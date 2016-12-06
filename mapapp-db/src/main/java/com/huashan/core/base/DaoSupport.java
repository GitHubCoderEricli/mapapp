package com.huashan.core.base;


import com.huashan.core.annotation.CoocaaCascade;
import com.huashan.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BasicType;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

/**
 * 功能描述：数据库操作基础实现
 *
 * @param <T>
 */
@Transactional
public abstract class DaoSupport<T extends AbstractItem> implements Dao<T>, Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -7815256706084508119L;

    protected final Log logger = LogFactory.getLog(getClass());

    private static Order DEFAULTORDER = Order.desc("id");


//    private HibernateTemplate hibernateTemplate;
//
//    @Resource
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    public HibernateTemplate getHibernateTemplate() {
//        return hibernateTemplate;
//    }
//
    private SessionFactory sessionFactory;

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    private Class<T> getBeanClass() {
        return (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

//    /**
//     * 获取hibernate操作模板
//     *
//     * @return
//     */
//    public HibernateTemplate d() {
//        return getHibernateTemplate();
//    }

    /**
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
//        d().delete(find(id));
        getSession().delete(find(id));
        return true;
    }

    /**
     * @param ids
     * @return
     */

    public boolean delete(final Integer[] ids) {
//        return d().execute(new HibernateCallback<Boolean>() {
//            @Override
//            public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
//                StringBuilder idStr = new StringBuilder();
//                for (Integer id : ids) {
//                    idStr.append(",").append(id);
//                }
//                String fieldName = null;
//                Field[] fields = getBeanClass().getDeclaredFields();
//                for (Field field : fields) {
//                    if (field.getAnnotation(Id.class) != null) {//找到主键字段
//                        fieldName = field.getName();
//                        break;
//                    }
//                }
//                Query query = session.createQuery("delete from " + getBeanClass().getSimpleName() + " where " + fieldName + " in (" + idStr.substring(1) + ")");
//                return query.executeUpdate() > 0;
//            }
//        });
        StringBuffer idStr = new StringBuffer();
        for (Integer id:ids) {
            idStr.append(",").append(id);
        }
        String fieldName = null;
        Field[] fields = getBeanClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.getAnnotation(Id.class) != null) {
                fieldName = field.getName();
                break;
            }
        }
        Query query = getSession().createQuery("delete from " + getBeanClass().getSimpleName() + " where " + fieldName + " in (" + idStr.substring(1) + ")");
        return query.executeUpdate() > 0;
    }

    /**
     * 删除
     *
     * @param t
     * @return
     */
    public boolean delete(T t) {
        getSession().delete(t);
        return true;
    }

    /**
     * 添加和修改
     *
     * @param t
     */
    public boolean saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
        return true;
    }

    /**
     * 使用id查找有延迟加载的数据
     *
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
//    public T load(final Integer id) {
//        return d().executeWithNativeSession(new HibernateCallback<T>() {
//            public T doInHibernate(Session session) throws HibernateException {
//                Field[] fs = ClassUtil.getFields(getBeanClass());
//                Criteria criteria = session.createCriteria(getBeanClass());
//                criteria.add(Restrictions.eq("id", id));
//                int listSize = 0;
//                for (Field f : fs) {
//                    if (Collection.class.isAssignableFrom(f.getType())) {
//                        criteria.setFetchMode(f.getName(), FetchMode.JOIN);
//                        listSize++;
//                    }
//                }
//                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//
//                //有BUG,当一个实体有两个List属性就会查询有问题,所以查询如果有多个list则使用下面这种方式
//                if (listSize > 1) {
//                    T t = (T) session.load(getBeanClass(), id);
//                    Method[] methods = ClassUtil.getMethodByStart(t, "get"); // 获取所有的get参数调用一次,达到延迟加载的效果
//                    for (Method m : methods) {
//                        try {
//                            Object obj = ClassUtil.invokeMethod(t, m);
//                            if (!ObjectUtil.isEmpty(obj)) {
//                                if (obj instanceof Collection) {
//                                    CollectionsUtil.isEmpty(((Collection<T>) obj));
//                                } else {
//                                    obj.equals(null); // 调用一个方法 , 达�郊釉氐男Ч�
//                                }
//                            }
//                        } catch (Exception e) {
//                            logger.error(e);
//                        }
//                    }
//                    return t;
//                }
//                return (T) criteria.uniqueResult();
//            }
//        });
//
//    }

    /**
     * 使用id查找有延迟加载的数据
     *
     * @param orders
     * @return
     */
//    @SuppressWarnings("unchecked")
//    public List<T> loadAll(final Order... orders) {
//        return d().executeWithNativeSession(new HibernateCallback<List<T>>() {
//            public List<T> doInHibernate(Session session) throws HibernateException {
//                Field[] fs = ClassUtil.getFields(getBeanClass());
//                Criteria criteria = session.createCriteria(getBeanClass());
//                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//                for (Field f : fs) {
//                    if (Collection.class.isAssignableFrom(f.getType())) {
//                        criteria.setFetchMode(f.getName(), FetchMode.JOIN);
//                    }
//                }
//                if (ObjectUtil.isNotEmpty(orders)) {
//                    for (Order order : orders) {
//                        criteria.addOrder(order);
//                    }
//                } else {
//                    criteria.addOrder(DEFAULTORDER);
//                }
//                return (List<T>) criteria.list();
//            }
//        });
//    }

    /**
     * 使用id查找
     *
     * @param id
     * @return
     */
    public T find(Integer id) {
//        return d().get(getBeanClass(), id);
        return (T) getSession().get(getBeanClass(), id);
    }

//    /**
//     * 使用pager查询
//     *
//     * @param pager
//     * @return
//     */
//    public List<T> load(Pager pager) {
//        return load(pager, DEFAULTORDER);
//    }

//    /**
//     * 使用pager查询,并包含query参数
//     *
//     * @param pager
//     * @param queryMap
//     * @return
//     */
//    public List<T> load(Pager pager, Map<String, Object> queryMap) {
//        return find(pager, queryMap, DEFAULTORDER);
//    }


