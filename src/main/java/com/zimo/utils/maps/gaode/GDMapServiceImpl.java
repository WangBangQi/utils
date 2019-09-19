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

    private static GdMapClient client;

    static {
        client = new GdMapClient();
    }

    @Override
    public <T extends GdMapResponse> T  gerGdMapResponse(GdMapRequest<T> request) {
        return client.getGdMapResponse(request);
    }

}
