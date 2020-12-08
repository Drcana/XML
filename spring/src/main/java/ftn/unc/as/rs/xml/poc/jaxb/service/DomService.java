package ftn.unc.as.rs.xml.poc.jaxb.service;

import org.springframework.stereotype.Component;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.OutputStream;

@Component
public class DomService {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_cutanje";

    private static final String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

    private static final String RESENJE_XML_PATH = "src\\main\\resources\\static\\data\\xml\\resenje.xml";

    private static DocumentBuilderFactory factory;

    private static TransformerFactory transformerFactory;

    private Document document;

    /*
     * Factory initialization static-block
     */

    static {
        factory = DocumentBuilderFactory.newInstance();

        transformerFactory = TransformerFactory.newInstance();
    }
    /**
     * Generates document object model for a given XML file.
     */
    public void createDocument() {

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();

            // Kreiranje novog dokumenta
            document = builder.newDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateResenje() {

        Element resenje = document.createElementNS(TARGET_NAMESPACE, "resenje");
        document.appendChild(resenje);

        resenje.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.ftn.uns.ac.rs/resenje ../xsd/resenje.xsd");

        Element informacijeOResenju = document.createElementNS(TARGET_NAMESPACE, "informacije_o_resenju");
        resenje.appendChild(informacijeOResenju);

        Element datumResenja = document.createElementNS(TARGET_NAMESPACE, "datum_resenja");
        datumResenja.appendChild(document.createTextNode("2020-11-11"));
        informacijeOResenju.appendChild(datumResenja);

        Element datumPodnosenjaZahteva = document.createElementNS(TARGET_NAMESPACE, "datum_podnosenja_zahteva");
        datumPodnosenjaZahteva.appendChild(document.createTextNode("2020-10-10"));
        informacijeOResenju.appendChild(datumPodnosenjaZahteva);

        Element trazilac = document.createElementNS(TARGET_NAMESPACE, "trazilac");
        informacijeOResenju.appendChild(trazilac);

        Element adresaT = document.createElementNS(TARGET_NAMESPACE, "adresa");
        trazilac.appendChild(adresaT);

        Element mestoT = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mestoT.appendChild(document.createTextNode("Novi Sad"));
        adresaT.appendChild(mestoT);

        Element ulicaT = document.createElementNS(TARGET_NAMESPACE, "ulica");
        ulicaT.appendChild(document.createTextNode("Strazilovska"));
        adresaT.appendChild(ulicaT);

        Element brojT = document.createElementNS(TARGET_NAMESPACE, "broj");
        brojT.appendChild(document.createTextNode("11"));
        adresaT.appendChild(brojT);

        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        ime.appendChild(document.createTextNode("Aleksa"));
        trazilac.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "prezime");
        prezime.appendChild(document.createTextNode("Aleksic"));
        trazilac.appendChild(prezime);

        Element organ = document.createElementNS(TARGET_NAMESPACE, "organ");
        informacijeOResenju.appendChild(organ);

        Element adresaO = document.createElementNS(TARGET_NAMESPACE, "adresa");
        organ.appendChild(adresaO);

        Element mestoO = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mestoO.appendChild(document.createTextNode("Novi Sad"));
        adresaO.appendChild(mestoO);

        Element ulicaO = document.createElementNS(TARGET_NAMESPACE, "ulica");
        ulicaO.appendChild(document.createTextNode("Sutjeska"));
        adresaO.appendChild(ulicaO);

        Element brojO = document.createElementNS(TARGET_NAMESPACE, "broj");
        brojO.appendChild(document.createTextNode("3"));
        adresaO.appendChild(brojO);

        Element naziv = document.createElementNS(TARGET_NAMESPACE, "naziv");
        naziv.appendChild(document.createTextNode("Osudni sud"));
        organ.appendChild(naziv);

        Element poverenik = document.createElementNS(TARGET_NAMESPACE, "poverenik");
        informacijeOResenju.appendChild(poverenik);

        Element imePoverenika = document.createElementNS(TARGET_NAMESPACE, "ime");
        imePoverenika.appendChild(document.createTextNode("Pera"));
        poverenik.appendChild(imePoverenika);

        Element prezimePoverenika = document.createElementNS(TARGET_NAMESPACE, "prezime");
        prezimePoverenika.appendChild(document.createTextNode("Peric"));
        poverenik.appendChild(prezimePoverenika);

        Element sadrzajResenja = document.createElementNS(TARGET_NAMESPACE, "sadraj_resenja");
        resenje.appendChild(sadrzajResenja);

        Element opisResenja = document.createElementNS(TARGET_NAMESPACE, "opis_resenja");
        opisResenja.appendChild(document.createTextNode("Повереник за информације од јавног значаја и заштиту података о личности, у поступку по алби\r\n"
                + "            коју је изјавио AA...."));
        sadrzajResenja.appendChild(opisResenja);

        Element teloResenja = document.createElementNS(TARGET_NAMESPACE, "telo_resenja");
        teloResenja.appendChild(document.createTextNode("Р Е Ш Е Њ Е"));
        sadrzajResenja.appendChild(teloResenja);

        Element paragrafR = document.createElementNS(TARGET_NAMESPACE, "paragraf");
        teloResenja.appendChild(paragrafR);

        Element obrazlozenje = document.createElementNS(TARGET_NAMESPACE, "obrazlozenje");
        obrazlozenje.appendChild(document.createTextNode("О б р а з л о ж е њ е"));
        sadrzajResenja.appendChild(obrazlozenje);

        Element paragrafO = document.createElementNS(TARGET_NAMESPACE, "paragraf");
        obrazlozenje.appendChild(paragrafO);

        Element uputstvo = document.createElementNS(TARGET_NAMESPACE, "uputstvo");
        uputstvo.appendChild(document.createTextNode("Упутство о правном средству:"));
        sadrzajResenja.appendChild(uputstvo);
    }

