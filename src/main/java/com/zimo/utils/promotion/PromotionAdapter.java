package com.zimo.utils.promotion;

import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,2:07 PM
 */
public interface PromotionAdapter {

    /**
     * 获取规则
     * @return
     */
    List<PromotionRule> convertRules();

    /**
     * 获取促销要执行的动作
     * @return
     */
    List<PromotionAction> convertActions();

    /**
     * 获取促销 config
     * @return
     */
    String convertPromotionConfig();
}
