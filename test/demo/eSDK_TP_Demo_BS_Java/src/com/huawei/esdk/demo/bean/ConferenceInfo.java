package com.huawei.esdk.demo.bean;

import java.util.List;

import com.huawei.esdk.demo.autogen.ConferenceStatusEx;
import com.huawei.esdk.demo.autogen.SiteAccessInfoEx;
import com.huawei.esdk.demo.autogen.SiteInfoEx;
import com.huawei.esdk.demo.autogen.SiteStatusEx;


public class ConferenceInfo
{
    
    protected String confId;
    
    protected String name;
    
    protected String beginTime;
    
    protected String duration;
    
    protected String accessCode;
    
    protected String password;
    
    protected Integer mediaEncryptType;
    
    protected Integer auxVideoFormat;
    
    protected Integer auxVideoProtocol;
    
    protected Integer cpResouce;
    
    protected String rate;
    
    protected Integer isRecording;
    
    protected String recorderAddr;
    
    protected Integer isLiveBroadcast;
    
    protected Integer presentation;
    
    protected String status;
    
    protected String billCode;
    
    protected List<SiteInfoEx> sites;
    
    protected List<SiteStatusEx> siteList;
    
    protected ConferenceStatusEx confStatus;
    
    protected  List<SiteAccessInfoEx> sitesAccessInfos;

    public List<SiteAccessInfoEx> getSitesAccessInfos()
    {
        return sitesAccessInfos;
    }

    public void setSitesAccessInfos(List<SiteAccessInfoEx> sitesAccessInfos)
    {
        this.sitesAccessInfos = sitesAccessInfos;
    }

    public List<SiteStatusEx> getSiteList()
    {
        return siteList;
    }
    
    public void setSiteList(List<SiteStatusEx> siteList)
    {
        this.siteList = siteList;
    }
    
    public ConferenceStatusEx getConfStatus()
    {
        return confStatus;
    }
    
    public void setConfStatus(ConferenceStatusEx confStatus)
    {
        this.confStatus = confStatus;
    }
    
    public String getConfId()
    {
        return confId;
    }
    
    public void setConfId(String confId)
    {
        this.confId = confId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getBeginTime()
    {
        return beginTime;
    }
    
    public void setBeginTime(String beginTime)
    {
        this.beginTime = beginTime;
    }
    
    public String getDuration()
    {
        return duration;
    }
    
    public void setDuration(String duration)
    {
        this.duration = duration;
    }
    
    public String getAccessCode()
    {
        return accessCode;
    }
    
    public void setAccessCode(String accessCode)
    {
        this.accessCode = accessCode;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public Integer getMediaEncryptType()
    {
        return mediaEncryptType;
    }
    
    public void setMediaEncryptType(Integer mediaEncryptType)
    {
        this.mediaEncryptType = mediaEncryptType;
    }
    
    public Integer getAuxVideoFormat()
    {
        return auxVideoFormat;
    }
    
    public void setAuxVideoFormat(Integer auxVideoFormat)
    {
        this.auxVideoFormat = auxVideoFormat;
    }
    
    public Integer getAuxVideoProtocol()
    {
        return auxVideoProtocol;
    }
    
    public void setAuxVideoProtocol(Integer auxVideoProtocol)
    {
        this.auxVideoProtocol = auxVideoProtocol;
    }
    
    public Integer getCpResouce()
    {
        return cpResouce;
    }
    
    public void setCpResouce(Integer cpResouce)
    {
        this.cpResouce = cpResouce;
    }
    
    public String getRate()
    {
        return rate;
    }
    
    public void setRate(String rate)
    {
        this.rate = rate;
    }
    
    public Integer getIsRecording()
    {
        return isRecording;
    }
    
    public void setIsRecording(Integer isRecording)
    {
        this.isRecording = isRecording;
    }
    
    public String getRecorderAddr()
    {
        return recorderAddr;
    }
    
    public void setRecorderAddr(String recorderAddr)
    {
        this.recorderAddr = recorderAddr;
    }
    
    public Integer getIsLiveBroadcast()
    {
        return isLiveBroadcast;
    }
    
    public void setIsLiveBroadcast(Integer isLiveBroadcast)
    {
        this.isLiveBroadcast = isLiveBroadcast;
    }
    
    public Integer getPresentation()
    {
        return presentation;
    }
    
    public void setPresentation(Integer presentation)
    {
        this.presentation = presentation;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public String getBillCode()
    {
        return billCode;
    }
    
    public void setBillCode(String billCode)
    {
        this.billCode = billCode;
    }
    
    public List<SiteInfoEx> getSites()
    {
        return sites;
    }
    
    public void setSites(List<SiteInfoEx> sites)
    {
        this.sites = sites;
    }
    
}
