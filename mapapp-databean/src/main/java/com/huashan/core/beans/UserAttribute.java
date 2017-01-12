package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * 用户属性
 * Created by lixu on 2017-01-01.
 */
@Entity
@Table(name = "db_userAttribute")
public class UserAttribute extends AbstractItem implements ItemBase {
    @Column( name = "id" , nullable=false ,length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "timestamp" ,length = 32 )
    private String timestamp;

    @Column( name = "life" ,length = 11 )
    private Integer life;

    @Column( name = "neiGong" ,length = 11 )
    private Integer neiGong;

    @Column( name = "waiGong" ,length = 11 )
    private Integer waiGong;

    @Column( name = "partner" ,length = 11 )
    private Integer partner;

    @Column( name = "userid" ,length = 11)
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getNeiGong() {
        return neiGong;
    }

    public void setNeiGong(Integer neiGong) {
        this.neiGong = neiGong;
    }

    public Integer getWaiGong() {
        return waiGong;
    }

    public void setWaiGong(Integer waiGong) {
        this.waiGong = waiGong;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
