package com.zimo.utils.promotion.coupon;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,5:36 PM
 */
public class CouponConfig {

    //冗余的满减金额
    private Integer amount;

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

    /**
     * 采购商 ID
     */
    private Long supplierId;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
}
