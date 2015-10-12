
package com.huawei.esdk.demo.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for BroadInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BroadInfoEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="directBroad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recordBroad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="directBroadStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="recordBroadStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BroadInfoEx", propOrder = {
    "directBroad",
    "recordBroad",
    "directBroadStatus",
    "recordBroadStatus"
})
public class BroadInfoEx {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer directBroad;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer recordBroad;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer directBroadStatus;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer recordBroadStatus;

    /**
     * Gets the value of the directBroad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDirectBroad() {
        return directBroad;
    }

    /**
     * Sets the value of the directBroad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectBroad(Integer value) {
        this.directBroad = value;
    }

    /**
     * Gets the value of the recordBroad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRecordBroad() {
        return recordBroad;
    }

    /**
     * Sets the value of the recordBroad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordBroad(Integer value) {
        this.recordBroad = value;
    }

    /**
     * Gets the value of the directBroadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getDirectBroadStatus() {
        return directBroadStatus;
    }

    /**
     * Sets the value of the directBroadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirectBroadStatus(Integer value) {
        this.directBroadStatus = value;
    }

    /**
     * Gets the value of the recordBroadStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getRecordBroadStatus() {
        return recordBroadStatus;
    }

    /**
     * Sets the value of the recordBroadStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordBroadStatus(Integer value) {
        this.recordBroadStatus = value;
    }

}
