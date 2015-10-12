package com.huawei.esdk.csdemo.action;

import java.util.Map;
import java.util.Vector;
import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.AuthorizeService;
import com.huawei.esdk.csdemo.service.SiteService;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.panel.ResultPan;
import com.huawei.esdk.csdemo.view.panel.SiteControlPanel;
import com.huawei.esdk.csdemo.view.panel.SiteControlSiteListPan;
import com.huawei.esdk.csdemo.view.panel.SiteControlVedioPan;
import com.huawei.esdk.tp.professional.local.bean.CameraControlEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class SiteControlAction {
    private SiteService siteService = new SiteService();
    private String siteURI;

    public void sitesTabelAction(){
        siteURI = getSelectedSiteUri();
        getSiteControlVedioPan().getKoalaPic().setText("");
        if(null == siteURI ||"".equals(siteURI) ){
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_select_site[DataBase.getInstance().getLanguageFlag()]);
            return;
        }
        
        TPSDKResponseEx<Integer> result1 = siteService.isConnectAuxSourceEx(siteURI);
        TPSDKResponseEx<Integer> result2 = siteService.isSendAuxStreamEx(siteURI);
        
        if(0 != result1.getResultCode()){
//            JOptionPane.showConfirmDialog(getSiteControlPanel(), result1.getResultCode(), "isConnectAuxSourceEx error",
//                JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION);
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_isConnectAuxSourceEx_error
                [DataBase.getInstance().getLanguageFlag()]+result1.getResultCode());
            setDefaultVal();
            return;
        }
        
        if(0 != result2.getResultCode()){
//            JOptionPane.showConfirmDialog(getSiteControlPanel(), result2.getResultCode(), "isSendAuxStreamEx error",
//                JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION);
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_isSendAuxStreamEx_error
                [DataBase.getInstance().getLanguageFlag()]+result2.getResultCode());   
            setDefaultVal();
            return;
        }
        
        getSiteControlVedioPan().getConnAuxStreamCK().setSelected(result1.getResult() == 1);
        getSiteControlVedioPan().getSendAuxStreamCK().setSelected(result2.getResult()  == 1);
        
        if(result2.getResult()  == 0){
            getSiteControlVedioPan().getSendAuxStreamBtn().setText(    LabelText.siteCtol_video_sendAuxStreamBtn_start[DataBase.getInstance().getLanguageFlag()]);
        }else{
            getSiteControlVedioPan().getSendAuxStreamBtn().setText(    LabelText.siteCtol_video_sendAuxStreamBtn_stop[DataBase.getInstance().getLanguageFlag()]);
        }
        
       TPSDKResponseEx<Map<Integer, String>> map1 = siteService.queryAuxStreamSourcesEx(siteURI);
       if(0 == map1.getResultCode()){
           getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_queryAuxStreamSourcesEx_error[DataBase.getInstance().getLanguageFlag()]
               +map1.getResultCode());     
       }
       
       TPSDKResponseEx<Map<Integer, String>> map2 =  siteService.queryMainStreamSourcesEx(siteURI);
       if(0 == map2.getResultCode()){
           getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_queryMainStreamSourcesEx_error[DataBase.getInstance().getLanguageFlag()]
               +map2.getResultCode());     
       }
       
       getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_querySiteStream_success[DataBase.getInstance().getLanguageFlag()]);     
       
       getSiteControlVedioPan().getAuxStreamJC().removeAllItems();
       getSiteControlVedioPan().getMainStreamJC().removeAllItems();
       
       
       
       for(Integer key: map1.getResult().keySet()){
           
           ItemObject item = new ItemObject();
           item.setKey(String.valueOf(key));
           item.setValue(map1.getResult().get(key));
           getSiteControlVedioPan().getAuxStreamJC().addItem(item);
       }
       
       for(Integer key: map2.getResult().keySet()){
           ItemObject item = new ItemObject();
           item.setKey(String.valueOf(key));
           item.setValue(map2.getResult().get(key));
           getSiteControlVedioPan().getMainStreamJC().addItem(item);
           
       }
       
    }
    private void setDefaultVal(){
        getSiteControlVedioPan().getConnAuxStreamCK().setSelected(false);
        getSiteControlVedioPan().getSendAuxStreamCK().setSelected(false);
        getSiteControlVedioPan().getSendAuxStreamBtn().setText(    
            LabelText.siteCtol_video_sendAuxStreamBtn_start[DataBase.getInstance().getLanguageFlag()]);
        getSiteControlVedioPan().getAuxStreamJC().removeAllItems();
        getSiteControlVedioPan().getMainStreamJC().removeAllItems();
    }
    
    public void setAuxStreamEx()
    {
        
        siteURI = getSelectedSiteUri();
        Integer controlCode = (getSiteControlVedioPan().getSendAuxStreamCK().isSelected()?1:0);
       Integer result =  siteService.setAuxStreamEx(siteURI, controlCode);
       
       if(null == siteURI || null == controlCode ){
           return;
       }
       
       if(0 == result){
           if(0 == controlCode){
               getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_sendAuxStream_success[DataBase.getInstance().getLanguageFlag()]+result); 
               getSiteControlVedioPan().getSendAuxStreamCK().setSelected(true);
               getSiteControlVedioPan().getSendAuxStreamBtn().setText(    LabelText.siteCtol_video_sendAuxStreamBtn_stop[DataBase.getInstance().getLanguageFlag()]);
           }else{
               getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_notSendAuxStream_success[DataBase.getInstance().getLanguageFlag()]+result); 
               getSiteControlVedioPan().getSendAuxStreamCK().setSelected(false);
               getSiteControlVedioPan().getSendAuxStreamBtn().setText(    LabelText.siteCtol_video_sendAuxStreamBtn_start[DataBase.getInstance().getLanguageFlag()]);
           }
           
       }else{
           if(0 == controlCode){
               getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_sendAuxStream_error[DataBase.getInstance().getLanguageFlag()]+result); 
               return;
           }else{
               getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_notSendAuxStream_error[DataBase.getInstance().getLanguageFlag()]+result); 
               return;
           }
       }
    }
    
    public void controlCameraButAction(Integer controlCode){
        String camSrc = ((ItemObject)getSiteControlVedioPan().getMainStreamJC().getSelectedItem()).getKey();
        System.out.println("camSrc：==" +camSrc);
        CameraControlEx cameraControl = new CameraControlEx();
        cameraControl.setCamPos(255);
        cameraControl.setCamSrc(Integer.parseInt(camSrc));
        cameraControl.setCamState(0);
        switch (controlCode) {
        case 0:

            cameraControl.setCamAction(2);
            int result = siteService.ctrlCameraEx(siteURI, cameraControl);
            if(0 == result){
                getResultPan().showResultMsg(true, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_up_success[DataBase.getInstance().getLanguageFlag()]+result);
                getSiteControlVedioPan().getKoalaPic().setText(LabelText.siteCtol_video_up1[DataBase.getInstance().getLanguageFlag()]);
                
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                cameraControl.setCamAction(10);
                int res = siteService.ctrlCameraEx(siteURI, cameraControl);
                if(0 == res)
                {
                    getSiteControlVedioPan().getKoalaPic().setText("");
                }

            }else{
                getResultPan().showResultMsg(false, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_up_error[DataBase.getInstance().getLanguageFlag()]+result);
            }
            break;
        case 1:

            cameraControl.setCamAction(3);
            int result1 = siteService.ctrlCameraEx(siteURI, cameraControl);
            if(0 == result1){
                getResultPan().showResultMsg(true, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_down_success[DataBase.getInstance().getLanguageFlag()]+result1);
                getSiteControlVedioPan().getKoalaPic().setText(LabelText.siteCtol_video_down1[DataBase.getInstance().getLanguageFlag()]);
                
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                cameraControl.setCamAction(11);
                int res = siteService.ctrlCameraEx(siteURI, cameraControl);
                if(0 == res)
                {
                    getSiteControlVedioPan().getKoalaPic().setText("");
                }
            }else{
                getResultPan().showResultMsg(false, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_down_error[DataBase.getInstance().getLanguageFlag()]+result1);
            }
            break;
        case 2:

            cameraControl.setCamAction(1);
            int result2 = siteService.ctrlCameraEx(siteURI, cameraControl);
            if(0 == result2){
                getResultPan().showResultMsg(true, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_left_success[DataBase.getInstance().getLanguageFlag()]+result2);
                getSiteControlVedioPan().getKoalaPic().setText(LabelText.siteCtol_video_left1[DataBase.getInstance().getLanguageFlag()]);
                
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                cameraControl.setCamAction(9);
                int res = siteService.ctrlCameraEx(siteURI, cameraControl);
                if(0 == res)
                {
                    getSiteControlVedioPan().getKoalaPic().setText("");
                }
            }else{
                getResultPan().showResultMsg(false, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_left_error[DataBase.getInstance().getLanguageFlag()]+result2);
            }
            break;
        case 3:

            cameraControl.setCamAction(0);
            int result3 = siteService.ctrlCameraEx(siteURI, cameraControl);
            if(0 == result3){
                getResultPan().showResultMsg(true, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_right_success[DataBase.getInstance().getLanguageFlag()]+result3);
                getSiteControlVedioPan().getKoalaPic().setText(LabelText.siteCtol_video_right1[DataBase.getInstance().getLanguageFlag()]);
                
                try
                {
                    Thread.sleep(200);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                cameraControl.setCamAction(8);
                int res = siteService.ctrlCameraEx(siteURI, cameraControl);
                if(0 == res)
                {
                    getSiteControlVedioPan().getKoalaPic().setText("");
                }
            }else{
                getResultPan().showResultMsg(false, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_right_error[DataBase.getInstance().getLanguageFlag()]+result3);
            }
            break;
        case 4:

            cameraControl.setCamAction(16);
            int result4 =  siteService.ctrlCameraEx(siteURI, cameraControl);
            if(0 == result4){
                getResultPan().showResultMsg(true, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_reset_success[DataBase.getInstance().getLanguageFlag()]+result4);
                getSiteControlVedioPan().getKoalaPic().setText(LabelText.siteCtol_video_center1[DataBase.getInstance().getLanguageFlag()]);
                
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                getSiteControlVedioPan().getKoalaPic().setText("");
            }else{
                getResultPan().showResultMsg(false, 
                    LabelText.bottom_result_panel_msg_ctrlCameraEx_reset_error[DataBase.getInstance().getLanguageFlag()]+result4);
            }
            break;
        default:
            break;
        }
    }
    
    public void logout()
    {
        
        KeepAliveThread.setFlag(1);
        
        new AuthorizeService().logout();

        DemoApp.mainFrame.setVisible(false);

        DemoApp.loginFrame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private String getSelectedSiteUri(){
        int selectRow = getSiteControlSiteListPan().getSiteList().getSelectedRow();
        Vector<Vector<String>> tableData = getSiteControlSiteListPan().getTableMode().getDataVector();
        Vector<String> sitedata = tableData.get(selectRow);
        return sitedata.get(0);
    }
    
    
    private SiteControlVedioPan getSiteControlVedioPan(){
        return getSiteControlPanel().getSiteControlVedioPan();
    }
    private SiteControlSiteListPan getSiteControlSiteListPan(){
        return getSiteControlPanel().getSiteControlSiteListPan();
    }
    private SiteControlPanel getSiteControlPanel(){
        return DemoApp.mainFrame.getPan3();
    }

    public ResultPan getResultPan(){
        return getSiteControlPanel().getBottom_show_result_panel();
    }

}
