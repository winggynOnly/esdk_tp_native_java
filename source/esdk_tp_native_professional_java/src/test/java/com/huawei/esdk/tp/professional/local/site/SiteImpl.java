package com.huawei.esdk.tp.professional.local.site;

import java.util.ArrayList;
import java.util.List;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.tp.professional.local.MyFaultException;
import com.huawei.esdk.tp.professional.local.bean.VideoSourcesInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.CtrlCameraEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.CtrlCameraExResponse;
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
import com.huawei.esdk.tp.professional.local.impl.autogen.SetAuxStreamExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetMainAuxStreamSourcesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetMainAuxStreamSourcesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoOutSrcEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoOutSrcExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SiteDeviceVersionInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalSiteMgr;

public class SiteImpl implements TPProfessionalSiteMgr {

	public static int isConnectAuxSourceExResult = 0;
	public static int querySiteVersionInfoExResult = 0;
	public static int queryAuxStreamSourcesExResult = 0;
	public static int setVideoOutSrcExResult = 0;
	public static int isSendAuxStreamExResult = 0;
	public static int queryVideoOutSrcStateExResult = 0;
	public static int ctrlCameraExResult = 0;
	public static int setAuxStreamExResult = 0;
	public static int isReceiveRemAuxStrmExResult = 0;
	public static int queryMainStreamSourcesExResult = 0;
	public static int setMainAuxStreamSourcesExResult = 0;
	
	public static boolean throwException = false;
	public static int exceptionCode = 0; 
	
	private SOAPFaultException getSOAPFaultException(){
		SOAPFaultException se = null;
		try {
			SOAPFault fault = new MyFaultException();
			fault.setFaultCode(String.valueOf(exceptionCode));
			se = new SOAPFaultException(fault);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return se;
	}

	@Override
	public SetMainAuxStreamSourcesExResponse setMainAuxStreamSourcesEx(
			SetMainAuxStreamSourcesEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetMainAuxStreamSourcesExResponse resp = new SetMainAuxStreamSourcesExResponse();
		resp.setResultCode(setMainAuxStreamSourcesExResult);
		return resp;
	}

	@Override
	public QueryMainStreamSourcesExResponse queryMainStreamSourcesEx(
			QueryMainStreamSourcesEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryMainStreamSourcesExResponse resp = new QueryMainStreamSourcesExResponse();
		resp.setResultCode(queryMainStreamSourcesExResult);
		return resp;
	}

	@Override
	public IsReceiveRemAuxStrmExResponse isReceiveRemAuxStrmEx(
			IsReceiveRemAuxStrmEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		IsReceiveRemAuxStrmExResponse resp = new IsReceiveRemAuxStrmExResponse();
		resp.setResultCode(isReceiveRemAuxStrmExResult);
		return resp;
	}

	@Override
	public SetAuxStreamExResponse setAuxStreamEx(SetAuxStreamEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetAuxStreamExResponse resp = new SetAuxStreamExResponse();
		resp.setResultCode(setAuxStreamExResult);
		return resp;
	}

	@Override
	public CtrlCameraExResponse ctrlCameraEx(CtrlCameraEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		CtrlCameraExResponse resp = new CtrlCameraExResponse();
		resp.setResultCode(ctrlCameraExResult);
		return resp;
	}

	@Override
	public QueryVideoOutSrcStateExResponse queryVideoOutSrcStateEx(
			QueryVideoOutSrcStateEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryVideoOutSrcStateExResponse resp = new QueryVideoOutSrcStateExResponse();
		resp.setResultCode(queryVideoOutSrcStateExResult);
		List<VideoSourcesInfoEx> list = new ArrayList<VideoSourcesInfoEx>();
		VideoSourcesInfoEx info1 = new VideoSourcesInfoEx();
		info1.setSourcesId(1);
		info1.setSourcesName("HD-SDI");
		info1.setSourcesState(1);
		list.add(info1);
		resp.getVideoSourcesInfos().addAll(list);
		return resp;
	}

	@Override
	public IsSendAuxStreamExResponse isSendAuxStreamEx(
			IsSendAuxStreamEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		IsSendAuxStreamExResponse resp = new IsSendAuxStreamExResponse();
		resp.setResultCode(isSendAuxStreamExResult);
		return resp;
	}

	@Override
	public SetVideoOutSrcExResponse setVideoOutSrcEx(SetVideoOutSrcEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetVideoOutSrcExResponse resp = new SetVideoOutSrcExResponse();
		resp.setResultCode(setVideoOutSrcExResult);
		return resp;
	}

	@Override
	public QueryAuxStreamSourcesExResponse queryAuxStreamSourcesEx(
			QueryAuxStreamSourcesEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryAuxStreamSourcesExResponse resp = new QueryAuxStreamSourcesExResponse();
		resp.setResultCode(queryAuxStreamSourcesExResult);
		return resp;
	}

	@Override
	public QuerySiteVersionInfoExResponse querySiteVersionInfoEx(
			QuerySiteVersionInfoEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QuerySiteVersionInfoExResponse resp = new QuerySiteVersionInfoExResponse();
		resp.setResultCode(querySiteVersionInfoExResult);
		SiteDeviceVersionInfoEx info = new SiteDeviceVersionInfoEx();
		info.setModel("9039S");
		info.setLicense(" 2102310AAS6RAB000065");
		info.setSoftVersion(" VCT V100R011C02B014SP03 Release   2012.12.19");
		resp.setSiteDeviceVersionInfo(info);
		return resp;
	}

	@Override
	public IsConnectAuxSourceExResponse isConnectAuxSourceEx(
			IsConnectAuxSourceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		IsConnectAuxSourceExResponse resp = new IsConnectAuxSourceExResponse();
		resp.setResultCode(isConnectAuxSourceExResult);
		return resp;
	}

}
