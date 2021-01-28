package rs.ac.uns.ftn.portal_organa_vlasti.util;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.xalan.processor.TransformerFactoryImpl;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;


/**
 * Primer demonstrira koriscenje iText PDF programskog API-a za
 * renderovanje PDF-a na osnovu XML dokumenta. Alternativa Apache FOP-u.
 */
@Component
public class FileTransformer {

    private FopFactory fopFactory;

    private static DocumentBuilderFactory documentFactory;

    private static TransformerFactory transformerFactory;

    private static final String XSL_FO_FILE = "src/main/resources/static/data/xsl/zahtev_fo.xsl";

    private static final String FOP_FACTORY_PATH = "src/main/resources/fop.xconf";

    public FileTransformer() throws SAXException, IOException {

        // Initialize FOP factory object
        fopFactory = FopFactory.newInstance(new File(FOP_FACTORY_PATH));

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();


        /* Inicijalizacija DOM fabrike */
        documentFactory = DocumentBuilderFactory.newInstance();
        documentFactory.setNamespaceAware(true);
        documentFactory.setIgnoringComments(true);
        documentFactory.setIgnoringElementContentWhitespace(true);

        /* Inicijalizacija Transformer fabrike */
//		transformerFactory = TransformerFactory.newInstance();
    }

    private Document buildDocument(String filePath) {
        try {
            DocumentBuilder builder = documentFactory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(filePath)));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean generateHTML(String xmlObject, String xslPath, String outputFilePath) throws FileNotFoundException {

        try {

            // Initialize Transformer instance
            StreamSource transformSource = new StreamSource(new File(xslPath));
            Transformer transformer = transformerFactory.newTransformer(transformSource);
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Generate XHTML
            transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

            // Transform DOM to HTML
            DOMSource source = new DOMSource(buildDocument(xmlObject));
            StreamResult result = new StreamResult(new FileOutputStream(outputFilePath));
            transformer.transform(source, result);

            return true;
        } catch (TransformerFactoryConfigurationError | TransformerException e) {

            return false;
        }
    }

    private void generatePDF(String xmlDocument, String outputFilePath) throws Exception {

        // Point to the XSL-FO file
        File xslFile = new File(XSL_FO_FILE);

        // Create transformation source
        StreamSource transformSource = new StreamSource(xslFile);

        StringReader stringReader = new StringReader(xmlDocument);

        // Initialize the transformation subject
        StreamSource source = new StreamSource(stringReader);

        // Initialize user agent needed for the transformation
        FOUserAgent userAgent = fopFactory.newFOUserAgent();

        // Create the output stream to store the results
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        // Initialize the XSL-FO transformer object
        Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);

        // Construct FOP instance with desired output format
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

        // Resulting SAX events
        Result res = new SAXResult(fop.getDefaultHandler());

        // Start XSLT transformation and FOP processing
        xslFoTransformer.transform(source, res);

        // Generate PDF file
        File pdfFile = new File(outputFilePath);
        if (!pdfFile.getParentFile().exists()) {
            System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
            pdfFile.getParentFile().mkdir();
        }

        OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
        out.write(outStream.toByteArray());

        System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
        out.close();

        System.out.println("[INFO] End.");

    }

}
