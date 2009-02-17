//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.02.17 at 09:07:21 AM CST 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ImageAnnotationIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ImageAnnotationIdentifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RECIST_Baseline_Target_Lesion"/>
 *     &lt;enumeration value="RECIST_Baseline_Non-target_Lesion"/>
 *     &lt;enumeration value="RECIST_Fellow-up_Target_Lesion"/>
 *     &lt;enumeration value="RECIST_Fellow-up_Non-target_Lesion"/>
 *     &lt;enumeration value="LIDC_Chest_CT_Nodule"/>
 *     &lt;enumeration value="Teaching"/>
 *     &lt;enumeration value="Quality_Control"/>
 *     &lt;enumeration value="Clinical_Finding"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Brain_Tumor_Baseline_Target_Lesion"/>
 *     &lt;enumeration value="Brain_Tumor_Baseline_Non-Target_Lesion"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ImageAnnotationIdentifier")
@XmlEnum
public enum ImageAnnotationIdentifier {

    @XmlEnumValue("RECIST_Baseline_Target_Lesion")
    RECIST_BASELINE_TARGET_LESION("RECIST_Baseline_Target_Lesion"),
    @XmlEnumValue("RECIST_Baseline_Non-target_Lesion")
    RECIST_BASELINE_NON_TARGET_LESION("RECIST_Baseline_Non-target_Lesion"),
    @XmlEnumValue("RECIST_Fellow-up_Target_Lesion")
    RECIST_FELLOW_UP_TARGET_LESION("RECIST_Fellow-up_Target_Lesion"),
    @XmlEnumValue("RECIST_Fellow-up_Non-target_Lesion")
    RECIST_FELLOW_UP_NON_TARGET_LESION("RECIST_Fellow-up_Non-target_Lesion"),
    @XmlEnumValue("LIDC_Chest_CT_Nodule")
    LIDC_CHEST_CT_NODULE("LIDC_Chest_CT_Nodule"),
    @XmlEnumValue("Teaching")
    TEACHING("Teaching"),
    @XmlEnumValue("Quality_Control")
    QUALITY_CONTROL("Quality_Control"),
    @XmlEnumValue("Clinical_Finding")
    CLINICAL_FINDING("Clinical_Finding"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Brain_Tumor_Baseline_Target_Lesion")
    BRAIN_TUMOR_BASELINE_TARGET_LESION("Brain_Tumor_Baseline_Target_Lesion"),
    @XmlEnumValue("Brain_Tumor_Baseline_Non-Target_Lesion")
    BRAIN_TUMOR_BASELINE_NON_TARGET_LESION("Brain_Tumor_Baseline_Non-Target_Lesion");
    private final String value;

    ImageAnnotationIdentifier(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ImageAnnotationIdentifier fromValue(String v) {
        for (ImageAnnotationIdentifier c: ImageAnnotationIdentifier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
