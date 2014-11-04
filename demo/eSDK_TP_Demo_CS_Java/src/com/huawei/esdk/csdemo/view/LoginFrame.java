package com.huawei.esdk.csdemo.view;

import java.awt.AWTEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.listener.LoginFrameListener;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class LoginFrame extends JFrame
{
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private String userName;

    private int loginStatus = 0;

    // private JFrame loginFrame;
    private JLabel uernameLabel = new JLabel();

    private JLabel passwordLabel = new JLabel();

    private JLabel keepAliveLabel = new JLabel();

    private JLabel keepAlivePLabel = new JLabel();

    private JLabel miaoLabel = new JLabel();

    private JLabel descriptionLabel = new JLabel();

    private JCheckBox keepAliveCb = new JCheckBox();

    private JComboBox keepAlivePJCB = new JComboBox();

    private JTextField uernameText = new JTextField();

    private JPasswordField passwordText = new JPasswordField();
    
    private JLabel laguageLabel = new JLabel();
    private JPanel radioContentLabel = new JPanel();
    private JRadioButton chineseRadio = new JRadioButton();
    private JRadioButton englishRadio = new JRadioButton();
    private ButtonGroup btnGroup = new ButtonGroup();
    
    private List<JComponent> components = new ArrayList<JComponent>();

    private JButton loginBut = new JButton();

    private JButton closeBut = new JButton();


    public LoginFrame()
    {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }

    protected void processWindowEvent(WindowEvent e)
    {
        if (e.getID() == WindowEvent.WINDOW_CLOSING)
        {
//            new LocalDataKeeper().saveDataInLocal();

            System.exit(1);
        }
        else
        {
            super.processWindowEvent(e);
        }
    }

    public void lunchFrame()
    {
        addComponentToList();
        initPanelText();
        initPanelBonds();
        addPanelToFrame();
        LoginFrameListener loginListener = new LoginFrameListener();
        loginListener.registerListener(this);
    }

    @SuppressWarnings("deprecation")
    public void initPanelText()
    {
        this.setTitle(LabelText.loginFrame_title[DataBase.getInstance().getLanguageFlag()]);

        uernameLabel.setText(LabelText.loginFrame_userName[DataBase.getInstance().getLanguageFlag()]);
        passwordLabel.setText(LabelText.loginFrame_userPswd[DataBase.getInstance().getLanguageFlag()]);
        keepAliveLabel.setText(LabelText.loginFrame_keepAlive[DataBase.getInstance().getLanguageFlag()]);
        keepAlivePLabel
                .setText(LabelText.loginFrame_keepAlivePeriod[DataBase.getInstance().getLanguageFlag()]);
        miaoLabel.setText(LabelText.loginFrame_miao[DataBase.getInstance().getLanguageFlag()]);
        descriptionLabel
                .setText(LabelText.loginFrame_description[DataBase.getInstance().getLanguageFlag()]);
        descriptionLabel.setFont(FontConstants.smallFont);

        loginBut.setText(LabelText.loginFrame_loginBut[DataBase.getInstance().getLanguageFlag()]);
        closeBut.setText(LabelText.loginFrame_closeBut[DataBase.getInstance().getLanguageFlag()]);

        laguageLabel.setText(LabelText.loginFrame_menuLanguage[DataBase.getInstance().getLanguageFlag()]);
        
        
        chineseRadio.setLabel("中文");
        englishRadio.setLabel("English");

    }

    public void initPanelBonds()
    {

//        uernameLabel.setBounds(30, 50, 80, 20);
//        uernameText.setBounds(100, 50, 200, 20);
//
//        passwordLabel.setBounds(30, 90, 80, 20);
//        passwordText.setBounds(100, 90, 200, 20);
//
//        keepAliveCb.setBounds(30, 130, 20, 20);
//        keepAliveLabel.setBounds(60, 130, 60, 20);
//
//        keepAlivePLabel.setBounds(130, 130, 80, 20);
//        keepAlivePJCB.setBounds(200, 130, 80, 20);
//        miaoLabel.setBounds(290, 130, 20, 20);
//        keepAlivePJCB.setAlignmentX(SwingConstants.CENTER);
        radioContentLabel.add(chineseRadio);
        radioContentLabel.add(englishRadio);
        
 Table table1 = new Table(350,250, 5, 5, new String[]{"15%","20%","20%","20%","20%"}, new String[]{"30","80","100","0","50"});
        
        Map<Integer,Integer> alignment1 = new HashMap<Integer,Integer>();
        alignment1.put(0, SwingConstants.LEFT);
        alignment1.put(2, SwingConstants.LEFT);
        alignment1.put(4, SwingConstants.LEFT);
        
        alignment1.put(6, SwingConstants.LEFT);
        alignment1.put(7, SwingConstants.LEFT);

        
        table1.setAlignment(alignment1);
        
       List< Integer[]> bounds1 = new ArrayList< Integer[]>();
       bounds1.add( new Integer[]{1,1,1,1});
       bounds1.add( new Integer[]{1,2,1,2});
       
       bounds1.add( new Integer[]{2,1,1,1});
       bounds1.add( new Integer[]{2,2,1,2});
       
       bounds1.add( new Integer[]{3,1,1,1});
       bounds1.add( new Integer[]{3,2,1,1});
       bounds1.add( new Integer[]{3,3,1,1});
       
       bounds1.add( new Integer[]{4,1,1,1});
       bounds1.add( new Integer[]{4,2,1,2});
//       bounds1.add( new Integer[]{3,3,1,1});

        
       new ComponentBoundsTool().getInitedBoundsComponent(components, bounds1, table1);
        

        loginBut.setBounds(50, 250, 80, 25);

        closeBut.setBounds(200, 250, 80, 25);

        descriptionLabel.setBounds(30, 280, 290, 100);
    }

    public void addPanelToFrame()
    {

        // need to move
        uernameText.setText("esdk_user");
        passwordText.setText("Huawei@123");
        //

        for (int i = 30; i < 60; i++)
        {
            keepAlivePJCB.addItem("    "+i);
        }
        keepAlivePJCB.setEnabled(true);
        
        keepAliveCb.setSelected(true);
        keepAliveCb.setVisible(false);

        this.setLayout(null);
        this.setBounds(500, 300, 350, 400);
 
        for(JComponent jcp : components)
        {
            this.add(jcp);
        }
        
        radioContentLabel.setLocation(radioContentLabel.getX() - 20, radioContentLabel.getY());
        
        this.add(loginBut);
        this.add(closeBut);
        this.add(descriptionLabel);

        this.setResizable(false);
//        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void addComponentToList()
    {
        
        components.add(uernameLabel);
        components.add(uernameText);

        components.add(passwordLabel);
        components.add(passwordText);


        components.add(keepAlivePLabel);
        components.add(keepAlivePJCB);
        components.add(miaoLabel);

        components.add(laguageLabel);
        components.add(radioContentLabel);
//        components.add(englishRadio);
    }
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setLoginStatus(int loginStatus)
    {
        this.loginStatus = loginStatus;
    }

    public int getLoginStatus()
    {
        return loginStatus;
    }

    public JComboBox getKeepAlivePJCB()
    {
        return keepAlivePJCB;
    }

    public void setKeepAlivePJCB(JComboBox keepAlivePJCB)
    {
        this.keepAlivePJCB = keepAlivePJCB;
    }

    public JTextField getUernameText()
    {
        return uernameText;
    }

    public void setUernameText(JTextField uernameText)
    {
        this.uernameText = uernameText;
    }

    public JPasswordField getPasswordText()
    {
        return passwordText;
    }

    public void setPasswordText(JPasswordField passwordText)
    {
        this.passwordText = passwordText;
    }

    public JButton getLoginBut()
    {
        return loginBut;
    }

    public JButton getCloseBut()
    {
        return closeBut;
    }

    public JCheckBox getKeepAliveCb()
    {
        return keepAliveCb;
    }

    public JLabel getUernameLabel()
    {
        return uernameLabel;
    }

    public void setUernameLabel(
        JLabel uernameLabel)
    {
        this.uernameLabel = uernameLabel;
    }

    public JLabel getPasswordLabel()
    {
        return passwordLabel;
    }

    public void setPasswordLabel(
        JLabel passwordLabel)
    {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getKeepAliveLabel()
    {
        return keepAliveLabel;
    }

    public void setKeepAliveLabel(
        JLabel keepAliveLabel)
    {
        this.keepAliveLabel =
            keepAliveLabel;
    }

    public JLabel getKeepAlivePLabel()
    {
        return keepAlivePLabel;
    }

    public void setKeepAlivePLabel(
        JLabel keepAlivePLabel)
    {
        this.keepAlivePLabel =
            keepAlivePLabel;
    }

    public JLabel getMiaoLabel()
    {
        return miaoLabel;
    }

    public void setMiaoLabel(
        JLabel miaoLabel)
    {
        this.miaoLabel = miaoLabel;
    }

    public JLabel getDescriptionLabel()
    {
        return descriptionLabel;
    }

    public void setDescriptionLabel(
        JLabel descriptionLabel)
    {
        this.descriptionLabel =
            descriptionLabel;
    }

    public JLabel getLaguageLabel()
    {
        return laguageLabel;
    }

    public void setLaguageLabel(
        JLabel laguageLabel)
    {
        this.laguageLabel = laguageLabel;
    }

    public JPanel getRadioContentLabel()
    {
        return radioContentLabel;
    }

    public void setRadioContentLabel(
        JPanel radioContentLabel)
    {
        this.radioContentLabel =
            radioContentLabel;
    }

    public JRadioButton getChineseRadio()
    {
        return chineseRadio;
    }

    public void setChineseRadio(
        JRadioButton chineseRadio)
    {
        this.chineseRadio = chineseRadio;
    }

    public JRadioButton getEnglishRadio()
    {
        return englishRadio;
    }

    public void setEnglishRadio(
        JRadioButton englishRadio)
    {
        this.englishRadio = englishRadio;
    }

    public ButtonGroup getBtnGroup()
    {
        return btnGroup;
    }

    public void setBtnGroup(
        ButtonGroup btnGroup)
    {
        this.btnGroup = btnGroup;
    }

    public void setComponents(
        List<JComponent> components)
    {
        this.components = components;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    public void setKeepAliveCb(
        JCheckBox keepAliveCb)
    {
        this.keepAliveCb = keepAliveCb;
    }

    public void setLoginBut(JButton loginBut)
    {
        this.loginBut = loginBut;
    }

    public void setCloseBut(JButton closeBut)
    {
        this.closeBut = closeBut;
    }


}
