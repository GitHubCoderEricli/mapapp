package com.huashan.core.interceptor;

import com.huashan.core.beans.AdminUser;
import com.huashan.utils.ObjectUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lixu on 2016-05-09.
 * 权限拦截
 */
public class UserInterceptorAdaptor extends HandlerInterceptorAdapter {
    public final Logger log = Logger.getLogger(this.getClass());

    private static String[] uriStr = {"/adminUser/login"};
    /**
     * 访问前处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        log.info(uri);
        if (!checkStr(uriStr,uri)) {
            AdminUser user = (AdminUser)request.getSession().getAttribute(AdminUser.LOGIN_SESSION_INFO);
            if (ObjectUtil.isNotEmpty(user)) {
                return super.preHandle(request, response, handler);
            }else {
                response.sendRedirect("/");
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * 后处理回调方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 整个请求处理完毕回调方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    /**
     * 过滤不拦截的请求,存在返回true
     * @return
     */
    private boolean checkStr(String[] uriStr, String uri) {
        if (uriStr == null || uriStr.length==0) {
            return false;
        }
        for (String ss:uriStr) {
            if (ss.equals(uri)) {
                return true;
            }
        }
        return false;
    }
}
