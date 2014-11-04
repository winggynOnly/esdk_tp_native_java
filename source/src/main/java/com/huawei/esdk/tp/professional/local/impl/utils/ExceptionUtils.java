package com.huawei.esdk.tp.professional.local.impl.utils;

import javax.net.ssl.SSLHandshakeException;
import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.constant.NativeConstant;

public abstract class ExceptionUtils {

	public static void processSoapException(
			TPSDKResponseEx<? extends Object> resp, Exception e)
	{
		if (e instanceof SOAPFaultException) 
		{
			String faultCodeString = ((SOAPFaultException)e).getFault().getFaultCode();
			String faultString = ((SOAPFaultException)e).getFault().getFaultString();
			if (faultCodeString.contains(":"))
			{
				String[] faultCodeStringArr = faultCodeString.split(":");
				if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SESSION_NOT_CORRECT))) 
				{
					resp.setResultCode(NativeConstant.SESSION_NOT_CORRECT);
				}
				else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.AUTHORIZE_ERRORCODE)))
				{
					resp.setResultCode(NativeConstant.AUTHORIZE_ERRORCODE);
				}
				else if (faultCodeStringArr[1].equals(String
						.valueOf(NativeConstant.ACCOUNT_LOCKED)))
				{
					resp.setResultCode(NativeConstant.ACCOUNT_LOCKED);
				}
				else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SYSTEM_ERRORCODE)))
				{
					resp.setResultCode(NativeConstant.SYSTEM_ERRORCODE);
				}
				else if(faultCodeString.equals("soap:Client") && faultString.contains("Unmarshalling Error"))
				{
//					if (faultString.contains("is expected")) 
//					{
//						
//						resp.setResultCode(NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE);
//					}
//					else 
//					{
						resp.setResultCode(NativeConstant.SDK_DATA_INCORRECT_ERRORCODE);
//					}
				}
				else if(faultString.equals("Connection refused: connect")||faultString.contains("Connection reset"))
				{
					resp.setResultCode(NativeConstant.ERROR_CODE_NETWORK_ERROR);
				}
				else if (faultString.contains("handshake_failure") || faultString.contains("trustAnchors parameter must be non-empty")) 
				{
					resp.setResultCode(NativeConstant.SSL_HANDSHAKE_FAILURE);
				} 
				else 
				{
					resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
				}
			}
			else
			{
				resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
			}
		}
		else
		{
			if (e.getCause() instanceof SSLHandshakeException) 
			{

				resp.setResultCode(NativeConstant.SSL_HANDSHAKE_FAILURE);
			}
			else if (e.getCause().getMessage().contains("no protocol")) 
			{
				resp.setResultCode(NativeConstant.NATIVE_URL_FORMAT_ERRORCODE);
			}
			else if (e.getMessage().contains("Could not send Message")) 
			{
				resp.setResultCode(NativeConstant.ERROR_CODE_NETWORK_ERROR);
			}
			else 
			{
				resp.setResultCode(NativeConstant.NATIVE_EXCEPTION);
			}
		}
		
	}
    
    public static Integer processSoapException(Exception e)
    {
        try
        {
            if (e instanceof SOAPFaultException)
            {
                String faultCodeString = ((SOAPFaultException)e).getFault().getFaultCode();
                String faultString = ((SOAPFaultException)e).getFault().getFaultString();
                if (faultCodeString.contains(":"))
                {
                    String[] faultCodeStringArr = faultCodeString.split(":");
                    if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SESSION_NOT_CORRECT)))
                    {
                        return NativeConstant.SESSION_NOT_CORRECT;
                    }
                    else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.AUTHORIZE_ERRORCODE)))
                    {
                        return NativeConstant.AUTHORIZE_ERRORCODE;
                    }
                    else if (faultCodeStringArr[1].equals(String.valueOf(NativeConstant.SYSTEM_ERRORCODE)))
                    {
                        return NativeConstant.SYSTEM_ERRORCODE;
                    }
                    else if (faultCodeString.equals("soap:Client") && faultString.contains("Unmarshalling Error"))
                    {
                        //					if (faultString.contains("is expected"))
                        //					{
                        //						return NativeConstant.SDK_PARAM_NOT_COMPLETE_ERRORCODE;
                        //					}
                        //					else 
                        //					{
                        return NativeConstant.SDK_DATA_INCORRECT_ERRORCODE;
                        //					}
                    }
                    else if (faultString.equals("Connection refused: connect"))
                    {
                        return NativeConstant.ERROR_CODE_NETWORK_ERROR;
                    }
                    else if (faultString.contains("handshake_failure")
                        || faultString.contains("trustAnchors parameter must be non-empty"))
                    {
                        return NativeConstant.SSL_HANDSHAKE_FAILURE;
                    }
                    else
                    {
                        return NativeConstant.NATIVE_EXCEPTION;
                    }
                }
                else
                {
                    return NativeConstant.NATIVE_EXCEPTION;
                }
            }
            else
            {
                if (e.getCause() instanceof SSLHandshakeException)
                {
                    
                    return NativeConstant.SSL_HANDSHAKE_FAILURE;
                }
                else if (e.getCause().getMessage().contains("no protocol"))
                {
                    return NativeConstant.NATIVE_URL_FORMAT_ERRORCODE;
                }
                else if (e.getMessage().contains("Could not send Message"))
                {
                    return NativeConstant.ERROR_CODE_NETWORK_ERROR;
                }
                else
                {
                    return NativeConstant.NATIVE_EXCEPTION;
                }
            }
        }
        catch (Exception ex)
        {
            return NativeConstant.NATIVE_EXCEPTION;
        }
    }
}
