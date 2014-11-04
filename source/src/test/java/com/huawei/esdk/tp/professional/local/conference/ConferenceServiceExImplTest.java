package com.huawei.esdk.tp.professional.local.conference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import mockit.Mock;
import mockit.MockUp;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huawei.esdk.tp.professional.local.ServiceFactoryEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceStatusEx;
import com.huawei.esdk.tp.professional.local.bean.FreeBusyStateEx;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;

public class ConferenceServiceExImplTest {
	static MockUp<ClientProvider> clientMock = null;

	private TPSDKResponseEx<ConferenceInfoEx> responsescheduleConferenceEx = null;
	private TPSDKResponseEx<ConferenceInfoEx> resposeEditScheduleConferenceEx = null;
	private TPSDKResponseEx<RecurrenceConfInfoEx> responseScheduleRecurrenceConferenceEx = null;

	@BeforeClass
	public static void before() {
		clientMock = new MockUp<ClientProvider>() {
			@SuppressWarnings({ "rawtypes", "unused" })
			@Mock
			public synchronized Object getClient(Class clz) {
				return new ConferenceImpl();
			}
		};
	}

	@After
	public void after() {
		ConferenceImpl.setDirectBroadExResult = 0;
		ConferenceImpl.setVideoSourceExResult = 0;
		ConferenceImpl.setSitesMuteExResult = 0;
		ConferenceImpl.queryConfCtrlPwdExResult = 0;
		ConferenceImpl.setContinuousPresenceExResult = 0;
		ConferenceImpl.setBroadcastSiteExResult = 0;
		ConferenceImpl.queryBroadInfoExResult = 0;
		ConferenceImpl.setRecordBroadExResult = 0;
		ConferenceImpl.setAudioSwitchExResult = 0;
		ConferenceImpl.releaseChairExResult = 0;
		ConferenceImpl.setSitesQuietExResult = 0;
		ConferenceImpl.setBroadcastContinuousPresenceExResult = 0;
		ConferenceImpl.requestChairExResult = 0;
		ConferenceImpl.scheduleRecurrenceConferenceExResult = 0;
		ConferenceImpl.delSiteFromConfExResult = 0;
		ConferenceImpl.connectSitesExResult = 0;
		ConferenceImpl.disconnectSitesExResult = 0;
		ConferenceImpl.scheduleConfExResult = 0;
		ConferenceImpl.prolongScheduledConfExResult = 0;
		ConferenceImpl.queryConfSitesStatusExResult = 0;
		ConferenceImpl.delScheduledConfExResult = 0;
		ConferenceImpl.editScheduledConfExResult = 0;
		ConferenceImpl.addSiteToConfExResult = 0;
		ConferenceImpl.querySiteStatusExResult = 0;
		ConferenceImpl.queryConferencesStatusExResult = 0;
		ConferenceImpl.synchSiteStatusExResult = 0;
		ConferenceImpl.editRecurrenceConferenceExResult = 0;
		ConferenceImpl.querySitesExResult = 0;
		ConferenceImpl.throwException = false;
		ConferenceImpl.exceptionCode = 0; 
	}

	// //////////////////////////////////////////////////召集或预约非周期性会议（scheduleConferenceEx）/////////////////////////////////////////////////////////////////

