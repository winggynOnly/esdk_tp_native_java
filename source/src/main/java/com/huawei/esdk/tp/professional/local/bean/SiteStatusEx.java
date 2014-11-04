package com.huawei.esdk.tp.professional.local.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;

/**
 * <p>Java class for SiteStatusEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteStatusEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="videoSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isMute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isQuiet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsLocalVideoOpen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="callFailedReson" type="{http://smc.huawei.com/}ErrorInfoEx" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteStatusEx", propOrder = {
    "uri",
    "name",
    "status",
    "volume",
    "videoSource",
    "isMute",
    "isQuiet",
    "type",
    "isLocalVideoOpen",
    "callFailedReson"
})
public class SiteStatusEx {

    protected String uri;
    protected String name;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer status;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer volume;
    protected String videoSource;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isMute;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isQuiet;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer type;
    @XmlElement(name = "IsLocalVideoOpen", type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isLocalVideoOpen;
    protected ErrorInfoEx callFailedReson;

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolume(Integer value) {
        this.volume = value;
    }

    /**
     * Gets the value of the videoSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVideoSource() {
        return videoSource;
    }

    /**
     * Sets the value of the videoSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVideoSource(String value) {
        this.videoSource = value;
    }

    /**
     * Gets the value of the isMute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsMute() {
        return isMute;
    }

    /**
     * Sets the value of the isMute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsMute(Integer value) {
        this.isMute = value;
    }

    /**
     * Gets the value of the isQuiet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsQuiet() {
        return isQuiet;
    }

    /**
     * Sets the value of the isQuiet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsQuiet(Integer value) {
        this.isQuiet = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /**
     * Gets the value of the isLocalVideoOpen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsLocalVideoOpen() {
        return isLocalVideoOpen;
    }

    /**
     * Sets the value of the isLocalVideoOpen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLocalVideoOpen(Integer value) {
        this.isLocalVideoOpen = value;
    }

    /**
     * Gets the value of the callFailedReson property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorInfoEx }
     *     
     */
    public ErrorInfoEx getCallFailedReson() {
        return callFailedReson;
    }

    /**
     * Sets the value of the callFailedReson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorInfoEx }
     *     
     */
    public void setCallFailedReson(ErrorInfoEx value) {
        this.callFailedReson = value;
    }

}
