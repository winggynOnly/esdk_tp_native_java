package com.huawei.esdk.csdemo.listener;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.huawei.esdk.csdemo.action.ScheduleConfAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.RecurrenceConfFrame;
import com.huawei.esdk.csdemo.view.ScheduleConfFrame;
import com.huawei.esdk.csdemo.view.SelectSiteFrame;

public class ScheduleConfListener
{

    private ScheduleConfFrame scheduleConfFrame;

    private ScheduleConfAction scheduleConfAction;

    public void register(ScheduleConfFrame scheduleConfFrame)
    {
        this.scheduleConfFrame = scheduleConfFrame;
        this.scheduleConfAction = new ScheduleConfAction(scheduleConfFrame);
        addShowSiteListListener();
        addCloseListener();
        addCreateConfListener();
        addRecurrenceConfDetailListener();
        addAnonymitySiteListener();
        addDeleteBtnListener();
        addRecurrenceFlagListener();
    }

    @SuppressWarnings("unchecked")
    private void addShowSiteListListener()
    {
        scheduleConfFrame.getAddsiteBut1().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (null == scheduleConfFrame.getFrame())
                {
                    Rectangle rect = new Rectangle(350, 250, 600, 310);
                    SelectSiteFrame frame = new SelectSiteFrame(rect,
                            scheduleConfFrame, true);
                    frame.lunchFrame();
                    scheduleConfFrame.setFrame(frame);
                }
               
                Vector<Vector<String>> existData = scheduleConfFrame.getTableMode().getDataVector();
                Vector<Vector<String>> vector = new Vector<Vector<String>>();
                for (Vector<String> data : DataBase.getInstance().getSelectSiteListVector())
                {
                    boolean flag = false;
                    for (Vector<String> exist : existData)
                    {
                        if (data.get(0).equals(exist.get(0)))
                        {
                            flag = true;
                            break;
                        }
                    }
                    if (flag)
                    {
                        continue;
                    }
                    else
                    {
                        vector.add(data);
                    }
                }
                scheduleConfFrame.getFrame().getSiteControlSiteListPan().freshTable(vector);
                
                scheduleConfFrame.getFrame().setVisible(true);
            }
        });
    }

    private void addCloseListener()
    {
        scheduleConfFrame.getCloseBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                scheduleConfFrame.dispose();
            }
        });
    }

    private void addCreateConfListener()
    {
        scheduleConfFrame.getScheConfBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String duration = scheduleConfFrame.getConfHowLongText()
                        .getText();
                if (!duration.matches("\\d+"))
                {
                    DemoApp.mainFrame
                            .getPan1()
                            .getBottom_show_result_panel()
                            .showResultMsg(
                                    false,
                                    LabelText.duration_error[DataBase.getInstance().getLanguageFlag()]);
                    return;
                }

//                Integer result = scheduleConfAction.scheduleConf();

                new MethodThread(scheduleConfAction,"scheduleConf").start();
//modify by gaolinfei                 
//                if (0 != result)
//                {
//                    DemoApp.mainFrame
//                            .getPan1()
//                            .getBottom_show_result_panel()
//                            .showResultMsg(
//                                    false,
//                                    LabelText.schedule_conf_failure[DataBase.getInstance().getLanguageFlag()]
//                                            + result);
//                    return;
//                }
//                else
//                {
//                    DemoApp.mainFrame
//                            .getPan1()
//                            .getBottom_show_result_panel()
//                            .showResultMsg(
//                                    true,
//                                    LabelText.schedule_conf_success[DataBase.getInstance().getLanguageFlag()]);
//
//                    DemoApp.mainFrame.getPan1().getConfListPanel()
//                            .refreshTable();
//                    scheduleConfFrame.getConfIdText().setText("");
//                    scheduleConfFrame.getConfNameText().setText("");
//                    scheduleConfFrame.getConfBeginTimeText().setText("");
//                    scheduleConfFrame.getConfHowLongText().setText("");
//                    scheduleConfFrame.dispose();
//                    return;
//                }

            }
        });
    }

    private void addRecurrenceConfDetailListener()
    {
        scheduleConfFrame.getRecurrenceDetailBut().addMouseListener(
                new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if (null == scheduleConfFrame.getRecurrenceConfDetail())
                        {
                            Rectangle rect = new Rectangle(300, 200, 350, 400);
                            RecurrenceConfFrame recurrenceConfFrame = new RecurrenceConfFrame(
                                    scheduleConfFrame, true, rect);
                            recurrenceConfFrame.lunchFrame();
                            scheduleConfFrame
                                    .setRecurrenceConfDetail(recurrenceConfFrame);
                            recurrenceConfFrame.setVisible(true);
                        }
                        else
                        {
                            scheduleConfFrame.getRecurrenceConfDetail()
                                    .setVisible(true);
                        }
                    }
                });
    }

    private void addAnonymitySiteListener()
    {
        scheduleConfFrame.getAddsiteBut().addMouseListener(new MouseAdapter()
        {
            @Override
            @SuppressWarnings("unchecked")
            public void mouseClicked(MouseEvent e)
            {
                Vector<Vector<String>> data = scheduleConfFrame.getTableMode()
                        .getDataVector();
                Vector<String> vector = new Vector<String>();
                vector.add(LabelText.schedule_conf_anonymous_site[DataBase.
                         getInstance().getLanguageFlag()]);
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                data.add(vector);
                scheduleConfFrame.clearTable();
                scheduleConfFrame.refreshSitesList(data);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void addDeleteBtnListener()
    {
        scheduleConfFrame.getDeletesiteBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int[] rows = scheduleConfFrame.getJtable().getSelectedRows();
                if (0 == rows.length)
                {
                    DemoApp.mainFrame.getPan1()
                            .getBottom_show_result_panel()
                            .showResultMsg(
                                    false,
                                    LabelText.choose_sites[DataBase.getInstance().getLanguageFlag()]);
                    return;
                }
                
                Vector<Vector<String>> selectedSites = scheduleConfFrame.getTableMode().getDataVector();
                
                for (int i = rows.length - 1 ;i >= 0;i--)
                {
                    selectedSites.removeElementAt(rows[i]);
                }
                scheduleConfFrame.clearTable();
                scheduleConfFrame.refreshSitesList(selectedSites);
            }
        });
    }
    
    private void addRecurrenceFlagListener()
    {
        scheduleConfFrame.getRecurrenceFlag().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (scheduleConfFrame.getRecurrenceFlag().isSelected() == true)
                {
                    scheduleConfFrame.getRecurrenceDetailBut().setVisible(true);
                }
                else
                {
                    scheduleConfFrame.getRecurrenceDetailBut().setVisible(false);
                }
            }
        });
    }
}
