//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.06 at 10:55:10 PM CET 
//


package ftn.unc.as.rs.xml.poc.jaxb.model.zalbaProtivOdluke;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="vrsta_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="informacije_o_primaocu_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="primalac_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zalba_protiv_odluke}adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podaci_o_zaliocu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zalba_protiv_odluke}adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podaci_o_organu">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="resenje_zahteva">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="broj_resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="detalji_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="razlog_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mesto_i_datum">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podaci_o_podnosiocu_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zalba_protiv_odluke}adresa"/>
 *                   &lt;element name="drugi_podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="napomena">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="lista_napomena">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="stavka" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" default="napomena1" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" default="Napomena:" />
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
    "vrstaZalbe",
    "informacijeOPrimaocuZalbe",
    "naslov",
    "podaciOZaliocu",
    "podaciOOrganu",
    "detaljiZalbe",
    "mestoIDatum",
    "podaciOPodnosiocuZalbe",
    "napomena"
})
@XmlRootElement(name = "zalba_protiv_odluke")
public class ZalbaProtivOdluke {

    @XmlElement(name = "vrsta_zalbe", required = true)
    protected String vrstaZalbe;
    @XmlElement(name = "informacije_o_primaocu_zalbe", required = true)
    protected ZalbaProtivOdluke.InformacijeOPrimaocuZalbe informacijeOPrimaocuZalbe;
    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "podaci_o_zaliocu", required = true)
    protected ZalbaProtivOdluke.PodaciOZaliocu podaciOZaliocu;
    @XmlElement(name = "podaci_o_organu", required = true)
    protected ZalbaProtivOdluke.PodaciOOrganu podaciOOrganu;
    @XmlElement(name = "detalji_zalbe", required = true)
    protected ZalbaProtivOdluke.DetaljiZalbe detaljiZalbe;
    @XmlElement(name = "mesto_i_datum", required = true)
    protected ZalbaProtivOdluke.MestoIDatum mestoIDatum;
    @XmlElement(name = "podaci_o_podnosiocu_zalbe", required = true)
    protected ZalbaProtivOdluke.PodaciOPodnosiocuZalbe podaciOPodnosiocuZalbe;
    @XmlElement(required = true)
    protected ZalbaProtivOdluke.Napomena napomena;

    /**
     * Gets the value of the vrstaZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaZalbe() {
        return vrstaZalbe;
    }

    /**
     * Sets the value of the vrstaZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaZalbe(String value) {
        this.vrstaZalbe = value;
    }

    /**
     * Gets the value of the informacijeOPrimaocuZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.InformacijeOPrimaocuZalbe }
     *     
     */
    public ZalbaProtivOdluke.InformacijeOPrimaocuZalbe getInformacijeOPrimaocuZalbe() {
        return informacijeOPrimaocuZalbe;
    }

    /**
     * Sets the value of the informacijeOPrimaocuZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.InformacijeOPrimaocuZalbe }
     *     
     */
    public void setInformacijeOPrimaocuZalbe(ZalbaProtivOdluke.InformacijeOPrimaocuZalbe value) {
        this.informacijeOPrimaocuZalbe = value;
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
     * Gets the value of the podaciOZaliocu property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.PodaciOZaliocu }
     *     
     */
    public ZalbaProtivOdluke.PodaciOZaliocu getPodaciOZaliocu() {
        return podaciOZaliocu;
    }

    /**
     * Sets the value of the podaciOZaliocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.PodaciOZaliocu }
     *     
     */
    public void setPodaciOZaliocu(ZalbaProtivOdluke.PodaciOZaliocu value) {
        this.podaciOZaliocu = value;
    }

    /**
     * Gets the value of the podaciOOrganu property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.PodaciOOrganu }
     *     
     */
    public ZalbaProtivOdluke.PodaciOOrganu getPodaciOOrganu() {
        return podaciOOrganu;
    }

    /**
     * Sets the value of the podaciOOrganu property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.PodaciOOrganu }
     *     
     */
    public void setPodaciOOrganu(ZalbaProtivOdluke.PodaciOOrganu value) {
        this.podaciOOrganu = value;
    }

    /**
     * Gets the value of the detaljiZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.DetaljiZalbe }
     *     
     */
    public ZalbaProtivOdluke.DetaljiZalbe getDetaljiZalbe() {
        return detaljiZalbe;
    }

    /**
     * Sets the value of the detaljiZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.DetaljiZalbe }
     *     
     */
    public void setDetaljiZalbe(ZalbaProtivOdluke.DetaljiZalbe value) {
        this.detaljiZalbe = value;
    }

    /**
     * Gets the value of the mestoIDatum property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.MestoIDatum }
     *     
     */
    public ZalbaProtivOdluke.MestoIDatum getMestoIDatum() {
        return mestoIDatum;
    }

    /**
     * Sets the value of the mestoIDatum property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.MestoIDatum }
     *     
     */
    public void setMestoIDatum(ZalbaProtivOdluke.MestoIDatum value) {
        this.mestoIDatum = value;
    }

    /**
     * Gets the value of the podaciOPodnosiocuZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.PodaciOPodnosiocuZalbe }
     *     
     */
    public ZalbaProtivOdluke.PodaciOPodnosiocuZalbe getPodaciOPodnosiocuZalbe() {
        return podaciOPodnosiocuZalbe;
    }

    /**
     * Sets the value of the podaciOPodnosiocuZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.PodaciOPodnosiocuZalbe }
     *     
     */
    public void setPodaciOPodnosiocuZalbe(ZalbaProtivOdluke.PodaciOPodnosiocuZalbe value) {
        this.podaciOPodnosiocuZalbe = value;
    }

    /**
     * Gets the value of the napomena property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaProtivOdluke.Napomena }
     *     
     */
    public ZalbaProtivOdluke.Napomena getNapomena() {
        return napomena;
    }

    /**
     * Sets the value of the napomena property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaProtivOdluke.Napomena }
     *     
     */
    public void setNapomena(ZalbaProtivOdluke.Napomena value) {
        this.napomena = value;
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
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="razlog_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    public static class DetaljiZalbe {

        @XmlElementRefs({
            @XmlElementRef(name = "razlog_zalbe", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "datum", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
     *         &lt;element name="primalac_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zalba_protiv_odluke}adresa"/>
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
        "primalacZalbe",
        "adresa"
    })
    public static class InformacijeOPrimaocuZalbe {

        @XmlElement(name = "primalac_zalbe", required = true)
        protected String primalacZalbe;
        @XmlElement(required = true)
        protected Adresa adresa;

        /**
         * Gets the value of the primalacZalbe property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrimalacZalbe() {
            return primalacZalbe;
        }

        /**
         * Sets the value of the primalacZalbe property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrimalacZalbe(String value) {
            this.primalacZalbe = value;
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
            @XmlElementRef(name = "datum", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "mesto", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
     *         &lt;element name="lista_napomena">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="stavka" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" default="napomena1" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" default="Napomena:" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "listaNapomena"
    })
    public static class Napomena {

        @XmlElement(name = "lista_napomena", required = true)
        protected ZalbaProtivOdluke.Napomena.ListaNapomena listaNapomena;
        @XmlAttribute(name = "title")
        protected String title;

        /**
         * Gets the value of the listaNapomena property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaProtivOdluke.Napomena.ListaNapomena }
         *     
         */
        public ZalbaProtivOdluke.Napomena.ListaNapomena getListaNapomena() {
            return listaNapomena;
        }

        /**
         * Sets the value of the listaNapomena property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaProtivOdluke.Napomena.ListaNapomena }
         *     
         */
        public void setListaNapomena(ZalbaProtivOdluke.Napomena.ListaNapomena value) {
            this.listaNapomena = value;
        }

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            if (title == null) {
                return "Napomena:";
            } else {
                return title;
            }
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
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
         *         &lt;element name="stavka" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" default="napomena1" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
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
            "stavka"
        })
        public static class ListaNapomena {

            @XmlElement(required = true)
            protected List<ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka> stavka;

            /**
             * Gets the value of the stavka property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the stavka property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getStavka().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka }
             * 
             * 
             */
            public List<ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka> getStavka() {
                if (stavka == null) {
                    stavka = new ArrayList<ZalbaProtivOdluke.Napomena.ListaNapomena.Stavka>();
                }
                return this.stavka;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" default="napomena1" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Stavka {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "id")
                protected String id;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the id property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getId() {
                    if (id == null) {
                        return "napomena1";
                    } else {
                        return id;
                    }
                }

                /**
                 * Sets the value of the id property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setId(String value) {
                    this.id = value;
                }

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
     *       &lt;sequence>
     *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="resenje_zahteva">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="broj_resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
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
        "content"
    })
    public static class PodaciOOrganu {

        @XmlElementRefs({
            @XmlElementRef(name = "resenje_zahteva", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "naziv_organa", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
         * {@link JAXBElement }{@code <}{@link ZalbaProtivOdluke.PodaciOOrganu.ResenjeZahteva }{@code >}
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
         *         &lt;element name="broj_resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        public static class ResenjeZahteva {

            @XmlElementRefs({
                @XmlElementRef(name = "datum", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
                @XmlElementRef(name = "broj_resenja", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link String }
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
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zalba_protiv_odluke}adresa"/>
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
    public static class PodaciOPodnosiocuZalbe {

        @XmlElementRefs({
            @XmlElementRef(name = "prezime", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "ime", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "adresa", namespace = "zalba_protiv_odluke", type = Adresa.class),
            @XmlElementRef(name = "drugi_podaci_za_kontakt", namespace = "zalba_protiv_odluke", type = JAXBElement.class),
            @XmlElementRef(name = "potpis", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link Adresa }
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
     *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zalba_protiv_odluke}adresa"/>
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
    public static class PodaciOZaliocu {

        @XmlElementRefs({
            @XmlElementRef(name = "adresa", namespace = "zalba_protiv_odluke", type = Adresa.class),
            @XmlElementRef(name = "naziv", namespace = "zalba_protiv_odluke", type = JAXBElement.class)
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
         * {@link String }
         * {@link Adresa }
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

}
