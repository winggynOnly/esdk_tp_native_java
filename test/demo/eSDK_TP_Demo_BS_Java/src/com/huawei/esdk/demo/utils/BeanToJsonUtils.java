package com.huawei.esdk.demo.utils;

import java.lang.reflect.Field;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BeanToJsonUtils
{
    
    public static String beanToJson(Object bean)
    {
        JSONObject jsonObject = JSONObject.fromObject(bean);
        return jsonObject.toString();
    }
    
    public static String beanToJson(Object bean, String[] _nory_changes, boolean nory)
    {
        JSONObject json = null;
        if (nory)
        {// 转换_nory_changes里的属性
            Field[] fields = bean.getClass().getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            for (Field field : fields)
            {
                System.out.println(field.getName());
                sb.append(":" + field.getName());
            }
            fields = bean.getClass().getSuperclass().getDeclaredFields();
            for (Field field : fields)
            {
                System.out.println(field.getName());
                sb.append (":" + field.getName());
            }
            sb.append( ":");
            String str = sb.toString();
            for (String s : _nory_changes)
            {
                str = str.replace(":" + s + ":", ":");
            }
            json = JSONObject.fromObject(bean, configJson(str.split(":")));
        }
        else
        {
            // 转换除了_nory_changes里的属性
            json = JSONObject.fromObject(bean, configJson(_nory_changes));
        }
        return json.toString();
        
    }
    
    private static JsonConfig configJson(String[] excludes)
    {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(false);
        return jsonConfig;
    }
    
}
