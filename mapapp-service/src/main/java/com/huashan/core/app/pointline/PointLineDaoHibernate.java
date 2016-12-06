package com.huashan.core.app.pointline;

import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.PointInfo;
import com.huashan.core.beans.PointLine;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Nov 01 21:41:24 CST 2016
 */
@Repository
public class PointLineDaoHibernate extends DaoSupport<PointLine> implements PointLineDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Integer> findPointInfoId(Integer lineId) {
		String hql = "select pointInfoId from PointLine where lineId =(:lineId)";
		Query query = this.getSession().createQuery(hql);
		query.setParameter("lineId", lineId);
		return query.list();
	}

	@Override
	public List<PointInfo> findPointInfoList(Integer lineId) {
		String hql = "select A from PointInfo A,PointLine B where B.pointInfoId = A.id and B.lineId = (:lineId) order by B.position asc";
		Query query = this.getSession().createQuery(hql);
		query.setParameter("lineId", lineId);
		return query.list();
	}
}

