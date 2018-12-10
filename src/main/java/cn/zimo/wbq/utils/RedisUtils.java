package cn.zimo.wbq.utils;

import io.lettuce.core.RedisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


public class RedisUtils {
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);
    private static final Integer HOUR_CACHE_TIME = 3600;
    private static final Integer DAY_CACHE_TIME = 3600*24;


    private static ValueOperations<String,String> valueOperations = SpringUtils.getBean(ValueOperations.class);

    public static void save(String key,Object value){
        save(key,value,HOUR_CACHE_TIME);
    }

    public static void save(String key,Object value,long expired){
        if (key!=null && value!=null) {
            try {
                valueOperations.getOperations().restore(key,SerializeUtils.serialize(value),expired,TimeUnit.SECONDS);
            } catch (Throwable t) {
                log.error("redis保存失败,key=",key,t);
                throw new RedisException(t);
            }
        }
    }


    /**
     * 缓存字符串，过期时间一个小时
     * @param key
     * @param value
     */
    public static void saveString(String key,String value){
        saveString(key,value,HOUR_CACHE_TIME);
    }

    /**
     * 保存字符串，没有过期时间
     * @param key
     * @param value
     */
    public static void saveStringNoExp(String key,String value){
        if (key!=null && value!=null){
            try {
                valueOperations.set(key,value);
            }catch (Throwable t){
                log.error("redis保存失败,key=",key,t);
                throw new RedisException(t);
            }
        }
    }

    /**
     * 保存字符串，有过期时间
     * @param key
     * @param value
     * @param expired
     */
    public static void saveString(String key,String value,long expired){
        if (key!=null && value!=null) {
            try {
                valueOperations.set(key, value,expired, TimeUnit.SECONDS);
            }catch (Throwable t){
                log.error("redis保存失败,key=",t);
                throw new RedisException(t);
            }
        }
    }

    public static void del(String key){
        try {
            valueOperations.getOperations().delete(key);
        }catch (Throwable t){
            log.error("redis删除缓存失败,key=",key,t);
            throw new RedisException(t);
        }
    }

    public static <T> T get(String key){
        try {
            byte[] o = valueOperations.getOperations().dump(key);
            return o==null? null : (T)SerializeUtils.unSerialize(o);
        }catch (Throwable t){
            log.error("获取缓存失败，key={}",key,t);
            throw new RedisException(t);
        }
    }
    public static String getString(String key){
        try {
            return valueOperations.get(key);
        }catch (Throwable t){
            log.error("获取缓存失败，key=",key,t);
            throw new RedisException(t);
        }
    }

}
