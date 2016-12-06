package com.huashan.core.app.pointline;

import com.huashan.core.base.Dao;
import com.huashan.core.beans.PointInfo;
import com.huashan.core.beans.PointLine;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Nov 01 21:41:24 CST 2016
 */
public interface PointLineDao extends Dao<PointLine> {
    /**
     * 根据PointLineId查询PointInfo id
     * @param lineId
     * @return
     */
    List<Integer> findPointInfoId(Integer lineId);

    /**
     * 根据路线id获取关联点信息
     * @param lineId
     * @return
     */
    List<PointInfo> findPointInfoList(Integer lineId);
	
}
