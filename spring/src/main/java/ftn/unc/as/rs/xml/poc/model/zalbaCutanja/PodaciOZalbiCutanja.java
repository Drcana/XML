//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.06 at 10:54:48 PM CET 
//


package ftn.unc.as.rs.xml.poc.model.zalbaCutanja;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="vrsta_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="informacije_o_primaocu_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="primalac_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zalba_cutanje}adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="informacije_o_zalbi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="zakon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="razlog_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detalji_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="podaci_o_zalbi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="predlog_resenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="napomena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="podnosilac_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{zalba_cutanje}adresa"/>
 *                   &lt;element name="podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "content"
})
@XmlRootElement(name = "podaci_o_zalbi_cutanja")
public class PodaciOZalbiCutanja {

    @XmlElementRefs({
            @XmlElementRef(name = "informacije_o_zalbi", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "napomena", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "razlog_zalbe", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "podnosilac_zalbe", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "detalji_zalbe", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "vrsta_zalbe", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "mesto_i_datum", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "informacije_o_primaocu_zalbe", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
            @XmlElementRef(name = "predlog_resenja", namespace = "zalba_cutanje", type = JAXBElement.class, required = false)
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
     * {@link JAXBElement }{@code <}{@link PodaciOZalbiCutanja.InformacijeOZalbi }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link PodaciOZalbiCutanja.PodnosilacZalbe }{@code >}
     * {@link JAXBElement }{@code <}{@link PodaciOZalbiCutanja.DetaljiZalbe }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link PodaciOZalbiCutanja.MestoIDatum }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link PodaciOZalbiCutanja.InformacijeOPrimaocuZalbe }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="podaci_o_zalbi" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "content"
    })
    public static class DetaljiZalbe {

        @XmlElementRefs({
                @XmlElementRef(name = "datum", namespace = "zalba_cutanje", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "podaci_o_zalbi", namespace = "zalba_cutanje", type = JAXBElement.class, required = false)
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
     *         &lt;element ref="{zalba_cutanje}adresa"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
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
         * @return possible object is
         * {@link String }
         */
        public String getPrimalacZalbe() {
            return primalacZalbe;
        }

        /**
         * Sets the value of the primalacZalbe property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setPrimalacZalbe(String value) {
            this.primalacZalbe = value;
        }

        /**
         * Gets the value of the adresa property.
         *
         * @return possible object is
         * {@link Adresa }
         */
        public Adresa getAdresa() {
            return adresa;
        }

        /**
         * Sets the value of the adresa property.
         *
         * @param value allowed object is
         *              {@link Adresa }
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
     *         &lt;element name="zakon" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "content"
    })
    public static class InformacijeOZalbi {

        @XmlElementRefs({
                @XmlElementRef(name = "naziv_organa", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "zakon", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "naslov", namespace = "zalba_cutanje", type = JAXBElement.class)
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
         * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "content"
    })
    public static class MestoIDatum {

        @XmlElementRefs({
                @XmlElementRef(name = "mesto", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "datum", namespace = "zalba_cutanje", type = JAXBElement.class)
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
     *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="prezime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{zalba_cutanje}adresa"/>
     *         &lt;element name="podaci_za_kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "content"
    })
    public static class PodnosilacZalbe {

        @XmlElementRefs({
                @XmlElementRef(name = "potpis", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "ime", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "prezime", namespace = "zalba_cutanje", type = JAXBElement.class),
                @XmlElementRef(name = "adresa", namespace = "zalba_cutanje", type = Adresa.class),
                @XmlElementRef(name = "podaci_za_kontakt", namespace = "zalba_cutanje", type = JAXBElement.class)
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
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         */
        public List<Object> getContent() {
            if (content == null) {
                content = new ArrayList<Object>();
            }
            return this.content;
        }

    }

}
