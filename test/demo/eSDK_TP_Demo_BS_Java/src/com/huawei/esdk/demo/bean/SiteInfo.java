package com.huawei.esdk.demo.bean;

import java.util.Date;

public class SiteInfo
{
    private Date beginTime;
    
    private String span;
    
    private Integer resultCode;
    
    private Integer siteInConfStatus;
    
    public Date getBeginTime()
    {
        return beginTime;
    }
    
    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }
    
    public String getSpan()
    {
        return span;
    }
    
    public void setSpan(String span)
    {
        this.span = span;
    }
    
    public Integer getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(Integer resultCode)
    {
        this.resultCode = resultCode;
    }

    public Integer getSiteInConfStatus()
    {
        return siteInConfStatus;
    }

    public void setSiteInConfStatus(Integer siteInConfStatus)
    {
        this.siteInConfStatus = siteInConfStatus;
    }
    
}
