//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.12 at 12:43:42 AM CET 
//


package ftn.unc.as.rs.xml.poc.jaxb.model.zahtev;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{zahtev_za_pristup_informacijama}adresa"/>
 *         &lt;element name="naslov_dokumenta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zahtev_na_osnovu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zakon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zahtev_za_pristup_informacijama}napomena"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lista_zahteva">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{zahtev_za_pristup_informacijama}zahtev" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="zahtev_se_odnosi_na">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="informacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mesto_i_datum">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podnosilac_zahteva">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence minOccurs="0">
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zahtev_za_pristup_informacijama}adresa"/>
 *                   &lt;element name="drugi_podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="napomene">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="lista">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element ref="{zahtev_za_pristup_informacijama}napomena" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="naslov" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nazivOrgana",
    "adresa",
    "naslovDokumenta",
    "zahtevNaOsnovu",
    "listaZahteva",
    "zahtevSeOdnosiNa",
    "mestoIDatum",
    "podnosilacZahteva",
    "napomene"
})
@XmlRootElement(name = "dokument_zahtev")
public class DokumentZahtev {

    @XmlElement(name = "naziv_organa", required = true)
    protected String nazivOrgana;
    @XmlElement(required = true)
    protected Adresa adresa;
    @XmlElement(name = "naslov_dokumenta", required = true)
    protected String naslovDokumenta;
    @XmlElement(name = "zahtev_na_osnovu", required = true)
    protected DokumentZahtev.ZahtevNaOsnovu zahtevNaOsnovu;
    @XmlElement(name = "lista_zahteva", required = true)
    protected DokumentZahtev.ListaZahteva listaZahteva;
    @XmlElement(name = "zahtev_se_odnosi_na", required = true)
    protected DokumentZahtev.ZahtevSeOdnosiNa zahtevSeOdnosiNa;
    @XmlElement(name = "mesto_i_datum", required = true)
    protected DokumentZahtev.MestoIDatum mestoIDatum;
    @XmlElement(name = "podnosilac_zahteva", required = true)
    protected DokumentZahtev.PodnosilacZahteva podnosilacZahteva;
    @XmlElement(required = true)
    protected DokumentZahtev.Napomene napomene;

    /**
     * Gets the value of the nazivOrgana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivOrgana() {
        return nazivOrgana;
    }

    /**
     * Sets the value of the nazivOrgana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivOrgana(String value) {
        this.nazivOrgana = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link Adresa }
     *     
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *     
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the naslovDokumenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslovDokumenta() {
        return naslovDokumenta;
    }

    /**
     * Sets the value of the naslovDokumenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslovDokumenta(String value) {
        this.naslovDokumenta = value;
    }

    /**
     * Gets the value of the zahtevNaOsnovu property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.ZahtevNaOsnovu }
     *     
     */
    public DokumentZahtev.ZahtevNaOsnovu getZahtevNaOsnovu() {
        return zahtevNaOsnovu;
    }

    /**
     * Sets the value of the zahtevNaOsnovu property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.ZahtevNaOsnovu }
     *     
     */
    public void setZahtevNaOsnovu(DokumentZahtev.ZahtevNaOsnovu value) {
        this.zahtevNaOsnovu = value;
    }

    /**
     * Gets the value of the listaZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.ListaZahteva }
     *     
     */
    public DokumentZahtev.ListaZahteva getListaZahteva() {
        return listaZahteva;
    }

    /**
     * Sets the value of the listaZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.ListaZahteva }
     *     
     */
    public void setListaZahteva(DokumentZahtev.ListaZahteva value) {
        this.listaZahteva = value;
    }

    /**
     * Gets the value of the zahtevSeOdnosiNa property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.ZahtevSeOdnosiNa }
     *     
     */
    public DokumentZahtev.ZahtevSeOdnosiNa getZahtevSeOdnosiNa() {
        return zahtevSeOdnosiNa;
    }

    /**
     * Sets the value of the zahtevSeOdnosiNa property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.ZahtevSeOdnosiNa }
     *     
     */
    public void setZahtevSeOdnosiNa(DokumentZahtev.ZahtevSeOdnosiNa value) {
        this.zahtevSeOdnosiNa = value;
    }

    /**
     * Gets the value of the mestoIDatum property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.MestoIDatum }
     *     
     */
    public DokumentZahtev.MestoIDatum getMestoIDatum() {
        return mestoIDatum;
    }

    /**
     * Sets the value of the mestoIDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.MestoIDatum }
     *     
     */
    public void setMestoIDatum(DokumentZahtev.MestoIDatum value) {
        this.mestoIDatum = value;
    }

