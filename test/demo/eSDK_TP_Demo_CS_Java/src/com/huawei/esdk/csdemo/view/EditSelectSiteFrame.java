package com.huawei.esdk.csdemo.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.panel.SelectSiteListPan;

public class EditSelectSiteFrame extends JDialog implements ActionListener
{
private static final long serialVersionUID = 1L;
    
    private Rectangle rectangle;
    
    private SelectSiteListPan siteControlSiteListPan;
    
    private EditConfFrame editConfFrame;
    
    private JButton okBut = new JButton();

    private JButton closeBut = new JButton();
    
    public EditSelectSiteFrame(EditConfFrame owner,Boolean isMoal,Rectangle rectangle)
    {
        super(owner,isMoal);
        this.rectangle = rectangle;
        this.setLayout(null);
        this.editConfFrame = owner;
    }
    
    public void lunchFrame()
    {
        this.setTitle(LabelText.choose_sites_to_add[DataBase.getInstance().getLanguageFlag()]);
        this.setBounds(this.rectangle);
        Rectangle btmRect1 = new Rectangle(10,20,rectangle.width-40,220);
        siteControlSiteListPan = new SelectSiteListPan(btmRect1);
        siteControlSiteListPan.createPanel();
        this.add(siteControlSiteListPan);
        
        okBut.setText(LabelText.okBtn[DataBase.getInstance().getLanguageFlag()]);
        okBut.setActionCommand("confirm_select_command");
        okBut.addActionListener(this);
        closeBut.setText(LabelText.closeBtn[DataBase.getInstance().getLanguageFlag()]);
        closeBut.setActionCommand("close_command");
        closeBut.addActionListener(this);
        
        okBut.setBounds(265 - 50, 310 - 65, 100, 25);
        
        this.add(okBut);
        this.add(closeBut);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        if ("confirm_select_command".equals(command))
        {
            siteControlSiteListPan.getSelectedData();
            editConfFrame.refreshSitesList(siteControlSiteListPan.getSelectedData());
            this.setVisible(false);
            return ;
        }
    }

    public SelectSiteListPan getSiteControlSiteListPan()
    {
        return siteControlSiteListPan;
    }
    
}
