package com.zimo.utils.promotion.repository;

import com.zimo.utils.mapper.PromotionMapper;
import com.zimo.utils.promotion.Promotion;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:10 AM
 */
@Repository
public class PromotionDAO {

    @Resource
    private PromotionMapper promotionMapper;

    public Long save(Promotion promotion){
        promotionMapper.insert(promotion);
        return promotion.getId();
    }

    public Promotion findById(Long id){
        return promotionMapper.findById(id);
    }
}
