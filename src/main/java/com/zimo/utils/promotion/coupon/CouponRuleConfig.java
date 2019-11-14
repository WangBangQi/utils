package com.zimo.utils.promotion.coupon;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,4:50 PM
 */
public class CouponRuleConfig {

    private Integer amount;


    public CouponRuleConfig(String  config) {
        JSONObject configJson = JSONObject.parseObject(config);

        String amount = configJson.getString("amount");
        if (null != amount){
            this.setAmount(Integer.valueOf(amount));
        }

    }


    public Map<String,Object> toArray(){
        Map<String,Object> map = new HashMap<>();

        if (null != this.getAmount() ){
            map.put("amount",this.getAmount());
        }
        return map;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        Map<String,Object> map = this.toArray();
        return JSONObject.toJSONString(map);
    }
}
