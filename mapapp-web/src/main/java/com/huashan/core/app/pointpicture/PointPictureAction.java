package com.huashan.core.app.pointpicture;

import com.huashan.core.base.BaseAction;
import com.huashan.core.webservice.PointPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:13:48 CST 2016
 */

@Controller
@RequestMapping("/pointPicture")
public class PointPictureAction extends BaseAction {
	
	@Autowired
	PointPictureService service;
	
}
