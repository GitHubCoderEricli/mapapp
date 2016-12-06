package com.huashan.core.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 功能描述：所有controller的父类
 * Created by lixu on 2016-05-19.
 */
public abstract class BaseAction implements BaseController{

    /**
     * 获取session
     * @return
     */
    public HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession contextSess = attr.getRequest().getSession(true);
        return contextSess;
    }

    /**
     * 无model的action取RequestMapping中的value为路径
     *
     * @return
     */
    public String dir() {
        String dir = getClass().getAnnotation(RequestMapping.class).value()[0].replaceAll("/", "");
        return dir == null?null:dir.toLowerCase();
    }

    /**
     * 重定向
     *
     * @param path
     * @return
     */
    public String redirect(String path) {
        return join("", new String[]{"redirect:", path});
    }

    /**
     * 跳转
     *
     * @param path
     * @return
     */
    public String forward(String path) {
        return join("/", new String[]{dir(), path});
    }

    /**
     * 跳转
     *
     * @param path
     * @return
     */
    public String forward(String path,String viewsName) {
        return join("/", new String[]{viewsName, dir(), path});
    }

    /**
     * 根据url获取当前权限子权限
     * @param uri 当前节点uri
     * @return
     */
//    public List<Permission> getChildPermission(String uri) {
//        Assert.notNull(uri, "uri is null, can not get child permission");
//        String path = uri.substring(1, uri.lastIndexOf("."));
//        UserStorePermission userStorePermission = (UserStorePermission)this.getSession().getAttribute(UserStorePermission.LOGIN_SESSION_INFO);
//        List<Permission> list = new ArrayList<Permission>(userStorePermission.getCurrentPermission());
//        for (int i = 0; i < list.size(); i++) {
//            Permission permission = list.get(i);
//            if (path.equals(permission.getPpath())) {
//                return permission.getChildPermission();
//            }else if (!ObjectUtil.isEmpty(permission.getChildPermission())) {
//                list.addAll(permission.getChildPermission());
//            }
//        }
//        return null;
//    }

    /**
     * 连接字符串
     * @param joinAt 分隔符
     * @param str
     * @return
     */
    public static String join(  String joinAt,String[] str  ){
        String response = "";
        boolean first = true;
        for(String s : str ){
            if( first ){
                response += s;
                first = false;
            }else{
                response += ( joinAt + s );
            }
        }
        return response;
    }
}
