package com.huawei.esdk.tp.professional.local.authentication;

import junit.framework.Assert;
import mockit.Mock;
import mockit.MockUp;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huawei.esdk.tp.professional.local.ServiceFactoryEx;
import com.huawei.esdk.tp.professional.local.impl.utils.ClientProvider;

@SuppressWarnings("unused")
public class AuthorizeServiceExImplTest {
	static MockUp<ClientProvider> clientMock = null;
	
	@BeforeClass
	public static void before() {
		clientMock = new MockUp<ClientProvider>() {
			@SuppressWarnings("rawtypes")
			@Mock
			 public synchronized Object getClient(Class clz) {
				return new TPCommonImpl();
			}
		};
	}
	
	@After
	public void after(){
		TPCommonImpl.throwException = false;
		TPCommonImpl.loginResult = 0;
		TPCommonImpl.authenticateResult = 0;
		TPCommonImpl.logoutResult = 0;
		TPCommonImpl.keepAliveResult = 0;
	}

	// 用户名密码正确、登录成功
	// OK
	@Test
	public void testLogin001() {

		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0, authorizeServiceEx.login("user1", "AAAaaa111")
				.intValue());
	}
	
	@Test
	public void testLogin() {
		TPCommonImpl.throwException = true;
		TPCommonImpl.exceptionCode = 2130000020;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(2130000020, authorizeServiceEx.login("user1", "AAAaaa111")
				.intValue());
	}

	// 密码错误，登录失败
	// OK
	@Test
	public void testLogin002() {
		
		TPCommonImpl.authenticateResult = 0x50200032;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0x50200032,
				authorizeServiceEx.login("user1", "AAAaaa11").intValue());
	}

	// 密码为空，登录失败
	// NOK
	@Test
	public void testLogin003() {
		TPCommonImpl.authenticateResult = 0x50200032;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0x50200032, authorizeServiceEx.login("user1", null)
				.intValue());
	}

	// 用户名不存在，登录失败
	// OK
	@Test
	public void testLogin004() {
		TPCommonImpl.authenticateResult = 0x50200032;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0x50200032,
				authorizeServiceEx.login("user", "AAAaaa111").intValue());
	}

	// 用户名为空，登录失败
	// OK
	@Test
	public void testLogin005() {
		TPCommonImpl.authenticateResult = 0x50200032;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0x50200032,
				authorizeServiceEx.login(null, "AAAaaa111").intValue());
	}

	// 登录后再次登录，登录成功
	// OK
	@Test
	public void testLogin006() {
		TPCommonImpl.authenticateResult = 0;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0, authorizeServiceEx.login("user1", "AAAaaa111")
				.intValue());
		Assert.assertEquals(0, authorizeServiceEx.login("user1", "AAAaaa111")
				.intValue());
	}

	// 用户已登录，注销成功
	// OK
	@Test
	public void testLogout001() {
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0, authorizeServiceEx.logout().intValue());
	}

	// 用户未登录，注销失败
	//
	@Test
	public void testLogout002() {
		TPCommonImpl.exceptionCode = 571052032;
		TPCommonImpl.throwException = true;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(2130000020, authorizeServiceEx.logout().intValue());
	}
	
	

	// 用户已登录，保持会话成功
	// OK
	@Test
	public void testKeepAlive001() {
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(0, authorizeServiceEx.keepAlive().intValue());
	}

	// 用户未登录，保持会话失败
	//
	@Test
	public void testKeepAlive002() {
		TPCommonImpl.exceptionCode = 571052032;
		TPCommonImpl.throwException = true;
		AuthorizeServiceEx authorizeServiceEx = (AuthorizeServiceEx) ServiceFactoryEx
				.getService(AuthorizeServiceEx.class);
		Assert.assertEquals(2130000020, authorizeServiceEx.keepAlive()
				.intValue());
	}

}
