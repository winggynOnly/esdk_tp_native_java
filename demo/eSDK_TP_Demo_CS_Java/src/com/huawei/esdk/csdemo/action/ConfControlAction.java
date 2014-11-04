package com.huawei.esdk.csdemo.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.enums.ContinuousPresenceMode;
import com.huawei.esdk.csdemo.mapping.ConfStatusMapping;
import com.huawei.esdk.csdemo.mapping.SiteStatusMapping;
import com.huawei.esdk.csdemo.mapping.SiteTypeMapping;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.AuthorizeService;
import com.huawei.esdk.csdemo.service.ConferenceService;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.csdemo.utils.KeepAliveThread;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.panel.ConfControlBottomPan;
import com.huawei.esdk.csdemo.view.panel.ConfControlMiddlePan;
import com.huawei.esdk.csdemo.view.panel.ConfControlPanel;
import com.huawei.esdk.csdemo.view.panel.ConfControlTopPan;
import com.huawei.esdk.csdemo.view.panel.ResultPan;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceStatusEx;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class ConfControlAction {

	private ConferenceService conferenceService = new ConferenceService();
	
	private ConfControlPanel confControlPanel;
	
	private String selectedConfId;
	private String selectedSiteRUI;
	private Date recurrenceConfBeginTime;
	

    
	
	public ConfControlAction(ConfControlPanel confControlPanel)
	{
		this.confControlPanel = confControlPanel;
	}
	public void searchButAction()
	{
	    selectedConfId = getSelectedConfId();
	    
	    String confName;
	    Integer confStatus;
	    String chairSite;
	    String broadcastSite;
	    String speakingSite;
	    Integer isLock;
	    Integer isAudioSwitch;
	    Integer swtichGate;
	    
		if(null == selectedConfId)
		{
//            JOptionPane.showConfirmDialog(null, "PLESAE SELECT A CONFERENCE ID", "error",
//                    JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION);
		    if(0 != getTopPane().getConfIdJCB().getItemCount())
		    {
		        getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_need_confId[DataBase.getInstance().getLanguageFlag()]);
		    }
		    else
		    {
		        clearComponentValue();
		        clearTableData();
		//        getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_need_confId[DataBase.getInstance().getLanguageFlag()]);
		    }
		        return ;
		}

		//query conference info
		RecurrenceConfInfoEx conference =  DataBase.getInstance().queryConferenceById(selectedConfId);
		
		if(null == conference)
		{
            getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_no_confReturn[DataBase.getInstance().getLanguageFlag()]);
			return ;
		}
		
	    clearComponentValue();
		
		// query conference status
		List<String> confIds = new ArrayList<String>();
		confIds.add(selectedConfId);
		TPSDKResponseEx<List<ConferenceStatusEx>> result	= conferenceService.queryConferencesStatusEx(confIds);
		
		
		if(0 != result.getResultCode())
		{
		    getResultPan().showResultMsg(false, LabelText.bottom_result_panel_queryConfStatus_error[DataBase.getInstance().getLanguageFlag()]+result.getResultCode());
	      	clearTableData();
		    return;
		}

		ConferenceStatusEx confStatusInfo = result.getResult().get(0);
