package com.huashan.core.app;

import com.huashan.core.base.BaseAction;
import com.huashan.core.beans.AdminUser;
import com.huashan.core.beans.MapResponse;
import com.huashan.core.webservice.AdminUserService;
import com.huashan.utils.NumberUtil;
import com.huashan.utils.ObjectUtil;
import com.huashan.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lixu on 2016-11-17.
 */
@Controller
@RequestMapping("adminUser")
public class AdminUserAction extends BaseAction{
    @Autowired
    AdminUserService service;

    @RequestMapping("login")
    @ResponseBody
    public MapResponse<?> login(AdminUser user, HttpServletRequest request) {
        request.getSession().invalidate();//清除session中的数据
        String message = null;

        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return MapResponse.failResponse("用户名密码不能为空,请重试。");
        }

        AdminUser adminUser = this.service.find(user.getUserName(), user.getPassword());

        if (ObjectUtil.isEmpty(adminUser))
            return MapResponse.failResponse("用户名或密码错误,请重试。");
        if (NumberUtil.equals(adminUser.getStatus(), 1)) {
            return MapResponse.failResponse("登陆失败,您可能已被禁止登陆。");
        }

        //添加权限
        request.getSession().setAttribute(AdminUser.LOGIN_SESSION_INFO, adminUser);
        return MapResponse.successResponse(null);
    }

    public static void main(String[] args) {
        System.out.print(DigestUtils.md5Hex("123456").toString());
    }
}
