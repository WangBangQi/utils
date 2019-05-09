package cn.zimo.wbq.utils;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/9,4:45 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class StringUtils {

    public static boolean isNotBlank(String str){
        if (str == null || str.length()==0) return false;
        return true;
    }

    public static boolean isBlank(String str){
        return !isNotBlank(str);
    }

    public static boolean isEmpty(Object o){
        if ( o == null) return true;
        return false;
    }

    public static boolean isNotEmpty(Object o){
        return !isEmpty(o);
    }

    public static boolean isNotEmpty(Object ... args){
        for (Object o : args){
            if (isEmpty(o)) return false;
        }
        return true;
    }
}
