package com.huashan.core.app.user;

import com.huashan.core.app.npc.NPCDao;
import com.huashan.core.app.userAttribute.UserAttributeDao;
import com.huashan.core.app.userSelectSubject.UserSelectSubjectDao;
import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.*;
import com.huashan.core.beans.job.UserSeclectAttribute;
import com.huashan.core.webservice.UserService;
import com.huashan.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	@Autowired
	UserAttributeDao userAttributeDao;

	@Autowired
	UserSelectSubjectDao userSelectSubjectDao;

	@Autowired
	NPCDao npcDao;
	
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
		user.setScope(map.get("scope").length() > 119 ? map.get("scope").substring(0, 119) : map.get("scope"));
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
		user.setPrivilege(map.get("privilege").length() > 499 ? map.get("privilege").substring(0, 499) : map.get("privilege"));
		user.setUnionid(map.get("unionid"));
	}


	@Override
	public MapResponse<String> sendUserSubJect(String requestMap, User user) {
		JSONObject jsonObject = JSONObject.fromObject(requestMap);
		Integer userId = jsonObject.getInt("userId");
		if (userId == null) {
			return MapResponse.failResponse("用户id参数为空！");
		}
		String timestamp = jsonObject.getString("time");

		JSONArray jsonArray = jsonObject.getJSONArray("selectSubject");
		JSONObject userAttr = jsonObject.getJSONObject("attribute");

//		if (userId == null || !user.getId().equals(userId)) {
//			return MapResponse.failResponse("用户ID与当前登陆用户不符或者为空了！");
//		}

		//请求的用户
		User userRequest = this.dao.find(userId);
		if (DateUtil.compareTimestamp(timestamp, userRequest.getTimestamp())) {
			userRequest.setTimestamp(timestamp);
			this.dao.saveOrUpdate(userRequest);
			if (jsonArray != null) {
				for (Object obj:jsonArray) {
					JSONObject js = JSONObject.fromObject(obj);
					List<UserSelectSubject> userSelectSubjects = this.userSelectSubjectDao.find(new Criterion[]{Restrictions.eq("userid", userId), Restrictions.eq("question", js.getInt("question"))});
					if (!CollectionsUtil.isEmpty(userSelectSubjects)) {
						continue;
					}
					UserSelectSubject uselect = new UserSelectSubject();
					uselect.setQuestion(js.getInt("question"));
					uselect.setAnswer(js.getInt("answer"));
					uselect.setUserid(userId);
					this.userSelectSubjectDao.saveOrUpdate(uselect);
				}
			}
			List<UserAttribute> userAttributes = this.userAttributeDao.find(Restrictions.eq("userId", userId));
			UserAttribute userAttribute = CollectionsUtil.isEmpty(userAttributes)?new UserAttribute():userAttributes.get(0);
			userAttribute.setLife(userAttr.getInt("life"));
			userAttribute.setNeiGong(userAttr.getInt("neiGong"));
			userAttribute.setWaiGong(userAttr.getInt("waiGong"));
			userAttribute.setPartner(userAttr.getInt("partner"));
			userAttribute.setUserId(userId);
			this.userAttributeDao.saveOrUpdate(userAttribute);

			return MapResponse.successResponse("成功！");
		} else {
			return MapResponse.failResponse("失败，之前已经提交！");
		}
	}

	@Override
	public MapResponse<UserSeclectAttribute> getUserSebject(int userId) {
		List<UserAttribute> userAttributes = this.userAttributeDao.find(Restrictions.eq("userId", userId));
		List<UserSelectSubject> userSelectSubjects = this.userSelectSubjectDao.find(Restrictions.eq("userid", userId), Order.asc("answer"));

		UserSeclectAttribute userSeclectAttribute = new UserSeclectAttribute();
		if (!CollectionsUtil.isEmpty(userAttributes)) {
			userSeclectAttribute.setUserAttribute(userAttributes.get(0));
		}
		if (!CollectionsUtil.isEmpty(userSelectSubjects)) {
			userSeclectAttribute.setUserSelectSubject(userSelectSubjects);
		}
		return MapResponse.successResponse(userSeclectAttribute);
	}

	@Override
	public List<NPC> getPeakUserInfo() {
		List<NPC> list = this.npcDao.findAll();
		if (!CollectionsUtil.isEmpty(list)) {
			for (NPC npc:list) {
				User user = this.dao.find(npc.getUserId());
				List<UserAttribute> ulist = this.userAttributeDao.find(Restrictions.eq("userId", npc.getUserId()));
				//修改头像信息
				npc.setImg(user.getHeadImgUrl());
				npc.setName(user.getNickname());
				npc.setUserAttribute(ulist.get(0));
			}
		}
		return list;
	}

	//pk过程加锁用，如果为0表示无人pk，为1表示有人正在pk直接返回pk失败。
	private static int pkflag = 0;

	@Override
	public boolean userPk(int userId, int code) {
		synchronized(this) {
			if (pkflag == 1) {
				return false;
			}
			pkflag = 1;
		}
		try {
			List<UserAttribute> userAttributesA = this.userAttributeDao.find(Restrictions.eq("userId", userId));
			List<NPC> npcs = this.npcDao.find(Restrictions.eq("code", code));
			List<UserAttribute> userAttributesB = this.userAttributeDao.find(Restrictions.eq("userId", npcs.get(0).getUserId()));
			boolean result = userApkB(userAttributesA.get(0), userAttributesB.get(0), npcs.get(0).getCode());
			if (result) {
				NPC npc = npcs.get(0);
				npc.setUserId(userId);
				this.npcDao.saveOrUpdate(npc);
			}
			return result;
		} catch (Exception e) {
			return false;
		} finally {
			pkflag = 0;
		}
	}

	/**
	 * 计算两个用户pk结果
	 * @param attributeA
	 * @param attributeB
	 * @param pkSign 算法标记 0
	 * @return
	 */
	boolean userApkB(UserAttribute attributeA, UserAttribute attributeB, int pkSign) {
		int aTotal = attributeA.getLife() + attributeA.getNeiGong() + attributeA.getWaiGong() + attributeA.getPartner();
		int bTotal = attributeB.getLife() + attributeB.getNeiGong() + attributeB.getWaiGong() + attributeB.getPartner();

		double probability = 0;
		if (pkSign == PKSign.Life.getIndex()) {
			double A = Double.valueOf(aTotal + attributeA.getLife()*3);
			double B = A + attributeB.getLife()*3 + bTotal;
			probability = A/B;
		} else if (pkSign == PKSign.NeiGong.getIndex()) {
			double A = Double.valueOf(aTotal + attributeA.getNeiGong()*3);
			double B = A + attributeB.getNeiGong()*3 + bTotal;
			probability = A/B;
		} else if (pkSign == PKSign.WaiGong.getIndex()) {
			double A = Double.valueOf(aTotal + attributeA.getWaiGong()*3);
			double B = A + attributeB.getWaiGong()*3 + bTotal;
			probability = A/B;
		} else if (pkSign == PKSign.Partner.getIndex()) {
			double A = Double.valueOf(aTotal + attributeA.getPartner()*3);
			double B = A + attributeB.getPartner()*3 + bTotal;
			probability = A/B;
		} else {
			Double A = Double.valueOf(aTotal);
			Double B = A + bTotal;
			probability = A/B;
		}

		double random = Math.random();
		if (probability > random) {
			return true;
		}
		return false;
	}

}
