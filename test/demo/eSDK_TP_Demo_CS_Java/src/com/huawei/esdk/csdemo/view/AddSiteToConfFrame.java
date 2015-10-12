package com.huawei.esdk.csdemo.view;

import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;

import com.huawei.esdk.csdemo.listener.AddSiteToConfListener;
import com.huawei.esdk.csdemo.view.panel.SelectSiteListPan;

public class AddSiteToConfFrame extends JDialog
{

    private static final long serialVersionUID = 1L;
    
    private Rectangle rectangle;
    
    private SelectSiteListPan siteControlSiteListPan;
    
    @SuppressWarnings("unused")
    private ScheduleConfFrame scheduleConfFrame;
    
    private JButton okBut = new JButton();

    private JButton closeBut = new JButton();
    
    public AddSiteToConfFrame(Frame owner,Boolean isModal,Rectangle rectangle)
    {
        super(owner,isModal);
        this.rectangle = rectangle;
        this.setLayout(null);
    }
    
    public void lunchFrame()
    {
        this.setTitle("选择添加到会议的会场");
        this.setBounds(this.rectangle);
        Rectangle btmRect1 = new Rectangle(10,20,rectangle.width-40,220);
        siteControlSiteListPan = new SelectSiteListPan(btmRect1);
        siteControlSiteListPan.createPanel();
        this.add(siteControlSiteListPan);
        
        okBut.setText("确定");
        okBut.setActionCommand("confirm_select_command");
//        okBut.addActionListener(this);
        closeBut.setText("关闭");
        closeBut.setActionCommand("close_command");
//        closeBut.addActionListener(this);
        
        okBut.setBounds(265 - 50 - 20, 310 - 65, 100, 25);
        closeBut.setBounds(250 + 50 + 20, 310 - 65, 100, 25);
        
        this.add(okBut);
        this.add(closeBut);
        AddSiteToConfListener listener = new AddSiteToConfListener();
        listener.register(this);
        
        siteControlSiteListPan.getSiteList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.setResizable(false);
    }

    public JButton getOkBut()
    {
        return okBut;
    }

    public JButton getCloseBut()
    {
        return closeBut;
    }

    public SelectSiteListPan getSiteControlSiteListPan()
    {
        return siteControlSiteListPan;
    }
    
}
