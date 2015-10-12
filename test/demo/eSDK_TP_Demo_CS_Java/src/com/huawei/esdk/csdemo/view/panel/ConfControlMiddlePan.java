package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class ConfControlMiddlePan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;
	private int xx = 10;
	private int yy = 10;

	// site list
	private JPanel siteListPanel = new JPanel();

	private JScrollPane siteListJS = new JScrollPane();
	private JTable jtable = new JTable()
    {
        /** * */
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };
	private DefaultTableModel tableMode = new DefaultTableModel();
	
	// private JButton addsiteBut = new JButton();
	// private JButton addsiteBut1 = new JButton();
	// private JButton deletesiteBut = new JButton();

	// site status
	private JPanel siteStatusPanel = new JPanel();

	private JLabel siteNameLabel = new JLabel();
	private JTextField siteNameText = new JTextField();
	private JButton broadcastSiteBut = new JButton();

	private JLabel startTimeLabel = new JLabel();
	private JTextField startTimeText = new JTextField();
	private JButton quietSiteBut = new JButton();

	private JLabel confHowLongLabel = new JLabel();
	private JTextField confHowLongText = new JTextField();
	private JLabel confHowLongUnitLabel = new JLabel();
	private JButton muteSiteBut = new JButton();

	private JLabel siteStatusLabel = new JLabel();
	private JTextField siteStatusText = new JTextField();
	private JButton broadcastContinuousPresenceBut = new JButton();
	
	private JLabel mikeOn = new JLabel(new ImageIcon(DataBase.getInstance().getPath("mikeOn.png")));
	private JLabel mikeOff = new JLabel(new ImageIcon(DataBase.getInstance().getPath("mikeOff.png")));
	
	private JLabel speakerOn = new JLabel(new ImageIcon(DataBase.getInstance().getPath("speakerOn.png")));
	private JLabel speakerOff = new JLabel(new ImageIcon(DataBase.getInstance().getPath("speakerOff.png")));
	
	private JLabel broadcasting = new JLabel(new ImageIcon(DataBase.getInstance().getPath("broadcasting.png")));
	
