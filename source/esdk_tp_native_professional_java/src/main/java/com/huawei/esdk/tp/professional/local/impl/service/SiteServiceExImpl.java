package com.huawei.esdk.tp.professional.local.impl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huawei.esdk.tp.professional.local.bean.CameraControlEx;
import com.huawei.esdk.tp.professional.local.bean.SiteDeviceVersionInfoEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.bean.VideoSourcesInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.AuxStreamInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.CtrlCameraEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsConnectAuxSourceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsConnectAuxSourceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsReceiveRemAuxStrmEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsReceiveRemAuxStrmExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsSendAuxStreamEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.IsSendAuxStreamExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryAuxStreamSourcesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryAuxStreamSourcesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryMainStreamSourcesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryMainStreamSourcesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteVersionInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteVersionInfoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryVideoOutSrcStateEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryVideoOutSrcStateExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetAuxStreamEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetMainAuxStreamSourcesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoOutSrcEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SiteMicVersionMapEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalSiteMgr;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.tp.professional.local.impl.utils.ExceptionUtils;
import com.huawei.esdk.tp.professional.local.site.SiteServiceEx;

public class SiteServiceExImpl implements SiteServiceEx {
	private TPProfessionalSiteMgr tPProfessionalSiteMgr = (TPProfessionalSiteMgr)ClientProvider.getClient(TPProfessionalSiteMgr.class);
    private static SiteServiceExImpl instance = null;
	
	public static synchronized SiteServiceExImpl getInstance()
	{
		if (null == instance) {
			instance = new SiteServiceExImpl();
		}
		return instance;
	}
	
