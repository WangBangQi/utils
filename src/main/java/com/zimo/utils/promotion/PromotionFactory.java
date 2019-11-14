package com.zimo.utils.promotion;

import com.zimo.utils.promotion.coupon.CouponPromotionDTO;
import org.springframework.stereotype.Service;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:10 AM
 */
@Service
public class PromotionFactory {

    public Promotion createPromotion(CouponPromotionDTO couponPromotionDTO)throws PromotionException{
        if (!couponPromotionDTO.paramValid()){
            throw new PromotionException();
        }
        Promotion promotion = new Promotion();
        promotion.setName(couponPromotionDTO.getName());
        promotion.setDescription(couponPromotionDTO.getDescription());
        promotion.setBeganAt(couponPromotionDTO.getValid_began_at());
        promotion.setEndedAt(couponPromotionDTO.getValid_ended_at());
        promotion.setPosition(couponPromotionDTO.getPosition());
        promotion.setType(PromotionType.COUPON.getCode());
        promotion.setConfig(couponPromotionDTO.convertPromotionConfig());
        promotion.setPromotionRules(couponPromotionDTO.convertRules());
        promotion.setPromotionActions(couponPromotionDTO.convertActions());
        return promotion;
    }

}
