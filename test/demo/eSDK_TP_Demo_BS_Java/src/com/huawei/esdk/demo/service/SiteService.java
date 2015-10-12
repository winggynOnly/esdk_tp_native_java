package com.huawei.esdk.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.demo.autogen.AuxStreamInfoEx;
import com.huawei.esdk.demo.autogen.CameraControlEx;
import com.huawei.esdk.demo.autogen.CtrlCameraEx;
import com.huawei.esdk.demo.autogen.IsConnectAuxSourceEx;
import com.huawei.esdk.demo.autogen.IsConnectAuxSourceExResponse;
import com.huawei.esdk.demo.autogen.IsReceiveRemAuxStrmEx;
import com.huawei.esdk.demo.autogen.IsReceiveRemAuxStrmExResponse;
import com.huawei.esdk.demo.autogen.IsSendAuxStreamEx;
import com.huawei.esdk.demo.autogen.IsSendAuxStreamExResponse;
import com.huawei.esdk.demo.autogen.QueryAuxStreamSourcesEx;
import com.huawei.esdk.demo.autogen.QueryAuxStreamSourcesExResponse;
import com.huawei.esdk.demo.autogen.QueryMainStreamSourcesEx;
import com.huawei.esdk.demo.autogen.QueryMainStreamSourcesExResponse;
import com.huawei.esdk.demo.autogen.QuerySiteVersionInfoEx;
import com.huawei.esdk.demo.autogen.QuerySiteVersionInfoExResponse;
import com.huawei.esdk.demo.autogen.QueryVideoOutSrcStateEx;
import com.huawei.esdk.demo.autogen.QueryVideoOutSrcStateExResponse;
import com.huawei.esdk.demo.autogen.SetAuxStreamEx;
import com.huawei.esdk.demo.autogen.SetMainAuxStreamSourcesEx;
import com.huawei.esdk.demo.autogen.SetVideoOutSrcEx;
import com.huawei.esdk.demo.autogen.SiteDeviceVersionInfoEx;
import com.huawei.esdk.demo.autogen.TPProfessionalSiteMgr;
import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.autogen.VideoSourcesInfoEx;
import com.huawei.esdk.demo.utils.ClientProvider;
import com.huawei.esdk.demo.utils.ExceptionUtils;

public class SiteService
{
    private TPProfessionalSiteMgr tPProfessionalSiteMgr =
        (TPProfessionalSiteMgr)ClientProvider.getClient(TPProfessionalSiteMgr.class);
    
    private static SiteService instance = null;
    
    public static synchronized SiteService getInstance()
    {
        if (null == instance)
        {
            instance = new SiteService();
        }
        return instance;
    }
    
