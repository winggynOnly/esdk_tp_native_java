package com.huawei.esdk.demo.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor
{
    /** 
     * Serialization UID
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public String intercept(ActionInvocation inv)
        throws Exception
    {
        ActionContext ctx = inv.getInvocationContext();  
        Map<String, Object> session = ctx.getSession();
        String actionName = ctx.getName();
        
        if ("login".equals(actionName) || "logout".equals(actionName) || "changeLanguage".equals(actionName))
        {
            return inv.invoke();
        }
        //Boolean loginFlag = (Boolean)session.get("loginFlag");
        String flag = (String)session.get("loginUser");
        if (null == flag)
        {
            return "login";
        }
        else
        {
            return inv.invoke();
        }
        
    }
}
