//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.08 at 01:56:21 AM CET 
//


package ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivCutanja;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the test package. 
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

    private final static QName _ZalbaProtivCutanjaMestoIDatumDatum_QNAME = new QName("zalba_protiv_cutanja", "datum");
    private final static QName _ZalbaProtivCutanjaMestoIDatumMesto_QNAME = new QName("zalba_protiv_cutanja", "mesto");
    private final static QName _AdresaUlica_QNAME = new QName("zalba_protiv_cutanja", "ulica");
    private final static QName _AdresaBroj_QNAME = new QName("zalba_protiv_cutanja", "broj");
    private final static QName _ZalbaProtivCutanjaInformacijeOZalbiNaslov_QNAME = new QName("zalba_protiv_cutanja", "naslov");
    private final static QName _ZalbaProtivCutanjaInformacijeOZalbiNazivOrgana_QNAME = new QName("zalba_protiv_cutanja", "naziv_organa");
    private final static QName _ZalbaProtivCutanjaInformacijeOZalbiZakon_QNAME = new QName("zalba_protiv_cutanja", "zakon");
    private final static QName _ZalbaProtivCutanjaInformacijeOZalbi_QNAME = new QName("zalba_protiv_cutanja", "informacije_o_zalbi");
    private final static QName _ZalbaProtivCutanjaDetaljiZalbe_QNAME = new QName("zalba_protiv_cutanja", "detalji_zalbe");
    private final static QName _ZalbaProtivCutanjaRazlogZalbe_QNAME = new QName("zalba_protiv_cutanja", "razlog_zalbe");
    private final static QName _ZalbaProtivCutanjaNapomena_QNAME = new QName("zalba_protiv_cutanja", "napomena");
    private final static QName _ZalbaProtivCutanjaMestoIDatum_QNAME = new QName("zalba_protiv_cutanja", "mesto_i_datum");
    private final static QName _ZalbaProtivCutanjaPodnosilacZalbe_QNAME = new QName("zalba_protiv_cutanja", "podnosilac_zalbe");
    private final static QName _ZalbaProtivCutanjaInformacijeOPrimaocuZalbe_QNAME = new QName("zalba_protiv_cutanja", "informacije_o_primaocu_zalbe");
    private final static QName _ZalbaProtivCutanjaPredlogResenja_QNAME = new QName("zalba_protiv_cutanja", "predlog_resenja");
    private final static QName _ZalbaProtivCutanjaVrstaZalbe_QNAME = new QName("zalba_protiv_cutanja", "vrsta_zalbe");
    private final static QName _ZalbaProtivCutanjaPodnosilacZalbeIme_QNAME = new QName("zalba_protiv_cutanja", "ime");
    private final static QName _ZalbaProtivCutanjaPodnosilacZalbePrezime_QNAME = new QName("zalba_protiv_cutanja", "prezime");
    private final static QName _ZalbaProtivCutanjaPodnosilacZalbePotpis_QNAME = new QName("zalba_protiv_cutanja", "potpis");
    private final static QName _ZalbaProtivCutanjaPodnosilacZalbePodaciZaKontakt_QNAME = new QName("zalba_protiv_cutanja", "podaci_za_kontakt");
    private final static QName _ZalbaProtivCutanjaDetaljiZalbePodaciOZalbi_QNAME = new QName("zalba_protiv_cutanja", "podaci_o_zalbi");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja }
     * 
     */
    public ZalbaProtivCutanja createZalbaProtivCutanja() {
        return new ZalbaProtivCutanja();
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja.InformacijeOPrimaocuZalbe }
     * 
     */
    public ZalbaProtivCutanja.InformacijeOPrimaocuZalbe createZalbaProtivCutanjaInformacijeOPrimaocuZalbe() {
        return new ZalbaProtivCutanja.InformacijeOPrimaocuZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja.InformacijeOZalbi }
     * 
     */
    public ZalbaProtivCutanja.InformacijeOZalbi createZalbaProtivCutanjaInformacijeOZalbi() {
        return new ZalbaProtivCutanja.InformacijeOZalbi();
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja.DetaljiZalbe }
     * 
     */
    public ZalbaProtivCutanja.DetaljiZalbe createZalbaProtivCutanjaDetaljiZalbe() {
        return new ZalbaProtivCutanja.DetaljiZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja.PodnosilacZalbe }
     * 
     */
    public ZalbaProtivCutanja.PodnosilacZalbe createZalbaProtivCutanjaPodnosilacZalbe() {
        return new ZalbaProtivCutanja.PodnosilacZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivCutanja.MestoIDatum }
     * 
     */
    public ZalbaProtivCutanja.MestoIDatum createZalbaProtivCutanjaMestoIDatum() {
        return new ZalbaProtivCutanja.MestoIDatum();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "datum", scope = ZalbaProtivCutanja.MestoIDatum.class)
    public JAXBElement<String> createZalbaProtivCutanjaMestoIDatumDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaMestoIDatumDatum_QNAME, String.class, ZalbaProtivCutanja.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "mesto", scope = ZalbaProtivCutanja.MestoIDatum.class)
    public JAXBElement<String> createZalbaProtivCutanjaMestoIDatumMesto(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaMestoIDatumMesto_QNAME, String.class, ZalbaProtivCutanja.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "ulica", scope = Adresa.class)
    public JAXBElement<String> createAdresaUlica(String value) {
        return new JAXBElement<String>(_AdresaUlica_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "broj", scope = Adresa.class)
    public JAXBElement<String> createAdresaBroj(String value) {
        return new JAXBElement<String>(_AdresaBroj_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "mesto", scope = Adresa.class)
    public JAXBElement<String> createAdresaMesto(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaMestoIDatumMesto_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "naslov", scope = ZalbaProtivCutanja.InformacijeOZalbi.class)
    public JAXBElement<String> createZalbaProtivCutanjaInformacijeOZalbiNaslov(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaInformacijeOZalbiNaslov_QNAME, String.class, ZalbaProtivCutanja.InformacijeOZalbi.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "naziv_organa", scope = ZalbaProtivCutanja.InformacijeOZalbi.class)
    public JAXBElement<String> createZalbaProtivCutanjaInformacijeOZalbiNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaInformacijeOZalbiNazivOrgana_QNAME, String.class, ZalbaProtivCutanja.InformacijeOZalbi.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "zakon", scope = ZalbaProtivCutanja.InformacijeOZalbi.class)
    public JAXBElement<String> createZalbaProtivCutanjaInformacijeOZalbiZakon(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaInformacijeOZalbiZakon_QNAME, String.class, ZalbaProtivCutanja.InformacijeOZalbi.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivCutanja.InformacijeOZalbi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "informacije_o_zalbi", scope = ZalbaProtivCutanja.class)
    public JAXBElement<ZalbaProtivCutanja.InformacijeOZalbi> createZalbaProtivCutanjaInformacijeOZalbi(ZalbaProtivCutanja.InformacijeOZalbi value) {
        return new JAXBElement<ZalbaProtivCutanja.InformacijeOZalbi>(_ZalbaProtivCutanjaInformacijeOZalbi_QNAME, ZalbaProtivCutanja.InformacijeOZalbi.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivCutanja.DetaljiZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "detalji_zalbe", scope = ZalbaProtivCutanja.class)
    public JAXBElement<ZalbaProtivCutanja.DetaljiZalbe> createZalbaProtivCutanjaDetaljiZalbe(ZalbaProtivCutanja.DetaljiZalbe value) {
        return new JAXBElement<ZalbaProtivCutanja.DetaljiZalbe>(_ZalbaProtivCutanjaDetaljiZalbe_QNAME, ZalbaProtivCutanja.DetaljiZalbe.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "razlog_zalbe", scope = ZalbaProtivCutanja.class)
    public JAXBElement<String> createZalbaProtivCutanjaRazlogZalbe(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaRazlogZalbe_QNAME, String.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "napomena", scope = ZalbaProtivCutanja.class)
    public JAXBElement<String> createZalbaProtivCutanjaNapomena(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaNapomena_QNAME, String.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivCutanja.MestoIDatum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "mesto_i_datum", scope = ZalbaProtivCutanja.class)
    public JAXBElement<ZalbaProtivCutanja.MestoIDatum> createZalbaProtivCutanjaMestoIDatum(ZalbaProtivCutanja.MestoIDatum value) {
        return new JAXBElement<ZalbaProtivCutanja.MestoIDatum>(_ZalbaProtivCutanjaMestoIDatum_QNAME, ZalbaProtivCutanja.MestoIDatum.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivCutanja.PodnosilacZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "podnosilac_zalbe", scope = ZalbaProtivCutanja.class)
    public JAXBElement<ZalbaProtivCutanja.PodnosilacZalbe> createZalbaProtivCutanjaPodnosilacZalbe(ZalbaProtivCutanja.PodnosilacZalbe value) {
        return new JAXBElement<ZalbaProtivCutanja.PodnosilacZalbe>(_ZalbaProtivCutanjaPodnosilacZalbe_QNAME, ZalbaProtivCutanja.PodnosilacZalbe.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivCutanja.InformacijeOPrimaocuZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "informacije_o_primaocu_zalbe", scope = ZalbaProtivCutanja.class)
    public JAXBElement<ZalbaProtivCutanja.InformacijeOPrimaocuZalbe> createZalbaProtivCutanjaInformacijeOPrimaocuZalbe(ZalbaProtivCutanja.InformacijeOPrimaocuZalbe value) {
        return new JAXBElement<ZalbaProtivCutanja.InformacijeOPrimaocuZalbe>(_ZalbaProtivCutanjaInformacijeOPrimaocuZalbe_QNAME, ZalbaProtivCutanja.InformacijeOPrimaocuZalbe.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "predlog_resenja", scope = ZalbaProtivCutanja.class)
    public JAXBElement<String> createZalbaProtivCutanjaPredlogResenja(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaPredlogResenja_QNAME, String.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "vrsta_zalbe", scope = ZalbaProtivCutanja.class)
    public JAXBElement<String> createZalbaProtivCutanjaVrstaZalbe(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaVrstaZalbe_QNAME, String.class, ZalbaProtivCutanja.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "ime", scope = ZalbaProtivCutanja.PodnosilacZalbe.class)
    public JAXBElement<String> createZalbaProtivCutanjaPodnosilacZalbeIme(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaPodnosilacZalbeIme_QNAME, String.class, ZalbaProtivCutanja.PodnosilacZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "prezime", scope = ZalbaProtivCutanja.PodnosilacZalbe.class)
    public JAXBElement<String> createZalbaProtivCutanjaPodnosilacZalbePrezime(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaPodnosilacZalbePrezime_QNAME, String.class, ZalbaProtivCutanja.PodnosilacZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "potpis", scope = ZalbaProtivCutanja.PodnosilacZalbe.class)
    public JAXBElement<String> createZalbaProtivCutanjaPodnosilacZalbePotpis(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaPodnosilacZalbePotpis_QNAME, String.class, ZalbaProtivCutanja.PodnosilacZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "podaci_za_kontakt", scope = ZalbaProtivCutanja.PodnosilacZalbe.class, defaultValue = "")
    public JAXBElement<String> createZalbaProtivCutanjaPodnosilacZalbePodaciZaKontakt(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaPodnosilacZalbePodaciZaKontakt_QNAME, String.class, ZalbaProtivCutanja.PodnosilacZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "datum", scope = ZalbaProtivCutanja.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivCutanjaDetaljiZalbeDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaMestoIDatumDatum_QNAME, String.class, ZalbaProtivCutanja.DetaljiZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_cutanja", name = "podaci_o_zalbi", scope = ZalbaProtivCutanja.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivCutanjaDetaljiZalbePodaciOZalbi(String value) {
        return new JAXBElement<String>(_ZalbaProtivCutanjaDetaljiZalbePodaciOZalbi_QNAME, String.class, ZalbaProtivCutanja.DetaljiZalbe.class, value);
    }

}