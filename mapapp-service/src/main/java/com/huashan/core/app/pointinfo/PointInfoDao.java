package com.huashan.core.app.pointinfo;

import com.huashan.core.base.Dao;
import com.huashan.core.beans.PointInfo;
import com.huashan.core.beans.PointLine;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:07:26 CST 2016
 */
public interface PointInfoDao extends Dao<PointInfo> {
    /**
     * 根据id列表查询PointInfoId
     * @param list
     * @return
     */
    List<Integer> findByPointId(List<Integer> list);

    /**
     * 根据id列表查询PointInfo
     * @param list
     * @return
     */
    List<PointInfo> findPointInfoByIdList(List<Integer> list);
}
