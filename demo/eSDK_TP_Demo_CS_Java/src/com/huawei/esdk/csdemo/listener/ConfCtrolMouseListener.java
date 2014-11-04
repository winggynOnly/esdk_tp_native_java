package com.huawei.esdk.csdemo.listener;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.action.ConfControlAction;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.csdemo.view.panel.BottomPan;
import com.huawei.esdk.csdemo.view.panel.ConfControlBottomPan;
import com.huawei.esdk.csdemo.view.panel.ConfControlMiddlePan;
import com.huawei.esdk.csdemo.view.panel.ConfControlPanel;
import com.huawei.esdk.csdemo.view.panel.ConfControlTopPan;


public class ConfCtrolMouseListener {
	
	private ConfControlAction confControlAction;
	private ConfControlPanel confControlPanel;
	
	
	public void registerListener(ConfControlPanel confControlPanel){
		 confControlAction = new ConfControlAction(confControlPanel);
		this.confControlPanel = confControlPanel;
		addListenerForTopPanelDropdown();
		addListenerForTopPanelSearchBut();
		addListenerForTopPanelSwitchAdCK();
		addListenerForMidBroadcastSite();
		addListenerForMidMuteSiteBut();
		addListenerForMidqQueitSiteBut();
		addListenerForMidbroadcastCPBut();
		addListenerForBotleftSettingBut();
		addListenerForBotrightSettingBut();
		addListenerForMidSiteListTable();
		addListenerForImageDescription();
		addListenerForRecurrenceCombox();
		logoutButAction();
	}
	
