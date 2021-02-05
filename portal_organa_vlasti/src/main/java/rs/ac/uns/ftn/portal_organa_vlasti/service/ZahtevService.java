package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.apache.commons.io.FileUtils;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ZahtevRepository;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectNotification;
import rs.ac.uns.ftn.portal_organa_vlasti.util.FileTransformer;
import rs.ac.uns.ftn.user.User;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.zahtev.Status;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class ZahtevService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev";

    /**
     * For POC with JAXB
     */
    private static final String XML_PATH = "src/main/resources/static/data/xml/zahtev.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zahtev.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev";

    /**
     * For generating XHTML / PDF files
     */
    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/zahtev.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/zahtev_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/zahtev";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/zahtev";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZahtevRepository zahtevRepository;

    @Autowired
    private EmailClient emailClient;

    public String parseXmlZahtevToString() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public DokumentZahtev parseXmlZahtevToObject() throws JAXBException {
        return jaxbService.parseXmlToObject(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZahtev(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(DokumentZahtev dokumentZahtev, Authentication authentication, boolean isFirstTimeCreated) throws Exception {

        if (isFirstTimeCreated) {
            String id = UUID.randomUUID().toString();
            dokumentZahtev.setId(id);
            dokumentZahtev.setUserId(getEmailOfLoggedUser(authentication));
            dokumentZahtev.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));
            dokumentZahtev.setDatum(getTodayDate());
            dokumentZahtev.setStatus(Status.PENDING);
        }

        zahtevRepository.create(dokumentZahtev);

        return new DocumentDto(dokumentZahtev.getId());
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public DokumentZahtev get(String documentId) {
        return zahtevRepository.get(documentId);
    }

    public ZahtevCollection getAll() {
        return zahtevRepository.getAll();
    }

    public WrapperResponse<Boolean> delete(String documentId) throws Exception {
        return new WrapperResponse<>(zahtevRepository.delete(documentId));
    }

    public ZahtevCollection getAllByUserId(Authentication authentication) {
        return zahtevRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

    public byte[] generateHTML(String documentId) {
        FileTransformer transformer;

        String xmlObject = getZahtevAsString(documentId);

        String htmlPath = String.format("%s_%s.html", XHTML_FILE_PATH, documentId);

        try {
            transformer = new FileTransformer();
            if (transformer.generateHTML(xmlObject, XSL_FILE_PATH, htmlPath)) {
                return convertFileToBytes(htmlPath);
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    private String getZahtevAsString(String documentId) {
        DokumentZahtev dokumentZahtev = zahtevRepository.get(documentId);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(dokumentZahtev, stringWriter);

        return stringWriter.toString();
    }

    private byte[] convertFileToBytes(String generatedFilePath) throws IOException {
        return FileUtils.readFileToByteArray(new File(generatedFilePath));
    }

    public WrapperResponse<Boolean> reject(String documentId, Authentication authentication) throws NotFoundException {
        DokumentZahtev dokumentZahtev = get(documentId);

        RejectNotification rejectNotification = new RejectNotification();

        rejectNotification.setReceiverEmail(dokumentZahtev.getUserId());
        rejectNotification.setSenderEmail(getEmailOfLoggedUser(authentication));
        rejectNotification.setZahtevId(documentId);

        boolean sentEmail = emailClient.rejectZahtev(rejectNotification);

        if (sentEmail) {
            dokumentZahtev.setStatus(Status.REJECTED);
            updateZahtev(dokumentZahtev, authentication);
        }

        return new WrapperResponse<>(sentEmail);
    }

    public void updateZahtev(DokumentZahtev dokumentZahtev, Authentication authentication) throws NotFoundException {
        try {
            delete(dokumentZahtev.getId());
            create(dokumentZahtev, authentication, false);
        } catch (Exception ex) {
            throw new NotFoundException("Zahtev with id = [ " + dokumentZahtev.getId() + " ] not found");
        }
    }

    public byte[] generatePDF(String documentId) {

        FileTransformer transformer;

        String xmlObject = getZahtevAsString(documentId);

        String pdfPath = String.format("%s_%s.pdf", PDF_FILE_PATH, documentId);

        try {
            transformer = new FileTransformer();
            if (transformer.generatePDF(xmlObject, XSL_FO_FILE_PATH, pdfPath)) {
                return convertFileToBytes(pdfPath);
            }
        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