    public Document getDocument() {
        return document;
    }

    public void transform(OutputStream out) {
        try {

            // Kreiranje instance objekta zaduzenog za serijalizaciju DOM modela
            Transformer transformer = transformerFactory.newTransformer();

            // Indentacija serijalizovanog izlaza
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Nad "source" objektom (DOM stablo) vrši se transformacija
            DOMSource source = new DOMSource(document);

            // Rezultujući stream (argument metode)
            StreamResult result = new StreamResult(out);

            // Poziv metode koja vrši opisanu transformaciju
            transformer.transform(source, result);

        } catch (TransformerException | TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
    }

    public void buildResenjeDocument() {

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();

            /* Postavlja error handler. */
//            builder.setErrorHandler(this);

            document = builder.parse(new File(RESENJE_XML_PATH));

            /* Detektuju eventualne greske */
            if (document != null) {
                System.out.println("[INFO] File parsed with no errors.");
            } else
                System.out.println("[WARN] Document is null.");

        } catch (SAXParseException e) {

            System.out.println("[ERROR] Parsing error, line: " + e.getLineNumber() + ", uri: " + e.getSystemId());
            System.out.println("[ERROR] " + e.getMessage());
            System.out.print("[ERROR] Embedded exception: ");

            Exception embeddedException = e;
            if (e.getException() != null)
                embeddedException = e.getException();

            // Print stack trace...
            embeddedException.printStackTrace();

            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String output = "";

    public String extractTreeToString(Node node) {

        // Uslov za izlazak iz rekurzije
        if (node == null)
            return output;

        // Ispis uopštenih podataka o čvoru iz Node interfejsa
        // printNodeDetails(node, indent);

        // Ako je upitanju dokument čvor (korenski element)
        if (node instanceof Document) {

            output += "START_DOCUMENT\n";

            // Rekurzivni poziv za prikaz korenskog elementa
            Document doc = (Document) node;
            extractTreeToString(doc.getDocumentElement());
        } else if (node instanceof Element) {

            Element element = (Element) node;

            output += "START_ELEMENT: " + element.getTagName();

            // Preuzimanje liste atributa
            NamedNodeMap attributes = element.getAttributes();

            if (attributes.getLength() > 0) {

                output += ", ATTRIBUTES: ";

                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    extractTreeToString(attribute);
                    if (i < attributes.getLength() - 1)
                        output += ", ";
                }
            }

            output += "\n";

            // Prikaz svakog od child nodova, rekurzivnim pozivom
            NodeList children = element.getChildNodes();

            if (children != null) {
                for (int i = 0; i < children.getLength(); i++) {
                    Node aChild = children.item(i);
                    extractTreeToString(aChild);
                }
            }
        }
        // Za naredne čvorove nema rekurzivnog poziva jer ne mogu imati podelemente
        else if (node instanceof Attr) {

            Attr attr = (Attr) node;
            output += attr.getName() + "=" + attr.getValue() + "\n";

        } else if (node instanceof Text) {
            Text text = (Text) node;

            if (text.getTextContent().trim().length() > 0)
                output += "CHARACTERS: " + text.getTextContent().trim() + "\n";
        } else if (node instanceof CDATASection) {
            output += "CDATA: " + node.getNodeValue() + "\n";
        } else if (node instanceof Comment) {
            output += "COMMENT: " + node.getNodeValue() + "\n";
        } else if (node instanceof ProcessingInstruction) {
            output += "PROCESSING INSTRUCTION: " + "\n";

            ProcessingInstruction instruction = (ProcessingInstruction) node;
            output += "data: " + instruction.getData() + "\n";
            output += ", target: " + instruction.getTarget() + "\n";
        } else if (node instanceof Entity) {
            Entity entity = (Entity) node;
            output += "ENTITY: " + entity.getNotationName() + "\n";
        }

        return output;
    }
}
