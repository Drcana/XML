//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.28 at 04:39:24 AM CET 
//


package rs.ac.uns.ftn.portal_organa_vlasti.model.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Tnacin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tnacin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="drugi_nacin" type="{http://www.ftn.uns.ac.rs/zahtev}Tdrugi_nacin" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="checked" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="tip_dostave" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tnacin", propOrder = {
    "drugiNacin"
})
public class Tnacin {

    @XmlElement(name = "drugi_nacin")
    protected TdrugiNacin drugiNacin;
    @XmlAttribute(name = "checked", required = true)
    protected boolean checked;
    @XmlAttribute(name = "tip_dostave", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tipDostave;

    /**
     * Gets the value of the drugiNacin property.
     * 
     * @return
     *     possible object is
     *     {@link TdrugiNacin }
     *     
     */
    public TdrugiNacin getDrugiNacin() {
        return drugiNacin;
    }

    /**
     * Sets the value of the drugiNacin property.
     * 
     * @param value
     *     allowed object is
     *     {@link TdrugiNacin }
     *     
     */
    public void setDrugiNacin(TdrugiNacin value) {
        this.drugiNacin = value;
    }

    /**
     * Gets the value of the checked property.
     * 
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets the value of the checked property.
     * 
     */
    public void setChecked(boolean value) {
        this.checked = value;
    }

    /**
     * Gets the value of the tipDostave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipDostave() {
        return tipDostave;
    }

    /**
     * Sets the value of the tipDostave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipDostave(String value) {
        this.tipDostave = value;
    }

}