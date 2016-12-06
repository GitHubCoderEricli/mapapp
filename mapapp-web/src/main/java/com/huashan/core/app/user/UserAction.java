package com.huashan.core.app.user;

import com.huashan.core.base.BaseAction;
import com.huashan.core.base.Service;
import com.huashan.core.beans.User;
import com.huashan.core.beans.WechatUser;
import com.huashan.core.webservice.UserService;
import com.huashan.core.webservice.WechatUserService;
import com.huashan.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Aug 16 17:25:54 CST 2016
 */

@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction {
	
	@Autowired
	UserService service;

	@Autowired
	WechatUserService wechatUserService;
	
	public Service<User> getService() {
		return service;
	}

	/**
	 * 1.通过微信回调获得参数code
	 * @param code
	 * @param state
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(String code, String state, HttpServletRequest request, Model model) {
		if (StringUtils.isNotEmpty(code)) {

//			WechatUser wechatUser = this.wechatUserService.findWechatUsetById(20);
			WechatUser wechatUser = this.wechatUserService.find(20);
			if (wechatUser == null) {
				return "/";
			}
			//2.通过code换取网页授权access_token并存储user信息
			User user = this.service.getAccess_token(wechatUser, code);
			if (user != null && user.getScope().equals("snsapi_userinfo")) {
				user = this.service.getUserInfo(user, wechatUser);
			}else {
				//判断用户是否关注公众号、如果关注了则去获取用户信息
			}
			request.getSession().setAttribute(User.USERSESSIONLOG, user);
			model.addAttribute("user", user);
		}
		return "/";
	}
}
