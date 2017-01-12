package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * Created by lixu on 2017-01-02.
 */
@Entity
@Table(name = "db_npc")
public class NPC  extends AbstractItem implements ItemBase {
    @Column( name = "id" , nullable=false ,length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "img" ,length = 320 )
    private String img;

    @Column(name = "name", length = 60, nullable = false)
    private String name;

    @Column(name = "code", length = 11, nullable = false)
    private Integer code;

    @Column(name = "userid", length = 11, nullable = false)
    private Integer userId;

    private User user;

    private UserAttribute userAttribute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAttribute getUserAttribute() {
        return userAttribute;
    }

    public void setUserAttribute(UserAttribute userAttribute) {
        this.userAttribute = userAttribute;
    }
}
