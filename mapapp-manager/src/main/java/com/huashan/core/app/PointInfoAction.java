package com.huashan.core.app;

import com.huashan.core.base.BaseAction;
import com.huashan.core.beans.MapResponse;
import com.huashan.core.beans.Point;
import com.huashan.core.beans.PointDetailed;
import com.huashan.core.beans.PointInfo;
import com.huashan.core.webservice.PointInfoService;
import com.huashan.core.webservice.PointService;
import com.huashan.utils.CollectionsUtil;
import com.huashan.utils.ObjectUtil;
import com.huashan.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author lixu
 *         <p>
 *         Wed Oct 26 23:07:26 CST 2016
 */

@Controller
@RequestMapping("/pointInfo")
public class PointInfoAction extends BaseAction {

    @Autowired
    PointInfoService service;

    @Autowired
    PointService pointService;

    @RequestMapping("list")
    public String getAll(HttpServletRequest request, Model model, Pager pager) {
        List<PointInfo> list = this.service.findCascadeByPager(pager);
        model.addAttribute("pointInfoList", list);
        model.addAttribute("pager", pager);
        return "/views/pointInfo/list";
    }

    @RequestMapping("add")
    public String addPointInfo(HttpServletRequest request, Model model) {
        List<Point> list = this.pointService.findAll();
        model.addAttribute("pointList", list);
        return "/views/pointInfo/add";
    }

    @RequestMapping("save")
    public String save(HttpServletRequest request, Model model, PointInfo pointInfo, Integer pointId,
                       @RequestParam(value = "file", required = false) MultipartFile[] file, String detailDis) {

        return "redirect:list";
    }

    @RequestMapping("getPointDetailed")
    @ResponseBody
    public MapResponse<PointDetailed> getPointDetailed(@RequestBody Map map, HttpServletRequest request, HttpServletResponse response) {
//        Integer id = (Integer)map.get("id");
        Object obj = map.get("id");
        Integer id = obj == null ? null : Integer.parseInt(obj.toString());
        PointDetailed vo = null;
        if (id == null) {
            return MapResponse.failResponse("id不能为空！");
        }
        vo = this.service.findPointDetailed(id);
        if (vo == null) {
            return MapResponse.failResponse("数据为空！");
        } else {
            return MapResponse.successResponse(vo);
        }
    }
}
