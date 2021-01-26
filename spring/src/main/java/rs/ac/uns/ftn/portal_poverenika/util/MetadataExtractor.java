package rs.ac.uns.ftn.portal_poverenika.util;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.springframework.stereotype.Component;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Primer demonstrira ekstrakciju RDFa metapodataka iz
 * XML dokumenta primenom GRDDL (Gleaning Resource Descriptions
 * from Dialects of Languages) transformacije.
 */
@Component
public class MetadataExtractor {

    private TransformerFactory transformerFactory;

    private static final String XSLT_FILE = "src/main/resources/static/data/xsl/grddl.xsl";

    public MetadataExtractor() {

        // Setup the XSLT transformer factory
        transformerFactory = new TransformerFactoryImpl();
    }

    /**
     * Generates RDF/XML based on RDFa metadata from an XML containing
     * input stream by applying GRDDL XSL transformation.
     *
     * @param in  XML containing input stream
     * @param out RDF/XML output stream
     */
    public void extractMetadata(InputStream in, OutputStream out) throws TransformerException {
        // Create transformation source
        StreamSource transformSource = new StreamSource(new File(XSLT_FILE));

        // Initialize GRDDL transformer object
        Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);

        // Set the indentation properties
        grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
        grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        // Initialize transformation subject
        StreamSource source = new StreamSource(in);

        // Initialize result stream
        StreamResult result = new StreamResult(out);

        // Trigger the transformation
        grddlTransformer.transform(source, result);
    }
}
