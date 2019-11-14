package com.zimo.utils.mapper;

import com.zimo.utils.promotion.Promotion;
import com.zimo.utils.promotion.PromotionAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,5:50 PM
 */
public interface PromotionActionMapper {

    int insert(PromotionAction action);

    void deleteByPromotionId(@Param("promotionId")Long promotionId);

    List<PromotionAction> listByPromotionId(@Param("promotionId")Long promotionId);
}
