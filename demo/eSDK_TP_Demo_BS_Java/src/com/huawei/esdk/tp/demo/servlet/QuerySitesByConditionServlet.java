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
import com.huawei.esdk.tp.demo.utils.PropertiesUtils;
import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.bean.FiltersEx;
import com.huawei.esdk.tp.professional.local.bean.PageParamEx;
import com.huawei.esdk.tp.professional.local.bean.QueryConfigEx;
import com.huawei.esdk.tp.professional.local.bean.QuerySitesByConditionExResponse;
import com.huawei.esdk.tp.professional.local.bean.SortItemsEx;
import com.huawei.esdk.tp.professional.local.bean.StringFilterEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

/**
 * 通讯录处理类
 * 用于添加账号
 * @author wWX233376
 * @see  [无]
 * @since  [eSDK UC V100R003C30]
 */
public class QuerySitesByConditionServlet extends HttpServlet {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5053679104100767687L;
	
	/**
     * log日志对象
     */
    private static final Logger LOGGER = Logger.getLogger(QuerySitesByConditionServlet.class);
    
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
     
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		//获取页面入参
    	String numberPerPage = request.getParameter("numberPerPage");
        String currentPage = request.getParameter("currentPage");
        String focusItem = request.getParameter("focusItem");

    	String sortItemsStr = request.getParameter("sortItems");
    	String filtersStr = request.getParameter("filters");
    	

    	@SuppressWarnings("unchecked")
        List<StringMap<String>> sortItemInfos = GSON.fromJson(sortItemsStr, new ArrayList<StringMap<String>>().getClass());
    	@SuppressWarnings("unchecked")
        List<StringMap<String>> filterInfos = GSON.fromJson(filtersStr, new ArrayList<StringMap<String>>().getClass());
    	
    	QueryConfigEx queryConfig = new QueryConfigEx();
    	PageParamEx pageParam = new PageParamEx();
    	pageParam.setCurrentPage(Integer.parseInt(currentPage));
    	pageParam.setNumberPerPage(Integer.parseInt(numberPerPage));
    	queryConfig.setPageParam(pageParam);
    	
    	if(null != focusItem && !"".equals(focusItem))
    	{
    	    queryConfig.setFocusItem(Integer.parseInt(focusItem));
    	}
    	
    	List<SortItemsEx> sortItems = new ArrayList<SortItemsEx>();
    	for(StringMap<String> stringMap : sortItemInfos)
    	{
    	    SortItemsEx sortitem = new SortItemsEx();
    	    sortitem.setItemIndex(Integer.parseInt(stringMap.get("itemIndex")));
    	    sortitem.setSort(Integer.parseInt(stringMap.get("sort")));
    	    sortItems.add(sortitem);
    	}
    	queryConfig.setSortItems(sortItems);
    	
        List<FiltersEx> filters = new ArrayList<FiltersEx>();
        for(StringMap<String> stringMap : filterInfos)
        {
            StringFilterEx stringFilter = new StringFilterEx();
            stringFilter.setColumnIndex(Integer.parseInt(stringMap.get("columnIndex")));
            stringFilter.setValue(stringMap.get("value"));
            filters.add(stringFilter);
        }
        queryConfig.setFilters(filters);
    	
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
        TPSDKResponseEx<QuerySitesByConditionExResponse> createConfResponse =
            ServiceFactory.getConferenceServiceEx().querySitesByConditionEx(queryConfig);
        
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

