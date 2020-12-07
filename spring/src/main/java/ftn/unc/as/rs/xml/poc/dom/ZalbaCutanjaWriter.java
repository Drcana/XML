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
public class ZalbaCutanjaWriter {

    private static String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_cutanje";

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
        Element zalbaCutanja = document.createElementNS(TARGET_NAMESPACE, "podaci_o_zalbi_cutanja");
        document.appendChild(zalbaCutanja);

        zalbaCutanja.setAttribute("xmlns", "zalba_cutanje");
        zalbaCutanja.setAttribute("xsi", XSI_NAMESPACE);
        zalbaCutanja.setAttribute("schemaLocation", "http://www.ftn.uns.ac.rs/zahtev ../xsd/zahtev.xsd");

        Element vrstaZalbe = document.createElementNS(TARGET_NAMESPACE, "vrsta_zalbe");
        vrstaZalbe.appendChild(document.createTextNode("ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ ТРАЖИОЦА У ЗАКОНСКОМ РОКУ (ЋУТАЊЕ УПРАВЕ)\n"));
        zalbaCutanja.appendChild(vrstaZalbe);

        Element informacijeOPrimaocuZalbe = document.createElementNS(TARGET_NAMESPACE, "informacije_o_primaocu_zalbe");
        zalbaCutanja.appendChild(informacijeOPrimaocuZalbe);

        Element primalacZalbe = document.createElementNS(TARGET_NAMESPACE, "primalac_zalbe");
        primalacZalbe.appendChild(document.createTextNode("Поверенику за информације од јавног значаја и заштиту података о личности"));
        informacijeOPrimaocuZalbe.appendChild(primalacZalbe);

        Element adresa = document.createElementNS(TARGET_NAMESPACE, "adresa");
        adresa.appendChild(document.createTextNode("Адреса за пошту:\n"));
        informacijeOPrimaocuZalbe.appendChild(adresa);

        Element mesto = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mesto.appendChild(document.createTextNode("Београд"));
        adresa.appendChild(mesto);

        adresa.appendChild(document.createTextNode(","));

        Element ulica = document.createElementNS(TARGET_NAMESPACE, "ulica");
        ulica.appendChild(document.createTextNode("Булевар краља Александрa"));
        adresa.appendChild(ulica);

        adresa.appendChild(document.createTextNode("бр."));

        Element broj = document.createElementNS(TARGET_NAMESPACE, "broj");
        broj.appendChild(document.createTextNode("15"));
        adresa.appendChild(broj);

        Element informacijeOZalbi = document.createElementNS(TARGET_NAMESPACE, "informacije_o_zalbi");
        zalbaCutanja.appendChild(informacijeOZalbi);

        Element zakon = document.createElementNS(TARGET_NAMESPACE, "zakon");
        zakon.appendChild(document.createTextNode("У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:\n"));
        informacijeOZalbi.appendChild(zakon);

        Element naslov = document.createElementNS(TARGET_NAMESPACE, "naslov");
        naslov.appendChild(document.createTextNode("Ж А Л Б У"));
        informacijeOZalbi.appendChild(naslov);

        Element nazivOrgana = document.createElementNS(TARGET_NAMESPACE, "naziv_organa");
        informacijeOZalbi.appendChild(nazivOrgana);

        informacijeOZalbi.appendChild(document.createTextNode("( навести назив органа)\n"));

        Element razlogZalbe = document.createElementNS(TARGET_NAMESPACE, "razlog_zalbe");
        razlogZalbe.appendChild(document.createTextNode("\nзбог тога што орган власти: \n"));
        razlogZalbe.appendChild(document.createTextNode("није поступио / није поступио у целости / у законском року\n"));
        razlogZalbe.appendChild(document.createTextNode("(подвући због чега се изјављује жалба)\n"));
        zalbaCutanja.appendChild(razlogZalbe);

        Element detaljiZalbe = document.createElementNS(TARGET_NAMESPACE, "detalji_zalbe");
        detaljiZalbe.appendChild(document.createTextNode("по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том органу дана"));
        zalbaCutanja.appendChild(detaljiZalbe);

        Element datum = document.createElementNS(TARGET_NAMESPACE, "datum");
        detaljiZalbe.appendChild(datum);

        detaljiZalbe.appendChild(document.createTextNode("године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја \n"));
        detaljiZalbe.appendChild(document.createTextNode("омогући увид- копија документа који садржи информације о /у вези са :\n"));

        Element podaciOZalbi = document.createElementNS(TARGET_NAMESPACE, "podaci_o_zalbi");
        detaljiZalbe.appendChild(podaciOZalbi);

        detaljiZalbe.appendChild(document.createTextNode("\n(навести податке о захтеву и информацији/ама)\n"));

        Element predlogResenja = document.createElementNS(TARGET_NAMESPACE, "predlog_resenja");
        predlogResenja.appendChild(document.createTextNode("На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им информацији/ма. \n"));
        predlogResenja.appendChild(document.createTextNode("доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.\n"));
        zalbaCutanja.appendChild(predlogResenja);

        Element napomena = document.createElementNS(TARGET_NAMESPACE, "napomena");
        zalbaCutanja.appendChild(document.createTextNode("Напомена: Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.\n"));
        zalbaCutanja.appendChild(napomena);

        Element podnosilacZalbe = document.createElementNS(TARGET_NAMESPACE, "podnosilac_zalbe");
        zalbaCutanja.appendChild(podnosilacZalbe);

        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        podnosilacZalbe.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "prezime");
        podnosilacZalbe.appendChild(prezime);

        podnosilacZalbe.appendChild(document.createTextNode("\n\tПодносилац жалбе / Име и презиме\n\t"));

        Element adresa2 = document.createElementNS(TARGET_NAMESPACE, "adresa");
        podnosilacZalbe.appendChild(adresa2);

        Element mesto2 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        adresa2.appendChild(mesto2);

        Element ulica2 = document.createElementNS(TARGET_NAMESPACE, "ulica");
        adresa2.appendChild(ulica2);

        Element broj2 = document.createElementNS(TARGET_NAMESPACE, "broj");
        adresa2.appendChild(broj2);

        podnosilacZalbe.appendChild(document.createTextNode("\n\tадреса\n\t"));

        Element podaciZaKontakt = document.createElementNS(TARGET_NAMESPACE, "podaci_za_kontakt");
        podnosilacZalbe.appendChild(podaciZaKontakt);

        podnosilacZalbe.appendChild(document.createTextNode("\n\tдруги подаци за контакт\n\t"));

        Element potpis = document.createElementNS(TARGET_NAMESPACE, "potpis");
        podnosilacZalbe.appendChild(potpis);

        podnosilacZalbe.appendChild(document.createTextNode("\n\tПотпис\n\t"));

        Element mestoIDatum = document.createElementNS(TARGET_NAMESPACE, "mesto_i_datum");
        mestoIDatum.appendChild(document.createTextNode("\n\tУ"));
        zalbaCutanja.appendChild(mestoIDatum);

        Element mesto3 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mestoIDatum.appendChild(mesto3);

        mestoIDatum.appendChild(document.createTextNode("\tдана"));

        Element datum2 = document.createElementNS(TARGET_NAMESPACE, "datum");
        mestoIDatum.appendChild(datum2);

        mestoIDatum.appendChild(document.createTextNode("године\n"));
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

            filePath = "/static/data/schemas/zalbaCutanja.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        ZalbaCutanjaWriter handler = new ZalbaCutanjaWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);


        try {
            handler.transform(new FileOutputStream("src/main/resources/static/data/xml/zalba_cutanja_out.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}