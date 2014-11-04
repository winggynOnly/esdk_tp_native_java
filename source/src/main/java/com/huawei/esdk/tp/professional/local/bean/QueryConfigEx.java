
package com.huawei.esdk.tp.professional.local.bean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.huawei.esdk.tp.professional.local.impl.autogen.Adapter3;


/**
 * <p>Java class for QueryConfigEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryConfigEx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sortItems" type="{http://smc.huawei.com/}SortItemsEx" maxOccurs="unbounded"/>
 *         &lt;element name="filters" type="{http://smc.huawei.com/}FiltersEx" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="focusItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pageParam" type="{http://smc.huawei.com/}PageParamEx"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryConfigEx", propOrder = {
    "sortItems",
    "filters",
    "focusItem",
    "pageParam"
})
public class QueryConfigEx {

    @XmlElement(required = true)
    protected List<SortItemsEx> sortItems;
    protected List<FiltersEx> filters;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter3 .class)
    @XmlSchemaType(name = "int")
    protected Integer focusItem;
    @XmlElement(required = true)
    protected PageParamEx pageParam;

    /**
     * Gets the value of the sortItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SortItemsEx }
     * 
     * 
     */
    public List<SortItemsEx> getSortItems() {
        if (sortItems == null) {
            sortItems = new ArrayList<SortItemsEx>();
        }
        return this.sortItems;
    }

    /**
     * Gets the value of the filters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FiltersEx }
     * 
     * 
     */
    public List<FiltersEx> getFilters() {
        if (filters == null) {
            filters = new ArrayList<FiltersEx>();
        }
        return this.filters;
    }

    /**
     * Gets the value of the focusItem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getFocusItem() {
        return focusItem;
    }

    /**
     * Sets the value of the focusItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFocusItem(Integer value) {
        this.focusItem = value;
    }

    /**
     * Gets the value of the pageParam property.
     * 
     * @return
     *     possible object is
     *     {@link PageParamEx }
     *     
     */
    public PageParamEx getPageParam() {
        return pageParam;
    }

    /**
     * Sets the value of the pageParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageParamEx }
     *     
     */
    public void setPageParam(PageParamEx value) {
        this.pageParam = value;
    }

    public void setSortItems(List<SortItemsEx> sortItems)
    {
        this.sortItems = sortItems;
    }

    public void setFilters(List<FiltersEx> filters)
    {
        this.filters = filters;
    }

}
