package com.huashan.core.base;


import com.huashan.utils.Pager;
import com.huashan.utils.Result;

import javax.jws.WebMethod;
import java.util.List;

/**
 * 功能描述：service的基类
 * <p/>
 * 2010-12-30  上午11:44:14
 *
 * @param <T>
 */
public interface Service<T extends AbstractItem> {



//	/**
//	 * 获取操作的dao
//	 * @return
//	 */
//	Dao<T> getDao();

    /**
     * 添加或修改一条记录
     *
     * @param t
     * @return
     */
    @WebMethod(operationName = "save_or_update_t")
    boolean saveOrUpdate(T t);

    /**
     * 使用id删除
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "delete_id")
    boolean delete(Integer id);

    /**
     * 使用id删除
     *
     * @param ids
     * @return
     */
    @WebMethod(operationName = "delete_ids")
    boolean delete(Integer[] ids);

    /**
     * 删除该项
     */
    @WebMethod(operationName = "delete_t")
    boolean delete(T t);

//    /**
//     * 使用id查找有延迟加载的数据
//     *
//     * @param id
//     * @return
//     */
//    @WebMethod(operationName = "load_id")
//    T load(Integer id);

//    /**
//     * load所有延迟数据
//     *
//     * @return
//     */
//    @WebMethod(operationName = "load_all")
//    List<T> loadAll();

    /**
     * 使用id查找
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "find_id_int")
    T find(Integer id);

    /**
     * 使用id字符串查找,字符串格式为,1,2,3,4
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "find_id_str")
    List<T> find(String id);

    /**
     * 使用id数组查找
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "find_id_intlist")
    List<T> find(Integer[] id);

    /**
     * 查找所有
     */
    @WebMethod(operationName = "find_all")
    List<T> findAll();


    /**
     * 使用pager查询
     *
     * @param pager
     * @return
     */
    @WebMethod(operationName = "find_pager")
    Result<T> find(Pager pager);

    @WebMethod
    Result<T> findByPagerQuery(Pager pager) throws Exception;

//    /**
//     * 使用id字符串查找,字符串格式为,1,2,3,4
//     *
//     * @param id
//     * @return
//     */
//    @WebMethod(operationName = "load_id_str")
//    List<T> load(String id);

//    /**
//     * 使用id数组查找
//     *
//     * @param id
//     * @return
//     */
//    @WebMethod(operationName = "load_id_intlist")
//    List<T> load(Integer[] id);

    /**
     * 是否有相同的,如果有 返回该相同数据,默认验证为name
     * 如果用name验证可以使用该方法
     *
     * @param value
     * @return
     */
    @WebMethod(operationName = "hasSame_value")
    T hasSame(String value);


    @WebMethod(operationName = "save_json")
    boolean saveOrUpdate(String json);


    @WebMethod(operationName = "find_pager_url")
    Result<T> find_json(String pagerStr);

    /**
     * 使用id查找
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "find_cascade_by_id")
    T findCascadeById(Integer id);

}
