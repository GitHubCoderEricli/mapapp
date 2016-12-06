package com.huashan.core.webservice;

import com.huashan.core.base.Service;
import com.huashan.core.beans.User;
import com.huashan.core.beans.WechatUser;

import javax.jws.WebService;


/**
 * 
 * 
 * @author lixu
 * 
 * Tue Aug 16 17:25:54 CST 2016
 */
@WebService
public interface UserService extends Service<User> {

    /**
     * 通过code换取网页授权access_token并存储
     */
    User getAccess_token(WechatUser wechatUser, String code);

    /**
     * 拉取用户信息，并保存
     */
    User getUserInfo(User user, WechatUser wechatUser);

}
