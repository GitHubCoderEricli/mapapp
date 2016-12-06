package com.huashan.utils;


import java.util.Date;
import java.util.Map;

;

/**
 * 邮件的工具类
 * @author beam
 *
 */
public class ReplaceUtil{
	/**
	 * 替换掉短信和邮件内容中的订单信息内容
	 *
	 *@author beam
	 *
	 *         目前支持的标签如下：
	 *
	 *         {ht:订单编号} {ht:淘宝编号} {ht:商品总数} {ht:订单状态} {ht:付款时间}
	 *         导购员 订单创建日期 提成   导购员实名 月报时间段
	 *         distribution_user order_create_time fxUser_money fxUserTureName
	 *
	 * @return
	 */
	/*public static String contentReplace(String content,Map<String,String> contentMap) {
		if (content != null && contentMap != null) {
			content = content.replace("{ht:网店名称}", contentMap.get("shopName")==null?"":contentMap.get("shopName"));
			String officeAdmin=contentMap.get("officeAdmin");
            if(officeAdmin!=null&&officeAdmin!=""){
                content=content.replace("{ht:办事处联络人}",officeAdmin);
            }
		}
		return content;
	}*/

	public static String contentReplaceToBoos(String body,Map<String,String> map) {
		if (body != null && map != null) {
			if( map.get("dg_sum_num_1")!=null)
				body=body.replace("{ht:导购员总数量}",map.get("dg_sum_num_1"));
			else
				body=body.replace("{ht:导购员总数量}","0");
			String start= DateUtil.convertDateToString(DateUtil.SHORTDATEFORMATER,new Date(new Date().getTime()-7*24*60*60*1000));
			String end=DateUtil.convertDateToString(DateUtil.SHORTDATEFORMATER,new Date());
			body=body.replace("{ht:统计的时间段}", start+"到"+end);
		}
		return body;
	}
}