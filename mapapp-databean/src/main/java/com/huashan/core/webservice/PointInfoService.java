package com.huashan.core.webservice;

import javax.jws.WebService;
import com.huashan.core.base.Service;
import com.huashan.core.beans.PointDetailed;
import com.huashan.core.beans.PointInfo;

import java.util.List;


/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:07:26 CST 2016
 */
@WebService
public interface PointInfoService extends Service<PointInfo> {
    /**
     * 查询所有景点信息
     * 附带坐标信息
     * @return
     */
    List<PointInfo> findCascadeAll();

    /**
     * 获取景点详细信息
     * @param id
     * @return
     */
    PointDetailed findPointDetailed(Integer id);
}
