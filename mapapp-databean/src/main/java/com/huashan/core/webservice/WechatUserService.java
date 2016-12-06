package com.huashan.core.webservice;

import com.huashan.core.base.Service;
import com.huashan.core.beans.WechatUser;

import javax.jws.WebService;


/**
 *
 * @author lixu
 * 
 * Fri Aug 12 16:41:21 CST 2016
 */
@WebService
public interface WechatUserService extends Service<WechatUser> {
    /**
     * 对接微信
     * 获取token_access
     */
    boolean getTokenAcess();

    WechatUser findWechatUsetById(Integer id);


}
