package com.huawei.esdk.csdemo.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.mapping.SiteTypeMapping;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.ConferenceService;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.csdemo.view.panel.SiteControlPanel;
import com.huawei.esdk.csdemo.view.panel.SiteControlSiteListPan;
import com.huawei.esdk.tp.professional.local.bean.FreeBusyStateEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;


public class InitialDefaultDataAction
{
    private ConferenceService conferenceService = new ConferenceService();
    
    public void initDefaultData(){
        
        
        initSiteTabel();
        initScheduledConfTabel();

        
        DemoApp.progressFrame.setVisible(false);
        DemoApp.mainFrame.setVisible(true);
    }
    
    public void initSiteTabel(){
        
        DemoApp.progressFrame.showProgressMessage("starting initial site data。。。");
        TPSDKResponseEx<List<SiteInfoEx>> sitesResult = conferenceService.querySitesEx();
        if(0 != sitesResult.getResultCode()){
            System.out.println("InitSiteTabel Fail");
            return;
        }
        
        List<SiteInfoEx> siteList = sitesResult.getResult();

        String[] tableTitle = new String[4];
        
        String[][] tableData = new String[siteList.size()][4];

        int columnCount = getSiteControlSiteListPan().getTableMode().getColumnCount();
        for(int i = 0;i < columnCount;i++){
            tableTitle[i] = getSiteControlSiteListPan().getTableMode().getColumnName(i);
        }

        
        List<String> uris = new ArrayList<String>();
        int i = 0;
        for (SiteInfoEx site : siteList)
        {
            DataBase.getInstance().saveSite(site);
            tableData[i][0] = site.getUri();
            tableData[i][1] = site.getName();
            tableData[i][2] = SiteTypeMapping.int2String(site.getType());
            uris.add(site.getUri());
            DataBase.getInstance().getAllSiteMap().put(site.getUri(), site);
            i = i + 1;
        }
        
        Duration duration = null;
        try
        {
            duration = DatatypeFactory.newInstance().newDuration("PT30M");
        }
        catch (DatatypeConfigurationException e)
        {
            e.printStackTrace();
        }
        
        TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> siteStatusResult = conferenceService.querySiteStatusEx(uris, new Date(), duration);
        
        if(0 != siteStatusResult.getResultCode()){
            System.out.println("InitSiteTabel Fail");
            return;
        }
        Map<String, List<FreeBusyStateEx>> response = siteStatusResult.getResult();
        int j = 0;
        for (String uri : uris)
        {
            Integer status = null == response.get(uri) ? 2 :response.get(uri).get(0).getState();
            DataBase.getInstance().querySiteByUri(uri).setStatus(status);
            tableData[j][3] = renderStatus(status);
            j = j + 1;
        }

        getSiteControlSiteListPan().getTableMode().setDataVector(tableData, tableTitle);
        
        DemoApp.progressFrame.showProgressMessage("initial site data completed。。。");

    }
    
    public void initScheduledConfTabel(){
        DemoApp.progressFrame.showProgressMessage("starting conference data 。。。");

//        new LocalDataKeeper().loadDataFromLocal();
            
        getConfManagerPanel().getConfListPanel().refreshTable();
        DemoApp.progressFrame.showProgressMessage("initial conference data completed。。。");

    }
    
    
    public String renderStatus(Integer status)
    {
        if (0 == status)
        {
            return LabelText.siteCtol_sitelist_status_free[DataBase.getInstance().getLanguageFlag()];
        }
        else if (1 == status)
        {
            return LabelText.siteCtol_sitelist_status_busy[DataBase.getInstance().getLanguageFlag()];
        }
        else
        {
            return LabelText.siteCtol_sitelist__status_not_exist[DataBase.getInstance().getLanguageFlag()];
        }
    }
    
    private SiteControlPanel getSiteControlPanel(){
       return DemoApp.mainFrame.getPan3();
    }
    
    private ConfManagerPanel getConfManagerPanel(){
        return DemoApp.mainFrame.getPan1();
    }
    private SiteControlSiteListPan getSiteControlSiteListPan(){
        return getSiteControlPanel().getSiteControlSiteListPan();
    }
}
