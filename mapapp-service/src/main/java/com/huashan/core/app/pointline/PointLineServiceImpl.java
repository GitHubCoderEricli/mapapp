package com.huashan.core.app.pointline;

import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.PointLine;
import com.huashan.core.webservice.PointLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

/**
 * 
 * 
 * @author lixu
 * 
 * Tue Nov 01 21:41:24 CST 2016
 */
@Service
public class PointLineServiceImpl extends ServiceSupport<PointLine> implements PointLineService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	PointLineDao dao;
	
	public Dao<PointLine> getDao(){
		return this.dao;
	}

	@Override
	public boolean saveOrUpdate(PointLine pointLine) {
		return false;
	}

}
