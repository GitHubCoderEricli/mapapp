package com.huashan.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * Created by lixu on 2016-06-06.
 */
public class SPRUTIL {
    /**
     * 系统路径
     */
    public static String contextPath = null;
    /**
     * 项目跟目录
     */
    public static String webContentPath = null;
    /**
     * spring上下文
     */
    public static ApplicationContext context = null;

    /**
     * 获取spring管理的bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> name) throws BeansException {
        return (T) context.getBean(name);
    }
}
