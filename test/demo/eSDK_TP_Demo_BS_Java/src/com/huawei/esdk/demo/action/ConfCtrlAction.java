package com.huawei.esdk.demo.action;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import com.huawei.esdk.demo.autogen.ConferenceStatusEx;
import com.huawei.esdk.demo.autogen.FreeBusyStateEx;
import com.huawei.esdk.demo.autogen.SiteStatusEx;
import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.bean.ConferenceInfo;
import com.huawei.esdk.demo.bean.SiteInfo;
import com.huawei.esdk.demo.common.BaseAction;
import com.huawei.esdk.demo.service.ConferenceService;
import com.huawei.esdk.demo.utils.DateUtils;
import com.huawei.esdk.demo.utils.DurationUtils;

public class ConfCtrlAction extends BaseAction
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -7983308152619117616L;
    
    private ConferenceService conferenceService = ConferenceService.getInstance() ;
    private String confId;
    private ConferenceInfo confInfo;
    
    private String siteUri;
    private Integer resultCode;
    private SiteInfo siteInfo;
    
    private List<String> confIds;
    
    public String queryConfById() 
    {
        List<String> confIds = new ArrayList<String>();
        confInfo = new ConferenceInfo();
        confIds.add(confId);
        TPSDKResponseEx<List<ConferenceStatusEx>>  resultEx = conferenceService.queryConferencesStatusEx(confIds);
        List<ConferenceStatusEx> list = resultEx.getResult();
        TPSDKResponseEx<List<SiteStatusEx>> result = conferenceService.queryConfSitesStatusEx(confId, null);
        if(0== result.getResultCode())
        {
            List<SiteStatusEx> siteList =  conferenceService.queryConfSitesStatusEx(confId, null).getResult();
            confInfo.setSiteList(siteList);
        }
        else
        {
           resultCode = result.getResultCode();
           return "error";
        }
        if(0 != resultEx.getResultCode())
        {
            return "error";
        }
        ConferenceStatusEx  confStatus = list.get(0);
        confInfo.setConfStatus(confStatus);
        resultCode = result.getResultCode();
        return "success";
    }
    
    public String  setBroadcastSite()
    {
        String isBroadcast = getRequest().getParameter("isBroadcast");
         resultCode = conferenceService.setBroadcastSiteEx(confId, siteUri, Integer.parseInt(isBroadcast));
        return "success";
    }
    public String  setSitesQuiet()
    {
        String isQuiet = getRequest().getParameter("isQuiet");
        List<String> sitesList = new ArrayList<String>();
        sitesList.add(siteUri);
         resultCode = conferenceService.setSitesQuietEx(confId, sitesList, Integer.parseInt(isQuiet));
        return "success";
    }
    public String setSitesMute()
    {
        String isMute = getRequest().getParameter("isMute");
        List<String> sitesList = new ArrayList<String>();
        sitesList.add(siteUri);
         resultCode = conferenceService.setSitesMuteEx(confId, sitesList, Integer.parseInt(isMute));
        return "success";
    }
    
    public String setBroadcastContinuousPresence()
    {
        String isBroadcastCP = getRequest().getParameter("isBroadcastCP");
        resultCode = conferenceService.setBroadcastContinuousPresenceEx(confId, Integer.parseInt(isBroadcastCP));
        return "success";
    }
    
    public  String setVideoSource()
    {
        Integer isLock = 0; 
        String videoSourceUri = getRequest().getParameter("videoSourceUri");
        resultCode = conferenceService.setVideoSourceEx(confId, siteUri, videoSourceUri, isLock);
        return "success";
    }
    
    public String querySiteStatus()
    {
        List<String> siteUris = new ArrayList<String>();
        siteInfo = new SiteInfo();
        siteUris.add(siteUri);
        Calendar time =Calendar.getInstance();  
        Date now = new Date();
        time.setTime(now);  
        time.set(Calendar.DATE, time.get(Calendar.DATE) - 1);
        String durationString = "PT3000M";
        Duration duration = null;
        try
        {
            duration = DatatypeFactory.newInstance().newDuration(durationString);
        }
        catch (DatatypeConfigurationException e)
        {
            return "error";
        }
        TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>>  response = conferenceService.querySiteStatusEx(siteUris, time.getTime(), duration);
        TPSDKResponseEx<List<SiteStatusEx>> result = conferenceService.queryConfSitesStatusEx(confId, siteUris);
        
        if(  0 != result.getResultCode())
        {
            siteInfo.setResultCode(result.getResultCode());
        }
        else
        {
            List<SiteStatusEx> sitesStatus = result.getResult();
            siteInfo.setResultCode(result.getResultCode());
            siteInfo.setSiteInConfStatus(sitesStatus.get(0).getStatus());
            if (0 == response.getResultCode())
            {
                List<FreeBusyStateEx> freeBusyStates  = response.getResult().get(siteUri);
                    if (null != freeBusyStates)
                    {
                    // flag = false;
                        for (FreeBusyStateEx freeBusyState : freeBusyStates)
                        {
                            if(confId.equals(freeBusyState.getConfId()))
                            {
                                //siteInfo.setBeginTime((freeBusyState.getStartTime())) ;
                                siteInfo.setBeginTime(DateUtils.gregoriantoDate(freeBusyState.getStartTime()));
                                siteInfo.setSpan(String.valueOf(DurationUtils.duration2int(freeBusyState.getSpan())));
                             // = true;
                                break;
                            }
                        }
/*                        if (!flag)
                        {
                            int confIdNum = 0;
                            try
                            {
                               confIdNum = Integer.parseInt(confId);
                            }
                            catch (NumberFormatException e)
                            {
                                return "error";
                            }
                            for (FreeBusyStateEx freeBusyState : freeBusyStates)
                            {
                                if(String.valueOf(confIdNum+1).equals(freeBusyState.getConfId()))
                                {
                                    siteInfo.setBeginTime((freeBusyState.getStartTime())) ;
                                    siteInfo.setSpan(String.valueOf(DurationUtils.duration2int(freeBusyState.getSpan())));
                                    break;
                                }
                            }
                        }*/
                    }
            }
        }
        
        return "success";
    }
    public String setContinuousPresence()
    {
        Integer presenceMode =null;
        try
        {
            presenceMode = Integer.valueOf(getRequest().getParameter("mode"));
        }
        catch (NumberFormatException e)
        {
               return "error";
        }
        String target = getRequest().getParameter("target");
        resultCode =  conferenceService.setContinuousPresenceEx(confId, target, presenceMode, null);
        return "success";
    }
    public String queryConfId()
    {
     /*   URL url = this.getClass().getResource("/");
        String path = url.getPath().substring(1); 
        confIds = fileDao.queryConfIds(path +"1.txt");*/
        confIds = new ArrayList<String>();
        Set<String> confIdKey = ConfMgrAction.dataMap.keySet();
        Iterator<String> it = confIdKey.iterator();
        while (it.hasNext())
        {
            confIds.add(it.next());
        }
        return "success";
    }


    public String getConfId()
    {
        return confId;
    }

    public void setConfId(String confId)
    {
        this.confId = confId;
    }

    public String getSiteUri()
    {
        return siteUri;
    }

    public void setSiteUri(String siteUri)
    {
        this.siteUri = siteUri;
    }

    public Integer getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(Integer resultCode)
    {
        this.resultCode = resultCode;
    }
    public SiteInfo getSiteInfo()
    {
        return siteInfo;
    }

    public void setSiteInfo(SiteInfo siteInfo)
    {
       this. siteInfo = siteInfo;
    }

    public ConferenceInfo getConfInfo()
    {
        return confInfo;
    }

    public void setConfInfo(ConferenceInfo confInfo)
    {
        this.confInfo = confInfo;
    }

    public List<String> getConfIds()
    {
        return confIds;
    }

    public void setConfIds(List<String> confIds)
    {
        this.confIds = confIds;
    }

} 
