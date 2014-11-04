
package com.huawei.esdk.tp.professional.local.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;


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
 *         &lt;element name="editConf" type="{http://smc.huawei.com/}RecurrenceConfInfoEx"/>
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
@XmlRootElement(name = "editRecurrenceConferenceEx")
public class EditRecurrenceConferenceEx {

    @XmlElement(required = true)
    protected RecurrenceConfInfoEx editConf;

    /**
     * Gets the value of the editConf property.
     * 
     * @return
     *     possible object is
     *     {@link RecurrenceConfInfoEx }
     *     
     */
    public RecurrenceConfInfoEx getEditConf() {
        return editConf;
    }

    /**
     * Sets the value of the editConf property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurrenceConfInfoEx }
     *     
     */
    public void setEditConf(RecurrenceConfInfoEx value) {
        this.editConf = value;
    }

}
