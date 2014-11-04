package com.huawei.esdk.tp.professional.local.authentication;


import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.tp.professional.local.MyFaultException;
import com.huawei.esdk.tp.professional.local.impl.autogen.Authenticate;
import com.huawei.esdk.tp.professional.local.impl.autogen.AuthenticateResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.KeepAlive;
import com.huawei.esdk.tp.professional.local.impl.autogen.KeepAliveResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.LoginRequest;
import com.huawei.esdk.tp.professional.local.impl.autogen.LoginRequestResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.Logout;
import com.huawei.esdk.tp.professional.local.impl.autogen.LogoutResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPCommon;

public class TPCommonImpl implements TPCommon {
	public static boolean throwException = false;
	public static int loginResult = 0;
	public static int authenticateResult = 0;
	public static int logoutResult = 0;
	public static int keepAliveResult = 0;
	
	public static int exceptionCode = 0; 
	private SOAPFaultException getSOAPFaultException(){
		SOAPFaultException se = null;
		try {
			//SOAPFault fault = SOAPFactory.newInstance().createFault();
			SOAPFault fault = new MyFaultException();
			fault.setFaultCode(String.valueOf(exceptionCode));
			se = new SOAPFaultException(fault);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		return se;
	}
	
	public LoginRequestResponse loginRequest(LoginRequest parameters) {
		LoginRequestResponse rsp = new LoginRequestResponse();
		rsp.setResultCode(loginResult);
		return rsp;
	}
	public AuthenticateResponse authenticate(Authenticate parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		AuthenticateResponse rsp = new AuthenticateResponse();
		rsp.setResultCode(authenticateResult);
		return rsp;
	}
	public KeepAliveResponse keepAlive(KeepAlive parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		KeepAliveResponse r = new KeepAliveResponse();
		r.setResultCode(keepAliveResult);
		return r;
	}
	public LogoutResponse logout(Logout parameters) {
		if (throwException) {
			throw getSOAPFaultException();
		}
		LogoutResponse r = new LogoutResponse();
		r.setResultCode(logoutResult);
		return r;
	}

}
