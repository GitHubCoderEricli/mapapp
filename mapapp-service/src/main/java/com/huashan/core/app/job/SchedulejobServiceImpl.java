package com.huashan.core.app.job;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.job.QuartzJobFactory;
import com.huashan.core.beans.job.QuartzJobFactoryDisallowConcurrentExecution;
import com.huashan.core.beans.job.Schedulejob;
import com.huashan.core.webservice.SchedulejobService;
import com.huashan.utils.*;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author lixu
 * 
 * Fri Aug 12 17:38:14 CST 2016
 */
@Service
public class SchedulejobServiceImpl extends ServiceSupport<Schedulejob> implements SchedulejobService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	SchedulejobDao dao;
	
	public Dao<Schedulejob> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(Schedulejob t) {
		return dao.saveOrUpdate(t);
	}

	public final Logger log = Logger.getLogger(this.getClass());


	@Override
	public Result<Schedulejob> findRoleByPager(Pager pager) {
		List criterionList = new ArrayList<Criterion>();
		List<Schedulejob> list = new ArrayList<Schedulejob>();
		String name = (String) pager.getQuery().get("name");
		if (StringUtils.areNotEmpty(name)) {
			criterionList.add(Restrictions.like("jobname", "%" + name + "%"));
		}
		String sortName = (String) pager.getQuery().get("sortName");
		String sortType = (String) pager.getQuery().get("sortType");
		if (!StringUtils.isEmpty(sortName) && !StringUtils.isEmpty(sortType)) {
			if(StringUtils.equals(sortType, "asc")) {
				list = this.dao.findCascade(pager, criterionList, null, Order.asc(sortName));
			}else {
				list = this.dao.findCascade(pager, criterionList, null, Order.desc(sortName));
			}
		}else {
			list = this.dao.findCascade(pager, criterionList, null, Order.desc("id"));
		}

		return new Result<Schedulejob>(pager,list);
	}

	@Override
	public List<Schedulejob> getAllJob() throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		GroupMatcher<JobKey> matcher = GroupMatcher.anyGroup();
		Set<JobKey> jobKeys = jobKeys = scheduler.getJobKeys(matcher);
		List<Schedulejob> jobList = new ArrayList<Schedulejob>();
		for (JobKey jobKey:jobKeys) {
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			for (Trigger trigger:triggers) {
				Schedulejob job = new Schedulejob();
				job.setJobName(jobKey.getName());
				job.setJobGroup(jobKey.getGroup());
				job = (Schedulejob) this.findByItem(job).get(0);
				Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
				jobList.add(job);
			}
		}
		return jobList;
	}

	@Override
	public void pauseJob(Schedulejob schedulejob) throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		JobKey jobKey = JobKey.jobKey(schedulejob.getJobName(), schedulejob.getJobGroup());
		scheduler.pauseJob(jobKey);
	}

	@Override
	public void resumeJob(Schedulejob schedulejob) throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		JobKey jobKey = JobKey.jobKey(schedulejob.getJobName(), schedulejob.getJobGroup());
		scheduler.resumeJob(jobKey);
	}

	@Override
	public void deleteJob(Schedulejob schedulejob) throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		JobKey jobKey = JobKey.jobKey(schedulejob.getJobName(), schedulejob.getJobGroup());
		scheduler.deleteJob(jobKey);
	}

	@Override
	public void runAJobNow(Schedulejob schedulejob) throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		JobKey jobKey = JobKey.jobKey(schedulejob.getJobName(), schedulejob.getJobGroup());
		scheduler.triggerJob(jobKey);
	}

	@Override
	public void updateJobCron(Schedulejob schedulejob) throws SchedulerException {
		Scheduler scheduler = getSchedulerFactory().getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(schedulejob.getJobName(), schedulejob.getJobGroup());

		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(schedulejob.getCronExpression());

		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

		scheduler.rescheduleJob(triggerKey, trigger);
	}

	public void addRunJob(Schedulejob job) {
		if (ObjectUtil.isEmpty(job) || !Schedulejob.STATUS_RUNNING.equals(job.getJobStatus().toString())) {
			return;
		}
		Scheduler scheduler = this.getSchedulerFactory().getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
		CronTrigger trigger = null;
		try {
			trigger = (CronTrigger)scheduler.getTrigger(triggerKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
			log.info("triggerKey不存在");
			return;
		}
		if (trigger == null) {
			Class clazz = Schedulejob.CONCURRENT_IS.equals(job.getIsConcurrent())? QuartzJobFactory.class : QuartzJobFactoryDisallowConcurrentExecution.class;
			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(),job.getJobGroup()).build();

			jobDetail.getJobDataMap().put("scheduleJob", job);
			CronScheduleBuilder cronScheduleBuilder;
			try {
				cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
			} catch (Exception e) {
				e.printStackTrace();
				log.error("Cronexpression不正确"+e.getMessage());
				return;
			}


			trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup()).withSchedule(cronScheduleBuilder).build();
			try {
				scheduler.scheduleJob(jobDetail, trigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
				log.error("创建job失败！"+e.getMessage());
			}
			//trigger已存在，更新相应的定时设置
		} else {
			CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();

			// 按新的trigger重新设置job执行
			try {
				scheduler.rescheduleJob(triggerKey, trigger);
			} catch (SchedulerException e) {
				e.printStackTrace();
				log.error("更新job失败！"+e.getMessage());
			}
		}
		log.info("定时任务穿件完成。");
	}

	SchedulerFactoryBean getSchedulerFactory() {
		SchedulerFactoryBean schedulerFactoryBean = SPRUTIL.getBean(SchedulerFactoryBean.class);
		return schedulerFactoryBean;
	}

	@Override
	public String Test() {
		return "Hello world!";
	}
}
