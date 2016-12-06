package com.huashan.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.MessageDigest;

/**
 * 加密解密类
 */
public class Eryptogram {
	private static String Algorithm = "AES";

	public Eryptogram() {

	}

	private static byte[] encryptData(byte[] input, byte[] key)
			throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = c1.doFinal(input);
		return cipherByte;

	}

	private static byte[] decryptData(byte[] input, byte[] key)
			throws Exception {
		SecretKey deskey = new javax.crypto.spec.SecretKeySpec(key, Algorithm);
		Cipher c1 = Cipher.getInstance(Algorithm);
		c1.init(Cipher.DECRYPT_MODE, deskey);
		byte[] clearByte = c1.doFinal(input);
		return new String(clearByte,"utf-8").getBytes();
	}

	private static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	private static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	private static byte[] getSecretKey(String mykey) throws Exception {
		return hexStringToByte(getMd5().substring(8, 24));
	}

	private static String getMd5(String... inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		if (inStr != null && !"".equals(inStr)) {
			String str = "";

			for (String s : inStr) {
				if (s != null && !"".equals(s))
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

	/***
	 * 
	 * 获得秘钥字符串
	 * 
	 * @throws Exception
	 * 
	 * 
	 * 
	 * */
	public static String getKeyStr(String myKey) throws Exception {
		byte[] key = Eryptogram.getSecretKey(myKey);
		return Eryptogram.bytesToHexString(key);
	}

	/***
	 * 
	 * 对字符串加密 获得加密后的字符串
	 * 
	 * @throws Exception
	 * 
	 * 
	 * */
	public static String encryptData(String passWord, String myKey)
			throws Exception {
		byte[] key = Eryptogram.getSecretKey(myKey);
		byte[] tmp = Eryptogram.encryptData(passWord.getBytes(), key);
		return Eryptogram.bytesToHexString(tmp);
	}

	/**
	 * 对加密后的字符串解密
	 * 
	 * 获得解密字符串
	 * 
	 * @throws Exception
	 * 
	 * */
	public static String decryptData(String passWord, String myKey)
			throws Exception {
		byte[] tmp = Eryptogram.hexStringToByte(passWord);
		byte[] key = Eryptogram.getSecretKey(myKey);
		return new String(Eryptogram.decryptData(tmp, key));
	}
	/**
	 * 按已经MD5加密后的秘钥获取解密信息
	 * 
	 * 获得解密字符串
	 * 
	 * @throws Exception
	 * 
	 * */
	public static String decryptData_1(String passWord ,String key) throws Exception {
		byte [] K = Eryptogram.hexStringToByte(key);
		byte [] P_W = Eryptogram.hexStringToByte(passWord);
		return new String(Eryptogram.decryptData(P_W, K));
	}
	/**
	 * 按MD5加密后的秘钥进行加密
	 * 
	 * 获得加密字符串
	 * 
	 * @throws Exception
	 * 
	 * */
	public static String encryptData_1(String passWord,String key) throws Exception {
		byte [] K = Eryptogram.hexStringToByte(key);
		byte [] tmp = Eryptogram.encryptData(passWord.getBytes(), K);
		return Eryptogram.bytesToHexString(tmp);
	}
}