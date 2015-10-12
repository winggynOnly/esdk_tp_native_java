package com.huawei.esdk.tp.professional.local.site;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import junit.framework.Assert;
import mockit.Mock;
import mockit.MockUp;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huawei.esdk.tp.professional.local.ServiceFactoryEx;
import com.huawei.esdk.tp.professional.local.bean.CameraControlEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.bean.VideoSourcesInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteDeviceVersionInfoEx;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;

public class SiteServiceExImplTest {
	static MockUp<ClientProvider> clientMock = null;
	
	@BeforeClass
	public static void before() {
		clientMock = new MockUp<ClientProvider>() {
			@SuppressWarnings({ "rawtypes", "unused" })
			@Mock
			 public synchronized Object getClient(Class clz) {
				return new SiteImpl();
			}
		};
	}
	
	@After
	public void after(){
		SiteImpl.isConnectAuxSourceExResult = 0;
		SiteImpl.querySiteVersionInfoExResult = 0;
		SiteImpl.queryAuxStreamSourcesExResult = 0;
		SiteImpl.setVideoOutSrcExResult = 0;
		SiteImpl.isSendAuxStreamExResult = 0;
		SiteImpl.queryVideoOutSrcStateExResult = 0;
		SiteImpl.ctrlCameraExResult = 0;
		SiteImpl.setAuxStreamExResult = 0;
		SiteImpl.isReceiveRemAuxStrmExResult = 0;
		SiteImpl.queryMainStreamSourcesExResult = 0;
		SiteImpl.setMainAuxStreamSourcesExResult = 0;
		SiteImpl.throwException = false;
		SiteImpl.exceptionCode = 0;
	}
	/////////////////////////////////////////////////////////////////////01_01 查询是否接入辅流源isConnectAuxSourceEx /////////////////////////////////////////////////////////////////////////
	@Test
	public void isConnectAuxSourceExTest001(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseSiteServiceEx=siteServiceEx.isConnectAuxSourceEx("01010086");
		Assert.assertEquals(0, responseSiteServiceEx.getResultCode());
	}
	//OK
	@Test
	public void isConnectAuxSourceExTest002(){
		SiteImpl.isConnectAuxSourceExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseSiteServiceEx=siteServiceEx.isConnectAuxSourceEx("01010010");
		Assert.assertEquals(-1, responseSiteServiceEx.getResultCode());
	}
	
	@Test
	public void isConnectAuxSourceExTest003(){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 2130000020;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseSiteServiceEx=siteServiceEx.isConnectAuxSourceEx("01010010");
		Assert.assertEquals(2130000020, responseSiteServiceEx.getResultCode());
	}
	////////////////////////////////////////////////////////////////01_02 查询当前是否正在发送辅流isSendAuxStreamEx ///////////////////////////////////////////////////////////////////////////
	//
	@Test
	public void isReceiveRemAuxStrmEx01 (){
		SiteImpl.isReceiveRemAuxStrmExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isReceiveRemAuxStrmEx ("01010086");
		Assert.assertEquals(-1, responseEx.getResultCode());
	}
	@Test
	public void isReceiveRemAuxStrmEx02 (){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isReceiveRemAuxStrmEx ("01010086");
		Assert.assertEquals(0, responseEx.getResultCode());
	}
	
	@Test
	public void isReceiveRemAuxStrmEx03 (){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 2130000020;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isReceiveRemAuxStrmEx ("01010086");
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}
	
	///////////////////////////////////////////////////////////////01_03查询指定会场是否正在接收远端辅流///////////////////////////////////////////////////////////////////////////////
	//
	//
	@Test
	public void isSendAuxStreamExExTest01(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isSendAuxStreamEx("01010086");
		Assert.assertEquals(0, responseEx.getResultCode());
	}
	
	@Test
	public void isSendAuxStreamExExTest02(){
		SiteImpl.isSendAuxStreamExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isSendAuxStreamEx("01010086");
		Assert.assertEquals(-1, responseEx.getResultCode());
	}
	
	@Test
	public void isSendAuxStreamExExTest03(){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 571052032;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Integer > responseEx=siteServiceEx.isSendAuxStreamEx("01010086");
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}
	
	
	////////////////////////////////////////////////////////////////01_04 设置开始或停止发送辅流///////////////////////////////////////////////////////////////////////////////
	//会场已接入辅流源，在会议中，开始发送辅流成功
	//OK
	@Test
	public void setAuxStreamExTest001() throws DatatypeConfigurationException, InterruptedException{
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(0, siteServiceEx.setAuxStreamEx("01010086", 1).intValue());
		
	}
	//会场已接入辅流源，会议中已有其它会场发送辅流，开始发送辅流失败
	//OK
	@Test
	public void setAuxStreamExTest002() throws DatatypeConfigurationException, InterruptedException{
		SiteImpl.setAuxStreamExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(-1, siteServiceEx.setAuxStreamEx("01010086", 1).intValue());
	}
	
