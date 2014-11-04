package com.huawei.esdk.tp.professional.local.site;

import java.util.List;
import java.util.Map;

import com.huawei.esdk.tp.professional.local.bean.CameraControlEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.bean.VideoSourcesInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteDeviceVersionInfoEx;

public interface SiteServiceEx {
	TPSDKResponseEx<Integer> isConnectAuxSourceEx(String siteURI);

	TPSDKResponseEx<Integer> isSendAuxStreamEx(String siteURI);

	TPSDKResponseEx<Integer> isReceiveRemAuxStrmEx(String siteURI);

	Integer setAuxStreamEx(String siteUri, Integer controlCode);

	TPSDKResponseEx<Map<Integer, String>> queryAuxStreamSourcesEx(String siteURI);

	TPSDKResponseEx<List<VideoSourcesInfoEx>> queryVideoOutSrcStateEx(
			String siteURI);

	Integer ctrlCameraEx(String siteUri, CameraControlEx cameraControl);

	Integer setMainAuxStreamSourcesEx(String siteUri, List<Integer> localMainSrc,
			Integer localAuxSrc);

	TPSDKResponseEx<Map<Integer, String>> queryMainStreamSourcesEx(
			String siteUri);

	Integer setVideoOutSrcEx(String siteUri, Integer hdOut, Integer videoSrc);

	TPSDKResponseEx<SiteDeviceVersionInfoEx> querySiteVersionInfoEx(
			String siteURI);
}
