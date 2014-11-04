package com.huawei.esdk.tp.demo.utils;

import java.util.HashMap;
import java.util.Map;

public abstract class StringUtils
{
    public static boolean isEmpty(String str)
    {
        if (str == null || str.trim().length() == 0)
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean isNotEmpty(String str)
    {        
        return !isEmpty(str);
    }
    
    public static boolean isValue(String str)
    {
        return !isEmpty(str);
    }
    
    /**
     * 判断是否有值，如果有，返回值，否则返回""
     */
    public static String hasValue(String value)
    {
        return isEmpty(value) ? "" : value;
    }
    
    /**
     * 
     * 避免null字符串，如果是null则转换成空字符串。
     *
     * @param value 需要检查的字符串
     * @return String
     * @since eSDK Solutions Platform V100R003C00
     */
    public static String avoidNull(String value)
    {
        if (null != value)
        {
            return value;
        }
        
        return "";
    }
    
    public static boolean isNumber(String str)
    {
        if (null == str)
        {
            return false;
        }
        
        return str.matches("\\d+");
    }
    
    public static boolean isEmptyWihthoutTrim(String str)
    {
        if (str == null || str.length() == 0)
        {
            return true;
        }
        return false;
    }
    
    public static boolean isUintNumber(String str)
    {
        try
        {
            long uInt = Long.parseLong(str);
            if (4294967295L < uInt)
            {
                return false;
            }
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    /**
     * 
     * 截掉指定长度的错误码
     * @param errCode 错误码
     * @param length 保留长度
     * @param isRight 从右侧开始截掉
     * @return 截掉之后返回的错误码
     */
    public static String truncateString(String errCode, int length, boolean isRight)
    {
        if (!isEmpty(errCode))
        {
            if (length >= errCode.length())
            {
                return errCode;
            }
            else
            {
                String subString = "";
                if (isRight)
                {
                    subString = errCode.substring(0, length);
                    return subString;
                }
                else
                {
                    subString = errCode.substring(errCode.length() - length, errCode.length());
                    return subString;
                }
            }
        }
        return errCode;
    }
    
    /**
     * 
     * 将传入的字符串格式成指定的长度的字符串，如果长度不足指定的长度可以在左边或者右边填补指定的字符。
     *
     * @param formatStr 需要格式化字符串
     * @param length 需要格式化后的长度
     * @param leftPadding 是否是在左边填充
     * @param paddingCharacter 填充的字符
     * @return 格式化后的字符串
     * @since eSDK Solutions Platform V100R003C00
     */
    public static String formatNumber(String formatStr, int length, boolean leftPadding, char paddingCharacter)
    {
        StringBuilder result = new StringBuilder(formatStr);
        String paddingStr = String.valueOf(paddingCharacter);
        
        while (result.length() < length)
        {
            if (leftPadding)
            {
                result = (new StringBuilder(paddingStr)).append(result);
            }
            else
            {
                result.append(paddingCharacter);
            }
        }
        
        return result.toString();
    }
    
    public static Map<String, String> parseString(String content, String level1SplitPatten, String level2SplitPatten)
    {
        Map<String, String> result = new HashMap<String, String>();
        if (isEmpty(content))
        {
            return result;
        }
        
        String[] tempArray = content.split(level1SplitPatten);
        String[] tempArray4Item;
        for (String item : tempArray)
        {
            tempArray4Item = item.trim().split(level2SplitPatten);
            if (tempArray4Item.length > 1)
            {
                result.put(tempArray4Item[0].trim(), tempArray4Item[1].trim());
            }
        }
        
        return result;
    }
}
