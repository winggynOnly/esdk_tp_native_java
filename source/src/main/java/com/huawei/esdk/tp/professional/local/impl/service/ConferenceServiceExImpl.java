package com.huawei.esdk.tp.professional.local.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;

import org.apache.cxf.common.util.StringUtils;
import org.apache.log4j.Logger;

import com.huawei.esdk.platform.professional.local.PlatformServiceFactoryEx;
import com.huawei.esdk.platform.professional.local.bean.SDKResponse;
import com.huawei.esdk.platform.professional.local.constant.PlatformNativeConstant;
import com.huawei.esdk.platform.professional.local.impl.utils.RSA2048Utils;
import com.huawei.esdk.platform.professional.local.service.common.PlatformKeyServiceEx;
import com.huawei.esdk.tp.professional.local.bean.BroadInfoEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceStatusEx;
import com.huawei.esdk.tp.professional.local.bean.FreeBusyStateEx;
import com.huawei.esdk.tp.professional.local.bean.QueryConfigEx;
import com.huawei.esdk.tp.professional.local.bean.QuerySitesByConditionExResponse;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.SiteVolumeEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.conference.ConferenceServiceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.AddSiteToConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.AddSiteToConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ConnectSitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelSiteFromConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisconnectSitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisplayConfSiteLocalVideoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisplayConfSiteLocalVideoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditRecurrenceConferenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditRecurrenceConferenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditScheduledConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.HideConfSiteLocalVideoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.HideConfSiteLocalVideoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ProlongScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryBroadInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryBroadInfoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfCtrlPwdEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfCtrlPwdExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfSitesStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfSitesStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConferencesStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConferencesStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesByConditionEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ReleaseChairEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.RequestChairEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleRecurrenceConferenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleRecurrenceConferenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetAudioSwitchEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastContinuousPresenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastSiteEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetConfSiteVolumeEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetConfSiteVolumeExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetContinuousPresenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetDirectBroadEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetFloorEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetFloorExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetRecordBroadEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesMuteEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesQuietEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoSourceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SiteFreeBusyStatesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SynchSiteStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SynchSiteStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalConfCtr;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalConfMgr;
import com.huawei.esdk.tp.professional.local.impl.utils.Base64Utils;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.tp.professional.local.impl.utils.ExceptionUtils;

public class ConferenceServiceExImpl implements ConferenceServiceEx
{
    
