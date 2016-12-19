package com.huashan.core.app.recommendline;

import com.huashan.core.app.point.PointDao;
import com.huashan.core.app.pointinfo.PointInfoDao;
import com.huashan.core.app.pointline.PointLineDao;
import com.huashan.core.base.Dao;
import com.huashan.core.base.ServiceSupport;
import com.huashan.core.beans.Point;
import com.huashan.core.beans.PointInfo;
import com.huashan.core.beans.RecommendLine;
import com.huashan.core.webservice.RecommendLineService;
import com.huashan.utils.CollectionsUtil;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * 
 * @author lixu
 * 
 * Thu Oct 27 22:16:10 CST 2016
 */
@Service
public class RecommendLineServiceImpl extends ServiceSupport<RecommendLine> implements RecommendLineService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Autowired
	RecommendLineDao dao;

	@Autowired
	PointLineDao pointLineDao;

	@Autowired
	PointInfoDao pointInfoDao;

	@Autowired
	PointDao pointDao;

	public Dao<RecommendLine> getDao(){
		return this.dao;
	}
	
	public boolean saveOrUpdate(RecommendLine t) {
		return dao.saveOrUpdate(t);
	}

	@Override
	public List<RecommendLine> getAllLine() {
		List<RecommendLine> lineList = this.dao.findAll(Order.asc("code"));
		if (!CollectionsUtil.isEmpty(lineList)) {
			for (RecommendLine rl:lineList) {
				List<PointInfo> pList = this.pointLineDao.findPointInfoList(rl.getId());
				if (!CollectionsUtil.isEmpty(pList)) {
					rl.setPointInfoList(pList);
				}
			}
		}
		return lineList;
	}

	@Override
	public List<Point> getLineAndGridById(Integer id) {
//		List<PointLine> list = this.pointLineDao.find(Restrictions.eq("lineId", id), Order.asc("position"));
		List<Point> list = this.pointDao.findPointByLineId(id);
		return list;

//		if (!CollectionsUtil.isEmpty(list)) {
//			List<Integer> pointInfoIdList = new ArrayList<Integer>();
//			for (PointLine p:list) {
//				pointInfoIdList.add(p.getPointInfoId());
//			}
//			List<Integer> pointIdList = this.pointInfoDao.findByPointId(pointInfoIdList);
//			List<Point> pointList = this.pointDao.findPoinById(pointIdList);
//			return pointList;
//		}else {
//			return null;
//		}
	}
}
