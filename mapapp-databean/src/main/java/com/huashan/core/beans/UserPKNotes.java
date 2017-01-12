package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * 用户pk记录表
 * Created by lixu on 2017-01-12.
 */
@Entity
@Table(name = "db_userpknotes")
public class UserPKNotes extends AbstractItem implements ItemBase {
    @Column( name = "id" , nullable=false ,length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "userid", nullable = false)
    private Integer userId;

    @Column( name = "npcid", nullable = false)
    private Integer npcId;

    @Column( name = "pktimes", nullable = false)
    private Integer pkTimes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNpcId() {
        return npcId;
    }

    public void setNpcId(Integer npcId) {
        this.npcId = npcId;
    }

    public Integer getPkTimes() {
        return pkTimes;
    }

    public void setPkTimes(Integer pkTimes) {
        this.pkTimes = pkTimes;
    }
}
