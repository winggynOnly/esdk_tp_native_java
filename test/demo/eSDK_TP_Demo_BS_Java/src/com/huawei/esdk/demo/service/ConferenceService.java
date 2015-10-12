package com.huawei.esdk.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.demo.autogen.AddSiteToConfEx;
import com.huawei.esdk.demo.autogen.AddSiteToConfExResponse;
import com.huawei.esdk.demo.autogen.BroadInfoEx;
import com.huawei.esdk.demo.autogen.ConferenceInfoEx;
import com.huawei.esdk.demo.autogen.ConferenceStatusEx;
import com.huawei.esdk.demo.autogen.ConnectSitesEx;
import com.huawei.esdk.demo.autogen.DelScheduledConfEx;
import com.huawei.esdk.demo.autogen.DelSiteFromConfEx;
import com.huawei.esdk.demo.autogen.DisconnectSitesEx;
import com.huawei.esdk.demo.autogen.EditRecurrenceConferenceEx;
import com.huawei.esdk.demo.autogen.EditRecurrenceConferenceExResponse;
import com.huawei.esdk.demo.autogen.EditScheduledConfEx;
import com.huawei.esdk.demo.autogen.EditScheduledConfExResponse;
import com.huawei.esdk.demo.autogen.FreeBusyStateEx;
import com.huawei.esdk.demo.autogen.ProlongScheduledConfEx;
import com.huawei.esdk.demo.autogen.QueryBroadInfoEx;
import com.huawei.esdk.demo.autogen.QueryBroadInfoExResponse;
import com.huawei.esdk.demo.autogen.QueryConfCtrlPwdEx;
import com.huawei.esdk.demo.autogen.QueryConfCtrlPwdExResponse;
import com.huawei.esdk.demo.autogen.QueryConfSitesStatusEx;
import com.huawei.esdk.demo.autogen.QueryConfSitesStatusExResponse;
import com.huawei.esdk.demo.autogen.QueryConferencesStatusEx;
import com.huawei.esdk.demo.autogen.QueryConferencesStatusExResponse;
import com.huawei.esdk.demo.autogen.QuerySiteStatusEx;
import com.huawei.esdk.demo.autogen.QuerySiteStatusExResponse;
import com.huawei.esdk.demo.autogen.QuerySitesEx;
import com.huawei.esdk.demo.autogen.QuerySitesExResponse;
import com.huawei.esdk.demo.autogen.RecurrenceConfInfoEx;
import com.huawei.esdk.demo.autogen.ReleaseChairEx;
import com.huawei.esdk.demo.autogen.RequestChairEx;
import com.huawei.esdk.demo.autogen.ScheduleConfEx;
import com.huawei.esdk.demo.autogen.ScheduleConfExResponse;
import com.huawei.esdk.demo.autogen.ScheduleRecurrenceConferenceEx;
import com.huawei.esdk.demo.autogen.ScheduleRecurrenceConferenceExResponse;
import com.huawei.esdk.demo.autogen.SetAudioSwitchEx;
import com.huawei.esdk.demo.autogen.SetBroadcastContinuousPresenceEx;
import com.huawei.esdk.demo.autogen.SetBroadcastSiteEx;
import com.huawei.esdk.demo.autogen.SetContinuousPresenceEx;
import com.huawei.esdk.demo.autogen.SetDirectBroadEx;
import com.huawei.esdk.demo.autogen.SetRecordBroadEx;
import com.huawei.esdk.demo.autogen.SetSitesMuteEx;
import com.huawei.esdk.demo.autogen.SetSitesQuietEx;
import com.huawei.esdk.demo.autogen.SetVideoSourceEx;
import com.huawei.esdk.demo.autogen.SiteAccessInfoEx;
import com.huawei.esdk.demo.autogen.SiteFreeBusyStatesEx;
import com.huawei.esdk.demo.autogen.SiteInfoEx;
import com.huawei.esdk.demo.autogen.SiteStatusEx;
import com.huawei.esdk.demo.autogen.SynchSiteStatusEx;
import com.huawei.esdk.demo.autogen.SynchSiteStatusExResponse;
import com.huawei.esdk.demo.autogen.TPProfessionalConfCtr;
import com.huawei.esdk.demo.autogen.TPProfessionalConfMgr;
import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.utils.ClientProvider;
import com.huawei.esdk.demo.utils.DateUtils;
import com.huawei.esdk.demo.utils.ExceptionUtils;

