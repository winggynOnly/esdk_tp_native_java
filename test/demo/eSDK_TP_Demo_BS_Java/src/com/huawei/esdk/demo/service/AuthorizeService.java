package com.huawei.esdk.demo.service;

import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.demo.autogen.Authenticate;
import com.huawei.esdk.demo.autogen.KeepAlive;
import com.huawei.esdk.demo.autogen.LoginRequest;
import com.huawei.esdk.demo.autogen.LoginRequestResponse;
import com.huawei.esdk.demo.autogen.Logout;
import com.huawei.esdk.demo.autogen.TPCommon;
import com.huawei.esdk.demo.utils.Base64Utils;
import com.huawei.esdk.demo.utils.ClientProvider;
import com.huawei.esdk.demo.utils.Encrypt;
import com.huawei.esdk.demo.utils.ExceptionUtils;



public class AuthorizeService
{
    private TPCommon tPCommonClient = ((TPCommon)ClientProvider.getClient(TPCommon.class));
    
    private static AuthorizeService instance = null;
    
    public static synchronized AuthorizeService getInstance()
    {
        if (null == instance)
        {
            instance = new AuthorizeService();
        }
        return instance;
    }
    
    public Integer login(String userName, String password)
    {
        
        LoginRequest loginReq = new LoginRequest();
        loginReq.setClientType("API");
        loginReq.setUserName(userName);
        loginReq.setVersion(2);
        LoginRequestResponse loginResp = tPCommonClient.loginRequest(loginReq);
        if (loginResp.getResultCode() == 0)
        {
            Authenticate authenticate = new Authenticate();
            String encodePwd = Base64Utils.encode(loginResp.getRandomSequence());
            String pwd = Encrypt.getEncryptPassword(null == encodePwd ? "" : encodePwd, password);
            byte[] base64Pwd = Base64Utils.getFromBASE64(null == pwd ? "" : pwd);
            authenticate.setEncryptPassword(null == base64Pwd ? new byte[0] : base64Pwd);
            try
            {
                return tPCommonClient.authenticate(authenticate).getResultCode();
            }
            catch (SOAPFaultException e)
            {
                return ExceptionUtils.processSoapException(e);
            }
        }
        return loginResp.getResultCode();
    }
    
    public Integer logout()
    {
        try
        {
            return tPCommonClient.logout(new Logout()).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
    public Integer keepAlive()
    {
        try
        {
            return tPCommonClient.keepAlive(new KeepAlive()).getResultCode();
        }
        catch (SOAPFaultException e)
        {
            return ExceptionUtils.processSoapException(e);
        }
    }
    
}
