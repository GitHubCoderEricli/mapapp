package com.huashan.utils;

public class Prompt {
	public enum User {
		/**
		 * 购物车提示信息
		 */
		ERROR_SIGN("1001","签名不对"),
		NO_LOGINING("1002","未登录"),
		IS_LOGINED("1003","已登录"),
		ILLEGAL_OPERATION("1015","非法操作"),
		SUCCESS_OPERATION("1016","操作成功"),
		ERROR_PHONENUM("1017","手机号码不正确");
		
		// 成员变量
		private String code;
		private String msg;
		// 构造方法
		private User(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		} 
		// 普通方法
		public static String getMsg(String code) {
			for (Cart c : Cart.values()) {
				if (c.getCode().equals(code)) {
					return c.msg;
				}
			}
			return null;
		}
	} 
	public enum Cart {
		/**
		 * 购物车和订单提示信息
		 */
		ADD_SUCCESS("1004","添加成功"),
		ADD_FAILED("1005","添加失败"),
		DEL_SUCCESS("1006","删除成功"),
		DEL_FAILED("1007","删除失败"),
		UPDATE_SUCCESS("1008","修改成功"),
		UPDATE_FAILED("1009","修改失败"),
		SAVE_ORDER_FAILED("1010", "下单失败"),
		DELALL_SUCCESS("1013","清空成功"),
		DELALL_FAILED("1014","清空失败");
		
		
		// 成员变量
		private String code;
		private String msg;

		// 构造方法
		private Cart(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		} 

		// 普通方法
		public static String getMsg(String code) {
			for (Cart c : Cart.values()) {
				if (c.getCode().equals(code)) {
					return c.msg;
				}
			}
			return null;
		}

		// 覆盖方法
		// @Override
		// public String toString() {
		// return this.index + "_" + this.name;
		// }
	}

	public enum Goods{
		PARAM_NOT_COMPLETE("1011","参数不完整"),
		GOODS_NOT_EXISTS("1012", "该商品不存在或已下架");
		// 成员变量
		private String code;
		private String msg;

		// 构造方法
		private Goods(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		} 

		// 普通方法
		public static String getMsg(String code) {
			for (Cart c : Cart.values()) {
				if (c.getCode().equals(code)) {
					return c.msg;
				}
			}
			return null;
		}
	}
	
	public enum Pay {
		/**
		 * 支付平台
		 */
		BALANCE("CC00401",1),
		TONG_LIAN("CC00403",7),
		ALIPAY_SCAN("CC00405",4),
		YI_BAO("CC00406",10),
		WECHAT_PAY("CC00407",11),
		ALIPAY_AUTH("CC00408",4),
		ALIPAY_PAY("CC00409",4),
		DAO_MENG("CC00410",12);
		
		// 成员变量
		private String code;
		private Integer msg;
		// 构造方法
		private Pay(String code, Integer msg) {
			this.code = code;
			this.msg = msg;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public Integer getMsg() {
			return msg;
		}
		public void setMsg(Integer msg) {
			this.msg = msg;
		} 
		// 普通方法
		public static String getMsg(String code) {
			for (Cart c : Cart.values()) {
				if (c.getCode().equals(code)) {
					return c.msg;
				}
			}
			return null;
		}
	}

	public enum QueryOption {
		/**
		 * 查询条件操作
		 */
		EQ("1015","等于", "eq"),
		NEQ("1016","不等于", "ne"),
		GT("1017","大于", "gt"),
		LT("1018","小于", "lt"),
		GTE("1019","大于等于", "ge"),
		LTE("1020","小于等于", "le"),
		AND("1021","AND", "and"),
		OR("1022","OR", "or"),
		IN("1023","IN", "in"),
		ISNULL("1024","null", "isNull"),
		ISNOTNULL("1025","notnull", "isNotNull"),
		ISEMPTY("1026","空", "isEmpty"),
		ISNOTEMPTY("1027","非空", "isNotEmpty"),
		LIKE("1028","LIKE", "like");

		// 成员变量
		private String code;
		private String msg;
		private String option;
		// 构造方法
		private QueryOption(String code, String msg, String option) {
			this.code = code;
			this.msg = msg;
			this.option = option;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public String getOption() {
			return option;
		}
		public void setOption(String option) {
			this.option = option;
		}
	}
}
