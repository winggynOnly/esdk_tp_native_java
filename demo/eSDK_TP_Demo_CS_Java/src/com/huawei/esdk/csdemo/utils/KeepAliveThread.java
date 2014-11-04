package com.huawei.esdk.csdemo.utils;


import java.util.Date;

import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;

public class KeepAliveThread implements Runnable
{
    private static KeepAliveThread instance;

    private static AuthorizeServiceEx authorizeService;

    private static int rate;

    private static int flag;

    public static KeepAliveThread getInstance(AuthorizeServiceEx service,
            int rate)
    {
        KeepAliveThread.rate = rate;

        if (null == instance)
        {
            KeepAliveThread.authorizeService = service;
            KeepAliveThread.instance = new KeepAliveThread();
        }
        return instance;
    }

    private KeepAliveThread()
    {

    }

    @Override
    public void run()
    {
        flag = 0;
        Long lastKeepLiveTime = 0L;
        Long nowTime = 0L;
        while (0 == flag)
        {
            nowTime = new Date().getTime();
            if (nowTime - lastKeepLiveTime > KeepAliveThread.rate * 1000)
            {
                flag = KeepAliveThread.authorizeService.keepAlive();
                lastKeepLiveTime = nowTime;
            }
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static int getRate()
    {
        return rate;
    }

    public static void setRate(int rate)
    {
        KeepAliveThread.rate = rate;
    }

    public static int getFlag()
    {
        return flag;
    }

    public static void setFlag(int flag)
    {
        KeepAliveThread.flag = flag;
    }

}
