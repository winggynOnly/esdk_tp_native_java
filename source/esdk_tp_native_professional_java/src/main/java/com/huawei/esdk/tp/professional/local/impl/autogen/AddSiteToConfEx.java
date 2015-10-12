
package com.huawei.esdk.tp.professional.local.impl.autogen;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;


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
 *         &lt;element name="siteInfo" type="{http://smc.huawei.com/}SiteInfoEx"/>
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
    "siteInfo",
    "beginTime"
})
@XmlRootElement(name = "addSiteToConfEx")
public class AddSiteToConfEx {

    @XmlElement(required = true)
    protected String confId;
    @XmlElement(required = true)
    protected SiteInfoEx siteInfo;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date beginTime;

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
     * Gets the value of the siteInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SiteInfoEx }
     *     
     */
    public SiteInfoEx getSiteInfo() {
        return siteInfo;
    }

    /**
     * Sets the value of the siteInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteInfoEx }
     *     
     */
    public void setSiteInfo(SiteInfoEx value) {
        this.siteInfo = value;
    }

    /**
     * Gets the value of the beginTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * Sets the value of the beginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginTime(Date value) {
        this.beginTime = value;
    }

}
