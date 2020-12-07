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
public class ObavestenjeWriter {

    private static String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/obavestenje";

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
        Element obavestenje = document.createElementNS(TARGET_NAMESPACE, "Obavestenje");
        document.appendChild(obavestenje);

        obavestenje.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.ftn.uns.ac.rs/obavestenje ../xsd/obavestenje.xsd" );

        Element informacijeOObavestenju = document.createElementNS(TARGET_NAMESPACE, "informacije_o_obavestenju");
        obavestenje.appendChild(informacijeOObavestenju);

        Element organVlasti = document.createElementNS(TARGET_NAMESPACE, "organ_vlasti");
        informacijeOObavestenju.appendChild(organVlasti);

        Element adresa = document.createElementNS(TARGET_NAMESPACE, "Adresa");
        organVlasti.appendChild(adresa);

        Element mesto = document.createElementNS(TARGET_NAMESPACE, "Mesto");
        mesto.appendChild(document.createTextNode("Novi Sad"));
        adresa.appendChild(mesto);

        Element ulica = document.createElementNS(TARGET_NAMESPACE, "Ulica");
        ulica.appendChild(document.createTextNode("Bulevar Oslobodjenja"));
        adresa.appendChild(ulica);

        Element broj = document.createElementNS(TARGET_NAMESPACE, "Broj");
        broj.appendChild(document.createTextNode("1"));
        adresa.appendChild(broj);

        Element naziv = document.createElementNS(TARGET_NAMESPACE, "naziv");
        naziv.appendChild(document.createTextNode("Univerzitet"));
        organVlasti.appendChild(naziv);

        Element podnosilacZahteva = document.createElementNS(TARGET_NAMESPACE, "podnosilac_zahteva");
        informacijeOObavestenju.appendChild(podnosilacZahteva);

        Element adresaPZ = document.createElementNS(TARGET_NAMESPACE, "Adresa");
        podnosilacZahteva.appendChild(adresaPZ);

        Element mestoPZ = document.createElementNS(TARGET_NAMESPACE, "Mesto");
        mestoPZ.appendChild(document.createTextNode("Novi Sad"));
        adresaPZ.appendChild(mestoPZ);

        Element ulicaPZ = document.createElementNS(TARGET_NAMESPACE, "Ulica");
        ulicaPZ.appendChild(document.createTextNode("Brace Ribnikar"));
        adresaPZ.appendChild(ulicaPZ);

        Element brojPZ = document.createElementNS(TARGET_NAMESPACE, "Broj");
        brojPZ.appendChild(document.createTextNode("2"));
        adresaPZ.appendChild(brojPZ);

        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        ime.appendChild(document.createTextNode("Pera"));
        podnosilacZahteva.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "prezime");
        prezime.appendChild(document.createTextNode("Peric"));
        podnosilacZahteva.appendChild(prezime);

        Element datumObavestenja = document.createElementNS(TARGET_NAMESPACE, "datum_obavestenja");
        datumObavestenja.appendChild(document.createTextNode("2020-10-10"));
        organVlasti.appendChild(datumObavestenja);

        Element dostavljeno = document.createElementNS(TARGET_NAMESPACE, "dostavljeno");
        dostavljeno.appendChild(document.createTextNode("Dostavljeno:"));
        organVlasti.appendChild(dostavljeno);

        Element imenovanom = document.createElementNS(TARGET_NAMESPACE, "imenovanom");
        imenovanom.appendChild(document.createTextNode("1. Imenovanom:"));
        dostavljeno.appendChild(imenovanom);

        Element arhivi = document.createElementNS(TARGET_NAMESPACE, "arhivi");
        arhivi.appendChild(document.createTextNode("2. Arhivi:"));
        dostavljeno.appendChild(arhivi);

        Element tekstObavestenja = document.createElementNS(TARGET_NAMESPACE, "tekst_obavestenja");
        obavestenje.appendChild(tekstObavestenja);

        Element zahtevInformacija = document.createElementNS(TARGET_NAMESPACE, "zahtev_informacija");
        tekstObavestenja.appendChild(zahtevInformacija);

        Element datumZahtevaInformacije = document.createElementNS(TARGET_NAMESPACE, "datum_zahteva_informacije");
        datumZahtevaInformacije.appendChild(document.createTextNode("2020-10-10"));
        zahtevInformacija.appendChild(datumZahtevaInformacije);

        Element trazenaInformacija = document.createElementNS(TARGET_NAMESPACE, "trazena_informacija");
        trazenaInformacija.appendChild(document.createTextNode("Trazena informacija ide ovde..."));
        zahtevInformacija.appendChild(trazenaInformacija);

        Element uvidUInformacije = document.createElementNS(TARGET_NAMESPACE, "uvid_u_informacije");
        tekstObavestenja.appendChild(uvidUInformacije);

        Element datumUvida = document.createElementNS(TARGET_NAMESPACE, "datum_uvida");
        datumUvida.appendChild(document.createTextNode("2020-10-10"));
        uvidUInformacije.appendChild(datumUvida);

        Element vremeUvida = document.createElementNS(TARGET_NAMESPACE, "vreme_uvida");
        uvidUInformacije.appendChild(vremeUvida);

        Element tacnoVreme = document.createElementNS(TARGET_NAMESPACE, "tacno_vreme");
        tacnoVreme.appendChild(document.createTextNode("13:00:00"));
        vremeUvida.appendChild(tacnoVreme);

        Element intervalVremena = document.createElementNS(TARGET_NAMESPACE, "interval_vremena");
        vremeUvida.appendChild(intervalVremena);

        Element odV = document.createElementNS(TARGET_NAMESPACE, "od");
        odV.appendChild(document.createTextNode("13:00:00"));
        vremeUvida.appendChild(odV);

        Element doV = document.createElementNS(TARGET_NAMESPACE, "do");
        odV.appendChild(document.createTextNode("14:00:00"));
        vremeUvida.appendChild(doV);

        Element mestoUvida = document.createElementNS(TARGET_NAMESPACE, "mesto_uvida");
        uvidUInformacije.appendChild(mestoUvida);

        Element adresaMU = document.createElementNS(TARGET_NAMESPACE, "Adresa");
        mestoUvida.appendChild(adresaMU);

        Element mestoMU = document.createElementNS(TARGET_NAMESPACE, "Mesto");
        mestoMU.appendChild(document.createTextNode("Novi Sad"));
        adresaMU.appendChild(mestoMU);

        Element ulicaMU = document.createElementNS(TARGET_NAMESPACE, "Ulica");
        ulicaMU.appendChild(document.createTextNode("Sutjeska"));
        adresaMU.appendChild(ulicaMU);

        Element brojMU = document.createElementNS(TARGET_NAMESPACE, "Broj");
        brojMU.appendChild(document.createTextNode("3"));
        adresaMU.appendChild(brojMU);

        Element brojKancelarije = document.createElementNS(TARGET_NAMESPACE, "broj_kancelarije");
        brojKancelarije.appendChild(document.createTextNode("23"));
        mestoUvida.appendChild(brojKancelarije);

        Element troskovi = document.createElementNS(TARGET_NAMESPACE, "troskovi");
        troskovi.appendChild(document.createTextNode("2323"));
        obavestenje.appendChild(troskovi);
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

            filePath = "/static/data/schemas/obavestenje.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        ObavestenjeWriter handler = new ObavestenjeWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);


        try {
            handler.transform(new FileOutputStream("src/main/resources/static/data/xml/obavestenje_out.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}