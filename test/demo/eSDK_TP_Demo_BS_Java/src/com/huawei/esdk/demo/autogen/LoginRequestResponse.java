
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
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="randomSequence" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="hashType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "resultCode",
    "randomSequence",
    "hashType"
})
@XmlRootElement(name = "LoginRequestResponse")
public class LoginRequestResponse {

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer resultCode;
    protected byte[] randomSequence;
    protected String hashType;

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(Integer value) {
        this.resultCode = value;
    }

    /**
     * Gets the value of the randomSequence property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getRandomSequence() {
        return randomSequence;
    }

    /**
     * Sets the value of the randomSequence property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setRandomSequence(byte[] value) {
        this.randomSequence = value;
    }

    /**
     * Gets the value of the hashType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHashType() {
        return hashType;
    }

    /**
     * Sets the value of the hashType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHashType(String value) {
        this.hashType = value;
    }

}
