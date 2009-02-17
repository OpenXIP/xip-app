//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.17 at 09:07:21 AM CST 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImagingObservationCharacteristic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImagingObservationCharacteristic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="relatedImagingObservationCharacteristic" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ImagingObservationCharacteristic" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImagingObservationCharacteristic" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="codeMeaning" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="codingSchemeDesignator" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="codeValue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImagingObservationCharacteristic", propOrder = {
    "relatedImagingObservationCharacteristic"
})
public class ImagingObservationCharacteristic {

    protected ImagingObservationCharacteristic.RelatedImagingObservationCharacteristic relatedImagingObservationCharacteristic;
    @XmlAttribute(required = true)
    protected BigInteger id;
    @XmlAttribute(required = true)
    protected String codeMeaning;
    @XmlAttribute(required = true)
    protected String codingSchemeDesignator;
    @XmlAttribute(required = true)
    protected String codeValue;
    @XmlAttribute
    protected String comment;

    /**
     * Gets the value of the relatedImagingObservationCharacteristic property.
     * 
     * @return
     *     possible object is
     *     {@link ImagingObservationCharacteristic.RelatedImagingObservationCharacteristic }
     *     
     */
    public ImagingObservationCharacteristic.RelatedImagingObservationCharacteristic getRelatedImagingObservationCharacteristic() {
        return relatedImagingObservationCharacteristic;
    }

    /**
     * Sets the value of the relatedImagingObservationCharacteristic property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImagingObservationCharacteristic.RelatedImagingObservationCharacteristic }
     *     
     */
    public void setRelatedImagingObservationCharacteristic(ImagingObservationCharacteristic.RelatedImagingObservationCharacteristic value) {
        this.relatedImagingObservationCharacteristic = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the codeMeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeMeaning() {
        return codeMeaning;
    }

    /**
     * Sets the value of the codeMeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeMeaning(String value) {
        this.codeMeaning = value;
    }

    /**
     * Gets the value of the codingSchemeDesignator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodingSchemeDesignator() {
        return codingSchemeDesignator;
    }

    /**
     * Sets the value of the codingSchemeDesignator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodingSchemeDesignator(String value) {
        this.codingSchemeDesignator = value;
    }

    /**
     * Gets the value of the codeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * Sets the value of the codeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeValue(String value) {
        this.codeValue = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
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
     *         &lt;element name="ImagingObservationCharacteristic" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImagingObservationCharacteristic" minOccurs="0"/>
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
        "imagingObservationCharacteristic"
    })
    public static class RelatedImagingObservationCharacteristic {

        @XmlElement(name = "ImagingObservationCharacteristic")
        protected ImagingObservationCharacteristic imagingObservationCharacteristic;

        /**
         * Gets the value of the imagingObservationCharacteristic property.
         * 
         * @return
         *     possible object is
         *     {@link ImagingObservationCharacteristic }
         *     
         */
        public ImagingObservationCharacteristic getImagingObservationCharacteristic() {
            return imagingObservationCharacteristic;
        }

        /**
         * Sets the value of the imagingObservationCharacteristic property.
         * 
         * @param value
         *     allowed object is
         *     {@link ImagingObservationCharacteristic }
         *     
         */
        public void setImagingObservationCharacteristic(ImagingObservationCharacteristic value) {
            this.imagingObservationCharacteristic = value;
        }

    }

}