	@Test
	public void setAuxStreamExTest003() throws DatatypeConfigurationException, InterruptedException{
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 571052032;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(2130000020, siteServiceEx.setAuxStreamEx("01010086", 1).intValue());
	}
	/////////////////////////////////////////////////////////////////////01_05 获取辅流视频源列表////////////////////////////////////////////////////////////////////////////	
	//会场有一个辅流源，获取辅流源列表成功
	//
	@Test
	public void queryAuxStreamSourcesExTest01(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryAuxStreamSourcesEx("01010086");
		Assert.assertEquals(0, responseEx.getResultCode());
	}
	@Test
	public void queryAuxStreamSourcesExTest02(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		SiteImpl.queryAuxStreamSourcesExResult = -1;
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryAuxStreamSourcesEx("01010086");
		Assert.assertEquals(-1, responseEx.getResultCode());
	}
	
	@Test
	public void queryAuxStreamSourcesExTest03(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 571052032;
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryAuxStreamSourcesEx("01010086");
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}
	
	
	
	//////////////////////////////////////////////////////////////////////01_06 查询视频输入口接入视频源状态///////////////////////////////////////////////////////////////////////////
	//会场接入一路输入视屏源，查询成功(拔掉HD　IN　1　接口）
	//OK
	@Test
	public void  queryVideoOutSrcStateExTest001() {
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<List<VideoSourcesInfoEx>> responseEx=siteServiceEx.queryVideoOutSrcStateEx("01010086");
		Assert.assertEquals(0, responseEx.getResultCode());
		Assert.assertEquals(1, responseEx.getResult().get(0).getSourcesState().intValue());
		Assert.assertEquals("HD-SDI", responseEx.getResult().get(0).getSourcesName());
		Assert.assertEquals(1, responseEx.getResult().get(0).getSourcesState().intValue());
	}
	//会场接入两路输入视屏源，查询成功
	//OK
	@Test
	public void  queryVideoOutSrcStateExTest002() {
		SiteImpl.queryVideoOutSrcStateExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<List<VideoSourcesInfoEx>> responseEx=siteServiceEx.queryVideoOutSrcStateEx("01010086");
		Assert.assertEquals(-1, responseEx.getResultCode());
		
	}
	
	@Test
	public void  queryVideoOutSrcStateExTest003() {
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 571052032;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<List<VideoSourcesInfoEx>> responseEx=siteServiceEx.queryVideoOutSrcStateEx("01010086");
		Assert.assertEquals(2130000020, responseEx.getResultCode());
		
	}
	///////////////////////////////////////////////////////////////////////01_07 摄像机控制操作//////////////////////////////////////////////////////////////////////
	//
	//
	//在摄像头最大像素内，放大图像成功
	//OK
	@Test
	public void ctrlCameraExTest001() {
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		CameraControlEx cameraControl = new CameraControlEx();
		cameraControl.setCamAction(4);
		cameraControl.setCamPos(1);
		cameraControl.setCamSrc(1);
		cameraControl.setCamState(0);
		Assert.assertEquals(0,siteServiceEx.ctrlCameraEx("01010086", cameraControl).intValue());
	}
	//OK
	@Test
	public void ctrlCameraExTest002() throws InterruptedException {
		SiteImpl.ctrlCameraExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		CameraControlEx cameraControl = new CameraControlEx();
		cameraControl.setCamAction(400);
		cameraControl.setCamPos(1);
		cameraControl.setCamSrc(1);
		cameraControl.setCamState(0);
		Assert.assertEquals(-1,siteServiceEx.ctrlCameraEx("01010086", cameraControl).intValue());
	}
	
