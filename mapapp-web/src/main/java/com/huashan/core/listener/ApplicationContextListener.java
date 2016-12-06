package com.huashan.core.listener;

import com.huashan.utils.SPRUTIL;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lixu on 2016-06-06.
 */
@Component
public class ApplicationContextListener implements ServletContextListener,ApplicationContextAware {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String realpath = servletContextEvent.getServletContext().getRealPath("/");
        SPRUTIL.contextPath = realpath+"/WEB-INF";
        SPRUTIL.webContentPath = realpath;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SPRUTIL.context = applicationContext;
    }
}
