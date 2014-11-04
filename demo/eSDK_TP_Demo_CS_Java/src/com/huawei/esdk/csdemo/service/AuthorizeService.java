package com.huawei.esdk.csdemo.service;

import java.io.Serializable;
import com.huawei.esdk.csdemo.common.ServiceFactory;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;


public class AuthorizeService implements Serializable
{
    /** * */
    private static final long serialVersionUID = 5408565124599380127L;
    
    private AuthorizeServiceEx service = null;

    public AuthorizeService()
    {
        service = ServiceFactory.getInstance().getAuthorizeServiceEx();
    }

    public Integer login(String userName, String password)
    {
        Integer result = service.login(userName, password);
        return result;
    }

    public void keepAlive(int rate)
    {
        KeepAliveThread aliveThread = KeepAliveThread
                .getInstance(service, rate);
        
        Thread thread = new Thread(aliveThread);  
        thread.start();
    }

    public void stopKeepAlive()
    {
        
    }
    
    public void logout()
    {
        KeepAliveThread.setFlag(1);
        service.logout();
    }

}
