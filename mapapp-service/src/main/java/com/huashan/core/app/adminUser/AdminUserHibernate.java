package com.huashan.core.app.adminUser;

import com.huashan.core.base.Dao;
import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.AdminUser;
import org.springframework.stereotype.Repository;

/**
 * Created by lixu on 2016-11-17.
 */
@Repository
public class AdminUserHibernate extends DaoSupport<AdminUser> implements AdminUserDao {
}
