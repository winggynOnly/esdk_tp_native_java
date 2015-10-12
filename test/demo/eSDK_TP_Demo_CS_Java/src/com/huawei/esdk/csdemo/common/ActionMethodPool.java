package com.huawei.esdk.csdemo.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.huawei.esdk.csdemo.action.ConfControlAction;
import com.huawei.esdk.csdemo.action.ConfManagerAction;
import com.huawei.esdk.csdemo.action.EditConfAction;
import com.huawei.esdk.csdemo.action.InitialDefaultDataAction;
import com.huawei.esdk.csdemo.action.LoginAction;
import com.huawei.esdk.csdemo.action.ScheduleConfAction;
import com.huawei.esdk.csdemo.action.SiteControlAction;

public class ActionMethodPool
{
    private Map<String,Method> methodMap = new HashMap<String,Method>();
    private static ActionMethodPool instance;
    private ActionMethodPool(){
        Method[] confControlmethods =  ConfControlAction.class.getDeclaredMethods();
        for(Method item : confControlmethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] confManagermethods =  ConfManagerAction.class.getDeclaredMethods();
        for(Method item : confManagermethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] editConfmethods =  EditConfAction.class.getDeclaredMethods();
        for(Method item : editConfmethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] initialDefaultDatamethods =  InitialDefaultDataAction.class.getDeclaredMethods();
        for(Method item : initialDefaultDatamethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] loginmethods =  LoginAction.class.getDeclaredMethods();
        for(Method item : loginmethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] scheduleConfmethods =  ScheduleConfAction.class.getDeclaredMethods();
        for(Method item : scheduleConfmethods)
        {
            methodMap.put(item.getName(), item);
        }
        
        Method[] siteControlmethods =  SiteControlAction.class.getDeclaredMethods();
        for(Method item : siteControlmethods)
        {
            methodMap.put(item.getName(), item);
        }
    }
    
    public static ActionMethodPool getInstance()
    {
        if(null == instance)
        {
            instance = new ActionMethodPool();
        }
        return instance;
    }
    
    public void runMethod(Object action, String methodName,Object... param) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {

        Method method =  methodMap.get(methodName);
        
        if(null == method)
        {
            return;
        }


        method.invoke(action, param);
    }

}

