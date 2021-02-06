package rs.ac.uns.ftn.portal_poverenika.service;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_poverenika.dto.DocumentDto;
import rs.ac.uns.ftn.portal_poverenika.dto.ResenjeCollection;
import rs.ac.uns.ftn.portal_poverenika.model.resenje.Resenje;
import rs.ac.uns.ftn.portal_poverenika.model.user.User;
import rs.ac.uns.ftn.portal_poverenika.repository.ResenjeRepository;
import rs.ac.uns.ftn.portal_poverenika.util.FileTransformer;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
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
public class ResenjeService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/resenje";

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

    public void writeXmlResenje(HttpServletResponse response) throws IOException {
        domService.createDocument();
        domService.generateResenje();
        domService.transform(response.getOutputStream());
    }

    public String parseXmlResenje() {
        domService.buildResenjeDocument();

        return domService.extractTreeToString(domService.getDocument());
    }
    public DocumentDto create(Resenje resenje, Authentication authentication) throws Exception {
        String id = UUID.randomUUID().toString();

        resenje.setId(id);
        resenje.setUserId(getEmailOfLoggedUser(authentication));
        resenje.setDatum(getTodayDate());
        resenje.setAbout(String.format("%s/%s", TARGET_NAMESPACE, id));

        resenjeRepository.create(resenje);

        return new DocumentDto(id);
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
                byte[] bytes = convertFileToBytes(pdfPath);

                return Base64.getEncoder().encode(bytes);
            }
        } catch (Exception e) {
            return new byte[]{};
        }

        return new byte[]{};
    }
}
