
package com.huawei.esdk.tp.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;


/**
 * <p>Java class for CameraControlEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CameraControlEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="camState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="camAction" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="camPos" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="camSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraControlEx", propOrder = {
    "camState",
    "camAction",
    "camPos",
    "camSrc"
})
public class CameraControlEx {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer camState;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer camAction;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer camPos;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer camSrc;

    /**
     * Gets the value of the camState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCamState() {
        return camState;
    }

    /**
     * Sets the value of the camState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamState(Integer value) {
        this.camState = value;
    }

    /**
     * Gets the value of the camAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCamAction() {
        return camAction;
    }

    /**
     * Sets the value of the camAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamAction(Integer value) {
        this.camAction = value;
    }

    /**
     * Gets the value of the camPos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCamPos() {
        return camPos;
    }

    /**
     * Sets the value of the camPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamPos(Integer value) {
        this.camPos = value;
    }

    /**
     * Gets the value of the camSrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCamSrc() {
        return camSrc;
    }

    /**
     * Sets the value of the camSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamSrc(Integer value) {
        this.camSrc = value;
    }

}
