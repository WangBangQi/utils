package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.exceptions.HttpException;
import cn.zimo.wbq.http.HttpHandler;
import cn.zimo.wbq.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.maps.gaode.exceptions.GdMapException;
import com.zimo.utils.utils.SecurityUtil;
import org.apache.tomcat.util.security.MD5Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.*;
import java.util.stream.Collectors;

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
        if (null == request.getRequestUrl()){
            throw new GdMapException("request url invalid ,you should set value ");
        }
        request.setUrl(request.getRequestUrl());
        if (null != request.getRequestMethod()){
            request.setMethod(request.getRequestMethod());
        } else {
            request.setMethod(request.getDefaultMethod());
        }
        //计算签名之后，签名错误也能够正常返回，所以先不使用
//        request.setQueryMap(this.sign(request.getParamMap()));
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

    private Map<String,String> sign(Map<String,String> paramMap){
        Set<String> keys = paramMap.keySet();
        //升序排序 KEY
        List<String> keyList = keys.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                })
                .collect(Collectors.toList());

        StringBuilder signValue = new StringBuilder();
        for (String key : keyList){
            signValue.append(key).append("=").append(paramMap.get(key)).append("&");
        }

        signValue.deleteCharAt(signValue.lastIndexOf("&"));

        //添加密钥
        signValue.append(Constant.SIGN_PRIVATE_SECRET);

        try {
            paramMap.put("sig", SecurityUtil.generateSign(signValue.toString()));
        }catch (NoSuchAlgorithmException e){
            throw new GdMapException("MD5 sign failed:{}",e);
        }

        return paramMap;
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
