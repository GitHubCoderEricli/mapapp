package com.huashan.core.webservice;

import com.huashan.core.base.Service;
import com.huashan.core.beans.MapResponse;
import com.huashan.core.beans.NPC;
import com.huashan.core.beans.User;
import com.huashan.core.beans.WechatUser;
import com.huashan.core.beans.job.UserSeclectAttribute;
import net.sf.json.JSONObject;

import javax.jws.WebService;
import java.util.List;
import java.util.Map;


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

    /**
     * 保存用户答题信息
     * @param requestJson
     * @return
     */
    MapResponse<String> sendUserSubJect(String requestJson, User user);

    /**
     * 根据用户Id获取用户答题信息
     * @param userId
     * @return
     */
    MapResponse<UserSeclectAttribute> getUserSebject(int userId);

    /**
     * 获取峰主信息
     * @return
     */
    List<NPC> getPeakUserInfo();

    /**
     * 用户跟峰主pk
     * @param userId
     * @param code
     * @return
     */
    int userPk(int userId, int code);

}
