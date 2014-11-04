package com.huawei.esdk.csdemo.listener;

import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import com.huawei.esdk.csdemo.action.EditConfAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.EditConfFrame;
import com.huawei.esdk.csdemo.view.EditSelectSiteFrame;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.RecurrenceConfFrame;

public class EditConfListener
{

    private EditConfFrame editConfFrame;

    private EditConfAction editConfAction;

    public void register(EditConfFrame editConfFrame)
    {
        this.editConfFrame = editConfFrame;

        this.editConfAction = new EditConfAction(editConfFrame);

        addCloseListener();

        addShowSiteListListener();

        addEditConfListener();

        addReferrenceDetailListener();

        addAnonymitySiteListener();
    
        addDeleteBtnListener();
        
        addRecurrenceFlagListener();
    }

    private void addCloseListener()
    {
        editConfFrame.getCloseBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                editConfFrame.dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void addShowSiteListListener()
    {
        editConfFrame.getAddsiteBut1().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (null == editConfFrame.getFrame())
                {
                    Rectangle rect = new Rectangle(350, 250, 600, 310);
                    EditSelectSiteFrame frame = new EditSelectSiteFrame(
                            editConfFrame, true, rect);
                    frame.lunchFrame();
                    editConfFrame.setFrame(frame);
                }
                
                Vector<Vector<String>> existData = editConfFrame.getTableMode().getDataVector();
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
                editConfFrame.getFrame().getSiteControlSiteListPan().freshTable(vector);
                
                editConfFrame.getFrame().setVisible(true);
            }
        });
    }

    private void addEditConfListener()
    {
        editConfFrame.getScheConfBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                String duration = editConfFrame.getConfHowLongText().getText();
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

//                Integer result = editConfAction.editConf();

                new MethodThread(editConfAction,"editConf").start();
            }
        });
    }

    private void addReferrenceDetailListener()
    {
        editConfFrame.getRecurrenceDetailBut().addMouseListener(
                new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent e)
                    {
                        if (null == editConfFrame.getRecurrenceConfDetail())
                        {
                            Rectangle rect = new Rectangle(300, 200, 350, 400);
                            RecurrenceConfFrame recurrenceConfFrame = new RecurrenceConfFrame(
                                    editConfFrame, true, rect);
                            recurrenceConfFrame.lunchFrame();
                            editConfFrame
                                    .setRecurrenceConfDetail(recurrenceConfFrame);
                            recurrenceConfFrame.setVisible(true);
                        }
                        else
                        {
                            editConfFrame.getRecurrenceConfDetail().setVisible(
                                    true);
                        }
                    }
                });
    }

    private void addAnonymitySiteListener()
    {
        editConfFrame.getAddsiteBut().addMouseListener(new MouseAdapter()
        {
            @Override
            @SuppressWarnings("unchecked")
            public void mouseClicked(MouseEvent e)
            {
                Vector<Vector<String>> data = editConfFrame.getTableMode()
                        .getDataVector();
                Vector<String> vector = new Vector<String>();
                vector.add("");
                vector.add("");
                vector.add("4");
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                vector.add("");
                data.add(vector);
                editConfFrame.clearTable();
                editConfFrame.refreshSitesList(data);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    private void addDeleteBtnListener()
    {
        editConfFrame.getDeletesiteBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int[] rows = editConfFrame.getJtable().getSelectedRows();
                if (0 == rows.length)
                {
                    DemoApp.mainFrame.getPan1()
                            .getBottom_show_result_panel()
                            .showResultMsg(
                                    false,
                                    LabelText.choose_sites[DataBase.getInstance().getLanguageFlag()]);
                    return;
                }
                
                Vector<Vector<String>> selectedSites = editConfFrame.getTableMode().getDataVector();
                
                for (int i = rows.length - 1 ;i >= 0;i--)
                {
                    selectedSites.removeElementAt(rows[i]);
                }
                editConfFrame.clearTable();
                editConfFrame.refreshSitesList(selectedSites);
            }
        });
    }
    
    private void addRecurrenceFlagListener()
    {
        editConfFrame.getRecurrenceFlag().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (editConfFrame.getRecurrenceFlag().isSelected() == true)
                {
                    editConfFrame.getRecurrenceDetailBut().setVisible(true);
                }
                else
                {
                    editConfFrame.getRecurrenceDetailBut().setVisible(false);
                }
            }
        });
    }
}
