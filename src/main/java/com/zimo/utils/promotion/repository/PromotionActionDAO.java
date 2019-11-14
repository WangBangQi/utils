package com.zimo.utils.promotion.repository;

import com.zimo.utils.mapper.PromotionActionMapper;
import com.zimo.utils.promotion.Promotion;
import com.zimo.utils.promotion.PromotionAction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:11 AM
 */
@Repository
public class PromotionActionDAO {

    @Resource
    private PromotionActionMapper promotionActionMapper;

    public void save(PromotionAction promotionAction){
        promotionActionMapper.insert(promotionAction);
    }

    public void deleteByPromotionId(Long promotionId){
        promotionActionMapper.deleteByPromotionId(promotionId);
    }

    public List<PromotionAction> listByPromotionId(Long promotionId){
        return promotionActionMapper.listByPromotionId(promotionId);
    }
}
