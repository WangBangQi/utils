package cn.zimo.wbq.utils;

import java.util.Collections;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/9,5:04 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class ListUtils {

    public static boolean isEmpty(List list){
        if (list == null || list.size() ==0) return true;
        return false;
    }

    public static boolean isNotEmpty(List list){
        return !isEmpty(list);
    }

    public static List getEmptyList(){
        return Collections.EMPTY_LIST;
    }

}
