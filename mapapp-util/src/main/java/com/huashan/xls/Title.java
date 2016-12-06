package com.huashan.xls;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author huangxing
 * 
 * 这是一个 xls 的头，程序将按头的标示对对象 初始化
 * 
 *
 */
public class Title {
	
	public Title(){
		
	}
	
	public Title( Map<String ,String > title ){
		this.title = title;
	}
	
	private Map<String ,String > title = new HashMap<String , String >();
	

	/**
	 * @param name xlsName 
	 * 
	 * @param value fieldName
	 * 
	 * 
	 * */
	public  Title  add (String name , String value ) {
		this.title.put(name , value); return this;
	}


	public Map<String, String> getTitle() {
		return title;
	}


	public void setTitle(Map<String, String> title) {
		this.title = title;
	}
	
}
 
