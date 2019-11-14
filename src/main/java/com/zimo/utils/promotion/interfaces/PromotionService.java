package com.zimo.utils.promotion.interfaces;

import com.zimo.utils.promotion.Promotion;
import com.zimo.utils.promotion.coupon.CouponPromotionDTO;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,2:22 PM
 */
public interface PromotionService {

    Promotion findById(Long promotionId);


    void save(CouponPromotionDTO couponPromotionDTO);
}
