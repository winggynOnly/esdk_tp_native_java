package com.huawei.esdk.csdemo.view.panel;

import java.awt.Rectangle;

import javax.swing.JPanel;

import com.huawei.esdk.csdemo.listener.ConfManagerListener;
import com.huawei.esdk.csdemo.observe.ConfManagerDataObserve;

public class ConfManagerPanel extends JPanel{
	/** * */
    private static final long serialVersionUID = 1L;
    private Rectangle rectangle;
	private BottomPan bottomPanel;
	private ConfMgrConfInfoPan confInfoPanel;
	private ConfMgrConfListpPan confListPanel;
    private ResultPan bottom_show_result_panel;
	

	public ConfManagerPanel(Rectangle rectangle){
		this.rectangle = rectangle;
		this.setLayout(null);
		this.setBounds(rectangle);

	}

	public void createPanel(){
        Rectangle btmRect = new Rectangle(10,rectangle.height - 250,rectangle.width-40,140);
        bottomPanel = new BottomPan(btmRect);
        bottomPanel.createPanel();
        
		Rectangle btmRect1 = new Rectangle(10,20,rectangle.width-40,220);
		confListPanel = new ConfMgrConfListpPan(btmRect1);
		confListPanel.addValueToTable();
		
		Rectangle btmRect2 = new Rectangle(10,250,rectangle.width-40,310);
		confInfoPanel = new ConfMgrConfInfoPan(btmRect2);
		confInfoPanel.createPanel();
		
        Rectangle btmRect3 = new Rectangle(10, rectangle.height - 105,rectangle.width-40,50);
        bottom_show_result_panel = new ResultPan(btmRect3);

		this.add(bottomPanel);
		this.add(confListPanel);
		this.add(confInfoPanel);
        this.add(bottom_show_result_panel);
		
		ConfManagerListener confManagerListener = new ConfManagerListener();
		confManagerListener.register(this);
		
		ConfManagerDataObserve observe = new ConfManagerDataObserve();
		observe.start();
	}

    public BottomPan getBottomPanel()
    {
        return bottomPanel;
    }

    public ConfMgrConfInfoPan getConfInfoPanel()
    {
        return confInfoPanel;
    }

    public ConfMgrConfListpPan getConfListPanel()
    {
        return confListPanel;
    }


    public ResultPan getBottom_show_result_panel()
    {
        return bottom_show_result_panel;
    }

}
