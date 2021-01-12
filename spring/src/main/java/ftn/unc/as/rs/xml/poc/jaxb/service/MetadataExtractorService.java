package ftn.unc.as.rs.xml.poc.jaxb.service;

import ftn.unc.as.rs.xml.poc.jaxb.fuseki.FusekiAuthenticationUtilities;
import ftn.unc.as.rs.xml.poc.jaxb.model.obavestenje.Obavestenje;
import ftn.unc.as.rs.xml.poc.jaxb.model.zahtev.DokumentZahtev;
import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivCutanja.ZalbaProtivCutanja;
import ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke.ZalbaProtivOdluke;
import ftn.unc.as.rs.xml.poc.jaxb.util.MetadataExtractor;
import ftn.unc.as.rs.xml.poc.jaxb.util.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

@Service
public class MetadataExtractorService {

    @Autowired
    MetadataExtractor metadataExtractor;

    private static final String SPARQL_NAMED_GRAPH_URI = "/metadata";

    public void extractMetadata(String graph, OutputStream os, Object xmlObject) throws IOException, TransformerException, org.xml.sax.SAXException {

        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

        String xmlFilePath = getInputFilePath(xmlObject.getClass().getSimpleName());

        String rdfFilePath = "src/main/resources/static/data/rdf/output.rdf";
        getInputFilePath(xmlObject.getClass().getSimpleName());

        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(xmlObject, stringWriter);

//        metadataExtractor.extractMetadata(stringWriter.toString(), new FileOutputStream(new File(rdfFilePath)));

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(
                new FileInputStream(new File(xmlFilePath)),
                new FileOutputStream(new File(rdfFilePath)));


        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        model.read(rdfFilePath);

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

        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "-" + graph + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI + "-" + graph, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close();

        System.out.println("[INFO] End.");
    }

    private String getInputFilePath(String type) {
        String file = "";

        if (type.equals(Obavestenje.class.getSimpleName())) {
            file = "obavestenje.xml";
        } else if (type.equals(DokumentZahtev.class.getSimpleName())) {
            file = "zahtev.xml";
        } else if (type.equals(ZalbaProtivOdluke.class.getSimpleName())) {
            file = "zalbaProtivOdluke.xml";
        } else if (type.equals(ZalbaProtivCutanja.class.getSimpleName())) {
            file = "zalbaProtivCutanja.xml";
        }

        return String.format("src/main/resources/static/data/xml/%s", file);
    }
}
