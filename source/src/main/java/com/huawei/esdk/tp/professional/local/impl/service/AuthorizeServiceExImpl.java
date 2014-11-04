package com.huawei.esdk.tp.professional.local.impl.service;

import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.impl.autogen.Authenticate;
import com.huawei.esdk.tp.professional.local.impl.autogen.KeepAlive;
import com.huawei.esdk.tp.professional.local.impl.autogen.LoginRequest;
import com.huawei.esdk.tp.professional.local.impl.autogen.LoginRequestResponse;
import com.huawei.esdk.tp.professional.local.impl.autogen.Logout;
import com.huawei.esdk.tp.professional.local.impl.autogen.TPCommon;
import com.huawei.esdk.tp.professional.local.impl.utils.Base64Utils;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.tp.professional.local.impl.utils.Encrypt;
import com.huawei.esdk.tp.professional.local.impl.utils.ExceptionUtils;

public class AuthorizeServiceExImpl implements AuthorizeServiceEx {
	private TPCommon tPCommonClient = ((TPCommon) ClientProvider
			.getClient(TPCommon.class));
	
	private static AuthorizeServiceExImpl instance = null;

	public static synchronized AuthorizeServiceExImpl getInstance() {
		if (null == instance) {
			instance = new AuthorizeServiceExImpl();
		}
		return instance;
	}

	
	public Integer login(String userName, String password) {
	    
		LoginRequest loginReq = new LoginRequest();
		loginReq.setClientType("API");
		loginReq.setUserName(userName);
		loginReq.setVersion(2);
		try {
			LoginRequestResponse loginResp = tPCommonClient
					.loginRequest(loginReq);
			if (loginResp.getResultCode() == 0) {
				Authenticate authenticate = new Authenticate();
				String encodePwd = Base64Utils.encode(loginResp
						.getRandomSequence());
				String pwd = Encrypt.getEncryptPassword(null == encodePwd ? ""
						: encodePwd, password);
				byte[] base64Pwd = Base64Utils.getFromBASE64(null == pwd ? ""
						: pwd);
				authenticate.setEncryptPassword(null == base64Pwd ? new byte[0]
						: base64Pwd);
				return tPCommonClient.authenticate(authenticate)
						.getResultCode();
			}
			return loginResp.getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public Integer logout() {
		try {
			return tPCommonClient.logout(new Logout()).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

	
	public Integer keepAlive() {
		try {
			return tPCommonClient.keepAlive(new KeepAlive()).getResultCode();
		} catch (Exception e) {
			return ExceptionUtils.processSoapException(e);
		}
	}

}
