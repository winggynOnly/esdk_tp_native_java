package com.huawei.esdk.tp.professional.local.conference;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.tp.professional.local.MyFaultException;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.QuerySitesByConditionExResponse;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.AddSiteToConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.AddSiteToConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ConnectSitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ConnectSitesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelScheduledConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelSiteFromConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DelSiteFromConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisconnectSitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisconnectSitesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisplayConfSiteLocalVideoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.DisplayConfSiteLocalVideoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditRecurrenceConferenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditRecurrenceConferenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.EditScheduledConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.HideConfSiteLocalVideoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.HideConfSiteLocalVideoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ProlongScheduledConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ProlongScheduledConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryBroadInfoEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryBroadInfoExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfCtrlPwdEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfCtrlPwdExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfSitesStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConfSitesStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConferencesStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryConferencesStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryHistoryRecordAddrEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QueryHistoryRecordAddrExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySiteStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesByConditionEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.QuerySitesExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ReleaseChairEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ReleaseChairExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.RequestChairEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.RequestChairExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleConfEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleConfExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleRecurrenceConferenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.ScheduleRecurrenceConferenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetAudioSwitchEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetAudioSwitchExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastContinuousPresenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastContinuousPresenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastSiteEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetBroadcastSiteExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetConfSiteVolumeEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetConfSiteVolumeExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetContinuousPresenceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetContinuousPresenceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetDirectBroadEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetDirectBroadExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetFloorEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetFloorExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetRecordBroadEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetRecordBroadExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetRecordingVideoSourceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetRecordingVideoSourceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesMuteEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesMuteExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesQuietEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetSitesQuietExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoSourceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SetVideoSourceExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.StartLiveBroadcastEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.StartLiveBroadcastExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.StartRecordingEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.StartRecordingExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.StopLiveBroadcastEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.StopLiveBroadcastExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.StopRecordingEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.StopRecordingExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.SynchSiteStatusEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.SynchSiteStatusExResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalConfCtr;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPProfessionalConfMgr;

