package com.huashan.core.webservice;

import com.huashan.core.base.Service;
import com.huashan.core.beans.job.Schedulejob;
import com.huashan.utils.Pager;
import com.huashan.utils.Result;
import org.quartz.SchedulerException;

import javax.jws.WebService;
import java.util.List;


/**
 * 
 * 
 * @author lixu
 * 
 * Fri Aug 12 17:38:14 CST 2016
 */
@WebService
public interface SchedulejobService extends Service<Schedulejob> {

    /**
     * 分页查询
     * @param pager
     * @return
     */
    Result<Schedulejob> findRoleByPager(Pager pager);

    /**
    * 获取所有计划中的定时任务
    * @return
            */
    List<Schedulejob> getAllJob() throws SchedulerException;

    /**
     * 暂停一个job
     * @param schedulejob
     */
    void pauseJob(Schedulejob schedulejob) throws SchedulerException;

    /**
     * 恢复一个job
     * @param schedulejob
     */
    void resumeJob(Schedulejob schedulejob) throws SchedulerException;

    /**
     * 删除一个job 停用时调用
     * @param schedulejob
     */
    void deleteJob(Schedulejob schedulejob) throws SchedulerException;

    /**
     * 立即执行
     * @param schedulejob
     */
    void runAJobNow(Schedulejob schedulejob) throws SchedulerException;

    /**
     * 更新在执行job的cronEx表达式
     * @param schedulejob
     */
    void updateJobCron(Schedulejob schedulejob) throws SchedulerException;

    /**
     * 添加计划任务
     * @param schedulejob
     */
    void addRunJob(Schedulejob schedulejob);

    String Test();
}
