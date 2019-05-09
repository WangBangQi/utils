package cn.zimo.wbq.exceptions;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/28,10:47 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class SystemException extends ErrCodeException {
    public SystemException(Integer code, String message) {
        super(code, message);
    }

    public static SystemException SYSTEM_ERR = new SystemException(Code.SYSTEM_ERR,"系统错误");
}
