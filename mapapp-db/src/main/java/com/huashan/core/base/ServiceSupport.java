package com.huashan.core.base;


import com.huashan.utils.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：service的基础实现
 * <p/>
 * 2010-12-30  上午11:44:28
 *
 * @param <T>
 */

public abstract class ServiceSupport<T extends AbstractItem> implements Service<T>, Serializable {

    public abstract Dao<T> getDao();


    /**
     *
     */
    private static final long serialVersionUID = -1040390621007755334L;
    protected final Log logger = LogFactory.getLog(getClass());


    @SuppressWarnings("unchecked")
    private Class<T> getBeanClass() {
        return (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 添加或修改一条记录
     *
     * @param t
     * @return
     */
    @Transactional
    public abstract boolean saveOrUpdate(T t);

    /**
     * 使用id删除
     *
     * @param id
     * @return
     */
    @Transactional
    public boolean delete(Integer id) {
        return getDao().delete(id);
    }

    /**
     * 使用id删除
     *
     * @param ids
     * @return
     */
    @Transactional
    public boolean delete(Integer[] ids) {
        return getDao().delete(ids);
    }

    /**
     * 删除该项
     */
    @Transactional
    public boolean delete(T t) {
        return getDao().delete(t);

    }

//    /**
//     * 使用id查找有延迟加载的数据
//     *
//     * @param id
//     * @return
//     */
//    public T load(Integer id) {
//        return getDao().load(id);
//    }

//    /**
//     * load所有延迟数据
//     *
//     * @return
//     */
//    public List<T> loadAll() {
//        return getDao().loadAll();
//    }

    /**
     * 使用id查找
     *
     * @param id
     * @return
     */
    @Transactional
    public T find(Integer id) {
        if (id == null) return null;
        return getDao().find(id);
    }

    /**
     * 使用id字符串查找,字符串格式为,1,2,3,4
     *
     * @param ids
     * @return
     */
    @Transactional
    public List<T> find(String ids) {
        if (StringUtils.isEmpty(ids)) return null;
        List<Integer> idsList = new ArrayList<Integer>();
        String[] temp = ids.split(",");
        for (String t : temp) {
            if (StringUtils.isNotEmpty(t)) {
                idsList.add(NumberUtil.toInt(t));
            }
        }
        return find(idsList);
    }

    /**
     * 使用id数组查找
     *
     * @param ids
     * @return
     */
    @Transactional
    public List<T> find(Integer[] ids) {
        return getDao().find(Restrictions.in("id", ids));
    }

    /**
     * 使用id集合
     *
     * @param ids
     * @return
     */
    @Transactional
    public List<T> find(Collection<Integer> ids) {
        return getDao().find(Restrictions.in("id", ids));
    }

    /**
     * 查找所有
     */
    @Transactional
    public List<T> findAll() {
        return getDao().findAll(Order.desc("id"));
    }


    /**
     * 使用pager查询
     *
     * @param pager
     * @return
     */
    @Transactional
    public Result<T> find(Pager pager) {
        return new Result<T>(pager, getDao().find(pager));
    }
    @Transactional
    public List<T> find(Pager pager, Map<String, Object> queryMap) {
        return getDao().find(pager, queryMap);
    }

//    /**
//     * 使用id字符串查找,字符串格式为,1,2,3,4
//     *
//     * @param ids
//     * @return
//     */
//    public List<T> load(String ids) {
//        if (StringUtils.isEmpty(ids)) return null;
//
//        List<Integer> idsList = new ArrayList<Integer>();
//        String[] temp = ids.split(",");
//        for (String t : temp) {
//            if (StringUtils.isNotEmpty(t)) {
//                idsList.add(NumberUtil.toInt(t));
//            }
//        }
//
//        return load(idsList);
//    }

//    /**
//     * 使用id数组查找
//     *
//     * @param id
//     * @return
//     */
//    public List<T> load(Integer[] id) {
//        return getDao().load(Restrictions.in("id", id));
//    }

//    /**
//     * 使用id数组查找
//     *
//     * @param ids
//     * @return
//     */
//    public List<T> load(Collection<Integer> ids) {
//        return getDao().load(Restrictions.in("id", ids));
//    }

//    /**
//     * 使用pager查询
//     *
//     * @param pager
//     * @return
//     */
//    public List<T> load(Pager pager) {
//        return getDao().load(pager);
//    }


//    /**
//     * 使用pager查询,并包含query参数
//     *
//     * @param pager
//     * @param queryMap
//     * @return
//     */
//    public List<T> load(Pager pager, Map<String, Object> queryMap) {
//        return getDao().load(pager, queryMap);
//    }

    /**
     * 使用实体查找,屏蔽null
     *
     * @param t
     * @return
     */
    @Transactional
    public List<T> findByItem(T t) {
        return getDao().findByItem(t);
    }

    /**
     * 使用实体查找,屏蔽null
     * @param pager
     * @param t
     * @return
     */
    @Transactional
    public List<T> findByItem(Pager pager, T t) {
        return getDao().findByItem(pager, t);
    }


    /**
     * 是否有相同的,如果有 返回该相同数据,默认验证为name
     * 如果用name验证可以使用该方法
     *
     * @param value
     * @return
     */
    @Transactional
    public T hasSame(String value) {
        return hasSame("name", value);
    }

    /**
     * 是否有相同的,如果有 返回该相同数据,默认验证为name
     * 如果用name验证可以使用该方法
     * @param propertyName
     * @param value
     * @return
     */
    @Transactional
    public T hasSame(String propertyName, String value) {
        return hasSame(new Pair<String, String>(propertyName, value));
    }
    @Transactional
    public List<T> hasSames(String propertyName, String value) {
        return hasSames(new Pair<String, String>(propertyName, value));
    }
    @Transactional
    public T hasSame(Pair<?, ?>... pairs) {
        return hasSames(pairs) == null ? null : hasSames(pairs).get(0);
    }

    /**
     * 是否有相同的,如果有 返回该相同数据,默认验证为name
     * 如果用name验证可以使用该方法
     * @param pairs
     * @return
     */
    @Transactional
    public List<T> hasSames(Pair<?, ?>... pairs) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        for (Pair<?, ?> pair : pairs) {
            criterionList.add(Restrictions.eq((String) pair.getFirst(), pair.getSecond()));
        }
        Criterion[] criterions = new Criterion[criterionList.size()];
        criterionList.toArray(criterions);
        List<T> finds = getDao().find(criterions);
        if (CollectionsUtil.isEmpty(finds)) return null;
        return finds;
    }

    /**
     * 使用条件查找,返回总数
     *
     * @param criteriones
     * @return
     */
    @Transactional
    public int getTotal(Criterion... criteriones) {
        return getDao().getTotal(criteriones);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public boolean saveOrUpdate(String json) {
        JSONObject obj = JSONObject.fromObject(json);
        T t = (T) JSONObject.toBean(obj, this.getBeanClass());
        return this.saveOrUpdate(t);
    }
    @Transactional
    public Result<T> find_json(String pagerStr) {
        return this.find(com.huashan.utils.StringUtils.urlToPager(pagerStr));
    }
    @Transactional
    public Result<T> findByPagerQuery(Pager pager) throws Exception {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Pager.QueryMap> listQuery = pager.getQueryMaps();
        try {
            for (Pager.QueryMap queryMap : listQuery) {// and
                criterionList.add(createCriterion(queryMap));
            }
        } catch (IllegalAccessException e) {
            logger.error(e);
        } catch (InvocationTargetException e) {
            logger.error(e);
        } catch (NoSuchMethodException e) {
            logger.error(e);
        }
        Criterion[] criterions = new Criterion[criterionList.size()];
        criterionList.toArray(criterions);

        List<Order> sortList = pager.getListSort();

        List<T> list = getDao().find(pager, criterions, sortList.toArray(new Order[]{}));
        return new Result<T>(pager, getDao().fetchCascade(list));
    }
    @Transactional
    private Criterion createCriterion(Pager.QueryMap queryMap) throws Exception {
        Method method = null;
        if (Prompt.QueryOption.IN.equals(queryMap.queryOption)) {// in
            if (Collection.class.isAssignableFrom(queryMap.value.getClass())) {
                method = Restrictions.class.getMethod(queryMap.queryOption.getOption(), String.class, Collection.class);
            } else if (queryMap.value.getClass().isArray()) {
                method = Restrictions.class.getMethod(queryMap.queryOption.getOption(), String.class, Object[].class);
            } else {
                throw new Exception("parameter can not match 'in' to " + queryMap.value.getClass());
            }
        } else if (Prompt.QueryOption.ISNOTNULL.equals(queryMap.queryOption) || Prompt.QueryOption.ISNULL.equals(queryMap.queryOption)
                || Prompt.QueryOption.ISEMPTY.equals(queryMap.queryOption) || Prompt.QueryOption.ISNOTEMPTY.equals(queryMap.queryOption)) {// null empty
            method = Restrictions.class.getMethod(queryMap.queryOption.getOption(), String.class);
        } else if (Prompt.QueryOption.AND.equals(queryMap.queryOption) || Prompt.QueryOption.OR.equals(queryMap.queryOption)) {//and or
            boolean isCollection = Collection.class.isAssignableFrom(queryMap.value.getClass());
            boolean isArray = queryMap.value.getClass().isArray();
            if (isCollection || isArray) {
                List<Criterion> criterions = new ArrayList<Criterion>();
                if (isCollection) {
                    for (Object o : (Collection) queryMap.value) {
                        if (Pager.QueryMap.class.equals(o.getClass())) {
                            Criterion c = createCriterion((Pager.QueryMap) o);
                            if (c != null) criterions.add(c);
                        }
                    }
                } else {
                    for (Object o : (Object[]) queryMap.value) {
                        if (Pager.QueryMap.class.equals(o.getClass())) {
                            Criterion c = createCriterion((Pager.QueryMap) o);
                            if (c != null) criterions.add(c);
                        }
                    }
                }
                method = Restrictions.class.getMethod(queryMap.queryOption.getOption(), Criterion.class, Criterion.class);
                if (method == null) {
                    return null;
                }
                Criterion criterionTotle = null;
                for (Criterion criterion : criterions) {
                    if (criterionTotle == null) {
                        criterionTotle = criterion;
                    } else {
                        criterionTotle = (Criterion) method.invoke(null, criterionTotle, criterion);
                    }
                }
                return criterionTotle;
            } else {
                throw new Exception("parameter can not match '" + queryMap.queryOption.getOption() + "' to " + queryMap.value.getClass());
            }

        } else {
            method = Restrictions.class.getMethod(queryMap.queryOption.getOption(), String.class, Object.class);
        }

        return method == null ? null : (Criterion) method.invoke(null, queryMap.columnName, queryMap.value);
    }
    @Transactional
    public T findCascadeById(Integer id) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("id", id));
        return getDao().findCascade(criterions, Order.asc("id")).get(0);
    }
}
