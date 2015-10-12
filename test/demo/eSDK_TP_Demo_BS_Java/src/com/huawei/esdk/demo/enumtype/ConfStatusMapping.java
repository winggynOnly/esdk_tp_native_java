package com.huawei.esdk.demo.enumtype;

public abstract class ConfStatusMapping
{
    public static String int2Str(Integer status)
    {
    	if (null == status) {
			return "";
		}
    	switch (status) {
		case 1:{
			return "NOEXIST";
		}
		case 2:{
			return "SCHEDULED";
		}
		case 3:{
			return "ONGOING";
		}
		case 4:{
			return "NOPERMISSION";
		}
		case 5:{
			return "END";
		}
        default:
        {
            return "";
        }
    }
    }
}