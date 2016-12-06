package com.huashan.core.beans;


import javax.persistence.*;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixu
 *         <p>
 *         Thu Oct 27 22:16:10 CST 2016
 */
@Entity
@Table(name = "db_recommendLine")
public class RecommendLine extends AbstractItem implements ItemBase {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public RecommendLine() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "powerTime", length = 11)
    private Integer powerTime;

    @Column(name = "expendTime", length = 11)
    private Double expendTime;

    @Column(name = "selPercent", length = 11)
    private Integer selPercent;

    @Column(name = "cost", length = 11)
    private Integer cost;

    @Column(name = "buyTicketUrl", length = 320)
    private String buyTicketUrl;

    @Column(name = "code", length = 60)
    private String code;

    @Column(name = "shortName", length = 60)
    private String shortName;

    @Transient
    private List<PointInfo> pointInfoList = new ArrayList<PointInfo>();


    public RecommendLine(Integer id, String name, Integer powerTime, Double expendTime, Integer selPercent, Integer cost, String buyTicketUrl, String code, String shortName) {
        this.id = id;
        this.name = name;
        this.powerTime = powerTime;
        this.expendTime = expendTime;
        this.selPercent = selPercent;
        this.cost = cost;
        this.buyTicketUrl = buyTicketUrl;
        this.code = code;
        this.shortName = shortName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPowerTime(Integer powerTime) {
        this.powerTime = powerTime;
    }

    public Integer getPowerTime() {
        return this.powerTime;
    }

    public void setExpendTime(Double expendTime) {
        this.expendTime = expendTime;
    }

    public Double getExpendTime() {
        return this.expendTime;
    }

    public void setSelPercent(Integer selPercent) {
        this.selPercent = selPercent;
    }

    public Integer getSelPercent() {
        return this.selPercent;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setBuyTicketUrl(String buyTicketUrl) {
        this.buyTicketUrl = buyTicketUrl;
    }

    public String getBuyTicketUrl() {
        return this.buyTicketUrl;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public List<PointInfo> getPointInfoList() {
        return pointInfoList;
    }

    public void setPointInfoList(List<PointInfo> pointInfoList) {
        this.pointInfoList = pointInfoList;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
