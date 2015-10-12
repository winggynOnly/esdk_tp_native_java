package com.huawei.esdk.csdemo.listener;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JEditorPane;

import com.huawei.esdk.csdemo.action.SiteControlAction;
import com.huawei.esdk.csdemo.adapter.MouseAdapter;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.common.MethodThread;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.csdemo.view.panel.BottomPan;
import com.huawei.esdk.csdemo.view.panel.SiteControlPanel;
import com.huawei.esdk.csdemo.view.panel.SiteControlSiteListPan;
import com.huawei.esdk.csdemo.view.panel.SiteControlVedioPan;

public class SiteControlMouseListener {
	private SiteControlPanel siteControlPanel;
	private SiteControlAction siteControlAction;
	
	public void registerListener(SiteControlPanel siteControlPanel){
		this.siteControlPanel = siteControlPanel;
		siteControlAction = new SiteControlAction();
		addListenerForCameraCtrolPan();
		addListenerForSitesTabel();
		addListenerForSendAuxStreamBtn();
		addListenerForSendAuxStreamCK();
		addListenerForConnAuxStreamCK();
		logoutButAction();
	}
	
	private void addListenerForCameraCtrolPan(){
		getSiteControlVedioPan().getUp().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
//			    siteControlAction.controlCameraButAction(0);
	               new MethodThread(siteControlAction,"controlCameraButAction",0).start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				getSiteControlVedioPan().getUp().setIcon(getSiteControlVedioPan().getUp_pabel_icon1());
//				 getEditPane().setText("摄像机控制操作\n 接口说明：Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  \n 功能描述 ：指定会场摄像头控制，可以控制摄像机进行旋转、聚焦等操作 ");
				 getEditPane().setText("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  ");
		            
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				getSiteControlVedioPan().getUp().setIcon(getSiteControlVedioPan().getUp_pabel_icon());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
		});
		getSiteControlVedioPan().getDown().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
//			    siteControlAction.controlCameraButAction(1);
	             new MethodThread(siteControlAction,"controlCameraButAction",1).start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				getSiteControlVedioPan().getDown().setIcon(getSiteControlVedioPan().getDown_pabel_icon1());
//				 getEditPane().setText("摄像机控制操作\n 接口说明：Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  \n 功能描述 ：指定会场摄像头控制，可以控制摄像机进行旋转、聚焦等操作 ");
				 getEditPane().setText("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)   ");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				getSiteControlVedioPan().getDown().setIcon(getSiteControlVedioPan().getDown_pabel_icon());
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		});
		getSiteControlVedioPan().getLeft().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
//			    siteControlAction.controlCameraButAction(2);
	             new MethodThread(siteControlAction,"controlCameraButAction",2).start();
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				
				getSiteControlVedioPan().getLeft().setIcon(getSiteControlVedioPan().getLeft_pabel_icon1());
//				 getEditPane().setText("摄像机控制操作\n 接口说明：Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  \n 功能描述 ：指定会场摄像头控制，可以控制摄像机进行旋转、聚焦等操作 ");
				 getEditPane().setText("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl) ");
		    }

			@Override
			public void mouseExited(MouseEvent e) {
				
				getSiteControlVedioPan().getLeft().setIcon(getSiteControlVedioPan().getLeft_pabel_icon());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
		});
		getSiteControlVedioPan().getRight().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
//			    siteControlAction.controlCameraButAction(3);
	             new MethodThread(siteControlAction,"controlCameraButAction",3).start();
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				getSiteControlVedioPan().getRight().setIcon(getSiteControlVedioPan().getRight_pabel_icon1());
//				 getEditPane().setText("摄像机控制操作\n 接口说明：Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  \n 功能描述 ：指定会场摄像头控制，可以控制摄像机进行旋转、聚焦等操作 ");
				 getEditPane().setText("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl) ");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				getSiteControlVedioPan().getRight().setIcon(getSiteControlVedioPan().getRight_pabel_icon());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
		});
		getSiteControlVedioPan().getCenter().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
//			    siteControlAction.controlCameraButAction(4);
	             new MethodThread(siteControlAction,"controlCameraButAction",4).start();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				getSiteControlVedioPan().getCenter().setIcon(getSiteControlVedioPan().getCenter_pabel_icon1());
