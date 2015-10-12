package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.huawei.esdk.csdemo.common.ComponentBoundsTool;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.Table;
import com.huawei.esdk.csdemo.memorydb.DataBase;


public class ConfControlTopPan extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;
	private int xx = 10;
	private int yy = 10;
	
	private JPanel confSearchPanel = new JPanel();
	private JLabel confIdLabel = new JLabel();
	private JComboBox confIdJCB = new JComboBox();
	private JButton searchConfBut = new JButton();
	
	private List<JComponent> confSearchComponents = new ArrayList<JComponent>();
	//conf status panel
	
	private JPanel statusPanel = new JPanel();
	
	private JLabel confNameLabel = new JLabel();
	private JTextField confNameText = new JTextField();
	
	private JLabel confStatusLabel = new JLabel();
	private JTextField confStatusText = new JTextField();
	
	private JCheckBox isConfLockedCK= new JCheckBox();
	private JLabel isConfLockedLabel = new JLabel();
	
	private JLabel chairSiteLabel = new JLabel();
	private JTextField chairSiteText = new JTextField();
	
	private JLabel broadcastSiteLabel = new JLabel();
	private JTextField broadcastSiteText = new JTextField();
	
	private JLabel speakSiteLabel = new JLabel();
	private JTextField speakSiteText = new JTextField();
	
	private JCheckBox setAudioSwitchCK= new JCheckBox();
	private JLabel setAudioSwitchLabel = new JLabel();
	
	private JLabel switchGateLabel = new JLabel();
	
	private JSlider switchGateSlider = new JSlider(0,100,50);
	private JLabel switchGateValOutput = new JLabel("50");
	
	private JLabel recurrenceLabel = new JLabel();
	private JComboBox recurrenceCB = new JComboBox();
	
	private List<JComponent> confStatusComponents = new ArrayList<JComponent>();
	
	public ConfControlTopPan(Rectangle rectangle){
		this.rectangle = rectangle;
		this.setLayout(null);
	}
	public void repaintCompomentName(){
		confIdLabel.setText(LabelText.confCtol_top_confIdLabel[DataBase.getInstance().getLanguageFlag()]);
		searchConfBut.setText(LabelText.confCtol_top_searchConfBut[DataBase.getInstance().getLanguageFlag()]);
		
		statusPanel.setBorder(BorderFactory.
		    createTitledBorder(BorderFactory.createEtchedBorder(), LabelText.confCtol_top_statusPanel_border[DataBase.getInstance().getLanguageFlag()]));
		confNameLabel.setText(LabelText.confCtol_top_confNameLabel[DataBase.getInstance().getLanguageFlag()]);
		confStatusLabel.setText(LabelText.confCtol_top_confStatusLabel[DataBase.getInstance().getLanguageFlag()]);
		isConfLockedLabel.setText(LabelText.confCtol_top_isConfLockedLabel[DataBase.getInstance().getLanguageFlag()]);
		chairSiteLabel.setText(LabelText.confCtol_top_chairSiteLabel[DataBase.getInstance().getLanguageFlag()]);
		broadcastSiteLabel.setText(LabelText.confCtol_top_broadcastSiteLabel[DataBase.getInstance().getLanguageFlag()]);
		speakSiteLabel.setText(LabelText.confCtol_top_speakSiteLabel[DataBase.getInstance().getLanguageFlag()]);
		setAudioSwitchLabel.setText(LabelText.confCtol_top_setAudioSwitchLabel[DataBase.getInstance().getLanguageFlag()]);
		switchGateLabel.setText(LabelText.confCtol_top_switchGateLabel[DataBase.getInstance().getLanguageFlag()]);
		recurrenceLabel.setText(LabelText.recurrence_time[DataBase.getInstance().getLanguageFlag()]);
		isConfLockedCK.setEnabled(false);
	}

	public void initCompomentBouds(){
		this.setBounds(this.rectangle);
		
        confSearchPanel.setBounds(xx, 0, this.rectangle.width - 2*xx, 40);
        statusPanel.setBounds(xx,  40, this.rectangle.width - 2*xx, this.rectangle.height - 40 - 2*yy);
        
		// table1
		Table table1 = new Table(this.rectangle.width,30, 1, 3, new String[]{"25"}, new String[]{"100","150","180"});
		
	      Map<Integer,Integer> alignment1 = new HashMap<Integer,Integer>();
	      alignment1.put(0, SwingConstants.LEFT);
	      table1.setAlignment(alignment1);
	      
	     List< Integer[]> bounds1 = new ArrayList< Integer[]>();
	     bounds1.add( new Integer[]{0,0,1,1});
	     bounds1.add( new Integer[]{0,1,1,1});
	     bounds1.add( new Integer[]{0,2,1,1});
	      
	     new ComponentBoundsTool().getInitedBoundsComponent(this.confSearchComponents, bounds1, table1);
		
	     
	  // table
		
		Table table2 = new Table(this.rectangle.width,this.rectangle.height,3,7, new String[]{"40","40","40"}, new String[]{"12%","16%","16%","16%","4%","12%","16%"});
		Map<Integer,Integer> alignment2 = new HashMap<Integer,Integer>();
		alignment2.put(4, SwingConstants.RIGHT);
		alignment2.put(5, SwingConstants.LEFT);
		
		alignment2.put(12, SwingConstants.RIGHT);
		alignment2.put(13, SwingConstants.LEFT);
//		alignment.put(15, SwingConstants.LEFT);
		alignment2.put(16, SwingConstants.LEFT);
		table2.setAlignment(alignment2);
		

       List<Integer[]> bounds2 = new ArrayList<Integer[]>();
       bounds2.add(new Integer[]{0,0,1,1});
       bounds2.add(new Integer[]{0,1,1,1});
       bounds2.add(new Integer[]{0,2,1,1});
       bounds2.add(new Integer[]{0,3,1,1});
       bounds2.add(new Integer[]{0,5,1,1});
       bounds2.add(new Integer[]{0,6,1,1});

       bounds2.add(new Integer[]{1,0,1,1});
       bounds2.add(new Integer[]{1,1,1,1});
       bounds2.add(new Integer[]{1,2,1,1});
       bounds2.add(new Integer[]{1,3,1,1});
       bounds2.add(new Integer[]{1,5,1,1});
       bounds2.add(new Integer[]{1,6,1,1});
       
       bounds2.add(new Integer[]{2,0,1,1});
       bounds2.add(new Integer[]{2,1,1,1});
       
       bounds2.add(new Integer[]{2,2,1,1});
       bounds2.add(new Integer[]{2,3,1,1});
       bounds2.add(new Integer[]{2,4,1,1});

       bounds2.add(new Integer[]{2,5,1,1});
       bounds2.add(new Integer[]{2,6,1,1});
       
       new ComponentBoundsTool().getInitedBoundsComponent(this.confStatusComponents, bounds2, table2);
		
	}

	public void addCompomentToPanel(){
	    confNameText.setEditable(false);
	    confStatusText.setEditable(false);
	    isConfLockedCK.setEnabled(false);
	    chairSiteText.setEditable(false);
	    broadcastSiteText.setEditable(false);
	    speakSiteText.setEditable(false);
	    this.setLayout(null);
	    
	    this.add(confSearchPanel);
	    confSearchPanel.setLayout(null);
	    
		for(JComponent jcpt : confSearchComponents){
		    confSearchPanel.add(jcpt);
		}
		

		this.add(statusPanel);
		statusPanel.setLayout(null);

		for(JComponent jcpt : confStatusComponents){
		    statusPanel.add(jcpt);
		}
		
	}

	public void repaintComponentVal(){

	}

	public void addComponentToList(){
	    // confSearch panel
	    confSearchComponents.add(confIdLabel);
	    confSearchComponents.add(confIdJCB);
	    confSearchComponents.add(searchConfBut);
	    
	    //status panel
	    confStatusComponents.add(confNameLabel );
	    confStatusComponents.add(confNameText );
	    confStatusComponents.add(confStatusLabel );
	    confStatusComponents.add(confStatusText );
	    confStatusComponents.add(isConfLockedCK );
	    confStatusComponents.add(isConfLockedLabel );
	    
	    confStatusComponents.add(chairSiteLabel );
	    confStatusComponents.add(chairSiteText );
	    confStatusComponents.add(broadcastSiteLabel );
	    confStatusComponents.add(broadcastSiteText );
	    confStatusComponents.add(speakSiteLabel );
	    confStatusComponents.add(speakSiteText );
	    
	    confStatusComponents.add(setAudioSwitchCK );
	    confStatusComponents.add(setAudioSwitchLabel  );
	    
	    confStatusComponents.add(switchGateLabel);
	    confStatusComponents.add(switchGateSlider);
	    confStatusComponents.add(switchGateValOutput);
	        
        confStatusComponents.add(recurrenceLabel);
        confStatusComponents.add(recurrenceCB);
	}
	
	public void createPanel(){
	    addComponentToList();
		repaintCompomentName();
		initCompomentBouds();
		addCompomentToPanel();
		repaintComponentVal();
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	public JLabel getConfIdLabel() {
		return confIdLabel;
	}
	public JComboBox getConfIdJCB() {
		return confIdJCB;
	}
	public JButton getSearchConfBut() {
		return searchConfBut;
	}
	public JPanel getStatusPanel() {
		return statusPanel;
	}
	public JLabel getConfNameLabel() {
		return confNameLabel;
	}
	public JTextField getConfNameText() {
		return confNameText;
	}
	public JLabel getConfStatusLabel() {
		return confStatusLabel;
	}
	public JTextField getConfStatusText() {
		return confStatusText;
	}
	public JCheckBox getIsConfLockedCK() {
		return isConfLockedCK;
	}
	public JLabel getIsConfLockedLabel() {
		return isConfLockedLabel;
	}
	public JLabel getChairSiteLabel() {
		return chairSiteLabel;
	}
	public JTextField getChairSiteText() {
		return chairSiteText;
	}
	public JLabel getBroadcastSiteLabel() {
		return broadcastSiteLabel;
	}
	public JTextField getBroadcastSiteText() {
		return broadcastSiteText;
	}
	public JLabel getSpeakSiteLabel() {
		return speakSiteLabel;
	}
	public JTextField getSpeakSiteText() {
		return speakSiteText;
	}
	public JCheckBox getSetAudioSwitchCK() {
		return setAudioSwitchCK;
	}
	public JLabel getSetAudioSwitchLabel() {
		return setAudioSwitchLabel;
	}
	public JLabel getSwitchGateLabel() {
		return switchGateLabel;
	}
	public JSlider getSwitchGateSlider() {
		return switchGateSlider;
	}
	public JLabel getSwitchGateValOutput() {
		return switchGateValOutput;
	}
    public List<JComponent> getConfStatusComponents()
    {
        return confStatusComponents;
    }
    public JPanel getConfSearchPanel()
    {
        return confSearchPanel;
    }
    public List<JComponent> getConfSearchComponents()
    {
        return confSearchComponents;
    }
    public JLabel getRecurrenceLabel()
    {
        return recurrenceLabel;
    }
    public JComboBox getRecurrenceCB()
    {
        return recurrenceCB;
    }
	
	
}
