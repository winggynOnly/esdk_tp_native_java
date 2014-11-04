package com.huawei.esdk.csdemo.mapping;

import com.huawei.esdk.csdemo.common.LabelText;
import com.huawei.esdk.csdemo.memorydb.DataBase;

public abstract class ConfStatusMapping
{
    public static String int2String(Integer status)
    {
        if (null == status)
        {
            return LabelText.confStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
        if(0 == status)
        {
            return LabelText.confStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
        if (1 == status)
        {
            return LabelText.confStatusMapping_not_exist[DataBase.getInstance().getLanguageFlag()];
        }
        else if (2 == status)
        {
            return LabelText.confStatusMapping_changed[DataBase.getInstance().getLanguageFlag()];
        }
        else if (3 == status)
        {
            return LabelText.confStatusMapping_going[DataBase.getInstance().getLanguageFlag()];
        }
        else if (4 == status)
        {
            return  LabelText.confStatusMapping_noAccess[DataBase.getInstance().getLanguageFlag()];
        }
        else if (5 == status)
        {
            return LabelText.confStatusMapping_end[DataBase.getInstance().getLanguageFlag()];
        }
        else
        {
            return LabelText.confStatusMapping_unknow[DataBase.getInstance().getLanguageFlag()];
        }
    }
}
