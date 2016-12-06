package com.huashan.core.app.point;

import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.Point;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:00:00 CST 2016
 */
@Repository
public class PointDaoHibernate extends DaoSupport<Point> implements PointDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Point> findPoinById(List<Integer> list) {
		String hql = "from Point A where A.id in (:alist)";
		Query query = this.getSession().createQuery(hql);
		query.setParameterList("alist", list);
		List<Point> pointList = query.list();
		return pointList;
	}

	@Override
	public List<Point> findPointByLineId(Integer lineId) {
		String hql = "SELECT \n" +
				"  A \n" +
				"FROM\n" +
				"  Point A,\n" +
				"  PointInfo B,\n" +
				"  PointLine C \n" +
				"WHERE A.id = B.pointId \n" +
				"  AND B.id = C.pointInfoId \n" +
				"  AND C.lineId = (:lineId) \n" +
				"ORDER BY C.position ASC ";
		Query query = this.getSession().createQuery(hql);
		query.setParameter("lineId", lineId);
		List<Point> pointList = query.list();
		return pointList;
	}
}

