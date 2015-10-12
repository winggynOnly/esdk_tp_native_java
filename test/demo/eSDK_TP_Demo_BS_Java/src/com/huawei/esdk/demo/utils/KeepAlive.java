package com.huawei.esdk.demo.utils;

import com.huawei.esdk.demo.service.AuthorizeService;

public class KeepAlive implements Runnable
{
    public  boolean keepAliveFlag= false;
    
    private AuthorizeService authorizeService = AuthorizeService.getInstance();
    @Override
    public void run()
    {
        int timeFlag = 0;
        while (keepAliveFlag)
        {
            if(timeFlag >30000)
            {
                System.out.println("send keepAlive message..." +  "--------------" + this.toString() );
                authorizeService.keepAlive();
                timeFlag  = 0;
            }
            try
            {
                Thread.sleep(50);
                timeFlag += 50; 
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
    }
    
}
