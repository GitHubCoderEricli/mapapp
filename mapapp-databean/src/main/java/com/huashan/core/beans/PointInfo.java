package com.huashan.core.beans;

import javax.persistence.*;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

/**
 * @author lixu
 *         <p>
 *         Wed Oct 26 23:07:26 CST 2016
 */
@Entity
@Table(name = "db_pointInfo")
public class PointInfo extends AbstractItem implements ItemBase {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PointInfo() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pointId", length = 11)
    private Integer pointId;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "icon", length = 260)
    private String icon;

    @Column(name = "shortDes", length = 320)
    private String shortDes;

    @Column(name = "picture", length = 260)
    private String picture;

    @Column(name = "address", length = 320)
    private String address;

    @Column(name = "audio", length = 320)
    private String audio;

    @Column(name = "recommendNum", length = 11)
    private Integer recommendNum;

    @Column(name = "difficultyNum", length = 11)
    private Integer difficultyNum;

    @Column(name = "interestNum", length = 11)
    private Integer interestNum;

    @Column(name = "type", length = 11)
    private Integer type;

    @Transient
    private Point point;

    public PointInfo(Integer id, Integer pointId, String name, String icon, String shortDes, String picture, String address, String audio, Integer recommendNum, Integer difficultyNum, Integer interestNum, Integer type) {
        this.id = id;
        this.pointId = pointId;
        this.name = name;
        this.icon = icon;
        this.shortDes = shortDes;
        this.picture = picture;
        this.address = address;
        this.audio = audio;
        this.recommendNum = recommendNum;
        this.difficultyNum = difficultyNum;
        this.interestNum = interestNum;
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public Integer getPointId() {
        return this.pointId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getShortDes() {
        return this.shortDes;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getRecommendNum() {
        return this.recommendNum;
    }

    public void setDifficultyNum(Integer difficultyNum) {
        this.difficultyNum = difficultyNum;
    }

    public Integer getDifficultyNum() {
        return this.difficultyNum;
    }

    public void setInterestNum(Integer interestNum) {
        this.interestNum = interestNum;
    }

    public Integer getInterestNum() {
        return this.interestNum;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return this.type;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
