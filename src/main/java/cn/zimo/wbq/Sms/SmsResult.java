package cn.zimo.wbq.Sms;

import java.io.Serializable;

public class SmsResult implements Serializable {
    private static final long serialVersionUID = 7359736771270896525L;

    private String msg;
    private boolean success = false;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
