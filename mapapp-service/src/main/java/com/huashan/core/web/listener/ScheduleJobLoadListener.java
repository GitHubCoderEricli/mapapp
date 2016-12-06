package com.huashan.core.web.listener;

import com.huashan.core.beans.job.Schedulejob;
import com.huashan.core.webservice.SchedulejobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lixu on 2016-06-30.
 */
@Component
public class ScheduleJobLoadListener implements ApplicationListener<ContextRefreshedEvent> {
    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    SchedulejobService service;

    public final Logger log = Logger.getLogger(this.getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = (ApplicationContext)event.getSource();
        schedulerFactoryBean = (SchedulerFactoryBean)context.getBean(SchedulerFactoryBean.class);
//        SchedulejobService service = context.getBean(SchedulejobService.class);
        init(service);
        log.info("-------------------------ScheduleJobLoadListener--------------------------------");
    }

    public void init(SchedulejobService service) {
        List<Schedulejob> jobList = service.findAll();
        for (Schedulejob job : jobList) {
            this.service.addRunJob(job);
        }
    }


}
