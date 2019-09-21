package com.zimo.utils.config;


import java.io.Serializable;

/**
 * @author XLY
 * @remark 响应类
 */
public class Result implements Serializable{

    private static final long serialVersionUID = -3445944192568629336L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 包含数据
     */
    private Object data;

    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
