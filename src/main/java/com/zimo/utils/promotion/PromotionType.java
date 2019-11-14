package com.zimo.utils.promotion;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,9:37 AM
 */
public enum PromotionType {
    /*优惠劵*/
    COUPON("coupon")
    ;

    private String code;

    PromotionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }


}
