package com.huawei.esdk.csdemo.view.panel;


import java.awt.Rectangle;
import javax.swing.JPanel;

import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.observe.ConfCrolPanelDataObserve;


public class ConfControlPanel  extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rectangle rectangle;
	private BottomPan bottomPanel;
	private ConfControlTopPan topPan;
	private ConfControlMiddlePan middlePan;
	private ConfControlBottomPan bottomPan;
	private ConfCrolPanelDataObserve observe;
    private ResultPan bottom_show_result_panel;

	public ConfControlPanel(Rectangle rectangle){
		this.rectangle = rectangle;
		this.setLayout(null);
		this.setBounds(rectangle);
	}

	public void createPanel(){
        Rectangle btmRect = new Rectangle(10,rectangle.height - 250,rectangle.width-40,140);
        bottomPanel = new BottomPan(btmRect);
        bottomPanel.createPanel();

		Rectangle btmRect1 = new Rectangle(10,10,rectangle.width-40,200);
		topPan = new ConfControlTopPan(btmRect1);
		topPan.createPanel();
		
		Rectangle btmRect2 = new Rectangle(10,200,rectangle.width-40,200);
		middlePan = new ConfControlMiddlePan(btmRect2);
		middlePan.createPanel();
		
		Rectangle btmRect3 = new Rectangle(10,400,rectangle.width-40,160);
		bottomPan = new ConfControlBottomPan(btmRect3);
		bottomPan.createPanel();
		
        Rectangle btmRect4 = new Rectangle(10, rectangle.height - 105,rectangle.width-40,50);
        bottom_show_result_panel = new ResultPan(btmRect4);
		
		this.add(bottomPanel);
		this.add(topPan);
		this.add(middlePan);
		this.add(bottomPan);
        this.add(bottom_show_result_panel);
		
		observe = 	new ConfCrolPanelDataObserve();
		observe.start();
		DataBase.getInstance().setConfDataChanged(true);
	}
	
	public void refreshPanel(){
		topPan.repaintComponentVal();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public BottomPan getBottomPanel() {
		return bottomPanel;
	}

	public ConfControlTopPan getTopPan() {
		return topPan;
	}

	public ConfControlMiddlePan getMiddlePan() {
		return middlePan;
	}

	public ConfControlBottomPan getBottomPan() {
		return bottomPan;
	}

	public ConfCrolPanelDataObserve getObserve() {
		return observe;
	}

    public ResultPan getBottom_show_result_panel()
    {
        return bottom_show_result_panel;
    }
	
	
}