public class ConferenceService
{
    private TPProfessionalConfCtr TPProfessionalConfCtr =
        (TPProfessionalConfCtr)ClientProvider.getClient(TPProfessionalConfCtr.class);
    
    private TPProfessionalConfMgr TPProfessionalConfMgr =
        (TPProfessionalConfMgr)ClientProvider.getClient(TPProfessionalConfMgr.class);
    
    private static ConferenceService instance = null;
    
    public static synchronized ConferenceService getInstance()
    {
        if (null == instance)
        {
            instance = new ConferenceService();
        }
        return instance;
    }
    
    public TPSDKResponseEx<ConferenceInfoEx> scheduleConfEx(ConferenceInfoEx scheduleConf)
    {
        TPSDKResponseEx<ConferenceInfoEx> resp = new TPSDKResponseEx<ConferenceInfoEx>();
        ScheduleConfExResponse scheduleConfExResp = new ScheduleConfExResponse();
        ScheduleConfEx scheduleConfEx = new ScheduleConfEx();
        scheduleConfEx.setScheduleConf(scheduleConf);
        try
        {
            scheduleConfExResp = TPProfessionalConfMgr.scheduleConfEx(scheduleConfEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = scheduleConfExResp.getResultCode();
        resp.setResult(0 == resultCode ? scheduleConfExResp.getConferenceInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<RecurrenceConfInfoEx> scheduleRecurrenceConferenceEx(RecurrenceConfInfoEx scheduleConf)
    {
        TPSDKResponseEx<RecurrenceConfInfoEx> resp = new TPSDKResponseEx<RecurrenceConfInfoEx>();
        ScheduleRecurrenceConferenceEx scheduleRecurrenceConference = new ScheduleRecurrenceConferenceEx();
        ScheduleRecurrenceConferenceExResponse scheduleRecurrenceConferenceResp =
            new ScheduleRecurrenceConferenceExResponse();
        scheduleRecurrenceConference.setScheduleConf(scheduleConf);
        try
        {
            scheduleRecurrenceConferenceResp =
                TPProfessionalConfMgr.scheduleRecurrenceConferenceEx(scheduleRecurrenceConference);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = scheduleRecurrenceConferenceResp.getResultCode();
        resp.setResult(0 == resultCode ? scheduleRecurrenceConferenceResp.getRecurrenceConfInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<ConferenceInfoEx> editScheduledConfEx(ConferenceInfoEx editConf)
    {
        TPSDKResponseEx<ConferenceInfoEx> resp = new TPSDKResponseEx<ConferenceInfoEx>();
        EditScheduledConfExResponse editScheduledConfExResp = new EditScheduledConfExResponse();
        EditScheduledConfEx editScheduledConfEx = new EditScheduledConfEx();
        editScheduledConfEx.setEditConf(editConf);
        try
        {
            editScheduledConfExResp = TPProfessionalConfMgr.editScheduledConfEx(editScheduledConfEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = editScheduledConfExResp.getResultCode();
        resp.setResult(0 == resultCode ? editScheduledConfExResp.getConferenceInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<RecurrenceConfInfoEx> editRecurrenceConferenceEx(RecurrenceConfInfoEx editConf)
    {
        TPSDKResponseEx<RecurrenceConfInfoEx> resp = new TPSDKResponseEx<RecurrenceConfInfoEx>();
        EditRecurrenceConferenceExResponse editRecurrenceConferenceExResp = new EditRecurrenceConferenceExResponse();
        EditRecurrenceConferenceEx editRecurrenceConferenceEx = new EditRecurrenceConferenceEx();
        editRecurrenceConferenceEx.setEditConf(editConf);
        try
        {
            editRecurrenceConferenceExResp =
                TPProfessionalConfMgr.editRecurrenceConferenceEx(editRecurrenceConferenceEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = editRecurrenceConferenceExResp.getResultCode();
        resp.setResult(0 == resultCode ? editRecurrenceConferenceExResp.getRecurrenceConfInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<List<SiteInfoEx>> querySitesEx()
    {
        TPSDKResponseEx<List<SiteInfoEx>> resp = new TPSDKResponseEx<List<SiteInfoEx>>();
        QuerySitesExResponse querySitesExResp = new QuerySitesExResponse();
        try
        {
            querySitesExResp = TPProfessionalConfMgr.querySitesEx(new QuerySitesEx());
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = querySitesExResp.getResultCode();
        resp.setResult(0 == resultCode ? querySitesExResp.getSiteInfos() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer prolongScheduledConfEx(String confId, Date beginDate, Duration prolongTime)
    {
        ProlongScheduledConfEx prolongScheduledConfEx = new ProlongScheduledConfEx();
        //prolongScheduledConfEx.setBeginDate(beginDate);
        prolongScheduledConfEx.setBeginDate(DateUtils.toGregorianCalendarDate(beginDate));
        prolongScheduledConfEx.setConfId(confId);
        prolongScheduledConfEx.setProlongTime(prolongTime);
        try
        {
            return TPProfessionalConfMgr.prolongScheduledConfEx(prolongScheduledConfEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> querySiteStatusEx(List<String> siteUris, Date beginTime,
        Duration duration)
    {
        TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> resp =
            new TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>>();
        QuerySiteStatusEx querySiteStatusEx = new QuerySiteStatusEx();
        QuerySiteStatusExResponse querySiteStatusExResp = new QuerySiteStatusExResponse();
        //querySiteStatusEx.setBeginTime(beginTime);
        querySiteStatusEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        querySiteStatusEx.setDuration(duration);
        querySiteStatusEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            querySiteStatusExResp = TPProfessionalConfMgr.querySiteStatusEx(querySiteStatusEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = querySiteStatusExResp.getResultCode();
        resp.setResultCode(resultCode);
        if (0 == resultCode)
        {
            Map<String, List<FreeBusyStateEx>> map = new HashMap<String, List<FreeBusyStateEx>>();
            for (SiteFreeBusyStatesEx siteFreeBusyStatesEx : querySiteStatusExResp.getSiteFreeBusyStates())
            {
                map.put(siteFreeBusyStatesEx.getUri(), siteFreeBusyStatesEx.getStates());
            }
            resp.setResult(map);
        }
        return resp;
    }
    
    public TPSDKResponseEx<List<ConferenceStatusEx>> queryConferencesStatusEx(List<String> confIds)
    {
        TPSDKResponseEx<List<ConferenceStatusEx>> resp = new TPSDKResponseEx<List<ConferenceStatusEx>>();
        QueryConferencesStatusEx queryConferencesStatusEx = new QueryConferencesStatusEx();
        QueryConferencesStatusExResponse queryConferencesStatusExResp = new QueryConferencesStatusExResponse();
        queryConferencesStatusEx.getConfIds().addAll(null == confIds ? new ArrayList<String>() : confIds);
        try
        {
            queryConferencesStatusExResp = TPProfessionalConfMgr.queryConferencesStatusEx(queryConferencesStatusEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryConferencesStatusExResp.getResultCode();
        resp.setResult(0 == resultCode ? queryConferencesStatusExResp.getConferenceStatuses() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<List<SiteStatusEx>> queryConfSitesStatusEx(String confId, List<String> siteUris)
    {
        TPSDKResponseEx<List<SiteStatusEx>> resp = new TPSDKResponseEx<List<SiteStatusEx>>();
        QueryConfSitesStatusEx queryConfSitesStatusEx = new QueryConfSitesStatusEx();
        QueryConfSitesStatusExResponse queryConfSitesStatusExResp = new QueryConfSitesStatusExResponse();
        queryConfSitesStatusEx.setConfId(confId);
        queryConfSitesStatusEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            queryConfSitesStatusExResp = TPProfessionalConfMgr.queryConfSitesStatusEx(queryConfSitesStatusEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryConfSitesStatusExResp.getResultCode();
        resp.setResult(0 == resultCode ? queryConfSitesStatusExResp.getSiteStatuses() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> synchSiteStatusEx(List<String> siteUris, Date beginTime,
        Duration duration)
    {
        TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> resp =
            new TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>>();
        SynchSiteStatusEx synchSiteStatusEx = new SynchSiteStatusEx();
        SynchSiteStatusExResponse synchSiteStatusExResponse = new SynchSiteStatusExResponse();
        //synchSiteStatusEx.setBeginTime(beginTime);
        synchSiteStatusEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        synchSiteStatusEx.setDuration(duration);
        synchSiteStatusEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            synchSiteStatusExResponse = TPProfessionalConfMgr.synchSiteStatusEx(synchSiteStatusEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = synchSiteStatusExResponse.getResultCode();
        resp.setResultCode(resultCode);
        if (0 == resultCode)
        {
            Map<String, List<FreeBusyStateEx>> map = new HashMap<String, List<FreeBusyStateEx>>();
            for (SiteFreeBusyStatesEx siteFreeBusyStatesEx : synchSiteStatusExResponse.getSiteFreeBusyStates())
            {
                map.put(siteFreeBusyStatesEx.getUri(), siteFreeBusyStatesEx.getStates());
            }
            resp.setResult(map);
        }
        return resp;
    }
    
    public TPSDKResponseEx<List<SiteAccessInfoEx>> addSiteToConfEx(String confId, SiteInfoEx siteInfo, Date beginTime)
    {
        TPSDKResponseEx<List<SiteAccessInfoEx>> resp = new TPSDKResponseEx<List<SiteAccessInfoEx>>();
        AddSiteToConfEx addSiteToConfEx = new AddSiteToConfEx();
        AddSiteToConfExResponse addSiteToConfExResp = new AddSiteToConfExResponse();
        addSiteToConfEx.setConfId(confId);
        addSiteToConfEx.setSiteInfo(siteInfo);
        //addSiteToConfEx.setBeginTime(beginTime);
        addSiteToConfEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        
        try
        {
            addSiteToConfExResp = TPProfessionalConfMgr.addSiteToConfEx(addSiteToConfEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = addSiteToConfExResp.getResultCode();
        //resp.setResult(0 == resultCode ? addSiteToConfExResp.getSiteAccessInfoEx() : null);
        resp.setResult(0 == resultCode ? addSiteToConfExResp.getSiteAccessInfos() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime)
    {
        DelSiteFromConfEx delSiteFromConfEx = new DelSiteFromConfEx();
        delSiteFromConfEx.setConfId(confId);
        delSiteFromConfEx.setSiteUri(siteUri);
        //delSiteFromConfEx.setBeginTime(beginTime);
        delSiteFromConfEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        try
        {
            return TPProfessionalConfMgr.delSiteFromConfEx(delSiteFromConfEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer connectSitesEx(String confId, List<String> siteUris)
    {
        ConnectSitesEx connectSitesEx = new ConnectSitesEx();
        connectSitesEx.setConfId(confId);
        connectSitesEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            return TPProfessionalConfMgr.connectSitesEx(connectSitesEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer disconnectSitesEx(String confId, List<String> siteUris)
    {
        DisconnectSitesEx disconnectSitesEx = new DisconnectSitesEx();
        disconnectSitesEx.setConfId(confId);
        disconnectSitesEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            return TPProfessionalConfMgr.disconnectSitesEx(disconnectSitesEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer delScheduledConfEx(String confId, Date beginTime)
    {
        DelScheduledConfEx delScheduledConfEx = new DelScheduledConfEx();
        delScheduledConfEx.setConfId(confId);
        //delScheduledConfEx.setBeginTime(beginTime);
        delScheduledConfEx.setBeginTime(DateUtils.toGregorianCalendarDate(beginTime));
        try
        {
            return TPProfessionalConfMgr.delScheduledConfEx(delScheduledConfEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setVideoSourceEx(String confId, String siteUri, String videoSourceUri, Integer isLock)
    {
        SetVideoSourceEx setVideoSourceEx = new SetVideoSourceEx();
        setVideoSourceEx.setConfId(confId);
        setVideoSourceEx.setIsLock(isLock);
        setVideoSourceEx.setSiteUri(siteUri);
        setVideoSourceEx.setVideoSourceUri(videoSourceUri);
        try
        {
            return TPProfessionalConfCtr.setVideoSourceEx(setVideoSourceEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setAudioSwitchEx(String confId, Integer switchGate, Integer isSwitch)
    {
        SetAudioSwitchEx setAudioSwitchEx = new SetAudioSwitchEx();
        setAudioSwitchEx.setConfId(confId);
        setAudioSwitchEx.setIsSwitch(isSwitch);
        setAudioSwitchEx.setSwitchGate(switchGate);
        try
        {
            return TPProfessionalConfCtr.setAudioSwitchEx(setAudioSwitchEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setBroadcastSiteEx(String confId, String siteUri, Integer isBroadcast)
    {
        SetBroadcastSiteEx setBroadcastSiteEx = new SetBroadcastSiteEx();
        setBroadcastSiteEx.setConfId(confId);
        setBroadcastSiteEx.setIsBroadcast(isBroadcast);
        setBroadcastSiteEx.setSiteUri(siteUri);
        try
        {
            return TPProfessionalConfCtr.setBroadcastSiteEx(setBroadcastSiteEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setBroadcastContinuousPresenceEx(String confId, Integer isBroadcast)
    {
        SetBroadcastContinuousPresenceEx setBroadcastContinuousPresenceEx = new SetBroadcastContinuousPresenceEx();
        setBroadcastContinuousPresenceEx.setConfId(confId);
        setBroadcastContinuousPresenceEx.setIsBroadcast(isBroadcast);
        try
        {
            return TPProfessionalConfCtr.setBroadcastContinuousPresenceEx(setBroadcastContinuousPresenceEx)
                .getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setSitesMuteEx(String confId, List<String> siteUris, Integer isMute)
    {
        SetSitesMuteEx setSitesMuteEx = new SetSitesMuteEx();
        setSitesMuteEx.setConfId(confId);
        setSitesMuteEx.setIsMute(isMute);
        setSitesMuteEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            return TPProfessionalConfCtr.setSitesMuteEx(setSitesMuteEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setSitesQuietEx(String confId, List<String> siteUris, Integer isQuiet)
    {
        SetSitesQuietEx setSitesQuietEx = new SetSitesQuietEx();
        setSitesQuietEx.setConfId(confId);
        setSitesQuietEx.setIsQuiet(isQuiet);
        setSitesQuietEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            return TPProfessionalConfCtr.setSitesQuietEx(setSitesQuietEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setContinuousPresenceEx(String confId, String target, Integer presenceMode, List<String> subPics)
    {
        SetContinuousPresenceEx setContinuousPresenceEx = new SetContinuousPresenceEx();
        setContinuousPresenceEx.setConfId(confId);
        setContinuousPresenceEx.setTarget(target);
        setContinuousPresenceEx.setPresenceMode(presenceMode);
        setContinuousPresenceEx.getSubPics().addAll(null == subPics ? new ArrayList<String>() : subPics);
        try
        {
            return TPProfessionalConfCtr.setContinuousPresenceEx(setContinuousPresenceEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer requestChairEx(String siteURI)
    {
        RequestChairEx requestChairEx = new RequestChairEx();
        requestChairEx.setSiteUri(siteURI);
        try
        {
            return TPProfessionalConfCtr.requestChairEx(requestChairEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer releaseChairEx(String siteURI)
    {
        ReleaseChairEx releaseChairEx = new ReleaseChairEx();
        releaseChairEx.setSiteUri(siteURI);
        try
        {
            return TPProfessionalConfCtr.releaseChairEx(releaseChairEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<String> queryConfCtrlPwdEx(String siteURI)
    {
        TPSDKResponseEx<String> resp = new TPSDKResponseEx<String>();
        QueryConfCtrlPwdEx queryConfCtrlPwdEx = new QueryConfCtrlPwdEx();
        queryConfCtrlPwdEx.setSiteUri(siteURI);
        QueryConfCtrlPwdExResponse queryConfCtrlPwdExResp = new QueryConfCtrlPwdExResponse();
        try
        {
            queryConfCtrlPwdExResp = TPProfessionalConfCtr.queryConfCtrlPwdEx(queryConfCtrlPwdEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryConfCtrlPwdExResp.getResultCode();
        resp.setResult(0 == resultCode ? queryConfCtrlPwdExResp.getResult() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<BroadInfoEx> queryBroadInfoEx(String siteURI)
    {
        TPSDKResponseEx<BroadInfoEx> resp = new TPSDKResponseEx<BroadInfoEx>();
        QueryBroadInfoEx queryBroadInfoEx = new QueryBroadInfoEx();
        QueryBroadInfoExResponse queryBroadInfoExResp = new QueryBroadInfoExResponse();
        try
        {
            queryBroadInfoExResp = TPProfessionalConfCtr.queryBroadInfoEx(queryBroadInfoEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryBroadInfoExResp.getResultCode();
        //resp.setResult(0 == resultCode ? queryBroadInfoExResp.getBroadInfoEx() : null);
        resp.setResult(0 == resultCode ? queryBroadInfoExResp.getBroadInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer setRecordBroadEx(String siteURI, Integer action)
    {
        SetRecordBroadEx setRecordBroadEx = new SetRecordBroadEx();
        setRecordBroadEx.setSiteUri(siteURI);
        setRecordBroadEx.setAction(action);
        try
        {
            return TPProfessionalConfCtr.setRecordBroadEx(setRecordBroadEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setDirectBroadEx(String siteURI, Integer action)
    {
        SetDirectBroadEx setDirectBroadEx = new SetDirectBroadEx();
        setDirectBroadEx.setSiteUri(siteURI);
        setDirectBroadEx.setAction(action);
        try
        {
            return TPProfessionalConfCtr.setDirectBroadEx(setDirectBroadEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
}
