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

    private String method = HttpRequest.METHOD_GET;

    private Map<String,String> paramMap = new HashMap<>();

    public GdMapRequest() {
        super();
        this.setMethod(this.method);
    }

    public abstract Class<T> getResponseClass();

    public Map<String, String> getParamMap() {
        return paramMap;
    }

    public void putParamMap(String key,String value){
        this.paramMap.put(key,value);
    }
}
