package com.huashan.core.app.point;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.Point;
import com.huashan.core.webservice.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:00:00 CST 2016
 */
@Service
public class PointServiceImpl extends ServiceSupport<Point> implements PointService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	PointDao dao;
	
	public Dao<Point> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(Point t) {
		return dao.saveOrUpdate(t);
	}
}
