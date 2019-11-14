package com.zimo.utils.promotion.interfaces;

import com.zimo.utils.promotion.Promotion;
import com.zimo.utils.promotion.PromotionFactory;
import com.zimo.utils.promotion.coupon.CouponPromotionDTO;
import com.zimo.utils.promotion.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,2:22 PM
 */

@Service
public class PromotionServiceImpl implements PromotionService {


    @Resource
    private PromotionRepository promotionRepository;

    @Resource
    private PromotionFactory promotionFactory;


    @Override
    public Promotion findById(Long promotionId) {
        return promotionRepository.findById(promotionId);
    }

    @Override
    public void save(CouponPromotionDTO couponPromotionDTO) {
        Promotion promotion = promotionFactory.createPromotion(couponPromotionDTO);
        promotionRepository.saveOrUpdate(promotion);
    }
}
