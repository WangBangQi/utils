package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpHandler;
import cn.zimo.wbq.http.HttpRequest;

import cn.zimo.wbq.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,2:00 PM
 */
public class GDMapServiceImpl implements GDMapService {

    private static final Logger log = LoggerFactory.getLogger(GDMapServiceImpl.class);

    private static GdMapClient client;

    static {
        client = new GdMapClient();
    }


    @Override
    public ReGeoResponse getAcsResponse(ReGeoRequest reGeoRequest) {

        reGeoRequest.setUrl(Constant.RE_GEO_URL);
        reGeoRequest.setMethod(HttpRequest.METHOD_GET);

        reGeoRequest.setQueryMap(reGeoRequest.getParamMap());

        return client.getGdMapResponse(reGeoRequest);
    }


    public static void main (String args[]){

        GDMapService gdMapService = new GDMapServiceImpl();

        ReGeoRequest reGeoRequest = new ReGeoRequest();
        reGeoRequest.setKey(Constant.APP_KEY);
        reGeoRequest.setLatLng("120.1068580000","30.3320730000");
        reGeoRequest.setRoadLevel(0);

        ReGeoResponse reGeoResponse = gdMapService.getAcsResponse(reGeoRequest);


        System.out.println(JSONObject.toJSONString(reGeoResponse.getRegeocode()));


    }
}
