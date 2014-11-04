package com.huawei.esdk.tp.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.internal.StringMap;
import com.huawei.esdk.tp.demo.factory.ServiceFactory;
import com.huawei.esdk.tp.demo.utils.DateUtils;
import com.huawei.esdk.tp.demo.utils.DurationUtils;
import com.huawei.esdk.tp.demo.utils.PropertiesUtils;
import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

/**
 * 通讯录处理类
 * 用于添加账号
 * @author wWX233376
 * @see  [无]
 * @since  [eSDK UC V100R003C30]
 */
public class ScheduleConfServlet extends HttpServlet {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5053679104100767687L;
	
	/**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(ScheduleConfServlet.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
     
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		//获取页面入参
    	String confName = request.getParameter("confName");
        String beginTime = request.getParameter("beginTime");
        String duration = request.getParameter("duration");
        String accessCode = request.getParameter("accessCode");
        String password = request.getParameter("password");
        String cpResouce = request.getParameter("cpResouce");
        String rate = request.getParameter("rate");
        String isRecording = request.getParameter("isRecording");
        String isLiveBroadcast = request.getParameter("isLiveBroadcast");
        String chairmanPassword = request.getParameter("chairmanPassword");
    	String sitesStr = request.getParameter("sites");

    	@SuppressWarnings("unchecked")
    	List<StringMap<String>> siteInfos = GSON.fromJson(sitesStr, new ArrayList<StringMap<String>>().getClass());
    	
    	ConferenceInfoEx confInfo = new ConferenceInfoEx();
    	confInfo.setName(confName);
    	confInfo.setBeginTime(DateUtils.stringToDate(beginTime, 
    	    "yyyy-MM-dd HH:mm:ss"));
    	confInfo.setDuration(DurationUtils.durationInt2dur(Integer.parseInt(duration)));
    	confInfo.setAccessCode(accessCode);
    	confInfo.setPassword(password);
    	confInfo.setChairmanPassword(chairmanPassword);
    	confInfo.setCpResouce(Integer.parseInt(cpResouce));
    	confInfo.setIsLiveBroadcast(Integer.parseInt(isLiveBroadcast));
    	confInfo.setIsRecording(Integer.parseInt(isRecording));
    	confInfo.setRate(rate);
    	
    	List<SiteInfoEx> sites = new ArrayList<SiteInfoEx>();
    	for(StringMap<String> stringMap : siteInfos)
    	{
    	    SiteInfoEx siteInfoEx = new SiteInfoEx();
    	    siteInfoEx.setName(stringMap.get("name"));
    	    siteInfoEx.setType(Integer.parseInt(stringMap.get("type")));
    	    siteInfoEx.setUri(stringMap.get("uri"));
    	    sites.add(siteInfoEx);
    	}
    	
    	confInfo.setSites(sites);
    	
    	//调用业务接口前需要鉴权
    	AuthorizeServiceEx authorizeServiceEx = ServiceFactory.getAuthorizeServiceEx();
    	Integer errcode = authorizeServiceEx.login(PropertiesUtils.getValue("userName"),
    	    PropertiesUtils.getValue("password"));
    	if(0 != errcode)
    	{
            // 输出流
            PrintWriter pw = response.getWriter();
            TPSDKResponseEx<Integer> result = new TPSDKResponseEx<Integer>();
            result.setResultCode(errcode);
            pw.print(GSON.toJson(result));
            pw.close();
            return;
    	}
    	
    	// 调用呼叫会议管理中的createConf方法
        TPSDKResponseEx<ConferenceInfoEx> createConfResponse =
            ServiceFactory.getConferenceServiceEx().scheduleConfEx(confInfo);
        
        // 根据接口返回数据生成JSON字符串，以便于页面展示
        String result = GSON.toJson(createConfResponse);
        LOGGER.info("Finish to createConf, response is : " + result);

        //退出登录
        authorizeServiceEx.logout();
        
        // 输出流
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print(GSON.toJson(result));
        pw.close();
	}
}

