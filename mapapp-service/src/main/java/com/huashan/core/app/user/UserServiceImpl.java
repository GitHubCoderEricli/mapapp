package com.huashan.core.app.user;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.User;
import com.huashan.core.beans.WechatUser;
import com.huashan.core.webservice.UserService;
import com.huashan.utils.HttpsUtil;
import com.huashan.utils.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * 
 * @author lixu
 * 
 * Tue Aug 16 17:25:54 CST 2016
 */
@Service
public class UserServiceImpl extends ServiceSupport<User> implements UserService {
	public final Logger log = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	UserDao dao;
	
	public Dao<User> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(User t) {
		return dao.saveOrUpdate(t);
	}

	@Override
	@Transactional
	public User getAccess_token(WechatUser wechatUser, String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token";
		String result = HttpsUtil.getBody(url, getParams(wechatUser, code));
		Map<String, String> map = JsonUtil.josnToMap(result);
		if (map == null || map.get("errcode") != null) {
			log.info("微信错误码：" + map.get("errcode"));
			return null;
		}
		User user = this.hasSame("openid", map.get("openid"));
		updateUser(user, map);
		return user;
	}

	@Override
	@Transactional
	public User getUserInfo(User user, WechatUser wechatUser) {
		String url = "https://api.weixin.qq.com/sns/userinfo";
		String result = HttpsUtil.getBody(url, getKeyMap(user, wechatUser));
		Map<String, String> map = JsonUtil.josnToMap(result);
		if (map == null || map.get("errcode") != null) {
			log.info("微信错误码：" + map.get("errcode"));
			return user;
		}
		setUserInfo(user, map);
		this.dao.saveOrUpdate(user);
		return user;
	}

	/**
	 * 拼写参数
	 * @param wechatUser
	 * @param code
	 * @return
	 */
	private Map<String, String> getParams(WechatUser wechatUser, String code) {
		Map<String, String> map = new HashMap<>();
		map.put("appid", wechatUser.getAppID());
		map.put("secret", wechatUser.getAppSecret());
		map.put("code", code);
		map.put("grant_type", "authorization_code");
		return map;
	}

	/**
	 * 拼写参数
	 */
	private Map<String, String> getKeyMap(User user, WechatUser wechatUser) {
		Map<String, String> map = new HashMap<>();
		map.put("access_token", user.getAccessToken());
		map.put("openid", user.getOpenid());
		map.put("lang", "zh_CN");
		return map;
	}
	/**
	 * 封装获取到的信息并更新
	 */
	private void updateUser(User user, Map<String, String> map) {
		if (user == null) {
			user = new User();
		}
		user.setOpenid(map.get("openid"));
		user.setAccessToken(map.get("access_token"));
		//设定access_token为超时时间
		Long time = Integer.parseInt(map.get("expires_in")) + System.currentTimeMillis()/1000;
		user.setTokenTime(time.toString());
		user.setRefreshToken(map.get("refresh_token"));
		user.setScope(map.get("scope").length()>119?map.get("scope").substring(0,119):map.get("scope"));
		user.setUnionid(map.get("unionid"));
		this.dao.saveOrUpdate(user);
	}

	/**
	 * 填写微信用户信息
	 */
	private void setUserInfo(User user, Map<String, String> map) {
		user.setNickname(map.get("nickname"));
		String sex = map.get("sex").equals("0")?"3":map.get("sex");
		user.setSex(Integer.parseInt(sex));
		user.setProvince(map.get("province"));
		user.setCity(map.get("city"));
		user.setCounty(map.get("county"));
		user.setHeadImgUrl(map.get("headimgurl"));
		user.setPrivilege(map.get("privilege").length()>499?map.get("privilege").substring(0,499):map.get("privilege"));
		user.setUnionid(map.get("unionid"));
	}

}
