package com.zimo.utils.dao;

import com.zimo.utils.mapper.UserAuthMapper;
import com.zimo.utils.model.UserAuth;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zi.mo
 * @description
 * @createTime 2019/9/23,6:00 PM
 */
@Component
public class UserAuthDao {

    @Resource
    private UserAuthMapper userAuthMapper;



    public void save(UserAuth userAuth){
        userAuthMapper.insert(userAuth);
    }

    public void update(UserAuth userAuth){
        userAuthMapper.update(userAuth);
    }
}
