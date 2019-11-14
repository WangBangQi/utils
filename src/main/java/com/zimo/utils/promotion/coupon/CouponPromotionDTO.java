package com.zimo.utils.promotion.coupon;

import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.promotion.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,10:04 AM
 */
public class CouponPromotionDTO implements PromotionAdapter{

    /*供应商*/
    public static final Integer PLATFORM_SUPPLIER = 0;
    /*平台*/
    public static final Integer PLATFORM_ALL = 1;

    private Long id;

    private String name;

    private String description;

    //权重,默认为 0
    private Integer position;

    /**
     * 优惠卷类型
     * ${@link CouponType}
     */
    private Integer type;

    /**
     * 优惠卷所属平台类别
     */
    private Integer platform;

    /*供应商 ID*/
    private Long supplierId;


    /**
     * 获取方式
     *  ${@link GainWay}
     */
    private String gainWay;

    //金额
    private Integer amount;

    private Integer reduceAmount;

    private Integer percentage;

    /**
     * 规则 JSON 字符串
     */
    private String config;

    /*有效开始时间*/
    private Long valid_began_at;

    /*有效结束时间*/
    private Long valid_ended_at;

    /**
     * 领取开始时间
     */
    private Long get_began_at;

    /**
     * 领取结束时间
     */
    private Long get_ended_at;

    /**
     * 库存数量
     */
    private Long stock;

    /**
     * 已经领取的数量
     */
    private Long sold;

    /**
     * 使用的优惠卷数量
     */
    private Long used;

    //领取限制  1
    private Integer catch_limit;



    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    @Override
    public List<PromotionRule> convertRules() {
        List<PromotionRule> promotionRules = new ArrayList<>();
        //促销规则类别
        if (CouponType.full_fixed_discount.getCode().equals(this.getType())
                || CouponType.percentage_discount.getCode().equals(this.getType())){
            //满减固定金额
            PromotionRule promotionRule = new PromotionRule();
            promotionRule.setType(RuleType.order_total.getCode());
            promotionRule.setConfig(new CouponRuleConfig(this.getConfig()).toString());
            promotionRule.setPromotionId(this.getId());
            promotionRule.setCreateTime(System.currentTimeMillis());
            promotionRules.add(promotionRule);
        }
        if (CouponType.fixed_discount.getCode().equals(this.getType())){
            //现金劵，没有使用限制

        }
        return promotionRules;
    }

    @Override
    public List<PromotionAction> convertActions() {
        //描述的是要执行 的动作
        List<PromotionAction> promotionActions = new ArrayList<>();
        if (CouponType.full_fixed_discount.getCode().equals(this.getType())
                || CouponType.fixed_discount.getCode().equals(this.getType())){
            //满减固定金额
            PromotionAction promotionAction = new PromotionAction();
            promotionAction.setType(ActionType.order_fixed_discount.getCode());
            promotionAction.setConfig(new CouponActionConfig(this.getConfig()).toString());
            promotionAction.setCreateTime(System.currentTimeMillis());
            promotionActions.add(promotionAction);
        }
        if (CouponType.percentage_discount.getCode().equals(this.getType())){
            //百分比折扣
            PromotionAction promotionAction = new PromotionAction();
            promotionAction.setType(ActionType.order_percentage_discount.getCode());
            promotionAction.setConfig(new CouponActionConfig(this.getConfig()).toString());
            promotionAction.setCreateTime(System.currentTimeMillis());
            promotionActions.add(promotionAction);
        }
        return promotionActions;
    }

    @Override
    public String convertPromotionConfig() {
        CouponConfig couponConfig = new CouponConfig();
        couponConfig.setSold(this.getSold());
        couponConfig.setStock(this.getStock());
        couponConfig.setUsed(this.getUsed());
        couponConfig.setCatch_limit(this.getCatch_limit());
        couponConfig.setGet_began_at(this.getGet_began_at());
        couponConfig.setGet_ended_at(this.getGet_ended_at());
        couponConfig.setValid_began_at(this.getValid_began_at());
        couponConfig.setValid_ended_at(this.getValid_ended_at());
        couponConfig.setSupplierId(this.getSupplierId());
        return JSONObject.toJSONString(couponConfig);
    }

    /**
     * 校验不能为 NULL 的参数,已经参数的合法性
     * @return <code>true</code> 参数合法 返回 true
     */
    public boolean paramValid(){
        //TODO:校验参数
        return true;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSold() {
        return sold;
    }

    public void setSold(Long sold) {
        this.sold = sold;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    public Integer getCatch_limit() {
        return catch_limit;
    }

    public void setCatch_limit(Integer catch_limit) {
        this.catch_limit = catch_limit;
    }

    public String getGainWay() {
        return gainWay;
    }

    public void setGainWay(String gainWay) {
        this.gainWay = gainWay;
    }

    public Long getValid_began_at() {
        return valid_began_at;
    }

    public void setValid_began_at(Long valid_began_at) {
        this.valid_began_at = valid_began_at;
    }

    public Long getValid_ended_at() {
        return valid_ended_at;
    }

    public void setValid_ended_at(Long valid_ended_at) {
        this.valid_ended_at = valid_ended_at;
    }

    public Long getGet_began_at() {
        return get_began_at;
    }

    public void setGet_began_at(Long get_began_at) {
        this.get_began_at = get_began_at;
    }

    public Long getGet_ended_at() {
        return get_ended_at;
    }

    public void setGet_ended_at(Long get_ended_at) {
        this.get_ended_at = get_ended_at;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Integer reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public enum CouponType{
        //满减固定折扣 （满减）
        full_fixed_discount(0),
        //百分比折扣 （打折）
        percentage_discount(1),
        //固定减少 （现金劵）
        fixed_discount(2)
        ;
        private Integer code;


        CouponType(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

    public enum GainWay{
        //用户手动领取
        user_get(0),
        //活动发放
        promotion_grant(1)
        ;
        private Integer code;


        GainWay(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }
    }

}
