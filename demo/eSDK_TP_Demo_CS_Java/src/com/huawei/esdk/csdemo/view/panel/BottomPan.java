package com.huawei.esdk.csdemo.view.panel;


import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.PropertiesUtils;

public class BottomPan extends JPanel
{

    private static final long serialVersionUID = 1L;

    public BottomPan(Rectangle rectangle)
    {
        this.rectangle = rectangle;
        this.setLayout(null);
        this.setBounds(rectangle);
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    private Rectangle rectangle;

    private JLabel btm_userName = new JLabel("");

    private JLabel btm_connStastus = new JLabel();

    private JLabel btm_serverAddress = new JLabel();

    private JLabel btm_userName_val = new JLabel();

    private JLabel btm_connStastus_val = new JLabel();

    private JLabel btm_serverAddress_val = new JLabel();

    private JButton btm_exitLoginBut = new JButton();
    
    private JPanel userDetailPane = new JPanel();
    
    private List<JComponent> components = new ArrayList<JComponent>();

//    private JLabel showDescriptionLabel = new JLabel();
    
    private JEditorPane descriptionPane = new JEditorPane();
    
    private JPanel contPane = new JPanel();

    private int xx = 30;

    private int yy = 5;

    public void repaintCompomentName()
    {
    	contPane.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.btm_contPane[DataBase.getInstance().getLanguageFlag()]));

        btm_userName.setText(LabelText.btm_userName[DataBase.getInstance().getLanguageFlag()]);
        btm_connStastus
                .setText(LabelText.btm_connStastus[DataBase.getInstance().getLanguageFlag()]);
        btm_serverAddress
                .setText(LabelText.btm_serverAddress[DataBase.getInstance().getLanguageFlag()]);
        btm_exitLoginBut
                .setText(LabelText.btm_exitLoginBut[DataBase.getInstance().getLanguageFlag()]);
        btm_userName.setFont(FontConstants.normalFont);
        btm_connStastus.setFont(FontConstants.normalFont);
        btm_serverAddress.setFont(FontConstants.normalFont);
        btm_exitLoginBut.setFont(FontConstants.normalFont);
        btm_userName_val.setFont(FontConstants.normalFont);
        btm_connStastus_val.setFont(FontConstants.normalFont);
        btm_serverAddress_val.setFont(FontConstants.normalFont);
        descriptionPane.setFont(FontConstants.largeFont);
        descriptionPane.setEditable(false);
        this.repaint();
    }

    public void repaintComponentVal(String userName, String sonnStatus,
            String address)
    {

        btm_userName_val.setText(userName);
        btm_connStastus_val.setText(sonnStatus);
        btm_serverAddress_val.setText(address);
        this.repaint();
    }

    public void initCompomentBouds()
    {
        int width = this.rectangle.width - 2 * xx;
        int height = this.rectangle.height - 2 * yy;


//        btm_userName.setBounds(this.xx, this.yy, 80, 30);
//        btm_connStastus
//                .setBounds(this.xx, this.yy + (int) (height / 3), 80, 30);
//        btm_serverAddress.setBounds(this.xx, this.yy + (int) (2 * height / 3),
//                80, 30);
//
//        btm_userName_val.setBounds(this.xx + 100, this.yy, 80, 20);
//        btm_connStastus_val.setBounds(this.xx + 100, this.yy
//                + (int) (height / 3), 80, 30);
//        btm_serverAddress_val.setBounds(this.xx + 100, this.yy
//                + (int) (2 * height / 3), 380, 30);
//
//        btm_exitLoginBut.setBounds(this.xx + 200, this.yy + (int) (height / 3),
//                100, 25);

        contPane.setBounds(10, yy, width/2, height);
        descriptionPane.setBounds(10, 20, width/2 - 20, height- 30);
        
        userDetailPane.setBounds(this.rectangle.width/2 + 10, yy, width/2, height);
        
        Table table1 = new Table(width/2,height, 3, 3, new String[]{"33%","33%","33%"}, new String[]{"100","0","130"});
        
        Map<Integer,Integer> alignment1 = new HashMap<Integer,Integer>();
        alignment1.put(1, SwingConstants.LEFT);
        alignment1.put(3, SwingConstants.LEFT);
        alignment1.put(6, SwingConstants.LEFT);
        
        alignment1.put(0, SwingConstants.LEFT);
        alignment1.put(2, SwingConstants.LEFT);
        alignment1.put(5, SwingConstants.LEFT);

        
        table1.setAlignment(alignment1);
        
       List< Integer[]> bounds1 = new ArrayList< Integer[]>();
       bounds1.add( new Integer[]{0,0,1,1});
       bounds1.add( new Integer[]{0,1,1,2});
       
       bounds1.add( new Integer[]{1,0,1,1});
       bounds1.add( new Integer[]{1,1,1,1});
       bounds1.add( new Integer[]{1,2,1,1});
       
       bounds1.add( new Integer[]{2,0,1,1});
       bounds1.add( new Integer[]{2,1,1,2});

        
       new ComponentBoundsTool().getInitedBoundsComponent(components, bounds1, table1);
       
    }

    public void addCompomentToPanel()
    {

//        this.add(btm_userName_val);
//        this.add(btm_connStastus_val);
//        this.add(btm_serverAddress_val);
//        this.add(btm_exitLoginBut);
        this.setLayout(null);
        
        descriptionPane.setBackground(Color.white);
        contPane.setLayout(null);
        contPane.add(descriptionPane);
        this.add(contPane);
        
//        this.add(btm_userName);
//        this.add(btm_connStastus);
//        this.add(btm_serverAddress);
        userDetailPane.setLayout(null);
        for(JComponent jct : components){
            userDetailPane.add(jct);
        }

        this.add(userDetailPane);
    }

    public void createPanel()
    {
        addComponentToList();
        repaintCompomentName();
        initCompomentBouds();
        addCompomentToPanel();

        int loginStatus = DataBase.getInstance().getLoginStatus();
        // to do enum and guojihua
        String loginStatusStr = (loginStatus == 1 ? LabelText.btm_connStatus_online[DataBase.getInstance().getLanguageFlag()] : LabelText.btm_connStatus_offline[DataBase.getInstance().getLanguageFlag()]);

        repaintComponentVal(DataBase.getInstance().getUserName(), loginStatusStr,
                PropertiesUtils.getValue("sdkserver.url"));
    }
    
    public void addComponentToList(){
        components.add(btm_userName);
        components.add(btm_userName_val);
        components.add(btm_connStastus);
        components.add(btm_connStastus_val);
        components.add(btm_exitLoginBut);
        components.add(btm_serverAddress);
        components.add(btm_serverAddress_val);
    }

    public Rectangle getRectangle()
    {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    public JButton getBtm_exitLoginBut()
    {
        return btm_exitLoginBut;
    }

	public JLabel getBtm_userName() {
		return btm_userName;
	}

	public JLabel getBtm_connStastus() {
		return btm_connStastus;
	}

	public JLabel getBtm_serverAddress() {
		return btm_serverAddress;
	}

	public JLabel getBtm_userName_val() {
		return btm_userName_val;
	}

	public JLabel getBtm_connStastus_val() {
		return btm_connStastus_val;
	}

	public JLabel getBtm_serverAddress_val() {
		return btm_serverAddress_val;
	}

	public JEditorPane getDescriptionPane() {
		return descriptionPane;
	}

	public JPanel getContPane() {
		return contPane;
	}
    
}
