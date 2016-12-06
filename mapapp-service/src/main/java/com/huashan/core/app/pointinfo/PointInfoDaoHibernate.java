package com.huashan.core.app.pointinfo;

import com.huashan.core.base.DaoSupport;
import com.huashan.core.beans.PointInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:07:26 CST 2016
 */
@Repository
public class PointInfoDaoHibernate extends DaoSupport<PointInfo> implements PointInfoDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Integer> findByPointId(List<Integer> list) {
		String hql = "select pointId from PointInfo A where A.id in (:alist)";
		Query query = this.getSession().createQuery(hql);
		query.setParameterList("alist", list);
		return query.list();
	}

	@Override
	public List<PointInfo> findPointInfoByIdList(List<Integer> list) {
		String hql = " from PointInfo A where A.id in (:alist)";
		Query query = this.getSession().createQuery(hql);
		query.setParameterList("alist", list);
		return query.list();
	}
}

