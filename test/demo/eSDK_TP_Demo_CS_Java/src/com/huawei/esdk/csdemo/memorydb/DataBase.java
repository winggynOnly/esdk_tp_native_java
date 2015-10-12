package com.huawei.esdk.csdemo.memorydb;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import com.huawei.esdk.csdemo.enums.ContinuousPresenceMode;
import com.huawei.esdk.csdemo.enums.CpResourceMode;
import com.huawei.esdk.csdemo.mapping.ConfStatusMapping;
import com.huawei.esdk.csdemo.utils.DateUtils;
import com.huawei.esdk.csdemo.utils.DurationUtils;
import com.huawei.esdk.tp.professional.local.bean.RecurrenceConfInfoEx;
import com.huawei.esdk.tp.professional.local.bean.SiteInfoEx;

public class DataBase
{
    private DataBase()
    {
    }

    private static DataBase single = null;

    public synchronized static DataBase getInstance()
    {
        if (single == null)
        {
            single = new DataBase();
        }
        return single;
    }
    
    private int languageFlag = 0;
    
    private String userName = "";
    
    private int loginStatus = 0;
    
    private Map<String, RecurrenceConfInfoEx> confMap = new LinkedHashMap<String, RecurrenceConfInfoEx>();

    private Map<String, SiteInfoEx> siteMap = new HashMap<String, SiteInfoEx>();
    
    private Map<String,Integer> durationMap = new HashMap<String,Integer>();

    private Vector<Vector<String>> confVector = new Vector<Vector<String>>();
    
    private Vector<Vector<String>> selectSiteListVector = new Vector<Vector<String>>();
    
//    public static Map<String,Conference> confSiteMapping = new HashMap<String, Conference>();
    
    private Map<String,SiteInfoEx> allSiteMap = new HashMap<String,SiteInfoEx>();

    private boolean confDataChanged = true;
    
    private Map<String,Integer> holdingConfCpResource = new HashMap<String,Integer>();
    
    public void putInDuration(String key,Integer value)
    {
        durationMap.put(key, value);
    }
    
    public Integer getDurationFromMap(String key)
    {
        return durationMap.get(key);
    }

    public void saveSite(SiteInfoEx site)
    {
        synchronized (siteMap)
        {
            siteMap.put(site.getUri(), site);
        }
        synchronized (selectSiteListVector)
        {
            Vector<String> vector = new Vector<String>();
            vector.add(site.getUri());
            vector.add(site.getName());
//            vector.add(SiteTypeMapping.int2String(site.getType()));
            vector.add(site.getType()+"");
            selectSiteListVector.add(vector);
        }
    }
    
    public SiteInfoEx querySiteByUri(String uri)
    {
        return siteMap.get(uri);
    }

    public void clearConf()
    {
        confMap.clear();
        confVector.clear();
    }
    
    public void saveConference(RecurrenceConfInfoEx conf)
    {
        synchronized (confMap)
        {
            confMap.put(conf.getConfId(), conf);
        }

        Vector<String> vector = new Vector<String>();
        vector.add(conf.getConfId());
        vector.add(conf.getName());
        vector.add(DateUtils.date2yyyyMMddHHmmss(conf.getBeginTime()));
        vector.add(DurationUtils.duration2int(conf.getDuration()) + "");
        vector.add(conf.getAccessCode());
        vector.add(ConfStatusMapping.int2String(conf.getStatus()));
        synchronized (confVector)
        {
            confVector.add(vector);
        }
        
        //new add
        holdingConfCpResource.put(conf.getConfId(), convertHoldingConfCPResource(conf.getCpResouce()));
        
        confDataChanged = true;
    }

    public void removeConference(String confId)
    {
        synchronized (confMap)
        {
            confMap.remove(confId);
        }

        synchronized (confVector)
        {
            for (Vector<String> vector : confVector)
            {
                if (confId.equals(vector.get(0)))
                {
                    confVector.remove(vector);
                    break;
                }
            }
        }
        confDataChanged = true;
    }

