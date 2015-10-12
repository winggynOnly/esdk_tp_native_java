package com.huawei.esdk.csdemo.action;

import java.util.Vector;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import com.huawei.esdk.csdemo.common.ItemObject;
import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.ConferenceService;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.csdemo.view.ScheduleConfFrame;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class ScheduleConfAction
{
    private ConferenceService confService = new ConferenceService();

    private ScheduleConfFrame scheduleConfFrame;

    public ScheduleConfAction(ScheduleConfFrame scheduleConfFrame)
    {
        this.scheduleConfFrame = scheduleConfFrame;
    }

    @SuppressWarnings("unchecked")
    public void scheduleConf()
    {
        int result = 0;
        if (scheduleConfFrame.getRecurrenceFlag().isSelected())
        {
            RecurrenceConfInfoEx conf = new RecurrenceConfInfoEx();
            ItemObject frequency = (ItemObject) scheduleConfFrame
                    .getRecurrenceConfDetail().getFrequencyBox()
                    .getSelectedItem();
            try
            {
                conf.setFrequency(Integer.parseInt(frequency.getKey()));
                String interval = scheduleConfFrame.getRecurrenceConfDetail()
                        .getIntervalText().getText();
                conf.setInterval("".equals(interval) ? null : Integer
                        .parseInt(interval));
                Object[] weekdays = scheduleConfFrame.getRecurrenceConfDetail()
                        .getWeekDaysList().getSelectedValues();
                for (int i = 0; i < weekdays.length; i++)
                {
                    ItemObject obj = (ItemObject) weekdays[i];
                    conf.getWeekDays().add(Integer.parseInt(obj.getKey()));
                }
                String weekday = scheduleConfFrame.getRecurrenceConfDetail()
                        .getWeekDayText().getText();
                conf.setWeekDay("".equals(weekday) ? null : Integer
                        .parseInt(weekday));
                String monthday = scheduleConfFrame.getRecurrenceConfDetail()
                        .getMonthDayText().getText();
                conf.setMonthDay("".equals(monthday) ? null : Integer
                        .parseInt(monthday));
                String count = scheduleConfFrame.getRecurrenceConfDetail()
                        .getCountText().getText();
                conf.setCount("".equals(count) ? null : Integer.parseInt(count));
            }
            catch (NumberFormatException e)
            {
                DemoApp.mainFrame
                .getPan1()
                .getBottom_show_result_panel()
                .showResultMsg(
                        false,
                        LabelText.number_too_larger[DataBase
                                .getInstance().getLanguageFlag()]);
                return;
            }

            String enddate = scheduleConfFrame.getRecurrenceConfDetail()
                    .getDateText().getText();
            conf.setEndDate("".equals(enddate) ? null : DateUtils
                    .yyyyMMddHHmmss2date(enddate));

            conf.setConfId(scheduleConfFrame.getConfIdText().getText());
            conf.setName(scheduleConfFrame.getConfNameText().getText());
            conf.setBeginTime(scheduleConfFrame.getConfBeginTimeText()
                    .getDate());
            try
            {
                conf.setDuration(DatatypeFactory.newInstance().newDuration(
                        "PT" + scheduleConfFrame.getConfHowLongText().getText()
                                + "M"));
            }
            catch (DatatypeConfigurationException ex)
            {
                ex.printStackTrace();
            }

            Vector<Vector<String>> sites = scheduleConfFrame.getTableMode()
                    .getDataVector();
            SiteInfoEx siteInfo = null;
            for (Vector<String> site : sites)
            {
                siteInfo = new SiteInfoEx();
                siteInfo.setUri(site.get(0));
                siteInfo.setName(site.get(1));
                
                Integer siteType = null;
                if(!("".equals(site.get(2)))){
                    siteType = Integer.parseInt(site.get(2));
                }
                siteInfo.setType(siteType);
                conf.getSites().add(siteInfo);
            }

            conf.setPassword(scheduleConfFrame.getPasswordText().getText());
            //DTS2014052105833
            conf.setChairmanPassword(scheduleConfFrame.getChairmanPasswordText().getText());
            conf.setRate(scheduleConfFrame.getSpeedRateJC().getSelectedItem()
                    .toString());

            ItemObject itemObject = (ItemObject) scheduleConfFrame
                    .getContinuousPresenceJC().getSelectedItem();

            conf.setCpResouce(Integer.parseInt(itemObject.getKey()));

            TPSDKResponseEx<RecurrenceConfInfoEx> response = confService
                    .scheduleRecurrenceConfEx(conf);

            result = response.getResultCode();
            if (0 == result && null != response.getResult())
            {
                RecurrenceConfInfoEx confInfo = response.getResult();
                confInfo.setBeginTime(conf.getBeginTime());
                confInfo.setDuration(conf.getDuration());
                confInfo.setName(conf.getName());
                confInfo.setCpResouce(conf.getCpResouce());
                confInfo.setWeekDay(conf.getWeekDay());
                confInfo.setWeekDays(conf.getWeekDays());
                confInfo.setFrequency(conf.getFrequency());
                confInfo.setInterval(conf.getInterval());
                confInfo.setMonthDay(conf.getMonthDay());
                confInfo.setEndDate(conf.getEndDate());
                confInfo.setCount(conf.getCount());
                
                confInfo.setPassword(scheduleConfFrame.getPasswordText().getText());
                confInfo.setChairmanPassword(scheduleConfFrame.getChairmanPasswordText().getText());
                
                DataBase.getInstance().saveConference(confInfo);
                // confService.insertDataToExcel(confInfo);
            }
        }
        else
        // 预约非周期性会议
        {
            ConferenceInfoEx conf = new ConferenceInfoEx();
            conf.setConfId(scheduleConfFrame.getConfIdText().getText());
            conf.setName(scheduleConfFrame.getConfNameText().getText());
            conf.setBeginTime(scheduleConfFrame.getConfBeginTimeText()
                    .getDate());
            try
            {
                conf.setDuration(DatatypeFactory.newInstance().newDuration(
                        "PT" + scheduleConfFrame.getConfHowLongText().getText()
                                + "M"));
            }
            catch (DatatypeConfigurationException ex)
            {
                ex.printStackTrace();
            }

            Vector<Vector<String>> sites = scheduleConfFrame.getTableMode()
                    .getDataVector();
            SiteInfoEx siteInfo = null;
            for (Vector<String> site : sites)
            {
                siteInfo = new SiteInfoEx();
                siteInfo.setUri(site.get(0));
                siteInfo.setName(site.get(1));
                
                Integer siteType = null;
                if(!("".equals(site.get(2)))){
                    siteType = Integer.parseInt(site.get(2));
                }
                siteInfo.setType(siteType);
                conf.getSites().add(siteInfo);
            }

            conf.setPassword(scheduleConfFrame.getPasswordText().getText());
            //DTS2014052105833
            conf.setChairmanPassword(scheduleConfFrame.getChairmanPasswordText().getText());
            conf.setRate(scheduleConfFrame.getSpeedRateJC().getSelectedItem()
                    .toString());

            ItemObject itemObject = (ItemObject) scheduleConfFrame
                    .getContinuousPresenceJC().getSelectedItem();

            conf.setCpResouce(Integer.parseInt(itemObject.getKey()));

            TPSDKResponseEx<ConferenceInfoEx> response = confService
                    .scheduleConfEx(conf);
            result = response.getResultCode();
            if (0 == result && null != response.getResult())
            {
                ConferenceInfoEx info = response.getResult();
                RecurrenceConfInfoEx confInfo = new RecurrenceConfInfoEx();
                confInfo.setBeginTime(conf.getBeginTime());
                confInfo.setDuration(conf.getDuration());
                confInfo.setName(conf.getName());
                confInfo.setCpResouce(conf.getCpResouce());
                confInfo.setConfId(info.getConfId());
                confInfo.setAccessCode(info.getAccessCode());
                confInfo.getSites().addAll(info.getSites());
                confInfo.setPassword(scheduleConfFrame.getPasswordText().getText());
                confInfo.setChairmanPassword(scheduleConfFrame.getChairmanPasswordText().getText());
                DataBase.getInstance().saveConference(confInfo);
                // confService.insertDataToExcel(confInfo);
            }
        }

        // modify by gaolinfei
        if (0 != result)
        {
            DemoApp.mainFrame
                    .getPan1()
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            false,
                            LabelText.schedule_conf_failure[DataBase
                                    .getInstance().getLanguageFlag()] + result);
        }
        else
        {
            DemoApp.mainFrame
                    .getPan1()
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            true,
                            LabelText.schedule_conf_success[DataBase
                                    .getInstance().getLanguageFlag()]);

            DemoApp.mainFrame.getPan1().getConfListPanel().refreshTable();
            // 选中最新预约的会议那行数据
            int rowNumber = DemoApp.mainFrame.getPan1().getConfListPanel()
                    .getConfList().getRowCount();
            DemoApp.mainFrame.getPan1().getConfListPanel().getConfList()
                    .setRowSelectionInterval(rowNumber - 1, rowNumber - 1);

            scheduleConfFrame.getConfIdText().setText("");
            scheduleConfFrame.getConfNameText().setText("");
            scheduleConfFrame.getConfBeginTimeText().setText("");
            scheduleConfFrame.getConfHowLongText().setText("");
            scheduleConfFrame.dispose();
        }
    }
}
