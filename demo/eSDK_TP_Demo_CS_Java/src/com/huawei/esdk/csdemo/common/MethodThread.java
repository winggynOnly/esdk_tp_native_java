package com.huawei.esdk.csdemo.common;

import java.lang.reflect.InvocationTargetException;

public class MethodThread extends Thread
{

    private Object action;
    private String methodName;
    private Object[] params;

    public MethodThread(Object action, String methodName,Object... params)
    {
        this.action = action;
        this.methodName = methodName;
        this.params = params.clone();
    }
    @Override
    public void run()
    {
        try
        {
            if(0 == params.length){   
                ActionMethodPool.getInstance().runMethod(action, methodName);
            }
            else if(1 == params.length){ 
                ActionMethodPool.getInstance().runMethod(action, methodName,params[0]);
            }
            else if(2 == params.length){ 
                ActionMethodPool.getInstance().runMethod(action, methodName,params[0],params[1]);
            }
            else if(3 == params.length){ 
                ActionMethodPool.getInstance().runMethod(action, methodName,params[0],params[1],params[2]);
            }
            else if(4 == params.length){ 
                ActionMethodPool.getInstance().runMethod(action, methodName,params[0],params[1],params[2],params[3]);
            }
            else if(5 == params.length){ 
                ActionMethodPool.getInstance().runMethod(action, methodName,params[0],params[1],params[2],params[3],params[4]);
            }
        }
        catch (SecurityException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
