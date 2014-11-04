package com.huawei.esdk.csdemo.view;

import java.awt.Frame;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.listener.ProlongConfListener;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ProlongConfFrame extends JDialog
{
    /** * */
    private static final long serialVersionUID = 1L;

    private Rectangle rect;

    public ProlongConfFrame(Frame owner, Boolean isModal,Rectangle rect)
    {
        super(owner, isModal);
        this.rect = rect;
    }

    private JLabel timeLabel = new JLabel();

    private JTextField timeText = new JTextField();

    private JButton okButton = new JButton();

    private JButton closeButton = new JButton();

    public void lunchFrame()
    {
        this.setTitle(LabelText.prolong_conf[DataBase.getInstance().getLanguageFlag()]);
        this.setBounds(rect);
        this.setLayout(null);
        timeLabel.setText(LabelText.overtime[DataBase.getInstance().getLanguageFlag()]);
        okButton.setText(LabelText.okBtn[DataBase.getInstance().getLanguageFlag()]);
        closeButton.setText(LabelText.closeBtn[DataBase.getInstance().getLanguageFlag()]);

        timeLabel.setBounds(30, 50, 120, 20);
        timeText.setBounds(120, 50, 200, 20);

        okButton.setBounds(50, 100, 80, 25);
        closeButton.setBounds(200, 100, 80, 25);

        this.add(timeLabel);
        this.add(timeText);
        this.add(okButton);
        this.add(closeButton);

        this.setResizable(false);

        ProlongConfListener listener = new ProlongConfListener();
        listener.register(this);
        
        this.setVisible(true);
    }

    public JTextField getTimeText()
    {
        return timeText;
    }

    public JButton getOkButton()
    {
        return okButton;
    }

    public JButton getCloseButton()
    {
        return closeButton;
    }

}
