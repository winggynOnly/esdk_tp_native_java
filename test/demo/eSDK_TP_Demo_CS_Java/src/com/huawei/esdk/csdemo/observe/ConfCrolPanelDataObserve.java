package com.huawei.esdk.csdemo.observe;

import java.io.Serializable;

import javax.swing.JComboBox;

import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.view.DemoApp;


public class ConfCrolPanelDataObserve extends Thread implements Serializable
{

	/** * */
    private static final long serialVersionUID = 9197029182980500964L;
    
    public int flag = 0;
	@Override
	public synchronized void run() 
	{
		
		try 
		{
			while (0 == flag) 
			{

				if (DataBase.getInstance().isConfDataChanged()) 
				{
					
					JComboBox jcb = DemoApp.mainFrame.getPan2().getTopPan().getConfIdJCB();

					jcb.removeAllItems();

					String[] ids = DataBase.getInstance().queryAllConfIds();
					if(null != ids && 0 != ids.length)
					{
    					for (String id : ids) 
    					{
    						jcb.addItem(id);
    					}
    					DemoApp.mainFrame.getPan2().getTopPan().getSearchConfBut().doClick();
					}
					else
					{
					    
					}

					DataBase.getInstance().setConfDataChanged(false);
				}
				
				Thread.sleep(500);

			}
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public void stopObserve()
	{
		flag = 1;
	}
	
	public void copyProperty()
	{
		
	}
}
