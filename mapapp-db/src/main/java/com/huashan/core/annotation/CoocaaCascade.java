package com.huashan.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义级联查询注解，不用hibernate的级联查询，自己做可控的级联查询
 *
 * Created by chenzhenwei on 2015/11/1.
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CoocaaCascade {
    /**
     * 对应的目标字段--实体类字段非数据库字段
     * @return
     */
    String targetColumn() default "id";

    /**
     * 本表的对应字段--实体类字段非数据库字段
     * @return
     */
    String jionColunm() default "id";

    /**
     * 级联查询调用的dao接口,从spring中取
     * @return
     */
    String daoClassName();

    /**
     * 是否是延迟加载
     * @return
     */
    boolean isLazyLoad() default false;
}
