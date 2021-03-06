package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.apache.commons.io.FileUtils;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.exist.http.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.DocumentDto;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.SearchZahtevMap;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.WrapperResponse;
import rs.ac.uns.ftn.portal_organa_vlasti.dto.ZahtevCollection;
import rs.ac.uns.ftn.portal_organa_vlasti.repository.ZahtevRepository;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.client.EmailClient;
import rs.ac.uns.ftn.portal_organa_vlasti.soap.model.RejectNotification;
import rs.ac.uns.ftn.portal_organa_vlasti.util.FileTransformer;
import rs.ac.uns.ftn.portal_organa_vlasti.util.MetadataExtractor;
import rs.ac.uns.ftn.user.User;
import rs.ac.uns.ftn.zahtev.DokumentZahtev;
import rs.ac.uns.ftn.zahtev.Status;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
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

    private static final String JAXB_INSTANCE = "rs.ac.uns.ftn.zahtev";

    /**
     * For generating XHTML / PDF files
     */
    private static final String XSL_FILE_PATH = "src/main/resources/static/data/xsl/zahtev.xsl";

    private static final String XSL_FO_FILE_PATH = "src/main/resources/static/data/xsl/zahtev_fo.xsl";

    private static final String XHTML_FILE_PATH = "src/main/resources/static/data/html/zahtev";

    private static final String PDF_FILE_PATH = "src/main/resources/static/data/pdf/zahtev";

    private static final String XML_FILE_PATH = "src/main/resources/static/data/xml/zahtev";

    private static final String RDF_FILE_PATH = "src/main/resources/static/data/rdf/zahtev";

    private static final String JSON_FILE_PATH = "src/main/resources/static/data/json/zahtev";

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

    public DocumentDto create(DokumentZahtev dokumentZahtev, Authentication authentication) throws Exception {

        String id = UUID.randomUUID().toString();
        dokumentZahtev.setId(id);
        dokumentZahtev.setUserId(getEmailOfLoggedUser(authentication));
        dokumentZahtev.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));
        dokumentZahtev.setDatum(getTodayDate());
        dokumentZahtev.setStatus(Status.PENDING);

        return save(dokumentZahtev);
    }

    private DocumentDto save(DokumentZahtev dokumentZahtev) throws Exception {
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
            return new byte[]{};
        }

        return new byte[]{};
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
            save(dokumentZahtev);
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
            return new byte[]{};
        }

        return new byte[]{};
    }

    public ZahtevCollection searchAll(String term) {
        return zahtevRepository.searchAll(term);
    }

    public ZahtevCollection advancedSearch(SearchZahtevMap searchMap) throws IOException {
        return zahtevRepository.advancedSearch(searchMap);
    }

    public byte[] exportAsRdf(String id) throws IOException {

        String rdfFilePath = String.format("%s_%s.rdf", RDF_FILE_PATH, id);
        String xmlFilePath = String.format("%s_%s.xml", XML_FILE_PATH, id);

        String zahtev = getZahtevAsString(id);

        MetadataExtractor metadataExtractorService = new MetadataExtractor();

        try (FileOutputStream fileOutputStream = new FileOutputStream(rdfFilePath); FileWriter fileWriter = new FileWriter(xmlFilePath)) {
            fileWriter.write(zahtev);
            fileWriter.close();

            metadataExtractorService.extractMetadata(new FileInputStream(xmlFilePath), fileOutputStream);
        } catch (Exception e) {
            return new byte[]{};
        }

        return convertFileToBytes(rdfFilePath);
    }

    public byte[] exportAsJson(String id) throws IOException {

        ResultSet results = zahtevRepository.exportAsJson(id);

        String jsonfilePath = String.format("%s_%s.json", JSON_FILE_PATH, id);
        OutputStream out = new BufferedOutputStream(new FileOutputStream(jsonfilePath));
        ResultSetFormatter.outputAsJSON(out, results);

        return convertFileToBytes(jsonfilePath);
    }
}
