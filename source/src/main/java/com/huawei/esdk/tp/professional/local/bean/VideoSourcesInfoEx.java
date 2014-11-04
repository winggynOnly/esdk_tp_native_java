
package com.huawei.esdk.tp.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;


/**
 * <p>Java class for VideoSourcesInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoSourcesInfoEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sourcesId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourcesState" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sourcesName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoSourcesInfoEx", propOrder = {
    "sourcesId",
    "sourcesState",
    "sourcesName"
})
public class VideoSourcesInfoEx {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer sourcesId;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer sourcesState;
    protected String sourcesName;

    /**
     * Gets the value of the sourcesId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSourcesId() {
        return sourcesId;
    }

    /**
     * Sets the value of the sourcesId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcesId(Integer value) {
        this.sourcesId = value;
    }

    /**
     * Gets the value of the sourcesState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getSourcesState() {
        return sourcesState;
    }

    /**
     * Sets the value of the sourcesState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcesState(Integer value) {
        this.sourcesState = value;
    }

    /**
     * Gets the value of the sourcesName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourcesName() {
        return sourcesName;
    }

    /**
     * Sets the value of the sourcesName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourcesName(String value) {
        this.sourcesName = value;
    }

}