	public TPSDKResponseEx<Integer> isConnectAuxSourceEx(String siteURI) {
		TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
		IsConnectAuxSourceEx isConnectAuxSourceEx = new IsConnectAuxSourceEx();
		IsConnectAuxSourceExResponse isConnectAuxSourceExResp = new IsConnectAuxSourceExResponse();
		isConnectAuxSourceEx.setSiteUri(siteURI);
		try {
			isConnectAuxSourceExResp = tPProfessionalSiteMgr.isConnectAuxSourceEx(isConnectAuxSourceEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = isConnectAuxSourceExResp.getResultCode();
		resp.setResult(0 == resultCode ? isConnectAuxSourceExResp.getResult() : null);
		resp.setResultCode(resultCode);
		return resp;
	}

	
	public TPSDKResponseEx<Integer> isSendAuxStreamEx(String siteURI) {
		TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
		IsSendAuxStreamEx isSendAuxStreamEx = new IsSendAuxStreamEx();
		IsSendAuxStreamExResponse isSendAuxStreamExResp = new IsSendAuxStreamExResponse();
		isSendAuxStreamEx.setSiteUri(siteURI);
		try {
			isSendAuxStreamExResp = tPProfessionalSiteMgr.isSendAuxStreamEx(isSendAuxStreamEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = isSendAuxStreamExResp.getResultCode();
		resp.setResult(0 == resultCode ? isSendAuxStreamExResp.getResult() : null);
		resp.setResultCode(resultCode);
		return resp;
	}

	
	public TPSDKResponseEx<Integer> isReceiveRemAuxStrmEx(String siteURI) {
		TPSDKResponseEx<Integer> resp = new TPSDKResponseEx<Integer>();
		IsReceiveRemAuxStrmEx isReceiveRemAuxStrmEx = new IsReceiveRemAuxStrmEx();
		IsReceiveRemAuxStrmExResponse isReceiveRemAuxStrmExResp = new IsReceiveRemAuxStrmExResponse();
		isReceiveRemAuxStrmEx.setSiteUri(siteURI);
		try {
			isReceiveRemAuxStrmExResp = tPProfessionalSiteMgr.isReceiveRemAuxStrmEx(isReceiveRemAuxStrmEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = isReceiveRemAuxStrmExResp.getResultCode();
		resp.setResult(0 == resultCode ? isReceiveRemAuxStrmExResp.getResult() : null);
		resp.setResultCode(resultCode);
		return resp;
	}

	
	public Integer setAuxStreamEx(String siteUri, Integer controlCode) {
		SetAuxStreamEx setAuxStreamEx = new SetAuxStreamEx();
		setAuxStreamEx.setSiteUri(siteUri);
		setAuxStreamEx.setControlCode(controlCode);
		try {
			return tPProfessionalSiteMgr.setAuxStreamEx(setAuxStreamEx).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public TPSDKResponseEx<Map<Integer, String>> queryAuxStreamSourcesEx(
			String siteURI) {
		TPSDKResponseEx<Map<Integer, String>> resp = new TPSDKResponseEx<Map<Integer, String>>();
		QueryAuxStreamSourcesEx queryAuxStreamSourcesEx = new QueryAuxStreamSourcesEx();
		QueryAuxStreamSourcesExResponse queryAuxStreamSourcesExResp = new QueryAuxStreamSourcesExResponse();
		queryAuxStreamSourcesEx.setSiteUri(siteURI);
		try {
			queryAuxStreamSourcesExResp = tPProfessionalSiteMgr.queryAuxStreamSourcesEx(queryAuxStreamSourcesEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = queryAuxStreamSourcesExResp.getResultCode();
		resp.setResultCode(resultCode);
		if (0 == resultCode) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (AuxStreamInfoEx auxStreamInfoEx : queryAuxStreamSourcesExResp.getAuxStreams()) {
				map.put(auxStreamInfoEx.getId(), auxStreamInfoEx.getName());
			}
			resp.setResult(map);
		}
		return resp;
	}

	
	public TPSDKResponseEx<List<VideoSourcesInfoEx>> queryVideoOutSrcStateEx(
			String siteURI) {
		TPSDKResponseEx<List<VideoSourcesInfoEx>> resp = new TPSDKResponseEx<List<VideoSourcesInfoEx>>();
		QueryVideoOutSrcStateEx queryVideoOutSrcStateEx = new QueryVideoOutSrcStateEx();
		QueryVideoOutSrcStateExResponse queryVideoOutSrcStateExResp = new QueryVideoOutSrcStateExResponse();
		queryVideoOutSrcStateEx.setSiteUri(siteURI);
		try {
			queryVideoOutSrcStateExResp = tPProfessionalSiteMgr.queryVideoOutSrcStateEx(queryVideoOutSrcStateEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = queryVideoOutSrcStateExResp.getResultCode();
		resp.setResult(0 == resultCode ? queryVideoOutSrcStateExResp.getVideoSourcesInfos() : null);
		resp.setResultCode(resultCode);
		return resp;
	}

	
	public Integer ctrlCameraEx(String siteUri, CameraControlEx cameraControl) {
		CtrlCameraEx ctrlCameraEx = new CtrlCameraEx();
		ctrlCameraEx.setSiteUri(siteUri);
		ctrlCameraEx.setCameraControl(cameraControl);
		try {
			return tPProfessionalSiteMgr.ctrlCameraEx(ctrlCameraEx).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public Integer setMainAuxStreamSourcesEx(String siteUri,
			List<Integer> localMainSrc, Integer localAuxSrc) {
		SetMainAuxStreamSourcesEx setMainAuxStreamSourcesEx = new SetMainAuxStreamSourcesEx();
		setMainAuxStreamSourcesEx.setLocalAuxSrc(localAuxSrc);
		setMainAuxStreamSourcesEx.setLocalMainSrcs(localMainSrc);
		setMainAuxStreamSourcesEx.setSiteUri(siteUri);
		try {
			return tPProfessionalSiteMgr.setMainAuxStreamSourcesEx(setMainAuxStreamSourcesEx).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public TPSDKResponseEx<Map<Integer, String>> queryMainStreamSourcesEx(
			String siteUri) {
		TPSDKResponseEx<Map<Integer, String>> resp = new TPSDKResponseEx<Map<Integer, String>>();
		QueryMainStreamSourcesEx queryMainStreamSourcesEx = new QueryMainStreamSourcesEx();
		QueryMainStreamSourcesExResponse queryMainStreamSourcesExResp = new QueryMainStreamSourcesExResponse();
		queryMainStreamSourcesEx.setSiteUri(siteUri);
		try {
			queryMainStreamSourcesExResp = tPProfessionalSiteMgr.queryMainStreamSourcesEx(queryMainStreamSourcesEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = queryMainStreamSourcesExResp.getResultCode();
		resp.setResultCode(resultCode);
		if (0 == resultCode) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (AuxStreamInfoEx auxStreamInfoEx : queryMainStreamSourcesExResp.getAuxStreams()) {
				map.put(auxStreamInfoEx.getId(), auxStreamInfoEx.getName());
			}
			resp.setResult(map);
		}
		return resp;
	}

	
	public Integer setVideoOutSrcEx(String siteUri, Integer hdOut,
			Integer videoSrc) {
		SetVideoOutSrcEx setVideoOutSrcEx = new SetVideoOutSrcEx();
		setVideoOutSrcEx.setSiteUri(siteUri);
		setVideoOutSrcEx.setHdOut(hdOut);
		setVideoOutSrcEx.setVideoSrc(videoSrc);
		try {
			return tPProfessionalSiteMgr.setVideoOutSrcEx(setVideoOutSrcEx).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public TPSDKResponseEx<SiteDeviceVersionInfoEx> querySiteVersionInfoEx(
			String siteURI) {
		TPSDKResponseEx<SiteDeviceVersionInfoEx> resp = new TPSDKResponseEx<SiteDeviceVersionInfoEx>();
		QuerySiteVersionInfoEx querySiteVersionInfoEx = new QuerySiteVersionInfoEx();
		QuerySiteVersionInfoExResponse querySiteVersionInfoExResp = new QuerySiteVersionInfoExResponse();
		querySiteVersionInfoEx.setSiteUri(siteURI);
		
		try {
			querySiteVersionInfoExResp = tPProfessionalSiteMgr.querySiteVersionInfoEx(querySiteVersionInfoEx);
		} catch (Exception e) {
			 ExceptionUtils.processSoapException(resp,e);
			 return resp;
		}
		Integer resultCode = querySiteVersionInfoExResp.getResultCode();
		com.huawei.esdk.tp.professional.local.impl.autogen.SiteDeviceVersionInfoEx info = querySiteVersionInfoExResp.getSiteDeviceVersionInfo();
		SiteDeviceVersionInfoEx siteDeviceVersionInfoEx = null;
		if (null != info) {
			siteDeviceVersionInfoEx = new SiteDeviceVersionInfoEx();
			siteDeviceVersionInfoEx.setHardVersion(info.getHardVersion());
			siteDeviceVersionInfoEx.setLicense(info.getLicense());
			siteDeviceVersionInfoEx.setLogicVersion(info.getLogicVersion());
			siteDeviceVersionInfoEx.setManufacturer(info.getManufacturer());
			siteDeviceVersionInfoEx.setModel(info.getModel());
			siteDeviceVersionInfoEx.setSoftVersion(info.getSoftVersion());
			Map<String,String> micVersion = new HashMap<String,String>();
			for (SiteMicVersionMapEx versionMap : info.getMicVersions()) {
				micVersion.put(versionMap.getMicIP(), versionMap.getVersion());
			}
			
			siteDeviceVersionInfoEx.setMicVersion(micVersion);
		}
		resp.setResult(0 == resultCode ? siteDeviceVersionInfoEx : null);
		resp.setResultCode(resultCode);
		return resp;
	}

}
