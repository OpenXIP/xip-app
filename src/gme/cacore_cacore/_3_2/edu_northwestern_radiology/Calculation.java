//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.10.28 at 10:12:54 AM CDT 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Calculation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Calculation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="referencedCalculationCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ReferencedCalculation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ReferencedCalculation" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="calculationResultCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CalculationResult" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}CalculationResult" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mathML" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}AnnotationCalculationIdentifier" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Calculation", propOrder = {
    "referencedCalculationCollection",
    "calculationResultCollection"
})
public class Calculation {

    protected Calculation.ReferencedCalculationCollection referencedCalculationCollection;
    protected Calculation.CalculationResultCollection calculationResultCollection;
    @XmlAttribute(required = true)
    protected BigInteger id;
    @XmlAttribute(required = true)
    protected String uid;
    @XmlAttribute(required = true)
    protected String description;
    @XmlAttribute
    protected String mathML;
    @XmlAttribute(required = true)
    protected String type;

    /**
     * Gets the value of the referencedCalculationCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Calculation.ReferencedCalculationCollection }
     *     
     */
    public Calculation.ReferencedCalculationCollection getReferencedCalculationCollection() {
        return referencedCalculationCollection;
    }

    /**
     * Sets the value of the referencedCalculationCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calculation.ReferencedCalculationCollection }
     *     
     */
    public void setReferencedCalculationCollection(Calculation.ReferencedCalculationCollection value) {
        this.referencedCalculationCollection = value;
    }

    /**
     * Gets the value of the calculationResultCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Calculation.CalculationResultCollection }
     *     
     */
    public Calculation.CalculationResultCollection getCalculationResultCollection() {
        return calculationResultCollection;
    }

    /**
     * Sets the value of the calculationResultCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Calculation.CalculationResultCollection }
     *     
     */
    public void setCalculationResultCollection(Calculation.CalculationResultCollection value) {
        this.calculationResultCollection = value;
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
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUid(String value) {
        this.uid = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the mathML property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMathML() {
        return mathML;
    }

    /**
     * Sets the value of the mathML property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMathML(String value) {
        this.mathML = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     *         &lt;element name="CalculationResult" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}CalculationResult" maxOccurs="unbounded" minOccurs="0"/>
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
        "calculationResult"
    })
    public static class CalculationResultCollection {

        @XmlElement(name = "CalculationResult")
        protected List<CalculationResult> calculationResult;

        /**
         * Gets the value of the calculationResult property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the calculationResult property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCalculationResult().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CalculationResult }
         * 
         * 
         */
        public List<CalculationResult> getCalculationResult() {
            if (calculationResult == null) {
                calculationResult = new ArrayList<CalculationResult>();
            }
            return this.calculationResult;
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
     *         &lt;element name="ReferencedCalculation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ReferencedCalculation" maxOccurs="unbounded" minOccurs="0"/>
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
        "referencedCalculation"
    })
    public static class ReferencedCalculationCollection {

        @XmlElement(name = "ReferencedCalculation")
        protected List<ReferencedCalculation> referencedCalculation;

        /**
         * Gets the value of the referencedCalculation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the referencedCalculation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferencedCalculation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReferencedCalculation }
         * 
         * 
         */
        public List<ReferencedCalculation> getReferencedCalculation() {
            if (referencedCalculation == null) {
                referencedCalculation = new ArrayList<ReferencedCalculation>();
            }
            return this.referencedCalculation;
        }

    }

}
