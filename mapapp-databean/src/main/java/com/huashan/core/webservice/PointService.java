package com.huashan.core.webservice;

import javax.jws.WebService;
import com.huashan.core.base.Service;
import com.huashan.core.beans.Point;
import com.huashan.utils.Pager;

import java.util.List;


/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:00:00 CST 2016
 */
@WebService
public interface PointService extends Service<Point> {
    /**
     * 根据条件查询结果
     * @param pager
     * @return
     */
    List<Point> findByPager(Pager pager);

}
