package com.huawei.esdk.demo.enumtype;


public abstract class SiteTypeMapping {

	/**
	 * 此处需要加一个默认值
	 * 当用户没有输入值的时候使用SiteType.SITE_TYPE_IP;
	 * 用户输入错误时，返回null
	 * @param num
	 * @return
	 */
	public static String int2Enum(Integer num) {
        if (null == num)
        {
            return "";
        }
        
        switch (num)
        {
            case 0:
            {
                return "NONE";
            }
            case 1:
            {
                return "SITE_TYPE_AUTO";
            }
            case 2:
            {
                return "SITE_TYPE_E_1";
            }
            case 3:
            {
                return "SITE_TYPE_ISDN";
            }
            case 4:
            {
                return "SITE_TYPE_IP";
            }
            case 5:
            {
                return "SITE_TYPE_PSTN";
            }
            case 6:
            {
                return "SITE_TYPE_4_E_1";
            }
            case 7:
            {
                return "SITE_TYPE_SIP";
            }
            case 8:
            {
                return "SITE_TYPE_VO_IP_SIP";
            }
            case 9:
            {
                return "SITE_TYPE_VO_IP_H_323";
            }
            default:
            {
                //			return SiteType.SITE_TYPE_IP;
                return null;
            }
        }
	}
	
	   public static Integer enum2Int(String enumStr) 
	   {
            if (null == enumStr)
            {
                return null;
            }
            if (enumStr.equals("NONE"))
            {
                return 0;
            }
            else if (enumStr.equals("SITE_TYPE_AUTO"))
            {
                return 1;
            }
            else if (enumStr.equals("SITE_TYPE_E_1"))
            {
                return 2;
            }
            else if (enumStr.equals("SITE_TYPE_ISDN"))
            {
                return 3;
            }
            else if (enumStr.equals("SITE_TYPE_IP"))
            {
                return 4;
            }
            else if (enumStr.equals("SITE_TYPE_PSTN"))
            {
                return 5;
            }
            else if (enumStr.equals("SITE_TYPE_4_E_1"))
            {
                return 6;
            }
            else if (enumStr.equals("SITE_TYPE_SIP"))
            {
                return 7;
            }
            else if (enumStr.equals("SITE_TYPE_VO_IP_SIP"))
            {
                return 8;
            }
            else if (enumStr.equals("SITE_TYPE_VO_IP_H_323"))
            {
                return 9;
            }
            else
            {
                return null;
            }
	    }
}
