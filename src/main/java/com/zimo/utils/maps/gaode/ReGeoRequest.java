package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpRequest;
import com.zimo.utils.maps.gaode.exceptions.GdMapException;

/**
 * @author zi.mo
 * @description 逆编码请求对象
 * @createTime 2019/9/18,3:13 PM
 */
public class ReGeoRequest extends GdMapRequest<ReGeoResponse>{

    private String key;

    private String lat;

    private String lng;

    private Integer radius;

    private Integer roadLevel;

    public ReGeoRequest() {
        super();
    }

    @Override
    public Class<ReGeoResponse> getResponseClass() {
        return ReGeoResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return Constant.RE_GEO_URL;
    }

    @Override
    public String getRequestMethod() {
        return HttpRequest.METHOD_GET;
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

    /**
     *
     * @param lat 经度
     * @param lng 维度
     */
    public void setLatLng(String lat,String lng){
        this.lat = lat;
        this.lng = lng;
        if (lat == null || lng == null)
            throw new GdMapException("经纬度参数不能够为空");
        this.putParamMap("location",lat+","+lng);
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    /**
     * 设置搜索半径
     * @param radius 单位：米 ,范围 0~3000
     */
    public void setRadius(Integer radius){
        this.radius = radius;
        if (radius!=null){
            if (radius > 3000) radius =3000;
            if (radius < 0 ) radius = 0;
            this.putParamMap("radius",radius.toString());
        }
    }

    public Integer getRadius() {
        return this.radius;
    }

    public void setRoadLevel(Integer roadLevel){
        this.roadLevel = roadLevel;
        if (null != roadLevel && ( roadLevel.equals(0) || roadLevel.equals(1))){
            this.putParamMap("roadlevel",roadLevel.toString());
        }
    }

    public Integer getRoadLevel() {
        return this.roadLevel;
    }
}
