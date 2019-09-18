package com.zimo.utils.maps.gaode;

import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/18,2:24 PM
 */
public class GeoResponse {
    /**
     * 返回值为 0 或 1，0 表示请求失败；1 表示请求成功。
     */
    private String status;
    /**
     *返回结果的个数。

     */
    private String count;
    /**
     * 当 status 为 0 时，info 会返回具体错误原因，否则返回“OK”。详情可以参阅info状态表
     */
    private String info;
    /**
     * 地理编码信息列表,结果对象列表
     */

    private List<GeoCode> gecodes;

    public static class GeoCode {

        /**
         * 结构化地址信息  省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
         */
        private String formatted_address;

        /**
         * 国家
         */
        private String country;

        /**
         * 地址所在的省份名 例如：北京市。此处需要注意的是，中国的四大直辖市也算作省级单位。
         */
        private String province;

        /**
         * 城市，地址所在城市，例如：北京市
         */
        private String city;

        /**
         * 城市编码
         */
        private String citycode;

        /**
         * 地址所在的区 例如：朝阳区
         */
        private String district;

        /**
         * 街道
         */
        private String street;

        /**
         * 门牌号
         */
        private String number;

        /**
         * 区域编码
         */
        private String adcode;

        /**
         * 坐标点  经度，纬度
         */
        private String location;

        /**
         * 匹配等级
         */
        private String level;

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

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

        public String getCitycode() {
            return citycode;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<GeoCode> getGecodes() {
        return gecodes;
    }

    public void setGecodes(List<GeoCode> gecodes) {
        this.gecodes = gecodes;
    }
}
