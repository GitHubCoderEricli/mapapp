package com.huashan.core.app.pointpicture;



import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.PointPicture;
import com.huashan.core.webservice.PointPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:13:48 CST 2016
 */
@Service
public class PointPictureServiceImpl extends ServiceSupport<PointPicture> implements PointPictureService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	PointPictureDao dao;
	
	public Dao<PointPicture> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(PointPicture t) {
		return dao.saveOrUpdate(t);
	}
}
