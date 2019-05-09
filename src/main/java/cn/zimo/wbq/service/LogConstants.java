package cn.zimo.wbq.service;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/5,2:20 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class LogConstants {

    private static boolean openDebug = false;

    private static boolean openInfo = false;

    private static boolean openWarn = false;

    public static boolean isOpenDebug() {
        return openDebug;
    }

    public static void setOpenDebug(boolean openDebug) {
        LogConstants.openDebug = openDebug;
    }

    public static boolean isOpenInfo() {
        return openInfo;
    }

    public static void setOpenInfo(boolean openInfo) {
        LogConstants.openInfo = openInfo;
    }

    public static boolean isOpenWarn() {
        return openWarn;
    }

    public static void setOpenWarn(boolean openWarn) {
        LogConstants.openWarn = openWarn;
    }
}
