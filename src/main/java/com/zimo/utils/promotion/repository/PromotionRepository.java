package com.zimo.utils.promotion.repository;

import com.zimo.utils.promotion.Promotion;
import com.zimo.utils.promotion.PromotionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,1:37 PM
 */
@Repository
public class PromotionRepository {

    @Resource
    private PromotionActionDAO promotionActionDAO;

    @Resource
    private PromotionDAO promotionDAO;

    @Resource
    private PromotionRuleDAO promotionRuleDAO;


    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdate(Promotion promotion){
        //保存或者更新

        final Long promotionId = promotionDAO.save(promotion);
        //删除规则
        promotionRuleDAO.deleteByPromotionId(promotionId);
        //更新规则
        if (!CollectionUtils.isEmpty(promotion.getPromotionRules())){

            //TODO:实现批量新增
            promotion.getPromotionRules().forEach(
                    e->{
                        e.setPromotionId(promotionId);
                        promotionRuleDAO.save(e);
                    }
            );
        }

        //删除动作
        promotionActionDAO.deleteByPromotionId(promotionId);
        //更新动作
        //更新规则
        if (!CollectionUtils.isEmpty(promotion.getPromotionActions())){
            //TODO:实现批量新增
            promotion.getPromotionActions().forEach(
                    e->{
                        e.setPromotionId(promotionId);
                        promotionActionDAO.save(e);
                    }
            );
        }

    }


    /**
     * 根据促销唯一标识 ID 发现促销 ID
     * @param promotionId 促销 ID
     * @return 促销实体
     */
    public Promotion findById(final Long promotionId){
        Promotion promotion = promotionDAO.findById(promotionId);

        if (null == promotion){
            throw new PromotionException("invalid promotionId ,can not found promotion");
        }

        promotion.setPromotionRules(promotionRuleDAO.listByPromotionId(promotionId));
        promotion.setPromotionActions(promotionActionDAO.listByPromotionId(promotionId));

        return promotion;
    }
}
