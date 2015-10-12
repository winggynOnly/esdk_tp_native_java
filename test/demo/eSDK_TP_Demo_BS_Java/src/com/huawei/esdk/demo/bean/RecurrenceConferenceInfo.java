package com.huawei.esdk.demo.bean;

import java.util.List;
import java.util.Map;

import com.huawei.esdk.demo.autogen.SiteInfoEx;
import com.huawei.esdk.demo.autogen.SiteStatusEx;

public class RecurrenceConferenceInfo extends ConferenceInfo
{
    private Map<String, List<SiteInfoEx>> recurrenceMap;
    
    private List<SiteStatusEx> siteStatusList;
    
    public Map<String, List<SiteInfoEx>> getRecurrenceMap()
    {
        return recurrenceMap;
    }
    
    public void setRecurrenceMap(Map<String, List<SiteInfoEx>> recurrenceMap)
    {
        this.recurrenceMap = recurrenceMap;
    }
    
    public List<SiteStatusEx> getSiteStatusList()
    {
        return siteStatusList;
    }
    
    public void setSiteStatusList(List<SiteStatusEx> siteStatusList)
    {
        this.siteStatusList = siteStatusList;
    }
    
}