	public void addListenerForTopPanelDropdown()
	{
		getConfControlTopPan().getConfIdJCB().addMouseListener(new MouseAdapter()
        {


			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("显示所有已预约会议的 ID . \n 将调用 QueryScheduledConfId的方法  \n 返回所欲会议ID ");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("所有已预约会议的 ID . \n系统定时从内存数据库中读取所有已预约的会议的ID");
//               }
//               else
//               {
//                   getEditPane().setText("All the ID of scheduled conference \nSystem will load the all the ID of scheduled conference at regular time. ");
//               }
               getEditPane().setText(LabelText.description_pane_showAllConfId[DataBase.getInstance().getLanguageFlag()]);
			}

		});
	}
	
	
	public void addListenerForTopPanelSearchBut()
	{
		getConfControlTopPan().getSearchConfBut().addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("查询已调度会议的状态. \n 接口说明：PSDKResponse< List<ConferenceStatusEx>> queryConferencesStatusEx (List<String> confIds)   \n 功能描述：查询多个已调度会议的状态。返回所欲会议信息 ");
				getEditPane().setText("PSDKResponse< List<ConferenceStatusEx>> queryConferencesStatusEx (List<String> confIds)   ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
//				confControlAction.searchButAction();
				new MethodThread(confControlAction,"searchButAction").start();
			}
		});
	}
	
	public void addListenerForTopPanelSwitchAdCK(){
		getConfControlTopPan().getSetAudioSwitchCK().addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("设置会议的声控切换 \n 接口说明： Integer setAudioSwitchEx (String confId, Integer swtichGate,Integer isSwitch)  \n 功能描述 ：设置指定会场的视频源。 \n");
				getEditPane().setText("Integer setAudioSwitchEx (String confId, Integer swtichGate,Integer isSwitch) ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
//				confControlAction.setAudioSwitchEx();
				new MethodThread(confControlAction,"setAudioSwitchEx").start();
			}
		});
	}
	
	public void addListenerForMidBroadcastSite(){
		getConfControlMiddlePan().getBroadcastSiteBut().addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("设置广播会场 . \n 接口说明： Integer setBroadcastSiteEx (String confId, String siteUri, Integer isBroadcast)  \n 功能描述 ：指定会场开始、取消广播。 \n ");
				getEditPane().setText("Integer setBroadcastSiteEx (String confId, String siteUri, Integer isBroadcast)  ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
//				confControlAction.setBroadcastSiteEx();
				new MethodThread(confControlAction,"setBroadcastSiteEx").start();
			}
		});
	}
	
	public void addListenerForMidMuteSiteBut(){
		getConfControlMiddlePan().getMuteSiteBut().addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("指定会场闭音. \n 接口说明： Integer setSitesMuteEx(String confId, List<String> siteUris, Integer isMute)  \n 功能描述 ：指定会场闭音，关闭会场麦克风输入。全闭音，或全部取消闭音操作并不对后续再入会的会场有影响。 \n ");
			    getEditPane().setText("Integer setSitesMuteEx(String confId, List<String> siteUris, Integer isMute) ");
		            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				//confControlAction.setAudioSwitch();
//				confControlAction.setSitesMuteEx();
				new MethodThread(confControlAction,"setSitesMuteEx").start();
			}
		});
	}
	
	public void addListenerForMidqQueitSiteBut(){
		getConfControlMiddlePan().getQuietSiteBut().addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("指定会场静音 . \n 接口说明： Integer setSitesQuietEx(String confId, List<String> siteUris, Integer isQuiet)  \n 功能描述 ：指定会场静音，关闭会场扬声器输出。全静音，或全部取消静音操作并不对后续再入会的会场有影响。 \n ");
				getEditPane().setText("Integer setSitesQuietEx(String confId, List<String> siteUris, Integer isQuiet) ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				//confControlAction.setAudioSwitch();
//				confControlAction.setSitesQuietEx();
				new MethodThread(confControlAction,"setSitesQuietEx").start();
			}
		});
	}
	
	
	public void addListenerForMidbroadcastCPBut()
	{
		getConfControlMiddlePan().getBroadcastContinuousPresenceBut().addMouseListener(new MouseAdapter() 
		{

			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				
//				getEditPane().setText("设置广播多画面 . \n 接口说明： Integer setBroadcastContinuousPresenceEx (String confId, Integer isBroadcast)  \n 功能描述 ：指定多画面开始、取消广播. \n ");
				getEditPane().setText("Integer setBroadcastContinuousPresenceEx (String confId, Integer isBroadcast) ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
				//confControlAction.setAudioSwitch();
//				confControlAction.setBroadcastContinuousPresenceEx();
				new MethodThread(confControlAction,"setBroadcastContinuousPresenceEx").start();
			}
		});
	}
	
	public void addListenerForBotleftSettingBut()
	{
		getConfControlBottomPan().getLeftSettingBut().addMouseListener(new MouseAdapter() 
		{

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				
//				getEditPane().setText("设置指定会场的视频源. \n 接口说明： Integer setVideoSourceEx (String confId, String siteUri, String videoSourceUri, Integer isLock)  \n 功能描述 ：设置指定会场的视频源。 \n ");
			    getEditPane().setText("Integer setVideoSourceEx (String confId, String siteUri, String videoSourceUri, Integer isLock)");
		            
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
//				confControlAction.setVideoSourceEx();
				new MethodThread(confControlAction,"setVideoSourceEx").start();
			}
			});
		}
		
	public void addListenerForBotrightSettingBut()
	{
			getConfControlBottomPan().getRightSettingBut().addMouseListener(new MouseAdapter() 
			{

				@Override
				public void mouseEntered(MouseEvent e) 
				{
					
//					getEditPane().setText("设置多画面参数. \n 接口说明： Integer setContinuousPresenceEx(String confId, String target,Integer presenceMode,List<String> subPics)  \n 功能描述 ：设置多画面 \n ");
				    getEditPane().setText("Integer setContinuousPresenceEx(String confId, String target,Integer presenceMode,List<String> subPics)");
	                
				}
				
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					
//					confControlAction.setContinuousPresenceEx();
					new MethodThread(confControlAction,"setContinuousPresenceEx").start();
				}
			});
	}
	
	public void addListenerForMidSiteListTable()
	{
		getConfControlMiddlePan().getJtable().addMouseListener(new MouseAdapter() 
		{
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				getEditPane().setText("");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				
//				getEditPane().setText("查询指定会议中的会场状态\n TPSDKResponseEx<List<SiteStatusEx>> queryConfSitesStatusEx (String confId, List<String> siteUris) \n功能描述 ：查询指定会议中的会场状态。  ");
				getEditPane().setText("TPSDKResponseEx<List<SiteStatusEx>> queryConfSitesStatusEx (String confId, List<String> siteUris) ");
	            
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
//				confControlAction.querySiteByUriSiteCtrl();
				new MethodThread(confControlAction,"querySiteByUriSiteCtrl").start();
			}
		});
	}

	public void addListenerForImageDescription(){
		getConfControlMiddlePan().getMikeOff().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				
//				getEditPane().setText("当前 会场状态： 闭音。\n 点击 静音按钮设置会场 状态 为 不闭 音。");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("当前 会场状态： 闭音。\n点击 静音按钮设置会场 状态 为 不闭 音。");
//               }
//               else
//               {
//                   getEditPane().setText("Current site status:mute. \nClick the button change the status to not mute. ");
//               }
               getEditPane().setText(LabelText.description_pane_muteStatus1[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
		});
		
		getConfControlMiddlePan().getMikeOn().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				
//				getEditPane().setText("当前 会场状态： 不闭音。\n 点击 静音按钮设置会场 状态 为 闭 音。");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("当前 会场状态： 不闭音。\n点击 静音按钮设置会场状态 为 闭 音。");
//               }
//               else
//               {
//                   getEditPane().setText("Current site status:not mute. \nClick the button change the status to mute. ");
//               }
               getEditPane().setText(LabelText.description_pane_muteStatus2[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
		});
		
		getConfControlMiddlePan().getSpeakerOff().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				
//				getEditPane().setText("当前 会场状态：静音。\n 点击 静音按钮设置会场 状态 为不 静音。 ");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("当前 会场状态：静音。\n点击 静音按钮设置会场状态 为不 静音。");
//               }
//               else
//               {
//                   getEditPane().setText("Current site status:quiet. \nClick the button change the status to not quiet. ");
//               }
               getEditPane().setText(LabelText.description_pane_quietStatus1[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
		});
		
		getConfControlMiddlePan().getSpeakerOn().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				
//				getEditPane().setText("当前 会场状态：不静音。\n 点击 静音按钮设置会场 状态 为 静音。");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("当前 会场状态：不 静音。\n点击 静音按钮设置会场 状态为静音。");
//               }
//               else
//               {
//                   getEditPane().setText("Current site status:not quiet. \nClick the button change the status to quiet. ");
//               }
               getEditPane().setText(LabelText.description_pane_quietStatus2[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
		});
		
		getConfControlMiddlePan().getBroadcasting().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				
//				getEditPane().setText("当前 会场状态： 正在广播会场。\n 点击 广播会场按钮将停止广播。");
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("当前 会场状态： 正在广播会场。\n点击广播会场按钮将停止广播。");
//               }
//               else
//               {
//                   getEditPane().setText("Current site status:broadcasting site. \nClick the button to stop broadcasting site. ");
//               }
               getEditPane().setText(LabelText.description_pane_broadingSite[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
		});
		
		getConfControlTopPan().getSwitchGateSlider().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				
				int val = getConfControlTopPan().getSwitchGateSlider().getValue();
				getConfControlTopPan().getSwitchGateValOutput().setText(String.valueOf(val));
			}
		});
	}
	
	public void addListenerForRecurrenceCombox(){

	    
	    getConfControlTopPan().getRecurrenceCB().addItemListener(new ItemListener()
        {
            
            @Override
            public void itemStateChanged(ItemEvent e)
            {

                if(1 == e.getStateChange()){
//                    confControlAction.recurrenceComboxAction();
                    new MethodThread(confControlAction,"recurrenceComboxAction").start();
                }
            }
        });
	    
	       getConfControlTopPan().getRecurrenceCB().addMouseListener(new MouseAdapter()
        {

            
            @Override
            public void mouseExited(MouseEvent arg0)
            {
                
                getEditPane().setText("");
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0)
            {
                
              //  getEditPane().setText("选择周期性会议开始时间 ");
//                if(0 == DataBase.getInstance().getLanguageFlag())
//                {
//                    getEditPane().setText("选择周期性会议开始时间 。");
//                }
//                else
//                {
//                    getEditPane().setText("Choose one begin time. ");
//                }
//                
                getEditPane().setText(LabelText.description_pane_chooseRecurrentTimeBtn[DataBase.getInstance().getLanguageFlag()]);
            }

        });
	    
	}
	
	public void logoutButAction(){
		
		getConfControlPaneBottom().getBtm_exitLoginBut().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				getEditPane().setText("");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			//	getEditPane().setText("用户登出 \n 功能描述：用户登出系统。 ");
//	               if(0 == DataBase.getInstance().getLanguageFlag())
//	               {
//	                   getEditPane().setText("用户退出 \n功能描述：用户退出系统。 ");
//	               }
//	               else
//	               {
//	                   getEditPane().setText("Logout \nExit the demo system. ");
//	               }
	               getEditPane().setText(LabelText.description_pane_exitLoginBtn[DataBase.getInstance().getLanguageFlag()]);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
//                confControlAction.logout();
//                new MethodThread(confControlAction,"logout").start();
                KeepAliveThread.setFlag(1);
                try
                {
                    confControlAction.logout();
                }
                catch(Exception exception)
                {
                    System.out.println(e.toString());
                }
                finally
                {
                    System.exit(0);
                }

			}
		});

	}
	
	
	private JEditorPane getEditPane(){
		return getConfControlPanel().getBottomPanel().getDescriptionPane();
	}

	private ConfControlTopPan getConfControlTopPan(){
		return getConfControlPanel().getTopPan();
	}
	private ConfControlMiddlePan getConfControlMiddlePan(){
		return getConfControlPanel().getMiddlePan();
	}
	private ConfControlBottomPan getConfControlBottomPan(){
		return getConfControlPanel().getBottomPan();
	}
	private BottomPan getConfControlPaneBottom(){
		return getConfControlPanel().getBottomPanel();
	}

	public ConfControlAction getConfControlAction() {
		return confControlAction;
	}

	public void setConfControlAction(ConfControlAction confControlAction) {
		this.confControlAction = confControlAction;
	}

	public void setConfControlPanel(ConfControlPanel confControlPanel) {
		this.confControlPanel = confControlPanel;
	}
	
	public ConfControlPanel getConfControlPanel(){
		return confControlPanel;
	}
	
}