	@Test
	public void scheduleConferenceExTest001()
			throws DatatypeConfigurationException {
		ConferenceImpl.scheduleConfExResult = 1347424311;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("无会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 30);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo = null;
		scheduleConf.getSites().add(siteInfo);
		scheduleConf.setRate("1920K");
		responsescheduleConferenceEx = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(1347424311,
				responsescheduleConferenceEx.getResultCode());
		Assert.assertNull(responsescheduleConferenceEx.getResult());
	}

	@Test
	public void scheduleConferenceExTest002()
			throws DatatypeConfigurationException {
		ConferenceImpl.throwException = true;
		ConferenceImpl.exceptionCode = 1351614476;
		
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("一个会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 30);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		scheduleConf.setRate("1920K");
		responsescheduleConferenceEx = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(2130000020, responsescheduleConferenceEx.getResultCode());
	}
	
	@Test
	public void scheduleConferenceExTest003()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("一个会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 30);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		scheduleConf.setRate("1920K");
		responsescheduleConferenceEx = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, responsescheduleConferenceEx.getResultCode());
		Assert.assertNotNull(responsescheduleConferenceEx.getResult());
	}

	@Test
	public void scheduleRecurrenceConferenceExTest001()
			throws DatatypeConfigurationException {
		ConferenceImpl.scheduleRecurrenceConferenceExResult = 1347424311;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx recurrenceScheduleConf = new RecurrenceConfInfoEx();
		recurrenceScheduleConf.setName("周期会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60);
		recurrenceScheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90);
		recurrenceScheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = null;
		recurrenceScheduleConf.getSites().add(siteInfo1);
		recurrenceScheduleConf.setFrequency(0);
		recurrenceScheduleConf.setInterval(1);
		recurrenceScheduleConf.setCount(3);
		recurrenceScheduleConf.setRate("1920K");
		responseScheduleRecurrenceConferenceEx = conferenceServiceEx
				.scheduleRecurrenceConferenceEx(recurrenceScheduleConf);
		Assert.assertEquals(1347424311,
				responseScheduleRecurrenceConferenceEx.getResultCode());
		Assert.assertNull(responseScheduleRecurrenceConferenceEx.getResult());
		responseScheduleRecurrenceConferenceEx = null;
	}

	@Test
	public void scheduleRecurrenceConferenceExTest002()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx recurrenceScheduleConf = new RecurrenceConfInfoEx();
		recurrenceScheduleConf.setName("周期会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60);
		recurrenceScheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90);
		recurrenceScheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		recurrenceScheduleConf.getSites().add(siteInfo1);
		recurrenceScheduleConf.setFrequency(0);
		recurrenceScheduleConf.setInterval(1);
		recurrenceScheduleConf.setCount(3);
		recurrenceScheduleConf.setRate("1920K");
		responseScheduleRecurrenceConferenceEx = conferenceServiceEx
				.scheduleRecurrenceConferenceEx(recurrenceScheduleConf);
		Assert.assertEquals(0,
				responseScheduleRecurrenceConferenceEx.getResultCode());
		Assert.assertNotNull(responseScheduleRecurrenceConferenceEx.getResult());
		responseScheduleRecurrenceConferenceEx = null;
	}
	
