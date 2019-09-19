package com.zimo.utils.maps.gaode;

import java.util.List;

/**
 * @author zi.mo
 * @description 逆编码返回对象
 * @createTime 2019/9/18,2:33 PM
 */
public class ReGeoResponse extends GdMapResponse{

    /**
     * 地理编码信息列表,结果对象列表
     */
    private List<ReGeoCode> regeocodes;

    private ReGeoCode regeocode;

    public List<ReGeoCode> getRegeocodes() {
        return regeocodes;
    }

    public void setRegeocodes(List<ReGeoCode> regeocodes) {
        this.regeocodes = regeocodes;
    }

    public ReGeoCode getRegeocode() {
        return regeocode;
    }

    public void setRegeocode(ReGeoCode regeocode) {
        this.regeocode = regeocode;
    }


    public static class ReGeoCode {
        /**
         * 结构化地址信息
         * 结构化地址信息包括：省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
         * 如果坐标点处于海域范围内，则结构化地址信息为：省份＋城市＋区县＋海域信息
         */
        private String formatted_address;

        /**
         * 地址元素对象
         */
        private AddressComponent addressComponent;


        public static class AddressComponent{

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
             * 区域编码
             */
            private String adcode;
            /**
             * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息）
             */
            private String township;
            /**
             * 乡镇街道编码
             */
            private String towncode;

            private Neighborhood neighborhood;

            private Building building;

            /**
             * 门牌信息对象
             */
            private StreetNumber streetNumber;

            public static class Neighborhood{
                /**
                 * 社区名称
                 */
                private String name;
                /**
                 * POI类型
                 */
                private String type;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }

            public static class Building{
                private String name;
                private String type;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }

            public static class StreetNumber{
                private String street;
                private String number;
                private String location;
                private String direction;
                private String distance;

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

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDistance() {
                    return distance;
                }

                public void setDistance(String distance) {
                    this.distance = distance;
                }
            }

            public StreetNumber getStreetNumber() {
                return streetNumber;
            }

            public void setStreetNumber(StreetNumber streetNumber) {
                this.streetNumber = streetNumber;
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

            public String getAdcode() {
                return adcode;
            }

            public void setAdcode(String adcode) {
                this.adcode = adcode;
            }

            public String getTownship() {
                return township;
            }

            public void setTownship(String township) {
                this.township = township;
            }

            public String getTowncode() {
                return towncode;
            }

            public void setTowncode(String towncode) {
                this.towncode = towncode;
            }

            public Neighborhood getNeighborhood() {
                return neighborhood;
            }

            public void setNeighborhood(Neighborhood neighborhood) {
                this.neighborhood = neighborhood;
            }

            public Building getBuilding() {
                return building;
            }

            public void setBuilding(Building building) {
                this.building = building;
            }
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public AddressComponent getAddressComponent() {
            return addressComponent;
        }

        public void setAddressComponent(AddressComponent addressComponent) {
            this.addressComponent = addressComponent;
        }
    }
}
