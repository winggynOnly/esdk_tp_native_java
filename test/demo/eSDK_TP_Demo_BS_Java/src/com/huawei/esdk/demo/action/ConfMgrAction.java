package com.huawei.esdk.demo.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.datatype.Duration;

import com.huawei.esdk.demo.autogen.ConferenceInfoEx;
import com.huawei.esdk.demo.autogen.ConferenceStatusEx;
import com.huawei.esdk.demo.autogen.RecurrenceConfInfoEx;
import com.huawei.esdk.demo.autogen.SiteAccessInfoEx;
import com.huawei.esdk.demo.autogen.SiteInfoEx;
import com.huawei.esdk.demo.autogen.SiteStatusEx;
import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.bean.ConferenceInfo;
import com.huawei.esdk.demo.bean.RecurrenceConferenceInfo;
import com.huawei.esdk.demo.common.BaseAction;
import com.huawei.esdk.demo.service.ConferenceService;
import com.huawei.esdk.demo.utils.BeanToJsonUtils;
import com.huawei.esdk.demo.utils.DateUtils;
import com.huawei.esdk.demo.utils.DurationUtils;
import com.huawei.esdk.demo.utils.StringUtils;

public class ConfMgrAction extends BaseAction
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 9028393424971384175L;

    private Map<String, SiteInfoEx> siteInfoMap;
    
    private   ConferenceService conferenceService = ConferenceService.getInstance();
    
    private List<ConferenceInfo> confInfoList;
    
    private RecurrenceConferenceInfo recurrenceConfInfo;
    //存放会议信息
    public static final Map<String, ConferenceInfo> dataMap = new TreeMap<String, ConferenceInfo>();
    
    private static final Map<String, RecurrenceConferenceInfo> recurrenceDataMap = new HashMap<String, RecurrenceConferenceInfo>();
    
    /**
     * 预约会议
     * 修改会议
     */
    public void scheduleConf()
    {
        
        String confId = getRequest().getParameter("confId");
        String name = getRequest().getParameter("name");
        String beginTime = getRequest().getParameter("beginTime");
        String duration = getRequest().getParameter("duration");
        String rate = getRequest().getParameter("rate");
        String siteUris = getRequest().getParameter("siteUris");
        String cpResouce = getRequest().getParameter("cpResouce");
        int cpResouceNum = 0;
        try
        {
            cpResouceNum = Integer.parseInt(cpResouce);
        }
        catch (NumberFormatException e)
        {
            cpResouceNum = 0;
        }
        //根据siteUris获取会场的全部信息
        List<SiteInfoEx> choiceSite = new ArrayList<SiteInfoEx>();
        if (siteInfoMap == null)
        {
            queryAllSites();
        }
        
        //添加普通会场
        Set<Map.Entry<String, SiteInfoEx>> items = siteInfoMap.entrySet();
        for (Map.Entry<String, SiteInfoEx> entry : items)
        {
            if (siteUris.contains(entry.getKey()))
            {
                choiceSite.add(entry.getValue());
            }
        }
        //添加匿名会场
        setDynamicSite(siteUris, choiceSite);
        
        ConferenceInfoEx conferenceInfoEx = new ConferenceInfoEx();
        
        if (!StringUtils.isEmpty(confId))
        {
            conferenceInfoEx.setConfId(confId);
        }
        conferenceInfoEx.setName(name);
        //conferenceInfoEx.setBeginTime(DateUtils.toDate(beginTime));
        conferenceInfoEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        conferenceInfoEx.setDuration(DurationUtils.durationInt2dur(Integer.parseInt(duration)));
        conferenceInfoEx.setRate(rate);
        if(0 != cpResouceNum)
        {
            conferenceInfoEx.setCpResouce(cpResouceNum);
        }
        conferenceInfoEx.getSites().addAll(choiceSite);
      
        
        //判断是否有会议id，没有的时候是预约会议，有的时候是修改会议
        TPSDKResponseEx<ConferenceInfoEx> sdkResponse = null;
        if (StringUtils.isEmpty(confId))
        {
            sdkResponse = conferenceService.scheduleConfEx(conferenceInfoEx);
        }
        else
        {
            sdkResponse = conferenceService.editScheduledConfEx(conferenceInfoEx);
        }
        if (sdkResponse.getResultCode() == 0)
        {
            ConferenceInfoEx conferenceInfoEx2 = sdkResponse.getResult();
            ConferenceInfo conferenceInfo = new ConferenceInfo();
            conferenceInfo.setConfId(conferenceInfoEx2.getConfId());
            conferenceInfo.setName(name);
            conferenceInfo.setBeginTime(beginTime);
            conferenceInfo.setDuration(duration);
            conferenceInfo.setAccessCode(conferenceInfoEx2.getAccessCode());
            conferenceInfo.setStatus(queryConfStatus(conferenceInfoEx2.getConfId()));
            conferenceInfo.setSites(conferenceInfoEx2.getSites());
            dataMap.put(conferenceInfo.getConfId(), conferenceInfo);
            //查询会议状态
            outJson(BeanToJsonUtils.beanToJson(conferenceInfo));
        }
        else
        {
            outString(String.valueOf(sdkResponse.getResultCode()));
        }
        
    }
    
    /**
     * 预约周期会议
     * 修改周期会议
     */
    public void scheduleRecurrenceConference()
    {
        
        String confId = getRequest().getParameter("confId");
        String name = getRequest().getParameter("name");
        String beginTime = getRequest().getParameter("beginTime");
        String duration = getRequest().getParameter("duration");
        String rate = getRequest().getParameter("rate");
        String siteUris = getRequest().getParameter("siteUris");
        String cpResouce = getRequest().getParameter("cpResouce");
        int cpResouceNum = 0;
        try
        {
            cpResouceNum = Integer.parseInt(cpResouce);
        }
        catch (NumberFormatException e)
        {
            cpResouceNum = 0;
        }

        //
        String frequency = getRequest().getParameter("frequency");
        String interval = getRequest().getParameter("interval");
        String weekDay = getRequest().getParameter("weekDay");
        String monthDay = getRequest().getParameter("monthDay");
        String count = getRequest().getParameter("count");
        String endDate = getRequest().getParameter("endDate");
        //根据siteUris获取会场的全部信息
        List<SiteInfoEx> choiceSite = new ArrayList<SiteInfoEx>();
        if (siteInfoMap == null)
        {
            queryAllSites();
        }
        
        //添加普通会场
        Set<Map.Entry<String, SiteInfoEx>> items = siteInfoMap.entrySet();
        for (Map.Entry<String, SiteInfoEx> entry : items)
        {
            if (siteUris.contains(entry.getKey()))
            {
                choiceSite.add(entry.getValue());
            }
        }
        //添加匿名会场
        setDynamicSite(siteUris, choiceSite);
        
        RecurrenceConfInfoEx conferenceInfoEx = new RecurrenceConfInfoEx();
        
        if (!StringUtils.isEmpty(confId))
        {
            conferenceInfoEx.setConfId(confId);
        }
        conferenceInfoEx.setName(name);
        //conferenceInfoEx.setBeginTime(DateUtils.toDate(beginTime));
        conferenceInfoEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        conferenceInfoEx.setDuration(DurationUtils.durationInt2dur(Integer.parseInt(duration)));
        conferenceInfoEx.setRate(rate);
        conferenceInfoEx.getSites().addAll(choiceSite);
        if(0 != cpResouceNum)
        {
            conferenceInfoEx.setCpResouce(cpResouceNum);
        }
        //周期会议特有的字段
        conferenceInfoEx.setFrequency(StringUtils.isEmpty(frequency) ? null : Integer.parseInt(frequency));
        conferenceInfoEx.setInterval(StringUtils.isEmpty(interval) ? null : Integer.parseInt(interval));
        //List<Integer> weekDays = new ArrayList<Integer>();
        //weekDays.add(StringUtils.isEmpty(weekDay) ? null : Integer.parseInt(weekDay));
        //conferenceInfoEx.setWeekDays(weekDays);
        conferenceInfoEx.getWeekDays().add(StringUtils.isEmpty(weekDay) ? null : Integer.parseInt(weekDay));
        conferenceInfoEx.setMonthDay(StringUtils.isEmpty(monthDay) ? null : Integer.parseInt(monthDay));
        conferenceInfoEx.setCount(StringUtils.isEmpty(count) ? 0 : Integer.parseInt(count));
        //conferenceInfoEx.setEndDate(StringUtils.isEmpty(endDate) ? null : DateUtils.toDate(endDate));
        conferenceInfoEx.setEndDate(StringUtils.isEmpty(endDate) ? null : DateUtils.toGregorianCalendarDate(endDate));
        
        //判断是否有会议id，没有的时候是预约会议，有的时候是修改会议
        TPSDKResponseEx<RecurrenceConfInfoEx> sdkResponse = null;
        if (StringUtils.isEmpty(confId))
        {
            sdkResponse = conferenceService.scheduleRecurrenceConferenceEx(conferenceInfoEx);
        }
        else
        {
            sdkResponse = conferenceService.editRecurrenceConferenceEx(conferenceInfoEx);
        }
        
        if (sdkResponse.getResultCode() == 0)
        {
            RecurrenceConfInfoEx conferenceInfoEx2 = sdkResponse.getResult();
            ConferenceInfo conferenceInfo = new ConferenceInfo();
            conferenceInfo.setConfId(conferenceInfoEx2.getConfId());
            conferenceInfo.setName(name);
            conferenceInfo.setBeginTime(beginTime);
            conferenceInfo.setDuration(duration);
            conferenceInfo.setAccessCode(conferenceInfoEx2.getAccessCode());
            conferenceInfo.setStatus(queryConfStatus(conferenceInfoEx2.getConfId()));
            conferenceInfo.setSites(conferenceInfoEx2.getSites());
            conferenceInfo.setSitesAccessInfos(conferenceInfoEx2.getSiteAccessInfos());
            dataMap.put(conferenceInfo.getConfId(), conferenceInfo);
            //查询会议状态
            outJson(BeanToJsonUtils.beanToJson(conferenceInfo));
        }
        else
        {
            outString(String.valueOf(sdkResponse.getResultCode()));
        }
        
    }
    
    public String selectConfById()
    {
        if (siteInfoMap == null)
        {
            queryAllSites();
        }
        String confId = getRequest().getParameter("confId");
        if (null != dataMap.get(confId).getSitesAccessInfos())
        {
            recurrenceConfInfo = new RecurrenceConferenceInfo();
            List<SiteAccessInfoEx> siteAccessInfoExs = dataMap.get(confId).getSitesAccessInfos();
            Map<String ,List<SiteInfoEx>> recurrenceMap = new TreeMap<String,List<SiteInfoEx>>();
            recurrenceMap = setRecurrenceTimeMap(confId, siteAccessInfoExs);
            
            if(null != recurrenceDataMap.get(confId))
            {
                recurrenceMap =  recurrenceDataMap.get(confId).getRecurrenceMap();
            }
            recurrenceConfInfo.setRecurrenceMap(recurrenceMap);
            recurrenceDataMap.put(confId, recurrenceConfInfo);
            List<SiteStatusEx> siteStatusList = conferenceService.queryConfSitesStatusEx(confId, null).getResult();
            recurrenceConfInfo.setSiteStatusList(siteStatusList);
            return "recurrence";
        }
        else
        {
            confInfoList = new ArrayList<ConferenceInfo>();
            ConferenceInfo confInfo = dataMap.get(confId);
            List<SiteStatusEx> siteList = conferenceService.queryConfSitesStatusEx(confId, null).getResult();
            confInfo.setSiteList(siteList);
            confInfoList.add(confInfo);
            return "success";
        }
    }
    
    public String queryConfInfo()
    {
        confInfoList = new ArrayList<ConferenceInfo>();
        Set<Map.Entry<String, ConferenceInfo>> entryseSet = dataMap.entrySet();
        for (Map.Entry<String, ConferenceInfo> entry : entryseSet)
        {
            ConferenceInfo conferenceInfo = entry.getValue();
            conferenceInfo.setStatus(queryConfStatus(entry.getKey()));
            confInfoList.add(conferenceInfo);
        }
        return "success";
    }
    
    /**
     * 跳转到预约会议页面
     * @return
     */
    public String jumpScheduleConf()
    {
        //获取会议id，如果有id，则是修改会议，否则是预约会议
        String confId = getRequest().getParameter("confId");
        String confName = getRequest().getParameter("confName");
        if (!StringUtils.isEmpty(confId))
        {
            getRequest().setAttribute("confId", confId);
            getRequest().setAttribute("confName", confName);
            //getRequest().setAttribute("buttonName", "修改会议");
            getRequest().setAttribute("buttonName", getText("modifyConf"));
        }
        else
        {
            //	    getRequest().setAttribute("buttonName", "预约会议");
            getRequest().setAttribute("buttonName", getText("scheduleConf"));
        }
        return "newConf";
    }
    
    /**
     * 跳转到会场信息页面
     */
    public void jumpSiteInfo()
    {
        //给siteInfo页面传数据
        StringBuffer siteInfoBuffer = querySites2Json();
        //返回的数据格式：
        //"{Rows : [ {\"siteUri\" : \"01010010\",\"siteName\" : \"独孤求败\",\"siteType\" : \"SiteType_Ip\",\"siteStatus\" : \"free\"},{\"siteUri\" : \"01010086\",\"siteName\" : \"西门吹雪\",\"siteType\" : \"SiteType_Ip\",\"siteStatus\" : \"free\"}],Total : 4};";
        getRequest().getSession().setAttribute("siteInfo", siteInfoBuffer.toString());
        System.out.println(siteInfoBuffer);
        outJson(siteInfoBuffer.toString());
//        return "siteInfo";
    }
    
    /**
     * 跳转到添加会场信息页面
     */
    public String jumpAddSite()
    {
        StringBuffer siteInfoBuffer = querySites2Json();
        //  String siteInfo = "{Rows : [ {\"siteUri\" : \"01010010\",\"siteName\" : \"独孤求败\",\"siteType\" : \"SiteType_Ip\",\"siteStatus\" : \"free\"},{\"siteUri\" : \"01010086\",\"siteName\" : \"西门吹雪\",\"siteType\" : \"SiteType_Ip\",\"siteStatus\" : \"free\"}],Total : 4};";
        getRequest().getSession().setAttribute("siteInfo", siteInfoBuffer.toString());
        return "addSite";
    }
    
    /**
     * 跳转到延长会议页面
     */
    public String jumpProlongTime()
    {
        String confId = getRequest().getParameter("confId");
        getRequest().setAttribute("confId", confId);
        return "prolongInfo";
    }
    
    /**
     * 删除会议
     */
    public void cancelScheduledConf()
    {
        String confId = getRequest().getParameter("confId");
        String beginTime = getRequest().getParameter("beginTime");
        Date date = null;
        if (!StringUtils.isEmpty(beginTime))
        {
            date = DateUtils.toDate(beginTime);
            if(date.getTime() < new Date().getTime())
            {
            	date = null;	
            }
        }
        Integer sdkResponseEx = conferenceService.delScheduledConfEx(confId, date);
        if ( 0 == sdkResponseEx || 1342177282 ==sdkResponseEx )
        {
            dataMap.remove(confId);
        }
        outJS(sdkResponseEx.toString());
    }
    
    /**
     * 延长会议
     */
    public void prolongScheduledConf()
    {
        String confId = getRequest().getParameter("confId");
        String beginDate = getRequest().getParameter("beginDate");
        String prolongTime = getRequest().getParameter("prolongTime");
        
        Duration duration = DurationUtils.durationInt2dur(Integer.parseInt(prolongTime));
        Date date = null;
        if (!StringUtils.isEmpty(beginDate))
        {
            date = DateUtils.toDate(beginDate);
        }
        Integer sdkResponseEx = conferenceService.prolongScheduledConfEx(confId, date, duration);
        if (0 == sdkResponseEx)
        {
            try
            {
                int durationNum  = Integer.parseInt(dataMap.get(confId).getDuration());
                int prolongTimeNum = Integer.parseInt(prolongTime);
                int newDurationNum = durationNum + prolongTimeNum;
                dataMap.get(confId).setDuration(String.valueOf(newDurationNum));
            }
            catch (NumberFormatException e)
            {
                outJS("null");
            }
           
        }
        outJS(sdkResponseEx.toString());
    }
    
    /**
     * 添加会场
     */
    public void addSiteToConf()
    {
        String confId = getRequest().getParameter("confId");
        String beginTime = getRequest().getParameter("beginTime");
        String uri = getRequest().getParameter("siteUri");
        String name = getRequest().getParameter("siteName");
        String type = getRequest().getParameter("siteType");
        SiteInfoEx siteInfo = new SiteInfoEx();
        siteInfo.setUri(uri);
        siteInfo.setName(name);
        try
        {
            Integer typeInt = Integer.parseInt(type);
            siteInfo.setType(typeInt);
        }
        catch (Exception e)
        {
            siteInfo.setType(4);
        }
        //添加会场，一次只能添加一个会场
        TPSDKResponseEx<List<SiteAccessInfoEx>> result = null;
        if ("" == beginTime)
        {
            result = conferenceService.addSiteToConfEx(confId, siteInfo, null);
        }
        else
        {
            result = conferenceService.addSiteToConfEx(confId, siteInfo, DateUtils.toDate(beginTime));
            if(0 == result.getResultCode())
            {
                Map<String, List<SiteInfoEx>> recurrenceMap = setRecurrenceTimeMap(confId,result.getResult());
                recurrenceDataMap.get(confId).setRecurrenceMap(recurrenceMap);
            }
        }
        outString(String.valueOf(result.getResultCode()));
    }
    
    /**
     * 呼叫会场
     */
    public void connectSites()
    {
        String confId = getRequest().getParameter("confId");
        String sitesString = getRequest().getParameter("sites");
        List<String> siteUris = new ArrayList<String>();
        String[] sites = sitesString.split(",");
        for (String site : sites)
        {
            if (!StringUtils.isEmpty(site))
            {
                siteUris.add(site);
            }
        }
        Integer result = conferenceService.connectSitesEx(confId, siteUris);
        outString(String.valueOf(result));
    }
    
    /**
     * 删除会场
     */
    public void delSiteFromConf()
    {
        String confId = getRequest().getParameter("confId");
        String siteUri = getRequest().getParameter("siteUri");
        String beginTime = getRequest().getParameter("beginTime");
         Integer result = conferenceService.delSiteFromConfEx(confId, siteUri, DateUtils.toDate(beginTime));
         if(0 == result)
         {
             if(null != recurrenceDataMap.get(confId))
             {
                 List<SiteInfoEx> sites =  recurrenceDataMap.get(confId).getRecurrenceMap().get(beginTime);
                 SiteInfoEx siteInfo = new SiteInfoEx();
                 for (SiteInfoEx siteInfoEx : sites)
                {
                    if(siteInfoEx.getUri().equals(siteUri))
                    {
                        siteInfo = siteInfoEx;
                    }
                }
                 sites.remove(siteInfo);
                 recurrenceDataMap.get(confId).getRecurrenceMap().put(beginTime, sites);
             }
         }
        outString(String.valueOf(result));
    }
    
    /**
     * 查询所有会场
     */
    public void querySites()
    {
        if (null == siteInfoMap)
        {
            queryAllSites();
        }
        //		outJson(BeanToJsonUtils.beanToJson(siteInfoList));
    }
    
    private void queryAllSites()
    {
        if (null != siteInfoMap)
        {
            return;
        }
        TPSDKResponseEx<List<SiteInfoEx>> siteInfoEx = conferenceService.querySitesEx();
        List<SiteInfoEx> siteInfoList = siteInfoEx.getResult();
        siteInfoMap = new HashMap<String, SiteInfoEx>();
        for (SiteInfoEx siteInfo : siteInfoList)
        {
            siteInfoMap.put(siteInfo.getUri(), siteInfo);
        }
    }
    
    private String queryConfStatus(String confId)
    {
        Integer status = queryConfStatusInt(confId);
        return String.valueOf(status);
    }
    
    private Integer queryConfStatusInt(String confId)
    {
        List<String> confIds = new ArrayList<String>();
        confIds.add(confId);
        
        TPSDKResponseEx<List<ConferenceStatusEx>> siteInfoEx =
            conferenceService.queryConferencesStatusEx(confIds);
        if (0 == siteInfoEx.getResultCode())
        {
            int status = siteInfoEx.getResult().get(0).getStatus();
            return status;
        }
        return 0;
    }
    
    private StringBuffer querySites2Json()
    {
        querySites();
        StringBuffer siteInfoBuffer = new StringBuffer();
        boolean isFlag = false;
   /*     SiteCtrlAction sCtrlAction = new SiteCtrlAction();
        List<String> siteUriList = new ArrayList<String>();
        for (SiteInfoEx siteinfo : siteInfoList) {
            siteUriList.add(siteinfo.getUri());
        }
        Map<String, Integer>  siteStatusMap = sCtrlAction.querySiteStatusEx(siteUriList);*/
        siteInfoBuffer.append("{\"Rows\" : [");
        Set<Map.Entry<String, SiteInfoEx>> items = siteInfoMap.entrySet();
        for (Map.Entry<String, SiteInfoEx> entry : items)
        {
            
            SiteInfoEx siteInfoEx = entry.getValue();
            if (isFlag)
            {
                siteInfoBuffer.append(",");
            }
            isFlag = true;
            siteInfoBuffer.append("{").append("\"siteUri\":\"" + siteInfoEx.getUri() + "\",");
            siteInfoBuffer.append("\"siteName\":\"" + siteInfoEx.getName() + "\",");
            siteInfoBuffer.append("\"siteType\":\""+siteInfoEx.getType()+ "\"");
        /*    siteInfoBuffer.append("\"siteType\":\"" + SiteTypeMapping.int2Enum(siteInfoEx.getType()) + "\",");
            siteInfoBuffer.append("\"siteStatus\":\"" + siteInfoEx.getStatus() + "\"");*/
            // 会场状态
        /*    Integer sts = siteStatusMap.get(siteInfoEx.getUri());
            if (null == sts)
            {
                siteInfoBuffer.append("\"siteStatus\":\""+2+"\"");
            }
            else
            {
                siteInfoBuffer.append("\"siteStatus\":\"").append(sts).append("\"");
            }*/
            siteInfoBuffer.append("}");
        }
        siteInfoBuffer.append("]}");
        return siteInfoBuffer;
    }
    
    private  Map<String ,List<SiteInfoEx>> setRecurrenceTimeMap(String confId, List<SiteAccessInfoEx> siteAccessInfoExs)
    {
        List<SiteInfoEx> sites = new ArrayList<SiteInfoEx>();
        Map<String, List<SiteInfoEx>> recurrenceMap = new TreeMap<String, List<SiteInfoEx>>();
        //String beginTime = DateUtils.toString(siteAccessInfoExs.get(0).getBeginTime());
        String beginTime = DateUtils.toString(DateUtils.gregoriantoDate(siteAccessInfoExs.get(0).getBeginTime()));
        List<String> times = new ArrayList<String>();
        times.add(beginTime);
        for (SiteAccessInfoEx siteAccessInfoEx : siteAccessInfoExs)
        {
            //if (beginTime.equals(DateUtils.toString(siteAccessInfoEx.getBeginTime())))
            if (beginTime.equals(DateUtils.toString(DateUtils.gregoriantoDate(siteAccessInfoEx.getBeginTime()))))
            {
                sites.add(siteInfoMap.get(siteAccessInfoEx.getUri()));
                recurrenceMap.put(beginTime, sites);
                continue;
            }
            else
            {
                //beginTime = DateUtils.toString(siteAccessInfoEx.getBeginTime());
                //times.add(DateUtils.toString(siteAccessInfoEx.getBeginTime()));
                beginTime = DateUtils.toString(DateUtils.gregoriantoDate(siteAccessInfoEx.getBeginTime()));
                times.add(DateUtils.toString(DateUtils.gregoriantoDate(siteAccessInfoEx.getBeginTime())));
                sites = new ArrayList<SiteInfoEx>();
                sites.add(siteInfoMap.get(siteAccessInfoEx.getUri()));
            }
        }
        return recurrenceMap;
    }
    
    private void setDynamicSite(String siteUris ,  List<SiteInfoEx> choiceSite )
    {
        int dynamicNum = 0;
        if(siteUris.indexOf("dynamic") >= 0 )
        {
            dynamicNum =  siteUris.split("dynamic").length;
        }
        else if(siteUris.indexOf("匿名") >= 0)
        {
            dynamicNum =  siteUris.split("匿名").length;
        }
        SiteInfoEx dynamicSiteInfoEx = null;
        if (dynamicNum > 0)
        {
            for (int i = 1; i <  dynamicNum; i++)
            {
                dynamicSiteInfoEx = new SiteInfoEx();
                dynamicSiteInfoEx.setType(4);
                choiceSite.add(dynamicSiteInfoEx);
            }
        }
    }

    public List<ConferenceInfo> getConfInfoList()
    {
        return confInfoList;
    }
    
    public void setConfInfoList(List<ConferenceInfo> confInfoList)
    {
        this.confInfoList = confInfoList;
    }
    
    public RecurrenceConferenceInfo getRecurrenceConfInfo()
    {
        return recurrenceConfInfo;
    }

    public void setRecurrenceConfInfo(RecurrenceConferenceInfo recurrenceConfInfo)
    {
        this.recurrenceConfInfo = recurrenceConfInfo;
    }
}
