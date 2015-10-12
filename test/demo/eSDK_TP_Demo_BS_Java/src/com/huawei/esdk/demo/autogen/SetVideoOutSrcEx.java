
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
 *         &lt;element name="siteUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hdOut" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="videoSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "siteUri",
    "hdOut",
    "videoSrc"
})
@XmlRootElement(name = "setVideoOutSrcEx")
public class SetVideoOutSrcEx {

    @XmlElement(required = true)
    protected String siteUri;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer hdOut;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer videoSrc;

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
     * Gets the value of the hdOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getHdOut() {
        return hdOut;
    }

    /**
     * Sets the value of the hdOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdOut(Integer value) {
        this.hdOut = value;
    }

    /**
     * Gets the value of the videoSrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getVideoSrc() {
        return videoSrc;
    }

    /**
     * Sets the value of the videoSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoSrc(Integer value) {
        this.videoSrc = value;
    }

}
