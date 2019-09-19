package com.zimo.utils.maps.gaode;

import cn.zimo.wbq.http.HttpResponse;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,4:35 PM
 */
public abstract class GdMapResponse extends HttpResponse {


    /**
     * 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。
     */
    private String status;

    /**
     * 当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”。详情可以参阅info状态表
     */
    private String info;

    /**
     * 错误编码
     */
    private String infocode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public boolean isSuccess(){
        return status !=null && "1".equals(status);
    }
}
