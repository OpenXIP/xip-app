
package org.nema.dicom.PS3_19;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element name="GetAvailableScreenResult" type="{http://dicom.nema.org/PS3.19/HostService-20100825}Rectangle" minOccurs="0"/>
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
    "getAvailableScreenResult"
})
@XmlRootElement(name = "GetAvailableScreenResponse")
public class GetAvailableScreenResponse {

    @XmlElement(name = "GetAvailableScreenResult", nillable = true)
    protected Rectangle getAvailableScreenResult;

    /**
     * Gets the value of the getAvailableScreenResult property.
     * 
     * @return
     *     possible object is
     *     {@link Rectangle }
     *     
     */
    public Rectangle getGetAvailableScreenResult() {
        return getAvailableScreenResult;
    }

    /**
     * Sets the value of the getAvailableScreenResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rectangle }
     *     
     */
    public void setGetAvailableScreenResult(Rectangle value) {
        this.getAvailableScreenResult = value;
    }

}
