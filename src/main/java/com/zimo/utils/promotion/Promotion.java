package com.zimo.utils.promotion;

import java.util.List;

/**
 * @author zi.mo
 * @description 促销
 * @createTime 2019/9/24,9:34 AM
 */
public class Promotion {

    private Long id;

    private String name;

    private String description;

    //权重
    private Integer position;

    /**
     * ${@link PromotionType}
     */
    private String type;

    private String config;

    private Long beganAt;

    private Long endedAt;

    /**
     * 促销状态
     * ${@link PromotionStatus}
     */
    private Integer status;

    private List<PromotionRule> promotionRules;

    private List<PromotionAction> promotionActions;

    public List<PromotionRule> getPromotionRules() {
        return promotionRules;
    }

    public void setPromotionRules(List<PromotionRule> promotionRules) {
        this.promotionRules = promotionRules;
    }

    public List<PromotionAction> getPromotionActions() {
        return promotionActions;
    }

    public void setPromotionActions(List<PromotionAction> promotionActions) {
        this.promotionActions = promotionActions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Long getBeganAt() {
        return beganAt;
    }

    public void setBeganAt(Long beganAt) {
        this.beganAt = beganAt;
    }

    public Long getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Long endedAt) {
        this.endedAt = endedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
