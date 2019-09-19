package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpRequest;

/**
 * @author zi.mo
 * @description IP 地址定位
 * @createTime 2019/9/19,4:45 PM
 */
public class FixedPositionThroughIpRequest extends GdMapRequest<FixedPositionThroughIpResponse> {

    private static final String URL = "https://restapi.amap.com/v3/ip";

    /**
     * IP 地址， 不传的时候，查询的是 Http 请求的来源地址
     */
    private String ip;

    @Override
    public Class<FixedPositionThroughIpResponse> getResponseClass() {
        return FixedPositionThroughIpResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return FixedPositionThroughIpRequest.URL;
    }

    @Override
    public String getRequestMethod() {
        return HttpRequest.METHOD_GET;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
        if (ip != null){
            this.putParamMap("ip",ip);
        }
    }
}
