package com.zimo.utils.promotion;

import cn.zimo.wbq.exceptions.Code;
import cn.zimo.wbq.exceptions.ErrCodeException;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/24,11:00 AM
 */
public class PromotionException  extends ErrCodeException{
    public PromotionException() {
        super(Code.PROMOTION_ERROR,"promotion exception");
    }

    public PromotionException(String message) {
        super(Code.PROMOTION_ERROR,message);
    }

    public PromotionException(String message, Throwable throwable) {
        super(message,Code.PROMOTION_ERROR,throwable);
    }
}
