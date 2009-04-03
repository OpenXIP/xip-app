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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Annotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Annotation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="User" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}User" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="imagingObservationCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ImagingObservation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImagingObservation" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="calculationCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Calculation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Calculation" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="equipment" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Equipment" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Equipment" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="anatomicEntityCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AnatomicEntity" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}AnatomicEntity" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="aimVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="comment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dateTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="uid" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Annotation", propOrder = {
    "user",
    "imagingObservationCollection",
    "calculationCollection",
    "equipment",
    "anatomicEntityCollection"
})
@XmlSeeAlso({
    AnnotationOfAnnotation.class,
    ImageAnnotation.class
})
public abstract class Annotation {

    protected Annotation.User user;
    protected Annotation.ImagingObservationCollection imagingObservationCollection;
    protected Annotation.CalculationCollection calculationCollection;
    protected Annotation.Equipment equipment;
    protected Annotation.AnatomicEntityCollection anatomicEntityCollection;
    @XmlAttribute(required = true)
    protected BigInteger id;
    @XmlAttribute(required = true)
    protected String aimVersion;
    @XmlAttribute
    protected String comment;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(required = true)
    protected String uid;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation.User }
     *     
     */
    public Annotation.User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation.User }
     *     
     */
    public void setUser(Annotation.User value) {
        this.user = value;
    }

    /**
     * Gets the value of the imagingObservationCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation.ImagingObservationCollection }
     *     
     */
    public Annotation.ImagingObservationCollection getImagingObservationCollection() {
        return imagingObservationCollection;
    }

    /**
     * Sets the value of the imagingObservationCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation.ImagingObservationCollection }
     *     
     */
    public void setImagingObservationCollection(Annotation.ImagingObservationCollection value) {
        this.imagingObservationCollection = value;
    }

    /**
     * Gets the value of the calculationCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation.CalculationCollection }
     *     
     */
    public Annotation.CalculationCollection getCalculationCollection() {
        return calculationCollection;
    }

    /**
     * Sets the value of the calculationCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation.CalculationCollection }
     *     
     */
    public void setCalculationCollection(Annotation.CalculationCollection value) {
        this.calculationCollection = value;
    }

    /**
     * Gets the value of the equipment property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation.Equipment }
     *     
     */
    public Annotation.Equipment getEquipment() {
        return equipment;
    }

    /**
     * Sets the value of the equipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation.Equipment }
     *     
     */
    public void setEquipment(Annotation.Equipment value) {
        this.equipment = value;
    }

    /**
     * Gets the value of the anatomicEntityCollection property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation.AnatomicEntityCollection }
     *     
     */
    public Annotation.AnatomicEntityCollection getAnatomicEntityCollection() {
        return anatomicEntityCollection;
    }

    /**
     * Sets the value of the anatomicEntityCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation.AnatomicEntityCollection }
     *     
     */
    public void setAnatomicEntityCollection(Annotation.AnatomicEntityCollection value) {
        this.anatomicEntityCollection = value;
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
     * Gets the value of the aimVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAimVersion() {
        return aimVersion;
    }

    /**
     * Sets the value of the aimVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAimVersion(String value) {
        this.aimVersion = value;
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
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTime(XMLGregorianCalendar value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AnatomicEntity" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}AnatomicEntity" maxOccurs="unbounded" minOccurs="0"/>
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
        "anatomicEntity"
    })
    public static class AnatomicEntityCollection {

        @XmlElement(name = "AnatomicEntity")
        protected List<AnatomicEntity> anatomicEntity;

        /**
         * Gets the value of the anatomicEntity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the anatomicEntity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnatomicEntity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AnatomicEntity }
         * 
         * 
         */
        public List<AnatomicEntity> getAnatomicEntity() {
            if (anatomicEntity == null) {
                anatomicEntity = new ArrayList<AnatomicEntity>();
            }
            return this.anatomicEntity;
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
     *         &lt;element name="Calculation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Calculation" maxOccurs="unbounded" minOccurs="0"/>
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
        "calculation"
    })
    public static class CalculationCollection {

        @XmlElement(name = "Calculation")
        protected List<Calculation> calculation;

        /**
         * Gets the value of the calculation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the calculation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCalculation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Calculation }
         * 
         * 
         */
        public List<Calculation> getCalculation() {
            if (calculation == null) {
                calculation = new ArrayList<Calculation>();
            }
            return this.calculation;
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
     *         &lt;element name="Equipment" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Equipment" minOccurs="0"/>
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
        "equipment"
    })
    public static class Equipment {

        @XmlElement(name = "Equipment")
        protected gme.cacore_cacore._3_2.edu_northwestern_radiology.Equipment equipment;

        /**
         * Gets the value of the equipment property.
         * 
         * @return
         *     possible object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.Equipment }
         *     
         */
        public gme.cacore_cacore._3_2.edu_northwestern_radiology.Equipment getEquipment() {
            return equipment;
        }

        /**
         * Sets the value of the equipment property.
         * 
         * @param value
         *     allowed object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.Equipment }
         *     
         */
        public void setEquipment(gme.cacore_cacore._3_2.edu_northwestern_radiology.Equipment value) {
            this.equipment = value;
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
     *         &lt;element name="ImagingObservation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImagingObservation" maxOccurs="unbounded" minOccurs="0"/>
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
        "imagingObservation"
    })
    public static class ImagingObservationCollection {

        @XmlElement(name = "ImagingObservation")
        protected List<ImagingObservation> imagingObservation;

        /**
         * Gets the value of the imagingObservation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imagingObservation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImagingObservation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImagingObservation }
         * 
         * 
         */
        public List<ImagingObservation> getImagingObservation() {
            if (imagingObservation == null) {
                imagingObservation = new ArrayList<ImagingObservation>();
            }
            return this.imagingObservation;
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
     *         &lt;element name="User" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}User" minOccurs="0"/>
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
        "user"
    })
    public static class User {

        @XmlElement(name = "User")
        protected gme.cacore_cacore._3_2.edu_northwestern_radiology.User user;

        /**
         * Gets the value of the user property.
         * 
         * @return
         *     possible object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.User }
         *     
         */
        public gme.cacore_cacore._3_2.edu_northwestern_radiology.User getUser() {
            return user;
        }

        /**
         * Sets the value of the user property.
         * 
         * @param value
         *     allowed object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.User }
         *     
         */
        public void setUser(gme.cacore_cacore._3_2.edu_northwestern_radiology.User value) {
            this.user = value;
        }

    }

}
