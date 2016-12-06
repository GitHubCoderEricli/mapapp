package com.huashan.core.beans.job;

import com.huashan.utils.ObjectUtil;
import com.huashan.utils.SPRUTIL;
import com.huashan.utils.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lixu on 2016-07-01.
 */
public class TaskUtils {
    public final static Logger log = Logger.getLogger(TaskUtils.class);

    /**
     * 通过反射调用schduleJob中定义的方法
     * @param job
     */
    public static void invokMethod(Schedulejob job) {
        Object obj = null;
        Class clazz = null;

        if (StringUtils.isNotEmpty(job.getBeanClass())) {
            try {
                clazz = Class.forName(job.getBeanClass().toString());
//                obj = clazz.newInstance();
                obj = SPRUTIL.getBean(clazz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//            catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
        }
        if (ObjectUtil.isEmpty(obj)) {
            log.error("定时任务执行失败"+job.getJobName());
            return;
        }
        clazz = obj.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(job.getMethodName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            log.error("定时任务执行失败"+job.getJobName());
            return;
        }
        if (ObjectUtil.isNotEmpty(obj)) {
            try {
                method.invoke(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                log.error("定时任务执行失败" + job.getJobName());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                log.error("定时任务执行失败"+job.getJobName());
            }
        }
    }
}
