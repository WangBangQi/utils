package com.zimo.utils.maps.gaode;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/19,6:09 PM
 */
public class TestUtil {

    private static final Logger log = LoggerFactory.getLogger(TestUtil.class);

    public static void main (String args[]){

        GDMapService gdMapService = new GDMapServiceImpl();

        TestUtil testUtil = new TestUtil();
        testUtil.fixedPositionThroughIp(gdMapService);
    }


    public void fixedPositionThroughIp(GDMapService gdMapService){
        FixedPositionThroughIpRequest request = new FixedPositionThroughIpRequest();
//        request.setIp("47.97.251.229");
        request.setKey(Constant.APP_KEY);
        FixedPositionThroughIpResponse response = gdMapService.gerGdMapResponse(request);

        System.out.println(JSONObject.toJSONString(response));
    }

    public void reGeoRequest(GDMapService gdMapService){
        ReGeoRequest reGeoRequest = new ReGeoRequest();
        reGeoRequest.setKey(Constant.APP_KEY);
        reGeoRequest.setLatLng("120.1068580000","30.3320730000");
        reGeoRequest.setRoadLevel(0);

        ReGeoResponse reGeoResponse = gdMapService.gerGdMapResponse(reGeoRequest);


        if (reGeoResponse.isSuccess()){
            log.info("请求成功:{}",JSONObject.toJSONString(reGeoResponse.getRegeocode()));
            log.info("success ,cityCode = {} ,adcode = {} ");
        } else {
            log.info("请求失败:info={},infocode={}",reGeoResponse.getInfo(),reGeoResponse.getInfocode());
        }
    }
}
