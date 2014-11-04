
package com.huawei.esdk.tp.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter4;


/**
 * <p>Java class for DoubleFilterEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DoubleFilterEx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://smc.huawei.com/}FiltersEx">
 *       &lt;sequence>
 *         &lt;element name="greaterThan" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lessThan" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="equalTo" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoubleFilterEx", propOrder = {
    "greaterThan",
    "lessThan",
    "equalTo"
})
public class DoubleFilterEx
    extends FiltersEx
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "double")
    protected Double greaterThan;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "double")
    protected Double lessThan;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter4 .class)
    @XmlSchemaType(name = "double")
    protected Double equalTo;

    /**
     * Gets the value of the greaterThan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getGreaterThan() {
        return greaterThan;
    }

    /**
     * Sets the value of the greaterThan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreaterThan(Double value) {
        this.greaterThan = value;
    }

    /**
     * Gets the value of the lessThan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getLessThan() {
        return lessThan;
    }

    /**
     * Sets the value of the lessThan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLessThan(Double value) {
        this.lessThan = value;
    }

    /**
     * Gets the value of the equalTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getEqualTo() {
        return equalTo;
    }

    /**
     * Sets the value of the equalTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqualTo(Double value) {
        this.equalTo = value;
    }

}
