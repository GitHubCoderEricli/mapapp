package com.huashan.core.app.pointtxt;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.PointTxt;
import com.huashan.core.webservice.PointTxtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:21:08 CST 2016
 */
@Service
public class PointTxtServiceImpl extends ServiceSupport<PointTxt> implements PointTxtService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	PointTxtDao dao;

	@Override
	public Dao<PointTxt> getDao() {
		return null;
	}

	public boolean saveOrUpdate(PointTxt t) {
		return dao.saveOrUpdate(t);
	}
}
