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
import com.huawei.esdk.csdemo.view.EditConfFrame;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class EditConfAction
{

    private ConferenceService confService = new ConferenceService();

    private EditConfFrame editConfFrame;

    public EditConfAction(EditConfFrame editConfFrame)
    {
        this.editConfFrame = editConfFrame;
    }

    @SuppressWarnings("unchecked")
    public void editConf()
    {
        int result = 0;

        if (editConfFrame.getRecurrenceFlag().isSelected())
        {
            RecurrenceConfInfoEx conf = new RecurrenceConfInfoEx();
            ItemObject frequency = (ItemObject) editConfFrame
                    .getRecurrenceConfDetail().getFrequencyBox()
                    .getSelectedItem();
            conf.setFrequency(Integer.parseInt(frequency.getKey()));
            String interval = editConfFrame.getRecurrenceConfDetail()
                    .getIntervalText().getText();
            try
            {
                conf.setInterval("".equals(interval) ? null : Integer
                        .parseInt(interval));
                Object[] weekdays = editConfFrame.getRecurrenceConfDetail()
                        .getWeekDaysList().getSelectedValues();
                for (int i = 0; i < weekdays.length; i++)
                {
                    ItemObject obj = (ItemObject) weekdays[i];
                    conf.getWeekDays().add(Integer.parseInt(obj.getKey()));
                }
                String weekday = editConfFrame.getRecurrenceConfDetail()
                        .getWeekDayText().getText();
                conf.setWeekDay("".equals(weekday) ? null : Integer
                        .parseInt(weekday));
                String monthday = editConfFrame.getRecurrenceConfDetail()
                        .getMonthDayText().getText();
                conf.setMonthDay("".equals(monthday) ? null : Integer
                        .parseInt(monthday));
                String count = editConfFrame.getRecurrenceConfDetail()
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
            String enddate = editConfFrame.getRecurrenceConfDetail()
                    .getDateText().getText();
            conf.setEndDate("".equals(enddate) ? null : DateUtils
                    .yyyyMMddHHmmss2date(enddate));

            conf.setConfId(editConfFrame.getConfIdText().getText());
            conf.setName(editConfFrame.getConfNameText().getText());
            conf.setBeginTime(editConfFrame.getConfBeginTimeText().getDate());
            try
            {
                conf.setDuration(DatatypeFactory.newInstance().newDuration(
                        "PT" + editConfFrame.getConfHowLongText().getText()
                                + "M"));
            }
            catch (DatatypeConfigurationException ex)
            {
                ex.printStackTrace();
            }

            Vector<Vector<String>> sites = editConfFrame.getTableMode()
                    .getDataVector();
            SiteInfoEx siteInfo = null;
            for (Vector<String> site : sites)
            {
                siteInfo = new SiteInfoEx();
                siteInfo.setUri(site.get(0));
                siteInfo.setName(site.get(1));
                siteInfo.setType(Integer.parseInt(site.get(2)));
                conf.getSites().add(siteInfo);
            }

            conf.setPassword(editConfFrame.getPasswordText().getText());
            //DTS2014052105833
            conf.setChairmanPassword(editConfFrame.getChairmanPasswordText().getText());
            conf.setRate(editConfFrame.getSpeedRateJC().getSelectedItem()
                    .toString());

            ItemObject itemObject = (ItemObject) editConfFrame
                    .getContinuousPresenceJC().getSelectedItem();

            conf.setCpResouce(Integer.parseInt(itemObject.getKey()));

            TPSDKResponseEx<RecurrenceConfInfoEx> response = confService
                    .editRecurrenceConferenceEx(conf);
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
                confInfo.setPassword(editConfFrame.getPasswordText().getText());
                confInfo.setChairmanPassword(editConfFrame.getChairmanPasswordText().getText());

                DataBase.getInstance().removeConference(confInfo.getConfId());
                DataBase.getInstance().saveConference(confInfo);
                // confService.insertDataToExcel(confInfo);
            }
        }
        else
        {
            ConferenceInfoEx conf = new ConferenceInfoEx();

            conf.setConfId(editConfFrame.getConfIdText().getText());
            conf.setName(editConfFrame.getConfNameText().getText());
            conf.setBeginTime(editConfFrame.getConfBeginTimeText().getDate());
            try
            {
                conf.setDuration(DatatypeFactory.newInstance().newDuration(
                        "PT" + editConfFrame.getConfHowLongText().getText()
                                + "M"));
            }
            catch (DatatypeConfigurationException ex)
            {
                ex.printStackTrace();
            }

            Vector<Vector<String>> sites = editConfFrame.getTableMode()
                    .getDataVector();
            SiteInfoEx siteInfo = null;
            for (Vector<String> site : sites)
            {
                siteInfo = new SiteInfoEx();
                siteInfo.setUri(site.get(0));
                siteInfo.setName(site.get(1));
                siteInfo.setType(Integer.parseInt(site.get(2)));
                conf.getSites().add(siteInfo);
            }

            conf.setPassword(editConfFrame.getPasswordText().getText());
            //DTS2014052105833
            conf.setChairmanPassword(editConfFrame.getChairmanPasswordText().getText());
            conf.setRate(editConfFrame.getSpeedRateJC().getSelectedItem()
                    .toString());

            ItemObject itemObject = (ItemObject) editConfFrame
                    .getContinuousPresenceJC().getSelectedItem();

            conf.setCpResouce(Integer.parseInt(itemObject.getKey()));

            TPSDKResponseEx<ConferenceInfoEx> response = confService
                    .editScheduledConfEx(conf);
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
                confInfo.setPassword(editConfFrame.getPasswordText().getText());
                confInfo.setChairmanPassword(editConfFrame.getChairmanPasswordText().getText());
                DataBase.getInstance().removeConference(confInfo.getConfId());
                DataBase.getInstance().saveConference(confInfo);
                // confService.insertDataToExcel(confInfo);
            }
        }

        if (0 != result)
        {
            DemoApp.mainFrame
                    .getPan1()
                    .getBottom_show_result_panel()
                    .showResultMsg(
                            false,
                            LabelText.edit_conf_failure[DataBase.getInstance()
                                    .getLanguageFlag()] + result);
            return;
        }
        DemoApp.mainFrame
                .getPan1()
                .getBottom_show_result_panel()
                .showResultMsg(
                        true,
                        LabelText.edit_conf_success[DataBase.getInstance()
                                .getLanguageFlag()]);
        DemoApp.mainFrame.getPan1().getConfListPanel().refreshTable();
        editConfFrame.dispose();

    }

}
