//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.25 at 10:34:09 PM CET 
//


package rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ftn.unc.as.rs.xml.poc.jaxb.model.zahtev package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DokumentZahtevPodnosilacZahtevaPotpis_QNAME = new QName("zahtev_za_pristup_informacijama", "potpis");
    private final static QName _DokumentZahtevPodnosilacZahtevaIme_QNAME = new QName("zahtev_za_pristup_informacijama", "ime");
    private final static QName _DokumentZahtevPodnosilacZahtevaPrezime_QNAME = new QName("zahtev_za_pristup_informacijama", "prezime");
    private final static QName _DokumentZahtevPodnosilacZahtevaDrugiPodaciZaKontakt_QNAME = new QName("zahtev_za_pristup_informacijama", "drugi_podaci_za_kontakt");
    private final static QName _DokumentZahtevZahtevSeOdnosiNaInformacije_QNAME = new QName("zahtev_za_pristup_informacijama", "informacije");
    private final static QName _ZahtevListaNacina_QNAME = new QName("zahtev_za_pristup_informacijama", "lista_nacina");
    private final static QName _DokumentZahtevMestoIDatumDatum_QNAME = new QName("zahtev_za_pristup_informacijama", "datum");
    private final static QName _DokumentZahtevMestoIDatumMesto_QNAME = new QName("zahtev_za_pristup_informacijama", "mesto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ftn.unc.as.rs.xml.poc.jaxb.model.zahtev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Zahtev }
     * 
     */
    public Zahtev createZahtev() {
        return new Zahtev();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link DokumentZahtev }
     * 
     */
    public DokumentZahtev createDokumentZahtev() {
        return new DokumentZahtev();
    }

    /**
     * Create an instance of {@link DokumentZahtev.Napomene }
     * 
     */
    public DokumentZahtev.Napomene createDokumentZahtevNapomene() {
        return new DokumentZahtev.Napomene();
    }

    /**
     * Create an instance of {@link DokumentZahtev.PodnosilacZahteva }
     * 
     */
    public DokumentZahtev.PodnosilacZahteva createDokumentZahtevPodnosilacZahteva() {
        return new DokumentZahtev.PodnosilacZahteva();
    }

    /**
     * Create an instance of {@link Napomena }
     * 
     */
    public Napomena createNapomena() {
        return new Napomena();
    }

    /**
     * Create an instance of {@link Zahtev.ListaNacina }
     * 
     */
    public Zahtev.ListaNacina createZahtevListaNacina() {
        return new Zahtev.ListaNacina();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     * 
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Adresa.Broj }
     * 
     */
    public Adresa.Broj createAdresaBroj() {
        return new Adresa.Broj();
    }

    /**
     * Create an instance of {@link Adresa.Mesto }
     * 
     */
    public Adresa.Mesto createAdresaMesto() {
        return new Adresa.Mesto();
    }

    /**
     * Create an instance of {@link DokumentZahtev.ZahtevNaOsnovu }
     * 
     */
    public DokumentZahtev.ZahtevNaOsnovu createDokumentZahtevZahtevNaOsnovu() {
        return new DokumentZahtev.ZahtevNaOsnovu();
    }

    /**
     * Create an instance of {@link DokumentZahtev.ListaZahteva }
     * 
     */
    public DokumentZahtev.ListaZahteva createDokumentZahtevListaZahteva() {
        return new DokumentZahtev.ListaZahteva();
    }

    /**
     * Create an instance of {@link DokumentZahtev.ZahtevSeOdnosiNa }
     * 
     */
    public DokumentZahtev.ZahtevSeOdnosiNa createDokumentZahtevZahtevSeOdnosiNa() {
        return new DokumentZahtev.ZahtevSeOdnosiNa();
    }

    /**
     * Create an instance of {@link DokumentZahtev.MestoIDatum }
     * 
     */
    public DokumentZahtev.MestoIDatum createDokumentZahtevMestoIDatum() {
        return new DokumentZahtev.MestoIDatum();
    }

    /**
     * Create an instance of {@link Nacin }
     * 
     */
    public Nacin createNacin() {
        return new Nacin();
    }

    /**
     * Create an instance of {@link DrugiNacin }
     * 
     */
    public DrugiNacin createDrugiNacin() {
        return new DrugiNacin();
    }

    /**
     * Create an instance of {@link DokumentZahtev.Napomene.Lista }
     * 
     */
    public DokumentZahtev.Napomene.Lista createDokumentZahtevNapomeneLista() {
        return new DokumentZahtev.Napomene.Lista();
    }

    /**
     * Create an instance of {@link DokumentZahtev.PodnosilacZahteva.Ime }
     * 
     */
    public DokumentZahtev.PodnosilacZahteva.Ime createDokumentZahtevPodnosilacZahtevaIme() {
        return new DokumentZahtev.PodnosilacZahteva.Ime();
    }

    /**
     * Create an instance of {@link DokumentZahtev.PodnosilacZahteva.Prezime }
     * 
     */
    public DokumentZahtev.PodnosilacZahteva.Prezime createDokumentZahtevPodnosilacZahtevaPrezime() {
        return new DokumentZahtev.PodnosilacZahteva.Prezime();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "potpis", scope = DokumentZahtev.PodnosilacZahteva.class)
    public JAXBElement<String> createDokumentZahtevPodnosilacZahtevaPotpis(String value) {
        return new JAXBElement<String>(_DokumentZahtevPodnosilacZahtevaPotpis_QNAME, String.class, DokumentZahtev.PodnosilacZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DokumentZahtev.PodnosilacZahteva.Ime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "ime", scope = DokumentZahtev.PodnosilacZahteva.class)
    public JAXBElement<DokumentZahtev.PodnosilacZahteva.Ime> createDokumentZahtevPodnosilacZahtevaIme(DokumentZahtev.PodnosilacZahteva.Ime value) {
        return new JAXBElement<DokumentZahtev.PodnosilacZahteva.Ime>(_DokumentZahtevPodnosilacZahtevaIme_QNAME, DokumentZahtev.PodnosilacZahteva.Ime.class, DokumentZahtev.PodnosilacZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DokumentZahtev.PodnosilacZahteva.Prezime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "prezime", scope = DokumentZahtev.PodnosilacZahteva.class)
    public JAXBElement<DokumentZahtev.PodnosilacZahteva.Prezime> createDokumentZahtevPodnosilacZahtevaPrezime(DokumentZahtev.PodnosilacZahteva.Prezime value) {
        return new JAXBElement<DokumentZahtev.PodnosilacZahteva.Prezime>(_DokumentZahtevPodnosilacZahtevaPrezime_QNAME, DokumentZahtev.PodnosilacZahteva.Prezime.class, DokumentZahtev.PodnosilacZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "drugi_podaci_za_kontakt", scope = DokumentZahtev.PodnosilacZahteva.class)
    public JAXBElement<String> createDokumentZahtevPodnosilacZahtevaDrugiPodaciZaKontakt(String value) {
        return new JAXBElement<String>(_DokumentZahtevPodnosilacZahtevaDrugiPodaciZaKontakt_QNAME, String.class, DokumentZahtev.PodnosilacZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "informacije", scope = DokumentZahtev.ZahtevSeOdnosiNa.class)
    public JAXBElement<String> createDokumentZahtevZahtevSeOdnosiNaInformacije(String value) {
        return new JAXBElement<String>(_DokumentZahtevZahtevSeOdnosiNaInformacije_QNAME, String.class, DokumentZahtev.ZahtevSeOdnosiNa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zahtev.ListaNacina }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "lista_nacina", scope = Zahtev.class)
    public JAXBElement<Zahtev.ListaNacina> createZahtevListaNacina(Zahtev.ListaNacina value) {
        return new JAXBElement<Zahtev.ListaNacina>(_ZahtevListaNacina_QNAME, Zahtev.ListaNacina.class, Zahtev.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "datum", scope = DokumentZahtev.MestoIDatum.class)
    public JAXBElement<String> createDokumentZahtevMestoIDatumDatum(String value) {
        return new JAXBElement<String>(_DokumentZahtevMestoIDatumDatum_QNAME, String.class, DokumentZahtev.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zahtev_za_pristup_informacijama", name = "mesto", scope = DokumentZahtev.MestoIDatum.class)
    public JAXBElement<String> createDokumentZahtevMestoIDatumMesto(String value) {
        return new JAXBElement<String>(_DokumentZahtevMestoIDatumMesto_QNAME, String.class, DokumentZahtev.MestoIDatum.class, value);
    }

}
