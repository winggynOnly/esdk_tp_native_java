package com.huawei.esdk.csdemo.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.huawei.esdk.csdemo.mapping.ConfStatusMapping;
import com.huawei.esdk.csdemo.memorydb.DataBase;
import com.huawei.esdk.csdemo.service.ConferenceService;
import com.huawei.esdk.csdemo.view.DemoApp;
import com.huawei.esdk.tp.professional.local.bean.ConferenceStatusEx;
import com.huawei.esdk.tp.professional.local.bean.TPSDKResponseEx;

public class ConfManagerDataObserve extends Thread
{
    private ConferenceService conferenceService = new ConferenceService();
    public int flag = 0;
    private int count = 0;
    @Override
    public synchronized void run() 
    {
        
        List<String> notConfList = null;
        try 
        {
            while (0 == flag) 
            {  
                
                Thread.sleep(100);
                count++;
                if (50 > count)
                {
                    continue;
                }
                count = 0;
                
                if (0 == DataBase.getInstance().getConfVector().size())
                {
                    continue;
                }

             //  System.out.println("ConfManagerDataObserve");
               
                List<String> confIds = new ArrayList<String>();
               try{
                    synchronized (DataBase.getInstance().getConfVector())
                    {
                        for(Vector<String> row : DataBase.getInstance().getConfVector()){
                            confIds.add(row.get(0));
                        }
                    }
                }
                catch(Exception e)
                {
                   System.out.println("confVector synchronized exception,vector in loop error"); 
                }
                
                
                TPSDKResponseEx<List<ConferenceStatusEx>> result    = conferenceService.queryConferencesStatusEx(confIds);
                List<ConferenceStatusEx> confStatusList = result.getResult();
                
                
                
                if(0 != result.getResultCode()){
                    if(1347420162 == result.getResultCode()){
                        notConfList = new ArrayList<String>();
                        for(String id : confIds){
                            notConfList.add(id);
                        }
                    }
                }
                
                    if(null != notConfList){
                        int k = 0;
                        for(String id : notConfList){
                            try{
                                if(id.equals(DemoApp.mainFrame.getPan1().getConfListPanel().getTableMode().getValueAt(k, 0))){
                                    DataBase.getInstance().getConfMap().get(id).setStatus(1);
                                    DemoApp.mainFrame.getPan1().getConfListPanel().getTableMode().setValueAt(
                                        ConfStatusMapping.int2String(1), k, 5);
                                }
                            }
                            catch(Exception e){
                                System.out.println("exception");
                            }
                            k++;
                        }
                        notConfList = null;
                        continue;
                    }
                
                    int j = 0;
                    if(null != confStatusList)
                    {
                        for(ConferenceStatusEx status : confStatusList){
                            try{
                                if(status.getId().equals(DemoApp.mainFrame.getPan1().getConfListPanel().getTableMode().getValueAt(j, 0))){
                                    DataBase.getInstance().getConfMap().get(status.getId()).setStatus(status.getStatus());
                                    DemoApp.mainFrame.getPan1().getConfListPanel().getTableMode().setValueAt(
                                    ConfStatusMapping.int2String(status.getStatus()), j, 5);
                                }
                            }
                            catch(Exception e){
                                System.out.println("setValueAt confId :"+status.getId()+"exception");
                            }
                            j++;
                        }
                    }
            }
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

    public void stopObserve()
    {
        flag = 1;
    }
}