public class ConferenceImpl implements TPProfessionalConfCtr,
		TPProfessionalConfMgr {

	public static int setDirectBroadExResult = 0;
	public static int setVideoSourceExResult = 0;
	public static int setSitesMuteExResult = 0;
	public static int queryConfCtrlPwdExResult = 0;
	public static int setContinuousPresenceExResult = 0;
	public static int setBroadcastSiteExResult = 0;
	public static int queryBroadInfoExResult = 0;
	public static int setRecordBroadExResult = 0;
	public static int setAudioSwitchExResult = 0;
	public static int releaseChairExResult = 0;
	public static int setSitesQuietExResult = 0;
	public static int setBroadcastContinuousPresenceExResult = 0;
	public static int requestChairExResult = 0;
	public static int scheduleRecurrenceConferenceExResult = 0;
	public static int delSiteFromConfExResult = 0;
	public static int connectSitesExResult = 0;
	public static int disconnectSitesExResult = 0;
	public static int scheduleConfExResult = 0;
	public static int prolongScheduledConfExResult = 0;
	public static int queryConfSitesStatusExResult = 0;
	public static int delScheduledConfExResult = 0;
	public static int editScheduledConfExResult = 0;
	public static int addSiteToConfExResult = 0;
	public static int querySiteStatusExResult = 0;
	public static int queryConferencesStatusExResult = 0;
	public static int synchSiteStatusExResult = 0;
	public static int editRecurrenceConferenceExResult = 0;
	public static int querySitesExResult = 0;
	
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
	public QuerySitesExResponse querySitesEx(QuerySitesEx parameters) {
		QuerySitesExResponse resp = new QuerySitesExResponse();
		if (throwException) {
			throw getSOAPFaultException();
		}
		resp.setResultCode(querySitesExResult);
		SiteInfoEx site = new SiteInfoEx();
		site.setUri("01010010");
		site.setName("东方不败");
		resp.getSiteInfos().add(site);
		return resp;
	}

	@Override
	public EditRecurrenceConferenceExResponse editRecurrenceConferenceEx(
			EditRecurrenceConferenceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		EditRecurrenceConferenceExResponse resp = new EditRecurrenceConferenceExResponse();
		resp.setResultCode(editRecurrenceConferenceExResult);
		return resp;
	}

	@Override
	public SynchSiteStatusExResponse synchSiteStatusEx(
			SynchSiteStatusEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SynchSiteStatusExResponse resp = new SynchSiteStatusExResponse();
		resp.setResultCode(synchSiteStatusExResult);
		return resp;
	}

	@Override
	public QueryConferencesStatusExResponse queryConferencesStatusEx(
			QueryConferencesStatusEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryConferencesStatusExResponse resp = new QueryConferencesStatusExResponse();
		resp.setResultCode(queryConferencesStatusExResult);
		return resp;
	}

	@Override
	public QuerySiteStatusExResponse querySiteStatusEx(
			QuerySiteStatusEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QuerySiteStatusExResponse resp = new QuerySiteStatusExResponse();
		resp.setResultCode(querySiteStatusExResult);
		return resp;
	}

	@Override
	public AddSiteToConfExResponse addSiteToConfEx(AddSiteToConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		AddSiteToConfExResponse resp = new AddSiteToConfExResponse();
		resp.setResultCode(addSiteToConfExResult);
		return resp;
	}

	@Override
	public EditScheduledConfExResponse editScheduledConfEx(
			EditScheduledConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		EditScheduledConfExResponse resp = new EditScheduledConfExResponse();
		resp.setResultCode(editScheduledConfExResult);
		return resp;
	}

	@Override
	public DelScheduledConfExResponse delScheduledConfEx(
			DelScheduledConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		DelScheduledConfExResponse resp = new DelScheduledConfExResponse();
		resp.setResultCode(delScheduledConfExResult);
		return resp;
	}

	@Override
	public QueryConfSitesStatusExResponse queryConfSitesStatusEx(
			QueryConfSitesStatusEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryConfSitesStatusExResponse resp = new QueryConfSitesStatusExResponse();
		resp.setResultCode(queryConfSitesStatusExResult);
		return resp;
	}

	@Override
	public ProlongScheduledConfExResponse prolongScheduledConfEx(
			ProlongScheduledConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		ProlongScheduledConfExResponse resp = new ProlongScheduledConfExResponse();
		resp.setResultCode(prolongScheduledConfExResult);
		return resp;
	}

	@Override
	public ScheduleConfExResponse scheduleConfEx(ScheduleConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		ScheduleConfExResponse resp = new ScheduleConfExResponse();
		ConferenceInfoEx info = new ConferenceInfoEx();
		info.setConfId("1477");
		resp.setConferenceInfo(info);
		resp.setResultCode(scheduleConfExResult);
		return resp;
	}

	@Override
	public DisconnectSitesExResponse disconnectSitesEx(
			DisconnectSitesEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		DisconnectSitesExResponse resp = new DisconnectSitesExResponse();
		resp.setResultCode(disconnectSitesExResult);
		return resp;
	}

	@Override
	public ConnectSitesExResponse connectSitesEx(ConnectSitesEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		ConnectSitesExResponse resp = new ConnectSitesExResponse();
		resp.setResultCode(connectSitesExResult);
		return resp;
	}

	@Override
	public DelSiteFromConfExResponse delSiteFromConfEx(
			DelSiteFromConfEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		DelSiteFromConfExResponse resp = new DelSiteFromConfExResponse();
		resp.setResultCode(delSiteFromConfExResult);
		return resp;
	}

	@Override
	public ScheduleRecurrenceConferenceExResponse scheduleRecurrenceConferenceEx(
			ScheduleRecurrenceConferenceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		ScheduleRecurrenceConferenceExResponse resp = new ScheduleRecurrenceConferenceExResponse();
		resp.setResultCode(scheduleRecurrenceConferenceExResult);
		resp.setRecurrenceConfInfo(new RecurrenceConfInfoEx());
		return resp;
	}

	@Override
	public RequestChairExResponse requestChairEx(RequestChairEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		RequestChairExResponse resp = new RequestChairExResponse();
		resp.setResultCode(requestChairExResult);
		return resp;
	}

	@Override
	public SetBroadcastContinuousPresenceExResponse setBroadcastContinuousPresenceEx(
			SetBroadcastContinuousPresenceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetBroadcastContinuousPresenceExResponse resp = new SetBroadcastContinuousPresenceExResponse();
		resp.setResultCode(setBroadcastContinuousPresenceExResult);
		return resp;
	}

	@Override
	public SetSitesQuietExResponse setSitesQuietEx(SetSitesQuietEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetSitesQuietExResponse resp = new SetSitesQuietExResponse();
		resp.setResultCode(setSitesQuietExResult);
		return resp;
	}

	@Override
	public ReleaseChairExResponse releaseChairEx(ReleaseChairEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		ReleaseChairExResponse resp = new ReleaseChairExResponse();
		resp.setResultCode(releaseChairExResult);
		return resp;
	}

	@Override
	public SetAudioSwitchExResponse setAudioSwitchEx(SetAudioSwitchEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetAudioSwitchExResponse resp = new SetAudioSwitchExResponse();
		resp.setResultCode(setAudioSwitchExResult);
		return resp;
	}

	@Override
	public SetRecordBroadExResponse setRecordBroadEx(SetRecordBroadEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetRecordBroadExResponse resp = new SetRecordBroadExResponse();
		resp.setResultCode(setRecordBroadExResult);
		return resp;
	}

	@Override
	public QueryBroadInfoExResponse queryBroadInfoEx(QueryBroadInfoEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryBroadInfoExResponse resp = new QueryBroadInfoExResponse();
		resp.setResultCode(queryBroadInfoExResult);
		return resp;
	}

	@Override
	public SetBroadcastSiteExResponse setBroadcastSiteEx(
			SetBroadcastSiteEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetBroadcastSiteExResponse resp = new SetBroadcastSiteExResponse();
		resp.setResultCode(setBroadcastSiteExResult);
		return resp;
	}

	@Override
	public SetContinuousPresenceExResponse setContinuousPresenceEx(
			SetContinuousPresenceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetContinuousPresenceExResponse resp = new SetContinuousPresenceExResponse();
		resp.setResultCode(setContinuousPresenceExResult);
		return resp;
	}

	@Override
	public QueryConfCtrlPwdExResponse queryConfCtrlPwdEx(
			QueryConfCtrlPwdEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		QueryConfCtrlPwdExResponse resp = new QueryConfCtrlPwdExResponse();
		resp.setResultCode(queryConfCtrlPwdExResult);
		resp.setResult("1");
		return resp;
	}

	@Override
	public SetSitesMuteExResponse setSitesMuteEx(SetSitesMuteEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetSitesMuteExResponse resp = new SetSitesMuteExResponse();
		resp.setResultCode(setSitesMuteExResult);
		return resp;
	}

	@Override
	public SetVideoSourceExResponse setVideoSourceEx(SetVideoSourceEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetVideoSourceExResponse resp = new SetVideoSourceExResponse();
		resp.setResultCode(setVideoSourceExResult);
		return resp;
	}

	@Override
	public SetDirectBroadExResponse setDirectBroadEx(SetDirectBroadEx parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		SetDirectBroadExResponse resp = new SetDirectBroadExResponse();
		resp.setResultCode(setDirectBroadExResult);
		return resp;
	}

    @Override
    @WebResult(name = "hideConfSiteLocalVideoExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/hideConfSiteLocalVideoEx")
    public HideConfSiteLocalVideoExResponse hideConfSiteLocalVideoEx(
        @WebParam(partName = "parameters", name = "hideConfSiteLocalVideoEx", targetNamespace = "http://smc.huawei.com/")
        HideConfSiteLocalVideoEx parameters)
    {
        return new HideConfSiteLocalVideoExResponse();
    }

    @Override
    @WebResult(name = "setConfSiteVolumeExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setConfSiteVolumeEx")
    public SetConfSiteVolumeExResponse setConfSiteVolumeEx(
        @WebParam(partName = "parameters", name = "setConfSiteVolumeEx", targetNamespace = "http://smc.huawei.com/")
        SetConfSiteVolumeEx parameters)
    {
        return new SetConfSiteVolumeExResponse();
    }

    @Override
    @WebResult(name = "setFloorExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setFloorEx")
    public SetFloorExResponse setFloorEx(
        @WebParam(partName = "parameters", name = "setFloorEx", targetNamespace = "http://smc.huawei.com/")
        SetFloorEx parameters)
    {
        return new SetFloorExResponse();
    }

    @Override
    @WebResult(name = "displayConfSiteLocalVideoExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/displayConfSiteLocalVideoEx")
    public DisplayConfSiteLocalVideoExResponse displayConfSiteLocalVideoEx(
        @WebParam(partName = "parameters", name = "displayConfSiteLocalVideoEx", targetNamespace = "http://smc.huawei.com/")
        DisplayConfSiteLocalVideoEx parameters)
    {
        return new DisplayConfSiteLocalVideoExResponse();
    }

    @Override
    @WebResult(name = "querySitesByConditionExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/querySitesByConditionEx")
    public QuerySitesByConditionExResponse querySitesByConditionEx(
        @WebParam(partName = "parameters", name = "querySitesByConditionEx", targetNamespace = "http://smc.huawei.com/")
        QuerySitesByConditionEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "queryHistoryRecordAddrExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/queryHistoryRecordAddrEx")
    public QueryHistoryRecordAddrExResponse queryHistoryRecordAddrEx(
        @WebParam(partName = "parameters", name = "queryHistoryRecordAddrEx", targetNamespace = "http://smc.huawei.com/")
        QueryHistoryRecordAddrEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "stopRecordingExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/stopRecordingEx")
    public StopRecordingExResponse stopRecordingEx(
        @WebParam(partName = "parameters", name = "stopRecordingEx", targetNamespace = "http://smc.huawei.com/")
        StopRecordingEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "startRecordingExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/startRecordingEx")
    public StartRecordingExResponse startRecordingEx(
        @WebParam(partName = "parameters", name = "startRecordingEx", targetNamespace = "http://smc.huawei.com/")
        StartRecordingEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "startLiveBroadcastExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/startLiveBroadcastEx")
    public StartLiveBroadcastExResponse startLiveBroadcastEx(
        @WebParam(partName = "parameters", name = "startLiveBroadcastEx", targetNamespace = "http://smc.huawei.com/")
        StartLiveBroadcastEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "setRecordingVideoSourceExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/setRecordingVideoSourceEx")
    public SetRecordingVideoSourceExResponse setRecordingVideoSourceEx(
        @WebParam(partName = "parameters", name = "setRecordingVideoSourceEx", targetNamespace = "http://smc.huawei.com/")
        SetRecordingVideoSourceEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @WebResult(name = "stopLiveBroadcastExResponse", targetNamespace = "http://smc.huawei.com/", partName = "parameters")
    @WebMethod(action = "http://smc.huawei.com/stopLiveBroadcastEx")
    public StopLiveBroadcastExResponse stopLiveBroadcastEx(
        @WebParam(partName = "parameters", name = "stopLiveBroadcastEx", targetNamespace = "http://smc.huawei.com/")
        StopLiveBroadcastEx parameters)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
