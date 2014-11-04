package com.huawei.esdk.csdemo.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import com.huawei.esdk.csdemo.action.LoginAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.LoginFrame;

public class LoginFrameListener
{
    private LoginFrame frame;

    private LoginAction loginAction;

    public void registerListener(LoginFrame frame)
    {
        this.frame = frame;
        this.loginAction = new LoginAction(frame);
        addLoginListener();
        addCloseListener();
        addKeepLiveCBListener();
        addMenuChineseListener();
        addMenuEnglishListener();
    }

    /**
     * 注册登录事件监听
     */
    private void addLoginListener()
    {
        frame.getLoginBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                loginAction.login();
            }
        });
    }

    /**
     * 注册关闭监听
     */
    private void addCloseListener()
    {
        frame.getCloseBut().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
//                new LocalDataKeeper().saveDataInLocal();
                System.exit(0);
            }
        });
    }

    /**
     * 注册是否启动心跳checkbox事件监听
     */
    private void addKeepLiveCBListener()
    {
        frame.getKeepAliveCb().addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (frame.getKeepAliveCb().isSelected())
                {
                    frame.getKeepAlivePJCB().setEnabled(true);
                }
                else
                {
                    frame.getKeepAlivePJCB().setEnabled(false);
                }
            }
        });
    }

    private void addMenuChineseListener()
    {
        frame.getChineseRadio().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.getChineseRadio().setSelected(true);
                frame.getEnglishRadio().setSelected(false);
                DataBase.getInstance().setLanguageFlag(0);
                frame.initPanelText();
            }
        });
    }
    
    private void addMenuEnglishListener()
    {
        frame.getEnglishRadio().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {                
                frame.getChineseRadio().setSelected(false);
                frame.getEnglishRadio().setSelected(true);
                DataBase.getInstance().setLanguageFlag(1);
                frame.initPanelText();
            }
        });

    }
    
    
}
