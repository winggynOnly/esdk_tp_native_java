package com.huawei.esdk.tp.professional.local.impl.utils;

public class StringUtils
{
    public static boolean isNullOrEmpty(String str)
    {
        if (null == str || 0 == str.trim().length())
        {
            return true;
        }
        return false;
    }
}
