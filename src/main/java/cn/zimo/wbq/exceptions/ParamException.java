package cn.zimo.wbq.exceptions;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/3/28,10:30 AM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ParamException extends ErrCodeException{

    public ParamException(Integer code, String message) {
        super(code, message);
    }

    public static final ParamException PARAM_ERR = new ParamException(Code.PARAM_ERR,"参数错误");
}
