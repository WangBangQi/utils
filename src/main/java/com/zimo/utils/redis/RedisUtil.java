package com.zimo.utils.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/8/22,10:31 AM
 */
@Component
public class RedisUtil {


    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    /**
     * 判断 message 是否已经push
     * @param messageId 要查询的 message 的唯一标识
     * @return 已经 Push 返回 <code>true</code>,否则返回 <code>false</code>
     */
    public boolean isMessagePushed(String messageId){
        //实现，通过 Lua 保证逻辑的原子性

        Assert.notNull(messageId,"消息 ID 不能为空");

        //使用 Lua 脚本去检查

        String script = "if redis.call('get', KEYS[1]) == false then redis.call('set', KEYS[1], ARGV[1]) redis.call('expire', KEYS[1], ARGV[2]) return 0 else return 1 end";

        // 这里使用Long类型，查看源码可知脚本返回值类型只支持Long, Boolean, List, or deserialized value type.
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(script);
        redisScript.setResultType(Long.class);

        //设置 KEY
        List<String> keyList = new ArrayList<>();
        // key为消息ID
        keyList.add(messageId);

        // 每个键的失效时间为20秒
        Long result = redisTemplate.execute(redisScript, keyList, 1, 20);

        // 返回true: 已读、false: 未读
        return result != null && result != 0L;
    }



}