//				 getEditPane().setText("摄像机控制操作\n 接口说明：Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl)  \n 功能描述 ：指定会场摄像头控制，可以控制摄像机进行旋转、聚焦等操作 ");
				 getEditPane().setText("Integer ctrlCameraEx(String siteUri,CameraControlEx cameraControl) ");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				getSiteControlVedioPan().getCenter().setIcon(getSiteControlVedioPan().getCenter_pabel_icon());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
		});
	}

	public void addListenerForSitesTabel(){
	    getSiteControlSiteListPan().getSiteList().addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e)
            {
                
//                siteControlAction.sitesTabelAction();
                new MethodThread(siteControlAction,"sitesTabelAction").start();
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
//                if(0 == DataBase.getInstance().getLanguageFlag())
//                {
//                    getEditPane().setText("会场列表\n请选择一个会场");
//                }
//                else
//                {
//                    getEditPane().setText("Site List \nPlease choose one site");
//                }
                getEditPane().setText(LabelText.description_pane_slectSite[DataBase.getInstance().getLanguageFlag()]);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                
                getEditPane().setText("");
            }

	    });
	}
	
   public void addListenerForSendAuxStreamBtn(){
       getSiteControlVedioPan().getSendAuxStreamBtn().addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e)
            {
                
//                siteControlAction.setAuxStreamEx();
                new MethodThread(siteControlAction,"setAuxStreamEx").start();
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                
//                getEditPane().setText("设置开始或停止发送辅流 \n 接口说明：Integer setAuxStreamEx (String siteUri, Integer controlCode)  \n 功能描述 ：指定会场辅流发送控制\n ");
                getEditPane().setText("Integer setAuxStreamEx (String siteUri, Integer controlCode)  ");
                
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                
            }

        });
    }

	
   public void addListenerForConnAuxStreamCK(){
       getSiteControlVedioPan().getConnAuxStreamCK().addMouseListener(new MouseListener()
    {
        
        @Override
        public void mouseReleased(MouseEvent arg0)
        {
            
            
        }
        
        @Override
        public void mousePressed(MouseEvent arg0)
        {
            
            
        }
        
        @Override
        public void mouseExited(MouseEvent arg0)
        {
            
            getEditPane().setText("");
        }
        
        @Override
        public void mouseEntered(MouseEvent arg0)
        {
            
//            getEditPane().setText("查询是否接入辅流输入源\n 接口说明：Integer isConnectAuxSourceEx(String siteURI)  \n 功能描述 ：查询是否接入辅流输入源。如果当前终端接了辅流视频源，则可以发送辅流。反之，则不能 ");
            getEditPane().setText("Integer isConnectAuxSourceEx(String siteURI)");
            
        }
        
        @Override
        public void mouseClicked(MouseEvent arg0)
        {
            
            
        }
    });
   }
   
   public void addListenerForSendAuxStreamCK(){
       getSiteControlVedioPan().getSendAuxStreamCK().addMouseListener(new MouseListener()
    {
        
        @Override
        public void mouseReleased(MouseEvent e)
        {
            
            
        }
        
        @Override
        public void mousePressed(MouseEvent e)
        {
            
            
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            
            getEditPane().setText("");
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            
//            getEditPane().setText("查询当前是否正在发送辅流\n 接口说明：isSendAuxStreamEx(String siteURI)  \n 功能描述 ：查询当前是否正在发送辅流。如果当前正在发送辅流，则不可以进行发送辅流操作。反之，则可以。 ");
            getEditPane().setText("isSendAuxStreamEx(String siteURI) ");
            
        }
        
        @Override
        public void mouseClicked(MouseEvent e)
        {
            
            
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
//               if(0 == DataBase.getInstance().getLanguageFlag())
//               {
//                   getEditPane().setText("用户退出 \n功能描述：用户退出系统。 ");
//               }
//               else
//               {
//                   getEditPane().setText("Logout \nExit the demo system. ");
//               }

               getEditPane().setText(LabelText.description_pane_exitLoginBtn[DataBase.getInstance().getLanguageFlag()]);
           }
           
           @Override
           public void mouseClicked(MouseEvent e) {
               
//               siteControlAction.logout();
//               new MethodThread(siteControlAction,"logout").start();
                KeepAliveThread.setFlag(1);
                try
                {
                    
                    siteControlAction.logout();
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
   
    public BottomPan  getConfControlPaneBottom(){
        return getSiteControlPanel().getBottomPanel();
    }
    private JEditorPane getEditPane(){
        return getSiteControlPanel().getBottomPanel().getDescriptionPane();
    }
	private SiteControlVedioPan getSiteControlVedioPan(){
		return getSiteControlPanel().getSiteControlVedioPan();
	}
	private SiteControlSiteListPan getSiteControlSiteListPan(){
	    return getSiteControlPanel().getSiteControlSiteListPan();
	}
	private SiteControlPanel getSiteControlPanel(){
		return siteControlPanel;
	}

	public void setSiteControlPanel(SiteControlPanel siteControlPanel) {
		this.siteControlPanel = siteControlPanel;
	}
	
}
