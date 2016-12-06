package com.huashan.core.app.job;

import com.huashan.core.base.BaseAction;
import com.huashan.core.base.Service;
import com.huashan.core.beans.job.Schedulejob;
import com.huashan.core.webservice.SchedulejobService;
import com.huashan.core.webservice.WechatUserService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 
 * 
 * @author lixu
 * 
 * Fri Aug 12 17:38:14 CST 2016
 */

@Controller
@RequestMapping("/schedulejob")
public class SchedulejobAction extends BaseAction {
	
	@Autowired
	SchedulejobService service;

	@Autowired
	WechatUserService wechatUserService;
	
		public Service<Schedulejob> getService() {
		return service;
	}

	@RequestMapping("test")
	public String list(Model model, String abc) throws SchedulerException {
		Schedulejob job = this.service.find(20);
		if (job.getJobStatus()==1) {
			this.service.runAJobNow(job);
		} else {
			this.service.addRunJob(job);
			this.service.runAJobNow(job);
		}
		return "/abc";
	}

}
