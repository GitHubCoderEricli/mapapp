package com.huashan.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;

/**
 * ftp工具类
 * 
 * @author chenzhenwei
 * @date 2014-10-20
 */
public class FTPUtil {
	
	private FTPClient ftp;
	
	private String addr;
	private int port = 21;
	private String username;
	private String password;
	
	public FTPUtil(){}
	
	/**
	 * 
	 * @param addr
	 *            地址
	 * @param port
	 *            端口号
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 */
	private boolean connect(String addr, int port, String username,
			String password) throws Exception {
		boolean result = false;
		ftp = new FTPClient();
		int reply;
		ftp.connect(addr, port);
		if (!ftp.login(username, password)) {
			throw new Exception("登录FTP服务失败!");
		}
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);//2进制传输数据
		ftp.enterLocalPassiveMode();//被动模式
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return result;
		}
		result = true;
		return result;
	}
	
	/**
	 * 
	 * @param file
	 *            上传的文件或文件夹
	 * @throws Exception
	 */
	public void upload(File file, String ftpPath) throws Exception {
		connect(addr, port, username, password); 
		
		String[] pathArr = ftpPath.replace("/", "\\").split("\\\\");
		for (String dirName : pathArr) {//创建目录
			if (!ftp.changeWorkingDirectory(dirName)) {
				if (ftp.makeDirectory(dirName)){
					ftp.changeWorkingDirectory(dirName);
				} else {
					throw new Exception("目录创建失败,请检查权限及路径是否正确！");
				}
			}
		}
		
		for (int i = 0; i < pathArr.length; i++) {//回退到根
			ftp.changeToParentDirectory();
		}
		FileInputStream input = new FileInputStream(file);
		ftp.storeFile(ftpPath + file.getName(), input);
		ftp.logout();
		input.close();
		if (ftp.isConnected()) {
			ftp.disconnect();
		}
//		ftp.quit();
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
