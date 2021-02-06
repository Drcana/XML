package rs.ac.uns.ftn.portal_poverenika.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ZalbaProtivCutanjaCollection;
import rs.ac.uns.ftn.portal_poverenika.exception.InvalidDateException;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.model.zalba_protiv_cutanja.ZalbaProtivCutanja;
import rs.ac.uns.ftn.portal_poverenika.repository.ZalbaProtivCutanjaRepository;
import rs.ac.uns.ftn.portal_poverenika.soap.client.OrganVlastiClient;
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
import java.util.Base64;
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

        zalbaProtivCutanjaRepository.create(zalbaProtivCutanja);

        return new DocumentDto(id);
    }

    private boolean hasDateValidForEnteringZalba(String zahtevId) {
        XMLGregorianCalendar xmlGregorianCalendar = organVlastiClient.getZahtevId(zahtevId).getDatum();
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
                byte[] bytes = convertFileToBytes(pdfPath);

                return Base64.getEncoder().encode(bytes);
            }
        } catch (Exception e) {
            return new byte[]{};
        }

        return new byte[]{};
    }
}
