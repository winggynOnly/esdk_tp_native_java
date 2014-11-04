package com.huawei.esdk.csdemo.view;

import java.awt.AWTEvent;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import org.apache.log4j.Logger;

import com.huawei.esdk.csdemo.action.InitialDefaultDataAction;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.listener.ConfCtrolMouseListener;
import com.huawei.esdk.csdemo.listener.SiteControlMouseListener;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.AuthorizeService;
import com.huawei.esdk.csdemo.view.panel.ConfControlPanel;
import com.huawei.esdk.csdemo.view.panel.ConfManagerPanel;
import com.huawei.esdk.csdemo.view.panel.SiteControlPanel;




public class MainFrame extends JFrame
{
    private final static Logger LOGGER = Logger.getLogger(MainFrame.class);
    
    private AuthorizeService authorizeService = new AuthorizeService();

    private static final long serialVersionUID = 1L;

    private JTabbedPane jtabPane = new JTabbedPane();

    private ConfManagerPanel pan1;

    private ConfControlPanel pan2;

    private SiteControlPanel pan3;

    private Rectangle rectangle;

    public MainFrame(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        pan1 = new ConfManagerPanel(rectangle);
        pan2 = new ConfControlPanel(rectangle);
        pan3 = new SiteControlPanel(rectangle);
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    /**
     *  监听关闭
     * * @see javax.swing.JFrame#processWindowEvent(java.awt.event.WindowEvent)
     */
    protected void processWindowEvent(WindowEvent e)
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
        {
            int option = JOptionPane.showConfirmDialog(this, LabelText.JOptionPane_window_close_content[DataBase.getInstance().getLanguageFlag()],
                LabelText.JOptionPane_window_close_title[DataBase.getInstance().getLanguageFlag()], JOptionPane.OK_CANCEL_OPTION);
            if (JOptionPane.OK_OPTION == option)
            {
                // 点击了确定按钮
                authorizeService.logout();
                LOGGER.debug("关闭窗口");

//                new LocalDataKeeper().saveDataInLocal();

                System.exit(1);
            }
        }
        else
        {
            super.processWindowEvent(e);
        }
    }

    public void lunchFrame()
    {
        this.setTitle(LabelText.mainframe_title[DataBase.getInstance().getLanguageFlag()]);
        this.setResizable(false);
        pan1.createPanel();
        pan2.createPanel();
        pan3.createPanel();
        
        jtabPane.add(LabelText.mainframe_tab_confMgr_title[DataBase.getInstance().getLanguageFlag()], pan1);
        jtabPane.add(LabelText.mainframe_tab_confCtrl_title[DataBase.getInstance().getLanguageFlag()], pan2);
        jtabPane.add(LabelText.mainframe_tab_siteMgr_title[DataBase.getInstance().getLanguageFlag()], pan3);
        this.add(jtabPane);
        this.setBounds(this.rectangle);
//        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        InitialDefaultDataAction initdefaultDataAction = new InitialDefaultDataAction();
//        initdefaultDataAction.initDefaultData();
        new MethodThread(initdefaultDataAction,"initDefaultData").start();

		ConfCtrolMouseListener confCtrolMouseLisn = new ConfCtrolMouseListener();
		confCtrolMouseLisn.registerListener(this.getPan2());
		
		SiteControlMouseListener siteCtrolMouseLisn = new SiteControlMouseListener();
		siteCtrolMouseLisn.registerListener(this.getPan3());
    }

//    public void initTabText()
//    {
//        this.setTitle("主界面");
//        jtabPane.setTitleAt(0, "会议调度");
//        jtabPane.setTitleAt(1, "会议调度");
//        jtabPane.setTitleAt(2, "会场控制");
//    }

    public void initPanelBouds()
    {
        // pan1 = new ConfManagerPanel(this.rectangle);
    }

    public void addPanelToFrame()
    {
        this.setLayout(null);
        this.add(jtabPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ConfManagerPanel getPan1()
    {
        return pan1;
    }

    public ConfControlPanel getPan2()
    {
        return pan2;
    }

    public SiteControlPanel getPan3()
    {
        return pan3;
    }

}
