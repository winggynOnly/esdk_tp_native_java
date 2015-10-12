package com.huawei.esdk.csdemo.listener;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import com.huawei.esdk.csdemo.action.ConfManagerAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.mapping.SiteStatusMapping;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.AddSiteToConfFrame;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class AddSiteToConfListener
{

    private AddSiteToConfFrame addSiteToConfFrame;
    
    private ConfManagerAction confAction;

    public void register(AddSiteToConfFrame addSiteToConfFrame)
    {
        this.addSiteToConfFrame = addSiteToConfFrame;
        this.confAction = new ConfManagerAction(DemoApp.mainFrame.getPan1());
        addListenerToOkButton();
        addListnerToCloseButton();
    }

    private void addListenerToOkButton()
    {
        addSiteToConfFrame.getOkBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Vector<Vector<String>> selectedSites = addSiteToConfFrame
                        .getSiteControlSiteListPan().getSelectedData();
                int row = DemoApp.mainFrame.getPan1().getConfListPanel().getConfList().getSelectionModel().getMaxSelectionIndex();
                String confId = (String) DemoApp.mainFrame.getPan1().getConfListPanel().getConfList().getValueAt(row, 0);
                String beginTime = DemoApp.mainFrame.getPan1().getConfInfoPanel().getConfBeginTimeText().getText();
                
                if (!DemoApp.mainFrame.getPan1().getConfInfoPanel().getReTime().isEnabled())
                {
                    beginTime = "";
                }
                
                TPSDKResponseEx<List<SiteAccessInfoEx>> result = confAction.addSiteToConfEx(confId,selectedSites.get(0).get(0),beginTime);
                if (0 != result.getResultCode())
                {
                    DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(false, LabelText.add_site_failure[DataBase.getInstance().getLanguageFlag()] + result.getResultCode());
                    return;
                }
                DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(true, LabelText.add_site_success[DataBase.getInstance().getLanguageFlag()]);
//                String uri = selectedSites.get(0).get(0);
//                SiteInfoEx site = DataBase.getInstance().querySiteByUri(uri);
//                selectedSites.get(0).add("");
//                selectedSites.get(0).add("");
//                selectedSites.get(0).add("");
//                selectedSites.get(0).add(null);
//                selectedSites.get(0).add("");
//                DemoApp.mainFrame.getPan1().getConfInfoPanel().addRefreshSiteTable(selectedSites);
//                
//                TPSDKResponseEx<List<SiteStatusEx>> statusResult = confAction
//                        .queryConferenceSiteStatus(confId, null);
//
//                String[][] siteData = new String[statusResult.getResult().size()][8];
//
//                int i = 0;
//                for (SiteStatusEx info : statusResult.getResult())
//                {
//                    // if (null == siteMap.get(info.getUri()))
//                    // {
//                    siteData[i][0] = info.getUri();
//                    siteData[i][1] = info.getName();
//                    siteData[i][2] = info.getType() + "";
//                    siteData[i][3] = SiteStatusMapping.int2String(info.getStatus());
//                    siteData[i][4] = "";
//                    siteData[i][5] = "";
//                    siteData[i][6] = "";
//                    siteData[i][7] = "";
//                    // siteMap.put(info.getUri(), info);
//                    i = i + 1;
//                    // }
//                }
//                DemoApp.mainFrame.getPan1().getConfInfoPanel().refreshSiteTable(siteData);
                
                refreshSiteStatus(confId);

                addSiteToConfFrame.setVisible(false);
            }
        });
    }
    
    protected void refreshSiteStatus(String confid)
    {
        ConfManagerPanel confManagerPanel = DemoApp.mainFrame.getPan1();
        if(confManagerPanel.getConfInfoPanel().getReTime().isEnabled())
        {
            int selectedIndex = confManagerPanel
            .getConfInfoPanel().getReTime().getSelectedIndex();

            confid = String.valueOf(Integer.parseInt(confid)+ selectedIndex + 1);
        }
        
        TPSDKResponseEx<List<SiteStatusEx>> statusResult = confAction
                .queryConferenceSiteStatus(confid, null);
        if (0 != statusResult.getResultCode())
        {
            confManagerPanel.getBottom_show_result_panel().showResultMsg(
                    false,
                    LabelText.refresh_site_failure[DataBase.getInstance()
                            .getLanguageFlag()]);
            return;
        }

        String[][] siteData = new String[statusResult.getResult().size()][8];

        int i = 0;
        for (SiteStatusEx info : statusResult.getResult())
        {
            // if (null == siteMap.get(info.getUri()))
            // {
            siteData[i][0] = info.getUri();
            siteData[i][1] = info.getName();
            siteData[i][2] = String.valueOf(info.getType());
            siteData[i][3] = SiteStatusMapping.int2String(info.getStatus());
            siteData[i][4] = "";
            siteData[i][5] = "";
            siteData[i][6] = "";
            siteData[i][7] = "";
            // siteMap.put(info.getUri(), info);
            i = i + 1;
            // }
        }
        confManagerPanel.getConfInfoPanel().refreshSiteTable(siteData);
        confManagerPanel.getBottom_show_result_panel().showResultMsg(
                true,
                LabelText.refresh_site_success[DataBase.getInstance()
                        .getLanguageFlag()]);
    }

    private void addListnerToCloseButton()
    {
        addSiteToConfFrame.getCloseBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                addSiteToConfFrame.setVisible(false);
            }
        });
    }

}
