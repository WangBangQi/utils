package com.zimo.utils.maps.gaode;

import com.zimo.utils.maps.gaode.exceptions.GdMapException;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,3:13 PM
 */
public class ReGeoRequest extends GdMapRequest<ReGeoResponse>{

    @Override
    public Class<ReGeoResponse> getResponseClass() {
        return ReGeoResponse.class;
    }

    public void setKey(String key){
        this.putParamMap("key",key);
    }

    /**
     *
     * @param lat 经度
     * @param lng 维度
     */
    public void setLatLng(String lat,String lng){
        if (lat == null || lng == null)
            throw new GdMapException("经纬度参数不能够为空");
        this.putParamMap("location",lat+","+lng);
    }

    /**
     * 设置搜索半径
     * @param radius 单位：米 ,范围 0~3000
     */
    public void setRadius(Integer radius){
        if (radius!=null){
            if (radius > 3000) radius =3000;
            if (radius < 0 ) radius = 0;
            this.putParamMap("radius",radius.toString());
        }
    }

    public void setRoadLevel(Integer roadLevel){
        if (null != roadLevel && ( roadLevel.equals(0) || roadLevel.equals(1))){
            this.putParamMap("roadlevel",roadLevel.toString());
        }
    }


}
