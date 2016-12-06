package com.huashan.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

public class AesEncrypt {
	public static String TRANSFORM = "AES/CBC/NoPadding";
	public static final String IV = "45e3b3d534bbc289";
	public static final String DEFAULT_PW = "01be739c226aa6bd";

	public static String encrypt( final String enc_key, String enc_iv, String str) {
		byte[] ret = null;

		try {
			Cipher cipherEnc = Cipher.getInstance(TRANSFORM);
			cipherEnc.init(Cipher.ENCRYPT_MODE, createKey(enc_key),
					createIv(enc_iv));
			byte[] old = str.getBytes("UTF-8");

			int length = (int) Math.ceil(old.length / 16.0) * 16;
			byte[] newb = new byte[length];
			for (int i = 0; i < newb.length; i++) {
				if (i < old.length) {
					newb[i] = old[i];
				} else {
					newb[i] = 32;
				}
			}

			ret = cipherEnc.doFinal(newb);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return byte2hex(ret);
	}

	/** 字节数组转化为16进制字符串 **/
	public static String byte2hex(byte[] b) { // 一个字节的数
		StringBuffer sb = new StringBuffer(b.length * 2);
		String tmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			tmp = (Integer.toHexString(b[n] & 0XFF));
			if (tmp.length() == 1) {
				sb.append("0");
			}
			sb.append(tmp);
		}
		return sb.toString().toUpperCase(); // 转成大写
	}

	/** 将hex字符串转化为字节数组 **/
	private static byte[] hex2byte(String inputString) {
		if (inputString == null || inputString.length() < 2) {
			return new byte[0];
		}
		inputString = inputString.toLowerCase();
		int l = inputString.length() / 2;
		byte[] result = new byte[l];
		for (int i = 0; i < l; ++i) {
			String tmp = inputString.substring(2 * i, 2 * i + 2);
			result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
		}
		return result;
	}

	/*
	 * str is Hex String
	 */
	public static String decrypt(final String dec_key, String dec_iv, String str) {
		byte[] ret = null;

		try {
			Cipher cipherDec = Cipher.getInstance("AES/CBC/NoPadding");
			cipherDec.init(Cipher.DECRYPT_MODE, createKey(dec_key),
					createIv(dec_iv));
			byte[] e = hex2byte(str);
			ret = cipherDec.doFinal(e);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		try {
			String result = new String(ret, "UTF-8");
			return result.trim();
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/** 创建密钥 **/
	private static SecretKeySpec createKey(String password) {
		if (password == null) {
			password = "";
		}

		return new SecretKeySpec(password.getBytes(), "AES");
	}

	private static IvParameterSpec createIv(String iv) {
		return new IvParameterSpec(iv.getBytes());
	}
	 public static String getidentifyCode(String identifyCode){
	    	String key=identifyCode;
	    	key+=Rdom.genRandomNum(10);
	    	System.out.println("yuankey:" + key);
	    	key=enkey(key);
	    	System.out.println("desEncrypt:" + key);
	    	String keyn=key;
	    	try {
	    	System.out.println("deskey11:" + deskey(keyn.trim()));
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    	return key;
	    }
	    public static String enkey(String data){
	    	String keyStr = "coocaa78123456cr";
			String ivStr = "CoocaaAskCRM0101";
	    	return AesEncrypt.encrypt(keyStr, ivStr,data);
	    }
	    public static String deskey(String deskey){
	    	return  AesEncrypt.decrypt("coocaa78123456cr", "CoocaaAskCRM0101", deskey);
	    }
}
