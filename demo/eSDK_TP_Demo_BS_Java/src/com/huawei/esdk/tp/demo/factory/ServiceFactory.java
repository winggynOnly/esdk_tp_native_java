package com.huawei.esdk.tp.demo.factory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.huawei.esdk.tp.professional.local.ServiceFactoryEx;
import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.conference.ConferenceServiceEx;
import com.huawei.esdk.tp.professional.local.site.SiteServiceEx;


/**
 * 业务工厂管理类
 * 
 * @author  cWX191990
 * @see  [无]
 * @since  [eSDK IVS V100R003C00]
 */
public class ServiceFactory extends HttpServlet
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 4659959607228940247L;
    
    /**
     * 鉴权服务接口
     */
    private static AuthorizeServiceEx authorizeServiceEx;
    
    /**
     * 会场模块服务接口
     */
    private static SiteServiceEx siteServiceEx;
    
    /**
     * 会议模块服务接口
     */
    private static ConferenceServiceEx conferenceServiceEx;
    
    /** 
     * 重写init方法 
     */
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);
        
        // 从native包中ServiceFactoryEx类中获取相应的服务
        conferenceServiceEx = ServiceFactoryEx.getService(ConferenceServiceEx.class);
       
        siteServiceEx = ServiceFactoryEx.getService(SiteServiceEx.class);
        
        authorizeServiceEx = ServiceFactoryEx.getService(AuthorizeServiceEx.class);
    }
    
    public static SiteServiceEx getSiteServiceEx()
    {
        return siteServiceEx;
    }
    
    public static ConferenceServiceEx getConferenceServiceEx()
    {
        return conferenceServiceEx;
    }

    public static AuthorizeServiceEx getAuthorizeServiceEx()
    {
        return authorizeServiceEx;
    }
    
}
