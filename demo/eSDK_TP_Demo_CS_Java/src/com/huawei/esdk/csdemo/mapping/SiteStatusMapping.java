package com.huawei.esdk.csdemo.mapping;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class SiteStatusMapping
{
    public static String int2String(Integer status)
    {
        if (null == status)
        {
            return LabelText.siteStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
        else if (0 == status)
        {
            return LabelText.siteStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
        else if (1 == status)
        {
            return LabelText.siteStatusMapping_not_exist[DataBase.getInstance().getLanguageFlag()];
        }
        else if (2 == status)
        {
            return LabelText.siteStatusMapping_inConf[DataBase.getInstance().getLanguageFlag()];
        }
        else if (3 == status)
        {
            return LabelText.siteStatusMapping_noInConf[DataBase.getInstance().getLanguageFlag()];
        }
        else if (4 == status)
        {
            return LabelText.siteStatusMapping_call[DataBase.getInstance().getLanguageFlag()];
        }
        else if (5 == status)
        {
            return LabelText.siteStatusMapping_ring[DataBase.getInstance().getLanguageFlag()];
        }
        else
        {
            return LabelText.siteStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
    }

    public static String statusInt2String(Integer status)
    {
        if (null == status)
        {
            return LabelText.siteCtol_sitelist__status_not_exist[DataBase.getInstance().getLanguageFlag()];
        }

        if (0 == status)
        {
            return LabelText.siteCtol_sitelist_status_free[DataBase.getInstance().getLanguageFlag()];
        }
        else if (1 == status)
        {
            return LabelText.siteCtol_sitelist_status_busy[DataBase.getInstance().getLanguageFlag()];
        }
        else
        {
            return LabelText.siteCtol_sitelist__status_not_exist[DataBase.getInstance().getLanguageFlag()];
        }
    }
}
