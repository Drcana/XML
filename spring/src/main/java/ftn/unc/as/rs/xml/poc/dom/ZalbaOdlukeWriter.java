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
import java.io.OutputStream;

public class ZalbaOdlukeWriter {

    private static String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_protiv_odluke";

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
        Element zalbaProtivOdluke = document.createElementNS(TARGET_NAMESPACE, "zalba_protiv_odluke");
        document.appendChild(zalbaProtivOdluke);

        zalbaProtivOdluke.setAttribute("xmlns", "zalba_protiv_odluke");
        zalbaProtivOdluke.setAttribute( "xmlns:xsi", XSI_NAMESPACE);
        zalbaProtivOdluke.setAttribute( "xsi:schemaLocation", "zalba_protiv_odluke ../schemas/zalbaOdluke.xsd");

        Element vrstaZalbe = document.createElementNS(TARGET_NAMESPACE, "vrsta_zalbe");
        vrstaZalbe.appendChild(document.createTextNode("ЖАЛБА ПРОТИВ ОДЛУКЕ ОРГАНА ВЛАСТИ КОЈОМ ЈЕ ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ"));
        zalbaProtivOdluke.appendChild(vrstaZalbe);

        Element informacijeOPrimaocuZalbe = document.createElementNS(TARGET_NAMESPACE, "informacije_o_primaocu_zalbe");
        zalbaProtivOdluke.appendChild(informacijeOPrimaocuZalbe);

        Element primalacZalbe = document.createElementNS(TARGET_NAMESPACE, "primalac_zalbe");
        primalacZalbe.appendChild(document.createTextNode("Поверенику за информације од јавног значаја и заштиту података о личности"));
        informacijeOPrimaocuZalbe.appendChild(primalacZalbe);

        Element adresa = document.createElementNS(TARGET_NAMESPACE, "adresa");
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

        Element naslov = document.createElementNS(TARGET_NAMESPACE, "naslov");
        naslov.appendChild(document.createTextNode("Ж А Л Б А"));
        zalbaProtivOdluke.appendChild(naslov);

        Element podaciOZaliocu = document.createElementNS(TARGET_NAMESPACE, "podaci_o_zaliocu");
        zalbaProtivOdluke.appendChild(podaciOZaliocu);

        Element naziv = document.createElementNS(TARGET_NAMESPACE, "naziv");
        podaciOZaliocu.appendChild(naziv);

        Element adresa2 = document.createElementNS(TARGET_NAMESPACE, "adresa");
        podaciOZaliocu.appendChild(adresa2);

        Element mesto2 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        adresa2.appendChild(mesto2);

        Element ulica2 = document.createElementNS(TARGET_NAMESPACE, "ulica");
        adresa2.appendChild(ulica2);

        Element broj2 = document.createElementNS(TARGET_NAMESPACE, "broj");
        adresa2.appendChild(broj2);

        podaciOZaliocu.appendChild(document.createTextNode("(Име, презиме, односно назив, адреса и седиште жалиоца)"));

        Element podaciOOrganu = document.createElementNS(TARGET_NAMESPACE, "podaci_o_organu");
        podaciOOrganu.appendChild(document.createTextNode("против решења-закључка"));
        zalbaProtivOdluke.appendChild(podaciOOrganu);

        Element nazivOrgana = document.createElementNS(TARGET_NAMESPACE, "naziv_organa");
        podaciOOrganu.appendChild(nazivOrgana);

        podaciOOrganu.appendChild(document.createTextNode("(назив органа који је донео одлуку)"));

        Element resenjeZahteva = document.createElementNS(TARGET_NAMESPACE, "resenje_zahteva");
        resenjeZahteva.appendChild(document.createTextNode("Број"));
        podaciOOrganu.appendChild(resenjeZahteva);

        Element brojResenja = document.createElementNS(TARGET_NAMESPACE, "broj_resenja");
        resenjeZahteva.appendChild(brojResenja);

        resenjeZahteva.appendChild(document.createTextNode(" од "));

        Element datum = document.createElementNS(TARGET_NAMESPACE, "datum");
        resenjeZahteva.appendChild(datum);

        resenjeZahteva.appendChild(document.createTextNode("године"));

        Element detaljiZalbe = document.createElementNS(TARGET_NAMESPACE, "detalji_zalbe");
        detaljiZalbe.appendChild(document.createTextNode("Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) , \t\n"));
        detaljiZalbe.appendChild(document.createTextNode("супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана"));
        zalbaProtivOdluke.appendChild(detaljiZalbe);

        Element datum2 = document.createElementNS(TARGET_NAMESPACE, "datum");
        detaljiZalbe.appendChild(datum2);

