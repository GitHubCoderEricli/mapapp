package com.huashan.core.app.wechatuser;

import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.WechatUser;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lixu
 * 
 * Fri Aug 12 16:41:21 CST 2016
 */
@Repository
public class WechatUserDaoHibernate extends DaoSupport<WechatUser> implements WechatUserDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