	@Test
	public void ctrlCameraExTest003() throws InterruptedException {
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 1351614476;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		CameraControlEx cameraControl = new CameraControlEx();
		cameraControl.setCamAction(400);
		cameraControl.setCamPos(1);
		cameraControl.setCamSrc(1);
		cameraControl.setCamState(0);
		Assert.assertEquals(2130000020,siteServiceEx.ctrlCameraEx("01010086", cameraControl).intValue());
	}
	/////////////////////////////////////////////////////01_08 设置主流视频源、辅流视频源////////////////////////////////////////////////////////////////////////////////////////
	//会场接入两路主流视屏源，一路辅流视屏源，设置主流视屏源，辅流视屏源成功
	//OK
	@Test
	public void setMainAuxStreamSourcesExTest001(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(0, siteServiceEx.setMainAuxStreamSourcesEx("01010086", list, 0).intValue());
	}
	//会场接入1路主流视屏源，2路辅流视屏源，设置主流视屏源，辅流视屏源成功
	//OK
	@Test
	public void setMainAuxStreamSourcesExTest002(){
		SiteImpl.setMainAuxStreamSourcesExResult = -1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(-1, siteServiceEx.setMainAuxStreamSourcesEx("01010086", list, 3).intValue());
	}
	
	@Test
	public void setMainAuxStreamSourcesExTest003(){
		SiteImpl.throwException = true;
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		SiteImpl.exceptionCode = 1351614476;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(2130000020, siteServiceEx.setMainAuxStreamSourcesEx("01010086", list, 3).intValue());
	}
	/////////////////////////////////////////////////////01_09 获取主流视频源的下拉列表框内容/////////////////////////////////////////////////////////////////////////////////////////
	//OK
	@Test
	public void queryMainStreamSourcesExTest001(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryMainStreamSourcesEx("01010086");
		Assert.assertEquals(0, responseEx.getResultCode());
	}
	//OK
	@Test
	public void queryMainStreamSourcesExTest002(){
		SiteImpl.queryMainStreamSourcesExResult = -1;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryMainStreamSourcesEx("01010010");
		Assert.assertEquals(-1, responseEx.getResultCode());
	}
	
	@Test
	public void queryMainStreamSourcesExTest003(){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 1351614476;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx< Map<Integer,String>> responseEx=siteServiceEx.queryMainStreamSourcesEx("01010010");
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}
	//////////////////////////////////////////////////////01_10 设置输出口显示内容/////////////////////////////////////////////////////////////////////////////////////////
	//设置本端视频源输出口0为本地主流,设置成功
	//OK
	@Test
	public void setVideoOutSrcExTest001(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(0, siteServiceEx.setVideoOutSrcEx("01010086", 1, 0).intValue());
	}
	//设置本端不存的在输出口显示内容,设置失败
	//
	@Test
	public void setVideoOutSrcExTest002(){
		SiteImpl.setVideoOutSrcExResult = 151031812;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(151031812, siteServiceEx.setVideoOutSrcEx("01010086", 20, 0).intValue());
	}
	
	@Test
	public void setVideoOutSrcExTest003(){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 1351614476;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		Assert.assertEquals(2130000020, siteServiceEx.setVideoOutSrcEx("01010086", 20, 0).intValue());
	}
	//////////////////////////////////////////////////////01_11 查询获取终端型号/版本信息////////////////////////////////////////////////////////////////////////////////////////
	//输入存在的会场Uri，查询终端型号/版本信息成功
	//OK
	@Test
	public void querySiteVersionInfoExTest001(){
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<SiteDeviceVersionInfoEx> response=siteServiceEx.querySiteVersionInfoEx("01010086");
		Assert.assertEquals(0, response.getResultCode());
		Assert.assertEquals("9039S", response.getResult().getModel());
		Assert.assertEquals(" 2102310AAS6RAB000065", response.getResult().getLicense());
		Assert.assertEquals(" VCT V100R011C02B014SP03 Release   2012.12.19", response.getResult().getSoftVersion());
	}
	//输入不存在的会场Uri，查询终端型号/版本信息失败
	//
	@Test
	public void querySiteVersionInfoExTest002(){
		SiteImpl.querySiteVersionInfoExResult = 13;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<SiteDeviceVersionInfoEx> response=siteServiceEx.querySiteVersionInfoEx("11111");
		Assert.assertEquals(13, response.getResultCode());
	}
	
	@Test
	public void querySiteVersionInfoExTest003(){
		SiteImpl.throwException = true;
		SiteImpl.exceptionCode = 1351614476;
		SiteServiceEx siteServiceEx=(SiteServiceEx) ServiceFactoryEx.getService(SiteServiceEx.class);
		TPSDKResponseEx<SiteDeviceVersionInfoEx> response=siteServiceEx.querySiteVersionInfoEx("11111");
		Assert.assertEquals(2130000020, response.getResultCode());
	}

}
