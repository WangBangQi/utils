package com.zimo.utils.maps.gaode;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/19,4:44 PM
 */
public class FixedPositionThroughIpResponse extends GdMapResponse {

    /**
     * 省份名称  若为直辖市则显示直辖市名称；如果在局域网 IP网段内，则返回“局域网”；非法IP以及国外IP则返回空
     */
    private String province;

    /**
     * 城市名称   若为直辖市则显示直辖市名称；如果为局域网网段内IP或者非法IP或国外IP，则返回空
     */
    private String city;

    /**
     * 城市的 adcode 编码
     */
    private String adcode;

    /**
     * 所在城市矩形范围区域
     */
    private String rectangle;


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getRectangle() {
        return rectangle;
    }

    public void setRectangle(String rectangle) {
        this.rectangle = rectangle;
    }
}
