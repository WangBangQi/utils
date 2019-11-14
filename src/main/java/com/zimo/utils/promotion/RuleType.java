package com.zimo.utils.promotion;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,9:58 AM
 */
public enum RuleType {

//    订单总额 order_total
//    订单中促销项目总额 promotion_items_total
//    第N笔订单  nth_order
//    所属分类 has_category
//    消费者用户组 customer_group  (白金会员组/钻石会员组 等等)
//    购买数量  item_quantity
    /**
     * 订单总额
     */
    order_total("order_total"),

    ;
    private String code;

    RuleType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
