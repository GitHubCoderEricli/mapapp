package com.huashan.utils;

//import java.security.MessageDigest;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	public AES() {
	}
	    public static String getkey(Integer actId){
	    	String key="coocaa";
	    	key+=Rdom.genRandomNum(10);  
	    	return enkey(key);
	    }
	    public static String getidentifyCode(String identifyCode){
	    	String key="";
	    	if(StringUtils.isNotEmpty(identifyCode))
	    		key+=identifyCode;
	    	key+=Rdom.genRandomNum(10);
	    	System.out.println("yuankey:" + key);
	    	key=enkey(key);
	    	System.out.println("desEncrypt:" + key);
	    	
	    	  
	    	String keyn=key;
	    	try {
//	    	keyn=URLEncoder.encode(keyn, "utf-8");//encode(keyn);
//	    	System.out.println("URLEncoder:" + keyn); 
//	    	keyn=URLDecoder.decode(keyn,"utf-8");
//	    	System.out.println("URLDecoder:" + keyn); 
	    	System.out.println("deskey11:" + deskey(keyn.trim()));
	    	}catch (Exception e) {
				e.printStackTrace();
			}
//	    	yuankey:getbuy27949goodsid374identifycodehnel7708kt
//	    	desEncrypt:5m8FwISj3FedScMO9j/KEtk9YplY14koMSWlTNBQAsqps32TrF7STm5c+TRwfTMZ
//	    	URLEncoder:5m8FwISj3FedScMO9j/KEtk9YplY14koMSWlTNBQAsqps32TrF7STm5c+TRwfTMZ
//	    	URLDecoder:5m8FwISj3FedScMO9j/KEtk9YplY14koMSWlTNBQAsqps32TrF7STm5c+TRwfTMZ
//	    	deskey:getbuy27949goodsid374identifycodehnel7708kt
	    	return key;
	    }
	    public static String enkey(String key){
	    	return encrypt(key,"37baf05d45e3b3d5","37baf05d45e3b3d5");
	    }
	    public static String deskey(String deskey){
	    	return desEncrypt(deskey,"37baf05d45e3b3d5","37baf05d45e3b3d5");
	    }
	
	    public static String encrypt(String data,String key, String iv) {
	    	try {
				Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
				int blockSize = cipher.getBlockSize();

				byte[] dataBytes = data.getBytes();
				int plaintextLength = dataBytes.length;
				if (plaintextLength % blockSize != 0) {
					plaintextLength = plaintextLength
							+ (blockSize - (plaintextLength % blockSize));
				}

				byte[] plaintext = new byte[plaintextLength];
				System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

				SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
				IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

				cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
				byte[] encrypted = cipher.doFinal(plaintext);

				return new sun.misc.BASE64Encoder().encode(encrypted);

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	    }
	  public static String desEncrypt(String data,String key, String iv)  {
		  try {
				byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);

				Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
				SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
				IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

				cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
    }
	public static void main(String[] args){
		 
	}
	
}
