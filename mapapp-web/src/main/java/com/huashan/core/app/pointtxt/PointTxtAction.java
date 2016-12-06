package com.huashan.core.app.pointtxt;

import com.huashan.core.base.BaseAction;
import com.huashan.core.webservice.PointTxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:21:08 CST 2016
 */

@Controller
@RequestMapping("/pointTxt")
public class PointTxtAction extends BaseAction {
	
	@Autowired
	PointTxtService service;
}
