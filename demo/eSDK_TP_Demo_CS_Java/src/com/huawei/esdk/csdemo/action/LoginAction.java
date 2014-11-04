package com.huawei.esdk.csdemo.action;

import java.awt.Rectangle;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.AuthorizeService;
import com.huawei.esdk.csdemo.view.LoginFrame;
import com.huawei.esdk.csdemo.view.MainFrame;
import com.huawei.esdk.csdemo.view.DemoApp;

public class LoginAction
{
    protected final static Logger LOGGER = Logger.getLogger(LoginAction.class);
    
    private AuthorizeService authorizeService = new AuthorizeService();

    private LoginFrame frame;

    public LoginAction(LoginFrame frame)
    {
        this.frame = frame;
    }

    public void login()
    {
        String userName = frame.getUernameText().getText();
        String password = new String(frame.getPasswordText().getPassword());

        try {
            Integer result = authorizeService.login(userName, password);
            if (0 != result)
            {
                JOptionPane.showConfirmDialog(frame, result, "error",
                        JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION);
                return;
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(frame, LabelText.connect_error[DataBase.getInstance().getLanguageFlag()],"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // this.userName = userName;
        // this.loginStatus = 1;
        DataBase.getInstance().setUserName(userName);
        DataBase.getInstance().setLoginStatus(1);

        String aliveRate = frame.getKeepAlivePJCB().getSelectedItem()
                .toString().trim();

        authorizeService.keepAlive(Integer.parseInt(aliveRate));

        frame.setVisible(false);
        DemoApp.progressFrame.setVisible(true);
        DemoApp.progressFrame.showProgressMessage("begining to paint main frame...");
        
        Rectangle rect = new Rectangle(100, 100, 1024, 808);
        DemoApp.mainFrame = new MainFrame(rect);
        DemoApp.mainFrame.lunchFrame();
    }
}
