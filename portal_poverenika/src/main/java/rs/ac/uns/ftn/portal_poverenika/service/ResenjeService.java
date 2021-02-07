package rs.ac.uns.ftn.portal_poverenika.service;

import org.apache.commons.io.FileUtils;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.NotificationEmailDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_poverenika.exception.ProcessSuspendedException;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.Status;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.ZalbaProtivOdluke;
import rs.ac.uns.ftn.portal_poverenika.repository.ResenjeRepository;
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
public class ResenjeService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/resenje";

    /**
     * For parsing xml file
     */
    private static final String XML_PATH = "src/main/resources/static/data/xml/resenje.xml";

    private static final String XSD_PATH = "src/main/resources/static/data/xsd/resenje.xsd";

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.portal_poverenika.model.resenje";

    /**
     * For generating XHTML / PDF files
     */
    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/resenje.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/resenje_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/resenje";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/resenje";

    @Autowired
    private DomService domService;

    @Autowired
    private ResenjeRepository resenjeRepository;

    @Autowired
    private EmailClient emailClient;

    @Autowired
    private OrganVlastiClient organVlastiClient;

    @Autowired
    private ZalbaProtivCutanjaService zalbaProtivCutanjaService;

    @Autowired
    private ZalbaProtivOdlukeService zalbaProtivOdlukeService;

    @Autowired
    private JAXBService jaxbService;

    public void writeXmlResenje(HttpServletResponse response) throws IOException {
        domService.createDocument();
        domService.generateResenje();
        domService.transform(response.getOutputStream());
    }

    public String parseXmlResenje() {
        domService.buildResenjeDocument();

        return domService.extractTreeToString(domService.getDocument());
    }

    public Resenje parseXmlResenjeAsObject() throws JAXBException {
        return jaxbService.parseXml(JAXB_INSTANCE, XSD_PATH, XML_PATH);
    }

    public DocumentDto create(boolean isZalbaProtivCutanja, Resenje resenje, Authentication authentication) throws Exception {

        assertThatProcessIsActive(resenje, isZalbaProtivCutanja);

        String id = UUID.randomUUID().toString();

        resenje.setId(id);
        resenje.setUserId(getEmailOfLoggedUser(authentication));
        resenje.setDatum(getTodayDate());
        resenje.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        resenjeRepository.create(resenje);

        return new DocumentDto(id);
    }

    private void assertThatProcessIsActive(Resenje resenje, boolean isZalbaProtivCutanja)
            throws NotFoundException, ProcessSuspendedException {

        if (isZalbaProtivCutanja){
            checkZalbaProtivCutanja(resenje.getZalbaId());
        }
        checkZalbaProtivOdluke(resenje.getZalbaId());
    }

    private void checkZalbaProtivCutanja(String id) throws NotFoundException, ProcessSuspendedException {
        ZalbaProtivCutanja zalbaProtivCutanja = zalbaProtivCutanjaService.get(id);
        if (Status.WITHDRAWN == zalbaProtivCutanja.getStatus()){
            throw new ProcessSuspendedException("Ne moze se kreirati zalba jer je zalba POVUCENA");
        }

        rs.ac.uns.ftn.portal_poverenika.soap.model.zahtev.Status status =
                organVlastiClient.getZahtevById(zalbaProtivCutanja.getZahtevId()).getStatus();

        if (rs.ac.uns.ftn.portal_poverenika.soap.model.zahtev.Status.APPROVED == status){
            zalbaProtivCutanja.setStatus(Status.RESOLVED);
            zalbaProtivCutanjaService.updateZalba(zalbaProtivCutanja);
            throw new ProcessSuspendedException("Ne moze se kreirati zalba jer je gradjanin dobio odgovor na zahtev");
        }
    }

    private void checkZalbaProtivOdluke(String id) throws NotFoundException, ProcessSuspendedException {
        ZalbaProtivOdluke zalbaProtivOdluke = zalbaProtivOdlukeService.get(id);
        if (rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.Status.WITHDRAWN
                == zalbaProtivOdluke.getStatus()){
            throw new ProcessSuspendedException("Ne moze se kreirati zalba jer je zalba POVUCENA");
        }

        rs.ac.uns.ftn.portal_poverenika.soap.model.zahtev.Status status =
                organVlastiClient.getZahtevById(zalbaProtivOdluke.getZahtevId()).getStatus();

        if (rs.ac.uns.ftn.portal_poverenika.soap.model.zahtev.Status.APPROVED == status){
            zalbaProtivOdluke.setStatus(rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.Status.RESOLVED);
            zalbaProtivOdlukeService.updateZalba(zalbaProtivOdluke);
            throw new ProcessSuspendedException("Ne moze se kreirati zalba jer je gradjanin dobio odgovor na zahtev");
        }
    }

    private String getEmailOfLoggedUser(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getEmail();
    }

    private XMLGregorianCalendar getTodayDate() throws DatatypeConfigurationException {
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
    }

    public Resenje get(String documentId) {
        return resenjeRepository.get(documentId);
    }

    public ResenjeCollection getAll() {
        return resenjeRepository.getAll();
    }

    public ResenjeCollection getAllByUserId(Authentication authentication) {
        return resenjeRepository.getAllByUserId(getEmailOfLoggedUser(authentication));
    }

    public byte[] generateHTML(String documentId) {
        FileTransformer transformer;

        String xmlObject = getResenjeAsString(documentId);

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

    private String getResenjeAsString(String documentId) {
        Resenje resenje = resenjeRepository.get(documentId);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(resenje, stringWriter);

        return stringWriter.toString();
    }

    private byte[] convertFileToBytes(String generatedFilePath) throws IOException {
        return FileUtils.readFileToByteArray(new File(generatedFilePath));
    }

    public byte[] generatePDF(String documentId) {

        FileTransformer transformer;

        String xmlObject = getResenjeAsString(documentId);

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

    public WrapperResponse<Boolean> sendResenjeToUser(NotificationEmailDto notificationEmailDto,
                                                      Authentication authentication) throws NotFoundException {

        String resenjeId = notificationEmailDto.getDocumentId();
        Resenje resenje = get(resenjeId);

        byte[] generatedPdfFile = null; //generatePDF(resenjeId);
        byte[] generatedHtmlFile = generateHTML(resenjeId);

        Notification notification = new Notification();

        notification.setSenderEmail(getEmailOfLoggedUser(authentication));
        notification.setPdfFile(generatedPdfFile != null ? generatedPdfFile : new byte[]{});
        notification.setHtmlFile(generatedHtmlFile != null ? generatedHtmlFile : new byte[]{});

        return notificationEmailDto.isZalbaProtivCutanja()
                ? sendResenjeForZalbaProtivCutanja(notification, resenje)
                : sendResenjeForZalbaProtivOdluke(notification, resenje);
    }

    private WrapperResponse<Boolean> sendResenjeForZalbaProtivCutanja(Notification notification,
                                                                      Resenje resenje) throws NotFoundException {

        ZalbaProtivCutanja zalba = zalbaProtivCutanjaService.get(resenje.getZalbaId());

        notification.setReceiverEmail(zalba.getUserId());

        notification.setDocumentId(zalba.getId());

        boolean sentEmail = emailClient.sendResenje(notification);

        if (sentEmail) {
            zalba.setStatus(Status.RESOLVED);
            zalbaProtivCutanjaService.updateZalba(zalba);
        }

        return new WrapperResponse<>(sentEmail);
    }

    private WrapperResponse<Boolean> sendResenjeForZalbaProtivOdluke(Notification notification, Resenje resenje)
            throws NotFoundException {

        ZalbaProtivOdluke zalba = zalbaProtivOdlukeService.get(resenje.getZalbaId());

        notification.setReceiverEmail(zalba.getUserId());

        notification.setDocumentId(zalba.getId());

        boolean sentEmail = emailClient.sendResenje(notification);

        if (sentEmail) {
            zalba.setStatus(rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_odluke.Status.RESOLVED);
            zalbaProtivOdlukeService.updateZalba(zalba);
        }

        return new WrapperResponse<>(sentEmail);
    }
}
