package com.huawei.esdk.demo.service;

import com.huawei.esdk.demo.utils.KeepAlive;

public class KeepAliveService 
{
    public KeepAlive startKeepAlive()
    {
        KeepAlive keepAlive = new KeepAlive();
        Thread t1 = new Thread(keepAlive);
        keepAlive.keepAliveFlag = true;
        t1.start();
        System.out.println(t1.getId()+"====");
        return keepAlive;
    }
}