//    /**
//     * 使用pager查询
//     *
//     * @param pager
//     * @return
//     */
//    public List<T> load(Pager pager, Order... order) {
//        return load(pager, new HashMap<String, Object>(), order);
//    }

    /**
     * 使用pager查询,并包含query参数
     *
     * @param pager
     * @param queryMap
     * @param order
     * @return
     */
    public List<T> load(Pager pager, Map<String, Object> queryMap, Order... order) {
        Criterion[] criteriones = null;

        if (!CollectionsUtil.isEmpty(queryMap)) {
            criteriones = new Criterion[queryMap.size()];
            Iterator<Entry<String, Object>> iterator = queryMap.entrySet()
                    .iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                criteriones[i++] = Restrictions.eq(entry.getKey(), entry
                        .getValue());
            }
        }

        return load(pager, criteriones, order);
    }

    /**
     * 使用where查询
     *
     * @param criteriones
     * @param orders
     * @return
     */
    public List<T> load(final Criterion[] criteriones, final Order... orders) {
        return load(null, criteriones, orders);
    }

    /**
     * 使用where查询
     *
     * @param criterion
     * @param orders
     * @return
     */
    public List<T> load(final Criterion criterion, final Order... orders) {
        return load(new Criterion[]{criterion}, orders);
    }

    /**
     * 使用where查询
     *
     * @param criterion
     * @return
     */
    public List<T> load(final Criterion criterion) {
        return load(criterion, DEFAULTORDER);
    }


    /**
     * 使用pager查询,并包含子查询对象和参数
     *
     * @param pager
     * @param criteriones
     * @param orders
     * @return
     */
    public List<T> load(final Pager pager, final Criterion[] criteriones, final Order... orders) {
        return find(pager, criteriones, true, orders);
    }

    /**
     * 使用pager查询,并包含子查询对象和参数
     *
     * @param pager
     * @param criterion
     * @param orders
     * @return
     */
    public List<T> load(final Pager pager, final Criterion criterion, final Order... orders) {
        return load(pager, new Criterion[]{criterion}, orders);
    }


    /**
     * 使用pager查询
     *
     * @param pager
     * @return
     */
    public List<T> find(Pager pager) {
        return find(pager, DEFAULTORDER);
    }

    /**
     * 使用pager查询
     *
     * @param pager
     * @return
     */
    public List<T> find(Pager pager, Order... order) {
        return find(pager, new HashMap<String, Object>(), order);
    }

    public List<T> find(Pager pager, Map<String, Object> values) {
        return find(pager, values, DEFAULTORDER);
    }

    /**
     * 使用pager查询,并包含query参数,和排序字段
     *
     * @param pager
     * @param values
     * @param order
     * @returnd
     */
    public List<T> find(Pager pager, Map<String, Object> values, Order... order) {
        Criterion[] criteriones = null;
        if (!CollectionsUtil.isEmpty(values)) {
            criteriones = new Criterion[values.size()];
            Iterator<Entry<String, Object>> iterator = values.entrySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                criteriones[i++] = Restrictions.eq(entry.getKey(), entry
                        .getValue());
            }
        } else {
            criteriones = new Criterion[0];
        }

        return find(pager, criteriones, order);
    }

    /**
     * 使用排序
     *
     * @param orders 排序
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(final Order... orders) {
//        return (List<T>) d().executeFind(new HibernateCallback<Object>() {
//            public Object doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                final Criteria criteria = session.createCriteria(getBeanClass());
//                if (ObjectUtil.isNotEmpty(orders)) {
//                    for (Order order : orders) {
//                        criteria.addOrder(order);
//                    }
//                } else {
//                    criteria.addOrder(DEFAULTORDER);
//                }
//                return criteria.list();
//            }
//        });
        Session session = getSession();
        final Criteria criteria = getSession().createCriteria(getBeanClass());
        if (ObjectUtil.isNotEmpty(orders)) {
            for (Order order:orders) {
                criteria.addOrder(order);
            }
        }else {
            criteria.addOrder(DEFAULTORDER);
        }
        List list = criteria.list();
        return (List<T>) criteria.list();
    }

    /**
     * 按关系查询
     *
     * @param criteriones
     * @param orders
     * @return
     */
    public List<T> find(final Criterion[] criteriones, final Order... orders) {
        return find(null, criteriones, orders);
    }

    /**
     * 按关系查询
     *
     * @param criterion
     * @param orders
     * @return
     */
    public List<T> find(final Criterion criterion, final Order... orders) {
        return find(new Criterion[]{criterion}, orders);
    }

    /**
     * 按关系查询
     *
     * @param criterion
     * @return
     */
    public List<T> find(final Criterion criterion) {
        return find(new Criterion[]{criterion}, DEFAULTORDER);
    }

    /**
     * 按关系查找
     *
     * @param pager
     * @param criterion
     * @param orders
     * @return
     */
    public List<T> find(final Pager pager, final Criterion criterion,
                        final Order... orders) {
        return find(pager, new Criterion[]{criterion}, orders);
    }

    public List<T> find(final Pager pager, final Criterion[] criteriones,
                        final Order... orders) {
        return find(pager, criteriones, false, orders);
    }

    private List<T> find(final Pager pager, final Criterion[] criteriones, final boolean loadSubClass,
                         final Order... orders) {
        List<Criterion> list = new ArrayList<Criterion>();
        for (Criterion criterion : criteriones) {
            list.add(criterion);
        }
        return find(pager, list, loadSubClass, orders);
    }

    /**
     * 使用pager查询,并包含子查询对象和参数
     */
    @SuppressWarnings("unchecked")
    private List<T> find(final Pager pager, final Collection<Criterion> criteriones, final boolean loadSubClass,
                         final Order... orders) {
        if (ObjectUtil.isNotEmpty(pager)) {
            pager.setTotalNum(getTotal(criteriones));
            if (pager.getTotalNum() == 0)
                return new ArrayList<T>();
        }
//        return (List<T>) d().executeFind(new HibernateCallback<List<T>>() {
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
                final Criteria criteria = getSession().createCriteria(getBeanClass());
                boolean hasPager = false;
                if (ObjectUtil.isNotEmpty(pager)
                        && (pager.getTotalNum() > pager.getPageSize()
                        || pager.getPage() == 1)) {
                    criteria.setFirstResult(pager.getFirstRow());
                    criteria.setMaxResults(pager.getPageSize());
                    hasPager = true;
                }
                if (ObjectUtil.isNotEmpty(criteriones)) {
                    for (Criterion criterion : criteriones) {
                        criteria.add(criterion);
                    }
                }
                if (ObjectUtil.isNotEmpty(orders)
                        && CollectionsUtil.notEmpty(orders)) {
                    for (Order order : orders) {
                        criteria.addOrder(order);
                    }
                } else {
                    criteria.addOrder(DEFAULTORDER);
                }

                if (loadSubClass && !hasPager) {
                    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                    Field[] fs = ClassUtil.getFields(getBeanClass());
                    for (Field f : fs) {
                        if (Collection.class.isAssignableFrom(f.getType())) {
                            criteria.setFetchMode(f.getName(), FetchMode.JOIN);
                        }
                    }
                    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                } else if (loadSubClass) {
                    criteria.setProjection(Projections.property("id"));
                    List<T> ids = criteria.list();

                    //editor by jiushixuefeng 20120410
                    Criteria newCriteria = getSession().createCriteria(getBeanClass());
                    newCriteria.add(Restrictions.in("id", ids));

                    Field[] fs = ClassUtil.getFields(getBeanClass());
                    for (Field f : fs) {
                        if (Collection.class.isAssignableFrom(f.getType())) {
                            newCriteria.setFetchMode(f.getName(), FetchMode.JOIN);
                        }
                    }
                    if (ObjectUtil.isNotEmpty(orders)
                            && CollectionsUtil.notEmpty(orders)) {
                        for (Order order : orders) {
                            newCriteria.addOrder(order);
                        }
                    } else {
                        newCriteria.addOrder(DEFAULTORDER);
                    }
                    newCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                    return newCriteria.list();
                }
                return (List<T>) criteria.list();
//            }
//        });
    }

    public int getTotal(final Criterion... criteriones) {
        List<Criterion> list = new ArrayList<Criterion>();
        for (Criterion criterion : criteriones) {
            list.add(criterion);
        }
        return getTotal(list);
    }

    /**
     * 使用条件查找,返回总数
     *
     * @param criteriones
     * @return
     */
    public int getTotal(final Collection<Criterion> criteriones) {
//        List<?> l = d().executeFind(new HibernateCallback<Object>() {
//            public List<?> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//
//                final Criteria criteria = session
//                        .createCriteria(getBeanClass());
//
//                if (criteriones != null) {
//                    for (Criterion criterion : criteriones) {
//                        criteria.add(criterion);
//                    }
//                }
//
//                criteria.setProjection(Projections.rowCount());
//                return criteria.list();
//            }
//        });
        final Criteria criteria = getSession().createCriteria(getBeanClass());
        if (criteriones != null) {
            for (Criterion criterion:criteriones) {
                criteria.add(criterion);
            }
        }
        criteria.setProjection(Projections.rowCount());
        List<?> l = criteria.list();
        return ((Long) l.get(0)).intValue();
    }

    /**
     * 使用实体查找,返回总数
     *
     * @param t
     * @return
     */
    public int getTotal(final T t) {

//        List<?> l = d().executeFind(new HibernateCallback<Object>() {
//
//            public List<?> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//
//                final Criteria criteria = session
//                        .createCriteria(getBeanClass());
//
//                Example example = Example.create(t).enableLike().excludeNone()
//                        .excludeZeroes().ignoreCase();
//                criteria.add(example);
//
//                criteria.setProjection(Projections.rowCount());
//                return criteria.list();
//            }
//        });
//        return ((Long) l.get(0)).intValue();

        final Criteria criteria = getSession().createCriteria(getBeanClass());
        Example example = Example.create(t).enableLike().excludeNone().excludeZeroes().ignoreCase();
        criteria.add(example);
        criteria.setProjection(Projections.rowCount());
        return ((Long) criteria.list().get(0)).intValue();
    }

    /**
     * 使用实体查找,屏蔽null
     *
     * @param t
     * @return
     */
    public List<T> findByItem(T t) {
        return findByItem(null, t);
    }

    /**
     * 使用实体查找,屏蔽null
     *
     * @param pager
     * @param t
     * @return
     */
    public List<T> findByItem(Pager pager, T t) {
        return findByItem(pager, t, DEFAULTORDER);
    }

    /**
     * 使用实体查找,屏蔽null
     *
     * @param t
     * @param orders
     * @return
     */
    public List<T> findByItem(T t, Order... orders) {
        return findByItem(null, t, orders);
    }

    /**
     * 使用实体查找,屏蔽null
     * @param pager
     * @param t
     * @param orders
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findByItem(final Pager pager, final T t,
                              final Order... orders) {
        if (ObjectUtil.isNotEmpty(pager)) {
            pager.setTotalNum(getTotal(t));
        }
//        return d().execute(new HibernateCallback<List<T>>() {
//
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                final Criteria criteria = session
//                        .createCriteria(getBeanClass());
//                if (ObjectUtil.isNotEmpty(pager)) {
//                    criteria.setFirstResult(pager.getFirstRow());
//                    criteria.setMaxResults(pager.getPageSize());
//                }
//                // example 只能用and
//                Example example = Example.create(t).enableLike().ignoreCase();
//                criteria.add(example);
//
//                if (ObjectUtil.isNotEmpty(orders)) {
//                    for (Order order : orders) {
//                        criteria.addOrder(order);
//                    }
//                } else {
//                    criteria.addOrder(Order.desc("id"));
//                }
//                return criteria.list();
//            }
//        });

        final Criteria criteria = getSession().createCriteria(getBeanClass());
        if (ObjectUtil.isNotEmpty(pager)) {
            criteria.setFirstResult(pager.getFirstRow());
            criteria.setMaxResults(pager.getPageSize());
        }
        Example example = Example.create(t).enableLike().ignoreCase();
        criteria.add(example);
        if (ObjectUtil.isNotEmpty(orders)) {
            for (Order order:orders) {
                criteria.addOrder(order);
            }
        }else {
            criteria.addOrder(Order.desc("id"));
        }
        return criteria.list();
    }

    /**
     * 按分页和hql 查询数据
     *
     * @param pager
     * @param hql
     * @return
     */
    public List<T> findByHql(final Pager pager, final String hql) {
        return findByHql(pager, hql, null);
    }

    /**
     * 按 hql 查询数据
     *
     * @param hql
     * @return
     */
    public List<T> findByHql(final String hql) {
        return findByHql(null, hql, null);
    }

    /**
     * 按分页和hql 和条件查询数据
     *
     * @param pager
     * @param hql
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<T> findByHql(final Pager pager, final String hql,
                             final List<?> param) {
//        return (List<T>) d().executeFind(new HibernateCallback<List<T>>() {
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                Query query = session.createQuery(hql);
//                if (pager != null) {
//                    query.setFirstResult(pager.getFirstRow());
//                    query.setMaxResults(pager.getPageSize());
//                    pager.setTotalNum(getTotal(hql, param));
//                }
//                if (!CollectionsUtil.isEmpty(param)) {
//                    int size = param.size();
//                    for (int i = 0; i < size; i++) {
//                        query.setParameter(i, param.get(i));
//                    }
//                }
//                return query.list();
//            }
//        });
        Query query = getSession().createQuery(hql);
        if (pager != null) {
            query.setFirstResult(pager.getFirstRow());
            query.setMaxResults(pager.getPageSize());
            pager.setTotalNum(getTotal(hql, param));
        }
        if (!CollectionsUtil.isEmpty(param)) {
            int size = param.size();
            for (int i = 0; i < size; i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return (List<T>) query.list();
    }

    /**
     * 按hql查询总数
     *
     * @param hql
     * @return
     */
    public int getTotal(final String hql) {
        return getTotal(hql, null);
    }

    /**
     * 按hql和条件查询总数
     *
     * @param hql
     * @return
     */
    public int getTotal(final String hql, final List<?> param) {
//        return d().execute(new HibernateCallback<Integer>() {
//            public Integer doInHibernate(Session session)
//                    throws HibernateException, SQLException {
//
//                String realHql = "";
//                String lowerHql = hql.toLowerCase().trim();
//                if (lowerHql.startsWith("select")) {
//                    if (hql.indexOf("from") > -1) {
//                        realHql = hql.substring(hql.indexOf("from"));
//                    } else {
//                        realHql = hql.substring(hql.indexOf("From"));
//                    }
//                } else {
//                    realHql = hql;
//                }
//                if (lowerHql.lastIndexOf("group by") > -1) {
//                    int gi = hql.lastIndexOf("group by ");
//                    int space = hql.indexOf(' ', gi + 9);
//                    String column = "";
//                    if (space > -1) {
//                        column = hql.substring(gi + 8, space);
//                    } else {
//                        column = hql.substring(gi + 8);
//                    }
//                    realHql = " select count(distinct " + column + ") " + realHql.substring(0, realHql.lastIndexOf("group by"));
//                } else {
//                    realHql = " select count( * ) " + realHql;
//                }
////				int joinIndex = -1;
////		    	if(realHql.indexOf("insert join")>-1)
////		    		joinIndex=realHql.indexOf("insert");
////		    	else if(realHql.indexOf("left join")>-1)
////		    		joinIndex=realHql.indexOf("left join");
////		    	else if(realHql.indexOf("right join")>-1)
////		    		joinIndex=realHql.indexOf("right join");
////		    	int whereIndex = realHql.indexOf("where");
////		    	if(joinIndex>-1&&whereIndex>-1){
////		    		//做了个简单的 处理 需要补充啊//TODO
////		    		realHql = realHql.replace(realHql.subSequence(joinIndex,whereIndex), "");
////		    	}
//                Query query = session.createQuery(realHql);
//                if (!CollectionsUtil.isEmpty(param)) {
//                    int size = param.size();
//                    for (int i = 0; i < size; i++) {
//                        query.setParameter(i, param.get(i));
//                    }
//                }
//                return ((Long) query.uniqueResult()).intValue();
////				ScrollableResults scrollableResults = query
////						.scroll(ScrollMode.SCROLL_SENSITIVE);
////				scrollableResults.last();
////				int total = scrollableResults.getRowNumber() + 1;
////				scrollableResults.close();
////				return total;
//            }
//        });

        String realHql = "";
        String lowerHql = hql.toLowerCase().trim();
        if (lowerHql.startsWith("select")) {
            if (hql.indexOf("from") > -1) {
                realHql = hql.substring(hql.indexOf("from"));
            } else {
                realHql = hql.substring(hql.indexOf("From"));
            }
        } else {
            realHql = hql;
        }
        if (lowerHql.lastIndexOf("group by") > -1) {
            int gi = hql.lastIndexOf("group by ");
            int space = hql.indexOf(' ', gi + 9);
            String column = "";
            if (space > -1) {
                column = hql.substring(gi + 8, space);
            } else {
                column = hql.substring(gi + 8);
            }
            realHql = " select count(distinct " + column + ") " + realHql.substring(0, realHql.lastIndexOf("group by"));
        } else {
            realHql = " select count( * ) " + realHql;
        }
        Query query = getSession().createQuery(realHql);
        if (!CollectionsUtil.isEmpty(param)) {
            int size = param.size();
            for (int i = 0; i < size; i++) {
                query.setParameter(i, param.get(i));
            }
        }
        return ((Long) query.uniqueResult()).intValue();
    }

    /**
     * 按分页和sql 和条件查询数据
     * @param pager
     * @param sql
     * @param scalars 返回数据类型
     * @return
     */
    public List<T> findBySql(final Pager pager, final String sql,
                             final Pair<String, BasicType>... scalars) {
//        return d().execute(new HibernateCallback<List<T>>() {
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                SQLQuery query = session.createSQLQuery(sql);
//                if (CollectionsUtil.notEmpty(scalars)) {
//                    for (Pair<String, BasicType> scalar : scalars) {
//                        query.addScalar(scalar.getFirst(), scalar.getSecond());
//                    }
//                }
//                if (ObjectUtil.isNotEmpty(pager)) {
//                    query.setFirstResult(pager.getFirstRow());
//                    query.setMaxResults(pager.getPageSize());
//                    pager.setTotalNum(getTotalBySql(sql));
//                }
//                return query.list();
//            }
//        });

        SQLQuery query = getSession().createSQLQuery(sql);
        if (CollectionsUtil.notEmpty(scalars)) {
            for (Pair<String, BasicType> scalar : scalars) {
                query.addScalar(scalar.getFirst(), scalar.getSecond());
            }
        }
        if (ObjectUtil.isNotEmpty(pager)) {
            query.setFirstResult(pager.getFirstRow());
            query.setMaxResults(pager.getPageSize());
            pager.setTotalNum(getTotalBySql(sql));
        }
        return (List<T>) query.list();
    }
    /**
     * 返回map-拼sql的  建议使用参数 CSJ
     * @param pager
     * @param sql
     * @param scalars 明确字段的返回值
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<?> findBySqlmap(final Pager pager, final String sql,
                                final Pair<String, BasicType>... scalars) {
//        return d().executeFind(new HibernateCallback<List<T>>() {
//            @Override
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                SQLQuery query = session.createSQLQuery(sql);
//                query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//                if (CollectionsUtil.notEmpty(scalars)) {
//                    for (Pair<String, BasicType> scalar : scalars) {
//                        query.addScalar(scalar.getFirst(), scalar.getSecond());
//                    }
//                }
//                if (ObjectUtil.isNotEmpty(pager)
//                        && !NumberUtil.equals(Integer.MAX_VALUE,
//                        pager.getPageSize())) {
//                    query.setFirstResult(pager.getFirstRow());
//                    query.setMaxResults(pager.getPageSize());
//                    pager.setTotalNum(getTotalBySql(sql));
//                }
//                return query.list();
//            }
//        });
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (CollectionsUtil.notEmpty(scalars)) {
            for (Pair<String, BasicType> scalar : scalars) {
                query.addScalar(scalar.getFirst(), scalar.getSecond());
            }
        }
        if (ObjectUtil.isNotEmpty(pager)
                && !NumberUtil.equals(Integer.MAX_VALUE,
                pager.getPageSize())) {
            query.setFirstResult(pager.getFirstRow());
            query.setMaxResults(pager.getPageSize());
            pager.setTotalNum(getTotalBySql(sql));
        }
        return (List<T>) query.list();
    }
    /**
     * 返回map- 使用参数 CSJ
     * @param pager
     * @param sql
     * @param parameters 参数化的字段及值，如goods_id=:goodsId，则需要传入goodsId=300
     * @param scalars 明确字段的返回值
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<?> findBySqlMapParameters(final Pager pager, final String sql,final Map<String, Object> parameters,
                                final Pair<String, BasicType>... scalars) {
//        return d().executeFind(new HibernateCallback<List<T>>() {
//            @Override
//            public List<T> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                SQLQuery query = session.createSQLQuery(sql);
//                if (!CollectionsUtil.isEmpty(parameters)) {
//                    Iterator<Entry<String, Object>> iterator = parameters.entrySet().iterator();
//                    int i = 0;
//                    while (iterator.hasNext()) {
//                        Entry<String, Object> entry = iterator.next();
//                        query.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
//                    }
//                }
//                query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//                if (CollectionsUtil.notEmpty(scalars)) {
//                    for (Pair<String, BasicType> scalar : scalars) {
//                        query.addScalar(scalar.getFirst(), scalar.getSecond());
//                    }
//                }
//                if (ObjectUtil.isNotEmpty(pager)
//                        && !NumberUtil.equals(Integer.MAX_VALUE,
//                        pager.getPageSize())) {
//                    query.setFirstResult(pager.getFirstRow());
//                    query.setMaxResults(pager.getPageSize());
//                    pager.setTotalNum(getTotalBySqlMapParameters(sql,parameters));
//                }
//                return query.list();
//            }
//        });


        SQLQuery query = getSession().createSQLQuery(sql);
        if (!CollectionsUtil.isEmpty(parameters)) {
            Iterator<Entry<String, Object>> iterator = parameters.entrySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                query.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        if (CollectionsUtil.notEmpty(scalars)) {
            for (Pair<String, BasicType> scalar : scalars) {
                query.addScalar(scalar.getFirst(), scalar.getSecond());
            }
        }
        if (ObjectUtil.isNotEmpty(pager)
                && !NumberUtil.equals(Integer.MAX_VALUE,
                pager.getPageSize())) {
            query.setFirstResult(pager.getFirstRow());
            query.setMaxResults(pager.getPageSize());
            pager.setTotalNum(getTotalBySqlMapParameters(sql,parameters));
        }
        return (List<T>) query.list();
    }
    /**
     * 按sql和条件查询总数  使用参数 CSJ
     *
     * @param sql
     * @return
     */
    public int getTotalBySqlMapParameters(final String sql,final Map<String, Object> parameters) {
//        return d().execute(new HibernateCallback<Integer>() {
//            public Integer doInHibernate(Session session)
//                    throws HibernateException, SQLException {
//                Query query = session.createSQLQuery(sql);
//                if (!CollectionsUtil.isEmpty(parameters)) {
//                    Iterator<Entry<String, Object>> iterator = parameters.entrySet().iterator();
//                    int i = 0;
//                    while (iterator.hasNext()) {
//                        Entry<String, Object> entry = iterator.next();
//                        query.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
//                    }
//                }
//                ScrollableResults scrollableResults = query
//                        .scroll(ScrollMode.SCROLL_SENSITIVE);
//                scrollableResults.last();
//                return scrollableResults.getRowNumber() + 1;
//            }
//        });


        Query query = getSession().createSQLQuery(sql);
        if (!CollectionsUtil.isEmpty(parameters)) {
            Iterator<Entry<String, Object>> iterator = parameters.entrySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                query.setParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        ScrollableResults scrollableResults = query
                .scroll(ScrollMode.SCROLL_SENSITIVE);
        scrollableResults.last();
        return scrollableResults.getRowNumber() + 1;
    }
    /**
     * 按sql和条件查询总数
     *
     * @param sql
     * @return
     */
    public int getTotalBySql(final String sql) {
//        return d().execute(new HibernateCallback<Integer>() {
//            public Integer doInHibernate(Session session)
//                    throws HibernateException, SQLException {
//                Query query = session.createSQLQuery(sql);
//                ScrollableResults scrollableResults = query
//                        .scroll(ScrollMode.SCROLL_SENSITIVE);
//                scrollableResults.last();
//                return scrollableResults.getRowNumber() + 1;
//            }
//        });
        Query query = getSession().createSQLQuery(sql);
        ScrollableResults scrollableResults = query
                .scroll(ScrollMode.SCROLL_SENSITIVE);
        scrollableResults.last();
        return scrollableResults.getRowNumber() + 1;
    }

    /**
     * 按class查询
     *
     * @param clazz
     * @param criteriones
     * @return
     */
    public List<?> findByClazz(final Class<?> clazz,
                               final Criterion... criteriones) {
//        return d().executeFind(new HibernateCallback<List<?>>() {
//            public List<?> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                final Criteria criteria = session.createCriteria(clazz);
//                if (ObjectUtil.isNotEmpty(criteriones)) {
//                    for (final Criterion criterion : criteriones) {
//                        criteria.add(criterion);
//                    }
//                }
//                return criteria.list();
//            }
//        });

        final Criteria criteria = getSession().createCriteria(clazz);
        if (ObjectUtil.isNotEmpty(criteriones)) {
            for (final Criterion criterion : criteriones) {
                criteria.add(criterion);
            }
        }
        return (List<?>) criteria.list();
    }

    /**
     * 删除本实体中的其他实体
     *
     * @param obj
     * @return
     */
    public boolean deleteOtherObj(Object obj) {
//        d().delete(obj);
        getSession().delete(obj);
        return true;
    }

    public List<T> fetchCascade(List<T> list) throws SQLException {
        return fetchCascade(list, null);
    }

    public List<T> fetchCascade(List<T> list, Map<String, SubSelectParam> criteriAsMap) throws SQLException {
        List<AliasBean> aliasBeanList = getAliasBeanList();
        return setCascadeData(list, criteriAsMap, aliasBeanList);
    }

    public List<T> findCascade(List<Criterion> criteriones, Order... orders) {
        return findCascade(null, criteriones, null, orders);
    }

    @SuppressWarnings("unchecked")
    public List<T> findCascade(final Pager pager, final List<Criterion> criteriones,
                        final Map<String, SubSelectParam> criteriAsMap,
                        final Order... orders) {
        if (ObjectUtil.isNotEmpty(pager)) {
            pager.setTotalNum(getTotal(criteriones));
            if (pager.getTotalNum() == 0)
                return new ArrayList<T>();
        }
//        return d().execute(new HibernateCallback<List<T>>() {
//            @Override
//            public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
//                final Criteria criteria = session.createCriteria(getBeanClass());
//                if (pager != null && (pager.getTotalNum() > pager.getPageSize() || pager.getPage() == 1)) {
//                    criteria.setFirstResult(pager.getFirstRow());
//                    criteria.setMaxResults(pager.getPageSize());
//                }
//                if (criteriones != null) {
//                    for (Criterion criterion : criteriones) {
//                        criteria.add(criterion);
//                    }
//                }
//
//                if (orders != null) {
//                    for (Order order : orders) {
//                        criteria.addOrder(order);
//                    }
//                } else {
//                    criteria.addOrder(DEFAULTORDER);
//                }
//
//                List<AliasBean> aliasBeanList = getAliasBeanList();
//                List<T> list = criteria.list();
//
//                return setCascadeData(list, criteriAsMap, aliasBeanList);
//            }
//        });


        final Criteria criteria = getSession().createCriteria(getBeanClass());
        if (pager != null && (pager.getTotalNum() > pager.getPageSize() || pager.getPage() == 1)) {
            criteria.setFirstResult(pager.getFirstRow());
            criteria.setMaxResults(pager.getPageSize());
        }
        if (criteriones != null) {
            for (Criterion criterion : criteriones) {
                criteria.add(criterion);
            }
        }

        if (orders != null) {
            for (Order order : orders) {
                criteria.addOrder(order);
            }
        } else {
            criteria.addOrder(DEFAULTORDER);
        }

        List<AliasBean> aliasBeanList = null;
        try {
            aliasBeanList = getAliasBeanList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<T> list = criteria.list();

        try {
            list =  setCascadeData(list, criteriAsMap, aliasBeanList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 将级联出的信息放入实体类
     * @param list 需要级联的list
     * @param criteriAsMap 级联查询条件map
     * @param aliasBeanList 级联信息
     * @return 存入数据之后的list
     * @throws SQLException
     */
    private List<T> setCascadeData(List<T> list, Map<String, SubSelectParam> criteriAsMap, List<AliasBean> aliasBeanList) throws SQLException {
        if (criteriAsMap == null) criteriAsMap = new HashMap<String, SubSelectParam>();
        for (T t : list) {
            for (AliasBean aliasBean : aliasBeanList) {
                Dao dao = aliasBean.getDao();
                Field field = aliasBean.getField();
                String joinColumnName = aliasBean.getCoocaaCascade().jionColunm();
                String targetColumnName = aliasBean.getCoocaaCascade().targetColumn();

                Object joinColumn = null;

                try {
                    joinColumn = getBeanClass().getMethod("get" + StringUtils.toUpCaseFirstChar(joinColumnName)).invoke(t);
                } catch (IllegalAccessException e) {
                    throw new SQLException(e);
                } catch (InvocationTargetException e) {
                    throw new SQLException(e);
                } catch (NoSuchMethodException e) {
                    throw new SQLException(e);
                }

                Method setter = aliasBean.getMethodSet();
                SubSelectParam subSelectParam = criteriAsMap.get(field.getName());
                if (subSelectParam == null) subSelectParam = new SubSelectParam();
                subSelectParam.putCriterion(Restrictions.eq(targetColumnName, joinColumn));//级联方法的条件

                if (!"id".equals(targetColumnName)) {//targetColumnName不是ID的时候
                    try {
                        Object obj = invokeMethodByParameter(dao, subSelectParam, targetColumnName);
                        if (ObjectUtil.equals(obj.getClass(), field.getType())) {//如果返回的是List or Set的时候
                            setter.invoke(t, obj);
                        } else {
                            throw new SQLException(dao.getClass().getName() + ".findBy" + StringUtils.toUpCaseFirstChar(joinColumnName) + "'s return type is not correct. Must be " + field.getType() + ".");
                        }
                    } catch (Exception e) {
                        throw new SQLException(e);
                    }
                } else {//targetColumnName是ID的时候
                    try {
                        Method cascadeFieldGetMethod = getBeanClass().getMethod("get" + StringUtils.toUpCaseFirstChar(joinColumnName));
                        Integer columnVal = (Integer) cascadeFieldGetMethod.invoke(t);
                        setter.invoke(t, dao.find(columnVal));
                    } catch (NoSuchMethodException e) {
                        throw new SQLException(getBeanClass().getName() + "." + joinColumnName + "'s getter is not found", e);
                    } catch (InvocationTargetException e) {
                        throw new SQLException(e);
                    } catch (IllegalAccessException e) {
                        throw new SQLException(e);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 根据方法参数名注入参数执行
     * @param dao
     * @param subSelectParam
     * @param targetColumnName
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object invokeMethodByParameter(Dao dao, SubSelectParam subSelectParam, String targetColumnName) throws Exception {
        //获取dao的非代理class，用这个class获得参数名parameters
        Class<?> cleanDaoClass = ClassUtil.getTarget(dao).getClass();
        String findByStr = "findBy" + StringUtils.toUpCaseFirstChar(targetColumnName);
        Method methodFindBy = ClassUtil.getMethod(cleanDaoClass, findByStr);
        if (methodFindBy == null) throw new SQLException(cleanDaoClass + "." + findByStr + " is not exists, please create it.");

        String[] parameters = ClassUtil.getParameterNames(methodFindBy);
        Class<?>[] classes = methodFindBy.getParameterTypes();
        Object[] objects = new Object[parameters == null ? 0 : parameters.length];
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                if ("subSelectParam".equals(parameters[i]) || SubSelectParam.class.equals(classes[i])) {
                    objects[i] = subSelectParam;
                } else if ("criterionList".equals(parameters[i]) && List.class.equals(classes[i])) {
                    objects[i] = subSelectParam.getCriterionList();
                } else if ("orderList".equals(parameters[i]) && List.class.equals(classes[i])) {
                    objects[i] = subSelectParam.getCriterionList();
                } else if ("pager".equals(parameters[i]) && Pager.class.equals(classes[i])) {
                    objects[i] = subSelectParam.getPager();
                } else {
                    objects[i] = null;
                }
            }
        }
        //非代理类获得的method无法用代理类执行，所以用代理类获取方法来执行
        return ClassUtil.getMethod(dao, findByStr).invoke(dao, objects);
    }

    /**
     * 获取自定义级联的信息
     * @return
     * @throws SQLException
     */
    public List<AliasBean> getAliasBeanList() throws SQLException {
        Field[] fields = getBeanClass().getDeclaredFields();
        List<AliasBean> aliasBeanList = new ArrayList<AliasBean>();
        for (Field field : fields) {
            CoocaaCascade coocaaCascade = field.getAnnotation(CoocaaCascade.class);
            if (coocaaCascade != null) {
                Class<?> cascadeClass = ClassUtil.findCascadeClass(field);//需要级联的类
                Class<? extends Dao> daoClass = null;
                try {
                    daoClass = (Class<? extends Dao>) Thread.currentThread().getContextClassLoader().loadClass(coocaaCascade.daoClassName());
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }

                ParameterizedType parameterizedType = (ParameterizedType) daoClass.getGenericInterfaces()[0];
                Class<?> tempClass = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                if (!tempClass.equals(cascadeClass)) {
                    throw new SQLException(getBeanClass().getName() + "." + field.getName() + " Annotation CoocaaCascade.daoClassName can not find " + cascadeClass.getName());
                } else if (!ItemBase.class.isAssignableFrom(cascadeClass)) {
                    throw new SQLException(getBeanClass().getName() + "." + field.getName() + " is not extends " + ItemBase.class.getName());
                } else if (cascadeClass.getAnnotation(Table.class) == null) {
                    throw new SQLException(cascadeClass.getName() + " is not hibernate bean.");
                }
                String fieldName = field.getName();
                String setMethodStr = "set" + StringUtils.toUpCaseFirstChar(fieldName);//set方法名
                Method setter = null;
                try {
                    setter = getBeanClass().getMethod(setMethodStr, field.getType());
                } catch (NoSuchMethodException e) {
                    throw new SQLException(getBeanClass().getName() + "." + fieldName + " setter is not found");
                }

                AliasBean aliasBean = new AliasBean();
                aliasBean.setField(field);
                aliasBean.setDao(SPRUTIL.context.getBean(daoClass));
                aliasBean.setMethodSet(setter);
                aliasBean.setCoocaaCascade(coocaaCascade);

                aliasBeanList.add(aliasBean);
            }
        }
        return aliasBeanList;
    }

    @SuppressWarnings("unchecked")
    public List<T> find(final Pager pager, final Criterion[] criteriones,
                        final List<Pair<String, String>> criterias,
                        final boolean loadSubClass, final Order... orders) {
        if (ObjectUtil.isNotEmpty(pager)) {
            pager.setTotalNum(getTotal(criteriones, criterias));
            if (pager.getTotalNum() == 0)
                return new ArrayList<T>();
        }

//            return (List<T>) d().executeFind(new HibernateCallback<List<T>>() {
//
//                public List<T> doInHibernate(final Session session)
//                        throws HibernateException, SQLException {
//                    final Criteria criteria = session
//                            .createCriteria(getBeanClass());
//
//                    if (ObjectUtil.isNotEmpty(criterias)) {
//                        for (Pair<String, String> tmp : criterias) {
//                            String[] t = tmp.getSecond().split(":");
//                            if (t.length == 1) {
//                                criteria.createAlias(tmp.getFirst(),
//                                        tmp.getSecond(), CriteriaSpecification.LEFT_JOIN);
//                            } else if (t.length == 2) {
//                                if (t[1].equals(CriteriaSpecification.LEFT_JOIN + "")) {
//                                    criteria.createAlias(tmp.getFirst(), t[0],
//                                            CriteriaSpecification.LEFT_JOIN);
//                                } else if (t[1].equals(CriteriaSpecification.INNER_JOIN + "")) {
//                                    criteria.createAlias(tmp.getFirst(), t[0],
//                                            CriteriaSpecification.INNER_JOIN);
//                                }
//                            }
//                        }
//                        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//                    }
//                    if (ObjectUtil.isNotEmpty(pager) &&
//                            (pager.getTotalNum() > pager.getPageSize() || pager.getPage() == 1)) {
//                        criteria.setFirstResult(pager.getFirstRow());
//                        criteria.setMaxResults(pager.getPageSize());
//                    }
//                    if (ObjectUtil.isNotEmpty(criteriones)) {
//                        for (Criterion criterion : criteriones) {
//                            criteria.add(criterion);
//                        }
//                    }
//                    if (ObjectUtil.isNotEmpty(orders)
//                            && CollectionsUtil.notEmpty(orders)) {
//                        for (Order order : orders) {
//                            criteria.addOrder(order);
//                        }
//                    } else {
//                        criteria.addOrder(DEFAULTORDER);
//                    }
//
//                    if (loadSubClass) {
//                        Field[] fs = Reflect.getFields(getBeanClass());
//                        for (Field f : fs) {
//                            if (Collection.class.isAssignableFrom(f.getType())) {
//                                criteria.setFetchMode(f.getName(), FetchMode.JOIN);
//                            }
//                        }
//                        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//                    }
//                    return criteria.list();
//                }
//
//            });

        final Criteria criteria = getSession()
                .createCriteria(getBeanClass());

        if (ObjectUtil.isNotEmpty(criterias)) {
            for (Pair<String, String> tmp : criterias) {
                String[] t = tmp.getSecond().split(":");
                if (t.length == 1) {
                    criteria.createAlias(tmp.getFirst(),
                            tmp.getSecond(), CriteriaSpecification.LEFT_JOIN);
                } else if (t.length == 2) {
                    if (t[1].equals(CriteriaSpecification.LEFT_JOIN + "")) {
                        criteria.createAlias(tmp.getFirst(), t[0],
                                CriteriaSpecification.LEFT_JOIN);
                    } else if (t[1].equals(CriteriaSpecification.INNER_JOIN + "")) {
                        criteria.createAlias(tmp.getFirst(), t[0],
                                CriteriaSpecification.INNER_JOIN);
                    }
                }
            }
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }
        if (ObjectUtil.isNotEmpty(pager) &&
                (pager.getTotalNum() > pager.getPageSize() || pager.getPage() == 1)) {
            criteria.setFirstResult(pager.getFirstRow());
            criteria.setMaxResults(pager.getPageSize());
        }
        if (ObjectUtil.isNotEmpty(criteriones)) {
            for (Criterion criterion : criteriones) {
                criteria.add(criterion);
            }
        }
        if (ObjectUtil.isNotEmpty(orders)
                && CollectionsUtil.notEmpty(orders)) {
            for (Order order : orders) {
                criteria.addOrder(order);
            }
        } else {
            criteria.addOrder(DEFAULTORDER);
        }

        if (loadSubClass) {
            Field[] fs = Reflect.getFields(getBeanClass());
            for (Field f : fs) {
                if (Collection.class.isAssignableFrom(f.getType())) {
                    criteria.setFetchMode(f.getName(), FetchMode.JOIN);
                }
            }
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }
        return criteria.list();
    }

    public int getTotal(final Criterion[] criteriones,
                        final List<Pair<String, String>> criterias) {
//        List<?> l = d().executeFind(new HibernateCallback<Object>() {
//            public List<?> doInHibernate(final Session session)
//                    throws HibernateException, SQLException {
//                final Criteria criteria = session.createCriteria(getBeanClass());
//                if (criterias != null && criterias.size() >= 1) {
//                    for (Pair<String, String> pair : criterias) {
//                        String[] t = pair.getSecond().split(":");
//                        if (t.length == 1) {
//                            criteria.createAlias(pair.getFirst(),
//                                    pair.getSecond(),
//                                    CriteriaSpecification.LEFT_JOIN);
//                        } else if (t.length == 2) {
//                            if (t[1].equals(new Integer(
//                                    CriteriaSpecification.LEFT_JOIN).toString())) {
//                                criteria.createAlias(pair.getFirst(), t[0],
//                                        CriteriaSpecification.LEFT_JOIN);
//                            } else if (t[1].equals(new Integer(
//                                    CriteriaSpecification.INNER_JOIN).toString())) {
//                                criteria.createAlias(pair.getFirst(), t[0],
//                                        CriteriaSpecification.INNER_JOIN);
//                            }
//                        }
//                    }
//                }
//                if (criteriones != null && criteriones.length >= 1) {
//                    for (Criterion criterion : criteriones) {
//                        criteria.add(criterion);
//                    }
//                }
//                criteria.setProjection(Projections.rowCount());
//                return criteria.list();
//            }
//        });

        final Criteria criteria = getSession().createCriteria(getBeanClass());
        if (criterias != null && criterias.size() >= 1) {
            for (Pair<String, String> pair : criterias) {
                String[] t = pair.getSecond().split(":");
                if (t.length == 1) {
                    criteria.createAlias(pair.getFirst(),
                            pair.getSecond(),
                            CriteriaSpecification.LEFT_JOIN);
                } else if (t.length == 2) {
                    if (t[1].equals(new Integer(
                            CriteriaSpecification.LEFT_JOIN).toString())) {
                        criteria.createAlias(pair.getFirst(), t[0],
                                CriteriaSpecification.LEFT_JOIN);
                    } else if (t[1].equals(new Integer(
                            CriteriaSpecification.INNER_JOIN).toString())) {
                        criteria.createAlias(pair.getFirst(), t[0],
                                CriteriaSpecification.INNER_JOIN);
                    }
                }
            }
        }
        if (criteriones != null && criteriones.length >= 1) {
            for (Criterion criterion : criteriones) {
                criteria.add(criterion);
            }
        }
        criteria.setProjection(Projections.rowCount());
        List<?> l = criteria.list();
        if (l.size() == 0)
            return 0;
        return ((Long) l.get(0)).intValue();
    }

    @Override
    public void sessionEvict(Object o) {
        this.getSession().clear();
    }
}