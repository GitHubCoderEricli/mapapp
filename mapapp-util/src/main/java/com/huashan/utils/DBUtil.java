package com.huashan.utils;
/**
 * 
 * 功能描述：查询语句的封装类
 * 
 * 2010-12-30  上午11:36:22
 */
public class DBUtil {
	public static final String PERCENT = "%";
	public static String like( String str ){
		return leftlike( rightlike( str ) );
	}
	
	public static String leftlike( String str ){
		if( StringUtils.isEmpty( str )){
			str = StringUtils.EMPTY;
		}
		return StringUtils.join( new String[]{ PERCENT , str.trim() });
	}
	
	public static String rightlike( String str ){
		if( StringUtils.isEmpty( str )){
			str = StringUtils.EMPTY;
		}
		return StringUtils.join( new String[]{ str.trim(), PERCENT });
	}
	
	
	
}
