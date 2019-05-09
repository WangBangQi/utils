package cn.zimo.wbq.utils;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/9,5:19 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class DistanceUtils {
    private static final double EARTH_RADIUS = 6378137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 返回的是单位为 m 的 double 数据
     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
}
