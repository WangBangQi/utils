package com.zimo.utils.promotion;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/10/8,9:36 AM
 */
public enum PromotionStatus{
    /**
     * 下架
     */
    DOWN(0),
    /**
     * 上架
     */
    UP(1)
    ;
    private Integer code;

    PromotionStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}