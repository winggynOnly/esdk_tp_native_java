
package com.huawei.esdk.tp.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;


/**
 * <p>Java class for IntFilterEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntFilterEx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://smc.huawei.com/}FiltersEx">
 *       &lt;sequence>
 *         &lt;element name="greaterThan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lessThan" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="equalTo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntFilterEx", propOrder = {
    "greaterThan",
    "lessThan",
    "equalTo"
})
public class IntFilterEx
    extends FiltersEx
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer greaterThan;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer lessThan;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer equalTo;

    /**
     * Gets the value of the greaterThan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getGreaterThan() {
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
    public void setGreaterThan(Integer value) {
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
    public Integer getLessThan() {
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
    public void setLessThan(Integer value) {
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
    public Integer getEqualTo() {
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
    public void setEqualTo(Integer value) {
        this.equalTo = value;
    }

}
