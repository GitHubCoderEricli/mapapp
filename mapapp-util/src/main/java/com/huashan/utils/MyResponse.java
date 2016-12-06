package com.huashan.utils;

import net.sf.json.JSONObject;

/**
 *  
 */
public class MyResponse<T> {  
	private boolean status;
	private String code;
	private String msg;
	private T data;
	private static String sucReturn="0000";
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	private static <T> MyResponse<T> valueOf(boolean status,String code,String msg,T data){
		MyResponse<T> rsp=new MyResponse<T>();
		rsp.status=status;
		rsp.code=code;
		rsp.msg=msg;
		rsp.data=data;
		return rsp;
	}
	private static <T> String valueOfJson(boolean status,String code,String msg,T data){
		return JSONObject.fromObject(valueOf(status,code,msg,data)).toString();
		
	}
	public static <T> MyResponse<T> fail(String code,String msg){
		return valueOf(false,code,msg,null);
	}
	public static <T> MyResponse<T> success(){
		return success(null);
	}
	public static <T> MyResponse<T> success(T data){
		return valueOf(true,sucReturn,null,data);
	}
	public static <T> String failJson(String code,String msg){
		return valueOfJson(false,code,msg,null);
	}
	public static <T> String successJson(){
		return successJson(null);
	}
	public static <T> String successJson(T data){
		return valueOfJson(true,sucReturn,null,data);
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
