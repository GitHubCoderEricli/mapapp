package com.huashan.utils;

public class Convert {
    public static int toInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    /**
     * @Author demo
     * @param str  输入以json格式字符串为元素，分号隔开的的json数组
     * @return  List<Arg>
     */
	/*public static List<Arg> fromJsonArrayText(String str){
        String[] strs=str.split(";");
        List<Arg> rtn=new ArrayList<Arg>();
        for(String st:strs){
            JSONObject jo=JSONObject.fromObject(st);
            rtn.add((Arg)JSONObject.toBean(jo,Arg.class));
        }
        return rtn;
    }*/
    /**
     * @Author demo
     * @param args
     * @return 与fromJsonArrayText函数互逆
     */
    /*public static String toJsonArrayText(List<Arg> args){
        String rtn="";
        for(Arg arg:args){
            rtn+=JSONObject.fromObject(arg)+";";
        }
        return rtn;
    }*/
    /**
     * @Author demo
     * @param str  输入以json格式字符串为元素，分号隔开的的json数组
     * @return  对json里的对象建立map
     */
    /*public static Map<String,Object> jsonObjectsToMap(String str){
        Map<String,Object> rtn=new HashMap<String,Object>();
        for(Arg arg:fromJsonArrayText(str)){
            rtn.put(arg.getName(),arg.getValue());
        }
        return rtn;
    }*/
}