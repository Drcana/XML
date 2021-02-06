package rs.ac.uns.ftn.portal_poverenika.service;

import org.apache.commons.io.FileUtils;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivOdlukeCollection;
import rs.ac.uns.ftn.portal_poverenika.exception.NotRejectedZahtevException;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivOdlukeRepository;
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
public class ZalbaProtivOdlukeService {

    private static final String XML_PATH = "src/main/resources/static/data/xml/zalba_protiv_odluke.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/zalba_protiv_odluke.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke";

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_odluke";

    private static final String REJECTED_STATUS = "REJECTED";

    /**
     * For generating XHTML / PDF files
     */
    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/zalba_protiv_odluke.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/zalba_protiv_odluke_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/zalba_protiv_odluke";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/zalba_protiv_odluke";

    @Autowired
    private JAXBService jaxbService;

    @Autowired
    private ZalbaProtivOdlukeRepository zalbaProtivOdlukeRepository;

    @Autowired
    private OrganVlastiClient organVlastiClient;

    @Autowired
    private EmailClient emailClient;

    public String parseXmlZalbaProtivOdlukeAsString() throws JAXBException {
        ZalbaProtivOdluke zalbaProtivOdluke = jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivOdluke, stringWriter);

        return stringWriter.toString();
    }

    public ZalbaProtivOdluke parseXmlZalbaProtivOdlukeAsObject() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public void writeXmlZalbaProtivOdluke(HttpServletResponse response) throws JAXBException {
        jaxbService.unmarshalXml(JAXB_INSTANCE, XML_PATH, response);
    }

    public DocumentDto create(ZalbaProtivOdluke zalbaProtivOdluke, Authentication authentication) throws Exception {

        if (zahtevIsRejected(zalbaProtivOdluke.getZahtevId())) {
            throw new NotRejectedZahtevException("Zahtev nije odbijen, ne moze se uneti zalba!");
        }

        String id = UUID.randomUUID().toString();

        zalbaProtivOdluke.setId(id);
        zalbaProtivOdluke.setUserId(getEmailOfLoggedUser(authentication));
        zalbaProtivOdluke.setDatum(getTodayDate());
        zalbaProtivOdluke.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        return save(zalbaProtivOdluke);
    }

    private DocumentDto save(ZalbaProtivOdluke zalbaProtivOdluke) throws Exception {
        zalbaProtivOdlukeRepository.create(zalbaProtivOdluke);

        return new DocumentDto(zalbaProtivOdluke.getId());
    }

    private boolean zahtevIsRejected(String zahtevId) {
        String status = organVlastiClient.getZahtevById(zahtevId).getStatus().toString();

        return REJECTED_STATUS.equalsIgnoreCase(status);
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public ZalbaProtivOdluke get(String documentId) {
        return zalbaProtivOdlukeRepository.get(documentId);
    }

    public ZalbaProtivOdlukeCollection getAll() {
        return zalbaProtivOdlukeRepository.getAll();
    }

    public ZalbaProtivOdlukeCollection getAllByUserId(Authentication authentication) {
        return zalbaProtivOdlukeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
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
        ZalbaProtivOdluke zalbaProtivOdluke = zalbaProtivOdlukeRepository.get(documentId);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(zalbaProtivOdluke, stringWriter);

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

    public void updateZalba(ZalbaProtivOdluke zalba) throws NotFoundException {

        try {
            delete(zalba.getId());
            save(zalba);
        } catch (Exception ex) {
            throw new NotFoundException("Zalba protiv odluke with id = [ " + zalba.getId() + " ] not found");
        }
    }

    public boolean delete(String documentId) throws Exception {
        return zalbaProtivOdlukeRepository.delete(documentId);
    }

    public WrapperResponse<Boolean> sendZalbaToUser(String documentId, Authentication authentication) {
        ZalbaProtivOdluke zalba = get(documentId);

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
}
