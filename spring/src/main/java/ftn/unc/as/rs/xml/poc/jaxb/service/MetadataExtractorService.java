package ftn.unc.as.rs.xml.poc.jaxb.service;

import ftn.unc.as.rs.xml.poc.jaxb.fuseki.FusekiAuthenticationUtilities;
import ftn.unc.as.rs.xml.poc.jaxb.util.MetadataExtractor;
import ftn.unc.as.rs.xml.poc.jaxb.util.SparqlUtil;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Service
public class MetadataExtractorService {

    @Autowired
    private MetadataExtractor metadataExtractor;

    private static final String SPARQL_NAMED_GRAPH_URI = "/metadata";

    public void extractMetadata(String graph, OutputStream os) throws IOException, TransformerException {

        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(((ByteArrayOutputStream) os).toByteArray());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        metadataExtractor.extractMetadata(inputStream, outputStream);
        String rdf = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);

        Model model = ModelFactory.createDefaultModel();
        model.read(new ByteArrayInputStream(rdf.getBytes(StandardCharsets.UTF_8)), SparqlUtil.NTRIPLES);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "-" + graph + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI + "-" + graph, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();
    }
}
