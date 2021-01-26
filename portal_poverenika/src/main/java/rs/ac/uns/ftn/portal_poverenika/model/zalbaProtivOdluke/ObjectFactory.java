//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.25 at 10:52:07 PM CET 
//


package rs.ac.uns.ftn.portal_poverenika.model.zalbaProtivOdluke;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke package. 
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

    private final static QName _TAdresaMesto_QNAME = new QName("zalba_protiv_odluke", "mesto");
    private final static QName _TAdresaBroj_QNAME = new QName("zalba_protiv_odluke", "broj");
    private final static QName _TAdresaUlica_QNAME = new QName("zalba_protiv_odluke", "ulica");
    private final static QName _TTekstP_QNAME = new QName("zalba_protiv_odluke", "p");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja_QNAME = new QName("zalba_protiv_odluke", "broj_resenja");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME = new QName("zalba_protiv_odluke", "datum");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt_QNAME = new QName("zalba_protiv_odluke", "drugi_podaci_za_kontakt");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbeAdresa_QNAME = new QName("zalba_protiv_odluke", "adresa");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis_QNAME = new QName("zalba_protiv_odluke", "potpis");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbeIme_QNAME = new QName("zalba_protiv_odluke", "ime");
    private final static QName _ZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime_QNAME = new QName("zalba_protiv_odluke", "prezime");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuResenjeZahteva_QNAME = new QName("zalba_protiv_odluke", "resenje_zahteva");
    private final static QName _ZalbaProtivOdlukePodaciOOrganuNazivOrgana_QNAME = new QName("zalba_protiv_odluke", "naziv_organa");
    private final static QName _TLiceAdresa_QNAME = new QName("zalba_protiv_odluke", "Adresa");
    private final static QName _ZalbaProtivOdlukeDetaljiZalbeRazlogZalbe_QNAME = new QName("zalba_protiv_odluke", "razlog_zalbe");
    private final static QName _ZalbaProtivOdlukePodaciOZaliocuNaziv_QNAME = new QName("zalba_protiv_odluke", "naziv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke }
     * 
     */
    public ZalbaProtivOdluke createZalbaProtivOdluke() {
        return new ZalbaProtivOdluke();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
    }

    /**
     * Create an instance of {@link TTekst }
     * 
     */
    public TTekst createTTekst() {
        return new TTekst();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena }
     * 
     */
    public ZalbaProtivOdluke.Napomena createZalbaProtivOdlukeNapomena() {
        return new ZalbaProtivOdluke.Napomena();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena.ListaNapomena }
     * 
     */
    public ZalbaProtivOdluke.Napomena.ListaNapomena createZalbaProtivOdlukeNapomenaListaNapomena() {
        return new ZalbaProtivOdluke.Napomena.ListaNapomena();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu }
     * 
     */
    public ZalbaProtivOdluke.PodaciOOrganu createZalbaProtivOdlukePodaciOOrganu() {
        return new ZalbaProtivOdluke.PodaciOOrganu();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva }
     * 
     */
    public ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva createZalbaProtivOdlukePodaciOOrganuResenjeZahteva() {
        return new ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOZaliocu }
     * 
     */
    public ZalbaProtivOdluke.PodaciOZaliocu createZalbaProtivOdlukePodaciOZaliocu() {
        return new ZalbaProtivOdluke.PodaciOZaliocu();
    }

    /**
     * Create an instance of {@link TId }
     * 
     */
    public TId createTId() {
        return new TId();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.InformacijeOPrimaocuZalbe }
     * 
     */
    public ZalbaProtivOdluke.InformacijeOPrimaocuZalbe createZalbaProtivOdlukeInformacijeOPrimaocuZalbe() {
        return new ZalbaProtivOdluke.InformacijeOPrimaocuZalbe();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.DetaljiZalbe }
     * 
     */
    public ZalbaProtivOdluke.DetaljiZalbe createZalbaProtivOdlukeDetaljiZalbe() {
        return new ZalbaProtivOdluke.DetaljiZalbe();
    }

    /**
     * Create an instance of {@link TMestoDatum }
     * 
     */
    public TMestoDatum createTMestoDatum() {
        return new TMestoDatum();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOPodnosiocuZalbe }
     * 
     */
    public ZalbaProtivOdluke.PodaciOPodnosiocuZalbe createZalbaProtivOdlukePodaciOPodnosiocuZalbe() {
        return new ZalbaProtivOdluke.PodaciOPodnosiocuZalbe();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link TFIzickoLice }
     * 
     */
    public TFIzickoLice createTFIzickoLice() {
        return new TFIzickoLice();
    }

    /**
     * Create an instance of {@link TAdresa.Mesto }
     * 
     */
    public TAdresa.Mesto createTAdresaMesto() {
        return new TAdresa.Mesto();
    }

    /**
     * Create an instance of {@link TAdresa.Ulica }
     * 
     */
    public TAdresa.Ulica createTAdresaUlica() {
        return new TAdresa.Ulica();
    }

    /**
     * Create an instance of {@link TAdresa.Broj }
     * 
     */
    public TAdresa.Broj createTAdresaBroj() {
        return new TAdresa.Broj();
    }

    /**
     * Create an instance of {@link TTekst.P }
     * 
     */
    public TTekst.P createTTekstP() {
        return new TTekst.P();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka }
     * 
     */
    public ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka createZalbaProtivOdlukeNapomenaListaNapomenaStavka() {
        return new ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana }
     * 
     */
    public ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana createZalbaProtivOdlukePodaciOOrganuNazivOrgana() {
        return new ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum }
     * 
     */
    public ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum createZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum() {
        return new ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum();
    }

    /**
     * Create an instance of {@link ZalbaProtivOdluke.PodaciOZaliocu.Naziv }
     * 
     */
    public ZalbaProtivOdluke.PodaciOZaliocu.Naziv createZalbaProtivOdlukePodaciOZaliocuNaziv() {
        return new ZalbaProtivOdluke.PodaciOZaliocu.Naziv();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa.Mesto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "mesto", scope = TAdresa.class)
    public JAXBElement<TAdresa.Mesto> createTAdresaMesto(TAdresa.Mesto value) {
        return new JAXBElement<TAdresa.Mesto>(_TAdresaMesto_QNAME, TAdresa.Mesto.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa.Broj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "broj", scope = TAdresa.class)
    public JAXBElement<TAdresa.Broj> createTAdresaBroj(TAdresa.Broj value) {
        return new JAXBElement<TAdresa.Broj>(_TAdresaBroj_QNAME, TAdresa.Broj.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa.Ulica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "ulica", scope = TAdresa.class)
    public JAXBElement<TAdresa.Ulica> createTAdresaUlica(TAdresa.Ulica value) {
        return new JAXBElement<TAdresa.Ulica>(_TAdresaUlica_QNAME, TAdresa.Ulica.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTekst.P }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "p", scope = TTekst.class)
    public JAXBElement<TTekst.P> createTTekstP(TTekst.P value) {
        return new JAXBElement<TTekst.P>(_TTekstP_QNAME, TTekst.P.class, TTekst.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "broj_resenja", scope = ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaBrojResenja_QNAME, String.class, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class)
    public JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum> createZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum(ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum value) {
        return new JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.Datum.class, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "drugi_podaci_za_kontakt", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeDrugiPodaciZaKontakt_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "adresa", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<TAdresa> createZalbaProtivOdlukePodaciOPodnosiocuZalbeAdresa(TAdresa value) {
        return new JAXBElement<TAdresa>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeAdresa_QNAME, TAdresa.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "potpis", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbePotpis_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "ime", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbeIme(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeIme_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "prezime", scope = ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbePrezime_QNAME, String.class, ZalbaProtivOdluke.PodaciOPodnosiocuZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "mesto", scope = TMestoDatum.class)
    public JAXBElement<String> createTMestoDatumMesto(String value) {
        return new JAXBElement<String>(_TAdresaMesto_QNAME, String.class, TMestoDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = TMestoDatum.class)
    public JAXBElement<String> createTMestoDatumDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, String.class, TMestoDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "resenje_zahteva", scope = ZalbaProtivOdluke.PodaciOOrganu.class)
    public JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva> createZalbaProtivOdlukePodaciOOrganuResenjeZahteva(ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva value) {
        return new JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahteva_QNAME, ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva.class, ZalbaProtivOdluke.PodaciOOrganu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "naziv_organa", scope = ZalbaProtivOdluke.PodaciOOrganu.class)
    public JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana> createZalbaProtivOdlukePodaciOOrganuNazivOrgana(ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana value) {
        return new JAXBElement<ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana>(_ZalbaProtivOdlukePodaciOOrganuNazivOrgana_QNAME, ZalbaProtivOdluke.PodaciOOrganu.NazivOrgana.class, ZalbaProtivOdluke.PodaciOOrganu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "Adresa", scope = TLice.class)
    public JAXBElement<TAdresa> createTLiceAdresa(TAdresa value) {
        return new JAXBElement<TAdresa>(_TLiceAdresa_QNAME, TAdresa.class, TLice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "razlog_zalbe", scope = ZalbaProtivOdluke.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukeDetaljiZalbeRazlogZalbe(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukeDetaljiZalbeRazlogZalbe_QNAME, String.class, ZalbaProtivOdluke.DetaljiZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "datum", scope = ZalbaProtivOdluke.DetaljiZalbe.class)
    public JAXBElement<String> createZalbaProtivOdlukeDetaljiZalbeDatum(String value) {
        return new JAXBElement<String>(_ZalbaProtivOdlukePodaciOOrganuResenjeZahtevaDatum_QNAME, String.class, ZalbaProtivOdluke.DetaljiZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOZaliocu.Naziv }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "naziv", scope = ZalbaProtivOdluke.PodaciOZaliocu.class)
    public JAXBElement<ZalbaProtivOdluke.PodaciOZaliocu.Naziv> createZalbaProtivOdlukePodaciOZaliocuNaziv(ZalbaProtivOdluke.PodaciOZaliocu.Naziv value) {
        return new JAXBElement<ZalbaProtivOdluke.PodaciOZaliocu.Naziv>(_ZalbaProtivOdlukePodaciOZaliocuNaziv_QNAME, ZalbaProtivOdluke.PodaciOZaliocu.Naziv.class, ZalbaProtivOdluke.PodaciOZaliocu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "zalba_protiv_odluke", name = "adresa", scope = ZalbaProtivOdluke.PodaciOZaliocu.class)
    public JAXBElement<TAdresa> createZalbaProtivOdlukePodaciOZaliocuAdresa(TAdresa value) {
        return new JAXBElement<TAdresa>(_ZalbaProtivOdlukePodaciOPodnosiocuZalbeAdresa_QNAME, TAdresa.class, ZalbaProtivOdluke.PodaciOZaliocu.class, value);
    }

}
