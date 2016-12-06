package com.huashan.core.app.point;

import com.huashan.core.base.Dao;
import com.huashan.core.beans.Point;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:00:00 CST 2016
 */
public interface PointDao extends Dao<Point> {
    /**
     * 按id顺序排序
     * @param list
     * @return
     */
    List<Point> findPoinById(List<Integer> list);

    /**
     * 根据路线id查询有序的Point
     * @param lineId
     * @return
     */
    List<Point> findPointByLineId(Integer lineId);
}
