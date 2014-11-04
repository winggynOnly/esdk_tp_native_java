package com.huawei.esdk.csdemo.listener;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JEditorPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.action.ConfManagerAction;
import com.huawei.esdk.csdemo.adapter.ItemAdapter;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.mapping.SiteStatusMapping;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.csdemo.view.AddSiteToConfFrame;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.EditConfFrame;
import com.huawei.esdk.csdemo.view.ProlongConfFrame;
import com.huawei.esdk.csdemo.view.ScheduleConfFrame;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class ConfManagerListener
{
    protected static final Logger LOGGER = Logger.getLogger(ConfManagerListener.class);

    private ConfManagerPanel confManagerPanel;

    private ConfManagerAction confManagerAction;

    public void register(ConfManagerPanel confManagerPanel)
    {
        this.confManagerPanel = confManagerPanel;
        this.confManagerAction = new ConfManagerAction(confManagerPanel);
        addLogoutListener();
        addScheduleConfListener();
        addEditConfListener();
        addConfListTableListener();
        addShowAddSiteInConfListener();
        addConnectSiteListener();
        addDeleteSiteInConfListener();
        addDeleteConfListener();
        addProlongConfListener();
        addSelectTimeListener();
        addRefreshSitesListener();
    }

    /**
     * 退出登录的监听
     */
    private void addLogoutListener()
    {
        confManagerPanel.getBottomPanel().getBtm_exitLoginBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        KeepAliveThread.setFlag(1);
                        try
                        {
                            confManagerAction.logout();
                        }
                        catch(Exception exception)
                        {
                            LOGGER.error(exception.getMessage());
                        }
                        finally
                        {
                            System.exit(0);
                        }

                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel.getBottomPanel().getDescriptionPane()
                        // .setText("用户登出\n功能描述：用户登出系统");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane().setText("用户退出 \n功能描述：用户退出系统。 ");
//                        }
//                        else
//                        {
//                            getEditPane().setText(
//                                    "Logout \nExit the demo system. ");
//                        }
                        getEditPane().setText(LabelText.description_pane_exitLoginBtn[DataBase.getInstance().getLanguageFlag()]);
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    /**
     * 弹出预约会议的面板的监听
     */
    private void addScheduleConfListener()
    {
        confManagerPanel.getConfInfoPanel().getScheduleConfBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        Rectangle rect = new Rectangle(300, 200, 830, 610);
                        ScheduleConfFrame scheduleConfFrame = new ScheduleConfFrame(
                                DemoApp.mainFrame, true, rect);
                        scheduleConfFrame.lunchFrame();
                        scheduleConfFrame.setModal(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel.getBottomPanel().getDescriptionPane()
                        // .setText("进入预约会议面板\n功能描述：进入预约会议面板预约会议");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane()
//                                    .setText("进入预约会议面板\n功能描述：进入预约会议面板预约会议");
//                        }
//                        else
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "Open the schedule conference panel \nYou can schedule conference in schedule conference.");
//                        }
                        getEditPane().setText(LabelText.description_pane_scheduleConfBtn[DataBase.getInstance().getLanguageFlag()]);
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    private void addEditConfListener()
    {
        confManagerPanel.getConfInfoPanel().getEditConfBut()
                .addMouseListener(new MouseAdapter()
                {
                    @SuppressWarnings("unchecked")
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int[] rows = confManagerPanel.getConfListPanel()
                                .getConfList().getSelectedRows();
                        if (0 == rows.length)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_conf[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }

                        Rectangle rect = new Rectangle(300, 200, 830, 610);
                        EditConfFrame editConfFrame = new EditConfFrame(
                                DemoApp.mainFrame, true, rect);
                        editConfFrame.lunchFrame();

                        String confId = confManagerPanel.getConfInfoPanel()
                                .getConfIdText().getText();
                        RecurrenceConfInfoEx conf = DataBase.getInstance()
                                .queryConferenceById(confId);
                        editConfFrame.getConfIdText().setText(conf.getConfId());
                        editConfFrame.getConfNameText().setText(conf.getName());
                        editConfFrame.getConfBeginTimeText().setText(
                                DateUtils.date2yyyyMMddHHmmss(conf
                                        .getBeginTime()));
                        editConfFrame.getConfHowLongText().setText(
                                DurationUtils.duration2int(conf.getDuration())
                                        + "");

                        editConfFrame.getPasswordText().setText(conf.getPassword());
                        editConfFrame.getChairmanPasswordText().setText(conf.getChairmanPassword());
                        
                        if (0 == conf.getSiteAccessInfos().size())
                        {
//                            List<SiteInfoEx> list = conf.getSites();
//
//                            Vector<Vector<String>> siteData = new Vector<Vector<String>>();
//                            for (SiteInfoEx info : list)
//                            {
//                                Vector<String> vector = new Vector<String>();
//                                SiteInfoEx siteInfo = DataBase.getInstance()
//                                        .querySiteByUri(info.getUri());
//                                vector.add(siteInfo.getUri());
//                                vector.add(siteInfo.getName());
//                                vector.add(siteInfo.getType() + "");
//                                vector.add("");
//                                vector.add("");
//                                vector.add(siteInfo.getRate());
//                                vector.add("");
//                                vector.add("");
//
//                                siteData.add(vector);
//                            }

                            editConfFrame.getRecurrenceFlag()
                                    .setSelected(false);
//                            editConfFrame.getRecurrenceLabel()
//                                    .setVisible(false);
//                            editConfFrame.getRecurrenceFlag().setVisible(false);
//                            editConfFrame.getRecurrenceDetailBut().setVisible(
//                                    false);
                        }
                        else
                        {
                            setConfRecurrenceValsInPanel(confId, editConfFrame);
                            
                            editConfFrame.getRecurrenceFlag().setVisible(true);
                            editConfFrame.getRecurrenceDetailBut().setVisible(
                                    true);
                            editConfFrame.getRecurrenceLabel().setVisible(true);
                            editConfFrame.getRecurrenceFlag().setSelected(true);
//                            editConfFrame.getRecurrenceFlag().setEnabled(false);
                            editConfFrame.getRecurrenceDetailBut().setEnabled(
                                    true);
                        }
                        
                        Vector<Vector<String>> siteData = confManagerPanel.getConfInfoPanel().getTableMode().getDataVector();
                        for (Vector<String> site : siteData)
                        {
                            site.removeElementAt(3);
                        }
                        editConfFrame.refreshSitesList(siteData);
                        
                        editConfFrame.getContinuousPresenceJC().setSelectedIndex(DataBase.getInstance().queryConferenceById(confId).getCpResouce()-1);
                        
                        editConfFrame.setVisible(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel.getBottomPanel().getDescriptionPane()
                        // .setText("进入编辑会议面板\n功能描述：用户进入编辑会议面板编辑会议");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane().setText(
//                                    "进入编辑会议面板\n功能描述：用户进入编辑会议面板编辑会议");
//                        }
//                        else
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "Open the edit conference panel \nYou can edit conference in edit conference.");
//                        }
                        getEditPane().setText(LabelText.description_pane_editConfBtn[DataBase.getInstance().getLanguageFlag()]);
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    /**
     * 会议列表点击事件监听
     */
    private void addConfListTableListener()
    {
        confManagerPanel.getConfListPanel().getConfList().getSelectionModel()
                .addListSelectionListener(new ListSelectionListener()
                {
                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        ListSelectionModel sm = (ListSelectionModel) e
                                .getSource();
                        int row = sm.getMaxSelectionIndex();
                        if (row < 0)
                        {
                            return;
                        }
                        String confId = (String) confManagerPanel
                                .getConfListPanel().getConfList()
                                .getValueAt(row, 0);
                        RecurrenceConfInfoEx conf = DataBase.getInstance()
                                .queryConferenceById(confId);

                        confManagerPanel.getConfInfoPanel().getConfIdText()
                                .setText(confId);
                        confManagerPanel.getConfInfoPanel().getConfNameText()
                                .setText(conf.getName());
                        confManagerPanel
                                .getConfInfoPanel()
                                .getConfHowLongText()
                                .setText(
                                        DurationUtils.duration2int(conf
                                                .getDuration()) + "");

                        // 如果是普通会议
                        if (conf.getSiteAccessInfos().size() == 0)
                        {
//                            List<SiteInfoEx> sites = conf.getSites();
//                            String[][] siteData = new String[sites.size()][8];
//                            int i = 0;

                            // List<String> siteUris = new ArrayList<String>();
                            // for (SiteInfoEx site : sites)
                            // {
                            // siteUris.add(site.getUri());
                            // }

                            // TPSDKResponseEx<List<SiteStatusEx>>
                            // confSiteStatus =
                            // confManagerAction.queryConferenceSiteStatus(confId,
                            // siteUris);

//                            for (SiteInfoEx info : sites)
//                            {
//                                // if (null == siteMap.get(info.getUri()))
//                                // {
//                                if(null == info.getUri() || "".equals(info.getUri()))
//                                {
//                                    siteData[i][0] = LabelText.schedule_conf_anonymous_site[DataBase.
//                                            getInstance().getLanguageFlag()];
//                                    siteData[i][1] = "";
//                                    siteData[i][2] = "";
//                                    siteData[i][3] = "";
//                                    siteData[i][4] = "";
//                                    siteData[i][5] = "";
//                                    siteData[i][6] = "";
//                                    siteData[i][7] = "";
//                                }
//                                else
//                                {
//
//                                    SiteInfoEx siteInfo = DataBase.getInstance() .querySiteByUri(info.getUri());
//                                    
//                                    if(null != siteInfo){
//                                        siteData[i][0] = siteInfo.getUri();
//                                        siteData[i][1] = siteInfo.getName();
//                                        siteData[i][2] = siteInfo.getType() + "";
//                                        siteData[i][3] = "";
//                                        siteData[i][4] = "";
//                                        siteData[i][5] = siteInfo.getRate();
//                                        siteData[i][6] = "";
//                                        siteData[i][7] = "";
//                                    }
//                                }
//                                // siteMap.put(info.getUri(), info);
//                                i = i + 1;
//                                // }
//                            }
//                            confManagerPanel.getConfInfoPanel().refreshSiteTable(siteData);

                            confManagerPanel.getConfInfoPanel().getAccessCodeText().setText(conf.getAccessCode());
                            confManagerPanel.getConfInfoPanel().getConfBeginTimeText().setText(
                                            DateUtils.date2yyyyMMddHHmmss(conf.getBeginTime()));
                            confManagerPanel.getConfInfoPanel().getReTime().removeAllItems();
                            confManagerPanel.getConfInfoPanel().getReTime().setEnabled(false);
                            confManagerPanel.getConfInfoPanel().getConfBeginTimeText().setEnabled(false);
                        }
                        // 如果是周期会议
                        else
                        {
                            List<SiteAccessInfoEx> list = conf
                                    .getSiteAccessInfos();
                            Set<String> timeSet = new LinkedHashSet<String>();
//
//                            String timeFlag = DateUtils.date2yyyyMMddHHmmss(list.get(0).getBeginTime());
//                            int x = 0;
//
//                            // List<String> siteUris = new ArrayList<String>();
//
                            for (SiteAccessInfoEx accessInfo : list)
                            {
                                timeSet.add(DateUtils
                                        .date2yyyyMMddHHmmss(accessInfo .getBeginTime()));
//
//                                if (timeFlag.equals(DateUtils
//                                        .date2yyyyMMddHHmmss(accessInfo.getBeginTime())))
//                                {
//                                    // siteUris.add(accessInfo.getUri());
//                                    x = x + 1;
//                                }
                            }
//
//                            // TPSDKResponseEx<List<SiteStatusEx>>
//                            // confSiteStatus =
//                            // confManagerAction.queryConferenceSiteStatus(confId,
//                            // siteUris);
//
//                            String[][] data = new String[x][8];
//                            for (int j = 0; j < x; j++)
//                            {
//                                SiteInfoEx siteInfo = DataBase.getInstance()
//                                        .querySiteByUri(list.get(j).getUri());
//                                if(null == siteInfo){
//                                    continue;
//                                }
//                                data[j][0] = siteInfo.getUri();
//                                data[j][1] = siteInfo.getName();
//                                data[j][2] = siteInfo.getType() + "";
//                                data[j][3] = "";
//                                data[j][4] = "";
//                                data[j][5] = siteInfo.getRate();
//                                data[j][6] = "";
//                                data[j][7] = "";
//                            }
//
//                            confManagerPanel.getConfInfoPanel()
//                                    .refreshSiteTable(data);

                            confManagerPanel.getConfInfoPanel().getReTime()
                                    .removeAllItems();
                            confManagerPanel.getConfInfoPanel().getReTime()
                                    .setEnabled(true);
//                             Collections.sort(timeSet);
                            //排序
                            List<String> timeList = new ArrayList<String>();
                            for (String time : timeSet)
                            {
                                timeList.add(time);
                            }
                            Collections.sort(timeList);
                            
                            for (String time : timeList)
                            {
                                confManagerPanel.getConfInfoPanel().getReTime()
                                        .addItem(time);
                            }

                            confManagerPanel.getConfInfoPanel()
                                    .getAccessCodeText()
                                    .setText(list.get(0).getConfAccessCode());
                            confManagerPanel
                                    .getConfInfoPanel()
                                    .getConfBeginTimeText()
                                    .setText(
                                            DateUtils.date2yyyyMMddHHmmss(list
                                                    .get(0).getBeginTime()));
                            confManagerPanel.getConfInfoPanel()
                                    .getConfBeginTimeText().setEnabled(true);

                            if (null != DataBase
                                    .getInstance()
                                    .getDurationFromMap(
                                            confId
                                                    + "_"
                                                    + confManagerPanel
                                                            .getConfInfoPanel()
                                                            .getConfBeginTimeText()
                                                            .getText()))
                            {
                                confManagerPanel
                                        .getConfInfoPanel()
                                        .getConfHowLongText()
                                        .setText(
                                                DataBase.getInstance()
                                                        .getDurationFromMap(
                                                                confId
                                                                        + "_"
                                                                        + confManagerPanel
                                                                                .getConfInfoPanel()
                                                                                .getConfBeginTimeText()
                                                                                .getText())
                                                        + "");
                            }
                        }
                        refreshSiteStatus(confId);
                    }
                });
    }

    /**
     * 显示添加会场的面板
     */
    private void addShowAddSiteInConfListener()
    {
        confManagerPanel.getConfInfoPanel().getAddsiteBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if (0 > confManagerPanel.getConfListPanel()
                                .getConfList().getSelectionModel()
                                .getMaxSelectionIndex())
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_conf[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }
                        Rectangle rect = new Rectangle(350, 250, 600, 310);
                        AddSiteToConfFrame confFrame = new AddSiteToConfFrame(
                                DemoApp.mainFrame, true, rect);
                        confFrame.lunchFrame();
                        confFrame.getSiteControlSiteListPan().freshTable(
                                DataBase.getInstance()
                                        .getSelectSiteListVector());
                        confFrame.setVisible(true);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel.getBottomPanel().getDescriptionPane()
                        // .setText("添加会场\n功能描述：用户进入添加会场面板添加会场");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane().setText("添加会场\n功能描述：用户进入添加会场面板添加会场");
//                        }
//                        else
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "Open the add site panel \nYou can add site in add site panel.");
//                        }
                        getEditPane().setText(LabelText.description_pane_addSiteBtn[DataBase.getInstance().getLanguageFlag()]);
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    private void addConnectSiteListener()
    {
        confManagerPanel.getConfInfoPanel().getConnectSiteBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int row = confManagerPanel.getConfInfoPanel()
                                .getJtable().getSelectionModel()
                                .getMaxSelectionIndex();
                        if (0 > row)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_sites[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }
                        String confid = confManagerPanel.getConfInfoPanel()
                                .getConfIdText().getText();
                        int[] rows = confManagerPanel.getConfInfoPanel()
                                .getJtable().getSelectedRows();
                        List<String> sites = new ArrayList<String>();
                        for (int i = 0; i < rows.length; i++)
                        {
                            String uri = (String) confManagerPanel
                                    .getConfInfoPanel().getJtable()
                                    .getValueAt(rows[i], 0);
                            sites.add(uri);
                        }

                        if(confManagerPanel.getConfInfoPanel().getReTime().isEnabled())
                        {
                            int selectedIndex = confManagerPanel
                            .getConfInfoPanel().getReTime().getSelectedIndex();

                            confid = String.valueOf(Integer.parseInt(confid)+ selectedIndex + 1);
                        }
                        new MethodThread(confManagerAction,"connectSitesEx",confid,sites).start();


                        // refreshSiteStatus(confid);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel
                        // .getBottomPanel()
                        // .getDescriptionPane()
                        // .setText(
                        // "呼叫会场\n 接口说明：Integer connectSitesEx (String confId, List<String> siteUris) \n 功能描述：呼叫会场");

                        getEditPane()
                                .setText(
                                        "Integer connectSitesEx (String confId, List<String> siteUris) ");

                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    protected void refreshSiteStatus(String confid)
    {
        if(confManagerPanel.getConfInfoPanel().getReTime().isEnabled())
        {
            int selectedIndex = confManagerPanel
            .getConfInfoPanel().getReTime().getSelectedIndex();

            confid = String.valueOf(Integer.parseInt(confid)+ selectedIndex + 1);
        }
        
        TPSDKResponseEx<List<SiteStatusEx>> statusResult = confManagerAction
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
            siteData[i][2] = info.getType() + "";
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

    private void addDeleteSiteInConfListener()
    {
        confManagerPanel.getConfInfoPanel().getDeletesiteBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int[] rows = confManagerPanel.getConfInfoPanel()
                                .getJtable().getSelectedRows();
                        if (0 == rows.length || 1 < rows.length)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_site[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }

                        String confid = confManagerPanel.getConfInfoPanel()
                                .getConfIdText().getText();
                        
                        if(confManagerPanel.getConfInfoPanel().getReTime().isEnabled())
                        {
                            int selectedIndex = confManagerPanel
                            .getConfInfoPanel().getReTime().getSelectedIndex();

                            confid = String.valueOf(Integer.parseInt(confid)+ selectedIndex + 1);
                        }
                        
                        String uri = (String) confManagerPanel
                                .getConfInfoPanel().getJtable()
                                .getValueAt(rows[0], 0);
                        String time = confManagerPanel.getConfInfoPanel()
                                .getConfBeginTimeText().getText();
                        
                        if (!confManagerPanel.getConfInfoPanel().getReTime().isEnabled())
                        {
                            time = "";
                        }
                        
                        new MethodThread(confManagerAction,"delSiteFromConfEx",confid, uri, time).start();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel
                        // .getBottomPanel()
                        // .getDescriptionPane()
                        // .setText(
                        // "删除会场\n 接口说明：Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime) \n 功能描述：删除会场");
                        getEditPane()
                                .setText(
                                        "Integer delSiteFromConfEx(String confId, String siteUri, Date beginTime) ");
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    private void addDeleteConfListener()
    {
        confManagerPanel.getConfInfoPanel().getDeleteConfBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int[] rows = confManagerPanel.getConfListPanel()
                                .getConfList().getSelectedRows();
                        if (0 == rows.length)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_conf[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }

                        String confid = confManagerPanel.getConfInfoPanel()
                                .getConfIdText().getText();
                        String time = confManagerPanel.getConfInfoPanel()
                                .getConfBeginTimeText().getText();

                        new MethodThread(confManagerAction,"delScheduledConfEx",confid,time).start();

                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel
                        // .getBottomPanel()
                        // .getDescriptionPane()
                        // .setText(
                        // "删除会议\n 接口说明：Integer delScheduledConfEx(String confId, Date beginTime) \n 功能描述：删除预约会议&结束会议");
                        getEditPane()
                                .setText(
                                        "Integer delScheduledConfEx(String confId, Date beginTime)");
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    private void addProlongConfListener()
    {
        confManagerPanel.getConfInfoPanel().getProConfBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int[] rows = confManagerPanel.getConfListPanel()
                                .getConfList().getSelectedRows();
                        if (0 == rows.length)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_conf[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }
                        Rectangle rect = new Rectangle(300, 200, 350, 200);
                        ProlongConfFrame prolongConfFrame = new ProlongConfFrame(
                                DemoApp.mainFrame, true, rect);
                        prolongConfFrame.lunchFrame();
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel
                        // .getBottomPanel()
                        // .getDescriptionPane()
                        // .setText(
                        // "延长会议\n 接口说明：Integer prolongScheduledConfEx (String confId, java.util.Date beginDate, Duration prolongTime) \n 功能描述：延长已预约会议时间");
                        getEditPane()
                                .setText(
                                        "Integer prolongScheduledConfEx (String confId, java.util.Date beginDate, Duration prolongTime) ");
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }
                });
    }

    private void addSelectTimeListener()
    {
        confManagerPanel.getConfInfoPanel().getReTime()
                .addItemListener(new ItemAdapter()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        if (e.getStateChange() == ItemEvent.SELECTED)
                        {
                            String confid = confManagerPanel.getConfInfoPanel()
                                    .getConfIdText().getText();
                            String time = (String) confManagerPanel
                                    .getConfInfoPanel().getReTime()
                                    .getSelectedItem();
//                            RecurrenceConfInfoEx conf = DataBase.getInstance()
//                                    .queryConferenceById(confid);
//
//                            List<SiteAccessInfoEx> list = conf
//                                    .getSitesAccessInfo();
//
//                            int x = 0;
//                            for (SiteAccessInfoEx accessInfo : list)
//                            {
//                                if (time.equals(DateUtils
//                                        .date2yyyyMMddHHmmss(accessInfo
//                                                .getBeginTime())))
//                                {
//                                    x = x + 1;
//                                }
//                            }
//                            String[][] data = new String[x][8];
//                            int j = 0;
//                            for (SiteAccessInfoEx accessInfo : list)
//                            {
//                                if (time.equals(DateUtils
//                                        .date2yyyyMMddHHmmss(accessInfo
//                                                .getBeginTime())))
//                                {
//                                    SiteInfoEx siteInfo = DataBase
//                                            .getInstance().querySiteByUri(
//                                                    list.get(j).getUri());
//                                    if(null == siteInfo){
//                                        continue;
//                                    }
//                                    data[j][0] = siteInfo.getUri();
//                                    data[j][1] = siteInfo.getName();
//                                    data[j][2] = siteInfo.getType() + "";
//                                    data[j][3] = "";
//                                    data[j][4] = "";
//                                    data[j][5] = siteInfo.getRate();
//                                    data[j][6] = "";
//                                    data[j][7] = "";
//                                    j++;
//
//                                    confManagerPanel
//                                            .getConfInfoPanel()
//                                            .getAccessCodeText()
//                                            .setText(
//                                                    accessInfo
//                                                            .getConfAccessCode());
//                                }
//                            }
//
//                            confManagerPanel.getConfInfoPanel()
//                                    .refreshSiteTable(data);

                            confManagerPanel.getConfInfoPanel()
                                    .getConfBeginTimeText().setText(time);

                            if (null != DataBase
                                    .getInstance()
                                    .getDurationFromMap(
                                            confid
                                                    + "_"
                                                    + confManagerPanel
                                                            .getConfInfoPanel()
                                                            .getConfBeginTimeText()
                                                            .getText()))
                            {
                                confManagerPanel
                                        .getConfInfoPanel()
                                        .getConfHowLongText()
                                        .setText(
                                                DataBase.getInstance()
                                                        .getDurationFromMap(
                                                                confid
                                                                        + "_"
                                                                        + confManagerPanel
                                                                                .getConfInfoPanel()
                                                                                .getConfBeginTimeText()
                                                                                .getText())
                                                        + "");
                            }
                            
                            refreshSiteStatus(confid);
                        }
                    }
                });

        confManagerPanel.getConfInfoPanel().getReTime()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel
                        // .getBottomPanel()
                        // .getDescriptionPane()
                        // .setText(
                        // "选择周期会议的时间 \n 功能描述：通过选择周期会议子会议的举行时间，显示子会议的信息");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "选择周期会议的时间 \n 功能描述：通过选择周期会议子会议的举行时间，显示子会议的信息 ");
//                        }
//                        else
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "Choose the begin time of recurrent conference \nDisplay the detail of son conference by change the conference's begin time. ");
//                        }
                        getEditPane().setText(LabelText.description_pane_confBeginTimeBtn[DataBase.getInstance().getLanguageFlag()]);
                    }
                });

    }

    private void addRefreshSitesListener()
    {
        confManagerPanel.getConfInfoPanel().getRefreshSiteBut()
                .addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        int[] rows = confManagerPanel.getConfListPanel()
                                .getConfList().getSelectedRows();
                        if (0 == rows.length)
                        {
                            confManagerPanel.getBottom_show_result_panel()
                                    .showResultMsg(
                                            false,
                                            LabelText.choose_conf[DataBase
                                                    .getInstance()
                                                    .getLanguageFlag()]);
                            return;
                        }
                        String confid = confManagerPanel.getConfInfoPanel()
                                .getConfIdText().getText();
                        refreshSiteStatus(confid);
                    }

                    @Override
                    public void mouseExited(MouseEvent e)
                    {
                        confManagerPanel.getBottomPanel().getDescriptionPane()
                                .setText("");
                    }

                    @Override
                    public void mouseEntered(MouseEvent e)
                    {
                        // confManagerPanel.getBottomPanel().getDescriptionPane()
                        // .setText("刷新会场 \n 功能描述：选择会议后，可以点击刷新会议中会场的状态");
//                        if (0 == DataBase.getInstance().getLanguageFlag())
//                        {
//                            getEditPane().setText(
//                                    "刷新会场 \n 功能描述：选择会议后，可以点击刷新会议中会场的状态。 ");
//                        }
//                        else
//                        {
//                            getEditPane()
//                                    .setText(
//                                            "Refresh the site table \nRefresh the site table to view the status of site ");
//                        }
                        getEditPane().setText(LabelText.description_pane_refreashSiteListBtn[DataBase.getInstance().getLanguageFlag()]);
                    }
                });
    }

    private JEditorPane getEditPane()
    {
        // TODO Auto-generated method stub
        return confManagerPanel.getBottomPanel().getDescriptionPane();
    }
    
    private void setConfRecurrenceValsInPanel(String confId, EditConfFrame editConfFrame)
    {
        RecurrenceConfInfoEx confInfo = DataBase.getInstance().queryConferenceById(confId);
        if(null != confInfo.getWeekDay())
        {
            editConfFrame.getRecurrenceConfDetail().getWeekDayText().setText(String.valueOf(confInfo.getWeekDay()));
        }
        if(null != confInfo.getMonthDay())
        {
            editConfFrame.getRecurrenceConfDetail().getMonthDayText().setText(String.valueOf(confInfo.getMonthDay()));
        }
        if(null != confInfo.getInterval())
        {
            editConfFrame.getRecurrenceConfDetail().getIntervalText().setText(String.valueOf(confInfo.getInterval()));
        }
        if(null != confInfo.getWeekDays())
        {
            int[] selectedItems = new int[confInfo.getWeekDays().size()];

            Object[] items = confInfo.getWeekDays().toArray();
            
            for(int i = 0; i < confInfo.getWeekDays().size(); i++)
            {
                selectedItems[i] = (Integer)items[i];
            }
            editConfFrame.getRecurrenceConfDetail().getWeekDaysList().setSelectedIndices(selectedItems);
        }
        if(null != confInfo.getFrequency())
        {
            editConfFrame.getRecurrenceConfDetail().getFrequencyBox().setSelectedIndex(confInfo.getFrequency());
        }
        if(null != confInfo.getCount())
        {
            editConfFrame.getRecurrenceConfDetail().getCountText().setText(String.valueOf(confInfo.getCount()));
        }
        if(null != confInfo.getEndDate())
        {
            editConfFrame.getRecurrenceConfDetail().getDateText().setText( DateUtils.date2yyyyMMddHHmmss(confInfo
                .getEndDate()));
        }
        editConfFrame.getRecurrenceConfDetail().repaint();
    }
}
