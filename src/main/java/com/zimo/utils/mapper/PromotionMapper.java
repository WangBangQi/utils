package com.zimo.utils.mapper;

import com.zimo.utils.promotion.Promotion;
import org.apache.ibatis.annotations.Param;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,5:57 PM
 */
public interface PromotionMapper {

    int insert(Promotion promotion);

    int deleteById(@Param("id") Long id);

    Promotion findById(@Param("id")Long id);
}
