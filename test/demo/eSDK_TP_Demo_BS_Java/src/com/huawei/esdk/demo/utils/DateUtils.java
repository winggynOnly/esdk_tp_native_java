package com.huawei.esdk.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;


public abstract class DateUtils {

	public static Date toDate(String time){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		if (!StringUtils.isEmpty(time)) 
		{
			try 
			{
				date = sdf.parse(time);
				long datetimes = (date.getTime()/(60*1000))*60*1000;
				return new Date(datetimes);
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			return null;
		}

	}
	
	public static Date toBeginTime(String time){
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mmaa", Locale.US);
		Date date = null;
		if (!StringUtils.isEmpty(time)) {
			try {   
				date = sdf.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

    public static Date gregoriantoDate(XMLGregorianCalendar xmlGregorianCalendar)
    {
        if (null == xmlGregorianCalendar)
        {
            return null;
        }
        GregorianCalendar gregorianCalendar = xmlGregorianCalendar
                .toGregorianCalendar();
        return gregorianCalendar.getTime();
    }
    
	public static String toString(Date time){
		if (null == time) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(time);
	}
	
    
    /**
     * 将会议时间减去相应的时区 如：北京时间的情况，将data时间减去八小时
     */
    public static XMLGregorianCalendar getUTCDate(XMLGregorianCalendar data)
    {
        if (null == data)
        {
            return null;
        }
        int duration = data.getTimezone();
        Duration du = null;
        try
        {
            du = DatatypeFactory.newInstance().newDuration(false, 0, 0, 0, 0,
                    duration, 0);
        }
        catch (DatatypeConfigurationException e)
        {
            return null;
        }
        data.add(du);
        return data;
    }
    
    /**
     * Date类型转XMLGregorianCalendar类型 * @param date * @return
     */
    public static XMLGregorianCalendar toGregorianCalendarDate(Date date)
    {
        return toGregorianCalendarDateSMC(date);
    }
    
    /**
     * Date类型转XMLGregorianCalendar类型 * @param date * @return 用于预约周期会议返回的情况
     */
    public static XMLGregorianCalendar toGregorianCalendarDateSMC(Date date)
    {

        if (null == date)
        {
            return null;
        }
        GregorianCalendar nowGregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlDatetime = null;
        try
        {
            xmlDatetime = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(nowGregorianCalendar);
            nowGregorianCalendar.setTime(date);
            xmlDatetime = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(nowGregorianCalendar);
        }
        catch (DatatypeConfigurationException e)
        {
            return null;
        }
        return xmlDatetime;
    }

    /**
     * 将String类型的data转换成XMLGregorianCalendar类型的date 输入时间类型：yyyy-MM-dd HH:mm:ss
     * 返回XMLGregorianCalendar类型的时间
     * 
     * @param date
     * @return
     */
    public static XMLGregorianCalendar toGregorianCalendarDate(String date)
    {

        if (StringUtils.isEmpty(date))
        {
            return null;
        }
        return toGregorianCalendarDateSMC(DateUtils.toDate(date));
    }
}
