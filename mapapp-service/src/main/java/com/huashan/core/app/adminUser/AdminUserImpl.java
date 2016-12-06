package com.huashan.core.app.adminUser;

import com.huashan.core.base.Dao;
import com.huashan.core.base.Pair;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.AdminUser;
import com.huashan.core.webservice.AdminUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixu on 2016-11-17.
 */
@Service
public class AdminUserImpl extends ServiceSupport<AdminUser> implements AdminUserService {

    @Autowired
    AdminUserDao dao;

    public final Logger log = Logger.getLogger(this.getClass());

    @Override
    public Dao<AdminUser> getDao() {
        return this.dao;
    }

    @Override
    public boolean saveOrUpdate(AdminUser t) {
        return dao.saveOrUpdate(t);
    }

    @Override
    public AdminUser find(String userName, String password) {
        return super.hasSame(new Pair<Object, Object>("userName", userName), new Pair<String, String>("password", DigestUtils.md5Hex(password).toString()));
    }
}
