package com.huashan.core.app.pointinfo;

import com.huashan.core.app.point.PointDao;
import com.huashan.core.app.pointpicture.PointPictureDao;
import com.huashan.core.app.pointtxt.PointTxtDao;
import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.*;
import com.huashan.core.webservice.PointInfoService;
import com.huashan.utils.CollectionsUtil;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Wed Oct 26 23:07:26 CST 2016
 */
@Service
public class PointInfoServiceImpl extends ServiceSupport<PointInfo> implements PointInfoService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	PointInfoDao dao;

	@Autowired
	PointDao pointDao;

	@Autowired
	PointPictureDao pointPictureDao;

	@Autowired
	PointTxtDao pointTxtDao;
	
	public Dao<PointInfo> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(PointInfo t) {
		return dao.saveOrUpdate(t);
	}

	@Override
	@Transactional
	public List<PointInfo> findCascadeAll() {
		List<PointInfo> list = null;
		list = this.getDao().findAll();
		this.dao.sessionEvict(list);
		if (!CollectionsUtil.isEmpty(list)) {
			for (PointInfo p:list) {
				p.setPoint(pointDao.find(p.getPointId()));
			}
		}
		return list;
	}

	@Override
	public PointDetailed findPointDetailed(Integer id) {
		List<PointTxt> txtList = this.pointTxtDao.find(Restrictions.eq("pointInfoId", id));
		List<PointPicture> picturesList = this.pointPictureDao.find(Restrictions.eq("pointInfoId", id));
		if (CollectionsUtil.isEmpty(txtList) && CollectionsUtil.isEmpty(picturesList)) {
			return null;
		} else if (CollectionsUtil.isEmpty(txtList)){
			return new PointDetailed(picturesList, null);
		} else if (CollectionsUtil.isEmpty(picturesList)) {
			return new PointDetailed(null, txtList.get(0));
		} else {
			return new PointDetailed(picturesList, txtList.get(0));
		}
	}
}
