//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.17 at 09:07:21 AM CST 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnnotationOfAnnotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnotationOfAnnotation">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}Annotation">
 *       &lt;sequence>
 *         &lt;element name="referencedAnnotationCollection">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ReferencedAnnotation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ReferencedAnnotation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}AnnotationOfAnnotationIdentifier" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnotationOfAnnotation", propOrder = {
    "referencedAnnotationCollection"
})
public class AnnotationOfAnnotation
    extends Annotation
{

    @XmlElement(required = true)
    protected AnnotationOfAnnotation.ReferencedAnnotationCollection referencedAnnotationCollection;
    @XmlAttribute(required = true)
    protected AnnotationOfAnnotationIdentifier type;

    /**
     * Gets the value of the referencedAnnotationCollection property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationOfAnnotation.ReferencedAnnotationCollection }
     *     
     */
    public AnnotationOfAnnotation.ReferencedAnnotationCollection getReferencedAnnotationCollection() {
        return referencedAnnotationCollection;
    }

    /**
     * Sets the value of the referencedAnnotationCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationOfAnnotation.ReferencedAnnotationCollection }
     *     
     */
    public void setReferencedAnnotationCollection(AnnotationOfAnnotation.ReferencedAnnotationCollection value) {
        this.referencedAnnotationCollection = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationOfAnnotationIdentifier }
     *     
     */
    public AnnotationOfAnnotationIdentifier getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationOfAnnotationIdentifier }
     *     
     */
    public void setType(AnnotationOfAnnotationIdentifier value) {
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
     *         &lt;element name="ReferencedAnnotation" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ReferencedAnnotation" maxOccurs="unbounded"/>
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
        "referencedAnnotation"
    })
    public static class ReferencedAnnotationCollection {

        @XmlElement(name = "ReferencedAnnotation", required = true)
        protected List<ReferencedAnnotation> referencedAnnotation;

        /**
         * Gets the value of the referencedAnnotation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the referencedAnnotation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferencedAnnotation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReferencedAnnotation }
         * 
         * 
         */
        public List<ReferencedAnnotation> getReferencedAnnotation() {
            if (referencedAnnotation == null) {
                referencedAnnotation = new ArrayList<ReferencedAnnotation>();
            }
            return this.referencedAnnotation;
        }

    }

}
