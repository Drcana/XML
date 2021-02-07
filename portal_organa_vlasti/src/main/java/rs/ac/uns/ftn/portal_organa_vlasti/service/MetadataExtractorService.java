package rs.ac.uns.ftn.portal_organa_vlasti.service;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.portal_organa_vlasti.fuseki.FusekiAuthenticationUtilities;
import rs.ac.uns.ftn.portal_organa_vlasti.util.MetadataExtractor;
import rs.ac.uns.ftn.portal_organa_vlasti.util.SparqlUtil;

import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    public List<String> findAll(List<String> params, String searchQuery, Class<?> documentClassType) throws IOException {

        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

        String queryPath = conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI + "-" + documentClassType.getSimpleName();
        //First param is database collection
        params.add(0, queryPath);

        // Querying the named graph with a referenced SPARQL query
        System.out.println("[INFO] Loading SPARQL query from file \"" + searchQuery + "\"");
        String sparqlQuery = String.format(searchQuery, params.toArray());

        System.out.println(sparqlQuery);

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the SPARQL endpoint, iterate over the result set...
        System.out.println("[INFO] Showing the results for SPARQL query using the result handler.\n");
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;

        List<String> listOfIds = new ArrayList<>();

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                int lastIndex = varValue.toString().lastIndexOf("/");
                String id = varValue.toString().substring(lastIndex + 1);
                listOfIds.add(id);
            }
        }

        // Issuing the same query once again...

        // Create a QueryExecution that will access a SPARQL service over HTTP
        query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the collection, dump output response as XML
        System.out.println("[INFO] Showing the results for SPARQL query in native SPARQL XML format.\n");
        results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close();

        System.out.println("[INFO] End.");

        return listOfIds;
    }

    public ResultSet exportAsJson(String namespace, String documentId, Class<?> documentClassType) throws IOException {

        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties();

        String graphURI = conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI + "-" + documentClassType.getSimpleName();

        String sparqlQuery = SparqlUtil.selectData(graphURI, String.format("<%s/%s> ?p ?o", namespace, documentId));

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);

        // Query the collection, dump output response as XML
         return query.execSelect();
    }
}
