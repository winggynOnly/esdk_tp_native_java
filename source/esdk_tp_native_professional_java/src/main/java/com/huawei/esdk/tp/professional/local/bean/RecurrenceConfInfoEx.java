
package com.huawei.esdk.tp.professional.local.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter1;
import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;


/**
 * <p>Java class for RecurrenceConfInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecurrenceConfInfoEx">
 *   &lt;complexContent>
 *     &lt;extension base="{http://smc.huawei.com/}ConferenceInfoEx">
 *       &lt;sequence>
 *         &lt;element name="frequency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="interval" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="weekDays" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="weekDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="monthDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="siteAccessInfos" type="{http://smc.huawei.com/}SiteAccessInfoEx" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecurrenceConfInfoEx", propOrder = {
    "frequency",
    "interval",
    "weekDays",
    "weekDay",
    "monthDay",
    "count",
    "endDate",
    "siteAccessInfos"
})
public class RecurrenceConfInfoEx
    extends ConferenceInfoEx
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer frequency;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer interval;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected List<Integer> weekDays;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer weekDay;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer monthDay;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer count;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Date endDate;
    protected List<SiteAccessInfoEx> siteAccessInfos;

    /**
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequency(Integer value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterval(Integer value) {
        this.interval = value;
    }

    /**
     * Gets the value of the weekDays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weekDays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeekDays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<Integer> getWeekDays() {
        if (weekDays == null) {
            weekDays = new ArrayList<Integer>();
        }
        return this.weekDays;
    }

    /**
     * Gets the value of the weekDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getWeekDay() {
        return weekDay;
    }

    /**
     * Sets the value of the weekDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeekDay(Integer value) {
        this.weekDay = value;
    }

    /**
     * Gets the value of the monthDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getMonthDay() {
        return monthDay;
    }

    /**
     * Sets the value of the monthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthDay(Integer value) {
        this.monthDay = value;
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(Date value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the siteAccessInfos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the siteAccessInfos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSiteAccessInfos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SiteAccessInfoEx }
     * 
     * 
     */
    public List<SiteAccessInfoEx> getSiteAccessInfos() {
        if (siteAccessInfos == null) {
            siteAccessInfos = new ArrayList<SiteAccessInfoEx>();
        }
        return this.siteAccessInfos;
    }

	public void setWeekDays(List<Integer> weekDays) {
		this.weekDays = weekDays;
	}

	public void setSiteAccessInfos(List<SiteAccessInfoEx> siteAccessInfos) {
		this.siteAccessInfos = siteAccessInfos;
	}

}
