package com.huawei.esdk.demo.action;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import org.apache.struts2.ServletActionContext;

import com.huawei.esdk.demo.autogen.CameraControlEx;
import com.huawei.esdk.demo.autogen.FreeBusyStateEx;
import com.huawei.esdk.demo.autogen.SiteInfoEx;
import com.huawei.esdk.demo.autogen.TPSDKResponseEx;
import com.huawei.esdk.demo.common.BaseAction;
import com.huawei.esdk.demo.common.Constant;
import com.huawei.esdk.demo.service.ConferenceService;
import com.huawei.esdk.demo.service.SiteService;

public class SiteCtrlAction extends BaseAction {
	/** * */
	private static final long serialVersionUID = 1L;

	private static final int CAMERA_STATE = 0;

	private static final int CAMERA_POS = 255;

	private SiteService siteService = SiteService.getInstance();

	private ConferenceService conferenceService = ConferenceService.getInstance();

	// 摄像头控制
	public void cameraAction() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String siteUri = request.getParameter("siteUri");
		String actionCode = request.getParameter("actionCode");
		String cameraSrc = request.getParameter("auxSrc");
		CameraControlEx cc = new CameraControlEx();
		cc.setCamAction(Integer.valueOf(actionCode));
		cc.setCamPos(CAMERA_POS);
		cc.setCamSrc(Integer.valueOf(cameraSrc));
		cc.setCamState(CAMERA_STATE);
		Integer result = siteService.ctrlCameraEx(siteUri, cc);
		int cationCode = 0;
		if( 0 == result)
		{
		    switch (Integer.valueOf(actionCode))
            {
                case 0:
                    cationCode = 8;
                    break;
                case 1:
                    cationCode = 9;
                    break;
                case 2:
                    cationCode = 10;
                    break;
                case 3:
                    cationCode = 11;
                    break;
                default :
                    cationCode = -1;
                    break;
            }
		    if(-1 != cationCode)
		    {
		        cc.setCamAction(cationCode);
		        siteService.ctrlCameraEx(siteUri, cc);
		    }
		}
		outString(String.valueOf(result));
	}

	public String querySites() throws Exception {
		List<SiteInfoEx> lSiteInfoExs = null;
		TPSDKResponseEx<List<SiteInfoEx>> result = conferenceService
				.querySitesEx();
		StringBuffer reJson = new StringBuffer();
		// json的格式{root:[{siteuri:'01010086',sitename:'xxxx',
		// sitetype:'4'},{siteuri:'01010010',sitename:'xxxx', sitetype:'4'}]}
		reJson.append("{root:[");

		if (0 == result.getResultCode()) {
			lSiteInfoExs = result.getResult();
			
			// 获取会场状态
			List<String> siteUriList = new ArrayList<String>();
			for (SiteInfoEx siteinfo : lSiteInfoExs) {
				siteUriList.add(siteinfo.getUri());
			}
			Map<String, Integer> siteStatusMap = querySiteStatusEx(siteUriList);

			//拼装json消息发往页面
			boolean isFirst = true;
			for (SiteInfoEx siteinfo : lSiteInfoExs) {
				if (null != siteinfo) {
					if (!isFirst) {
						reJson.append(",");
					}
					isFirst = false;
					// 会场URI
					reJson.append("{siteUri:'").append(siteinfo.getUri());
					// 会场名称
					reJson.append("',siteName:'").append(siteinfo.getName());
					// 会场类型
					reJson.append("',siteType:'").append(siteinfo.getType());
					// 会场状态
					Integer sts = siteStatusMap.get(siteinfo.getUri());
					if (null == sts) {
						reJson.append("',siteStatus:'").append(2);
					} else {
						reJson.append("',siteStatus:'").append(sts);
					}
					reJson.append("'}");
				}
			}
		}
		reJson.append("]}");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(reJson.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Integer> querySiteStatusEx(List<String> siteUris) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Duration duration = null;
        try
        {
            duration = DatatypeFactory.newInstance().newDuration("PT300M");
        }
        catch (DatatypeConfigurationException e1)
        {
            return result;
        }
		// 当前时间30分钟内的会场忙闲
        TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> resultSiteSts =
            conferenceService.querySiteStatusEx(siteUris, new Date(), duration);
        Map<String, List<FreeBusyStateEx>> siteStauts = null;
        if (0 == resultSiteSts.getResultCode())
        {
            siteStauts = resultSiteSts.getResult();
            for (String key : siteStauts.keySet())
            {
                List<FreeBusyStateEx> fbse = siteStauts.get(key);
                if (null != fbse)
                {
                    result.put(key, fbse.get(0).getState());
                }
            }
            return result;
        }
        else
        {
            return result;
        }
	}

    public void isConnectAuxSourceEx()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String siteUri = request.getParameter("siteUri");
        try
        {
            TPSDKResponseEx<Integer> result = siteService.isConnectAuxSourceEx(siteUri);
            if (0 == result.getResultCode())
            {
                if (1 == result.getResult())
                {
                    outString("true");
                }
                else
                {
                    outString("false");
                }
            }
            else
            {
                outString(String.valueOf(result.getResultCode()));
            }
        }
        catch (Exception e)
        {
            if(e.getCause() instanceof SocketTimeoutException)
            {
                outString(String.valueOf(Constant.ERROR_CODE_DEVICE_CONN_ERROR));
            }
        }
        
    }

    public void isSendAuxStreamEx()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String siteUri = request.getParameter("siteUri");
        TPSDKResponseEx<Integer> result = siteService.isSendAuxStreamEx(siteUri);
        if (0 == result.getResultCode())
        {
            if (1 == result.getResult())
            {
                outString("true");
            }
            else
            {
                outString("false");
            }
        }
        else
        {
            outString(String.valueOf(result.getResultCode()));
        }
    }

    public void queryMainStreamSourcesEx()
    {
        HttpServletRequest request = ServletActionContext.getRequest();
        String siteUri = request.getParameter("siteUri");
        TPSDKResponseEx<Map<Integer, String>> result = siteService.queryMainStreamSourcesEx(siteUri);
        
        StringBuffer reJson = new StringBuffer();
        // json的格式{root:[{auxID:'01',auxName:'xxxx'}]}
        if (0 == result.getResultCode())
        {
            reJson.append("{root:[");
            Map<Integer, String> mapAux = result.getResult();
            boolean isFirst = true;
            Set<Map.Entry<Integer, String>> items = mapAux.entrySet();
            for (Map.Entry<Integer, String> entry : items)
            {
                if (null != entry)
                {
                    if (!isFirst)
                    {
                        reJson.append(",");
                    }
                    isFirst = false;
                    // 输入源ID
                    reJson.append("{auxID:'").append(entry.getKey());
                    // 输入源名称
                    reJson.append("',auxName:'").append(entry.getValue()).append("'}");
                }
            }
            reJson.append("]}");
            outString(reJson.toString());
        }
        else
        {
            outString(String.valueOf(result.getResultCode()));
        }
    }
}
