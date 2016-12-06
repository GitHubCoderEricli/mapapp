package com.huashan.core.beans.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 计划任务执行处 无状态
 * Created by lixu on 2016-07-01.
 */
public class QuartzJobFactory implements Job{
    public final Logger log = Logger.getLogger(this.getClass());
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Schedulejob scheduleJob = (Schedulejob) jobExecutionContext.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.invokMethod(scheduleJob);
    }
}
