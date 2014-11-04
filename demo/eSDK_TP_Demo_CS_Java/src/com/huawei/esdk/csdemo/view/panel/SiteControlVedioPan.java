package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.FontConstants;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.memorydb.DataBase;


public class SiteControlVedioPan extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;

	private int xx = 10;
	private int yy = 10;
	private JPanel part1 = new JPanel();
	private JPanel part2 = new JPanel();
	private JPanel part3 = new JPanel();

	private JPanel vedioPanel = new JPanel();
	private JLabel koalaPic = new JLabel();

	private JLabel bg_panel = new JLabel();
	private JLabel up = new JLabel();
	private JLabel down = new JLabel();
	private JLabel left = new JLabel();
	private JLabel right = new JLabel();
	private JLabel center = new JLabel();
	private JButton focusBut = new JButton("crolfocus");

	private JCheckBox connAuxStreamCK = new JCheckBox();
	private JLabel connAuxStreamLabel = new JLabel();
	
	private JCheckBox sendAuxStreamCK = new JCheckBox();
	private JLabel sendAuxStreamLabel = new JLabel();
	
	private JLabel mainStreamLabel = new JLabel();
	private JComboBox mainStreamJC = new JComboBox();
	
	private JLabel auxStreamLabel = new JLabel();
    private JComboBox auxStreamJC = new JComboBox();

    private JButton sendAuxStreamBtn = new JButton();
    
    private List<JComponent> part3List = new ArrayList<JComponent>();
    
	private Icon bg_pabel_icon = new ImageIcon(DataBase.getInstance().getPath("bg-camera-ctrl.png"));
	private Icon up_pabel_icon = new ImageIcon(DataBase.getInstance().getPath("cameractrl-top-normal.png"));
	private Icon up_pabel_icon1 = new ImageIcon(DataBase.getInstance().getPath("cameractrl-top-over.png"));
	private Icon down_pabel_icon = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-bottom-normal.png"));
	private Icon down_pabel_icon1 = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-bottom-over.png"));
	private Icon left_pabel_icon = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-left-normal.png"));
	private Icon left_pabel_icon1 = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-left-over.png"));
	private Icon right_pabel_icon = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-right-normal.png"));
	private Icon right_pabel_icon1 = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-right-over.png"));
	private Icon center_pabel_icon = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-center-normal.png"));
	private Icon center_pabel_icon1 = new ImageIcon(
			DataBase.getInstance().getPath("cameractrl-center-over.png"));

	
	
	public SiteControlVedioPan(Rectangle rectangle) {
		this.rectangle = rectangle;
		this.setLayout(null);
	}

	public void repaintCompomentName() {
		part1.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.siteCtol_video_part1_border[DataBase.getInstance().getLanguageFlag()]));

		part2.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.siteCtol_video_part2_border[DataBase.getInstance().getLanguageFlag()]));
		part3.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.siteCtol_video_part3_border[DataBase.getInstance().getLanguageFlag()]));

		
