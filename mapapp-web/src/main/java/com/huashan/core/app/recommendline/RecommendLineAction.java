package com.huashan.core.app.recommendline;

import com.huashan.core.base.BaseAction;
import com.huashan.core.base.Service;
import com.huashan.core.beans.MapResponse;
import com.huashan.core.beans.Point;
import com.huashan.core.beans.RecommendLine;
import com.huashan.core.webservice.PointLineService;
import com.huashan.core.webservice.RecommendLineService;
import com.huashan.utils.CollectionsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lixu
 * 
 * Thu Oct 27 22:16:10 CST 2016
 */

@Controller
@RequestMapping("/recommendLine")
public class RecommendLineAction extends BaseAction {
	
	@Autowired
	RecommendLineService service;

	@RequestMapping("getAll")
	@ResponseBody
	public MapResponse<List<RecommendLine>> getAll() {
		List<RecommendLine> list = this.service.getAllLine();
		if (!CollectionsUtil.isEmpty(list)) {
			return MapResponse.successResponse(list);
		} else {
			return MapResponse.failResponse("路线数据为空！！");
		}
	}

	@RequestMapping("getLineAndGridById")
	@ResponseBody
	public MapResponse<List<Point>> getLineAndGridById(Integer id) {
//		Object obj = map.get("id");
//		Integer id = obj == null? null:(Integer)obj;
		if (id == null) {
			return MapResponse.failResponse("路线id不能为空！");
		}
		List<Point> list = this.service.getLineAndGridById(id);
		return MapResponse.successResponse(list);
	}
}
