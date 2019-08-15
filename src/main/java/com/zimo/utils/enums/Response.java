package com.zimo.utils.enums;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/8/5,5:02 PM
 */
public enum Response {
    SUCCESS(1,"success"),
    FAIL(2,"fail")
    ;
    private ResponseResult result;

    Response(Integer id,String msg) {
        result = new ResponseResult();
        result.setId(id);
        result.setMsg(msg);
    }

    public ResponseResult getResult() {
        return result;
    }
}