//		Integer confStatus = confStatusInfo.getStatus();
//		conference.setStatus(confStatus);
		confName = confStatusInfo.getName();
		confStatus = confStatusInfo.getStatus();
		chairSite = confStatusInfo.getChair();
		broadcastSite = confStatusInfo.getBroadcast();
		speakingSite = confStatusInfo.getSpeaking();
		isLock = confStatusInfo.getIsLock();
		isAudioSwitch = confStatusInfo.getIsAudioSwitch();
		swtichGate = confStatusInfo.getSwitchGate();
		
		if(null == isAudioSwitch)
		{
		    isAudioSwitch = 0;
		}
		
		if(null == swtichGate)
		{
		    swtichGate = 50;
		}
		
		if(null == isLock)
		{
	          isLock = 0;
	    }
		
		if(null == chairSite)
		{
		    chairSite = "";
		}
		if(null == broadcastSite)
		{
		    broadcastSite = ""; 
        }
	      
		if(null == speakingSite)
		{
		    speakingSite = "";
        }
	    
		
		//判断是否为周期性会议
		if(null != conference.getSiteAccessInfos() && 0 != conference.getSiteAccessInfos().size())
		{
		    reRenderRecurrenceConf(conference,confStatus);
		}
		else
		{
		    reRenderNormalConf(conference,confStatus);
		}
		
		//
		

	      
        getTopPane().getSetAudioSwitchCK().setSelected(isAudioSwitch ==1);
        getTopPane().getSwitchGateSlider().setValue(swtichGate);
        
        getTopPane().getConfNameText().setText(confName);
        getTopPane().getConfStatusText().setText(ConfStatusMapping.int2String(confStatus));
        getTopPane().getIsConfLockedCK().setSelected(isLock == 1);

        getTopPane().getChairSiteText().setText(chairSite);
        getTopPane().getBroadcastSiteText().setText(broadcastSite);
        getTopPane().getSpeakSiteText().setText(speakingSite);

        //new add
        getBottomPane().getDuohuamianTypeText().setSelectedIndex(DataBase.getInstance().getHoldingConfCpResourceById(selectedConfId));
        getResultPan().showResultMsg(true, LabelText.bottom_result_panel_queryConfStatus_success[DataBase.getInstance().getLanguageFlag()]+result.getResultCode());
        getBottomPane().getDuohuamianTypeText().repaint();
	}
	
    protected void refreshSiteStatus()
    {
        String confid = getActualConfId();
//        if(getTopPane().getRecurrenceCB().isEnabled())
//        {
//            int selectedIndex = getTopPane().getRecurrenceCB().getSelectedIndex();
//
//            confid = String.valueOf(Integer.parseInt(confid)+ selectedIndex + 1);
//        }
        
        TPSDKResponseEx<List<SiteStatusEx>> statusResult = conferenceService.
                queryConfSitesStatusEx(confid, null);
        
        if (0 != statusResult.getResultCode())
        {
            getResultPan().showResultMsg(false,
                    LabelText.refresh_site_failure[DataBase.getInstance()
                            .getLanguageFlag()]);
            return;
        }

        
        List<SiteStatusEx> siteList = statusResult.getResult();
        //init table data
        Vector<Vector<String>> tableData = new Vector<Vector<String>>();

            for(SiteStatusEx siteInfo : siteList)
            {
                Vector<String> item = new Vector<String>();
                item.add(siteInfo.getUri());
                item.add(siteInfo.getName());
                item.add(SiteTypeMapping.int2String(siteInfo.getType()));

                tableData.add(item);
            }

        
      //init table title
        Vector<String> tableTitle = new Vector<String>();
        int columnCount = getMiddlePane().getTableMode().getColumnCount();
        for(int i = 0;i < columnCount;i++){
            tableTitle.add(getMiddlePane().getTableMode().getColumnName(i));
        }
        //

        getMiddlePane().getTableMode().setDataVector(tableData, tableTitle);
        getMiddlePane().getTableMode().fireTableDataChanged();
        
        getResultPan().showResultMsg( true,
                LabelText.refresh_site_success[DataBase.getInstance()
                        .getLanguageFlag()]);
    }
    
	private void reRenderNormalConf(RecurrenceConfInfoEx conference, Integer confStatus){
	    getTopPane().getRecurrenceCB().removeAllItems();
	    getTopPane().getRecurrenceCB().setEnabled(false);
	    recurrenceConfBeginTime = null;
	    
//        List<SiteInfoEx> siteList = conference.getSites();
//        //init table data
//        Vector<Vector<String>> tableData = new Vector<Vector<String>>();
//        int confNotExist = 1;
//        if(confNotExist != confStatus)
//        {
//            for(SiteInfoEx siteInfo : siteList)
//            {
//                Vector<String> item = new Vector<String>();
//                item.add(siteInfo.getUri());
//                item.add(siteInfo.getName());
//                
//                SiteInfoEx site = DataBase.getInstance().querySiteByUri(siteInfo.getUri());
//                if(null == site){
//                    item.add(SiteTypeMapping.int2String(4));
//                }else{
//                    item.add(SiteTypeMapping.int2String(site.getType()));
//                }
//
//                tableData.add(item);
//            }
//        }
//        
//      //init table title
//        Vector<String> tableTitle = new Vector<String>();
//        int columnCount = getMiddlePane().getTableMode().getColumnCount();
//        for(int i = 0;i < columnCount;i++){
//            tableTitle.add(getMiddlePane().getTableMode().getColumnName(i));
//        }
//        //
//
//        getMiddlePane().getTableMode().setDataVector(tableData, tableTitle);
//        getMiddlePane().getTableMode().fireTableDataChanged();
	    
      int confNotExist = 1;
      if(confNotExist != confStatus)
      {
          refreshSiteStatus();
      }

	}
	
	private void reRenderRecurrenceConf(RecurrenceConfInfoEx conference, Integer confStatus){
	    getTopPane().getRecurrenceCB().setEnabled(true);
	       //去重
        Set<Date> beginTimes = new LinkedHashSet<Date>();
        
        for(SiteAccessInfoEx siteAccess:conference.getSiteAccessInfos()){
            beginTimes.add(siteAccess.getBeginTime());
        }
       
        List<Date> beginTimeList = new ArrayList<Date>();
        for(Date date : beginTimes){
            beginTimeList.add(date);
        }
        Collections.sort(beginTimeList);
        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        for(Date date : beginTimeList){
            getTopPane().getRecurrenceCB().addItem(DateUtils.date2yyyyMMddHHmmss(date));
        }
        
        getTopPane().getRecurrenceCB().setSelectedIndex(0);
        
//        Date selectedTime =  DateUtils.yyyyMMddHHmmss2date(getTopPane().getRecurrenceCB().getItemAt(0).toString());
//
//        if(null == selectedTime){
//            return;
//        }
//        
//        List<Integer> siteUriList = new ArrayList<Integer>();
//        
//        int count = 0;
//        for(SiteAccessInfoEx siteAccess : conference.getSitesAccessInfo()){
//            if(selectedTime.equals(siteAccess.getBeginTime())){
//                siteUriList.add(count);
//            }
//            count++;
//        }
//        
//        
//        List<SiteInfoEx> siteList = new ArrayList<SiteInfoEx>();
//        //
//        for(int index : siteUriList){
//            siteList.add (conference.getSites().get(index));
//        }
//
//        //
//        
//        Vector<Vector<String>> tableData = new Vector<Vector<String>>();
//        int confNotExist = 1;
//        if(confNotExist != confStatus)
//        {
//            for(SiteInfoEx siteInfo : siteList)
//            {
//                Vector<String> item = new Vector<String>();
//                item.add(siteInfo.getUri());
//                item.add(siteInfo.getName());
//                
//                SiteInfoEx site = DataBase.getInstance().querySiteByUri(siteInfo.getUri());
//                if(null == site){
//                    item.add(SiteTypeMapping.int2String(4));
//                }else{
//                    item.add(SiteTypeMapping.int2String(site.getType()));
//                }
//
//                tableData.add(item);
//            }
//        }
//        
//        Vector<String> tableTitle = new Vector<String>();
//        int columnCount = getMiddlePane().getTableMode().getColumnCount();
//        for(int i = 0;i < columnCount;i++){
//            tableTitle.add(getMiddlePane().getTableMode().getColumnName(i));
//        }
//        //
////        getTopPane().getSetAudioSwitchCK().setSelected(isAudioSwitch ==1);
////        getTopPane().getSwitchGateSlider().setValue(swtichGate);
////        
////        getTopPane().getConfNameText().setText(conference.getName());
////        getTopPane().getConfStatusText().setText(ConfStatusMapping.int2String(conference.getStatus()));
//        getMiddlePane().getTableMode().setDataVector(tableData, tableTitle);
//        getMiddlePane().getTableMode().fireTableDataChanged();
        
        int confNotExist = 1;
        if(confNotExist != confStatus)
        {
            refreshSiteStatus();
        }
	}
	
    public void recurrenceComboxAction()
    {
//        RecurrenceConfInfoEx conference =  DataBase.getInstance().queryConferenceById(selectedConfId);
//        
//        recurrenceConfBeginTime =  DateUtils.yyyyMMddHHmmss2date(getTopPane().getRecurrenceCB().getSelectedItem().toString());
//
//        if(null == recurrenceConfBeginTime){
//            return;
//        }
//        
//        List<Integer> siteUriList = new ArrayList<Integer>();
//        
//        int count = 0;
//        for(SiteAccessInfoEx siteAccess : conference.getSitesAccessInfo()){
//            if(recurrenceConfBeginTime.equals(siteAccess.getBeginTime())){
//                siteUriList.add(count);
//            }
//            count++;
//        }
//        
//        
//        List<SiteInfoEx> siteList = new ArrayList<SiteInfoEx>();
//        //
//        for(int index : siteUriList){
//            siteList.add (DataBase.getInstance().getAllSiteMap().get(conference.getSites().get(index).getUri()));
//        }
//
//        //
//        
//        Vector<Vector<String>> tableData = new Vector<Vector<String>>();
//        for(SiteInfoEx siteInfo : siteList){
//            Vector<String> item = new Vector<String>();
//            if(null != siteInfo){
//                item.add(siteInfo.getUri());
//                item.add(siteInfo.getName());
//                item.add(SiteTypeMapping.int2String(siteInfo.getType()));
//            }
//            else
//            {
//                item.add("");
//                item.add("");
//                item.add(SiteTypeMapping.int2String(4));
//            }
//            tableData.add(item);
//        }
//        
//        Vector<String> tableTitle = new Vector<String>();
//        int columnCount = getMiddlePane().getTableMode().getColumnCount();
//        for(int i = 0;i < columnCount;i++){
//            tableTitle.add(getMiddlePane().getTableMode().getColumnName(i));
//        }
//        //
//
//        getMiddlePane().getTableMode().setDataVector(tableData, tableTitle);
//        getMiddlePane().getTableMode().fireTableDataChanged();
         refreshSiteStatus();
//        clearComponentValue();
    }
	
	private  void clearComponentValue(){
	    getTopPane().getConfNameText().setText("");
	    getTopPane().getConfStatusText().setText("");
	    getTopPane().getIsConfLockedCK().setSelected(false);
	    getTopPane().getChairSiteText().setText("");
	    getTopPane().getSpeakSiteText().setText("");
	    getTopPane().getBroadcastSiteText().setText("");
	    getTopPane().getSetAudioSwitchCK().setSelected(false);
	    getTopPane().getSwitchGateSlider().setValue(50);
	    getTopPane().getRecurrenceCB().removeAllItems();
//	    int rowCount = getMiddlePane().getTableMode().getRowCount();
//	    for(int i =0 ;i < rowCount; i++){
//	        getMiddlePane().getTableMode().set
//	    }
	    getMiddlePane().getSiteStatusText().setText("");
        getMiddlePane().getConfHowLongText().setText("");
        getMiddlePane().getStartTimeText().setText("");
        getMiddlePane().getSiteNameText().setText("");
        getMiddlePane().getMikeOff().setVisible(false);
        getMiddlePane().getMikeOn().setVisible(false);
        getMiddlePane().getSpeakerOff().setVisible(false);
        getMiddlePane().getSpeakerOn().setVisible(false);
        getMiddlePane().getBroadcasting().setVisible(false);
        getBottomPane().getSiteUriText().setText("");
        getBottomPane().getVideoSourceUriText().setText("");
        getBottomPane().getDuohuamianTypeText().setSelectedIndex(0);
	}
	
	private void clearTableData(){
        Vector<Vector<String>> tableData = new Vector<Vector<String>>();
        
        Vector<String> tableTitle = new Vector<String>();
        int columnCount = getMiddlePane().getTableMode().getColumnCount();
        for(int i = 0;i < columnCount;i++)
        {
            tableTitle.add(getMiddlePane().getTableMode().getColumnName(i));
        }

        getMiddlePane().getTableMode().setDataVector(tableData, tableTitle);
        getMiddlePane().getTableMode().fireTableDataChanged();
	}
	
	public void querySiteByUriSiteCtrl(){
	    
        getBottomPane().getDuohuamianTypeText().setSelectedIndex(DataBase.getInstance().getHoldingConfCpResourceById(selectedConfId));
        getBottomPane().getDuohuamianTypeText().repaint();
        getBottomPane().getVideoSourceUriText().setText("");
	    selectedSiteRUI = getSelectedSiteUri();
		if(null == selectedConfId || null == selectedSiteRUI){
			return;
		}

	    List<String> siteUris = new ArrayList<String>();
	    siteUris.add(selectedSiteRUI);
		

		ConferenceInfoEx conference =  DataBase.getInstance().queryConferenceById(selectedConfId);
//		Site selectedSite = DataBase.confSiteMapping.get(selectedConfId).getSiteInConf().get(selectedSiteRUI);
		

		
		TPSDKResponseEx<List<SiteStatusEx>> siteStatusResult = conferenceService.queryConfSitesStatusEx(selectedConfId, siteUris);
		if(0 != siteStatusResult.getResultCode()){
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_querySiteByUri_error[DataBase.getInstance().getLanguageFlag()]
                +siteStatusResult.getResultCode());
            return ;
		}else{
		    getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_querySiteByUri_success[DataBase.getInstance().getLanguageFlag()]
		        +siteStatusResult.getResultCode());
		}
		
		SiteStatusEx siteStatus = siteStatusResult.getResult().get(0);
		
		//Integer status = selectedSite.getStatus();
		
		getMiddlePane().getSiteNameText().setText(siteStatus.getName());		
		
		if(null != recurrenceConfBeginTime){
		    getMiddlePane().getStartTimeText().setText(DateUtils.date2yyyyMMddHHmmss(recurrenceConfBeginTime));
		}else{
		    getMiddlePane().getStartTimeText().setText(DateUtils.date2yyyyMMddHHmmss(conference.getBeginTime()));
		}
		
		
		getMiddlePane().getConfHowLongText().setText(String.valueOf( DurationUtils.duration2int(conference.getDuration())));
		getMiddlePane().getSiteStatusText().setText(SiteStatusMapping.int2String(siteStatus.getStatus()));
		
		getBottomPane().getSiteUriText().setText(selectedSiteRUI);
