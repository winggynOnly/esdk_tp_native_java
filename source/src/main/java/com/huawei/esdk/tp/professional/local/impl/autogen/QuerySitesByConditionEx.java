
package com.huawei.esdk.tp.professional.local.impl.autogen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.huawei.esdk.tp.professional.local.bean.QueryConfigEx;


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
 *         &lt;element name="queryConfig" type="{http://smc.huawei.com/}QueryConfigEx"/>
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
    "queryConfig"
})
@XmlRootElement(name = "querySitesByConditionEx")
public class QuerySitesByConditionEx {

    @XmlElement(required = true)
    protected QueryConfigEx queryConfig;

    /**
     * Gets the value of the queryConfig property.
     * 
     * @return
     *     possible object is
     *     {@link QueryConfigEx }
     *     
     */
    public QueryConfigEx getQueryConfig() {
        return queryConfig;
    }

    /**
     * Sets the value of the queryConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryConfigEx }
     *     
     */
    public void setQueryConfig(QueryConfigEx value) {
        this.queryConfig = value;
    }

}
