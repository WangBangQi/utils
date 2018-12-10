package cn.zimo.wbq.utils;

import com.zimo.utils.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class RedisUtilsTest {

    @Test
    public void save()throws Exception{
        String key = RedisKeyGenerationUtils.keyGenerationByClassAndId(User.class,15l);
        String value = "测试用户";
        RedisUtils.saveString(key,value);
        Assert.assertEquals("不相等",RedisUtils.getString(key),value);

        User user = new User();
        user.setUserName("哈哈");
        user.setUserId(135);
        String key2 = RedisKeyGenerationUtils.keyGenerationByClassAndMethodAndUniqueParam(User.class,"getUserInfo",user.getUserId().toString());
        User getValue= RedisUtils.get(key2);
        Assert.assertNotNull("缓存不为空",getValue);
        Assert.assertEquals("值比较不对",getValue.getUserName(),user.getUserName());
        Assert.assertEquals("值比较不对",getValue.getUserId(),user.getUserId());
    }
}