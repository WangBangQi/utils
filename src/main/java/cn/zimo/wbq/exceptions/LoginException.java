package cn.zimo.wbq.exceptions;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/28,10:25 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class LoginException extends ErrCodeException {

    public LoginException(Integer code, String message) {
        super(code, message);
    }

    public static LoginException TOKEN_ERR = new LoginException(Code.ACCESS_TOKEN_ERR,"accessToken 错误");

    public static LoginException REFRESH_TOKEN_ERR = new LoginException(Code.REFRESH_TOKEN_ERR,"refreshToken 错误");

    public static LoginException NEED_LOGIN = new LoginException(Code.NOT_LOGIN,"未登录");

    public static LoginException KICKED_OUT = new LoginException(Code.KICKED_OUT,"账号在别处登录");
}
