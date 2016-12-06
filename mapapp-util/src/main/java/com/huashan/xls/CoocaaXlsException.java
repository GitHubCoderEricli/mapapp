package com.huashan.xls;
/**
 * 
 * @author huangxing
 *
 */
public class CoocaaXlsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private CoocaaXlsException() {
	
	}

	public CoocaaXlsException(String aMessage, Throwable t) {
		super(aMessage + "\n embedded exception=" + t.toString());
	}

	public CoocaaXlsException(String aMessage) {
		super(aMessage);
	}

	public CoocaaXlsException(Throwable t) {
		this("CoocaaXlsException: ", t);
	}

	public String toString() {
		return "CoocaaXlsException: " + getMessage();
	}
}
 
