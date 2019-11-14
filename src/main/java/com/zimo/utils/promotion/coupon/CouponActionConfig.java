package com.zimo.utils.promotion.coupon;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,5:17 PM
 */
public class CouponActionConfig {

    /**
     * 固定减少金额
     */
    private Integer fixedAmount;

    /**
     * 百分比折扣 值为 1~100
     */
    private Integer percentage;

    public CouponActionConfig(String  config) {
        JSONObject configJson = JSONObject.parseObject(config);
        String fixedAmount = configJson.getString("fixedAmount");
        if ( null != fixedAmount) {
            this.setFixedAmount(Integer.valueOf(fixedAmount));
        }
        String percentage = configJson.getString("percentage");
        if (null != percentage){
            this.setPercentage(Integer.valueOf(percentage));
        }
    }


    public Map<String,Object> toArray(){
        Map<String,Object> map = new HashMap<>();

        if (null != this.getFixedAmount() ){
            map.put("fixedAmount",this.getFixedAmount());
        }
        if (null != this.getPercentage()){
            map.put("percentage",this.getPercentage());
        }
        return map;
    }


    public Integer getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(Integer fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        Map<String,Object> map = this.toArray();
        return JSONObject.toJSONString(map);
    }
}
