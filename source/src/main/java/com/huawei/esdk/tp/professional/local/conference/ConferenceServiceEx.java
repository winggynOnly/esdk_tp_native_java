package com.huawei.esdk.tp.professional.local.conference;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;

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

public interface ConferenceServiceEx
{
    TPSDKResponseEx<ConferenceInfoEx> scheduleConfEx(ConferenceInfoEx scheduleConf);
    
    TPSDKResponseEx<RecurrenceConfInfoEx> scheduleRecurrenceConferenceEx(RecurrenceConfInfoEx scheduleConf);
    
    TPSDKResponseEx<ConferenceInfoEx> editScheduledConfEx(ConferenceInfoEx editConf);
    
    TPSDKResponseEx<RecurrenceConfInfoEx> editRecurrenceConferenceEx(RecurrenceConfInfoEx editConf);
    
    TPSDKResponseEx<List<SiteInfoEx>> querySitesEx();
    
    Integer prolongScheduledConfEx(String confId, Date beginDate, Duration prolongTime);
    
    TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> querySiteStatusEx(List<String> siteUris, Date beginTime,
        Duration duration);
    
    TPSDKResponseEx<List<ConferenceStatusEx>> queryConferencesStatusEx(List<String> confIds);
    
    TPSDKResponseEx<List<SiteStatusEx>> queryConfSitesStatusEx(String confId, List<String> siteUris);
    
    TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> synchSiteStatusEx(List<String> siteUris, Date beginTime,
        Duration duration);
    
    TPSDKResponseEx<List<SiteAccessInfoEx>> addSiteToConfEx(String confId, SiteInfoEx siteInfo, Date beginTime);
    
    Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime);
    
    Integer connectSitesEx(String confId, List<String> siteUris);
    
    Integer disconnectSitesEx(String confId, List<String> siteUris);
    
    Integer delScheduledConfEx(String confId, Date beginTime);
    
    Integer setVideoSourceEx(String confId, String siteUri, String videoSourceUri, Integer isLock);
    
    Integer setAudioSwitchEx(String confId, Integer switchGate, Integer isSwitch);
    
    Integer setBroadcastSiteEx(String confId, String siteUri, Integer isBroadcast);
    
    Integer setBroadcastContinuousPresenceEx(String confId, Integer isBroadcast);
    
    Integer setSitesMuteEx(String confId, List<String> siteUris, Integer isMute);
    
    Integer setSitesQuietEx(String confId, List<String> siteUris, Integer isQuiet);
    
    Integer setContinuousPresenceEx(String confId, String target, Integer presenceMode, List<String> subPics);
    
    Integer requestChairEx(String siteURI);
    
    Integer releaseChairEx(String siteURI);
    
    TPSDKResponseEx<Integer> queryConfCtrlPwdEx(String siteURI);
    
    TPSDKResponseEx<BroadInfoEx> queryBroadInfoEx(String siteURI);
    
    Integer setRecordBroadEx(String siteURI, Integer action);
    
    Integer setDirectBroadEx(String siteURI, Integer action);
    
    Integer setFloorEx(String confId, String siteUri);
    
    Integer setConfSiteVolumeEx(String confId, List<SiteVolumeEx> siteVolumes);
    
    Integer displayConfSiteLocalVideoEx(String confId, List<String> siteUris);
    
    Integer hideConfSiteLocalVideoEx(String confId, List<String> siteUris);
    
    TPSDKResponseEx<QuerySitesByConditionExResponse> querySitesByConditionEx(QueryConfigEx queryConfig);
}