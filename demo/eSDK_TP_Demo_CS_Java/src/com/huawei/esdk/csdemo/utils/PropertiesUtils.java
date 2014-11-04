package com.huawei.esdk.csdemo.utils;



import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;


public class PropertiesUtils
{
    private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class);
    


    private static Properties properties = null;

    static
    {
        properties = loadProperty(); 
    }

    private static Properties loadProperty()
    {
        Properties p = new Properties();
        loadProp("config.properties", p);
        loadProp("esdk_tp_config.properties", p);
        return p;
    }
    
    private static void loadProp(String conf, Properties p)
    {
        InputStream is = null;
        try
        {
            is = getInputStream(conf);
            
            if (null != is)
            {
                p.load(is);
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Exception happened in loadProp() " + conf, e);
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    LOGGER.error("Exception happened in loadProperty()", e);
                }
            }
        }
    }

    public static String getValue(String key)
    {


        if (properties.containsKey(key))
        {
            String value = properties.getProperty(key);
            if (null != value)
            {
                value = value.trim();
            }

            return value;
        }
        else
        {
            return "";
        }
    }

    private static InputStream getInputStream(String path) throws IOException
    {
        return Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(path);
    }
}