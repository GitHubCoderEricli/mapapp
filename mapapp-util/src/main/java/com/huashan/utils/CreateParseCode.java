package com.huashan.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import java.io.OutputStream;
import java.util.HashMap;

/**
 * @Description: (普通二维码生成)
 * @author：Relieved
 * @date：2014-11-7 下午04:42:35
 */
public class CreateParseCode {
	public static final int width = 300;
	public static final int height = 300;
	// 二维码的图片格式
	public static final String format = "png";

	/**
	 * 二维码的生成
	 * 
	 * @throws Exception
	 * 
	 */
	public static void createCode(String text, OutputStream os)
			throws Exception {
		/**
		 * 设置二维码的参数
		 */
		HashMap<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
				BarcodeFormat.QR_CODE, width, height, hints);
		MatrixToImageWriter.writeToStream(bitMatrix, format, os);
	}
}
