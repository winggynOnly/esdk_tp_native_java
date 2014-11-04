package com.huawei.esdk.tp.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.huawei.esdk.tp.demo.utils.DateUtils;

/**
 * 通讯录处理类
 * 用于添加账号
 * @author wWX233376
 * @see  [无]
 * @since  [eSDK UC V100R003C30]
 */
public class CheckDateServlet extends HttpServlet {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 5053679104100767687L;
	
    /**
     * Gson，用于进行对象和json之间的转换
     */
    private static final Gson GSON = new Gson();
     
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
        doGet(request, response);
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
            String dateStr = req.getParameter("dateStr");
            Date date = DateUtils.stringToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
            String response = "false";
            if(null != date)
            {
                response = "true";
                PrintWriter pw = resp.getWriter();
                pw.print(GSON.toJson(response));
                pw.close();
            }
    }
}

