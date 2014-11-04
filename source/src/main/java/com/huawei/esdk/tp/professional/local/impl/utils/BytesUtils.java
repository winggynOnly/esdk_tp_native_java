package com.huawei.esdk.tp.professional.local.impl.utils;

public abstract class BytesUtils {

	public static String bytes2HexString(byte[] src){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (null != src && src.length > 0) {
	    	for (int i = 0; i < src.length; i++) {  
	    		int j = src[i] & 0xFF;  
	    		String str = Integer.toHexString(j);  
	    		if (str.length() < 2) {  
	    			stringBuilder.append(0);  
	    		}  
	    		stringBuilder.append(str);  
	    	}  
	    	return stringBuilder.toString();  
		}
	    return null;  
	}  

}
