package com.huashan.core.beans;

import com.huashan.core.base.AbstractItem;
import com.huashan.core.base.ItemBase;

import javax.persistence.*;

/**
 * Created by lixu on 2016-11-17.
 */
@Entity
@Table(name = "db_adminUser")
public class AdminUser extends AbstractItem implements ItemBase {
    public static final String LOGIN_SESSION_INFO = "LOGINSSIONINFO";

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public AdminUser() {
    }

    @Column(name = "id", nullable = false, length = 11)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userName", nullable = false, length = 60)
    private String userName;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @Column(name = "lev")
    private Integer lev;

    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
