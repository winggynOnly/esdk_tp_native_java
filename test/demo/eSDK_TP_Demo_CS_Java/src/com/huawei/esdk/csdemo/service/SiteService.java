package com.huawei.esdk.csdemo.service;

import java.util.List;
import java.util.Map;
import com.huawei.esdk.csdemo.common.ServiceFactory;
import com.huawei.esdk.tp.professional.local.bean.CameraControlEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.site.SiteServiceEx;


public class SiteService
{
    private SiteServiceEx service = null;

    public SiteService()
    {
        service = ServiceFactory.getInstance().getSiteServiceEx();
    }
    
    public TPSDKResponseEx<Integer> isConnectAuxSourceEx(String siteURI){
      TPSDKResponseEx<Integer> result =  service.isConnectAuxSourceEx(siteURI);
      return result;
    }
    public TPSDKResponseEx<Integer> isSendAuxStreamEx(String siteURI){
        TPSDKResponseEx<Integer> result =  service.isSendAuxStreamEx(siteURI);
        return result;
    }
    public Integer setAuxStreamEx(String siteURI, Integer controlCode){
        Integer result =  service.setAuxStreamEx(siteURI, controlCode);
        return result;
    }
    public TPSDKResponseEx<Map<Integer, String>> queryAuxStreamSourcesEx(String siteURI){
        TPSDKResponseEx<Map<Integer, String>> result =  service.queryAuxStreamSourcesEx(siteURI);
        return result;
    }
    
    public Integer setMainAuxStreamSourcesEx(String siteUri, List<Integer> localMainSrc, Integer localAuxSrc){
        Integer result =  service.setMainAuxStreamSourcesEx(siteUri, localMainSrc, localAuxSrc);
        return result;
    }
    
    public TPSDKResponseEx<Map<Integer, String>> queryMainStreamSourcesEx (String siteURI){
        TPSDKResponseEx<Map<Integer, String>> result =  service.queryMainStreamSourcesEx(siteURI);
        return result;
    }
    
    public Integer ctrlCameraEx(String siteUri, CameraControlEx cameraControl){
        return service.ctrlCameraEx(siteUri, cameraControl);
    }
}
