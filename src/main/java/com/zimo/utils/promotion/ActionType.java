package com.zimo.utils.promotion;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,9:58 AM
 */
public enum  ActionType {
//    订单固定折扣 order_fixed_discount
//    订单百分比折扣 order_percentage_discount
//    订单中促销项目固定折扣 promotion_items_fixed_discount
//    订单中促销项目阶梯式折扣 promotion_items_ladder_discount
//    赠送积分 present_integral
//    运费百分比折扣 shipping_percentage_discount

    /**
     * 订单固定折扣
     */
    order_fixed_discount("order_fixed_discount"),
    /**
     * 订单百分比折扣
     */
    order_percentage_discount("order_percentage_discount"),

    ;
    private String code;

    ActionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
