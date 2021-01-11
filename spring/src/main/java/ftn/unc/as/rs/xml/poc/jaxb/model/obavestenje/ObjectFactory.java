//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.12 at 12:35:08 AM CET 
//


package obavestenje;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the obavestenje package. 
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

    private final static QName _ObavestenjeTekstObavestenjaPTroskovi_QNAME = new QName("obavestenje", "troskovi");
    private final static QName _ObavestenjeTekstObavestenjaPDatumUvida_QNAME = new QName("obavestenje", "datum_uvida");
    private final static QName _ObavestenjeTekstObavestenjaPGodina_QNAME = new QName("obavestenje", "godina");
    private final static QName _ObavestenjeTekstObavestenjaPTrazenaInformacija_QNAME = new QName("obavestenje", "trazena_informacija");
    private final static QName _ObavestenjeTekstObavestenjaPVremeUvida_QNAME = new QName("obavestenje", "vreme_uvida");
    private final static QName _ObavestenjeTekstObavestenjaPMestoUvida_QNAME = new QName("obavestenje", "mesto_uvida");
    private final static QName _ObavestenjeTekstObavestenjaPVremeUvidaSati_QNAME = new QName("obavestenje", "sati");
    private final static QName _ObavestenjeTekstObavestenjaPVremeUvidaOd_QNAME = new QName("obavestenje", "od");
    private final static QName _ObavestenjeTekstObavestenjaPVremeUvidaDo_QNAME = new QName("obavestenje", "do");
    private final static QName _TMestoDatumDatum_QNAME = new QName("obavestenje", "datum");
    private final static QName _TMestoDatumMesto_QNAME = new QName("obavestenje", "mesto");
    private final static QName _TTekstP_QNAME = new QName("obavestenje", "p");
    private final static QName _TAdresaBroj_QNAME = new QName("obavestenje", "broj");
    private final static QName _TAdresaUlica_QNAME = new QName("obavestenje", "ulica");
    private final static QName _TLiceAdresa_QNAME = new QName("obavestenje", "Adresa");
    private final static QName _ObavestenjeTekstObavestenjaPMestoUvidaBrojKancelarije_QNAME = new QName("obavestenje", "broj_kancelarije");
    private final static QName _ObavestenjeTekstObavestenjaPMestoUvidaAdresa_QNAME = new QName("obavestenje", "adresa");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: obavestenje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Obavestenje }
     * 
     */
    public Obavestenje createObavestenje() {
        return new Obavestenje();
    }

    /**
     * Create an instance of {@link TTekst }
     * 
     */
    public TTekst createTTekst() {
        return new TTekst();
    }

    /**
     * Create an instance of {@link Obavestenje.TekstObavestenja }
     * 
     */
    public Obavestenje.TekstObavestenja createObavestenjeTekstObavestenja() {
        return new Obavestenje.TekstObavestenja();
    }

    /**
     * Create an instance of {@link Obavestenje.TekstObavestenja.P }
     * 
     */
    public Obavestenje.TekstObavestenja.P createObavestenjeTekstObavestenjaP() {
        return new Obavestenje.TekstObavestenja.P();
    }

    /**
     * Create an instance of {@link Obavestenje.InformacijeOObavestenju }
     * 
     */
    public Obavestenje.InformacijeOObavestenju createObavestenjeInformacijeOObavestenju() {
        return new Obavestenje.InformacijeOObavestenju();
    }

    /**
     * Create an instance of {@link TMestoDatum }
     * 
     */
    public TMestoDatum createTMestoDatum() {
        return new TMestoDatum();
    }

    /**
     * Create an instance of {@link TAdresa }
     * 
     */
    public TAdresa createTAdresa() {
        return new TAdresa();
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
     * Create an instance of {@link TId }
     * 
     */
    public TId createTId() {
        return new TId();
    }

    /**
     * Create an instance of {@link TTekst.P }
     * 
     */
    public TTekst.P createTTekstP() {
        return new TTekst.P();
    }

    /**
     * Create an instance of {@link Obavestenje.TekstObavestenja.P.VremeUvida }
     * 
     */
    public Obavestenje.TekstObavestenja.P.VremeUvida createObavestenjeTekstObavestenjaPVremeUvida() {
        return new Obavestenje.TekstObavestenja.P.VremeUvida();
    }

    /**
     * Create an instance of {@link Obavestenje.TekstObavestenja.P.MestoUvida }
     * 
     */
    public Obavestenje.TekstObavestenja.P.MestoUvida createObavestenjeTekstObavestenjaPMestoUvida() {
        return new Obavestenje.TekstObavestenja.P.MestoUvida();
    }

    /**
     * Create an instance of {@link Obavestenje.InformacijeOObavestenju.Dostavljeno }
     * 
     */
    public Obavestenje.InformacijeOObavestenju.Dostavljeno createObavestenjeInformacijeOObavestenjuDostavljeno() {
        return new Obavestenje.InformacijeOObavestenju.Dostavljeno();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "troskovi", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<BigInteger> createObavestenjeTekstObavestenjaPTroskovi(BigInteger value) {
        return new JAXBElement<BigInteger>(_ObavestenjeTekstObavestenjaPTroskovi_QNAME, BigInteger.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "datum_uvida", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPDatumUvida(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPDatumUvida_QNAME, String.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "godina", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPGodina(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPGodina_QNAME, String.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "trazena_informacija", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPTrazenaInformacija(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPTrazenaInformacija_QNAME, String.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.TekstObavestenja.P.VremeUvida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "vreme_uvida", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<Obavestenje.TekstObavestenja.P.VremeUvida> createObavestenjeTekstObavestenjaPVremeUvida(Obavestenje.TekstObavestenja.P.VremeUvida value) {
        return new JAXBElement<Obavestenje.TekstObavestenja.P.VremeUvida>(_ObavestenjeTekstObavestenjaPVremeUvida_QNAME, Obavestenje.TekstObavestenja.P.VremeUvida.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Obavestenje.TekstObavestenja.P.MestoUvida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "mesto_uvida", scope = Obavestenje.TekstObavestenja.P.class)
    public JAXBElement<Obavestenje.TekstObavestenja.P.MestoUvida> createObavestenjeTekstObavestenjaPMestoUvida(Obavestenje.TekstObavestenja.P.MestoUvida value) {
        return new JAXBElement<Obavestenje.TekstObavestenja.P.MestoUvida>(_ObavestenjeTekstObavestenjaPMestoUvida_QNAME, Obavestenje.TekstObavestenja.P.MestoUvida.class, Obavestenje.TekstObavestenja.P.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "sati", scope = Obavestenje.TekstObavestenja.P.VremeUvida.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPVremeUvidaSati(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPVremeUvidaSati_QNAME, String.class, Obavestenje.TekstObavestenja.P.VremeUvida.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "od", scope = Obavestenje.TekstObavestenja.P.VremeUvida.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPVremeUvidaOd(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPVremeUvidaOd_QNAME, String.class, Obavestenje.TekstObavestenja.P.VremeUvida.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "do", scope = Obavestenje.TekstObavestenja.P.VremeUvida.class)
    public JAXBElement<String> createObavestenjeTekstObavestenjaPVremeUvidaDo(String value) {
        return new JAXBElement<String>(_ObavestenjeTekstObavestenjaPVremeUvidaDo_QNAME, String.class, Obavestenje.TekstObavestenja.P.VremeUvida.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "datum", scope = TMestoDatum.class)
    public JAXBElement<String> createTMestoDatumDatum(String value) {
        return new JAXBElement<String>(_TMestoDatumDatum_QNAME, String.class, TMestoDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "mesto", scope = TMestoDatum.class)
    public JAXBElement<String> createTMestoDatumMesto(String value) {
        return new JAXBElement<String>(_TMestoDatumMesto_QNAME, String.class, TMestoDatum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTekst.P }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "p", scope = TTekst.class)
    public JAXBElement<TTekst.P> createTTekstP(TTekst.P value) {
        return new JAXBElement<TTekst.P>(_TTekstP_QNAME, TTekst.P.class, TTekst.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "broj", scope = TAdresa.class)
    public JAXBElement<BigInteger> createTAdresaBroj(BigInteger value) {
        return new JAXBElement<BigInteger>(_TAdresaBroj_QNAME, BigInteger.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "ulica", scope = TAdresa.class)
    public JAXBElement<String> createTAdresaUlica(String value) {
        return new JAXBElement<String>(_TAdresaUlica_QNAME, String.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "mesto", scope = TAdresa.class)
    public JAXBElement<String> createTAdresaMesto(String value) {
        return new JAXBElement<String>(_TMestoDatumMesto_QNAME, String.class, TAdresa.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "Adresa", scope = TLice.class)
    public JAXBElement<TAdresa> createTLiceAdresa(TAdresa value) {
        return new JAXBElement<TAdresa>(_TLiceAdresa_QNAME, TAdresa.class, TLice.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "broj_kancelarije", scope = Obavestenje.TekstObavestenja.P.MestoUvida.class)
    public JAXBElement<BigInteger> createObavestenjeTekstObavestenjaPMestoUvidaBrojKancelarije(BigInteger value) {
        return new JAXBElement<BigInteger>(_ObavestenjeTekstObavestenjaPMestoUvidaBrojKancelarije_QNAME, BigInteger.class, Obavestenje.TekstObavestenja.P.MestoUvida.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAdresa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "obavestenje", name = "adresa", scope = Obavestenje.TekstObavestenja.P.MestoUvida.class)
    public JAXBElement<TAdresa> createObavestenjeTekstObavestenjaPMestoUvidaAdresa(TAdresa value) {
        return new JAXBElement<TAdresa>(_ObavestenjeTekstObavestenjaPMestoUvidaAdresa_QNAME, TAdresa.class, Obavestenje.TekstObavestenja.P.MestoUvida.class, value);
    }

}
