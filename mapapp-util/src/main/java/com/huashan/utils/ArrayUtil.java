package com.huashan.utils;

/**  
 * 数组工具类  
 * @version 1.0 
 * @created 2011-7-29 上午10:50:13 
 */  
public class ArrayUtil {
	
	/**  
	 * 将Object类型的数组转成Integer类型的
	 * @param strArray
	 * @return  
	 */
	public static Integer[] objToInteger(Object[] strArray){
		if(strArray==null || strArray.length==0)
			return null;
		else{
			Integer[] array = new Integer[strArray.length];
			for(int i = 0;i<strArray.length;i++){
				if(ObjectUtil.isEmpty(strArray[i]))
					array[i] = null;
				else
					array[i] = Integer.parseInt(strArray[i].toString());
			}
			return array;
		}
	}
	
	/**  
	 * 将string类型的数组转成integer类型的
	 * @param strArray
	 * @return  
	 */
	public static Integer[] stringToInteger(String[] strArray){
		if(strArray==null || strArray.length==0)
			return null;
		else{
			Integer[] array = new Integer[strArray.length];
			for(int i = 0;i<strArray.length;i++){
				if(StringUtils.isEmpty(strArray[i]))
					array[i] = null;
				else
					array[i] = Integer.parseInt(strArray[i]);
			}
			return array;
		}
	}
}
