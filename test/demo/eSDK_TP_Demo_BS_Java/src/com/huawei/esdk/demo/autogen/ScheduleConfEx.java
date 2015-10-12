
package com.huawei.esdk.demo.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="scheduleConf" type="{http://smc.huawei.com/}ConferenceInfoEx"/>
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
    "scheduleConf"
})
@XmlRootElement(name = "scheduleConfEx")
public class ScheduleConfEx {

    @XmlElement(required = true)
    protected ConferenceInfoEx scheduleConf;

    /**
     * Gets the value of the scheduleConf property.
     * 
     * @return
     *     possible object is
     *     {@link ConferenceInfoEx }
     *     
     */
    public ConferenceInfoEx getScheduleConf() {
        return scheduleConf;
    }

    /**
     * Sets the value of the scheduleConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConferenceInfoEx }
     *     
     */
    public void setScheduleConf(ConferenceInfoEx value) {
        this.scheduleConf = value;
    }

}
