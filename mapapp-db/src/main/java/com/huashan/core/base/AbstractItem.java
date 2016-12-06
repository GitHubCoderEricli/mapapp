package com.huashan.core.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 所有model类的抽象类,包含每个item应该具有的基本方法,及一些方法 如 toString的实现
 * 
 * @author huangxing
 * 
 *         2013-11-12
 */
public abstract class AbstractItem implements ItemBase, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public Object clone()  throws CloneNotSupportedException {
		try {
			return super.clone();
			
			} catch (Exception e) {
			e.printStackTrace();
			
			logger.error(getClass().getName() + "[clone],浅拷贝未成功");
		}
		return  null ;
	}

}
