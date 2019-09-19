package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,4:33 PM
 */
public abstract class GdMapRequest <T extends GdMapResponse>extends HttpRequest {

    /**
     * 高德 KEY
     */
    private String key;

    /**
     * 请求参数
     */
    private Map<String,String> paramMap = new HashMap<>();

    public GdMapRequest() {
        super();
    }

    /**
     * 对应的需要转换的 response 对象
     * @return
     */
    public abstract Class<T> getResponseClass();

    /**
     * 获取该请求的 API 接口
     * @return
     */
    public abstract String getRequestUrl();

    /**
     * 该请求的请求方法
     * @return
     */
    public abstract String getRequestMethod();

    /**
     * 默认的返回的格式
     * @return
     */
    public String defaultOutput(){
        return "JSON";
    }


    public void setKey(String key){
        this.key = key;
        if (key != null) {
            this.putParamMap("key", key);
        }
    }

    public String getKey() {
        return this.key;
    }

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public void putParamMap(String key, String value){
        this.paramMap.put(key,value);
    }


    public String getDefaultMethod(){
        return this.getMethod();
    }

    public void setDefaultOutPut(){
        this.putParamMap("output",this.defaultOutput());
    }




}
