package cn.zimo.wbq.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String getRandom(int num){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,num);
    }

    public static String get32Random(){
        return UUIDUtil.getRandom(32);
    }
}
