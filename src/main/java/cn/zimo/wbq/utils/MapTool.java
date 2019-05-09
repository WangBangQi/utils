package cn.zimo.wbq.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/5/9,5:11 PM
 * @updateAuthor
 * @updateTime
 * @updateDesc
 */
public class MapTool extends HashMap<String,Object>{

    @Override
    public MapTool put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static MapTool map(){
        return new MapTool();
    }
}
