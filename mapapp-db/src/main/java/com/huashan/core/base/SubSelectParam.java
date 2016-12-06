package com.huashan.core.base;

import com.huashan.utils.Pager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzhenwei on 2015/11/9.
 */
public class SubSelectParam {
    public SubSelectParam() {
    }

    private List<Criterion> criterionList = new ArrayList<Criterion>();
    private List<Order> orderList = new ArrayList<Order>();
    private Pager pager;
    private Integer id;

    public SubSelectParam(List<Criterion> criterionList, List<Order> orderList) {
        this.criterionList = criterionList;
        this.orderList = orderList;
    }

    public List<Criterion> getCriterionList() {
        return criterionList;
    }

    public void setCriterionList(List<Criterion> criterionList) {
        this.criterionList = criterionList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public void putCriterion(Criterion criterion) {
        criterionList.add(criterion);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
