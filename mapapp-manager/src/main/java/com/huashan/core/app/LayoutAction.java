package com.huashan.core.app;

import com.huashan.core.base.BaseAction;
import com.huashan.core.beans.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lixu on 2016-12-06.
 */
@Controller
@RequestMapping("layout")
public class LayoutAction extends BaseAction {
    @RequestMapping("main")
    public String layou(Model model) {
        AdminUser adminUser= (AdminUser)getSession().getAttribute(AdminUser.LOGIN_SESSION_INFO);
        if (adminUser == null) {
            return redirect("/");
        }
        model.addAttribute("user", adminUser);
        return "/sysviews/main";
    }
}
