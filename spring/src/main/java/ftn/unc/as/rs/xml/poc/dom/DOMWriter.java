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

/**
 * Primer demonstrira metode API-ja za potrebe programskog kreiranja DOM stabla.
 * Pored programskog kreiranja DOM stabla, primer demonstrira i serijalizaciju
 * DOM stabla na proizvoljan stream (npr. FileOutputStream, System.out, itd.).
 */
public class DOMWriter {

    private static final String TARGET_NAMESPACE = "http://www.ftn.uns.ac.rs/zalba_cutanje";

    private static final String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

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
    void createDocument() {

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

    void generateZahtevDOM() {

    }

    void generateZalbaCutanjaDOM() {

        // Kreiranje i postavljanje korenskog elementa
        Element zalbaCutanja = document.createElementNS(TARGET_NAMESPACE, "podaci_o_zalbi_cutanja");
        document.appendChild(zalbaCutanja);

        zalbaCutanja.setAttribute("xmlns", "zalba_cutanje");
        zalbaCutanja.setAttribute("xsi", XSI_NAMESPACE);
        zalbaCutanja.setAttribute("schemaLocation", "zalba_cutanje ../schemas/zalbaProtivCutanja.xsd");

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

    void generateZalbaOdlukeDOM() {

        // Kreiranje i postavljanje korenskog elementa
        Element zalbaProtivOdluke = document.createElementNS(TARGET_NAMESPACE, "zalba_protiv_odluke");
        document.appendChild(zalbaProtivOdluke);

        zalbaProtivOdluke.setAttribute("xmlns", "zalba_protiv_odluke");
        zalbaProtivOdluke.setAttribute("xmlns:xsi", XSI_NAMESPACE);
        zalbaProtivOdluke.setAttribute("xsi:schemaLocation", "zalba_protiv_odluke ../schemas/zalbaProtivOdluke.xsd");

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

    void generateObavestenjeDOM() {

        // Kreiranje i postavljanje korenskog elementa
        Element obavestenje = document.createElementNS(TARGET_NAMESPACE, "Obavestenje");
        document.appendChild(obavestenje);

        obavestenje.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.ftn.uns.ac.rs/obavestenje ../xsd/obavestenje.xsd");

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

    void generateResenjeDOM() {
        // Kreiranje i postavljanje korenskog elementa
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

    /**
     * Serializes DOM tree to an arbitrary OutputStream.
     */
    void transform(OutputStream out) {
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
}