	@Test
	public void scheduleRecurrenceConferenceExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.throwException = true;
		ConferenceImpl.exceptionCode = 1351614476;
		
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx recurrenceScheduleConf = new RecurrenceConfInfoEx();
		recurrenceScheduleConf.setName("周期会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60);
		recurrenceScheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90);
		recurrenceScheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		recurrenceScheduleConf.getSites().add(siteInfo1);
		recurrenceScheduleConf.setFrequency(0);
		recurrenceScheduleConf.setInterval(1);
		recurrenceScheduleConf.setCount(3);
		recurrenceScheduleConf.setRate("1920K");
		responseScheduleRecurrenceConferenceEx = conferenceServiceEx
				.scheduleRecurrenceConferenceEx(recurrenceScheduleConf);
		Assert.assertEquals(2130000020,
				responseScheduleRecurrenceConferenceEx.getResultCode());
	}

	@Test
	public void editConferenceExTest001() throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("多个会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		responsescheduleConferenceEx = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, responsescheduleConferenceEx.getResultCode());

		ConferenceInfoEx editConf = new ConferenceInfoEx(); // 编辑会议信息
		editConf.setConfId(responsescheduleConferenceEx.getResult().getConfId());
		editConf.setName("修改会议名称的会议");
		editConf.setBeginTime(scheduleConf.getBeginTime());
		editConf.setDuration(scheduleConf.getDuration());
		editConf.getSites().addAll(scheduleConf.getSites());
		editConf.setRate(scheduleConf.getRate());
		resposeEditScheduleConferenceEx = conferenceServiceEx
				.editScheduledConfEx(editConf);
		Assert.assertEquals(0, resposeEditScheduleConferenceEx.getResultCode());
	}

	@Test
	public void editConferenceExTest002() throws DatatypeConfigurationException {
		
		ConferenceImpl.throwException = true;
		ConferenceImpl.exceptionCode = 1351614476;
		
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx editConf = new ConferenceInfoEx(); // 编辑会议信息
		editConf.setConfId("1477");
		editConf.setName("test");
		Date editTime = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
		editConf.setBeginTime(editTime);
		editConf.setDuration(DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60));
		resposeEditScheduleConferenceEx = conferenceServiceEx
				.editScheduledConfEx(editConf);
		Assert.assertEquals(2130000020,
				resposeEditScheduleConferenceEx.getResultCode());
	}
	
	@Test
	public void editConferenceExTest003() throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceImpl.editScheduledConfExResult = 1234;
		ConferenceInfoEx editConf = new ConferenceInfoEx(); // 编辑会议信息
		editConf.setConfId("1477");
		editConf.setName("test");
		Date editTime = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
		editConf.setBeginTime(editTime);
		editConf.setDuration(DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60));
		resposeEditScheduleConferenceEx = conferenceServiceEx
				.editScheduledConfEx(editConf);
		Assert.assertEquals(1234,
				resposeEditScheduleConferenceEx.getResultCode());
	}

	// /////////////////////////////////////////////////////////////////////////编辑已预约的周期性会议（editRecurrenceConferenceEx）////////////////////////////////////////////////////////////////////

	@Test
	public void editRecurrenceConferenceExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx editConf = new RecurrenceConfInfoEx(); // 编辑会议信息
		editConf.setConfId("1477");
		editConf.setName("修改名称的周期会议");
		editConf.setBeginTime(new Date(new Date().getTime() + 1000 * 60 * 60));
		editConf.setDuration(DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90));
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		editConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		editConf.getSites().add(siteInfo2);
		editConf.setRate("1920K");
		editConf.setFrequency(2);
		editConf.setWeekDay(1);
		editConf.setInterval(1);
		editConf.setCount(5);
		TPSDKResponseEx<RecurrenceConfInfoEx> responseEditConferenceEx = conferenceServiceEx
				.editRecurrenceConferenceEx(editConf);
		Assert.assertEquals(0, responseEditConferenceEx.getResultCode());
	}

	@Test
	public void editRecurrenceConferenceExTest002()
			throws DatatypeConfigurationException {
		ConferenceImpl.editRecurrenceConferenceExResult = 1234;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx editConf = new RecurrenceConfInfoEx();
		editConf.setConfId("1477");
		editConf.setName("修改名称的周期会议");
		editConf.setBeginTime(new Date(new Date().getTime() + 1000 * 60 * 60));
		editConf.setDuration(DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90));
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		editConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		editConf.getSites().add(siteInfo2);
		editConf.setRate("0K");
		editConf.setFrequency(2);
		editConf.setWeekDay(1);
		editConf.setInterval(1);
		editConf.setCount(5);
		TPSDKResponseEx<RecurrenceConfInfoEx> responseEditConferenceEx = conferenceServiceEx
				.editRecurrenceConferenceEx(editConf);
		Assert.assertEquals(1234, responseEditConferenceEx.getResultCode());
	}
	
	@Test
	public void editRecurrenceConferenceExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.throwException = true;
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		RecurrenceConfInfoEx editConf = new RecurrenceConfInfoEx();
		editConf.setConfId("1477");
		editConf.setName("修改名称的周期会议");
		editConf.setBeginTime(new Date(new Date().getTime() + 1000 * 60 * 60));
		editConf.setDuration(DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 90));
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		editConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		editConf.getSites().add(siteInfo2);
		editConf.setRate("0K");
		editConf.setFrequency(2);
		editConf.setWeekDay(1);
		editConf.setInterval(1);
		editConf.setCount(5);
		TPSDKResponseEx<RecurrenceConfInfoEx> responseEditConferenceEx = conferenceServiceEx
				.editRecurrenceConferenceEx(editConf);
		Assert.assertEquals(2130000020, responseEditConferenceEx.getResultCode());
	}

	// /////////////////////////////////////////////////////////////////////02_05
	// 查询所有会场列表（querySitesEx）/////////////////////////////////////////////////////////////////////

	@Test
	public void querySitesExTest001() {
		ConferenceImpl.querySitesExResult = -1;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		TPSDKResponseEx<List<SiteInfoEx>> response = conferenceServiceEx
				.querySitesEx();
		Assert.assertEquals(-1, response.getResultCode());
	}

	// OK
	@Test
	public void querySitesExTest002() {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		TPSDKResponseEx<List<SiteInfoEx>> response = conferenceServiceEx
				.querySitesEx();
		Assert.assertEquals(0, response.getResultCode());
		Assert.assertEquals("东方不败", response.getResult().get(0).getName());
		Assert.assertEquals("01010010", response.getResult().get(0).getUri());
	}
	
	@Test
	public void querySitesExTest003() {
		ConferenceImpl.throwException = true;
		ConferenceImpl.exceptionCode = 2130000020;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		TPSDKResponseEx<List<SiteInfoEx>> response = conferenceServiceEx
				.querySitesEx();
		Assert.assertEquals(2130000020, response.getResultCode());
	}

	// ////////////////////////////////////////////////////////////////02_06
	// 延长已预约会议时间（prolongScheduledConfEx）/////////////////////////////////////////////////////////////////////////
	@Test
	public void prolongScheduledConfExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response.getResultCode());
		Duration prolongTimeDuration = DatatypeFactory.newInstance()
				.newDuration(1000 * 60 * 120);
		Assert.assertEquals(
				0,
				conferenceServiceEx.prolongScheduledConfEx(
						response.getResult().getConfId(),
						scheduleConf.getBeginTime(), prolongTimeDuration)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response.getResult().getConfId(), beginTime).intValue());
	}

	@Test
	public void prolongScheduledConfExTest002()
			throws DatatypeConfigurationException {
		ConferenceImpl.prolongScheduledConfExResult = 0x1234;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		Assert.assertEquals(
				0x1234,
				conferenceServiceEx.prolongScheduledConfEx(
						"1477",
						null,
						DatatypeFactory.newInstance().newDuration(
								1000 * 60 * 1060)).intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx("1477",
						new Date(new Date().getTime() + 1000 * 60 * 60))
						.intValue());
	}
	
	@Test
	public void prolongScheduledConfExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		Assert.assertEquals(
				2130000020,conferenceServiceEx.prolongScheduledConfEx("1477",null,null).intValue());
		
	}

	@Test
	public void querySiteStatusExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		Date beginTime = new Date(new Date().getTime());
		Duration queryDuration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 30);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010010");
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseFreeBusyStateEx = conferenceServiceEx
				.querySiteStatusEx(siteList, beginTime, queryDuration);
		Assert.assertEquals(0, responseFreeBusyStateEx.getResultCode());
		Assert.assertTrue(null == responseFreeBusyStateEx.getResult()
				|| responseFreeBusyStateEx.getResult().size() == 0);
	}

	@Test
	public void querySiteStatusExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		ConferenceImpl.querySiteStatusExResult = 1234;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		siteInfo1.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		siteInfo2.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		siteInfo3.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response.getResultCode());
		beginTime = new Date(new Date().getTime());
		Duration queryDuration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 30);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseFreeBusyStateEx = conferenceServiceEx
				.querySiteStatusEx(siteList, beginTime, queryDuration);
		Assert.assertEquals(1234, responseFreeBusyStateEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response.getResult().getConfId(), beginTime).intValue());
	}
	@Test
	public void querySiteStatusExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseFreeBusyStateEx = conferenceServiceEx
				.querySiteStatusEx(null, null, null);
		Assert.assertEquals(2130000020, responseFreeBusyStateEx.getResultCode());
		
	}
	@Test
	public void queryConferencesStatusExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		List<String> confIds = new ArrayList<String>();
		confIds.add("8953");
		TPSDKResponseEx<List<ConferenceStatusEx>> responseEx = conferenceServiceEx
				.queryConferencesStatusEx(confIds);
		Assert.assertEquals(0, responseEx.getResultCode());

	}

	@Test
	public void queryConferencesStatusExTest002()
			throws DatatypeConfigurationException {
		ConferenceImpl.queryConferencesStatusExResult = 1234;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		List<String> confIds = new ArrayList<String>();
		confIds.add("8953");
		TPSDKResponseEx<List<ConferenceStatusEx>> responseEx = conferenceServiceEx
				.queryConferencesStatusEx(confIds);
		Assert.assertEquals(1234, responseEx.getResultCode());
	}
	
	@Test
	public void queryConferencesStatusExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		List<String> confIds = new ArrayList<String>();
		confIds.add("8953");
		TPSDKResponseEx<List<ConferenceStatusEx>> responseEx = conferenceServiceEx
				.queryConferencesStatusEx(confIds);
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}

	// //////////////////////////////////////////////////////////////////////////////02_09
	// 查询指定会议中的会场状态（queryConfSitesStatusEx）////////////////////////////////////////////////////////////////
	@Test
	public void queryConfSitesStatusExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		// Date beginTime = new Date();
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		Date beginTime1 = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime1);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010010");
		TPSDKResponseEx<List<SiteStatusEx>> responseEx = conferenceServiceEx
				.queryConfSitesStatusEx(response1.getResult().getConfId(),
						siteList);
		Assert.assertEquals(0, responseEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	// 002 会场在会议中，查询会场状态
	// OK
	@Test
	public void queryConfSitesStatusExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		ConferenceImpl.queryConfSitesStatusExResult = 123;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		// Date beginTime = new Date();
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		siteInfo1.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		siteInfo2.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		siteInfo3.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<List<SiteStatusEx>> responseEx = conferenceServiceEx
				.queryConfSitesStatusEx(response1.getResult().getConfId(),
						siteList);
		Assert.assertEquals(123, responseEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}
	
	@Test
	public void queryConfSitesStatusExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<List<SiteStatusEx>> responseEx = conferenceServiceEx
				.queryConfSitesStatusEx("1477",
						siteList);
		Assert.assertEquals(2130000020, responseEx.getResultCode());
	}

	// //////////////////////////////////////////////////////////////////////02_10
	// 指定会场忙闲状态同步（synchSiteStatusEx）///////////////////////////////////////////////////////////////////
	@Test
	public void synchSiteStatusExTest001()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		Date synBeginTime = new Date(new Date().getTime());
		Duration synDuration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseSynchSiteStatusEx = conferenceServiceEx
				.synchSiteStatusEx(siteList, synBeginTime, synDuration);
		Assert.assertEquals(2130000020, responseSynchSiteStatusEx.getResultCode());

	}
	
	@Test
	public void synchSiteStatusExTest002()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		Date synBeginTime = new Date(new Date().getTime());
		Duration synDuration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseSynchSiteStatusEx = conferenceServiceEx
				.synchSiteStatusEx(siteList, synBeginTime, synDuration);
		Assert.assertEquals(0, responseSynchSiteStatusEx.getResultCode());
		Assert.assertTrue(null != responseSynchSiteStatusEx.getResult());

	}

	// 002 查询一个会场，查询时间段内忙闲状态改变
	//
	@Test
	public void synchSiteStatusExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		Date synBeginTime = new Date(new Date().getTime());
		Duration synDuration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		List<String> siteList = new ArrayList<String>();
		siteList.add("01010086");
		TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> responseSynchSiteStatusEx = conferenceServiceEx
				.synchSiteStatusEx(siteList, synBeginTime, synDuration);
		Assert.assertEquals(2130000020, responseSynchSiteStatusEx.getResultCode());
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		siteInfo1.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		siteInfo2.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(2130000020, response1.getResultCode());
		responseSynchSiteStatusEx = conferenceServiceEx.synchSiteStatusEx(
				siteList, synBeginTime, synDuration);
		Assert.assertEquals(2130000020, responseSynchSiteStatusEx.getResultCode());
	}

	// ////////////////////////////////////////////////////////////02_11
	// 向会议添加会场（addSiteToConfEx）/////////////////////////////////////////////////////////////////////////////
	@Test
	public void addSiteToConfExTest001() throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(response1.getResult().getConfId(), siteInfo2,
						beginTime);
		Assert.assertEquals(0, responseAddSiteToConfEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}
	@Test
	public void addSiteToConfExTest002() throws DatatypeConfigurationException {
		ConferenceImpl.addSiteToConfExResult = 123;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(response1.getResult().getConfId(), siteInfo2,
						null);
		Assert.assertEquals(123, responseAddSiteToConfEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}
	
	@Test
	public void addSiteToConfExTest003() throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(null, null,
						null);
		Assert.assertEquals(2130000020, responseAddSiteToConfEx.getResultCode());
	}

	@Test
	public void addSiteToConfExTest004() throws DatatypeConfigurationException {
		ConferenceImpl.addSiteToConfExResult = 123;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(response1.getResult().getConfId(), siteInfo2,
						null);
		Assert.assertEquals(123, responseAddSiteToConfEx.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	// /////////////////////////////////////////////////////////////////////02_12
	// 删除会议中的会场（delSiteFromConfEx）/////////////////////////////////////////////////////////////////////
	@Test
	public void delSiteFromConfExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("延长时间的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010086");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delSiteFromConfEx(
						response1.getResult().getConfId(), "01010001",
						beginTime).intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	// OK
	@Test
	public void delSiteFromConfExTest002()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceImpl.delSiteFromConfExResult = 123;
		Assert.assertEquals(123,
				conferenceServiceEx.delSiteFromConfEx("1477", "01010001", null)
						.intValue());
	}
	
	@Test
	public void delSiteFromConfExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		Assert.assertEquals(2130000020,
				conferenceServiceEx.delSiteFromConfEx("1477", "01010001", null)
						.intValue());
	}

	// ////////////////////////////////////////////////////////////////////02_13
	// 呼叫一个或多个会场（connectSitesEx）///////////////////////////////////////////////////////////////////////
	@Test
	public void connectSitesExTest001() throws DatatypeConfigurationException,
			InterruptedException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("呼叫会场的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(response1.getResult().getConfId(), siteInfo2,
						beginTime);
		Assert.assertEquals(0, responseAddSiteToConfEx.getResultCode());
		List<String> siteUriList = new ArrayList<String>();
		siteUriList.add("01010010");
		Assert.assertEquals(
				0,
				conferenceServiceEx.connectSitesEx(
						response1.getResult().getConfId(), siteUriList)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	@Test
	public void connectSitesExTest002() throws DatatypeConfigurationException,
			InterruptedException {
		ConferenceImpl.connectSitesExResult = 123;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("呼叫会场的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().clear();
		scheduleConf.getSites().add(siteInfo2);
		scheduleConf.getSites().add(siteInfo3);
		TPSDKResponseEx<ConferenceInfoEx> response2 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response2.getResultCode());
		TPSDKResponseEx<List<SiteAccessInfoEx>> responseAddSiteToConfEx = conferenceServiceEx
				.addSiteToConfEx(response1.getResult().getConfId(), siteInfo2,
						beginTime);
		Assert.assertEquals(0, responseAddSiteToConfEx.getResultCode());
		List<String> siteUriList = new ArrayList<String>();
		siteUriList.add("01010010");
		Assert.assertEquals(
				123,
				conferenceServiceEx.connectSitesEx(
						response1.getResult().getConfId(), siteUriList)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response2.getResult().getConfId(), beginTime)
						.intValue());
	}
	
	@Test
	public void connectSitesExTest003() throws DatatypeConfigurationException,
			InterruptedException {
		ConferenceImpl.exceptionCode = 2130000020;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		
		Integer responseConnectSitesExEx = conferenceServiceEx
				.connectSitesEx(null,null);
		Assert.assertEquals(2130000020, responseConnectSitesExEx.intValue());
		
	}

	// /////////////////////////////////////////////////////////02_14
	// 断开指定会议的一个或多个会场（disconnectSitesEx）//////////////////////////////////////////////////////////////////////////////////
	@Test
	public void disconnectSitesExTest001() throws InterruptedException,
			DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("断开会场的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		List<String> siteUriList = new ArrayList<String>();
		siteUriList.add("01010086");
		Assert.assertEquals(
				0,
				conferenceServiceEx.disconnectSitesEx(
						response1.getResult().getConfId(), siteUriList)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	// 002 断掉一个不在该会议中的会场
	// OK
	@Test
	public void disconnectSitesExTest002() throws InterruptedException,
			DatatypeConfigurationException {
		ConferenceImpl.disconnectSitesExResult = 0x50505004;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("断开会场的会议");
		Date beginTime = new Date(new Date().getTime());
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		List<String> siteUriList = new ArrayList<String>();
		siteUriList.add("01010086");
		Assert.assertEquals(
				0x50505004,
				conferenceServiceEx.disconnectSitesEx(
						response1.getResult().getConfId(), siteUriList)
						.intValue());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}
	@Test
	public void disconnectSitesExTest003() throws DatatypeConfigurationException,
			InterruptedException {
		ConferenceImpl.exceptionCode = 2130000020;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		
		Integer responseDisconnectSitesExEx = conferenceServiceEx
				.disconnectSitesEx(null,null);
		Assert.assertEquals(2130000020, responseDisconnectSitesExEx.intValue());
		
	}
	
	// //////////////////////////////////////////////////////////////02_15
	// 删除预约会议&结束会议（delScheduledConfEx）////////////////////////////////////////////////////////////////////////////
	@Test
	public void delScheduledConfExTest001()
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("断开会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010086");
		siteInfo3.setType(4);
		siteInfo3.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		Assert.assertEquals(
				0,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), beginTime)
						.intValue());
	}

	// 002 删除预约但未召开的会议（beginTime为空）
	// OK
	@Test
	public void delScheduledConfExTest002()
			throws DatatypeConfigurationException {
		ConferenceImpl.delScheduledConfExResult = 123;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("断开会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 60 * 24);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010086");
		siteInfo3.setType(4);
		siteInfo3.setName("西门吹雪");
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response1 = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		Assert.assertEquals(0, response1.getResultCode());
		Assert.assertEquals(
				123,
				conferenceServiceEx.delScheduledConfEx(
						response1.getResult().getConfId(), null).intValue());
	}
	
	@Test
	public void delScheduledConfExTest003()
			throws DatatypeConfigurationException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		
		Assert.assertEquals(
				2130000020,
				conferenceServiceEx.delScheduledConfEx(
						null, null).intValue());
	}

	/***********************************************************************/
	// 预约普通会议，三个会场
	public String scheduleConferenceExOK(Integer leadTimeMin)
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("三个会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 30
				+ leadTimeMin.intValue() * 60 * 1000);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		siteInfo1.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		siteInfo2.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		siteInfo3.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		TPSDKResponseEx<ConferenceInfoEx> response = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		if (0 == response.getResultCode()) {
			return response.getResult().getConfId();
		}
		return null;
	}

	// 预约多画面会议，三个会场
	public String scheduleMultiConferenceExOK(Integer leadTimeMin)
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		ConferenceInfoEx scheduleConf = new ConferenceInfoEx();
		scheduleConf.setName("三个会场的会议");
		Date beginTime = new Date(new Date().getTime() + 1000 * 30
				+ leadTimeMin.intValue() * 60 * 1000);
		scheduleConf.setBeginTime(beginTime);
		Duration duration = DatatypeFactory.newInstance().newDuration(
				1000 * 60 * 60);
		scheduleConf.setDuration(duration);
		SiteInfoEx siteInfo1 = new SiteInfoEx();
		siteInfo1.setUri("01010086");
		siteInfo1.setType(4);
		siteInfo1.setName("西门吹雪");
		siteInfo1.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo1);
		SiteInfoEx siteInfo2 = new SiteInfoEx();
		siteInfo2.setUri("01010010");
		siteInfo2.setType(4);
		siteInfo2.setName("东方不败");
		siteInfo2.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo2);
		SiteInfoEx siteInfo3 = new SiteInfoEx();
		siteInfo3.setUri("01010001");
		siteInfo3.setType(4);
		siteInfo3.setName("北野风");
		siteInfo3.setDialingMode(0);
		scheduleConf.getSites().add(siteInfo3);
		scheduleConf.setRate("1920K");
		scheduleConf.setCpResouce(5);
		TPSDKResponseEx<ConferenceInfoEx> response = conferenceServiceEx
				.scheduleConfEx(scheduleConf);
		if (0 == response.getResultCode()) {
			return response.getResult().getConfId();
		}
		return null;
	}

	// 删除会议
	public void delScheduledConfExOK(String confId)
			throws DatatypeConfigurationException {
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		conferenceServiceEx.delScheduledConfEx(confId, null);
	}

	// //////////////////////////////////////////////////setVideoSourceEx(设置指定会场的视频源)/////////////////////////////////////////////////////////////////

	@Test
	public void setVideoSourceExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010010";
		String videoSourceUri = "01010086";
		Integer isLock = 0;

		Integer response = conferenceServiceEx.setVideoSourceEx(confId,
				siteUri, videoSourceUri, isLock);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	// 002会场不在会议中，设置视频源失败
	// OK
	@Test
	public void setVideoSourceExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.setVideoSourceExResult = 1347420168;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010002";
		String videoSourceUri = "01010086";
		Integer isLock = 0;

		Integer response = conferenceServiceEx.setVideoSourceEx(confId,
				siteUri, videoSourceUri, isLock);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(1347420168, response.intValue());
	}
	
	@Test
	public void setVideoSourceExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010002";
		String videoSourceUri = "01010086";
		Integer isLock = 0;

		Integer response = conferenceServiceEx.setVideoSourceEx(confId,
				siteUri, videoSourceUri, isLock);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// 001参数正确，开启声控切换成功
	// OK
	@Test
	public void setAudioSwitchExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		Integer swtichGate = 66;
		Integer isSwitch = 1;

		Integer response = conferenceServiceEx.setAudioSwitchEx(confId,
				swtichGate, isSwitch);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	// 002switchGate为-1，开启声控切换失败
	// OK
	@Test
	public void setAudioSwitchExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.setAudioSwitchExResult = 570789905;

		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		Integer swtichGate = 66;
		Integer isSwitch = -1;

		Integer response = conferenceServiceEx.setAudioSwitchEx(confId,
				swtichGate, isSwitch);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(570789905, response.intValue());
	}
	
	@Test
	public void setAudioSwitchExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;

		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		Integer swtichGate = 66;
		Integer isSwitch = -1;

		Integer response = conferenceServiceEx.setAudioSwitchEx(confId,
				swtichGate, isSwitch);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// 001参数正确，开启会场广播成功
	// OK
	@Test
	public void setBroadcastSiteExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010010";
		Integer isBroadcast = 0;

		Integer response = conferenceServiceEx.setBroadcastSiteEx(confId,
				siteUri, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	// 002参数正确，关闭会场广播成功
	// NA(SMC版本暂不支持)
	@Test
	public void setBroadcastSiteExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.setBroadcastSiteExResult = 570462212;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010010";
		Integer isBroadcast = 1;

		Integer response = conferenceServiceEx.setBroadcastSiteEx(confId,
				siteUri, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(570462212, response.intValue());
	}
	
	@Test
	public void setBroadcastSiteExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;

		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String siteUri = "01010010";
		Integer isBroadcast = 1;

		Integer response = conferenceServiceEx.setBroadcastSiteEx(confId,
				siteUri, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// 001会议支持多画面，开始广播多画面成功
	// OK
	@Test
	public void setBroadcastContinuousPresenceExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		String confId = confIdTemp;
		Integer isBroadcast = 0;

		Integer response = conferenceServiceEx
				.setBroadcastContinuousPresenceEx(confId, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	@Test
	public void setBroadcastContinuousPresenceExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceImpl.setBroadcastContinuousPresenceExResult = 570462212;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		Integer isBroadcast = 1;

		Integer response = conferenceServiceEx
				.setBroadcastContinuousPresenceEx(confId, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(570462212, response.intValue());
	}
	
	@Test
	public void setBroadcastContinuousPresenceExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		Integer isBroadcast = 1;

		Integer response = conferenceServiceEx
				.setBroadcastContinuousPresenceEx(confId, isBroadcast);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	@Test
	public void setSitesMuteExTest001() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isMute = 0;

		Integer response = conferenceServiceEx.setSitesMuteEx(confId, siteUris,
				isMute);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	@Test
	public void setSitesMuteExTest002() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.setSitesMuteExResult = -1;
		// 闭音
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isMute = 0;
		// 取消闭音
		isMute = 1;
		Integer response = conferenceServiceEx.setSitesMuteEx(confId, siteUris,
				isMute);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(-1, response.intValue());
	}
	
	@Test
	public void setSitesMuteExTest003() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		// 闭音
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isMute = 0;
		// 取消闭音
		isMute = 1;
		Integer response = conferenceServiceEx.setSitesMuteEx(confId, siteUris,
				isMute);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// 001对会议中其中一个会场静音成功
	// OK
	@Test
	public void setSitesQuietExTest001() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isQuiet = 0;

		Integer response = conferenceServiceEx.setSitesQuietEx(confId,
				siteUris, isQuiet);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	@Test
	public void setSitesQuietExTest003() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);

		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		// 静音
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isQuiet = 0;
		// 取消静音
		isQuiet = 1;
		Integer response = conferenceServiceEx.setSitesQuietEx(confId,
				siteUris, isQuiet);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}
	
	@Test
	public void setSitesQuietExTest002() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);

		ConferenceImpl.setSitesQuietExResult = -1;
		// 静音
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);
		String confId = confIdTemp;
		List<String> siteUris = new ArrayList<String>();
		siteUris.add("01010010");
		Integer isQuiet = 0;
		// 取消静音
		isQuiet = 1;
		Integer response = conferenceServiceEx.setSitesQuietEx(confId,
				siteUris, isQuiet);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(-1, response.intValue());
	}

	@Test
	public void setContinuousPresenceExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String target = "";
		Integer presenceMode = 3;
		List<String> subPics = new ArrayList<String>();
		subPics.add("1");

		Integer response = conferenceServiceEx.setContinuousPresenceEx(confId,
				target, presenceMode, subPics);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}

	@Test
	public void setContinuousPresenceExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceImpl.setContinuousPresenceExResult = -1;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String target = "0";
		Integer presenceMode = 3;
		List<String> subPics = new ArrayList<String>();
		subPics.add("1");

		Integer response = conferenceServiceEx.setContinuousPresenceEx(confId,
				target, presenceMode, subPics);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(-1, response.intValue());
	}
	
	@Test
	public void setContinuousPresenceExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleMultiConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String confId = confIdTemp;
		String target = "0";
		Integer presenceMode = 3;
		List<String> subPics = new ArrayList<String>();
		subPics.add("1");

		Integer response = conferenceServiceEx.setContinuousPresenceEx(confId,
				target, presenceMode, subPics);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// OK
	@Test
	public void releaseChairExTest001() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";
		// 释放主席
		Integer response = conferenceServiceEx.releaseChairEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.intValue());
	}
	
	@Test
	public void releaseChairExTest002() throws DatatypeConfigurationException,
			InterruptedException {
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";
		// 释放主席
		Integer response = conferenceServiceEx.releaseChairEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.intValue());
	}

	// NOK
	@Test
	public void releaseChairExTest003() throws DatatypeConfigurationException,
			InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.releaseChairExResult = -1;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";

		Integer response = conferenceServiceEx.releaseChairEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(-1, response.intValue());
	}

	// OK
	@Test
	public void queryConfCtrlPwdExTest001()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";

		TPSDKResponseEx<Integer> response = conferenceServiceEx
				.queryConfCtrlPwdEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(0, response.getResultCode());
	}

	// OK
	@Test
	public void queryConfCtrlPwdExTest002()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.queryConfCtrlPwdExResult = -1;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";

		TPSDKResponseEx<Integer> response = conferenceServiceEx
				.queryConfCtrlPwdEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(-1, response.getResultCode());
	}
	@Test
	public void queryConfCtrlPwdExTest003()
			throws DatatypeConfigurationException, InterruptedException {
		// 预订会议
		String confIdTemp = scheduleConferenceExOK(0);
		ConferenceImpl.exceptionCode = 1351614476;
		ConferenceImpl.throwException = true;
		ConferenceServiceEx conferenceServiceEx = (ConferenceServiceEx) ServiceFactoryEx
				.getService(ConferenceServiceEx.class);

		String siteURI = "01010010";

		TPSDKResponseEx<Integer> response = conferenceServiceEx
				.queryConfCtrlPwdEx(siteURI);
		// 删除会议
		delScheduledConfExOK(confIdTemp);
		Assert.assertEquals(2130000020, response.getResultCode());
	}

}
