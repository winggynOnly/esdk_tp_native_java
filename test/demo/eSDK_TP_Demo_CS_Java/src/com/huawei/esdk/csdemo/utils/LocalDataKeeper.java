package com.huawei.esdk.csdemo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.log4j.Logger;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;

@XmlRootElement
class MyConfs
{
    
    private Map<String, RecurrenceConfInfoEx> confMap =
        new LinkedHashMap<String, RecurrenceConfInfoEx>();
    
    public Map<String, RecurrenceConfInfoEx> getConfMap()
    {
        return confMap;
    }
    
    public void setConfMap(
        Map<String, RecurrenceConfInfoEx> confMap)
    {
        this.confMap = confMap;
    }
}

public class LocalDataKeeper
{
    private final static Logger LOGGER = Logger.getLogger(LocalDataKeeper.class);
    private String path = "MyConfs.xml";
    
    public void saveDataInLocal()
    {
        try
        {
            MyConfs myConfs = new MyConfs();
            
            myConfs.setConfMap(removeNotExistConf(
                DataBase.getInstance() .getConfMap()));
            
            JAXBContext jaxbCtx = JAXBContext.newInstance(myConfs.getClass());
            
            Marshaller marshaller = jaxbCtx.createMarshaller();
            
            File file = new File(path);
            
            marshaller.marshal(myConfs,file);
        }
        catch (JAXBException e)
        {
            LOGGER.error("error happened, "+e.toString());
        }
        
    }
    
    public void loadDataFromLocal()
    {
        try
        {
            JAXBContext jaxbCtx = JAXBContext.newInstance(MyConfs.class);
            
            Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            
            File file = new File(path);
            
            MyConfs a = (MyConfs)unmarshaller.unmarshal(file);
            
            if (null != a.getConfMap())
            {
                DataBase.getInstance().insertConfMapData(a.getConfMap());
            }
        }
        catch (JAXBException e)
        {
            LOGGER.error("error happened, "+e.toString());
        }
    }
    
    private Map<String, RecurrenceConfInfoEx> removeNotExistConf(
        Map<String, RecurrenceConfInfoEx> confMap)
    {
        int notExistStatusNum = 1;
        List<String> confIds = new ArrayList<String>();
        for(Entry<String, RecurrenceConfInfoEx> confEntry : confMap.entrySet())
        {
            if(notExistStatusNum == confEntry.getValue().getStatus()){
                confIds.add(confEntry.getKey());
            }
        }
        
        for(String id : confIds)
        {
            confMap.remove(id);
        }
        
        return confMap;
    }
}
