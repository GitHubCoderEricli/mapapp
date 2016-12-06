package com.huashan.utils;


import java.security.MessageDigest;

public class Md5api {
	public Md5api() {
	}

	public static String getMd5(String... inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		if(CollectionsUtil.notEmpty(inStr)){
			String str = "";
			
			for(String s : inStr){
				if(StringUtils.areNotEmpty(s))
					str += s;
			}
			
			char[] charArray = str.toCharArray();
			byte[] byteArray = new byte[charArray.length];

			for (int i = 0; i < charArray.length; i++)
				byteArray[i] = (byte) charArray[i];

			byte[] md5Bytes = md5.digest(byteArray);

			StringBuffer hexValue = new StringBuffer();

			int val;
			for (int i = 0; i < md5Bytes.length; i++) {
				val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}

			return hexValue.toString();
		}
		return "";
	}
	
	
	public static void main(String[] args){
		System.err.println(Md5api.getMd5("wedsdfsdf"));
		System.err.println(Md5api.getMd5("wedsdfsdf",""));
	}
	
}
