
package com.huawei.esdk.tp.professional.local.impl.autogen;

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
 *         &lt;element name="encryptPassword" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
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
    "encryptPassword"
})
@XmlRootElement(name = "Authenticate")
public class Authenticate {

    @XmlElement(required = true)
    protected byte[] encryptPassword;

    /**
     * Gets the value of the encryptPassword property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getEncryptPassword() {
        return encryptPassword;
    }

    /**
     * Sets the value of the encryptPassword property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setEncryptPassword(byte[] value) {
        this.encryptPassword = value;
    }

}
