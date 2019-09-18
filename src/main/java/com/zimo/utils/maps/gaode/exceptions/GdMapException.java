package com.zimo.utils.maps.gaode.exceptions;

import cn.zimo.wbq.exceptions.ErrCodeException;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,5:03 PM
 */
public class GdMapException extends ErrCodeException {
    public GdMapException() {
        super("9999","高德地图请求错误");
    }

    public GdMapException(String message) {
        super(message);
    }

    public GdMapException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
