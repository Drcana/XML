//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.06 at 10:54:16 PM CET 
//


package ftn.unc.as.rs.xml.poc.model.zahtev;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for nacin complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="nacin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="drugi_nacin" type="{zahtev_za_pristup_informacijama}drugi_nacin" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="check" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="tip_dostave" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nacin", propOrder = {
        "drugiNacin"
})
public class Nacin {

    @XmlElement(name = "drugi_nacin")
    protected List<DrugiNacin> drugiNacin;
    @XmlAttribute(name = "check", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String check;
    @XmlAttribute(name = "tip_dostave", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String tipDostave;

    /**
     * Gets the value of the drugiNacin property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drugiNacin property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrugiNacin().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DrugiNacin }
     */
    public List<DrugiNacin> getDrugiNacin() {
        if (drugiNacin == null) {
            drugiNacin = new ArrayList<DrugiNacin>();
        }
        return this.drugiNacin;
    }

    /**
     * Gets the value of the check property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCheck() {
        return check;
    }

    /**
     * Sets the value of the check property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCheck(String value) {
        this.check = value;
    }

    /**
     * Gets the value of the tipDostave property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTipDostave() {
        return tipDostave;
    }

    /**
     * Sets the value of the tipDostave property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTipDostave(String value) {
        this.tipDostave = value;
    }

}
