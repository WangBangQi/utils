package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpRequest;
import com.zimo.utils.maps.gaode.exceptions.GdMapException;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/19,6:25 PM
 */
public class WeatherInfoRequest extends GdMapRequest<WeatherInfoResponse> {


    private static final String URL = "https://restapi.amap.com/v3/weather/weatherInfo";

    /**
     * 城市编码 adcode 必填
     */
    private String city;

    /**
     * 气象类型 ，可选
     * base:返回实况天气,all:返回预报天气
     */
    private String extensions;

    @Override
    public Class<WeatherInfoResponse> getResponseClass() {
        return WeatherInfoResponse.class;
    }

    @Override
    public String getRequestUrl() {
        return WeatherInfoRequest.URL;
    }

    @Override
    public String getRequestMethod() {
        return HttpRequest.METHOD_GET;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        if (null != city){
            this.putParamMap("city",city);
        }
    }

    public String getExtensions() {
        return extensions;
    }

    public void setExtensions(String extensions) {
        this.extensions = extensions;
        if (null != extensions && (Extension.BASE.getValue().equals(extensions) || Extension.ALL.getValue().equals(extensions))){
            this.putParamMap("extensions",extensions);
        }
    }


    public  enum Extension{
        /*返回实况天气*/
        BASE("base"),
        /*返回预报天气*/
        ALL("all")
        ;

        Extension(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }
}
