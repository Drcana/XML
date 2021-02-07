package rs.ac.uns.ftn.portal_poverenika.service;

import org.apache.commons.io.FileUtils;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivCutanjaCollection;
import rs.ac.uns.ftn.portal_poverenika.exception.InvalidDateException;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.Status;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivCutanjaRepository;
import rs.ac.uns.ftn.portal_poverenika.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_poverenika.soap.client.OrganVlastiClient;
import rs.ac.uns.ftn.portal_poverenika.soap.model.email.Notification;
import rs.ac.uns.ftn.portal_poverenika.util.FileTransformer;

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
public class ZalbaProtivCutanjaService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_cutanja";

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalba_protiv_cutanja.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zalba_protiv_cutanja.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja";

    private static final Integer TEN_DAYS_IN_MILLIS = 10 * 1000 * 60 * 60 * 24;

    /**
     * For generating XHTML / PDF files
     */
    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/zalba_protiv_cutanja.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/zalba_protiv_cutanja_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/zalba_protiv_cutanja";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/zalba_protiv_cutanja";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZalbaProtivCutanjaRepository zalbaProtivCutanjaRepository;

    @Autowired
    private OrganVlastiClient organVlastiClient;

    @Autowired
    private EmailClient emailClient;

    public String parseXmlZalbaProtivCutanjaAsString() throws JAXBException {
        ZalbaProtivCutanja zalbaProtivCutanja = jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivCutanja, stringWriter);

        return stringWriter.toString();
    }

    public ZalbaProtivCutanja parseXmlZalbaProtivCutanjaAsObject() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivCutanja(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(ZalbaProtivCutanja zalbaProtivCutanja, Authentication authentication) throws Exception {

        if (!hasDateValidForEnteringZalba(zalbaProtivCutanja.getZahtevId())) {
            throw new InvalidDateException("Nije proslo dovoljno dana da bi se mogla uneti zalba!");
        }

        String id = UUID.randomUUID().toString();

        zalbaProtivCutanja.setId(id);
        zalbaProtivCutanja.setUserId(getEmailOfLoggedUser(authentication));
        zalbaProtivCutanja.setDatum(getTodayDate());
        zalbaProtivCutanja.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        return save(zalbaProtivCutanja);
    }

    private DocumentDto save(ZalbaProtivCutanja zalbaProtivCutanja) throws Exception {
        zalbaProtivCutanjaRepository.create(zalbaProtivCutanja);

        return new DocumentDto(zalbaProtivCutanja.getId());
    }

    private boolean hasDateValidForEnteringZalba(String zahtevId) {
        XMLGregorianCalendar xmlGregorianCalendar = organVlastiClient.getZahtevById(zahtevId).getDatum();
        Date dateOfZahtev = xmlGregorianCalendar.toGregorianCalendar().getTime();
        Date minDateForZalba = new Date(dateOfZahtev.getTime() + TEN_DAYS_IN_MILLIS);

        return new Date().after(minDateForZalba);
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public ZalbaProtivCutanja get(String documentId) {
        return zalbaProtivCutanjaRepository.get(documentId);
    }

    public ZalbaProtivCutanjaCollection getAll() {
        return zalbaProtivCutanjaRepository.getAll();
    }

    public ZalbaProtivCutanjaCollection getAllByUserId(Authentication authentication) {
        return zalbaProtivCutanjaRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

    public byte[] generateHTML(String documentId) {
        FileTransformer transformer;

        String xmlObject = getZalbaAsString(documentId);

        String htmlPath = String.format("%s_%s.html", XHTML_FILE_PATH, documentId);

        try {
            transformer = new FileTransformer();
            if (transformer.generateHTML(xmlObject, XSL_FILE_PATH, htmlPath)) {
                return convertFileToBytes(htmlPath);
            }
        } catch (Exception e) {
            return new byte[]{};
        }

        return new byte[]{};
    }

    private String getZalbaAsString(String documentId) {
        ZalbaProtivCutanja zalbaProtivCutanja = zalbaProtivCutanjaRepository.get(documentId);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivCutanja, stringWriter);

        return stringWriter.toString();
    }

    private byte[] convertFileToBytes(String generatedFilePath) throws IOException {
        return FileUtils.readFileToByteArray(new File(generatedFilePath));
    }

    public byte[] generatePDF(String documentId) {

        FileTransformer transformer;

        String xmlObject = getZalbaAsString(documentId);

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

    public Boolean updateZalba(ZalbaProtivCutanja zalba) throws NotFoundException {

        try {
            delete(zalba.getId());
            save(zalba);

            return true;
        } catch (Exception ex) {
            throw new NotFoundException("Zalba protiv cutanja with id = [ " + zalba.getId() + " ] not found");
        }
    }

    public boolean delete(String documentId) throws Exception {
        return zalbaProtivCutanjaRepository.delete(documentId);
    }

    public WrapperResponse<Boolean> sendZalbaToUser(String documentId, Authentication authentication) {
        ZalbaProtivCutanja zalba = get(documentId);

        byte[] generatedPdfFile = generatePDF(documentId);
        byte[] generatedHtmlFile = generateHTML(documentId);

        Notification notification = new Notification();

        notification.setSenderEmail(getEmailOfLoggedUser(authentication));
        notification.setReceiverEmail(zalba.getUserId());

        notification.setPdfFile(generatedPdfFile != null ? generatedPdfFile : new byte[]{});
        notification.setHtmlFile(generatedHtmlFile != null ? generatedHtmlFile : new byte[]{});

        notification.setDocumentId(zalba.getZahtevId());

        return new WrapperResponse<>(emailClient.sendZalba(notification));
    }

    public WrapperResponse<Boolean> withdraw(String id) throws NotFoundException {
        ZalbaProtivCutanja zalbaProtivCutanja = get(id);
        zalbaProtivCutanja.setStatus(Status.WITHDRAWN);

        return new WrapperResponse<>(updateZalba(zalbaProtivCutanja));
    }
}
