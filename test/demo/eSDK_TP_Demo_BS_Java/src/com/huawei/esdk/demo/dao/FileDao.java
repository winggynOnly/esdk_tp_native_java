package com.huawei.esdk.demo.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.huawei.esdk.demo.bean.ConferenceInfo;

public class FileDao
{
    private Logger logger = Logger.getLogger(FileDao.class);
    
    public List<String> queryConfIds(String filePathAndName)
    {
        List<String> confIds = new ArrayList<String>();
        InputStreamReader read = null;
        BufferedReader reader = null;
        try
        {
            File file = new File(filePathAndName);
            String line ="";
            if (file.isFile() && file.exists())
            {
                read = new InputStreamReader(new FileInputStream(file), "UTF-8");
                reader = new BufferedReader(read);
                while ((line = reader.readLine()) != null)
                {
                    ConferenceInfo  confInfo= null; 
                    JSONObject jsonObject = JSONObject.fromObject(line);
                    confInfo = (ConferenceInfo)JSONObject.toBean(jsonObject, ConferenceInfo.class);
                    confIds.add(confInfo.getConfId());
                }
            }
            reader.close();
            read.close();
        }
        catch (IOException e)
        {
            try
            {
                if(null != reader )
                {
                    reader.close();
                }
            }
            catch (IOException e1)
            {
                logger.error("close  failed");
            }
            try
            {
                if(null != read )
                {
                    read.close();
                }
            }
            catch (IOException e1)
            {
                logger.error("close  failed");
            }
            logger.error("read file failed");
        }
        return confIds;
    }
}
