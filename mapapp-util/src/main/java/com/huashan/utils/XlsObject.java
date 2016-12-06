package com.huashan.utils;

/**
 *  说明：
 *  创建时间：2013-10-23
 *  修改日期：
 *  文件名称：XlsObject.java
 *  @author：huangxing
 */


import com.huashan.xls.CoocaaXlsException;
import com.huashan.xls.Title;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * 将xls 或者数组往对象转换的 工具类
 * 
 * 
 * */
public class XlsObject {
	
	/**
	 * @param <T>
	 * @param title 表头描述
	 *  T 的 class
	 * 得到一个List [Object]
	 * @throws CoocaaXlsException 
	 * 
	 * */
	public static <T> List<T> toArray( Title title , InputStream inputStream , Class<T> class_)
			throws CoocaaXlsException {
		try{
			
			List< String [] > values = getList(inputStream);
			return toArray(title, values, class_);
		}catch ( Throwable e ) {
				
			throw new CoocaaXlsException ("xls文件转换为对象 集合异常",e);
		}
	}
	/**
	 * @param title 表头描述
	 * @param values 包含表头的xls 的2维数组
	 *  T 的 class
	 * 得到一个List [Object]
	 * @throws CoocaaXlsException 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toArray( Title title , List<String [] > values, Class<T> class_ )
			throws CoocaaXlsException {
		try{
			
			List<T> ts = new ArrayList<T>();
			
			Map<Integer, String > xlsTitle = getXlsTitle(values);
			for(int i = 1 ; i< values.size() ; i++)
				ts.add((T)toObject(title, xlsTitle, values.get(i), createObjcet(class_)));
			return ts;
		}catch ( Throwable e ) {
			
			throw new CoocaaXlsException (e);
	}
	}
	
	/**
	 * 
	 * 创建一个空的对象
	 * @throws CoocaaXlsException 
	 * 
	 * */
	private static Object createObjcet ( Class<?> objcetClass )
			throws CoocaaXlsException  {
		try {
			
			return objcetClass.newInstance();
			
		} catch ( Throwable e ) {
			
			throw new CoocaaXlsException ("异常发生在 ： [IllegalAccessException,InstantiationException] 可能缺少空构造函数", e);
		}
	}
	
	/**
	 * 从流 中获取一个 关于这个xls 的 List
	 * @throws CoocaaXlsException 
	 * 
	 * */
	private static List<String [] > getList( InputStream inputStream  )
			throws CoocaaXlsException {
		try {
			
			return ExcelUtil.readExcel(inputStream);
			
		} catch ( Throwable e) {
			
			throw new CoocaaXlsException ("异常发生在 ： [IOException,InvalidFormatException] 读取xls 文件异常", e);
		}
	}
	/**
	 * 
	 * 获取表头和字段的对应
	 * 
	 * @throws CoocaaXlsException 
	 * 
	 * 
	 * */
	private  static Map<Integer, String > getXlsTitle( List< String [] > list ) throws CoocaaXlsException {
		try {
			
			return getXlsTitle(list.get(0));
			
		} catch ( Throwable e) {
			throw new CoocaaXlsException ("异常发生在 ： [IndexOutOfBoundsException] 表头可能为空", e);
		}
	}
	/**
	 * 获取表头和字段的对应
	 * 
	 * @throws CoocaaXlsException 
	 * 
	 * 
	 * 
	 * 
	 * */
	public static Map<Integer,String> getXlsTitle( String[] xlsTitle )
			throws CoocaaXlsException {
		try {
			
			Map<Integer, String> titleMap = new HashMap<Integer,String>();
			for( int i = 0 ; i< xlsTitle.length ; i++ ) {
				
				titleMap.put( i , xlsTitle[ i ] );
			}
			return titleMap;
			
		} catch ( Throwable e) {
			throw new CoocaaXlsException ("异常发生在 ： [NullPointerException] 表头可能为空", e);
		}
	}
	/**
	 * 
	 * 设置属性
	 * 
	 * @param object 需要设置的 对象
	 * @param value 值
	 * @throws CoocaaXlsException 
	 * 
	 * 
	 * */
	private static Object setValue( Object object , PropertyDescriptor pd  , Object value )
			throws CoocaaXlsException {
		try {
			
			// 用这个构造描述 给这个Object 设置一个值
			return pd.getWriteMethod().invoke(object, value );
			
		} catch ( Throwable e) {
			
			throw new CoocaaXlsException ("set value 异常，可能没有这个属性，或者这个属性没有 get set方法", e);
		}
	}
	/***
	 * 通过设置的 title  和 xlsTitle 还有一个 String 获得 一个 ben object 的 对象
	 * @throws CoocaaXlsException 
	 * 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static <T> T toObject( Title title , Map<Integer , String> xlsTitle , String[] value , Object object )
			throws CoocaaXlsException {
		try {
			
			for( int i =0 ; i< value.length ; i++ ) {
				//得到当前的 xls 的 title 的名称
				String xlsCom = xlsTitle.get( i );
				/*通过构造器 set对这个 object 的引用进行赋值，前提是这个 field 必须有 get set 方法 否则将抛出异常
				 * 
				 * 还有 getObject 必须指定类型 否则也会抛出异常
				 * */
				PropertyDescriptor pd  = ClassUtil.getPropertyDescriptor(title.getTitle().get(xlsCom), object.getClass());
				setValue(object, pd , ClassUtil.getObject(pd.getPropertyType(), value[i]));
			}
			return (T)object;
			
		} catch ( Throwable e) {
				
			throw new CoocaaXlsException ("创建指定对象发生异常，可能是 没有指定相应的类型或者xls列名错误，参照 : com.coocaa.oss.tools.xls.ClassUtil getObject", e);
		}
	}
	
}
 
