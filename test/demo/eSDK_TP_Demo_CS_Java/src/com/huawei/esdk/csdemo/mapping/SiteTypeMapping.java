package com.huawei.esdk.csdemo.mapping;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public class SiteTypeMapping
{
    public static String int2String(Integer status)
    {
        if (null == status)
        {
            return LabelText.siteTypeMapping_invalid[DataBase.getInstance().getLanguageFlag()];
        }
        else if (0 == status)
        {
            return LabelText.siteTypeMapping_invalid[DataBase.getInstance().getLanguageFlag()];
        }
        else if (1 == status)
        {
            return LabelText.siteTypeMapping_audo[DataBase.getInstance().getLanguageFlag()];
        }
        else if (2 == status)
        {
            return "E1";
        }
        else if (3 == status)
        {
            return "ISDN";
        }
        else if (4 == status)
        {
            return "H.323";
        }
        else if (5 == status)
        {
            return "PSTN";
        }
        else if (6 == status)
        {
            return "4E1";
        }
        else if (7 == status)
        {
            return "SIP";
        }
        else if (8 == status)
        {
            return "VoIP SIP";
        }
        else if (9 == status)
        {
            return "VoIP H.323";
        }
        else
        {
            return LabelText.siteTypeMapping_invalid[DataBase.getInstance().getLanguageFlag()];
        }
    }
}