    public TPSDKResponseEx<Integer> isConnectAuxSourceEx(String siteURI)
    {
        TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
        IsConnectAuxSourceEx isConnectAuxSourceEx = new IsConnectAuxSourceEx();
        IsConnectAuxSourceExResponse isConnectAuxSourceExResp = new IsConnectAuxSourceExResponse();
        isConnectAuxSourceEx.setSiteUri(siteURI);
        try
        {
            isConnectAuxSourceExResp = tPProfessionalSiteMgr.isConnectAuxSourceEx(isConnectAuxSourceEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = isConnectAuxSourceExResp.getResultCode();
        resp.setResult(0 == resultCode ? isConnectAuxSourceExResp.getResult() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<Integer> isSendAuxStreamEx(String siteURI)
    {
        TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
        IsSendAuxStreamEx isSendAuxStreamEx = new IsSendAuxStreamEx();
        IsSendAuxStreamExResponse isSendAuxStreamExResp = new IsSendAuxStreamExResponse();
        isSendAuxStreamEx.setSiteUri(siteURI);
        try
        {
            isSendAuxStreamExResp = tPProfessionalSiteMgr.isSendAuxStreamEx(isSendAuxStreamEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = isSendAuxStreamExResp.getResultCode();
        resp.setResult(0 == resultCode ? isSendAuxStreamExResp.getResult() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public TPSDKResponseEx<Integer> isReceiveRemAuxStrmEx(String siteURI)
    {
        TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
        IsReceiveRemAuxStrmEx isReceiveRemAuxStrmEx = new IsReceiveRemAuxStrmEx();
        IsReceiveRemAuxStrmExResponse isReceiveRemAuxStrmExResp = new IsReceiveRemAuxStrmExResponse();
        isReceiveRemAuxStrmEx.setSiteUri(siteURI);
        try
        {
            isReceiveRemAuxStrmExResp = tPProfessionalSiteMgr.isReceiveRemAuxStrmEx(isReceiveRemAuxStrmEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = isReceiveRemAuxStrmExResp.getResultCode();
        resp.setResult(0 == resultCode ? isReceiveRemAuxStrmExResp.getResult() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer setAuxStreamEx(String siteUri, Integer controlCode)
    {
        SetAuxStreamEx setAuxStreamEx = new SetAuxStreamEx();
        setAuxStreamEx.setSiteUri(siteUri);
        setAuxStreamEx.setControlCode(controlCode);
        try
        {
            return tPProfessionalSiteMgr.setAuxStreamEx(setAuxStreamEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<Map<Integer, String>> queryAuxStreamSourcesEx(String siteURI)
    {
        TPSDKResponseEx<Map<Integer, String>> resp = new TPSDKResponseEx<Map<Integer, String>>();
        QueryAuxStreamSourcesEx queryAuxStreamSourcesEx = new QueryAuxStreamSourcesEx();
        QueryAuxStreamSourcesExResponse queryAuxStreamSourcesExResp = new QueryAuxStreamSourcesExResponse();
        queryAuxStreamSourcesEx.setSiteUri(siteURI);
        try
        {
            queryAuxStreamSourcesExResp = tPProfessionalSiteMgr.queryAuxStreamSourcesEx(queryAuxStreamSourcesEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryAuxStreamSourcesExResp.getResultCode();
        resp.setResultCode(resultCode);
        if (0 == resultCode)
        {
            Map<Integer, String> map = new HashMap<Integer, String>();
            //for (AuxStreamInfoEx auxStreamInfoEx : queryAuxStreamSourcesExResp.getAuxStream())
            for (AuxStreamInfoEx auxStreamInfoEx : queryAuxStreamSourcesExResp.getAuxStreams())
            {
                map.put(auxStreamInfoEx.getId(), auxStreamInfoEx.getName());
            }
            resp.setResult(map);
        }
        return resp;
    }
    
    public TPSDKResponseEx<List<VideoSourcesInfoEx>> queryVideoOutSrcStateEx(String siteURI)
    {
        TPSDKResponseEx<List<VideoSourcesInfoEx>> resp = new TPSDKResponseEx<List<VideoSourcesInfoEx>>();
        QueryVideoOutSrcStateEx queryVideoOutSrcStateEx = new QueryVideoOutSrcStateEx();
        QueryVideoOutSrcStateExResponse queryVideoOutSrcStateExResp = new QueryVideoOutSrcStateExResponse();
        queryVideoOutSrcStateEx.setSiteUri(siteURI);
        try
        {
            queryVideoOutSrcStateExResp = tPProfessionalSiteMgr.queryVideoOutSrcStateEx(queryVideoOutSrcStateEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryVideoOutSrcStateExResp.getResultCode();
        //resp.setResult(0 == resultCode ? queryVideoOutSrcStateExResp.getVideoSourcesInfoExs() : null);
        resp.setResult(0 == resultCode ? queryVideoOutSrcStateExResp.getVideoSourcesInfos() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
    public Integer ctrlCameraEx(String siteUri, CameraControlEx cameraControl)
    {
        CtrlCameraEx ctrlCameraEx = new CtrlCameraEx();
        ctrlCameraEx.setSiteUri(siteUri);
        ctrlCameraEx.setCameraControl(cameraControl);
        try
        {
            return tPProfessionalSiteMgr.ctrlCameraEx(ctrlCameraEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer setMainAuxStreamSourcesEx(String siteUri, Integer localMainSrc, Integer localAuxSrc)
    {
        SetMainAuxStreamSourcesEx setMainAuxStreamSourcesEx = new SetMainAuxStreamSourcesEx();
        setMainAuxStreamSourcesEx.setLocalAuxSrc(localAuxSrc);
        //setMainAuxStreamSourcesEx.setLocalMainSrc(localMainSrc);
        setMainAuxStreamSourcesEx.getLocalMainSrcs().add(localMainSrc);
        setMainAuxStreamSourcesEx.setSiteUri(siteUri);
        try
        {
            return tPProfessionalSiteMgr.setMainAuxStreamSourcesEx(setMainAuxStreamSourcesEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<Map<Integer, String>> queryMainStreamSourcesEx(String siteUri)
    {
        TPSDKResponseEx<Map<Integer, String>> resp = new TPSDKResponseEx<Map<Integer, String>>();
        QueryMainStreamSourcesEx queryMainStreamSourcesEx = new QueryMainStreamSourcesEx();
        QueryMainStreamSourcesExResponse queryMainStreamSourcesExResp = new QueryMainStreamSourcesExResponse();
        queryMainStreamSourcesEx.setSiteUri(siteUri);
        try
        {
            queryMainStreamSourcesExResp = tPProfessionalSiteMgr.queryMainStreamSourcesEx(queryMainStreamSourcesEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = queryMainStreamSourcesExResp.getResultCode();
        resp.setResultCode(resultCode);
        if (0 == resultCode)
        {
            Map<Integer, String> map = new HashMap<Integer, String>();
            for (AuxStreamInfoEx auxStreamInfoEx : queryMainStreamSourcesExResp.getAuxStreams())
            {
                map.put(auxStreamInfoEx.getId(), auxStreamInfoEx.getName());
            }
            resp.setResult(map);
        }
        return resp;
    }
    
    public Integer setVideoOutSrcEx(String siteUri, Integer hdOut, Integer videoSrc)
    {
        SetVideoOutSrcEx setVideoOutSrcEx = new SetVideoOutSrcEx();
        setVideoOutSrcEx.setSiteUri(siteUri);
        setVideoOutSrcEx.setHdOut(hdOut);
        setVideoOutSrcEx.setVideoSrc(videoSrc);
        try
        {
            return tPProfessionalSiteMgr.setVideoOutSrcEx(setVideoOutSrcEx).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public TPSDKResponseEx<SiteDeviceVersionInfoEx> querySiteVersionInfoEx(String siteURI)
    {
        TPSDKResponseEx<SiteDeviceVersionInfoEx> resp = new TPSDKResponseEx<SiteDeviceVersionInfoEx>();
        QuerySiteVersionInfoEx querySiteVersionInfoEx = new QuerySiteVersionInfoEx();
        QuerySiteVersionInfoExResponse querySiteVersionInfoExResp = new QuerySiteVersionInfoExResponse();
        querySiteVersionInfoEx.setSiteUri(siteURI);
        
        try
        {
            querySiteVersionInfoExResp = tPProfessionalSiteMgr.querySiteVersionInfoEx(querySiteVersionInfoEx);
        }
        catch (SOAPFaultException e)
        {
            ExceptionUtils.processSoapException(resp, e);
            return resp;
        }
        Integer resultCode = querySiteVersionInfoExResp.getResultCode();
        //resp.setResult(0 == resultCode ? querySiteVersionInfoExResp.getSiteDeviceVersionInfoEx() : null);
        resp.setResult(0 == resultCode ? querySiteVersionInfoExResp.getSiteDeviceVersionInfo() : null);
        resp.setResultCode(resultCode);
        return resp;
    }
    
}
