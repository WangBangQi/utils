package com.zimo.utils.maps.gaode;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public <T extends GdMapResponse> T  gerGdMapResponse(GdMapRequest<T> request) {
        return client.getGdMapResponse(request);
    }

    public static void main (String args[]){

        GDMapService gdMapService = new GDMapServiceImpl();

        ReGeoRequest reGeoRequest = new ReGeoRequest();
        reGeoRequest.setKey(Constant.APP_KEY);
        reGeoRequest.setLatLng("120.1068580000","30.3320730000");
        reGeoRequest.setRoadLevel(0);

        ReGeoResponse reGeoResponse = gdMapService.gerGdMapResponse(reGeoRequest);


        if (reGeoResponse.isSuccess()){
            log.info("请求成功:{}",JSONObject.toJSONString(reGeoResponse.getRegeocode()));
        } else {
            log.info("请求失败:info={},infocode={}",reGeoResponse.getInfo(),reGeoResponse.getInfocode());
        }


    }
}
