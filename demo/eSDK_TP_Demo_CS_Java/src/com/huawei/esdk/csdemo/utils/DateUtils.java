package com.huawei.esdk.csdemo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils
{
    private final static String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    
    public static Date yyyyMMddHHmmss2date(String str)
    {
        DateFormat format = new SimpleDateFormat(yyyyMMddHHmmss); 
        Date date = new Date();
        try
        {
            date = format.parse(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }
    
    public static String date2yyyyMMddHHmmss(Date date)
    {
        DateFormat format = new SimpleDateFormat(yyyyMMddHHmmss); 
        
        return format.format(date);
    }
}
