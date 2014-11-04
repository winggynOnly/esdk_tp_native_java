package com.huawei.esdk.csdemo.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.Duration;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import com.huawei.esdk.csdemo.common.ServiceFactory;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.tp.professional.local.bean.ConferenceInfoEx;
import com.huawei.esdk.tp.professional.local.bean.ConferenceStatusEx;
import com.huawei.esdk.tp.professional.local.bean.FreeBusyStateEx;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteAccessInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;
import com.huawei.esdk.tp.professional.local.conference.ConferenceServiceEx;


public class ConferenceService
{
    private ConferenceServiceEx service = null;

    public ConferenceService()
    {
        service = ServiceFactory.getInstance().getConfServiceEx();
    }

    public TPSDKResponseEx<List<ConferenceStatusEx>> queryConferencesStatusEx(
            List<String> confIds)
    {
        return service.queryConferencesStatusEx(confIds);
    }

    public Integer setAudioSwitchEx(String confId, Integer switchGate,
            Integer isSwitch)
    {
        return service.setAudioSwitchEx(confId, switchGate, isSwitch);
    }

    public TPSDKResponseEx<ConferenceInfoEx> scheduleConfEx(ConferenceInfoEx conf)
    {
        return service.scheduleConfEx(conf);
    }

    public TPSDKResponseEx<RecurrenceConfInfoEx> scheduleRecurrenceConfEx(
            RecurrenceConfInfoEx conf)
    {
        return service.scheduleRecurrenceConferenceEx(conf);
    }

