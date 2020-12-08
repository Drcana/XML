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
public class dokumentZahtevWriter {

    private static String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zahtev_za_pristup_informacijama";

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
		Element dokumentZahtev = document.createElementNS(TARGET_NAMESPACE, "dokument_zahtev");
		document.appendChild(dokumentZahtev);
        
        dokumentZahtev.setAttribute("xmlns", "zahtev_za_pristup_informacijama");
        dokumentZahtev.setAttribute("xsi", XSI_NAMESPACE);
        dokumentZahtev.setAttribute("schemaLocation", "http://www.ftn.uns.ac.rs/zahtev ../xsd/zahtev.xsd");		
		
		Element nazivOrgana = document.createElementNS(TARGET_NAMESPACE, "naziv_organa");
		dokumentZahtev.appendChild(nazivOrgana);
		
		Element adresa = document.createElementNS(TARGET_NAMESPACE, "adresa");
        dokumentZahtev.appendChild(adresa);

        Element ulica1 = document.createElementNS(TARGET_NAMESPACE, "ulica");
        adresa.appendChild(ulica1);

        Element broj1 = document.createElementNS(TARGET_NAMESPACE, "broj");
        adresa.appendChild(broj1);

        Element mesto1 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        adresa.append(mesto1);

        Element naslovDokumenta = document.createElementNS(TARGET_NAMESPACE, "naslov_dokumenta");
        naslov_dokumenta.appendChild(document.createTextNode("З А Х Т Е В за приступ информацији од јавног значаја"));
        dokumentZahtev.appendChild(naslovDokumenta);

        Element zahtevNaOsnovu = document.createElementNS(TARGET_NAMESPACE, "zahtev_na_osnovu");
        dokumentZahtev.appendChild(zahtevNaOsnovu);

        Element zakon = document.createElementNS(TARGET_NAMESPACE, "zakon");
        zakon.appendChild(document.createTextNode("На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:"));
		dokumentZahtev.appendChild(zakon);

        Element napomena1 = document.createElementNS(TARGET_NAMESPACE, "napomena");
        napomena1.setAttribute("id", "1");
        dokumentZahtev.appendChild(napomena1);

        Element listaZahteva = document.createElementNS(TARGET_NAMESPACE, "lista_zahteva");
        dokumentZahtev.appendChild(listaZahteva);

        Element posedovanjeInformacije = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        posedovanjeInformacije.setAttribute("tip_zahteva", "posedovanje_informacije");
        posedovanjeInformacije.setAttribute("check", "");
        posedovanjeInformacije.appendChild(document.createTextNode("обавештење да ли поседује тражену информацију;"));
        dokumentZahtev.appendChild(posedovanjeInformacije);

        Element uvidUDokument = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        uvidUDokument.setAttribute("tip_zahteva", "uvid_u_dokument");
        uvidUDokument.setAttribute("check", "");
        uvidUDokument.appendChild(document.createTextNode("увид у документ који садржи тражену информацију;⁫"));
        dokumentZahtev.append(uvidUDokument);

        Element kopijaDokumenta = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        kopijaDokumenta.setAttribute("tip_zahteva", "kopija_dokumenta");
        kopijaDokumenta.setAttribute("check", "");
        kopijaDokumenta.appendChild(document.createTextNode("копију документа који садржи тражену информацију;"));
        dokumentZahtev.append(kopijaDokumenta);

        Element dostavljanjeKopijeDokumenta = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        dostavljanjeKopijeDokumenta.setAttribute("tip_zahteva", "dostavljanje_kopije_dokumenta");
        dostavljanje_kopije_dokumenta.setAttribute("check", "");
        dostavljanje_kopije_dokumenta.appendChild(document.createTextNode("достављање копије документа који садржи тражену информацију"));
        dokumentZahtev.appendChild(dostavljanjeKopijeDokumenta);

        Element napomena2 = document.createElementNS(TARGET_NAMESPACE, "napomena");
        napomena2.setAttribute("id", "2");
        dostavljanjeKopijeDokumenta.appendChild(napomena2);

        Element nacinDostave = document.createElementNS(TARGET_NAMESPACE, "lista_nacina");
        dostavljanjeKopijeDokumenta.appendChild(nacinDostave);

        Element postom = document.createElementNS(TARGET_NAMESPACE, "nacin");
        postom.setAttribute("tip_dostave", "postom");
        postom.setAttribute("check", "");
        nacinDostave.appendChild(postom);

        Element elektronski = document.createElementNS(TARGET_NAMESPACE, "nacin");
        elektronski.setAttribute("tip_dostave", "elektronski");
        elektronski.setAttribute("check", "");
        nacinDostave.appendChild(elektronski);

        Element faksom = document.createElementNS(TARGET_NAMESPACE, "nacin");
        faksom.setAttribute("tip_dostave", "faksom");
        faksom.setAttribute("check", "");
        nacinDostave.appendChild(faksom);

