package com.huawei.esdk.demo.action;

import java.util.Locale;

import org.apache.struts2.ServletActionContext;

import com.huawei.esdk.demo.bean.UserInfo;
import com.huawei.esdk.demo.common.BaseAction;
import com.huawei.esdk.demo.service.AuthorizeService;
import com.huawei.esdk.demo.service.KeepAliveService;
import com.huawei.esdk.demo.utils.PropertiesUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

public class LoginAction extends BaseAction 
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 7768395611293823980L;

    private UserInfo loginParam;
    
    private Integer resultCode;
    
    static
    { 
        AuthorizeService authorizeService = AuthorizeService.getInstance();
       
        Integer res = authorizeService.login( PropertiesUtils.getValue("username"),  PropertiesUtils.getValue("password"));
        if (res == 0)
        {
            System.out.println("authorize success...");
            //启动保活线程
            KeepAliveService keepAliveService = new KeepAliveService();
            keepAliveService.startKeepAlive();
        }
        else 
        {
            System.out.println("authorize failed...");
        }
    }
    
    public String login() 
    {
        
        String username = loginParam.getUserName();
        //String password = loginParam.getPassword();
       
        System.out.println("login success...");
        getRequest().getSession().setAttribute("loginUser", username);
            
        return "success";
    }
    
    public String logout()
    {
        getRequest().getSession().removeAttribute("loginUser");
        getRequest().getSession().removeAttribute(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE);
        resultCode = 0;
        return "success";
    }
    
    public String changeLanguage()
    {
        String[] strings = getRequest().getParameter("language").split("_");
        Locale locale = new Locale(strings[0], strings[1]);
        ServletActionContext.getContext().setLocale(locale);
        //        getRequest().getSession().putValue(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
        getRequest().getSession().setAttribute(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
        ActionContext.getContext().getApplication().put("lang", getRequest().getParameter("language"));
        
        return "success";
    }
    
    public UserInfo getLoginParam()
    {
        return loginParam;
    }
    
    public void setLoginParam(UserInfo loginParam)
    {
        this.loginParam = loginParam;
    }
    
    public Integer getResultCode()
    {
        return resultCode;
    }
    
    public void setResultCode(Integer resultCode)
    {
        this.resultCode = resultCode;
    }
    
}
