package com.huashan.core.app.point;

import com.huashan.core.base.BaseAction;
import com.huashan.core.base.Service;
import com.huashan.core.beans.Point;
import com.huashan.core.webservice.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:00:00 CST 2016
 */

@Controller
@RequestMapping("/point")
public class PointAction extends BaseAction {
	
	@Autowired
	PointService service;
	
	public Service<Point> getService() {
		return service;
	}

}