//		getBottomPane().getVideoSourceUriText().setText(siteStatus.getVideoSource());
		
		if(1 == siteStatus.getIsMute()){
			getMiddlePane().getMikeOff().setVisible(true);
			getMiddlePane().getMikeOn().setVisible(false);
			getMiddlePane().getMuteSiteBut().setText(LabelText.confCtol_middle_stop_muteSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}else{
			getMiddlePane().getMikeOff().setVisible(false);
			getMiddlePane().getMikeOn().setVisible(true);
			getMiddlePane().getMuteSiteBut().setText(LabelText.confCtol_middle_muteSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}
		
		if(1 == siteStatus.getIsQuiet()){
			getMiddlePane().getSpeakerOff().setVisible(true);
			getMiddlePane().getSpeakerOn().setVisible(false);
			getMiddlePane().getQuietSiteBut().setText(LabelText.confCtol_middle_stop_quietSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}else{
			getMiddlePane().getSpeakerOff().setVisible(false);
			getMiddlePane().getSpeakerOn().setVisible(true);
			getMiddlePane().getQuietSiteBut().setText(LabelText.confCtol_middle_quietSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}
		
		int isBroadcasting = 1;
		if(0 == isBroadcasting){
			getMiddlePane().getBroadcasting().setVisible(true);
			getMiddlePane().getBroadcastSiteBut().setText(LabelText.confCtol_middle_stop_broadcastSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}else{
			getMiddlePane().getBroadcasting().setVisible(false);
			getMiddlePane().getBroadcastSiteBut().setText(LabelText.confCtol_middle_broadcastSiteBut[DataBase.getInstance().getLanguageFlag()]);
		}
		
		int isBroadcastingPresence = 1;
        if(0 == isBroadcastingPresence){
            getMiddlePane().getBroadcastingPresence().setVisible(true);
            getMiddlePane().getBroadcastContinuousPresenceBut().setText(LabelText.confCtol_middle_stop_broadcastContinuousPresenceBut[DataBase.getInstance().getLanguageFlag()]);
        }else{
            getMiddlePane().getBroadcastingPresence().setVisible(false);
            getMiddlePane().getBroadcastContinuousPresenceBut().setText(LabelText.confCtol_middle_broadcastContinuousPresenceBut[DataBase.getInstance().getLanguageFlag()]);
        }

	}
	
	public void setAudioSwitchEx(){

		boolean isChecked =	getTopPane().getSetAudioSwitchCK().isSelected();
		Integer switchGate = getTopPane().getSwitchGateSlider().getValue();
		
		int result = conferenceService.setAudioSwitchEx(getActualConfId(), switchGate, isChecked?1:0);
		
		
		
		if(0 == result){
//			DataBase.confSiteMapping.get(selectedConfId).setSwithGate(switchGate);
//			DataBase.confSiteMapping.get(selectedConfId).setSwithOnOff(isChecked?1:0);
			getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setAudioSwitch_success[DataBase.getInstance().getLanguageFlag()]
			    +result);
		}else{
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setAudioSwitch_error[DataBase.getInstance().getLanguageFlag()]+
                result);
            return;
		}
		
	}
	
	public void setBroadcastSiteEx() {

		Integer isBroadcast = (getMiddlePane().getBroadcasting().isVisible()?1:0);

		int result = conferenceService.setBroadcastSiteEx(getActualConfId(), selectedSiteRUI, isBroadcast);
		
		if(0 == result){

//			Map<String,Site> siteInConf = DataBase.confSiteMapping.get(selectedConfId).getSiteInConf();
//			for(String key :siteInConf.keySet()){
//				if(key.equals(selectedSiteRUI)){
//					siteInConf.get(key).setIsBroadcasting(isBroadcast);
//				}else{
//					siteInConf.get(key).setIsBroadcasting(isBroadcast == 0?1:0);
//				}
//			}
			
//			DataBase.confSiteMapping.get(confId).getSiteInConf().get(siteUri).setIsBroadcasting(isBroadcast);
			if(0 == isBroadcast){
			    getResultPan().showResultMsg(true,LabelText.bottom_result_panel_msg_setBroadcastSite_success[DataBase.getInstance().getLanguageFlag()] + result);
				getMiddlePane().getBroadcasting().setVisible(true);
				getMiddlePane().getBroadcastSiteBut().setText(LabelText.confCtol_middle_stop_broadcastSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}else{
			    getResultPan().showResultMsg(true,LabelText.bottom_result_panel_msg_setBroadcastSite_close_success[DataBase.getInstance().getLanguageFlag()] + result);
				getMiddlePane().getBroadcasting().setVisible(false);
				getMiddlePane().getBroadcastSiteBut().setText(LabelText.confCtol_middle_broadcastSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}
			
	         
		}else{
		    if(0 == isBroadcast){
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setBroadcastSite_error[DataBase.getInstance().getLanguageFlag()]
                + result);
		    }
		    else
		    {
	            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setBroadcastSite_close_error[DataBase.getInstance().getLanguageFlag()]
	                + result);
		    }
            return;
		}
	}

	public void setSitesMuteEx(){

		List<String> siteUris = new ArrayList<String>();
		siteUris.add(selectedSiteRUI);
		
		Integer isMute = (getMiddlePane().getMikeOff().isVisible()?1:0);

		int result = conferenceService.setSitesMuteEx(getActualConfId(), siteUris, isMute);
		if(0 == result){
			if(0 == isMute){
				getMiddlePane().getMikeOff().setVisible(true);
				getMiddlePane().getMikeOn().setVisible(false);
	            getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setSitesMute_success[DataBase.getInstance().getLanguageFlag()]
	                +result);
	            getMiddlePane().getMuteSiteBut().setText(LabelText.confCtol_middle_stop_muteSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}else{
				getMiddlePane().getMikeOff().setVisible(false);
				getMiddlePane().getMikeOn().setVisible(true);
	            getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setSitesMute_close_success[DataBase.getInstance().getLanguageFlag()]
	                +result);
	            getMiddlePane().getMuteSiteBut().setText(LabelText.confCtol_middle_muteSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}

		}else{
	        if(0 == isMute)
	        {
	            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setSitesMute_error[DataBase.getInstance().getLanguageFlag()]+ result);
	        }
            else
            {
                getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setSitesMute_close_error[DataBase.getInstance().getLanguageFlag()]
                    + result);
            }
            return;
		}
	}

	public void setSitesQuietEx(){
		
		List<String> siteUris = new ArrayList<String>();
		siteUris.add(selectedSiteRUI);
		
		
		Integer isMute = (getMiddlePane().getSpeakerOff().isVisible()?1:0);

		int result = conferenceService.setSitesQuietEx(getActualConfId(), siteUris, isMute);
		
		if(0 == result){
			if(0 == isMute){
				getMiddlePane().getSpeakerOff().setVisible(true);
				getMiddlePane().getSpeakerOn().setVisible(false);
	             getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setSitesQuiet_success[DataBase.getInstance().getLanguageFlag()]+result);
	             getMiddlePane().getQuietSiteBut().setText(LabelText.confCtol_middle_stop_quietSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}else{
				getMiddlePane().getSpeakerOff().setVisible(false);
				getMiddlePane().getSpeakerOn().setVisible(true);
	             getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setSitesQuiet_close_success[DataBase.getInstance().getLanguageFlag()]+result);
	             getMiddlePane().getQuietSiteBut().setText(LabelText.confCtol_middle_quietSiteBut[DataBase.getInstance().getLanguageFlag()]);
			}

		}else{
		    if(0 == isMute)
		    {
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setSitesQuiet_error[DataBase.getInstance().getLanguageFlag()]
                + result);
		    }
		    else
		    {
	            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setSitesQuiet_close_error[DataBase.getInstance().getLanguageFlag()]
	                + result);
		    }
            return;
		}
	}

	public void setBroadcastContinuousPresenceEx(){

	    Integer isBroadcast = (getMiddlePane().getBroadcastingPresence().isVisible()?1:0);
	    
		Integer result = conferenceService.setBroadcastContinuousPresenceEx(getActualConfId(), isBroadcast);
		if(0 != result){
            if(0 == isBroadcast)
            {
                getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setBroadcastContinuousPresence_error[DataBase.getInstance().getLanguageFlag()]
                    + result);
            }
            else
            {
                getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setBroadcastContinuousPresence_close_error[DataBase.getInstance().getLanguageFlag()]
                    + result);
            }
        }else{
            if(0 == isBroadcast)
            {
                getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setBroadcastContinuousPresence_success[DataBase.getInstance().getLanguageFlag()]
                    +result);
                getMiddlePane().getBroadcastingPresence().setVisible(true);
                getMiddlePane().getBroadcastContinuousPresenceBut().setText(LabelText.confCtol_middle_stop_broadcastContinuousPresenceBut[DataBase.getInstance().getLanguageFlag()]);
            }
            else
            {
                getResultPan().showResultMsg(true, LabelText.bottom_result_panel_msg_setBroadcastContinuousPresence_close_success[DataBase.getInstance().getLanguageFlag()]
                    +result);
                getMiddlePane().getBroadcastingPresence().setVisible(false);
                getMiddlePane().getBroadcastContinuousPresenceBut().setText(LabelText.confCtol_middle_broadcastContinuousPresenceBut[DataBase.getInstance().getLanguageFlag()]);
            }
        }
	}

	public void setVideoSourceEx(){
		String videoSourceUri = getBottomPane().getVideoSourceUriText().getText();
		
		Integer isLock = 0;
		Integer result = conferenceService.setVideoSourceEx(selectedConfId, selectedSiteRUI, videoSourceUri, isLock);
		
		if(0 != result){
            getResultPan().showResultMsg(false, LabelText.bottom_result_panel_msg_setVideoSource_error[DataBase.getInstance().getLanguageFlag()]+ 
                result);
            return;
		}else{
		    getResultPan().showResultMsg(true,LabelText.bottom_result_panel_msg_setVideoSource_success[DataBase.getInstance().getLanguageFlag()]+result);
		}
	}

    public void setContinuousPresenceEx()
    {
        String target = getBottomPane().getDuohuamianUriText().getText();
        
        String presenceModeStr = ((ItemObject)getBottomPane().getDuohuamianTypeText().getSelectedItem()).toString();
        
        List<String> subPics = new ArrayList<String>();
        Integer result =
            conferenceService.setContinuousPresenceEx(selectedConfId,
                target,
                ContinuousPresenceMode.getIndex(presenceModeStr),
                subPics);
        
        if (0 != result)
        {

            getResultPan().showResultMsg(false,LabelText.bottom_result_panel_msg_setContinuousPresence_error[DataBase.getInstance().getLanguageFlag()]
                + result);
            return;
        }else{
            DataBase.getInstance().saveHoldingConfCpResourceById(selectedConfId, getBottomPane().getDuohuamianTypeText().getSelectedIndex());
            getResultPan().showResultMsg(true,LabelText.bottom_result_panel_msg_setContinuousPresence_success[DataBase.getInstance().getLanguageFlag()]
                +result);
        }
    }
	
	public void logout(){
        KeepAliveThread.setFlag(1);
        
        new AuthorizeService().logout();

        DemoApp.mainFrame.setVisible(false);

        DemoApp.loginFrame.setVisible(true);
	}
	
	private String getActualConfId()
	{
        String confId = selectedConfId;
        if(getTopPane().getRecurrenceCB().isEnabled())
        {
            int selectedIndex = getTopPane().getRecurrenceCB().getSelectedIndex();
    
            confId = String.valueOf(Integer.parseInt(selectedConfId)+ selectedIndex + 1);
        }
        return confId;
	}
	
	public ConfControlTopPan getTopPane(){
		return getConfControlPanel().getTopPan();
	}
	public ConfControlMiddlePan getMiddlePane(){
		return getConfControlPanel().getMiddlePan();
	}
	public ConfControlBottomPan getBottomPane(){
		return getConfControlPanel().getBottomPan();
	}
	private String getSelectedConfId(){
		return (String) getTopPane().getConfIdJCB().getSelectedItem();
	}
	@SuppressWarnings("unchecked")
    private String getSelectedSiteUri(){
		int selectRow = getMiddlePane().getJtable().getSelectedRow();
		Vector<Vector<String>> tableData = getMiddlePane().getTableMode().getDataVector();
		Vector<String> sitedata = tableData.get(selectRow);
		return sitedata.get(0);
	}
	private ResultPan getResultPan(){
	    return getConfControlPanel().getBottom_show_result_panel();
	}
	public ConferenceService getConferenceService() {
		return conferenceService;
	}
	public void setConferenceService(ConferenceService conferenceService) {
		this.conferenceService = conferenceService;
	}
	public ConfControlPanel getConfControlPanel() {
		return confControlPanel;
	}
	public void setConfControlPanel(ConfControlPanel confControlPanel) {
		this.confControlPanel = confControlPanel;
	}

	
}
