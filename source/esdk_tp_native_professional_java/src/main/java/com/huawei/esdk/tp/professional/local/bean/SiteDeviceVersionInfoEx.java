
package com.huawei.esdk.tp.professional.local.bean;

import java.util.Map;

public class SiteDeviceVersionInfoEx {

    protected String model;
    protected String license;
    protected String softVersion;
    protected String hardVersion;
    protected String logicVersion;
    protected Map<String,String> micVersion;
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
     * Gets the value of the lisence property.
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
     * Sets the value of the lisence property.
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
     * Gets the value of the micVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the micVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMicVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VersionMap }
     * 
     * 
     */
    public Map<String,String> getMicVersion() {
        return this.micVersion;
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
    
    /**
     * Sets the value of the micVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link VersionMap }
     *     
     */
	public void setMicVersion(Map<String,String> micVersion) {
		this.micVersion = micVersion;
	}

}
