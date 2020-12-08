//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.06 at 10:55:10 PM CET 
//


package ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the zalbaOdluke package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AdresaMesto_QNAME = new QName("zalba_protiv_odluke", "mesto");
    private final static QName _AdresaBroj_QNAME = new QName("zalba_protiv_odluke", "broj");
    private final static QName _AdresaUlica_QNAME = new QName("zalba_protiv_odluke", "ulica");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja_QNAME = new QName("zalba_protiv_odluke", "broj_resenja");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME = new QName("zalba_protiv_odluke", "datum");
    private final static QName _ZalbaProtivOdlukePodaciOZaliocuNaziv_QNAME = new QName("zalba_protiv_odluke", "naziv");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt_QNAME = new QName("zalba_protiv_odluke", "drugi_podaci_za_kontakt");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis_QNAME = new QName("zalba_protiv_odluke", "potpis");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbeIme_QNAME = new QName("zalba_protiv_odluke", "ime");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime_QNAME = new QName("zalba_protiv_odluke", "prezime");
    private final static QName _ZalbaProtivOdlukeDetaljiZalbeRazlogZalbe_QNAME = new QName("zalba_protiv_odluke", "razlog_zalbe");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahteva_QNAME = new QName("zalba_protiv_odluke", "resenje_zahteva");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuNazivOrgana_QNAME = new QName("zalba_protiv_odluke", "naziv_organa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: zalbaOdluke
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke }
     */
    public ZalbaProtivOdluke createZalbaProtivOdluke() {
        return new ZalbaProtivOdluke();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena }
     */
    public ZalbaProtivOdluke.Napomena createZalbaProtivOdlukeNapomena() {
        return new ZalbaProtivOdluke.Napomena();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena.ListaNapomena }
     */
    public ZalbaProtivOdluke.Napomena.ListaNapomena createZalbaProtivOdlukeNapomenaListaNapomena() {
        return new ZalbaProtivOdluke.Napomena.ListaNapomena();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu }
     */
    public ZalbaProtivOdluke.PodaciOOrganu createZalbaProtivOdlukePodaciOOrganu() {
        return new ZalbaProtivOdluke.PodaciOOrganu();
    }

    /**
     * Create an instance of {@link Adresa }
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.InformacijeOPrimaocuZalbe }
     */
    public ZalbaProtivOdluke.InformacijeOPrimaocuZalbe createZalbaProtivOdlukeInformacijeOPrimaocuZalbe() {
        return new ZalbaProtivOdluke.InformacijeOPrimaocuZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOZaliocu }
     */
    public ZalbaProtivOdluke.PodaciOZaliocu createZalbaProtivOdlukePodaciOZaliocu() {
        return new ZalbaProtivOdluke.PodaciOZaliocu();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.DetaljiZalbe }
     */
    public ZalbaProtivOdluke.DetaljiZalbe createZalbaProtivOdlukeDetaljiZalbe() {
        return new ZalbaProtivOdluke.DetaljiZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.MestoIDatum }
     */
    public ZalbaProtivOdluke.MestoIDatum createZalbaProtivOdlukeMestoIDatum() {
        return new ZalbaProtivOdluke.MestoIDatum();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOPodnosiocuZalbe }
     */
    public ZalbaProtivOdluke.PodaciOPodnosiocuZalbe createZalbaProtivOdlukePodaciOPodnosiocuZalbe() {
        return new ZalbaProtivOdluke.PodaciOPodnosiocuZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka }
     */
    public ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka createZalbaProtivOdlukeNapomenaListaNapomenaStavka() {
        return new ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva }
     */
    public ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva createZalbaProtivOdlukePodaciOOrganuResenjeZahteva() {
        return new ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "mesto", scope = Adresa.class)
    public JAXBElement<String> createAdresaMesto(String value) {
        return new JAXBElement<String>(_AdresaMesto_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "broj", scope = Adresa.class)
    public JAXBElement<String> createAdresaBroj(String value) {
        return new JAXBElement<String>(_AdresaBroj_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "ulica", scope = Adresa.class)
    public JAXBElement<String> createAdresaUlica(String value) {
        return new JAXBElement<String>(_AdresaUlica_QNAME, String.class, Adresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "broj_resenja", scope = ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja_QNAME, String.class, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, String.class, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "naziv", scope = ZalbaProtivOdluke.PodaciOZaliocu.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOZaliocuNaziv(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOZaliocuNaziv_QNAME, String.class, ZalbaProtivOdluke.PodaciOZaliocu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "drugi_podaci_za_kontakt", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "potpis", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "ime", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbeIme(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeIme_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "prezime", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "mesto", scope = ZalbaProtivOdluke.MestoIDatum.class)
    public JAXBElement<String> createZalbaProtivOdlukeMestoIDatumMesto(String value) {
        return new JAXBElement<String>(_AdresaMesto_QNAME, String.class, ZalbaProtivOdluke.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = ZalbaProtivOdluke.MestoIDatum.class)
    public JAXBElement<String> createZalbaProtivOdlukeMestoIDatumDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, String.class, ZalbaProtivOdluke.MestoIDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "razlog_zalbe", scope = ZalbaProtivOdluke.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukeDetaljiZalbeRazlogZalbe(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukeDetaljiZalbeRazlogZalbe_QNAME, String.class, ZalbaProtivOdluke.DetaljiZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = ZalbaProtivOdluke.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukeDetaljiZalbeDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, String.class, ZalbaProtivOdluke.DetaljiZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "resenje_zahteva", scope = ZalbaProtivOdluke.PodaciOOrganu.class)
    public JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva> createZalbaProtivOdlukePodaciOOrganuResenjeZahteva(ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva value) {
        return new JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahteva_QNAME, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, ZalbaProtivOdluke.PodaciOOrganu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "naziv_organa", scope = ZalbaProtivOdluke.PodaciOOrganu.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOOrganuNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuNazivOrgana_QNAME, String.class, ZalbaProtivOdluke.PodaciOOrganu.class, value);
    }

}