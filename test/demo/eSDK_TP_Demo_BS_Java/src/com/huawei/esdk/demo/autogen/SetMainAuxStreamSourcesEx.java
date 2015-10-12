
package com.huawei.esdk.demo.autogen;

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
 *         &lt;element name="siteUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="localMainSrcs" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *         &lt;element name="localAuxSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "siteUri",
    "localMainSrcs",
    "localAuxSrc"
})
@XmlRootElement(name = "setMainAuxStreamSourcesEx")
public class SetMainAuxStreamSourcesEx {

    @XmlElement(required = true)
    protected String siteUri;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected List<Integer> localMainSrcs;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "int")
    protected Integer localAuxSrc;

    /**
     * Gets the value of the siteUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteUri() {
        return siteUri;
    }

    /**
     * Sets the value of the siteUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteUri(String value) {
        this.siteUri = value;
    }

    /**
     * Gets the value of the localMainSrcs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localMainSrcs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalMainSrcs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<Integer> getLocalMainSrcs() {
        if (localMainSrcs == null) {
            localMainSrcs = new ArrayList<Integer>();
        }
        return this.localMainSrcs;
    }

    /**
     * Gets the value of the localAuxSrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getLocalAuxSrc() {
        return localAuxSrc;
    }

    /**
     * Sets the value of the localAuxSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalAuxSrc(Integer value) {
        this.localAuxSrc = value;
    }

}
