package com.huashan.core.webservice;

import javax.jws.WebService;

import com.huashan.core.base.Service;
import com.huashan.core.beans.Point;
import com.huashan.core.beans.RecommendLine;

import java.util.List;


/**
 * 
 * 
 * @author lixu
 * 
 * Thu Oct 27 22:16:10 CST 2016
 */
@WebService
public interface RecommendLineService extends Service<RecommendLine> {
    /**
     * 获取所有路线
     * @return
     */
    List<RecommendLine> getAllLine();

    /**
     * 获取路线所有点坐标
     * @param id 路线id
     * @return
     */
    List<Point> getLineAndGridById(Integer id);
}
