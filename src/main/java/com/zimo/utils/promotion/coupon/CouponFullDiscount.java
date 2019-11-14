package com.zimo.utils.promotion.coupon;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:45 AM
 */
public class CouponFullDiscount {
    private Long get_began_at;

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

    /**
     * 优惠的金额,单位：分
     */
    private Integer reduceAmount;

    public CouponFullDiscount() {
    }

    public CouponFullDiscount(CouponPromotionDTO couponPromotionDTO) {
        this.setStock(couponPromotionDTO.getStock());
        this.setSold(couponPromotionDTO.getSold());
        this.setUsed(couponPromotionDTO.getUsed());
        //TODO:写完所有的设置
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

    public Integer getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(Integer reduceAmount) {
        this.reduceAmount = reduceAmount;
    }
}
