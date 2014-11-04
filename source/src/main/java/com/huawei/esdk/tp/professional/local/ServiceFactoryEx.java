package com.huawei.esdk.tp.professional.local;

import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.conference.ConferenceServiceEx;
import com.huawei.esdk.tp.professional.local.impl.service.AuthorizeServiceExImpl;
import com.huawei.esdk.tp.professional.local.impl.service.ConferenceServiceExImpl;
import com.huawei.esdk.tp.professional.local.impl.service.SiteServiceExImpl;
import com.huawei.esdk.tp.professional.local.site.SiteServiceEx;

public class ServiceFactoryEx
{
	static
	{
		System.setProperty("org.apache.cxf.JDKBugHacks.defaultUsesCaches", "true");
	}
	
    @SuppressWarnings("unchecked")
    public static <T> T getService(Class<? extends T> interfaceClass)
    {
        if (interfaceClass.getName().equals(ConferenceServiceEx.class.getName()))
        {
            return (T) ConferenceServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(SiteServiceEx.class.getName()))
        {
            return (T) SiteServiceExImpl.getInstance();
        }
        else if (interfaceClass.getName().equals(AuthorizeServiceEx.class.getName()))
        {
            return (T) AuthorizeServiceExImpl.getInstance();
        }
   
        return null;
    }

}
