
package com.huawei.esdk.tp.professional.local.impl.autogen;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="confId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="siteUris" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="isQuiet" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "siteUris",
    "isQuiet"
})
@XmlRootElement(name = "setSitesQuietEx")
public class SetSitesQuietEx {

    @XmlElement(required = true)
    protected String confId;
    @XmlElement(required = true)
    protected List<String> siteUris;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer isQuiet;

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
     * Gets the value of the siteUris property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteUris property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteUris().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSiteUris() {
        if (siteUris == null) {
            siteUris = new ArrayList<String>();
        }
        return this.siteUris;
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

}
