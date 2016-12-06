package com.huashan.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : 谭显林
 * Date: 14-2-19
 * Time: 下午11:02
 */
public  class JsonUtil {
    public static final ObjectMapper op=new ObjectMapper();
    static{
        op.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    public static <T> String toJson(T o) {
        try {
            return op.writeValueAsString(o);
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * JSON串转换为Java泛型对象
     *
     * @param s
     *            JSON字符串
     * @param tr
     *            TypeReference,例如: new TypeReference< List<User> >(){}
     * @param <T>
     *           泛型对象
     * @return List对象列表
     */
    @SuppressWarnings("unchecked")
    public static <T> T toObject(String s,TypeReference<T> tr) {
        try {
            return (T) op.readValue(s, tr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *  将POJO对象转成Map
     *  */
    public static Map pojoTOMapReflect(Object obj) {
        Map hashMap = new HashMap();
        try {
            Class c = obj.getClass();
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                if (m[i].getName().indexOf("get")==0) {
                    //System.out.println("方法名："+m[i].getName());
                    // System.out.println("值："+ m[i].invoke(obj, new Object[0]));
                    hashMap.put(m[i].getName(), m[i].invoke(obj, new Object[0]));
                }
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
        return hashMap;
    }
    /**
     * string json 转map
     * @param json
     * @return
     */
    private Map<String,String> JsonTOMap(String json){
        Map<String, String> map =  new HashMap<String, String>();
        JSONObject jsonObject = JSONObject.fromObject(json);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            String key = String.valueOf(it.next());
            String value = jsonObject.getString(key);
            //			String value = (String) jsonObject.get(key);
            map.put(key, value);
        }
        return  map;
    }

    public static Map<String, String> josnToMap(String json) {
        if (json == null || ("").equals(json)){
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        JSONObject jsonObject = JSONObject.fromObject(json);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            String key = String.valueOf(it.next());
            String value = jsonObject.getString(key);
            //			String value = (String) jsonObject.get(key);
            map.put(key, value);
        }
        return  map;
    }
}
