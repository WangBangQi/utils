package com.zimo.utils.mapper;

import com.zimo.utils.promotion.PromotionRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,5:56 PM
 */
public interface PromotionRuleMapper {

    int insert(PromotionRule promotionRule);

    void deleteByPromotionId(@Param("promotionId")Long promotionId);

    List<PromotionRule> listByPromotionId(@Param("promotionId")Long promotionId);
}
