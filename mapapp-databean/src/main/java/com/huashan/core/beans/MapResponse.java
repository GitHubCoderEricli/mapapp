package com.huashan.core.beans;

/**
 * 用来组装服务层对前端的返回结果
 * Created by lixu on 2016-05-20.
 */
public class MapResponse<T> {
    private boolean result;
    private String message;
    private T data;

    /**
     * 组装错误信息
     *
     * @param message
     * @param strings
     * @param <T>
     * @return
     */
    public static <T> MapResponse<T> failResponse(String message, String... strings) {
        return valueOf(false, parseMessage(message, strings), null);
    }

    /**
     * 替换字符串中的数据
     *
     * @param message
     * @param strings
     * @return
     */
    public static String parseMessage(String message, String... strings) {
        for (int i = 0; i < strings.length; i++) {
            message = message.replaceAll("\\{" + i + "\\}", strings[i]);
        }
        return message;
    }


    /**
     * 返回成功结果
     *
     * @param result
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> MapResponse<T> valueOf(boolean result, String message, T data) {
        MapResponse<T> mapResponse = new MapResponse<T>();
        mapResponse.setResult(result);
        mapResponse.setData(data);
        mapResponse.setMessage(message);
        return mapResponse;
    }

    /**
     * 返回成功信息
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> MapResponse<T> successResponse(T data) {
        return valueOf(true, null, data);
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
