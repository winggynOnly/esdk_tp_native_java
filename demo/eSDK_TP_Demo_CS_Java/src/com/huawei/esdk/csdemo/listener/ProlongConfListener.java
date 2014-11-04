package com.huawei.esdk.csdemo.listener;

import java.awt.event.MouseEvent;

import javax.xml.datatype.Duration;

import com.huawei.esdk.csdemo.action.ConfManagerAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.ProlongConfFrame;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;

public class ProlongConfListener
{
    private ProlongConfFrame frame;

    private ConfManagerPanel confManagerPanel;

    private ConfManagerAction confManagerAction;

    public void register(ProlongConfFrame frame)
    {
        this.frame = frame;
        confManagerPanel = DemoApp.mainFrame.getPan1();
        confManagerAction = new ConfManagerAction(confManagerPanel);
        addCloseListener();
        addOkListener();
    }

    private void addCloseListener()
    {
        frame.getCloseButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                frame.dispose();
            }
        });
    }

    private void addOkListener()
    {
        frame.getOkButton().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int[] rows = confManagerPanel.getConfListPanel().getConfList()
                        .getSelectedRows();
                if (0 == rows.length)
                {
                    DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(false, LabelText.choose_conf[DataBase.getInstance().getLanguageFlag()]);
                    return;
                }
                String prolongtime = frame.getTimeText().getText();
                if (!prolongtime.matches("\\d+"))
                {
                    DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(false, LabelText.prolong_time[DataBase.getInstance().getLanguageFlag()]);
                    return;
                }
                String confid = confManagerPanel.getConfInfoPanel()
                        .getConfIdText().getText();
                String time = confManagerPanel.getConfInfoPanel()
                        .getConfBeginTimeText().getText();
                Integer result = confManagerAction.prolongScheduledConfEx(confid, time,
                        Integer.parseInt(prolongtime));
                if (0 != result)
                {
                    DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(false, LabelText.prolong_conf_failure[DataBase.getInstance().getLanguageFlag()]
                                            + result);
                    return;
                }
                DemoApp.mainFrame.getPan1().getBottom_show_result_panel().showResultMsg(true, LabelText.prolong_conf_success[DataBase.getInstance().getLanguageFlag()]);
                frame.setVisible(false);
                
                RecurrenceConfInfoEx confInfo = DataBase.getInstance().queryConferenceById(confid);
                Duration duration = confInfo.getDuration();
                if (0 == confInfo.getSiteAccessInfos().size())
                {
                    Duration newDuration = DurationUtils.durationInt2dur(DurationUtils.duration2int(duration) + Integer.parseInt(prolongtime));
                    confInfo.setDuration(newDuration);
                    DataBase.getInstance().removeConference(confid);
                    DataBase.getInstance().saveConference(confInfo);
                    DemoApp.mainFrame.getPan1().getConfListPanel().refreshTable();
                }
                else
                {
                    Integer newTime = DurationUtils.duration2int(duration) + Integer.parseInt(prolongtime);
//                    DataBase.getInstance().putInDuration(confid + "_" + time, newTime);
                    confInfo.setDuration(DurationUtils.durationInt2dur(newTime));
                    DataBase.getInstance().removeConference(confid);
                    DataBase.getInstance().saveConference(confInfo);
                    DemoApp.mainFrame.getPan1().getConfListPanel().refreshTable();
                }
            }
        });
    }
}
