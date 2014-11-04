package com.huawei.esdk.csdemo.view.panel;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ResultPan extends JPanel
{
    /** * */
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private Rectangle rectangle;
    private JLabel isSuccess = new JLabel();
    private JLabel result = new JLabel();
    private JLabel successIcon = new JLabel();
    private JLabel failIcon = new JLabel();

    
    public ResultPan(Rectangle rectangle){

        this.rectangle = rectangle;
        this.setBounds(rectangle);
        this.setLayout(null);
        isSuccess.setBounds(35, 0, 100, rectangle.height);
        isSuccess.setHorizontalAlignment(SwingConstants.LEFT);
        result.setBounds(0, 0, rectangle.width, rectangle.height);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        successIcon.setIcon(new ImageIcon(DataBase.getInstance().getPath("online.png")));
        failIcon.setIcon(new ImageIcon(DataBase.getInstance().getPath("busy.png")));
        successIcon.setBounds(15, 18, 14, 14);
        failIcon.setBounds(15, 18, 14, 14);
        successIcon.setVisible(false);
        failIcon.setVisible(false);
//        successIcon.setBackground(Color.BLUE);
//        failIcon.setBackground(Color.red);
        isSuccess.setFont(FontConstants.normalFont);
        result.setFont(FontConstants.normalFont);
        this.add(successIcon);
        this.add(failIcon);
        this.add(isSuccess);
        this.add(result);
    }
    
    public void showResultMsg(boolean isSuccess,String msg){
        
        if(isSuccess)
        {
            successIcon.setVisible(true);
            failIcon.setVisible(false);
            this.isSuccess.setForeground(Color.blue);
            this.result.setForeground(Color.blue);
            this.result.setText(msg);
            this.isSuccess.setText(LabelText.bottom_show_result_panel_success[DataBase.getInstance().getLanguageFlag()]);
        }
        else
        {
            successIcon.setVisible(false);
            failIcon.setVisible(true);
            this.isSuccess.setForeground(Color.red);
            this.result.setForeground(Color.red);
            this.result.setText(msg);
            this.isSuccess.setText(LabelText.bottom_show_result_panel_error[DataBase.getInstance().getLanguageFlag()]);
        }
    }
}
