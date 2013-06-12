/*
Copyright (c) 2013, Washington University in St.Louis.
All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.17 at 06:25:05 AM BST 
//


package gme.cacore_cacore._3_2.edu_northwestern_radiology;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalculationResultIdentifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CalculationResultIdentifier">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Scalar"/>
 *     &lt;enumeration value="Vector"/>
 *     &lt;enumeration value="Histogram"/>
 *     &lt;enumeration value="Matrix"/>
 *     &lt;enumeration value="Array"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CalculationResultIdentifier")
@XmlEnum
public enum CalculationResultIdentifier {

    @XmlEnumValue("Scalar")
    SCALAR("Scalar"),
    @XmlEnumValue("Vector")
    VECTOR("Vector"),
    @XmlEnumValue("Histogram")
    HISTOGRAM("Histogram"),
    @XmlEnumValue("Matrix")
    MATRIX("Matrix"),
    @XmlEnumValue("Array")
    ARRAY("Array");
    private final String value;

    CalculationResultIdentifier(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CalculationResultIdentifier fromValue(String v) {
        for (CalculationResultIdentifier c: CalculationResultIdentifier.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