    public RecurrenceConfInfoEx queryConferenceById(String confid)
    {
        return confMap.get(confid);
    }
    
    public String[] queryAllConfIds(){
        String[] ids = new String[confMap.size()];
        ids =  confMap.keySet().toArray(ids);
        return ids;
    }

    public URL getPath(String img)
    {
        return getClass().getResource("/" + img);
    }
    

    public Map<String, RecurrenceConfInfoEx> getConfMap()
    {
        return confMap;
    }

    public void insertConfMapData(
        Map<String, RecurrenceConfInfoEx> confMap)
    {
        this.confMap = confMap;
        for(Entry<String, RecurrenceConfInfoEx> confEntry : confMap.entrySet()){
            RecurrenceConfInfoEx conf = confEntry.getValue();
            Vector<String> vector = new Vector<String>();
            vector.add(conf.getConfId());
            vector.add(conf.getName());
            vector.add(DateUtils.date2yyyyMMddHHmmss(conf.getBeginTime()));
            vector.add(DurationUtils.duration2int(conf.getDuration()) + "");
            vector.add(conf.getAccessCode());
            vector.add(ConfStatusMapping.int2String(conf.getStatus()));
            synchronized (confVector)
            {
                confVector.add(vector);
            }
        }
        confDataChanged = true;
    }
    
    private int convertHoldingConfCPResource(int cpModeIndex){
        cpModeIndex--;
        if(0 > cpModeIndex || (CpResourceMode.values().length -1) < cpModeIndex)
        {
            return 0;
        }
        String cpMode = CpResourceMode.values()[cpModeIndex].value();
        
        int result = 0;
        for(ContinuousPresenceMode item : ContinuousPresenceMode.values()){
            if(item.value().equals(cpMode)){
                break;
            }
            result++;
        }
        return result;
    }
    
    public int getLanguageFlag()
    {
        return languageFlag;
    }

    public void setLanguageFlag(int languageFlag)
    {
        this.languageFlag = languageFlag;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getLoginStatus()
    {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus)
    {
        this.loginStatus = loginStatus;
    }

    public Map<String, SiteInfoEx> getSiteMap()
    {
        return siteMap;
    }

    public void setSiteMap(Map<String, SiteInfoEx> siteMap)
    {
        this.siteMap = siteMap;
    }

    public Map<String, Integer> getDurationMap()
    {
        return durationMap;
    }

    public void setDurationMap(Map<String, Integer> durationMap)
    {
        this.durationMap = durationMap;
    }

    public Vector<Vector<String>> getConfVector()
    {
        return confVector;
    }

    public void setConfVector(Vector<Vector<String>> confVector)
    {
        this.confVector = confVector;
    }

    public Vector<Vector<String>> getSelectSiteListVector()
    {
        return selectSiteListVector;
    }

    public void setSelectSiteListVector(Vector<Vector<String>> selectSiteListVector)
    {
        this.selectSiteListVector = selectSiteListVector;
    }

    public Map<String, SiteInfoEx> getAllSiteMap()
    {
        return allSiteMap;
    }

    public void setAllSiteMap(Map<String, SiteInfoEx> allSiteMap)
    {
        this.allSiteMap = allSiteMap;
    }

    public boolean isConfDataChanged()
    {
        return confDataChanged;
    }

    public void setConfDataChanged(boolean confDataChanged)
    {
        this.confDataChanged = confDataChanged;
    }

    public void setConfMap(Map<String, RecurrenceConfInfoEx> confMap)
    {
        this.confMap = confMap;
    }

    public Integer getHoldingConfCpResourceById(String confId)
    {
        return holdingConfCpResource.get(confId);
    }

    public void saveHoldingConfCpResourceById(
        String confId, Integer cpMode)
    {
        this.holdingConfCpResource.put(confId, cpMode);
    }
    
    
}
