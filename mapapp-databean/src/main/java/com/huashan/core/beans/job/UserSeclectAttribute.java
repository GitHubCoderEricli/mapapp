package com.huashan.core.beans.job;

import com.huashan.core.beans.UserAttribute;
import com.huashan.core.beans.UserSelectSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于前后端传值、
 * Created by lixu on 2017-01-02.
 */
public class UserSeclectAttribute {
    private UserAttribute userAttribute;

    private List<UserSelectSubject> userSelectSubjects = new ArrayList<UserSelectSubject>();

    public UserAttribute getUserAttribute() {
        return userAttribute;
    }

    public void setUserAttribute(UserAttribute userAttribute) {
        this.userAttribute = userAttribute;
    }

    public List<UserSelectSubject> getUserSelectSubject() {
        return userSelectSubjects;
    }

    public void setUserSelectSubject(List<UserSelectSubject> userSelectSubjects) {
        this.userSelectSubjects = userSelectSubjects;
    }
}