    /**
     * 日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(ConferenceServiceExImpl.class);
    
    private PlatformKeyServiceEx keyServiceEx = PlatformServiceFactoryEx.getService(PlatformKeyServiceEx.class);
    
    private TPProfessionalConfCtr TPProfessionalConfCtr =
        (TPProfessionalConfCtr)ClientProvider.getClient(TPProfessionalConfCtr.class);
    
    private TPProfessionalConfMgr TPProfessionalConfMgr =
        (TPProfessionalConfMgr)ClientProvider.getClient(TPProfessionalConfMgr.class);
    
    private static ConferenceServiceExImpl instance = null;
    
    public static synchronized ConferenceServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new ConferenceServiceExImpl();
        }
        return instance;
    }
    
    public TPSDKResponseEx<ConferenceInfoEx> scheduleConfEx(ConferenceInfoEx scheduleConf)
    {
        TPSDKResponseEx<ConferenceInfoEx> resp = new TPSDKResponseEx<ConferenceInfoEx>();
        
        LOGGER.info("begin to execute getPublicKey method");
        SDKResponse<String> key = keyServiceEx.getPublicKey();
        if (null == key || 0 != key.getResultCode())
        {
            LOGGER.info("failed to get publicKey");
            resp.setResultCode(PlatformNativeConstant.FAILED_TO_GET_PUTLIC_KEY);
            return resp;
        }
        LOGGER.info("execute getPublicKey method completed");
        
        if (null != scheduleConf && !StringUtils.isEmpty(scheduleConf.getPassword()))
        {
            String encrytedPassword;
            try
            {
                encrytedPassword = Base64Utils.encode(RSA2048Utils.encode(scheduleConf.getPassword().getBytes()));
                scheduleConf.setPassword(encrytedPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
            }
        }
        
        if (null != scheduleConf && !StringUtils.isEmpty(scheduleConf.getChairmanPassword()))
        {
            String encrytedChairmanPassword;
            try
            {
                encrytedChairmanPassword = Base64Utils.encode(RSA2048Utils.encode(scheduleConf.getChairmanPassword().getBytes()));
                scheduleConf.setChairmanPassword(encrytedChairmanPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode ChairmanPassword error");
            }
        }
        
        
        ScheduleConfExResponse scheduleConfExResp = new ScheduleConfExResponse();
        ScheduleConfEx scheduleConfEx = new ScheduleConfEx();
        scheduleConfEx.setScheduleConf(scheduleConf);
        try
        {
            scheduleConfExResp = TPProfessionalConfMgr.scheduleConfEx(scheduleConfEx);
        }
        catch (Exception e)
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
        
        LOGGER.info("begin to execute getPublicKey method");
        SDKResponse<String> key = keyServiceEx.getPublicKey();
        if (null == key || 0 != key.getResultCode())
        {
            LOGGER.info("failed to get publicKey");
            resp.setResultCode(PlatformNativeConstant.FAILED_TO_GET_PUTLIC_KEY);
            return resp;
        }
        LOGGER.info("execute getPublicKey method completed");
        
        if (null != scheduleConf && !StringUtils.isEmpty(scheduleConf.getPassword()))
        {
            String encrytedPassword;
            try
            {
                encrytedPassword = Base64Utils.encode(RSA2048Utils.encode(scheduleConf.getPassword().getBytes()));
                scheduleConf.setPassword(encrytedPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
            }
        }
        
        if (null != scheduleConf && !StringUtils.isEmpty(scheduleConf.getChairmanPassword()))
        {
            String encrytedChairmanPassword;
            try
            {
                encrytedChairmanPassword = Base64Utils.encode(RSA2048Utils.encode(scheduleConf.getChairmanPassword().getBytes()));
                scheduleConf.setChairmanPassword(encrytedChairmanPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode ChairmanPassword error");
            }
        }
        
        
        ScheduleRecurrenceConferenceEx scheduleRecurrenceConference = new ScheduleRecurrenceConferenceEx();
        ScheduleRecurrenceConferenceExResponse scheduleRecurrenceConferenceResp =
            new ScheduleRecurrenceConferenceExResponse();
        scheduleRecurrenceConference.setScheduleConf(scheduleConf);
        try
        {
            scheduleRecurrenceConferenceResp =
                TPProfessionalConfMgr.scheduleRecurrenceConferenceEx(scheduleRecurrenceConference);
        }
        catch (Exception e)
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
        
        LOGGER.info("begin to execute getPublicKey method");
        SDKResponse<String> key = keyServiceEx.getPublicKey();
        if (null == key || 0 != key.getResultCode())
        {
            LOGGER.info("failed to get publicKey");
            resp.setResultCode(PlatformNativeConstant.FAILED_TO_GET_PUTLIC_KEY);
            return resp;
        }
        LOGGER.info("execute getPublicKey method completed");
        
        if (null != editConf && !StringUtils.isEmpty(editConf.getPassword()))
        {
            String encrytedPassword;
            try
            {
                encrytedPassword = Base64Utils.encode(RSA2048Utils.encode(editConf.getPassword().getBytes()));
                editConf.setPassword(encrytedPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
            }
        }
        
        if (null != editConf && !StringUtils.isEmpty(editConf.getChairmanPassword()))
        {
            String encrytedChairmanPassword;
            try
            {
                encrytedChairmanPassword = Base64Utils.encode(RSA2048Utils.encode(editConf.getChairmanPassword().getBytes()));
                editConf.setChairmanPassword(encrytedChairmanPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode ChairmanPassword error");
            }
        }
        
        
        EditScheduledConfExResponse editScheduledConfExResp = new EditScheduledConfExResponse();
        EditScheduledConfEx editScheduledConfEx = new EditScheduledConfEx();
        editScheduledConfEx.setEditConf(editConf);
        try
        {
            editScheduledConfExResp = TPProfessionalConfMgr.editScheduledConfEx(editScheduledConfEx);
        }
        catch (Exception e)
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
        LOGGER.info("begin to execute getPublicKey method");
        SDKResponse<String> key = keyServiceEx.getPublicKey();
        if (null == key || 0 != key.getResultCode())
        {
            LOGGER.info("failed to get publicKey");
            resp.setResultCode(PlatformNativeConstant.FAILED_TO_GET_PUTLIC_KEY);
            return resp;
        }
        LOGGER.info("execute getPublicKey method completed");
        
        if (null != editConf && !StringUtils.isEmpty(editConf.getPassword()))
        {
            String encrytedPassword;
            try
            {
                encrytedPassword = Base64Utils.encode(RSA2048Utils.encode(editConf.getPassword().getBytes()));
                editConf.setPassword(encrytedPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode password error");
            }
        }
        
        if (null != editConf && !StringUtils.isEmpty(editConf.getChairmanPassword()))
        {
            String encrytedChairmanPassword;
            try
            {
                encrytedChairmanPassword = Base64Utils.encode(RSA2048Utils.encode(editConf.getChairmanPassword().getBytes()));
                editConf.setChairmanPassword(encrytedChairmanPassword);
            }
            catch (Exception e)
            {
                LOGGER.debug("encode ChairmanPassword error");
            }
        }
        
        
        EditRecurrenceConferenceExResponse editRecurrenceConferenceExResp = new EditRecurrenceConferenceExResponse();
        EditRecurrenceConferenceEx editRecurrenceConferenceEx = new EditRecurrenceConferenceEx();
        editRecurrenceConferenceEx.setEditConf(editConf);
        try
        {
            editRecurrenceConferenceExResp =
                TPProfessionalConfMgr.editRecurrenceConferenceEx(editRecurrenceConferenceEx);
        }
        catch (Exception e)
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
        catch (Exception e)
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
        prolongScheduledConfEx.setBeginDate(beginDate);
        prolongScheduledConfEx.setConfId(confId);
        prolongScheduledConfEx.setProlongTime(prolongTime);
        try
        {
            return TPProfessionalConfMgr.prolongScheduledConfEx(prolongScheduledConfEx).getResultCode();
        }
        catch (Exception e)
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
        querySiteStatusEx.setBeginTime(beginTime);
        querySiteStatusEx.setDuration(duration);
        querySiteStatusEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            querySiteStatusExResp = TPProfessionalConfMgr.querySiteStatusEx(querySiteStatusEx);
        }
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        synchSiteStatusEx.setBeginTime(beginTime);
        synchSiteStatusEx.setDuration(duration);
        synchSiteStatusEx.getSiteUris().addAll(null == siteUris ? new ArrayList<String>() : siteUris);
        try
        {
            synchSiteStatusExResponse = TPProfessionalConfMgr.synchSiteStatusEx(synchSiteStatusEx);
        }
        catch (Exception e)
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
        addSiteToConfEx.setBeginTime(beginTime);
        try
        {
            addSiteToConfExResp = TPProfessionalConfMgr.addSiteToConfEx(addSiteToConfEx);
        }
        catch (Exception e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = addSiteToConfExResp.getResultCode();
        resp.setResult(0 == resultCode ? addSiteToConfExResp.getSiteAccessInfos() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime)
    {
        DelSiteFromConfEx delSiteFromConfEx = new DelSiteFromConfEx();
        delSiteFromConfEx.setConfId(confId);
        delSiteFromConfEx.setSiteUri(siteUri);
        delSiteFromConfEx.setBeginTime(beginTime);
        try
        {
            return TPProfessionalConfMgr.delSiteFromConfEx(delSiteFromConfEx).getResultCode();
        }
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer delScheduledConfEx(String confId, Date beginTime)
    {
        DelScheduledConfEx delScheduledConfEx = new DelScheduledConfEx();
        delScheduledConfEx.setConfId(confId);
        delScheduledConfEx.setBeginTime(beginTime);
        try
        {
            return TPProfessionalConfMgr.delScheduledConfEx(delScheduledConfEx).getResultCode();
        }
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
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
        catch (Exception e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<Integer> queryConfCtrlPwdEx(String siteURI)
    {
        TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
        QueryConfCtrlPwdEx queryConfCtrlPwdEx = new QueryConfCtrlPwdEx();
        queryConfCtrlPwdEx.setSiteUri(siteURI);
        QueryConfCtrlPwdExResponse queryConfCtrlPwdExResp = new QueryConfCtrlPwdExResponse();
        try
        {
            queryConfCtrlPwdExResp = TPProfessionalConfCtr.queryConfCtrlPwdEx(queryConfCtrlPwdEx);
        }
        catch (Exception e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryConfCtrlPwdExResp.getResultCode();
        resp.setResult(0 == resultCode ? Integer.valueOf(queryConfCtrlPwdExResp.getResult()) : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<BroadInfoEx> queryBroadInfoEx(String siteURI)
    {
        TPSDKResponseEx<BroadInfoEx> resp = new TPSDKResponseEx<BroadInfoEx>();
        QueryBroadInfoEx queryBroadInfoEx = new QueryBroadInfoEx();
        queryBroadInfoEx.setSiteUri(siteURI);
        QueryBroadInfoExResponse queryBroadInfoExResp = new QueryBroadInfoExResponse();
        try
        {
            queryBroadInfoExResp = TPProfessionalConfCtr.queryBroadInfoEx(queryBroadInfoEx);
        }
        catch (Exception e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryBroadInfoExResp.getResultCode();
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
        catch (Exception e)
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
        catch (Exception e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setFloorEx(String confId, String siteUri)
    {
        LOGGER.debug("setFloorEx method start");
        SetFloorEx setFloorEx = new SetFloorEx();
        setFloorEx.setConfId(confId);
        setFloorEx.setSiteUri(siteUri);
        try
        {
            SetFloorExResponse result = TPProfessionalConfCtr.setFloorEx(setFloorEx);
            Integer resultCode = result.getResultCode();
            LOGGER.debug("setFloorEx method end");
            return resultCode;
        }
        catch (Exception e)
        {
            LOGGER.debug("setFloorEx method exception");
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setConfSiteVolumeEx(String confId, List<SiteVolumeEx> siteVolumes)
    {
        LOGGER.debug("setConfSiteVolumeEx method start");
        SetConfSiteVolumeEx setConfSiteVolumeEx = new SetConfSiteVolumeEx();
        setConfSiteVolumeEx.setConfId(confId);
        List<SiteVolumeEx> siteVolumeExs = setConfSiteVolumeEx.getSiteVolumes();
        if (null != siteVolumes)
        {
            siteVolumeExs.addAll(siteVolumes);
        }
        try
        {
            SetConfSiteVolumeExResponse result = TPProfessionalConfCtr.setConfSiteVolumeEx(setConfSiteVolumeEx);
            Integer resultCode = result.getResultCode();
            LOGGER.debug("setConfSiteVolumeEx method end");
            return resultCode;
        }
        catch (Exception e)
        {
            LOGGER.debug("setConfSiteVolumeEx method exception");
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer displayConfSiteLocalVideoEx(String confId, List<String> siteUris)
    {
        LOGGER.debug("displayConfSiteLocalVideoEx method start");
        DisplayConfSiteLocalVideoEx displayConfSiteLocalVideoEx = new DisplayConfSiteLocalVideoEx();
        displayConfSiteLocalVideoEx.setConfId(confId);
        List<String> siteUriExs = displayConfSiteLocalVideoEx.getSiteUris();
        if (null != siteUris)
        {
            siteUriExs.addAll(siteUris);
        }
        try
        {
            DisplayConfSiteLocalVideoExResponse result =
                TPProfessionalConfCtr.displayConfSiteLocalVideoEx(displayConfSiteLocalVideoEx);
            Integer resultCode = result.getResultCode();
            LOGGER.debug("displayConfSiteLocalVideoEx method end");
            return resultCode;
        }
        catch (Exception e)
        {
            LOGGER.debug("displayConfSiteLocalVideoEx method exception");
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer hideConfSiteLocalVideoEx(String confId, List<String> siteUris)
    {
        LOGGER.debug("hideConfSiteLocalVideoEx method start");
        HideConfSiteLocalVideoEx hideConfSiteLocalVideoEx = new HideConfSiteLocalVideoEx();
        hideConfSiteLocalVideoEx.setConfId(confId);
        List<String> siteUriExs = hideConfSiteLocalVideoEx.getSiteUris();
        if (null != siteUris)
        {
            siteUriExs.addAll(siteUris);
        }
        try
        {
            HideConfSiteLocalVideoExResponse result =
                TPProfessionalConfCtr.hideConfSiteLocalVideoEx(hideConfSiteLocalVideoEx);
            Integer resultCode = result.getResultCode();
            LOGGER.debug("hideConfSiteLocalVideoEx method end");
            return resultCode;
        }
        catch (Exception e)
        {
            LOGGER.debug("hideConfSiteLocalVideoEx method exception");
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<QuerySitesByConditionExResponse> querySitesByConditionEx(QueryConfigEx queryConfig)
    {
        
        TPSDKResponseEx<QuerySitesByConditionExResponse> resp = new TPSDKResponseEx<QuerySitesByConditionExResponse>();
        QuerySitesByConditionExResponse response = null;
        try
        {
            QuerySitesByConditionEx parameters = new QuerySitesByConditionEx();
            parameters.setQueryConfig(queryConfig);
            response = TPProfessionalConfMgr.querySitesByConditionEx(parameters);
        }
        catch (Exception e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = response.getResultCode();
        resp.setResult(0 == resultCode ? response : null);
        resp.setResultCode(resultCode);
        return resp;
    }
}
