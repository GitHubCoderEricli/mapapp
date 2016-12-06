package com.huashan.core.base;

import com.huashan.core.annotation.CoocaaCascade;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Dao实现类中用来传递数据的类
 * Created by chenzhenwei on 2015/11/9.
 */
public class AliasBean {
    private Dao dao;
    private Field field;
    private CoocaaCascade coocaaCascade;

    private Method methodSet;

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public CoocaaCascade getCoocaaCascade() {
        return coocaaCascade;
    }

    public void setCoocaaCascade(CoocaaCascade coocaaCascade) {
        this.coocaaCascade = coocaaCascade;
    }

    public Method getMethodSet() {
        return methodSet;
    }

    public void setMethodSet(Method methodSet) {
        this.methodSet = methodSet;
    }
}
