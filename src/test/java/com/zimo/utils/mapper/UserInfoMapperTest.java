package com.zimo.utils.mapper;

import com.zimo.utils.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {
    @SuppressWarnings("all")
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void addUserInfo() throws Exception {
//        userInfoMapper.addUserInfo(new UserInfo(null,10,"aag","agag"));
        userInfoMapper.addUserInfo_2("agag",33333,"agagagg");
    }

}