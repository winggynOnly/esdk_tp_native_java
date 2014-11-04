package com.huawei.esdk.csdemo.common;

import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.ProgressFrame;
import com.huawei.esdk.tp.professional.local.ServiceFactoryEx;
import com.huawei.esdk.tp.professional.local.authentication.AuthorizeServiceEx;
import com.huawei.esdk.tp.professional.local.conference.ConferenceServiceEx;

import com.huawei.esdk.tp.professional.local.site.SiteServiceEx;

public class ServiceFactory {
	private static ServiceFactory instance;
	private AuthorizeServiceEx authorizeServiceEx = null;
	private SiteServiceEx siteServiceEx = null;
	private ConferenceServiceEx confServiceEx = null;
	private ServiceFactory(){
	    DemoApp.loginFrame.setVisible(false);
	    DemoApp.progressFrame = new ProgressFrame();
	    DemoApp.progressFrame.setVisible(true);
	    DemoApp.progressFrame.showProgressMessage("Creating ServiceFactory {http://smc.huawei.com/}");
		authorizeServiceEx = ServiceFactoryEx
		.getService(AuthorizeServiceEx.class);
		DemoApp.progressFrame.showProgressMessage("Creating Service {http://smc.huawei.com/} TPCommonService completed");
		siteServiceEx = ServiceFactoryEx
		.getService(SiteServiceEx.class);
		DemoApp.progressFrame.showProgressMessage("Creating Service {http://smc.huawei.com/} TPProfessionalSiteMgrService completed");
		confServiceEx = ServiceFactoryEx
		.getService(ConferenceServiceEx.class);
		DemoApp.progressFrame.showProgressMessage(" Creating Service {http://smc.huawei.com/} TPProfessionalConfCtrService completed");
		DemoApp.progressFrame.showProgressMessage(" Creating Service {http://smc.huawei.com/} TPProfessionalConfMgrService completed!");
	      DemoApp.progressFrame.setVisible(false);
	      DemoApp.loginFrame.setVisible(true);
	}
	
	public static ServiceFactory getInstance(){
		if(null == instance){
			instance = new ServiceFactory();
		}
		return instance;
	}

	public AuthorizeServiceEx getAuthorizeServiceEx() {
		return authorizeServiceEx;
	}

	public void setAuthorizeServiceEx(AuthorizeServiceEx authorizeServiceEx) {
		this.authorizeServiceEx = authorizeServiceEx;
	}

	public SiteServiceEx getSiteServiceEx() {
		return siteServiceEx;
	}

	public void setSiteServiceEx(SiteServiceEx siteServiceEx) {
		this.siteServiceEx = siteServiceEx;
	}

	public ConferenceServiceEx getConfServiceEx() {
		return confServiceEx;
	}

	public void setConfServiceEx(ConferenceServiceEx confServiceEx) {
		this.confServiceEx = confServiceEx;
	}

}
