package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.exceptions.HttpException;
import cn.zimo.wbq.http.HttpHandler;
import cn.zimo.wbq.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.maps.gaode.exceptions.GdMapException;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,4:41 PM
 */
public class GdMapClient {

    private int maxRetryNumber = 3;
    private boolean autoRetry = true;

    public <T extends GdMapResponse> T getGdMapResponse(GdMapRequest<T> request){
        HttpResponse httpResponse = this.doAction(request);
        return this.parseGdMapResponse(request.getResponseClass(),httpResponse);
    }

    private HttpResponse doAction(GdMapRequest request){
        boolean retry = this.autoRetry;
        int retryNumber = this.maxRetryNumber;
        HttpResponse response = null;
        int retryTimes = 1;
        for (; retry && retryTimes<=retryNumber; retryTimes++){
            try {
                response = HttpHandler.execute(request);
                break;
            }catch (HttpException e){
                //try again
                e.printStackTrace();
            }
        }
        return response;
    }


    private   <T extends GdMapResponse> T parseGdMapResponse(Class<T> t,HttpResponse httpResponse){
        //将结果转换成对象
        try {
            String result = httpResponse.getStringResult();
            System.out.println(result);
            return JSONObject.parseObject(result,t);
        }catch (Throwable throwable){
            throw new GdMapException("parseGdMapResponse Error",throwable);
        }
    }
}
