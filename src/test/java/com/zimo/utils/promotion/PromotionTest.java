package com.zimo.utils.promotion;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.promotion.coupon.CouponPromotionDTO;
import com.zimo.utils.promotion.interfaces.PromotionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,9:57 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PromotionTest {

    @Resource
    PromotionService promotionService;


    @Test
    public void save()throws Exception{



       for (int i = 0;i<10;i++){
           Long id = i%9 + 1L;
           add(id);
       }

    }

    private void add(Long supplierId){
        //新增一个优惠卷
        CouponPromotionDTO couponPromotionDTO = new CouponPromotionDTO();
        couponPromotionDTO.setCatch_limit(1);
        couponPromotionDTO.setGainWay(CouponPromotionDTO.GainWay.user_get.getCode().toString());
        couponPromotionDTO.setSold(100L);
        couponPromotionDTO.setStock(1000L);
        couponPromotionDTO.setUsed(0L);
        long now = new Date().getTime();
        couponPromotionDTO.setGet_began_at(now);
        couponPromotionDTO.setValid_began_at(now);
        couponPromotionDTO.setGet_ended_at(now+24*3600000);
        couponPromotionDTO.setValid_ended_at(now+7*24*3600000);
        couponPromotionDTO.setType(CouponPromotionDTO.CouponType.full_fixed_discount.getCode());
        couponPromotionDTO.setPosition(0);
        couponPromotionDTO.setName("满 100 减 10");
        couponPromotionDTO.setDescription("这是一个优惠卷");
        couponPromotionDTO.setPlatform(CouponPromotionDTO.PLATFORM_SUPPLIER);
        couponPromotionDTO.setSupplierId(supplierId);
        Map<String,Object> map = new HashMap<>();
        map.put("amount",10000);
        map.put("fixedAmount",1000);
        couponPromotionDTO.setConfig(JSONObject.toJSONString(map));
        promotionService.save(couponPromotionDTO);
    }

    @Test
    public void findById()throws Exception{
        Long promotionId = 16L;

        Promotion promotion = promotionService.findById(promotionId);

        System.out.println(JSONObject.toJSONString(promotion));
    }
}