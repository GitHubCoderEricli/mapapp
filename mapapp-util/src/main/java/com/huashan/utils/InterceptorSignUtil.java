package com.huashan.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 签名工具类
 * @author chenzhenwei
 *
 */
public class InterceptorSignUtil {
	static String key = "";
	/**
	 * 验证签名，参数名ASCII码从小到大排序（字典序），如果一个key有多个值则同样按照ASCII码从小到大排序（字典序），
	 * 以key1=value1&key2=value2格式排列后加上&key=api密钥，进行md5加密，
	 * 如果参数的值为空(null)不参与签名，必须带有随机数nonce_str，参数名区分大小写，传入的sign参数不做签名验证，签名为大写字母
	 * @param map
	 * @return
	 */
	public static String checkSign(Map<String, String[]> map) {
		StringBuffer sb = new StringBuffer();
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		boolean hasNonceStr = false;
		for (String key : keys) {
			if ("sign".equals(key)) continue;
			if ("nonce_str".equals(key)) hasNonceStr = true; 
			List<String> values = new ArrayList<String>();
			String[] v = map.get(key);
			for (String string : v) {
				values.add(string);
			}
			Collections.sort(values);
			for (String value : values) {
				sb.append("&").append(key).append("=").append(value);
			}
		}
		//如果不存在随机数则返回false
		if (!hasNonceStr) return "haven't param nonce_str";
		sb.append("&key=").append(key);
		
		return Md5api.getMd5(sb.substring(1)).toUpperCase();
	}
	
	/**
	 * 验证签名，参数名ASCII码从小到大排序（字典序），
	 * 以key1=value1&key2=value2格式排列后加上&key=api密钥，进行md5加密，
	 * 如果参数的值为空(null)不参与签名，必须带有随机数nonce_str，参数名区分大小写，
	 * 传入的sign参数不做签名验证，签名为大写字母
	 * @param map
	 * @return
	 */
	public static String getSign(Map<String, String> map) throws Exception {
		StringBuffer sb = new StringBuffer();
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		boolean hasNonceStr = false;
		for (String key : keys) {
			if ("sign".equals(key)) continue;
			if ("nonce_str".equals(key)) hasNonceStr = true; 
			sb.append("&").append(key).append("=").append(map.get(key));
		}
		//如果不存在随机数则返回false
		if (!hasNonceStr) throw new Exception("haven't param nonce_str");
		sb.append("&key=").append(key);
		
		return Md5.getMd5(sb.substring(1)).toUpperCase();
	}
	
	public static void setKey(String key) {
		InterceptorSignUtil.key = key;
	}
}
