package com.huashan.utils;

/**
 *  说明：
 *  创建时间：2013-10-26
 *  修改日期：
 *  文件名称：ConfigUtil.java
 *  @author：huangxing
 */


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * 提供  load .xml 和load .properties 文件
 * 
 * 
 * 
 * */
public class ConfigUtil {
	
	
	/**
	 * @param aResourcePath 资源路径,用类加载器加载
	 */
	public static Properties loadPropertiesResource(String aResourcePath )
			throws IOException {
		try {
			//使用诶加载器加载
			ClassLoader classLoader = ConfigUtil.class.getClassLoader();

			Properties properties = new Properties();

			// Try loading it.
			properties.load(classLoader.getResourceAsStream(aResourcePath));
			return properties;
		} catch (Throwable t) {
			
			throw new IOException("采用类加载器加载，该文件失败。文件路径"+ aResourcePath+"确认该文件是否存在？");
		}
	}
	
	/**
	 *.properties 文件加载文件的路径，用文件路径加载
	 */
	public static Properties loadPropertiesFile(String aFilePath, String name )
			throws IOException {
		try {

			Properties properties = new Properties();

			// Try loading it.
			properties.load(new FileInputStream(aFilePath));
			return properties;
		} catch (Throwable t) {
			
			throw new IOException("采用类加载器加载，该文件失败。文件路径"+ aFilePath+ File.separator + name+"确认该文件是否存在？");
		}
	}
	
	
	/**
	 * 不指定加载方式加载 。 properties   适用于 .properties 文件目录为程序包路径，或者绝对路径
	 * 
	 * 
	 * 首先尝试 用文件路径加载， 若是加载不成功，则用类加载器加载
	 * @throws IOException
	 * 
	 * */
	public static Properties loadProperties ( String patch ,String name )
			throws IOException {
			try {
				//首先选用文件加载
				String filePath = patch + File.separator + name;
				return loadPropertiesFile(filePath, name);
			} catch (Throwable t) {
				
				try {
					//若是以上加载异常，选用类加载器加载，失败再抛出异常
					return loadPropertiesResource( name );
				} catch (Throwable t2) {
					
					throw new IOException("加载【"+patch + File.separator + name+"】文件失败,文件是否存在?");
				}
			}
	}
	/**
	 * 
	 * @param aResourcePath 资源路径 com/abc.xml
	 * @return
	 * @throws IOException
	 */
	public static Document loadXmlResource( String aResourcePath )
			throws IOException {
		try {
			
			//使用诶加载器加载
			ClassLoader classLoader = ConfigUtil.class.getClassLoader();
			DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
			// Try loading it.
	     	return docBuild.parse(classLoader.getResourceAsStream(aResourcePath));
		} catch (Throwable t) {
			
			throw new IOException("采用类加载器加载，该文件失败。文件路径"+ aResourcePath+"确认该文件是否存在？");
		}
	}
	/**
	 * 
	 * @param aFilePath 文件路径
	 * @param name 名称
	 * @return
	 * @throws IOException
	 */
	public static Document loadXmlFile( String aFilePath ,String name )
			throws IOException {
		try {
			
			//使用文件流加载
			DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			// Try loading it.
	      	return docBuild.parse(new FileInputStream(aFilePath+ File.separator + name));
		} catch (Throwable t) {
			
			throw new IOException("采用类加载器加载，该文件失败。文件路径"+ aFilePath+ File.separator + name+"确认该文件是否存在？");
		}
	}
	
	/**
	 * 不指定加载方式加载 。 properties   适用于 .properties 文件目录为程序包路径，或者绝对路径
	 * 
	 * 
	 * 首先尝试 用文件路径加载， 若是加载不成功，则用类加载器加载
	 * @throws IOException
	 * 
	 * */
	public static Document loadXml ( String patch ,String name )
			throws IOException {
			try {
				//首先选用文件加载
				String filePath = patch + File.separator + name;
				return loadXmlFile(filePath, name);
			} catch (Throwable t) {
				
				try {
					//若是以上加载异常，选用类加载器加载，失败再抛出异常
					return loadXmlResource( name );
				} catch (Throwable t2) {
					
					throw new IOException("加载【"+patch + File.separator + name+"】文件失败,文件是否存在?");
				}
			}
	}
}
 
