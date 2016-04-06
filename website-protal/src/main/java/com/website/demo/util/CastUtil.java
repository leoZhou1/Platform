package com.website.demo.util;

import org.apache.commons.lang3.StringUtils;

public class CastUtil {

	public static String castString(Object obj){
		return castString(obj,"");
	}
	
	public static String castString(Object obj,String defaultValue){
		return obj!=null ? String.valueOf(obj) : defaultValue ;
	}
	
	public static double castDouble(Object obj){
		return castDouble(obj, 0);
	}
	
	public static double castDouble(Object obj,double defaultValue){
		double doubleValue = defaultValue;
		if(obj!=null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	
	public static int castInt(Object obj){
		return castInt(obj);
	}
	
	public static int castInt(Object obj,int defaultValue){
		int intValue = defaultValue;
		if(obj!=null){
			String strValue = castString(obj);
			if(StringUtil.isNotEmpty(strValue)){
				try {
					intValue = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
}