        detaljiZalbe.appendChild(document.createTextNode("године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама \t\n"));
        detaljiZalbe.appendChild(document.createTextNode("од јавног значаја. Oдлуку побијам у целости, односно у делу којим"));

        Element razlogZalbe = document.createElementNS(TARGET_NAMESPACE, "razlog_zalbe");
        detaljiZalbe.appendChild(razlogZalbe);

        detaljiZalbe.appendChild(document.createTextNode("јер није заснована на Закону о слободном приступу информацијама од јавног значаја.\t\n"));
        detaljiZalbe.appendChild(document.createTextNode("На основу изнетих разлога, предлажем да Повереник уважи моју жалбу, поништи одлука првостепеног органа и омогући\t\n"));
        detaljiZalbe.appendChild(document.createTextNode("ми приступ траженој/им информацији/ма.\t\n"));
        detaljiZalbe.appendChild(document.createTextNode("Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу\t\n"));
        detaljiZalbe.appendChild(document.createTextNode("информацијама од јавног значаја."));

        Element mestoIDatum = document.createElementNS(TARGET_NAMESPACE, "mesto_i_datum");
        mestoIDatum.appendChild(document.createTextNode("У"));
        zalbaProtivOdluke.appendChild(mestoIDatum);

        Element mesto3 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mestoIDatum.appendChild(mesto3);

        mestoIDatum.appendChild(document.createTextNode("дана"));

        Element datum3 = document.createElementNS(TARGET_NAMESPACE, "datum");
        mestoIDatum.appendChild(datum3);

        mestoIDatum.appendChild(document.createTextNode("године"));

        Element podaciOPodnosicuZalbe = document.createElementNS(TARGET_NAMESPACE, "podaci_o_podnosiocu_zalbe");
        zalbaProtivOdluke.appendChild(podaciOPodnosicuZalbe);

        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        podaciOPodnosicuZalbe.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "prezime");
        podaciOPodnosicuZalbe.appendChild(prezime);

        podaciOPodnosicuZalbe.appendChild(document.createTextNode("Подносилац жалбе / Име и презиме"));

        Element adresa3 = document.createElementNS(TARGET_NAMESPACE, "adresa");
        podaciOPodnosicuZalbe.appendChild(adresa3);

        Element mesto4 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        adresa3.appendChild(mesto4);

        Element ulica3 = document.createElementNS(TARGET_NAMESPACE, "ulica");
        adresa3.appendChild(ulica3);

        Element broj3 = document.createElementNS(TARGET_NAMESPACE, "broj");
        adresa3.appendChild(broj3);

        podaciOPodnosicuZalbe.appendChild(document.createTextNode("адреса"));

        Element drugiPodaciZaKontakt = document.createElementNS(TARGET_NAMESPACE, "drugi_podaci_za_kontakt");
        podaciOPodnosicuZalbe.appendChild(drugiPodaciZaKontakt);

        podaciOPodnosicuZalbe.appendChild(document.createTextNode("други подаци за контакт"));

        Element potpis = document.createElementNS(TARGET_NAMESPACE, "potpis");
        podaciOPodnosicuZalbe.appendChild(potpis);

        podaciOPodnosicuZalbe.appendChild(document.createTextNode("Потпис"));

        Element napomena = document.createElementNS(TARGET_NAMESPACE, "napomena");
        napomena.setAttribute("title", "Napomena:");
        zalbaProtivOdluke.appendChild(napomena);

        Element listaNapomena = document.createElementNS(TARGET_NAMESPACE, "lista_napomena");
        napomena.appendChild(listaNapomena);

        Element stavka1 = document.createElementNS(TARGET_NAMESPACE, "stavka");
        stavka1.setAttribute("id", "napomena1");
        stavka1.appendChild(document.createTextNode("У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив\r\n"));
        stavka1.appendChild(document.createTextNode("органа који је одлуку донео, као и број и датум одлуке.\r\n"));
        stavka1.appendChild(document.createTextNode("Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора\r\n"));
        stavka1.appendChild(document.createTextNode("посебно образложити.\r\n"));
        stavka1.appendChild(document.createTextNode("Ако жалбу изјављује на овом обрасцу, додатно образложење може посебно приложити.\r\n"));
        napomena.appendChild(stavka1);

        Element stavka2 = document.createElementNS(TARGET_NAMESPACE, "stavka");
        stavka2.setAttribute("id", "napomena2");
        stavka2.appendChild(document.createTextNode("Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој\r\n"));
        stavka2.appendChild(document.createTextNode("предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.\r\n"));
        napomena.appendChild(stavka2);
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

            filePath = "static/data/xml/schemas/zalbaOdluke.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        ZalbaOdlukeWriter handler = new ZalbaOdlukeWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);

		/*
		try {
			handler.transform(new FileOutputStream("static/data/xml/zalba_odluke_out_3.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
    }
}
