package com.huashan.core.webservice;

import com.huashan.core.base.Service;
import com.huashan.core.beans.AdminUser;

import javax.jws.WebService;

/**
 * Created by lixu on 2016-11-17.
 */
@WebService
public interface AdminUserService extends Service<AdminUser> {
    /**
     * 根据用户名密码查询用户
     * @param userName
     * @param password
     * @return
     */
    AdminUser find(String userName, String password);
}
