package com.huashan.core.app.wechatuser;

import com.huashan.core.base.BaseAction;
import com.huashan.core.base.Service;
import com.huashan.core.beans.WechatUser;
import com.huashan.core.webservice.WechatUserService;
import com.huashan.utils.Sha1Util;
import com.huashan.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lixu
 * 
 * Fri Aug 12 16:41:21 CST 2016
 */

@Controller
@RequestMapping("/wechatUser")
public class WechatUserAction extends BaseAction {

	public final Logger log = Logger.getLogger(this.getClass());

	//微信公众平台填写的token
	private static String token = "test";
	@Autowired
	WechatUserService service;

	public Service<WechatUser> getService() {
		return service;
	}

	/**
	 * 微信开发者校验
	 */
	@ResponseBody
	@RequestMapping(value = "developer" ,method = RequestMethod.GET)
	public String developer(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		String signature = httpServletRequest.getParameter("signature");
		String timestamp = httpServletRequest.getParameter("timestamp");
		String nonce = httpServletRequest.getParameter("nonce");
		String echostr = httpServletRequest.getParameter("echostr");

		List<String> list = new ArrayList<>();
		list.add(token);
		list.add(timestamp);
		list.add(nonce);

		//安字典排序
		Collections.sort(list);

		String signature1 = Sha1Util.SHA1(list.get(0) + list.get(1) + list.get(2));
		if (StringUtils.isNotEmpty(signature1) && signature1.equals(signature)) {
			log.info("signature1 = " + signature1);
			return echostr;
		} else {
			log.info("signature = " + signature);
			return echostr;
		}
	}

	@RequestMapping(value = "login")
	public String login(HttpServletRequest httpServletRequest) {
//		Map map = httpServletRequest.getParameterMap();
//		for (Object obj:map.keySet()) {
//			log.info(map.get(obj));
//		}
//		String url = httpServletRequest.getRequestURL().toString();
//		String openid = httpServletRequest.getAttribute("oprnid").toString();
		return "/";
	}

}
