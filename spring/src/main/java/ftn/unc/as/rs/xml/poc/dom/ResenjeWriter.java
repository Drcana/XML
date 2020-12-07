package ftn.unc.as.rs.xml.poc.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Primer demonstrira metode API-ja za potrebe programskog kreiranja DOM stabla.
 * Pored programskog kreiranja DOM stabla, primer demonstrira i serijalizaciju
 * DOM stabla na proizvoljan stream (npr. FileOutputStream, System.out, itd.).
 */
public class ResenjeWriter {

    private static String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/resenje";

    private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

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

    /**
     * Generates sample document object model
     * programmatically using DOM API methods.
     */
    public void generateDOM() {

        // Kreiranje i postavljanje korenskog elementa
        Element resenje = document.createElementNS(TARGET_NAMESPACE, "resenje");
        document.appendChild(resenje);

        resenje.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.ftn.uns.ac.rs/resenje ../xsd/resenje.xsd" );

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

    /**
     * Serializes DOM tree to an arbitrary OutputStream.
     */
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

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "/static/data/schemas/resenje.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        ResenjeWriter handler = new ResenjeWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);


        try {
            handler.transform(new FileOutputStream("src/main/resources/static/data/xml/resenje_out.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}