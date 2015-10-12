package com.huawei.esdk.demo.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础Action
 */
public class BaseAction extends ActionSupport
{

    private static final long serialVersionUID = 1L;
    
    private Logger log = Logger.getLogger(BaseAction.class);

    public HttpServletRequest getRequest()
    {
        return ServletActionContext.getRequest();
    }

    public HttpServletResponse getResponse()
    {
        return ServletActionContext.getResponse();
    }

    /**
     * 输出json
     * * @param str str
     */
    public void outJsonString(String str)
    {
        outString(str);
    }

    /**
     * 输出obj
     * * @param obj obj
     */
    public void outJson(Object obj)
    {
        outJsonString(JSONObject.fromObject(obj).toString());
    }

    /**
     * 输出array
     * * @param obj obj
     */
    public void outJsonArray(Object obj)
    {
        outJsonString(JSONArray.fromObject(obj).toString());
    }

    /**
     * 输出string
     * * @param str str
     */
    public void outString(String str)
    {
    	getResponse().setContentType("text/javascript;charset=UTF-8");
        try
        {
            PrintWriter out = getResponse().getWriter();
            out.write(str);
        }
        catch (IOException e)
        {
            log.error(e.getMessage());
        }
    }
    
    public void outJS(String str)
    {
    	getResponse().setContentType("text/html;charset=UTF-8");
    	getResponse().setHeader("Cache-Control", "no-cache");
    	try
        {
            PrintWriter out = getResponse().getWriter();
            out.write(str);
        }
        catch (IOException e)
        {
            log.error(e.getMessage());
        }
    }
}
