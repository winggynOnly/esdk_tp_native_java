
package com.huawei.esdk.tp.professional.local.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;


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
 *         &lt;element name="editConf" type="{http://smc.huawei.com/}ConferenceInfoEx"/>
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
    "editConf"
})
@XmlRootElement(name = "editScheduledConfEx")
public class EditScheduledConfEx {

    @XmlElement(required = true)
    protected ConferenceInfoEx editConf;

    /**
     * Gets the value of the editConf property.
     * 
     * @return
     *     possible object is
     *     {@link ConferenceInfoEx }
     *     
     */
    public ConferenceInfoEx getEditConf() {
        return editConf;
    }

    /**
     * Sets the value of the editConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConferenceInfoEx }
     *     
     */
    public void setEditConf(ConferenceInfoEx value) {
        this.editConf = value;
    }

}
