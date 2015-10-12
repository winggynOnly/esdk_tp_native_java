package com.huawei.esdk.demo.utils;

public abstract class StringUtils
{
    public static boolean isEmpty(String str)
    {
        if (null == str || str.trim().length() == 0 || "".equals(str.trim()))
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean isValue(String str)
    {
    	return !isEmpty(str);
    }
}
