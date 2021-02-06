package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.apache.commons.io.FileUtils;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.obavestenje.Obavestenje;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ObavestenjeNotificationDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ObavestenjeRepository;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.ObavestenjeNotification;
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
public class ObavestenjeService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/obavestenje";

    private static final String XML_PATH = "src/main/resources/static/data/xml/obavestenje.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/obavestenje.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.obavestenje";


    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/obavestenje.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/obavestenje_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/obavestenje";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/obavestenje";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    @Autowired
    private ZahtevService zahtevService;

    @Autowired
    private EmailClient emailClient;

    public String parseXmlObavestenjeToString() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public Obavestenje parseXmlObavestenjeToObject() throws JAXBException {
        return jaxbService.parseXmlToObject(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlObavestenje(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(Obavestenje obavestenje, Authentication authentication)
            throws Exception {

        String id = UUID.randomUUID().toString();
        obavestenje.setId(id);
        obavestenje.setUserId(getEmailOfLoggedUser(authentication));
        obavestenje.setDatum(getTodayDate());
        obavestenje.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        obavestenjeRepository.create(obavestenje);

        return new DocumentDto(obavestenje.getId());
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public Obavestenje get(String documentId) {
        return obavestenjeRepository.get(documentId);
    }

    public ObavestenjeCollection getAll() {
        return obavestenjeRepository.getAll();
    }

    public ObavestenjeCollection getAllByUserId(Authentication authentication) {
        return obavestenjeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

    public byte[] generateHTML(String documentId) {
        FileTransformer transformer;

        String xmlObject = getObavestenjeAsString(documentId);

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

    private String getObavestenjeAsString(String documentId) {
        Obavestenje obavestenje = obavestenjeRepository.get(documentId);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(obavestenje, stringWriter);

        return stringWriter.toString();
    }

    private byte[] convertFileToBytes(String generatedFilePath) throws IOException {
        return FileUtils.readFileToByteArray(new File(generatedFilePath));
    }

    public byte[] generatePDF(String documentId) {

        FileTransformer transformer;

        String xmlObject = getObavestenjeAsString(documentId);

        String pdfPath = String.format("%s_%s.pdf", PDF_FILE_PATH, documentId);

        try {
            transformer = new FileTransformer();
            if (transformer.generatePDF(xmlObject, XSL_FO_FILE_PATH, pdfPath)) {
                return convertFileToBytes(pdfPath);
            }
        } catch (Exception e) {
            return new byte[]{};
        }

        return new byte[]{};
    }

    public WrapperResponse<Boolean> sendResponseToUser(ObavestenjeNotificationDto obavestenjeNotificationDto, Authentication authentication)
            throws NotFoundException {

        String obavestenjeId = obavestenjeNotificationDto.getObavestenjeId();

        byte[] generatedPdfFile = generatePDF(obavestenjeId);
        byte[] generatedHtmlFile = generateHTML(obavestenjeId);

        Obavestenje obavestenje = get(obavestenjeId);

        DokumentZahtev dokumentZahtev = zahtevService.get(obavestenje.getZahtevId());

        ObavestenjeNotification obavestenjeNotification = new ObavestenjeNotification();

        obavestenjeNotification.setSenderEmail(getEmailOfLoggedUser(authentication));
        obavestenjeNotification.setPdfFile(generatedPdfFile != null ? generatedPdfFile : new byte[]{});
        obavestenjeNotification.setHtmlFile(generatedHtmlFile != null ? generatedHtmlFile : new byte[]{});

        obavestenjeNotification.setReceiverEmail(dokumentZahtev.getUserId());
        obavestenjeNotification.setZahtevId(dokumentZahtev.getId());

        boolean sentEmail = emailClient.sendObavestenje(obavestenjeNotification);

        if (sentEmail) {
            dokumentZahtev.setStatus(Status.APPROVED);
            zahtevService.updateZahtev(dokumentZahtev, authentication);
        }

        return new WrapperResponse<>(sentEmail);
    }

    public WrapperResponse<Boolean> delete(String documentId) throws Exception {
        return new WrapperResponse<>(obavestenjeRepository.delete(documentId));
    }
}