//		koalaPic.setIcon(new ImageIcon(DataBase.path + "Koala.jpg"));

		bg_panel.setIcon(bg_pabel_icon);

		up.setIcon(up_pabel_icon);
		up.setToolTipText(LabelText.siteCtol_video_up[DataBase.getInstance().getLanguageFlag()]);

		down.setIcon(down_pabel_icon);
		down.setToolTipText(LabelText.siteCtol_video_down[DataBase.getInstance().getLanguageFlag()]);

		left.setIcon(left_pabel_icon);
		left.setToolTipText(LabelText.siteCtol_video_left[DataBase.getInstance().getLanguageFlag()]);

		right.setIcon(right_pabel_icon);
		right.setToolTipText(LabelText.siteCtol_video_right[DataBase.getInstance().getLanguageFlag()]);

		center.setIcon(center_pabel_icon);
		center.setToolTipText(LabelText.siteCtol_video_center[DataBase.getInstance().getLanguageFlag()]);

		connAuxStreamLabel.setText(LabelText.siteCtol_video_connAuxStreamLabel[DataBase.getInstance().getLanguageFlag()]);
		sendAuxStreamLabel.setText(LabelText.siteCtol_video_sendAuxStreamLabel[DataBase.getInstance().getLanguageFlag()]);
		
		mainStreamLabel.setText(LabelText.siteCtol_video_mainStreamLabel[DataBase.getInstance().getLanguageFlag()]);

		auxStreamLabel.setText(LabelText.siteCtol_video_auxStreamLabel[DataBase.getInstance().getLanguageFlag()]);
		
	    sendAuxStreamBtn.setText(LabelText.siteCtol_video_sendAuxStreamBtn_start[DataBase.getInstance().getLanguageFlag()]);
	}

	public void initCompomentBouds() {
		int partHeight = this.rectangle.height - yy * 2;
		int partWidth = this.rectangle.width - xx * 2 - 30;
		int part1Width = partWidth / 2;
		int part2Width = partWidth / 4;
		int part3Width = partWidth / 4;

		part1.setLayout(null);
		part1.setBounds(xx, yy, part1Width, partHeight);

		vedioPanel.setLayout(null);
		vedioPanel.setBorder(BorderFactory.createEtchedBorder());
		vedioPanel.setBounds(20, 20, part1Width - 40, partHeight - 40);

//		int picWidth = koalaPic.getIcon().getIconWidth();
//		int picHeight = koalaPic.getIcon().getIconHeight();
		koalaPic.setFont(FontConstants.largeFont);
		koalaPic.setBounds((part1Width - 40 - 200)/2, (partHeight - 40-50)/2, 200, 50);
		koalaPic.setHorizontalAlignment(SwingConstants.CENTER);
		vedioPanel.add(koalaPic);
		part1.add(vedioPanel);

		part2.setBounds(xx + part1Width + 15, yy, part2Width, partHeight);
		part3.setBounds(xx + part1Width + part2Width + 30, yy, part3Width,
				partHeight);

		int bg_size = 100;
		int flag = 30;
		int butWidth = 60;
		int butHeight = 30;
		int centerSize = 43;
		bg_panel.setBounds((part2Width - bg_size) / 2,
				(partHeight - bg_size) / 2, bg_size, bg_size);
		up.setBounds((bg_size - butWidth) / 2,
				(bg_size - butHeight) / 2 - flag, butWidth, butHeight);
		down.setBounds((bg_size - butWidth) / 2, (bg_size - butHeight) / 2
				+ flag, butWidth, butHeight);
		left.setBounds((bg_size - butHeight) / 2 - flag,
				(bg_size - butWidth) / 2, butHeight, butWidth);
		right.setBounds((bg_size - butHeight) / 2 + flag,
				(bg_size - butWidth) / 2, butHeight, butWidth);
		center.setBounds((bg_size - centerSize) / 2,
				(bg_size - centerSize) / 2, centerSize, centerSize);
		this.setBounds(this.rectangle);

		// center.getInputVerifier()
		// up.get
		// up.addMouseListener(this);
		// ActionMap acMap =new ActionMap();
		// Action ac = new Action();
		// ac.
		// acMap.put(arg0, arg1)
		// up.setActionMap(am)
		// down.addMouseListener(this);
		// left.addMouseListener(this);
		// right.addMouseListener(this);
		// center.addMouseListener(this);
		
		String column2 = "50";
		String column3 = "50";
		
		if(0 !=  DataBase.getInstance().getLanguageFlag()){
		     column2 = "70";
		     column3 = "90";
		}

	      Table table1 = new Table(part3Width,partHeight, 5, 4, new String[]{"40","40","40","40","40"}, new String[]{"30",column2,column3,"0"});
	        
          Map<Integer,Integer> alignment1 = new HashMap<Integer,Integer>();
          alignment1.put(1, SwingConstants.LEFT);
          alignment1.put(3, SwingConstants.LEFT);
          table1.setAlignment(alignment1);
          
         List< Integer[]> bounds1 = new ArrayList< Integer[]>();
         bounds1.add( new Integer[]{0,0,1,1});
         bounds1.add( new Integer[]{0,1,1,3});
         
         bounds1.add( new Integer[]{1,0,1,1});
         bounds1.add( new Integer[]{1,1,1,3});
         
         bounds1.add( new Integer[]{2,0,1,2});
         bounds1.add( new Integer[]{2,2,1,2});
         
         bounds1.add( new Integer[]{3,0,1,2});
         bounds1.add( new Integer[]{3,2,1,2});
         
         bounds1.add( new Integer[]{4,0,1,3});

          
         new ComponentBoundsTool().getInitedBoundsComponent(part3List, bounds1, table1);
         
		
//		connAuxStreamCK.setBounds(xx, yy + 10, 25, 25);
//		connAuxStreamLabel.setBounds(xx + 25, yy + 10, 120, 25);
//		sendAuxStreamCK.setBounds(xx, yy + 45, 25, 25);
//		sendAuxStreamLabel.setBounds(xx + 25, yy + 45, 120, 25);
//		mainStreamLabel.setBounds(xx, yy + 80, 80, 25);
//		mainStreamJC.setBounds(xx + 80, yy + 80, 100, 25);
//		
//	    auxStreamLabel.setBounds(xx, yy + 120, 80, 25);
//	    auxStreamJC.setBounds(xx + 80, yy + 120, 100, 25);
//	    
//	    sendAuxStreamBtn.setBounds(xx, yy + 150, 120, 25);
	}

	public void addCompomentToPanel() {

		this.add(part1);
		this.add(part2);
		this.add(part3);

		// part2
		part2.setLayout(null);
//		focusBut.setBounds(0, 0, 10, 10);
//		part2.add(focusBut);
		part2.add(bg_panel);
		bg_panel.setLayout(null);
		bg_panel.add(up);
		bg_panel.add(down);
		bg_panel.add(left);
		bg_panel.add(right);
		bg_panel.add(center);
		part2.setFocusable(true);
		// part3
		part3.setLayout(null);
		part3.add(connAuxStreamCK);
		part3.add(connAuxStreamLabel);
		part3.add(sendAuxStreamCK);
		part3.add(sendAuxStreamLabel);
		part3.add(mainStreamLabel);
		part3.add(mainStreamJC);
	    part3.add(auxStreamLabel);
	    part3.add(auxStreamJC);
	    part3.add(sendAuxStreamBtn);
	        
	        connAuxStreamCK.setEnabled(false);
	        sendAuxStreamCK.setEnabled(false);
	        
	        
	}

	public void repaintComponentVal() {

	}

	public void createPanel() {
	    addComponentToList();
		repaintCompomentName();
		initCompomentBouds();
		addCompomentToPanel();
		repaintComponentVal();
//		new SiteControlMouseListener().addListenerForCemeraCtrolPan();
//		new SiteControlKeyListener().addListenerForCemeraCtrolPan(this);
	}

	public void addComponentToList(){

	       part3List.add(connAuxStreamCK);
	       part3List.add(connAuxStreamLabel);
	       part3List.add(sendAuxStreamCK);
	       part3List.add(sendAuxStreamLabel);
           part3List.add(auxStreamLabel);
           part3List.add(auxStreamJC);
           
	       part3List.add(mainStreamLabel);
	       part3List.add(mainStreamJC);

	       part3List.add(sendAuxStreamBtn);
	}
	public Rectangle getRectangle() {
		return rectangle;
	}

	public JPanel getPart1() {
		return part1;
	}

	public JPanel getPart2() {
		return part2;
	}

	public JPanel getPart3() {
		return part3;
	}

	public JPanel getVedioPanel() {
		return vedioPanel;
	}

	public JLabel getKoalaPic() {
		return koalaPic;
	}

	public JLabel getBg_panel() {
		return bg_panel;
	}

	public JLabel getUp() {
		return up;
	}

	public JLabel getDown() {
		return down;
	}

	public JLabel getLeft() {
		return left;
	}

	public JLabel getRight() {
		return right;
	}

	public JLabel getCenter() {
		return center;
	}

	public JButton getFocusBut() {
		return focusBut;
	}

	public JCheckBox getConnAuxStreamCK() {
		return connAuxStreamCK;
	}

	public JLabel getConnAuxStreamLabel() {
		return connAuxStreamLabel;
	}

	public JCheckBox getSendAuxStreamCK() {
		return sendAuxStreamCK;
	}

	public JLabel getSendAuxStreamLabel() {
		return sendAuxStreamLabel;
	}

	public JLabel getMainStreamLabel() {
		return mainStreamLabel;
	}

	public JComboBox getMainStreamJC() {
		return mainStreamJC;
	}

	public Icon getBg_pabel_icon() {
		return bg_pabel_icon;
	}

	public Icon getUp_pabel_icon() {
		return up_pabel_icon;
	}

	public Icon getUp_pabel_icon1() {
		return up_pabel_icon1;
	}

	public Icon getDown_pabel_icon() {
		return down_pabel_icon;
	}

	public Icon getDown_pabel_icon1() {
		return down_pabel_icon1;
	}

	public Icon getLeft_pabel_icon() {
		return left_pabel_icon;
	}

	public Icon getLeft_pabel_icon1() {
		return left_pabel_icon1;
	}

	public Icon getRight_pabel_icon() {
		return right_pabel_icon;
	}

	public Icon getRight_pabel_icon1() {
		return right_pabel_icon1;
	}

	public Icon getCenter_pabel_icon() {
		return center_pabel_icon;
	}

	public Icon getCenter_pabel_icon1() {
		return center_pabel_icon1;
	}

    public JLabel getAuxStreamLabel()
    {
        return auxStreamLabel;
    }

    public JComboBox getAuxStreamJC()
    {
        return auxStreamJC;
    }

    public JButton getSendAuxStreamBtn()
    {
        return sendAuxStreamBtn;
    }



}
