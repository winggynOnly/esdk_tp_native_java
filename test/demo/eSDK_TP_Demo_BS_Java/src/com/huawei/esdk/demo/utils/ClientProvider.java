package com.huawei.esdk.demo.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.huawei.esdk.demo.autogen.TPCommon;
import com.huawei.esdk.demo.autogen.TPProfessionalConfCtr;
import com.huawei.esdk.demo.autogen.TPProfessionalConfMgr;
import com.huawei.esdk.demo.autogen.TPProfessionalSiteMgr;
import com.huawei.esdk.demo.interceptor.MsgInInterceptor;
import com.huawei.esdk.demo.interceptor.MsgOutInterceptor;


public abstract class ClientProvider
{
    private static Map<String,Object> clientMap = new HashMap<String,Object>();
    @SuppressWarnings(
    { "rawtypes", "unchecked" })
    public static synchronized Object getClient(Class clz)
    {
        Object clientObj = clientMap.get(clz.getName());
        if (null != clientObj)
        {
            return clientObj;
        }
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        String url = PropertiesUtils.getValue("sdkserver.url");
        String serviceUrl = "";
        if (clz.getName().equals(TPCommon.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.common.service.url");
        }
        else if (clz.getName().equals(TPProfessionalConfMgr.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.confMgr.service.url");
        }
        else if (clz.getName().equals(TPProfessionalConfCtr.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.confCtr.service.url");
        }
        else if (clz.getName().equals(TPProfessionalSiteMgr.class.getName()))
        {
            serviceUrl = PropertiesUtils.getValue("professional.siteMgr.service.url");
        }

        factory.setAddress(url + "/" + serviceUrl);

        Object service = null;
        service = factory.create(clz);
        Client client = ClientProxy.getClient(service);

        // Add the header info
        // client.getRequestContext().put(Header.HEADER_LIST, prepareHeaders());
        if(Boolean.valueOf(PropertiesUtils.getValue("logging")))
        {
	        client.getOutInterceptors().add(new LoggingOutInterceptor());
	        client.getInInterceptors().add(new LoggingInInterceptor());
        }

        // 做拦截器，对发送出去的消息添加sessionID，对收到的消息截取sessionID
        client.getOutInterceptors().add(new MsgOutInterceptor());
        client.getInInterceptors().add(new MsgInInterceptor());

        // Setting HTTP Related information
        HTTPConduit http = (HTTPConduit) client.getConduit();
        if (null == http) {
			return null;
		}
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(35000);
        httpClientPolicy.setAllowChunking(false);
        httpClientPolicy.setReceiveTimeout(30000);
        http.setClient(httpClientPolicy);

        clientMap.put(clz.getName(), service);
        return service;
    }

}