package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.enums.ContinuousPresenceMode;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ConfControlBottomPan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Rectangle rectangle;
	private int xx = 10;
	private int yy = 10;
	private JPanel leftPanel = new JPanel();
	private JLabel siteUriLabel = new JLabel();
	private JTextField siteUriText = new JTextField();
	private JLabel videoSourceUriLabel = new JLabel();
	private JTextField videoSourceUriText = new JTextField();
	private JButton leftSettingBut = new JButton();
	private List<JComponent> leftComponents = new ArrayList<JComponent>();

	private JPanel rightPanel = new JPanel();
	private JLabel duohuamianUriLabel = new JLabel();
	private JTextField duohuamianUriText = new JTextField("0");
	private JLabel duohuamianTypeLabel = new JLabel();
	private JComboBox duohuamianTypeText = new JComboBox();
	private JButton rightSettingBut = new JButton();
    private List<JComponent> rightComponents = new ArrayList<JComponent>();
    
	public ConfControlBottomPan(Rectangle rectangle) {
		this.rectangle = rectangle;
		this.setLayout(null);
	}

	public void repaintCompomentName() {
		leftPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.confCtol_bottom_leftPanel_border[DataBase.getInstance().getLanguageFlag()]));
		siteUriLabel.setText(LabelText.confCtol_bottom_siteUriLabel[DataBase.getInstance().getLanguageFlag()]);

		videoSourceUriLabel.setText(LabelText.confCtol_bottom_videoSourceUriLabel[DataBase.getInstance().getLanguageFlag()]);

		leftSettingBut.setText(LabelText.confCtol_bottom_leftSetBut[DataBase.getInstance().getLanguageFlag()]);

		rightPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.confCtol_bottom_rightPanel_border[DataBase.getInstance().getLanguageFlag()]));
		
		duohuamianUriLabel.setText(LabelText.confCtol_bottom_duohuamianUriLabel[DataBase.getInstance().getLanguageFlag()]);

		duohuamianTypeLabel.setText(LabelText.confCtol_bottom_duohuamianTypeLabel[DataBase.getInstance().getLanguageFlag()]);

		rightSettingBut.setText(LabelText.confCtol_bottom_rightSetBut[DataBase.getInstance().getLanguageFlag()]);
	}

	public void initCompomentBouds() {

		int widgetWidth = (this.rectangle.width - 10 - 2 * xx) / 2;
		int widgetHeight = this.rectangle.height - 2 * yy;

		leftPanel.setBounds(xx, yy, widgetWidth, widgetHeight);
	    rightPanel.setBounds(xx + widgetWidth + 10, yy, widgetWidth,widgetHeight);
	    

		int lbwidth = 0;
		if(0 == DataBase.getInstance().getLanguageFlag()){
		    lbwidth = 90;
		}else{
		    lbwidth = 180;
		}
		
	     Table table1 = new Table(widgetWidth,widgetHeight, 3, 4, new String[]{"40","40","40"}, new String[]{String.valueOf(lbwidth),"0","40","130"});

         List< Integer[]> bounds1 = new ArrayList< Integer[]>();
         bounds1.add( new Integer[]{0,0,1,1});
         bounds1.add( new Integer[]{0,2,1,2});
         bounds1.add( new Integer[]{1,0,1,1});
         bounds1.add( new Integer[]{1,2,1,2});
         bounds1.add( new Integer[]{2,3,1,1});
          
         new ComponentBoundsTool().getInitedBoundsComponent(this.leftComponents, bounds1, table1);
         
         new ComponentBoundsTool().getInitedBoundsComponent(this.rightComponents, bounds1, table1);

	}

	public void addCompomentToPanel() {
		this.setBounds(this.rectangle);
		this.add(leftPanel);
		leftPanel.setLayout(null);
		for(JComponent jcpt: leftComponents){
		    leftPanel.add(jcpt);
		}


	    siteUriText.setEditable(false);

	    int i = 0;
		for(ContinuousPresenceMode item :ContinuousPresenceMode.values()){
		    ItemObject selectItem = new ItemObject();
		    selectItem.setKey(String.valueOf(i));
		    selectItem.setValue(item.value());
			duohuamianTypeText.addItem(selectItem);
			i++;
		}

		this.add(rightPanel);
		rightPanel.setLayout(null);
		for(JComponent jcpt : rightComponents){
		    rightPanel.add(jcpt);
		}

	}

	public void repaintComponentVal() {

	}

	public void createPanel() {
	    addComponentToList();
		repaintCompomentName();
		initCompomentBouds();
		addCompomentToPanel();
		repaintComponentVal();
	}

	private void addComponentToList(){

	    leftComponents.add(siteUriLabel);
	    leftComponents.add(siteUriText);
	    leftComponents.add(videoSourceUriLabel);
	    leftComponents.add(videoSourceUriText);
	    leftComponents.add(leftSettingBut);
	    
	    rightComponents.add(duohuamianUriLabel);
	    rightComponents.add(duohuamianUriText);
	    rightComponents.add(duohuamianTypeLabel);
	    rightComponents.add(duohuamianTypeText);
	    rightComponents.add(rightSettingBut);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public JLabel getSiteUriLabel() {
		return siteUriLabel;
	}

	public JTextField getSiteUriText() {
		return siteUriText;
	}




	public JLabel getVideoSourceUriLabel()
    {
        return videoSourceUriLabel;
    }

    public JTextField getVideoSourceUriText()
    {
        return videoSourceUriText;
    }

    public List<JComponent> getLeftComponents()
    {
        return leftComponents;
    }

    public List<JComponent> getRightComponents()
    {
        return rightComponents;
    }

    public JButton getLeftSettingBut() {
		return leftSettingBut;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public JLabel getDuohuamianUriLabel() {
		return duohuamianUriLabel;
	}

	public JTextField getDuohuamianUriText() {
		return duohuamianUriText;
	}

	public JLabel getDuohuamianTypeLabel() {
		return duohuamianTypeLabel;
	}

	public JComboBox getDuohuamianTypeText() {
		return duohuamianTypeText;
	}

	public JButton getRightSettingBut() {
		return rightSettingBut;
	}
	
}
