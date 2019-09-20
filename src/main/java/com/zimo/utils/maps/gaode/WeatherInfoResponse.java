package com.zimo.utils.maps.gaode;

import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/19,6:24 PM
 */
public class WeatherInfoResponse extends GdMapResponse {

    /**
     *  实况天气数据
     */
    private List<Live> lives;

    /**
     * 预报天气数据
     */
    private List<Forecast> forecasts;

    public List<Live> getLives() {
        return lives;
    }

    public void setLives(List<Live> lives) {
        this.lives = lives;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    /**
     * 实况天气预报
     */
    public static class Live{
        /**
         * 省份
         */
        private String province;

        private String city;

        private String adcode;

        /**
         * 天气现象 （汉字描述）
         */
        private String weather;

        private String temperature;

        /**
         * 风向描述
         */
        private String winddirection;

        /**
         * 风力级别  单位：级
         */
        private String windpower;

        /**
         * 空气湿度
         */
        private String humidity;

        /**
         * 数据发布的时间
         */
        private String reporttime;

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

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWinddirection() {
            return winddirection;
        }

        public void setWinddirection(String winddirection) {
            this.winddirection = winddirection;
        }

        public String getWindpower() {
            return windpower;
        }

        public void setWindpower(String windpower) {
            this.windpower = windpower;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getReporttime() {
            return reporttime;
        }

        public void setReporttime(String reporttime) {
            this.reporttime = reporttime;
        }
    }


    /**
     * 预报天气数据
     */
    public static class Forecast {


        private String city;

        private String adcode;
        /**
         * 省份
         */
        private String province;

        private String reporttime;

        /**
         * 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据
         */
        private List<Cast> casts;


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

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getReporttime() {
            return reporttime;
        }

        public void setReporttime(String reporttime) {
            this.reporttime = reporttime;
        }

        public List<Cast> getCasts() {
            return casts;
        }

        public void setCasts(List<Cast> casts) {
            this.casts = casts;
        }

        /**
         * 预报数据
         */
        public static class Cast{
            private String date;
            private String week;
            /**
             * 白天天气现象
             */
            private String dayweather;
            private String nightweather;
            /**
             * 白天温度
             */
            private String daytemp;
            private String nighttemp;
            /**
             * 白天风向
             */
            private String daywind;
            private String nightwind;
            /**
             * 白天风力
             */
            private String daypower;
            private String nightpower;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getDayweather() {
                return dayweather;
            }

            public void setDayweather(String dayweather) {
                this.dayweather = dayweather;
            }

            public String getNightweather() {
                return nightweather;
            }

            public void setNightweather(String nightweather) {
                this.nightweather = nightweather;
            }

            public String getDaytemp() {
                return daytemp;
            }

            public void setDaytemp(String daytemp) {
                this.daytemp = daytemp;
            }

            public String getNighttemp() {
                return nighttemp;
            }

            public void setNighttemp(String nighttemp) {
                this.nighttemp = nighttemp;
            }

            public String getDaywind() {
                return daywind;
            }

            public void setDaywind(String daywind) {
                this.daywind = daywind;
            }

            public String getNightwind() {
                return nightwind;
            }

            public void setNightwind(String nightwind) {
                this.nightwind = nightwind;
            }

            public String getDaypower() {
                return daypower;
            }

            public void setDaypower(String daypower) {
                this.daypower = daypower;
            }

            public String getNightpower() {
                return nightpower;
            }

            public void setNightpower(String nightpower) {
                this.nightpower = nightpower;
            }
        }

    }
}
