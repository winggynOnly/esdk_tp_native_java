package com.huawei.esdk.platform.professional.local.impl.service;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.huawei.esdk.platform.professional.local.bean.SDKResponse;
import com.huawei.esdk.platform.professional.local.impl.autogen.PlatformKeyMgr;
import com.huawei.esdk.platform.professional.local.impl.utils.ClientProvider;
import com.huawei.esdk.platform.professional.local.impl.utils.RSA2048Utils;
import com.huawei.esdk.platform.professional.local.service.common.PlatformKeyServiceEx;
import com.huawei.esdk.tp.professional.local.impl.utils.ExceptionUtils;

public class PlatformKeyServiceExImpl implements PlatformKeyServiceEx
{
    private static final Logger LOGGER = Logger.getLogger(PlatformKeyServiceExImpl.class);
    
    private PlatformKeyMgr platformKeyMgr = (PlatformKeyMgr)ClientProvider.getClient(PlatformKeyMgr.class);
    
    private static PlatformKeyServiceExImpl instance = null;
    
    public static synchronized PlatformKeyServiceExImpl getInstance()
    {
        if (null == instance)
        {
            instance = new PlatformKeyServiceExImpl();
        }
        return instance;
    }
    
    @Override
    public SDKResponse<String> getPublicKey()
    {
        LOGGER.debug("begin to execute getPublicKey method");
        
        SDKResponse<String> result = new SDKResponse<String>();
        
        Holder<Integer> resultCode = new Holder<Integer>();
        Holder<String> publicKey = new Holder<String>();
        
        try
        {
            platformKeyMgr.getPublicKey(resultCode, publicKey);
        }
        catch (Exception e)
        {
            LOGGER.error("getPublicKey method exception happened", e);
            result.setResultCode(ExceptionUtils.processSoapException(e));
            return result;
        }
        
        result.setResultCode(resultCode.value);
        result.setResult(publicKey.value);
        
        LOGGER.debug("execute getPublicKey method completed");
        
        LOGGER.debug("begin to execute setPublicKey method");
        
        RSA2048Utils.setPublicKey(publicKey.value);
        
        LOGGER.debug("execute setPublicKey method completed");
        
        return result;
        
    }
}
