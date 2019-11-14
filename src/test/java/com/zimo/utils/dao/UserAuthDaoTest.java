package com.zimo.utils.dao;

import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.model.UserAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;


/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/23,6:03 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAuthDaoTest {

    @Resource
    private UserAuthDao userAuthDao;

    @Test
    public void save()  throws Exception {
        for (int i = 100;i<1000;i++){
            String index = "00" + i;
            index = index.substring(index.length()-3,index.length());
            addNew(index);
        }

    }

    private void addNew(String index){
        UserAuth userAuth = new UserAuth();
        userAuth.setAccount("13173638162"+index);
        userAuth.setPassword("aa111111");
        UserAuth.LoginInfo loginInfo = new UserAuth.LoginInfo();
        loginInfo.setIp("133.14.414.12"+index);
        loginInfo.setLoginTime(new Date());
        loginInfo.setResult("success");

        userAuth.setLoginInfo(JSONObject.toJSONString(loginInfo));
        userAuthDao.save(userAuth);
    }

    @Test
    public void update() throws Exception {
    }

}