//	private JLabel broadcastingPresence = new JLabel(new ImageIcon(DataBase.getInstance().getPath("addfriend.png")));s
	
	private JLabel broadcastingPresence = new JLabel();
	
	private List<JComponent> siteStatusComponents = new ArrayList<JComponent>();

	public ConfControlMiddlePan(Rectangle rectangle) {
		this.rectangle = rectangle;
		this.setLayout(null);
	}

	public void repaintCompomentName() {
		// site list
		siteListPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.confCtol_middle_siteListPanel_border[DataBase.getInstance().getLanguageFlag()]));
		String[] tableTitle = { LabelText.confCtol_middle_tableTitle_title1[DataBase.getInstance().getLanguageFlag()], 
		    LabelText.confCtol_middle_tableTitle_title2[DataBase.getInstance().getLanguageFlag()], 
		    LabelText.confCtol_middle_tableTitle_title3[DataBase.getInstance().getLanguageFlag()] };
		tableMode.setColumnIdentifiers(tableTitle);
		// site status
		siteStatusPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), LabelText.confCtol_middle_siteStatusPanel_border[DataBase.getInstance().getLanguageFlag()]));

		siteNameLabel.setText(LabelText.confCtol_middle_siteNameLabel[DataBase.getInstance().getLanguageFlag()]);
		broadcastSiteBut.setText(LabelText.confCtol_middle_broadcastSiteBut[DataBase.getInstance().getLanguageFlag()]);
		startTimeLabel.setText(LabelText.confCtol_middle_startTimeLabel[DataBase.getInstance().getLanguageFlag()]);
		quietSiteBut.setText(LabelText.confCtol_middle_quietSiteBut[DataBase.getInstance().getLanguageFlag()]);
		confHowLongLabel.setText(LabelText.confCtol_middle_confHowLongLabel[DataBase.getInstance().getLanguageFlag()]);
		confHowLongUnitLabel.setText(LabelText.confCtol_middle_confHowLongUnitLabel[DataBase.getInstance().getLanguageFlag()]);
		muteSiteBut.setText(LabelText.confCtol_middle_muteSiteBut[DataBase.getInstance().getLanguageFlag()]);
		siteStatusLabel.setText(LabelText.confCtol_middle_siteStatusLabel[DataBase.getInstance().getLanguageFlag()]);
		broadcastContinuousPresenceBut.setText(LabelText.confCtol_middle_broadcastContinuousPresenceBut[DataBase.getInstance().getLanguageFlag()]);
	}

	public void initCompomentBouds() {

		int widgetWidth = (this.rectangle.width - 10 - 2 * xx) / 2;
		int widgetHeight = this.rectangle.height - 2 * yy;

		siteListPanel.setBounds(xx, yy, widgetWidth, widgetHeight);

		siteStatusPanel.setBounds(xx + widgetWidth + 10, yy, widgetWidth,
				widgetHeight);


		siteListJS.setBounds(xx, yy+10, widgetWidth - 2*xx, widgetHeight - 2*yy-10);
		

		String btnWidth = "130";
		if(0 != DataBase.getInstance().getLanguageFlag()){
		    btnWidth = "200";
		}
		
	    String labelWidth = "90";
        if(0 != DataBase.getInstance().getLanguageFlag()){
            labelWidth = "70";
        }
        
        String textWidth = "130";
        if(0 != DataBase.getInstance().getLanguageFlag()){
            textWidth = "110";
        }
		
	     Table table1 = new Table(widgetWidth,widgetHeight, 4, 5, new String[]{"40","40","40","40"}, new String[]{labelWidth,textWidth,"40","0",btnWidth});
	        
          Map<Integer,Integer> alignment1 = new HashMap<Integer,Integer>();
//          alignment1.put(0, SwingConstants.LEFT);
          table1.setAlignment(alignment1);
          
         List< Integer[]> bounds1 = new ArrayList< Integer[]>();
         bounds1.add( new Integer[]{0,0,1,1});
         bounds1.add( new Integer[]{0,1,1,2});
         bounds1.add( new Integer[]{0,3,1,1});
         bounds1.add( new Integer[]{0,4,1,1});
         
         bounds1.add( new Integer[]{1,0,1,1});
         bounds1.add( new Integer[]{1,1,1,2});
         bounds1.add( new Integer[]{1,3,1,1});
         bounds1.add( new Integer[]{1,3,1,1});
         bounds1.add( new Integer[]{1,4,1,1});
         
         bounds1.add( new Integer[]{2,0,1,1});
         bounds1.add( new Integer[]{2,1,1,1});
         bounds1.add( new Integer[]{2,2,1,1});
         bounds1.add( new Integer[]{2,3,1,1});
         bounds1.add( new Integer[]{2,3,1,1});
         bounds1.add( new Integer[]{2,4,1,1});
         
         bounds1.add( new Integer[]{3,0,1,1});
         bounds1.add( new Integer[]{3,1,1,2});
         bounds1.add( new Integer[]{3,3,1,1});
         bounds1.add( new Integer[]{3,4,1,1});
          
         new ComponentBoundsTool().getInitedBoundsComponent(this.siteStatusComponents, bounds1, table1);
        
		
	}

	public void addCompomentToPanel() {
	    startTimeText.setEditable(false);
	    siteNameText.setEditable(false);
	    confHowLongText.setEditable(false);
	    siteStatusText.setEditable(false);
		this.setBounds(this.rectangle);
		this.add(siteListPanel);
		siteListPanel.setLayout(null);
		siteListPanel.add(siteListJS);
		siteListJS.add(jtable);
		siteListJS.setViewportView(jtable);
		jtable.setModel(tableMode);

		this.add(siteStatusPanel);
		siteStatusPanel.setLayout(null);
		
		
		for(JComponent jcpt : siteStatusComponents){
		    siteStatusPanel.add(jcpt);
		}
		
		mikeOff.setVisible(false);
		mikeOn.setVisible(false);
		speakerOff.setVisible(false);
		speakerOn.setVisible(false);
		broadcasting.setVisible(false);
		broadcastingPresence.setVisible(false);
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

    public void addComponentToList()
    {
        siteStatusComponents.add(siteNameLabel);
        siteStatusComponents.add(siteNameText);
        siteStatusComponents.add(broadcasting);
        siteStatusComponents.add(broadcastSiteBut);
        
        siteStatusComponents.add(startTimeLabel);
        siteStatusComponents.add(startTimeText);
        siteStatusComponents.add(speakerOff);
        siteStatusComponents.add(speakerOn);
        siteStatusComponents.add(quietSiteBut);
        
        siteStatusComponents.add(confHowLongLabel);
        siteStatusComponents.add(confHowLongText);
        siteStatusComponents.add(confHowLongUnitLabel);
        siteStatusComponents.add(mikeOff);
        siteStatusComponents.add(mikeOn);
        siteStatusComponents.add(muteSiteBut);
        
        siteStatusComponents.add(siteStatusLabel);
        siteStatusComponents.add(siteStatusText);
        siteStatusComponents.add(broadcastingPresence);
        siteStatusComponents.add(broadcastContinuousPresenceBut);
    }
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public int getXx() {
		return xx;
	}

	public int getYy() {
		return yy;
	}

	public JPanel getSiteListPanel() {
		return siteListPanel;
	}

	public JScrollPane getSiteListJS() {
		return siteListJS;
	}

	public JTable getJtable() {
		return jtable;
	}

	public DefaultTableModel getTableMode() {
		return tableMode;
	}

	public JPanel getSiteStatusPanel() {
		return siteStatusPanel;
	}

	public JLabel getSiteNameLabel() {
		return siteNameLabel;
	}

	public JTextField getSiteNameText() {
		return siteNameText;
	}

	public JButton getBroadcastSiteBut() {
		return broadcastSiteBut;
	}

	public JLabel getStartTimeLabel() {
		return startTimeLabel;
	}

	public JTextField getStartTimeText() {
		return startTimeText;
	}

	public JButton getQuietSiteBut() {
		return quietSiteBut;
	}

	public JLabel getConfHowLongLabel() {
		return confHowLongLabel;
	}

	public JTextField getConfHowLongText() {
		return confHowLongText;
	}

	public JLabel getConfHowLongUnitLabel() {
		return confHowLongUnitLabel;
	}

	public JButton getMuteSiteBut() {
		return muteSiteBut;
	}

	public JLabel getSiteStatusLabel() {
		return siteStatusLabel;
	}

	public JTextField getSiteStatusText() {
		return siteStatusText;
	}

	public JButton getBroadcastContinuousPresenceBut() {
		return broadcastContinuousPresenceBut;
	}

	public JLabel getMikeOn() {
		return mikeOn;
	}

	public JLabel getMikeOff() {
		return mikeOff;
	}

	public JLabel getSpeakerOn() {
		return speakerOn;
	}

	public JLabel getSpeakerOff() {
		return speakerOff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JLabel getBroadcasting() {
		return broadcasting;
	}

    public JLabel getBroadcastingPresence()
    {
        return broadcastingPresence;
    }

    public List<JComponent> getSiteStatusComponents()
    {
        return siteStatusComponents;
    }

}
