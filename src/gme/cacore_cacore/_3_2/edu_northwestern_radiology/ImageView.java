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
 * <p>Java class for ImageView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ImageView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageViewModifierCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ImageViewModifier" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImageViewModifier" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="codeSequence">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CodeSequence" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}CodeSequence"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageView", propOrder = {
    "imageViewModifierCollection",
    "codeSequence"
})
public class ImageView {

    protected ImageView.ImageViewModifierCollection imageViewModifierCollection;
    @XmlElement(required = true)
    protected ImageView.CodeSequence codeSequence;
    @XmlAttribute(required = true)
    protected BigInteger id;

    /**
     * Gets the value of the imageViewModifierCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ImageView.ImageViewModifierCollection }
     *     
     */
    public ImageView.ImageViewModifierCollection getImageViewModifierCollection() {
        return imageViewModifierCollection;
    }

    /**
     * Sets the value of the imageViewModifierCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageView.ImageViewModifierCollection }
     *     
     */
    public void setImageViewModifierCollection(ImageView.ImageViewModifierCollection value) {
        this.imageViewModifierCollection = value;
    }

    /**
     * Gets the value of the codeSequence property.
     * 
     * @return
     *     possible object is
     *     {@link ImageView.CodeSequence }
     *     
     */
    public ImageView.CodeSequence getCodeSequence() {
        return codeSequence;
    }

    /**
     * Sets the value of the codeSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageView.CodeSequence }
     *     
     */
    public void setCodeSequence(ImageView.CodeSequence value) {
        this.codeSequence = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CodeSequence" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}CodeSequence"/>
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
        "codeSequence"
    })
    public static class CodeSequence {

        @XmlElement(name = "CodeSequence", required = true)
        protected gme.cacore_cacore._3_2.edu_northwestern_radiology.CodeSequence codeSequence;

        /**
         * Gets the value of the codeSequence property.
         * 
         * @return
         *     possible object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.CodeSequence }
         *     
         */
        public gme.cacore_cacore._3_2.edu_northwestern_radiology.CodeSequence getCodeSequence() {
            return codeSequence;
        }

        /**
         * Sets the value of the codeSequence property.
         * 
         * @param value
         *     allowed object is
         *     {@link gme.cacore_cacore._3_2.edu_northwestern_radiology.CodeSequence }
         *     
         */
        public void setCodeSequence(gme.cacore_cacore._3_2.edu_northwestern_radiology.CodeSequence value) {
            this.codeSequence = value;
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
     *         &lt;element name="ImageViewModifier" type="{gme://caCORE.caCORE/3.2/edu.northwestern.radiology.AIM}ImageViewModifier" maxOccurs="unbounded" minOccurs="0"/>
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
        "imageViewModifier"
    })
    public static class ImageViewModifierCollection {

        @XmlElement(name = "ImageViewModifier")
        protected List<ImageViewModifier> imageViewModifier;

        /**
         * Gets the value of the imageViewModifier property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the imageViewModifier property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImageViewModifier().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ImageViewModifier }
         * 
         * 
         */
        public List<ImageViewModifier> getImageViewModifier() {
            if (imageViewModifier == null) {
                imageViewModifier = new ArrayList<ImageViewModifier>();
            }
            return this.imageViewModifier;
        }

    }

}