    /**
     * 向文件数据库中写入数据 * @param confInfo
     */
    public void insertDataToExcel(RecurrenceConfInfoEx confInfo)
    {
        String file = getClass().getClassLoader()
                .getResource("conferences.xls").getFile();
        Workbook rw = null;
        WritableWorkbook book = null;
        try
        {
            rw = Workbook.getWorkbook(new File(file));
            book = Workbook.createWorkbook(new File(file), rw);

            WritableSheet st = book.getSheet(0);
            int rows = st.getRows();

            st.addCell(new Label(0, rows, confInfo.getConfId()));

            st.addCell(new Label(1, rows, confInfo.getName()));

            st.addCell(new Label(2, rows, DateUtils
                    .date2yyyyMMddHHmmss(confInfo.getBeginTime())));

            st.addCell(new Label(3, rows, DurationUtils.duration2int(confInfo
                    .getDuration()) + ""));

            st.addCell(new Label(4, rows, confInfo.getAccessCode()));

            st.addCell(new Label(5, rows, null == confInfo.getStatus() ? ""
                    : confInfo.getStatus() + ""));

            st.addCell(new Label(6, rows, confInfo.getPassword()));

            // st.addCell(new Label(1, rows, null ==
            // confInfo.getMediaEncryptType() ? "" :
            // confInfo.getMediaEncryptType() + ""));
            //
            // st.addc
            String siteUris = "";
            for (SiteInfoEx site : confInfo.getSites())
            {
                siteUris = siteUris + site.getUri() + ";";
            }
            st.addCell(new Label(7, rows, siteUris));

            st.addCell(new Label(8, rows, null == confInfo.getFrequency() ? "" : confInfo.getFrequency() + ""));
            
            st.addCell(new Label(9, rows, null == confInfo.getInterval() ? "" : confInfo.getInterval() + ""));
            
            String days = "";
            List<Integer> weekDays = confInfo.getWeekDays();
            for (Integer day : weekDays)
            {
                days = days + day + ";";
            }
            
            st.addCell(new Label(10, rows, days));
            
            st.addCell(new Label(11, rows, null == confInfo.getWeekDay() ? "" : confInfo.getWeekDay() + ""));
            
            st.addCell(new Label(12, rows, null == confInfo.getMonthDay() ? "" : confInfo.getMonthDay() + ""));
            
            st.addCell(new Label(13, rows, null == confInfo.getCount() ? "" : confInfo.getCount() + ""));
            
            st.addCell(new Label(14, rows, null == confInfo.getEndDate() ? "" : DateUtils.date2yyyyMMddHHmmss(confInfo.getEndDate())));

            book.write();
        }
        catch (BiffException ex)
        {
            System.out.println("Open template Excel file failed!");
            System.out.println("File name: " + "");
        }
        catch (IOException e)
        {

        }
        catch (RowsExceededException e)
        {
            e.printStackTrace();
        }
        catch (WriteException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != book)
                    book.close();
            }
            catch (WriteException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void addSiteIntoConfExcel(String confId, String uri)
    {
        String file = getClass().getClassLoader()
                .getResource("conferences.xls").getFile();
        Workbook rw = null;
        WritableWorkbook book = null;
        try
        {
            rw = Workbook.getWorkbook(new File(file));
            book = Workbook.createWorkbook(new File(file), rw);

            WritableSheet st = book.getSheet(0);
            int rows = st.getRows();
            for (int i = 0; i < rows; i++)
            {
                String id = st.getCell(0, i).getContents();
                if (confId.equals(id))
                {
                    String sites = st.getCell(7, i).getContents();
                    Label l = (Label) st.getCell(7, i);
                    l.setString(sites + uri + ";");
                }
            }

            book.write();
        }
        catch (BiffException ex)
        {
            System.out.println("Open template Excel file failed!");
            System.out.println("File name: " + "");
        }
        catch (IOException e)
        {

        }
        finally
        {
            try
            {
                if (null != book)
                    book.close();
            }
            catch (WriteException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从文件中获取数据
     */
    public void selectConfDataFromExcel()
    {
        String file = getClass().getClassLoader()
                .getResource("conferences.xls").getFile();
        Workbook rw = null;
        try
        {
            rw = Workbook.getWorkbook(new File(file));
        }
        catch (BiffException ex)
        {
            System.out.println("Open template Excel file failed!");
            System.out.println("File name: " + "");
        }
        catch (IOException e)
        {

        }

        Sheet st = rw.getSheet(0);

        int rows = st.getRows();

        RecurrenceConfInfoEx confInfo = null;
        for (int i = 0; i < rows; i++)
        {
            confInfo = new RecurrenceConfInfoEx();
            confInfo.setConfId(st.getCell(0, i).getContents());
            confInfo.setName(st.getCell(1, i).getContents());
            confInfo.setBeginTime(DateUtils.yyyyMMddHHmmss2date(st
                    .getCell(2, i).getContents()));
            confInfo.setDuration(DurationUtils.durationInt2dur(Integer
                    .parseInt(st.getCell(3, i).getContents())));
            confInfo.setAccessCode(st.getCell(4, i).getContents());
            String status = st.getCell(5, i).getContents();
            confInfo.setStatus(null == status || "".equals(status) ? null
                    : Integer.parseInt(status));
            confInfo.setPassword(st.getCell(6, i).getContents());
            String uris = st.getCell(7, i).getContents();
            if (uris.endsWith(";"))
            {
                uris = uris.substring(0, uris.length() - 1);
            }
            String[] siteUris = uris.split(";");

            for (int j = 0; j < siteUris.length; j++)
            {
                SiteInfoEx site = DataBase.getInstance().querySiteByUri(
                        siteUris[j]);
                if (null != site)
                {
                    confInfo.getSites().add(site);
                }
                else
                {
                    site = new SiteInfoEx();
                    site.setUri(siteUris[j]);
                }
            }
            
//            String frequency = st.getCell(8, i).getContents();
//            if (null != frequency && !"".equals(frequency))
//            {
//                confInfo.setFrequency(Integer.parseInt(frequency));
//                
//                String interval = st.getCell(9, i).getContents();
//                confInfo.setInterval(null == interval || "".equals(interval) ? null : Integer.parseInt(interval));
//                
////                confInfo
//            }
            
            DataBase.getInstance().clearConf();
            DataBase.getInstance().saveConference(confInfo);
        }
    }
    
    public TPSDKResponseEx<List<SiteStatusEx>> queryConfSitesStatusEx(
            String confId, List<String> siteUris)
    {
        return service.queryConfSitesStatusEx(confId, siteUris);
    }

    public Integer setBroadcastSiteEx(String confId, String siteUri,
            Integer isBroadcast)
    {
        return service.setBroadcastSiteEx(confId, siteUri, isBroadcast);
    }

    public Integer setSitesMuteEx(String confId, List<String> siteUris,
            Integer isMute)
    {
        return service.setSitesMuteEx(confId, siteUris, isMute);
    }

    public Integer setSitesQuietEx(String confId, List<String> siteUris,
            Integer isMute)
    {
        return service.setSitesQuietEx(confId, siteUris, isMute);
    }

    public Integer setBroadcastContinuousPresenceEx(String confId,
            Integer isBroadcast)
    {
        return service.setBroadcastContinuousPresenceEx(confId, isBroadcast);
    }

    public Integer setVideoSourceEx(String confId, String siteUri,
            String videoSourceUri, Integer isLock)
    {
        return service
                .setVideoSourceEx(confId, siteUri, videoSourceUri, isLock);
    }

    public Integer setContinuousPresenceEx(String confId, String target,
            Integer presenceMode, List<String> subPics)
    {
        return service.setContinuousPresenceEx(confId, target, presenceMode,
                subPics);
    }

    public TPSDKResponseEx<List<SiteAccessInfoEx>> addSiteToConfEx(String confId,
            SiteInfoEx siteInfo, Date beginTime)
    {
        return service.addSiteToConfEx(confId, siteInfo, beginTime);
    }

    public Integer connectSitesEx(String confid, List<String> sites)
    {
        return service.connectSitesEx(confid, sites);
    }

    public Integer delSiteFromConfEx(String confid, String uri, Date beginTime)
    {
        return service.delSiteFromConfEx(confid, uri, beginTime);
    }

    public Integer delScheduledConfEx(String confid, Date beginTime)
    {
        return service.delScheduledConfEx(confid, beginTime);
    }

    public Integer prolongScheduledConfEx(String confId, Date beginDate,
            Duration prolongTime)
    {
        return service.prolongScheduledConfEx(confId, beginDate, prolongTime);
    }
    public TPSDKResponseEx<List<SiteInfoEx>> querySitesEx(){
        return service.querySitesEx();
    }
    
    public TPSDKResponseEx<Map<String, List<FreeBusyStateEx>>> querySiteStatusEx(List<String> siteUris, Date beginTime,Duration duration){
        return service.querySiteStatusEx(siteUris, beginTime, duration);
    }

    public TPSDKResponseEx<ConferenceInfoEx> editScheduledConfEx(ConferenceInfoEx conf)
    {
        return service.editScheduledConfEx(conf);
    }

    public TPSDKResponseEx<RecurrenceConfInfoEx> editRecurrenceConferenceEx(RecurrenceConfInfoEx conf)
    {
        return service.editRecurrenceConferenceEx(conf);
    }
}
