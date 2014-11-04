package com.huawei.esdk.csdemo.action;

import java.util.Date;
import java.util.List;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.AuthorizeService;
import com.huawei.esdk.csdemo.service.ConferenceService;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class ConfManagerAction
{
    private AuthorizeService authorizeService = new AuthorizeService();

    private ConferenceService confService = new ConferenceService();

    private ConfManagerPanel confManagerPanel;

    public ConfManagerAction(ConfManagerPanel confManagerPanel)
    {
        this.confManagerPanel = confManagerPanel;
    }

    public void logout()
    {
        authorizeService.logout();
    }

    public void getConfDataFromExcel()
    {
        confService.selectConfDataFromExcel();
    }

    public TPSDKResponseEx<List<SiteAccessInfoEx>> addSiteToConfEx(String confId,
            String uri, String beginTime)
    {
        SiteInfoEx siteInfo = DataBase.getInstance().querySiteByUri(uri);
        Date time = "".equals(beginTime) ? null : DateUtils
                .yyyyMMddHHmmss2date(beginTime);
        TPSDKResponseEx<List<SiteAccessInfoEx>> result = confService
                .addSiteToConfEx(confId, siteInfo, time);
        if (0 == result.getResultCode())
        {
            RecurrenceConfInfoEx confInfo = DataBase.getInstance()
                    .queryConferenceById(confId);
            confInfo.getSites().add(siteInfo);
            // confService.addSiteIntoConfExcel(confId, uri);
            if (confInfo.getSiteAccessInfos().size() > 0)
            {
                confInfo.getSiteAccessInfos().clear();
                confInfo.getSiteAccessInfos().addAll(result.getResult());
            }

        }
        return result;
    }

    public void connectSitesEx(String confid, List<String> sites)
    {
        Integer result = confService.connectSitesEx(confid, sites);
        if (0 == result)
        {
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            true,
                            LabelText.connect_site_success[DataBase
                                    .getInstance()
                                    .getLanguageFlag()]);
        }
        else
        {
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            false,
                            LabelText.connect_site_failure[DataBase
                                    .getInstance()
                                    .getLanguageFlag()] + result);
        }
    }

    public void delSiteFromConfEx(String confid, String uri, String time)
    {
        Integer result = confService.delSiteFromConfEx(confid, uri,
            "".equals(time) ? null : DateUtils.yyyyMMddHHmmss2date(time));
        
        int[] rows = confManagerPanel.getConfInfoPanel()
            .getJtable().getSelectedRows();
        
        if (0 == result)
        {
            confManagerPanel.getConfInfoPanel()
                    .removeRefreshTable(rows[0]);

            RecurrenceConfInfoEx info = DataBase.getInstance()
                    .queryConferenceById(confid);
            // 周期性会议
            if (info.getSiteAccessInfos().size() > 0)
            {
                int size = info.getSiteAccessInfos().size();
                // 删除了所有周期性会议的会场
                if ("".equals(time))
                {
                    for (int i = size - 1; i >= 0; i--)
                    {
                        SiteAccessInfoEx site = info
                                .getSiteAccessInfos().get(i);
                        if (site.getUri().equals(uri))
                        {
                            info.getSiteAccessInfos().remove(i);
                        }
                    }
                }
                // 删除了指定周期性会议的会场
                else
                {
                    for (int i = size - 1; i >= 0; i--)
                    {
                        SiteAccessInfoEx site = info
                                .getSiteAccessInfos().get(i);
                        if (site.getUri().equals(uri)
                                && DateUtils
                                        .date2yyyyMMddHHmmss(
                                                site.getBeginTime())
                                        .equals(time))
                        {
                            info.getSiteAccessInfos().remove(i);
                        }
                    }
                }
            }
            // 普通会议
            else
            {
                int size = info.getSites().size() - 1;
                for (int i = 0; i < size; i++)
                {
                    SiteInfoEx site = info.getSites().get(
                            size - i);
                    if (uri.equals(site.getUri()))
                    {
                        info.getSites().remove(size - i);
                    }
                }
                // DataBase.getInstance().removeConference(confid);
                // DataBase.getInstance().saveConference(info);
            }
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            true,
                            LabelText.delete_site_success[DataBase
                                    .getInstance()
                                    .getLanguageFlag()]);
        }
        else
        {
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            false,
                            LabelText.delete_site_failure[DataBase
                                    .getInstance()
                                    .getLanguageFlag()]
                                    + result);
        }
        
    }

    public void delScheduledConfEx(String confid, String time)
    {
        Integer result = confService.delScheduledConfEx(confid,null);
        
        if (0 == result)
        {
            DataBase.getInstance().removeConference(confid);
            confManagerPanel.getConfListPanel().refreshTable();
            confManagerPanel.getConfInfoPanel().getConfIdText()
                    .setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfNameText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getAccessCodeText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfHowLongText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfBeginTimeText().setText("");
            confManagerPanel.getConfInfoPanel().clearTable();
            confManagerPanel.getConfInfoPanel().getReTime().removeAllItems();
            confManagerPanel.getConfInfoPanel().getReTime().setEnabled(false);
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            true,
                            LabelText.delete_conf_success[DataBase
                                    .getInstance()
                                    .getLanguageFlag()]);
        }
        else if (1342177282 == result)
        {
            DataBase.getInstance().removeConference(confid);
            confManagerPanel.getConfListPanel().refreshTable();
            confManagerPanel.getConfInfoPanel().getConfIdText()
                    .setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfNameText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getAccessCodeText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfHowLongText().setText("");
            confManagerPanel.getConfInfoPanel()
                    .getConfBeginTimeText().setText("");
            confManagerPanel.getConfInfoPanel().clearTable();
            confManagerPanel.getConfInfoPanel().getReTime().removeAllItems();
            confManagerPanel.getConfInfoPanel().getReTime().setEnabled(false);
            confManagerPanel
            .getBottom_show_result_panel()
            .showResultMsg(
                    false,
                    LabelText.delete_conf_message[DataBase
                            .getInstance()
                            .getLanguageFlag()]);
        }
        else
        {
            confManagerPanel
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            false,
                            LabelText.delete_conf_failure[DataBase
                                    .getInstance()
                                    .getLanguageFlag()]
                                    + result);
        }
    }

    public Integer prolongScheduledConfEx(String confid, String time, int prolongTime)
    {
        return confService.prolongScheduledConfEx(confid,
                DateUtils.yyyyMMddHHmmss2date(time),
                DurationUtils.durationInt2dur(prolongTime));
    }
    
    public TPSDKResponseEx<List<SiteStatusEx>> queryConferenceSiteStatus(String confId,List<String> siteUris)
    {
        return confService.queryConfSitesStatusEx(confId, siteUris);
    }
}
