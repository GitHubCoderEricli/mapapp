package com.huashan.core.app.user;

import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.User;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Aug 16 17:25:54 CST 2016
 */
@Repository
public class UserDaoHibernate extends DaoSupport<User> implements UserDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

