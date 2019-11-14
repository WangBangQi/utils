package com.zimo.utils.promotion.repository;

import com.zimo.utils.mapper.PromotionRuleMapper;
import com.zimo.utils.promotion.PromotionRule;
import org.apache.tomcat.util.digester.Rules;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:11 AM
 */
@Repository
public class PromotionRuleDAO {

    @Resource
    private PromotionRuleMapper promotionRuleMapper;

    public void save(PromotionRule promotionRule){
        promotionRuleMapper.insert(promotionRule);
    }

    public void deleteByPromotionId(Long promotionId){
        promotionRuleMapper.deleteByPromotionId(promotionId);
    }

    public List<PromotionRule> listByPromotionId(Long promotionId){
        return promotionRuleMapper.listByPromotionId(promotionId);
    }


}
