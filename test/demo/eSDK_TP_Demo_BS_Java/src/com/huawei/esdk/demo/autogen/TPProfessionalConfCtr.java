package com.huawei.esdk.demo.autogen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.1
 * 2014-04-29T10:32:46.562+08:00
 * Generated source version: 2.6.1
 * 
 */
@WebService(targetNamespace = "http://smc.huawei.com/", name = "TPProfessional.ConfCtr")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TPProfessionalConfCtr {

    @WebResult(name = "requestChairExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/requestChairEx")
    public RequestChairExResponse requestChairEx(
        @WebParam(partName = "parameters", name = "requestChairEx", targetNamespace = "http://smc.huawei.com/")
        RequestChairEx parameters
    );

    @WebResult(name = "setConfSiteVolumeExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setConfSiteVolumeEx")
    public SetConfSiteVolumeExResponse setConfSiteVolumeEx(
        @WebParam(partName = "parameters", name = "setConfSiteVolumeEx", targetNamespace = "http://smc.huawei.com/")
        SetConfSiteVolumeEx parameters
    );

    @WebResult(name = "queryHistoryRecordAddrExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryHistoryRecordAddrEx")
    public QueryHistoryRecordAddrExResponse queryHistoryRecordAddrEx(
        @WebParam(partName = "parameters", name = "queryHistoryRecordAddrEx", targetNamespace = "http://smc.huawei.com/")
        QueryHistoryRecordAddrEx parameters
    );

    @WebResult(name = "setBroadcastContinuousPresenceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setBroadcastContinuousPresenceEx")
    public SetBroadcastContinuousPresenceExResponse setBroadcastContinuousPresenceEx(
        @WebParam(partName = "parameters", name = "setBroadcastContinuousPresenceEx", targetNamespace = "http://smc.huawei.com/")
        SetBroadcastContinuousPresenceEx parameters
    );

    @WebResult(name = "stopRecordingExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/stopRecordingEx")
    public StopRecordingExResponse stopRecordingEx(
        @WebParam(partName = "parameters", name = "stopRecordingEx", targetNamespace = "http://smc.huawei.com/")
        StopRecordingEx parameters
    );

    @WebResult(name = "setSitesQuietExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setSitesQuietEx")
    public SetSitesQuietExResponse setSitesQuietEx(
        @WebParam(partName = "parameters", name = "setSitesQuietEx", targetNamespace = "http://smc.huawei.com/")
        SetSitesQuietEx parameters
    );

    @WebResult(name = "hideConfSiteLocalVideoExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/hideConfSiteLocalVideoEx")
    public HideConfSiteLocalVideoExResponse hideConfSiteLocalVideoEx(
        @WebParam(partName = "parameters", name = "hideConfSiteLocalVideoEx", targetNamespace = "http://smc.huawei.com/")
        HideConfSiteLocalVideoEx parameters
    );

    @WebResult(name = "setAudioSwitchExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setAudioSwitchEx")
    public SetAudioSwitchExResponse setAudioSwitchEx(
        @WebParam(partName = "parameters", name = "setAudioSwitchEx", targetNamespace = "http://smc.huawei.com/")
        SetAudioSwitchEx parameters
    );

    @WebResult(name = "setFloorExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setFloorEx")
    public SetFloorExResponse setFloorEx(
        @WebParam(partName = "parameters", name = "setFloorEx", targetNamespace = "http://smc.huawei.com/")
        SetFloorEx parameters
    );

    @WebResult(name = "releaseChairExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/releaseChairEx")
    public ReleaseChairExResponse releaseChairEx(
        @WebParam(partName = "parameters", name = "releaseChairEx", targetNamespace = "http://smc.huawei.com/")
        ReleaseChairEx parameters
    );

    @WebResult(name = "setRecordBroadExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setRecordBroadEx")
    public SetRecordBroadExResponse setRecordBroadEx(
        @WebParam(partName = "parameters", name = "setRecordBroadEx", targetNamespace = "http://smc.huawei.com/")
        SetRecordBroadEx parameters
    );

    @WebResult(name = "queryBroadInfoExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryBroadInfoEx")
    public QueryBroadInfoExResponse queryBroadInfoEx(
        @WebParam(partName = "parameters", name = "queryBroadInfoEx", targetNamespace = "http://smc.huawei.com/")
        QueryBroadInfoEx parameters
    );

    @WebResult(name = "setBroadcastSiteExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setBroadcastSiteEx")
    public SetBroadcastSiteExResponse setBroadcastSiteEx(
        @WebParam(partName = "parameters", name = "setBroadcastSiteEx", targetNamespace = "http://smc.huawei.com/")
        SetBroadcastSiteEx parameters
    );

    @WebResult(name = "startRecordingExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/startRecordingEx")
    public StartRecordingExResponse startRecordingEx(
        @WebParam(partName = "parameters", name = "startRecordingEx", targetNamespace = "http://smc.huawei.com/")
        StartRecordingEx parameters
    );

    @WebResult(name = "setContinuousPresenceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setContinuousPresenceEx")
    public SetContinuousPresenceExResponse setContinuousPresenceEx(
        @WebParam(partName = "parameters", name = "setContinuousPresenceEx", targetNamespace = "http://smc.huawei.com/")
        SetContinuousPresenceEx parameters
    );

    @WebResult(name = "queryConfCtrlPwdExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryConfCtrlPwdEx")
    public QueryConfCtrlPwdExResponse queryConfCtrlPwdEx(
        @WebParam(partName = "parameters", name = "queryConfCtrlPwdEx", targetNamespace = "http://smc.huawei.com/")
        QueryConfCtrlPwdEx parameters
    );

    @WebResult(name = "setSitesMuteExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setSitesMuteEx")
    public SetSitesMuteExResponse setSitesMuteEx(
        @WebParam(partName = "parameters", name = "setSitesMuteEx", targetNamespace = "http://smc.huawei.com/")
        SetSitesMuteEx parameters
    );

    @WebResult(name = "setVideoSourceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setVideoSourceEx")
    public SetVideoSourceExResponse setVideoSourceEx(
        @WebParam(partName = "parameters", name = "setVideoSourceEx", targetNamespace = "http://smc.huawei.com/")
        SetVideoSourceEx parameters
    );

    @WebResult(name = "startLiveBroadcastExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/startLiveBroadcastEx")
    public StartLiveBroadcastExResponse startLiveBroadcastEx(
        @WebParam(partName = "parameters", name = "startLiveBroadcastEx", targetNamespace = "http://smc.huawei.com/")
        StartLiveBroadcastEx parameters
    );

    @WebResult(name = "setDirectBroadExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setDirectBroadEx")
    public SetDirectBroadExResponse setDirectBroadEx(
        @WebParam(partName = "parameters", name = "setDirectBroadEx", targetNamespace = "http://smc.huawei.com/")
        SetDirectBroadEx parameters
    );

    @WebResult(name = "displayConfSiteLocalVideoExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/displayConfSiteLocalVideoEx")
    public DisplayConfSiteLocalVideoExResponse displayConfSiteLocalVideoEx(
        @WebParam(partName = "parameters", name = "displayConfSiteLocalVideoEx", targetNamespace = "http://smc.huawei.com/")
        DisplayConfSiteLocalVideoEx parameters
    );

    @WebResult(name = "setRecordingVideoSourceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setRecordingVideoSourceEx")
    public SetRecordingVideoSourceExResponse setRecordingVideoSourceEx(
        @WebParam(partName = "parameters", name = "setRecordingVideoSourceEx", targetNamespace = "http://smc.huawei.com/")
        SetRecordingVideoSourceEx parameters
    );

    @WebResult(name = "stopLiveBroadcastExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/stopLiveBroadcastEx")
    public StopLiveBroadcastExResponse stopLiveBroadcastEx(
        @WebParam(partName = "parameters", name = "stopLiveBroadcastEx", targetNamespace = "http://smc.huawei.com/")
        StopLiveBroadcastEx parameters
    );
}
