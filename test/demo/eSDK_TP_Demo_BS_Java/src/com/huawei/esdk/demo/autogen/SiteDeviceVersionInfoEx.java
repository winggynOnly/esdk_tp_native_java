
package com.huawei.esdk.demo.autogen;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiteDeviceVersionInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteDeviceVersionInfoEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="license" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="softVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hardVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logicVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="micVersions" type="{http://smc.huawei.com/}SiteMicVersionMapEx" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="manufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteDeviceVersionInfoEx", propOrder = {
    "model",
    "license",
    "softVersion",
    "hardVersion",
    "logicVersion",
    "micVersions",
    "manufacturer"
})
public class SiteDeviceVersionInfoEx {

    protected String model;
    protected String license;
    protected String softVersion;
    protected String hardVersion;
    protected String logicVersion;
    protected List<SiteMicVersionMapEx> micVersions;
    protected String manufacturer;

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicense(String value) {
        this.license = value;
    }

    /**
     * Gets the value of the softVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftVersion() {
        return softVersion;
    }

    /**
     * Sets the value of the softVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftVersion(String value) {
        this.softVersion = value;
    }

    /**
     * Gets the value of the hardVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHardVersion() {
        return hardVersion;
    }

    /**
     * Sets the value of the hardVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHardVersion(String value) {
        this.hardVersion = value;
    }

    /**
     * Gets the value of the logicVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogicVersion() {
        return logicVersion;
    }

    /**
     * Sets the value of the logicVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogicVersion(String value) {
        this.logicVersion = value;
    }

    /**
     * Gets the value of the micVersions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the micVersions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMicVersions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SiteMicVersionMapEx }
     * 
     * 
     */
    public List<SiteMicVersionMapEx> getMicVersions() {
        if (micVersions == null) {
            micVersions = new ArrayList<SiteMicVersionMapEx>();
        }
        return this.micVersions;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

}
