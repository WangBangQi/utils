package com.zimo.utils.controller;

import cn.zimo.wbq.utils.RedisKeyGenerationUtils;
import cn.zimo.wbq.utils.RedisUtils;
import com.zimo.utils.model.User;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
public class RedisController {


    @RequestMapping("/redis")
    public void test(){
        String key = RedisKeyGenerationUtils.keyGenerationByClassAndId(User.class,15l);
        String value = "测试用户";
        RedisUtils.saveString(key,value);
//        Assert.assertEquals("不相等",RedisUtils.getString(key),value);

        User user = new User();
        user.setUserName("哈哈");
        user.setUserId(135);
        String key2 = RedisKeyGenerationUtils.keyGenerationByClassAndMethodAndUniqueParam(User.class,"getUserInfo",user.getUserId().toString());
        User getValue= RedisUtils.get(key2);
        System.out.println("getValue"+getValue);
//        Assert.assertNotNull("缓存不为空",getValue);
//        Assert.assertEquals("值比较不对",getValue.getUserName(),user.getUserName());
//        Assert.assertEquals("值比较不对",getValue.getUserId(),user.getUserId());
    }
}
