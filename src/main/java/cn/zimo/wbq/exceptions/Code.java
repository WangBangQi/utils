package cn.zimo.wbq.exceptions;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/28,10:10 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public final class Code {

    /**
     * 请求成功的返回码
     */
    public static final int SUCCESS = 0;

    //系统错误
    public static final int SYSTEM_ERR = 99999;


    /**
     * ******************************************************************
     * 通用的错误码 10000~19999
     */

    //access token 无效
    public static final int ACCESS_TOKEN_ERR = 10000;

    // refresh token 无效
    public static final int REFRESH_TOKEN_ERR = 10001;

    // 无权限
    public static final int ACCESS_DENIED = 10002;

    //访问受限
    public static final int ACCESS_LIMIT = 10003;

    //没有找到对象
    public static final int CAN_NOT_FOUND_OBJECT = 10004;

    //文件错误
    public static final int FILE_ERR = 10005;

    //网络连接错误
    public static final int HTTP_ERR = 10006;

    //账号在别处登录
    public static final int KICKED_OUT = 10007;

    //需要验证
    public static final int NEED_VERIFY = 10008;

    //未登录
    public static final int NOT_LOGIN = 10009;

    //参数错误
    public static final int PARAM_ERR = 10010;

    //支付错误
    public static final int PAY_ERR = 10011;

    //内部服务调用异常
    public static final int SERVICE_ERR = 10012;

    //密码错误
    public static final int PASSWORD_ERR = 10013;

    //被禁用
    public static final int DISABLE = 10014;
}