        Element drugiNacin = document.createElementNS(TARGET_NAMESPACE, "nacin");
        drugiNacin.setAttribute("tip_dostave", "drugi_nacin");
        drugiNacin.setAttribute("check", "");
        nacinDostave.appendChild(drugiNacin);

        Element drugiNacinDostave = document.createElementNS(TARGET_NAMESPACE, "drugi_nacin");
        drugiNacin.appendChild(drugiNacinDostave);

        Element sadrzaj = document.createElementNS(TARGET_NAMESPACE, "sadrzaj");
        drugiNacinDostave.appendChild(sadrzaj);

        Element napomena3 = document.createElementNS(TARGET_NAMESPACE, "napomena");
        napomena3.setAttribute("id", "3");
        drugiNacinDostave.appendChild(napomena3);

        Element zahtevSeOdnosiNa = document.createElementNS(TARGET_NAMESPACE, "zahtev_se_odnosi_na");
        zahtevSeOdnosiNa.appendChild(document.createTextNode("Овај захтев се односи на следеће информације:"));
        dokumentZahtev.appendChild(zahtevSeOdnosiNa);

        Element informacije = document.createElementNS(TARGET_NAMESPACE, "informacije");
        zahtevSeOdnosiNa.appendChild(informacije);

        zahtevSeOdnosiNa.appendChild(document.createTextNode("навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење тражене информације"));

        Element mestoIDatum = document.createElementNS(TARGET_NAMESPACE, "mesto_i_datum");
        mestoIDatum.appendChild(document.createTextNode("У"));
        dokumentZahtev.appendChild(mestoIDatum);

        Element mesto = document.createElementNS(TARGET_NAMESPACE, "mesto");
        mestoIDatum.appendChild(mesto);

        mestoIDatum.appendChild(document.createTextNode(", dana"));

        Element datum = document.createElementNS(TARGET_NAMESPACE, "datum");
        mestoIDatum.appendChild(datum);

        mestoIDatum.appendChild(document.createTextNode("godine"));

        Element podnosilacZahteva = document.createElementNS(TARGET_NAMESPACE, "podnosilac_zahteva");
        dokumentZahtev.appendChild(podnosilacZahteva);

        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        podnosilacZahteva.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "prezime");
        podnosilacZahteva.appendChild(prezime);

        podnosilacZahteva.appendChild(document.createTextNode("Тражилац информације/Име и презиме"));

        Element adresa2 = document.createElementNS(TARGET_NAMESPACE, "adresa");
        podnosilacZahteva.appendChild(adresa2);

        Element ulica2 = document.createElementNS(TARGET_NAMESPACE, "ulica");
        adresa2.appendChild(ulica2);

        Element broj2 = document.createElementNS(TARGET_NAMESPACE, "broj");
        adresa2.appendChild(broj2);

        Element mesto2 = document.createElementNS(TARGET_NAMESPACE, "mesto");
        adresa2.appendChild(mesto2);

        podnosilacZahteva.appendChild(document.createTextNode("адреса"));

        Element drugiPodaciZaKontakt = document.createElementNS(TARGET_NAMESPACE, "drugi_podaci_za_kontakt");
        podnosilacZahteva.appendChild(drugiPodaciZaKontakt);

        podnosilacZahteva.appendChild(document.createTextNode("други подаци за контакт"));

        Element potpis = document.createElementNS(TARGET_NAMESPACE, "potpis");
        podnosilacZahteva.appendChild(potpis);

        podnosilacZahteva.appendChild(document.createTextNode("Потпис"));

        Element napomene = document.createElementNS(TARGET_NAMESPACE, "napomene");
        napomene.setAttribute("naslov", "Napomene");
        dokumentZahtev.appendChild(napomene);

        Element lista = document.createElementNS(TARGET_NAMESPACE, "lista");
        napomene.appendChild(lista);

        Element prvaNapomena = document.createElementNS(TARGET_NAMESPACE, "napomena");
        prvaNapomena.setAttribute("id", "1");
        prvaNapomena.setAttribute("labela", "*");
        prvaNapomena.appendChild(document.createTextNode("У кућици означити која законска права на приступ информацијама желите да остварите."));
        lista.appendChild(prvaNapomena);

        Element drugaNapomena = document.createElementNS(TARGET_NAMESPACE, "napomena");
        drugaNapomena.setAttribute("id", "2");
        drugaNapomena.setAttribute("labela", "**");
        drugaNapomena.appendChild(document.createTextNode("У кућици означити начин достављања копије докумената."));
        lista.appendChild(drugaNapomena);

        Element trecaNapomena = document.createElementNS(TARGET_NAMESPACE, "napomena");
        trecaNapomena.setAttribute("id", "3");
        trecaNapomena.setAttribute("labela", "***");
        trecaNapomena.appendChild(document.createTextNode("Када захтевате други начин достављања обавезно уписати који начин достављања захтевате."));
        lista.appendChild(trecaNapomena);
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

            filePath = "/static/data/schemas/zahtev.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        dokumentZahtevWriter handler = new dokumentZahtevWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);


        try {
            handler.transform(new FileOutputStream("src/main/resources/static/data/xml/zahtev_out.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}