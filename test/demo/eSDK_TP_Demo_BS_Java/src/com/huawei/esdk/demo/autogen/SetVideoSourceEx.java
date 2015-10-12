
package com.huawei.esdk.demo.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="confId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="siteUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="videoSourceUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isLock" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "confId",
    "siteUri",
    "videoSourceUri",
    "isLock"
})
@XmlRootElement(name = "setVideoSourceEx")
public class SetVideoSourceEx {

    @XmlElement(required = true)
    protected String confId;
    @XmlElement(required = true)
    protected String siteUri;
    @XmlElement(required = true)
    protected String videoSourceUri;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer isLock;

    /**
     * Gets the value of the confId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfId() {
        return confId;
    }

    /**
     * Sets the value of the confId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfId(String value) {
        this.confId = value;
    }

    /**
     * Gets the value of the siteUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteUri() {
        return siteUri;
    }

    /**
     * Sets the value of the siteUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteUri(String value) {
        this.siteUri = value;
    }

    /**
     * Gets the value of the videoSourceUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoSourceUri() {
        return videoSourceUri;
    }

    /**
     * Sets the value of the videoSourceUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoSourceUri(String value) {
        this.videoSourceUri = value;
    }

    /**
     * Gets the value of the isLock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsLock() {
        return isLock;
    }

    /**
     * Sets the value of the isLock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLock(Integer value) {
        this.isLock = value;
    }

}
