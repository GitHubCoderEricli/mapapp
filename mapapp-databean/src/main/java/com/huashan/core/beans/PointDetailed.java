package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixu on 2016-10-31.
 * 封装返回数据
 */
public class PointDetailed extends AbstractItem implements ItemBase{
    private List<PointPicture> pointPiture = new ArrayList<PointPicture>();
    private PointTxt pointTxt;

    public PointDetailed() {
    }

    public PointDetailed(List<PointPicture> pointPiture, PointTxt pointTxt) {
        this.pointPiture = pointPiture;
        this.pointTxt = pointTxt;
    }

    public List<PointPicture> getPointPiture() {
        return pointPiture;
    }

    public void setPointPiture(List<PointPicture> pointPiture) {
        this.pointPiture = pointPiture;
    }

    public PointTxt getPointTxt() {
        return pointTxt;
    }

    public void setPointTxt(PointTxt pointTxt) {
        this.pointTxt = pointTxt;
    }
}
