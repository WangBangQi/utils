package com.zimo.utils.mapper;

import com.zimo.utils.model.UserInfo;
import com.zimo.utils.sql_provider.UserInfoSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface UserInfoMapper {

    @SelectProvider(type = UserInfoSqlProvider.class,method = "addUserInfo")
    void addUserInfo(UserInfo userInfo);


    @Select(value = "INSERT INTO user_info (user_id,head_pic,desc)VALUES(#{userId},#{headPic},#{desc})")
    void addUserInfo_2(@Param("headPic")String headPic,
                       @Param("userId")Integer userId,
                       @Param("desc")String desc);
}
