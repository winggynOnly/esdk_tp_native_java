package com.huawei.esdk.csdemo.view.panel;


import java.awt.Rectangle;
import javax.swing.JPanel;

public class SiteControlPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;
	private BottomPan bottomPanel;
	private SiteControlVedioPan siteControlVedioPan;
	private SiteControlSiteListPan siteControlSiteListPan;

    private ResultPan bottom_show_result_panel;

	public SiteControlPanel(Rectangle rectangle){
		this.rectangle = rectangle;
		this.setLayout(null);
		this.setBounds(rectangle);

	}

	public void createPanel(){
		Rectangle btmRect = new Rectangle(10,rectangle.height - 250,rectangle.width-40,140);
		bottomPanel = new BottomPan(btmRect);
		bottomPanel.createPanel();

	    
		
		Rectangle btmRect1 = new Rectangle(10,20,rectangle.width-40,220);
		siteControlSiteListPan = new SiteControlSiteListPan(btmRect1);
		siteControlSiteListPan.createPanel();
		
		Rectangle btmRect2 = new Rectangle(10,250,rectangle.width-40,310);
		siteControlVedioPan = new SiteControlVedioPan(btmRect2);
		siteControlVedioPan.createPanel();
	      
        Rectangle btmRect3 = new Rectangle(10, rectangle.height - 105,rectangle.width-40,50);
        bottom_show_result_panel = new ResultPan(btmRect3);
        
		this.add(bottomPanel);
		this.add(siteControlVedioPan);
		this.add(siteControlSiteListPan);
		this.add(bottom_show_result_panel);
	}

	public BottomPan getBottomPanel() {
		return bottomPanel;
	}

	public void setBottomPanel(BottomPan bottomPanel) {
		this.bottomPanel = bottomPanel;
	}

	public SiteControlVedioPan getSiteControlVedioPan() {
		return siteControlVedioPan;
	}

	public void setSiteControlVedioPan(SiteControlVedioPan siteControlVedioPan) {
		this.siteControlVedioPan = siteControlVedioPan;
	}

	public SiteControlSiteListPan getSiteControlSiteListPan() {
		return siteControlSiteListPan;
	}

	public void setSiteControlSiteListPan(
			SiteControlSiteListPan siteControlSiteListPan) {
		this.siteControlSiteListPan = siteControlSiteListPan;
	}


    public ResultPan getBottom_show_result_panel()
    {
        return bottom_show_result_panel;
    }

}
