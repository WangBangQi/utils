package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpRequest;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,6:04 PM
 */
public class GeoRequest extends GdMapRequest<GeoResponse> {
    /**
     * 地址 必填
     * 规则遵循：国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号。
     * 如果需要解析多个地址的话，请用"|"进行间隔，并且将 batch 参数设置为 true，最多支持 10 个地址进进行"|"分割形式的请求。
     */
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        if (address!= null){
            this.putParamMap("address",address);
        }
    }

    @Override
    public Class<GeoResponse> getResponseClass() {
        return GeoResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return Constant.GEO_URL;
    }

    @Override
    public String getRequestMethod() {
        return HttpRequest.METHOD_GET;
    }
}
