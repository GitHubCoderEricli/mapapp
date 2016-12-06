package com.huashan.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author  
 * 将网络图片下载到本地
 * 
 */
public class DownLoadImgUtil {
	/**
	 * @param urlString   网络地址
	 * @param fileDir	  存放的路径
	 * @param fileName    存放的文件名
	 * @return
	 */

	public String getFileFromURL(String urlString, String fileDir, String fileName) {
		String filePath = fileDir + fileName;
		File dirPath = new File(fileDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			os = new FileOutputStream(filePath);
			byte[] b = new byte[1];
			if(is != null){
				while (is.read(b) > 0) {
					os.write(b);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
		return filePath;
	}
}
