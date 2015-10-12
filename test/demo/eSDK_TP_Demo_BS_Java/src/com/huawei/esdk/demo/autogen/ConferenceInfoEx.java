
package com.huawei.esdk.demo.autogen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ConferenceInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConferenceInfoEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="accessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chairmanPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mediaEncryptType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="auxVideoFormat" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="auxVideoProtocol" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cpResouce" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRecording" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="recorderAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLiveBroadcast" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="presentation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="billCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sites" type="{http://smc.huawei.com/}SiteInfoEx" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConferenceInfoEx", propOrder = {
    "confId",
    "name",
    "beginTime",
    "duration",
    "accessCode",
    "password",
    "chairmanPassword",
    "mediaEncryptType",
    "auxVideoFormat",
    "auxVideoProtocol",
    "cpResouce",
    "rate",
    "isRecording",
    "recorderAddr",
    "isLiveBroadcast",
    "presentation",
    "status",
    "billCode",
    "sites"
})
@XmlSeeAlso({
    RecurrenceConfInfoEx.class
})
public class ConferenceInfoEx {

    protected String confId;
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar beginTime;
    protected Duration duration;
    protected String accessCode;
    protected String password;
    protected String chairmanPassword;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer mediaEncryptType;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer auxVideoFormat;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer auxVideoProtocol;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer cpResouce;
    protected String rate;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer isRecording;
    protected String recorderAddr;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer isLiveBroadcast;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer presentation;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer status;
    protected String billCode;
    protected List<SiteInfoEx> sites;

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
     * Gets the value of the beginTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginTime() {
        return beginTime;
    }

    /**
     * Sets the value of the beginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginTime(XMLGregorianCalendar value) {
        this.beginTime = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the accessCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * Sets the value of the accessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessCode(String value) {
        this.accessCode = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the chairmanPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChairmanPassword() {
        return chairmanPassword;
    }

    /**
     * Sets the value of the chairmanPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChairmanPassword(String value) {
        this.chairmanPassword = value;
    }

    /**
     * Gets the value of the mediaEncryptType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMediaEncryptType() {
        return mediaEncryptType;
    }

    /**
     * Sets the value of the mediaEncryptType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaEncryptType(Integer value) {
        this.mediaEncryptType = value;
    }

    /**
     * Gets the value of the auxVideoFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAuxVideoFormat() {
        return auxVideoFormat;
    }

    /**
     * Sets the value of the auxVideoFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuxVideoFormat(Integer value) {
        this.auxVideoFormat = value;
    }

    /**
     * Gets the value of the auxVideoProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getAuxVideoProtocol() {
        return auxVideoProtocol;
    }

    /**
     * Sets the value of the auxVideoProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuxVideoProtocol(Integer value) {
        this.auxVideoProtocol = value;
    }

    /**
     * Gets the value of the cpResouce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCpResouce() {
        return cpResouce;
    }

    /**
     * Sets the value of the cpResouce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpResouce(Integer value) {
        this.cpResouce = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * Gets the value of the isRecording property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsRecording() {
        return isRecording;
    }

    /**
     * Sets the value of the isRecording property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRecording(Integer value) {
        this.isRecording = value;
    }

    /**
     * Gets the value of the recorderAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecorderAddr() {
        return recorderAddr;
    }

    /**
     * Sets the value of the recorderAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecorderAddr(String value) {
        this.recorderAddr = value;
    }

    /**
     * Gets the value of the isLiveBroadcast property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getIsLiveBroadcast() {
        return isLiveBroadcast;
    }

    /**
     * Sets the value of the isLiveBroadcast property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLiveBroadcast(Integer value) {
        this.isLiveBroadcast = value;
    }

    /**
     * Gets the value of the presentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getPresentation() {
        return presentation;
    }

    /**
     * Sets the value of the presentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentation(Integer value) {
        this.presentation = value;
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
     * Gets the value of the billCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillCode() {
        return billCode;
    }

    /**
     * Sets the value of the billCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillCode(String value) {
        this.billCode = value;
    }

    /**
     * Gets the value of the sites property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sites property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSites().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SiteInfoEx }
     * 
     * 
     */
    public List<SiteInfoEx> getSites() {
        if (sites == null) {
            sites = new ArrayList<SiteInfoEx>();
        }
        return this.sites;
    }

}
