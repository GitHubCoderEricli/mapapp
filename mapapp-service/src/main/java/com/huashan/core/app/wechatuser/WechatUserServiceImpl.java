package com.huashan.core.app.wechatuser;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.WechatUser;
import com.huashan.core.webservice.WechatUserService;
import com.huashan.utils.HttpsUtil;
import com.huashan.utils.JsonUtil;
import com.huashan.utils.SPRUTIL;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lixu
 * 
 * Fri Aug 12 16:41:21 CST 2016
 */
@Service
public class WechatUserServiceImpl extends ServiceSupport<WechatUser> implements WechatUserService {
	public final Logger log = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;
	@Autowired
	WechatUserDao dao;
	
	public Dao<WechatUser> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(WechatUser t) {
		return dao.saveOrUpdate(t);
	}

	@Override
	@Transactional
	public boolean getTokenAcess() {
		WechatUserDao wechatUserDao = SPRUTIL.getBean(WechatUserDao.class);
		//查询微信公众号信息,微信账号id为20
		WechatUser wechatUser = wechatUserDao.find(20);
		if (wechatUser!=null) {
 			String result = HttpsUtil.getBody(wechatUser.getUrl(), getParams(wechatUser));
			Map<String, String> resultMap = JsonUtil.josnToMap(result);
			Boolean flag = updateWechatUser(wechatUserDao, resultMap, wechatUser);
			if (flag) {
				log.info("获取微信access_token成功！");
			}else {
				log.info("获取微信access_token失败！");
			}
			return flag;
		}
		return false;
	}


	/**
	 * 拼写微信参数
	 * @param wechatUser
	 * @return
	 */
	private Map<String, String> getParams(WechatUser wechatUser) {
		Map<String, String> map = new HashMap<>();
		map.put("grant_type", wechatUser.getGrantType());
		map.put("appid", wechatUser.getAppID());
		map.put("secret", wechatUser.getAppSecret());
		return map;
	}

	/**
	 * 更新类操作
	 */
	private Boolean updateWechatUser(WechatUserDao wechatUserDao, Map<String, String> resultMap, WechatUser wechatUser) {
		if (resultMap == null) {
			return false;
		}
		wechatUser.setAccessToken(resultMap.get("access_token"));
		wechatUser.setExpiresH(Integer.parseInt(resultMap.get("expires_in")));
		wechatUserDao.saveOrUpdate(wechatUser);
		return true;
	}

	@Override
	public WechatUser findWechatUsetById(Integer id) {
		WechatUser user = this.dao.find(id);
		return user;
	}
}
