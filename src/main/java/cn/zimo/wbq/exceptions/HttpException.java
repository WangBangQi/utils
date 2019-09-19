package cn.zimo.wbq.exceptions;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/28,10:48 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class HttpException extends ErrCodeException {

    public HttpException() {
        super(Code.HTTP_ERR,"网络连接错误");
    }

    public HttpException(Integer code, String message) {
        super(code, message);
    }

    public HttpException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