    /**
     * Gets the value of the podnosilacZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.PodnosilacZahteva }
     *     
     */
    public DokumentZahtev.PodnosilacZahteva getPodnosilacZahteva() {
        return podnosilacZahteva;
    }

    /**
     * Sets the value of the podnosilacZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.PodnosilacZahteva }
     *     
     */
    public void setPodnosilacZahteva(DokumentZahtev.PodnosilacZahteva value) {
        this.podnosilacZahteva = value;
    }

    /**
     * Gets the value of the napomene property.
     * 
     * @return
     *     possible object is
     *     {@link DokumentZahtev.Napomene }
     *     
     */
    public DokumentZahtev.Napomene getNapomene() {
        return napomene;
    }

    /**
     * Sets the value of the napomene property.
     * 
     * @param value
     *     allowed object is
     *     {@link DokumentZahtev.Napomene }
     *     
     */
    public void setNapomene(DokumentZahtev.Napomene value) {
        this.napomene = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{zahtev_za_pristup_informacijama}zahtev" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zahtev"
    })
    public static class ListaZahteva {

        @XmlElement(required = true)
        protected List<Zahtev> zahtev;

        /**
         * Gets the value of the zahtev property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the zahtev property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getZahtev().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Zahtev }
         * 
         * 
         */
        public List<Zahtev> getZahtev() {
            if (zahtev == null) {
                zahtev = new ArrayList<Zahtev>();
            }
            return this.zahtev;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence minOccurs="0">
     *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class MestoIDatum {

        @XmlElementRefs({
            @XmlElementRef(name = "datum", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "mesto", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false)
        })
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="lista">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element ref="{zahtev_za_pristup_informacijama}napomena" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="naslov" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "lista"
    })
    public static class Napomene {

        @XmlElement(required = true)
        protected DokumentZahtev.Napomene.Lista lista;
        @XmlAttribute(name = "naslov", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NCName")
        protected String naslov;

        /**
         * Gets the value of the lista property.
         * 
         * @return
         *     possible object is
         *     {@link DokumentZahtev.Napomene.Lista }
         *     
         */
        public DokumentZahtev.Napomene.Lista getLista() {
            return lista;
        }

        /**
         * Sets the value of the lista property.
         * 
         * @param value
         *     allowed object is
         *     {@link DokumentZahtev.Napomene.Lista }
         *     
         */
        public void setLista(DokumentZahtev.Napomene.Lista value) {
            this.lista = value;
        }

        /**
         * Gets the value of the naslov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaslov() {
            return naslov;
        }

        /**
         * Sets the value of the naslov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaslov(String value) {
            this.naslov = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element ref="{zahtev_za_pristup_informacijama}napomena" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "napomena"
        })
        public static class Lista {

            @XmlElement(required = true)
            protected List<Napomena> napomena;

            /**
             * Gets the value of the napomena property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the napomena property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNapomena().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Napomena }
             * 
             * 
             */
            public List<Napomena> getNapomena() {
                if (napomena == null) {
                    napomena = new ArrayList<Napomena>();
                }
                return this.napomena;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence minOccurs="0">
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zahtev_za_pristup_informacijama}adresa"/>
     *         &lt;element name="drugi_podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class PodnosilacZahteva {

        @XmlElementRefs({
            @XmlElementRef(name = "drugi_podaci_za_kontakt", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "ime", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "adresa", namespace = "zahtev_za_pristup_informacijama", type = Adresa.class, required = false),
            @XmlElementRef(name = "prezime", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "potpis", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false)
        })
        @XmlMixed
        protected List<Object> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link Adresa }
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="zakon" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zahtev_za_pristup_informacijama}napomena"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "zakon",
        "napomena"
    })
    public static class ZahtevNaOsnovu {

        @XmlElement(required = true)
        protected String zakon;
        @XmlElement(required = true)
        protected Napomena napomena;

        /**
         * Gets the value of the zakon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZakon() {
            return zakon;
        }

        /**
         * Sets the value of the zakon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZakon(String value) {
            this.zakon = value;
        }

        /**
         * Gets the value of the napomena property.
         * 
         * @return
         *     possible object is
         *     {@link Napomena }
         *     
         */
        public Napomena getNapomena() {
            return napomena;
        }

        /**
         * Sets the value of the napomena property.
         * 
         * @param value
         *     allowed object is
         *     {@link Napomena }
         *     
         */
        public void setNapomena(Napomena value) {
            this.napomena = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="informacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class ZahtevSeOdnosiNa {

        @XmlElementRef(name = "informacije", namespace = "zahtev_za_pristup_informacijama", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

    }

}
