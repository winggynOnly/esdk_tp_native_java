package com.huawei.esdk.platform.professional.local;

import com.huawei.esdk.platform.professional.local.impl.service.PlatformKeyServiceExImpl;
import com.huawei.esdk.platform.professional.local.service.common.PlatformKeyServiceEx;

public class PlatformServiceFactoryEx
{
    static
    {
        System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<? extends T> interfaceClass)
    {
        if (interfaceClass.getName().equals(PlatformKeyServiceEx.class.getName()))
        {
            return (T)PlatformKeyServiceExImpl.getInstance();
        }
        else
        {
            return null;
        }
        
    }
    
}
