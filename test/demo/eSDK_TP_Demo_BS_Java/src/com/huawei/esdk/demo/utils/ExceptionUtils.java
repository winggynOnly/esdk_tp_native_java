package com.huawei.esdk.demo.utils;

import javax.xml.ws.soap.SOAPFaultException;

import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.common.Constant;


public abstract class ExceptionUtils
{
    
    public static void processSoapException(TPSDKResponseEx<? extends Object> resp, SOAPFaultException e)
    {
        if (e.getFault().getFaultCode().contains(String.valueOf(Constant.SESSION_NOT_CORRECT)))
        {
            resp.setResultCode(Constant.SESSION_NOT_CORRECT);
        }
        else
        {
            throw e;
        }
    }
    
    public static Integer processSoapException(SOAPFaultException e)
    {
        if (e.getFault().getFaultCode().contains(String.valueOf(Constant.SESSION_NOT_CORRECT)))
        {
            return Constant.SESSION_NOT_CORRECT;
        }
        else
        {
            throw e;
        }
    }
}
