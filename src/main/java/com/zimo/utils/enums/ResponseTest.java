package com.zimo.utils.enums;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/8/5,5:04 PM
 */
public enum ResponseTest {
    SUCCESS(1,"success"),
    FAIL(2,"fail")
    ;

    ResponseTest(Integer id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
