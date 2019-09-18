package com.zimo.utils.ddd;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/4,4:05 PM
 */
public class ValidatorNotificationHandle {

    protected String msg;

    public ValidatorNotificationHandle() {
    }


    public void handleError(String msg){
        this.setMsg(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
