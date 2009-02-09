//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.10.28 at 10:12:54 AM CDT 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImageAnnotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageAnnotation">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Annotation">
 *       &lt;sequence>
 *         &lt;element name="imageReferenceCollection">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ImageReference" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImageReference" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="probabilityMapCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProbabilityMap" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ProbabilityMap" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="geometricShapeCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="GeometricShape" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}GeometricShape" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="patient" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Patient" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Patient" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="textAnnotationCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TextAnnotation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}TextAnnotation" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="imageAnnotationType" use="required" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImageAnnotationIdentifier" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageAnnotation", propOrder = {
    "imageReferenceCollection",
    "probabilityMapCollection",
    "geometricShapeCollection",
    "patient",
    "textAnnotationCollection"
})
public class ImageAnnotation
    extends Annotation
{

    @XmlElement(required = true)
    protected ImageAnnotation.ImageReferenceCollection imageReferenceCollection;
    protected ImageAnnotation.ProbabilityMapCollection probabilityMapCollection;
    protected ImageAnnotation.GeometricShapeCollection geometricShapeCollection;
    protected ImageAnnotation.Patient patient;
    protected ImageAnnotation.TextAnnotationCollection textAnnotationCollection;
    @XmlAttribute(required = true)
    protected ImageAnnotationIdentifier imageAnnotationType;

    /**
     * Gets the value of the imageReferenceCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotation.ImageReferenceCollection }
     *     
     */
    public ImageAnnotation.ImageReferenceCollection getImageReferenceCollection() {
        return imageReferenceCollection;
    }

    /**
     * Sets the value of the imageReferenceCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotation.ImageReferenceCollection }
     *     
     */
    public void setImageReferenceCollection(ImageAnnotation.ImageReferenceCollection value) {
        this.imageReferenceCollection = value;
    }

    /**
     * Gets the value of the probabilityMapCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotation.ProbabilityMapCollection }
     *     
     */
    public ImageAnnotation.ProbabilityMapCollection getProbabilityMapCollection() {
        return probabilityMapCollection;
    }

    /**
     * Sets the value of the probabilityMapCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotation.ProbabilityMapCollection }
     *     
     */
    public void setProbabilityMapCollection(ImageAnnotation.ProbabilityMapCollection value) {
        this.probabilityMapCollection = value;
    }

    /**
     * Gets the value of the geometricShapeCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotation.GeometricShapeCollection }
     *     
     */
    public ImageAnnotation.GeometricShapeCollection getGeometricShapeCollection() {
        return geometricShapeCollection;
    }

    /**
     * Sets the value of the geometricShapeCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotation.GeometricShapeCollection }
     *     
     */
    public void setGeometricShapeCollection(ImageAnnotation.GeometricShapeCollection value) {
        this.geometricShapeCollection = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotation.Patient }
     *     
     */
    public ImageAnnotation.Patient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotation.Patient }
     *     
     */
    public void setPatient(ImageAnnotation.Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the textAnnotationCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotation.TextAnnotationCollection }
     *     
     */
    public ImageAnnotation.TextAnnotationCollection getTextAnnotationCollection() {
        return textAnnotationCollection;
    }

    /**
     * Sets the value of the textAnnotationCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotation.TextAnnotationCollection }
     *     
     */
    public void setTextAnnotationCollection(ImageAnnotation.TextAnnotationCollection value) {
        this.textAnnotationCollection = value;
    }

    /**
     * Gets the value of the imageAnnotationType property.
     * 
     * @return
     *     possible object is
     *     {@link ImageAnnotationIdentifier }
     *     
     */
    public ImageAnnotationIdentifier getImageAnnotationType() {
        return imageAnnotationType;
    }

    /**
     * Sets the value of the imageAnnotationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageAnnotationIdentifier }
     *     
     */
    public void setImageAnnotationType(ImageAnnotationIdentifier value) {
        this.imageAnnotationType = value;
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
     *         &lt;element name="GeometricShape" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}GeometricShape" maxOccurs="unbounded" minOccurs="0"/>
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
        "geometricShape"
    })
    public static class GeometricShapeCollection {

        @XmlElement(name = "GeometricShape")
        protected List<GeometricShape> geometricShape;

        /**
         * Gets the value of the geometricShape property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the geometricShape property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGeometricShape().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GeometricShape }
         * 
         * 
         */
        public List<GeometricShape> getGeometricShape() {
            if (geometricShape == null) {
                geometricShape = new ArrayList<GeometricShape>();
            }
            return this.geometricShape;
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
     *         &lt;element name="ImageReference" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImageReference" maxOccurs="unbounded"/>
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
        "imageReference"
    })
    public static class ImageReferenceCollection {

        @XmlElement(name = "ImageReference", required = true)
        protected List<ImageReference> imageReference;

        /**
         * Gets the value of the imageReference property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imageReference property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImageReference().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImageReference }
         * 
         * 
         */
        public List<ImageReference> getImageReference() {
            if (imageReference == null) {
                imageReference = new ArrayList<ImageReference>();
            }
            return this.imageReference;
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
     *         &lt;element name="Patient" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Patient" minOccurs="0"/>
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
        "patient"
    })
    public static class Patient {

        @XmlElement(name = "Patient")
        protected gme.cacore_cacore._3_2.edu_northwestern_radiology.Patient patient;

        /**
         * Gets the value of the patient property.
         * 
         * @return
         *     possible object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.Patient }
         *     
         */
        public gme.cacore_cacore._3_2.edu_northwestern_radiology.Patient getPatient() {
            return patient;
        }

        /**
         * Sets the value of the patient property.
         * 
         * @param value
         *     allowed object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.Patient }
         *     
         */
        public void setPatient(gme.cacore_cacore._3_2.edu_northwestern_radiology.Patient value) {
            this.patient = value;
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
     *         &lt;element name="ProbabilityMap" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ProbabilityMap" maxOccurs="unbounded" minOccurs="0"/>
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
        "probabilityMap"
    })
    public static class ProbabilityMapCollection {

        @XmlElement(name = "ProbabilityMap")
        protected List<ProbabilityMap> probabilityMap;

        /**
         * Gets the value of the probabilityMap property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the probabilityMap property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProbabilityMap().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProbabilityMap }
         * 
         * 
         */
        public List<ProbabilityMap> getProbabilityMap() {
            if (probabilityMap == null) {
                probabilityMap = new ArrayList<ProbabilityMap>();
            }
            return this.probabilityMap;
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
     *         &lt;element name="TextAnnotation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}TextAnnotation" maxOccurs="unbounded" minOccurs="0"/>
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
        "textAnnotation"
    })
    public static class TextAnnotationCollection {

        @XmlElement(name = "TextAnnotation")
        protected List<TextAnnotation> textAnnotation;

        /**
         * Gets the value of the textAnnotation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the textAnnotation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTextAnnotation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextAnnotation }
         * 
         * 
         */
        public List<TextAnnotation> getTextAnnotation() {
            if (textAnnotation == null) {
                textAnnotation = new ArrayList<TextAnnotation>();
            }
            return this.textAnnotation;
        }

    }

}
