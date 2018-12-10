package com.zimo.utils.mapper;

import com.zimo.utils.model.User;
import com.zimo.utils.sql_provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "headPic" ,column = "HEAD_PIC"),
    })
    @Select(value = "SELECT * FROM t_user")
    List<User> list();

    @Results({
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "userName", column = "USER_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "headPic" ,column = "HEAD_PIC"),
    })
    @Select(value = "select * from t_user where user_id = #{userId}")
    User searchById(@Param("userId") Integer userId);

    @SelectProvider(type = UserSqlProvider.class,method = "searchByName")
    List<User> searchByName(@Param("userName") String userName);

    @SelectProvider(type = UserSqlProvider.class,method = "searchByNamePage")
    List<User> searchByNamePage(@Param("userName")String userName,
                                @Param("start")Integer start,
                                @Param("end")Integer end);

    @Insert(value = "insert into t_user (USER_NAME,PASSWORD,HEAD_PIC)values(#{userName},#{password},#{headPic})")
    void addUser(@Param("userName")String userName,@Param("password")String password,@Param("headPic") String headPic);

    @SelectProvider(type = UserSqlProvider.class,method = "addUser")
    void addUser_2(@Param("userName")String userName,@Param("password")String password,@Param("headPic")String headPic);


    @Select(value = "SELECT count(user_id) from t_user where user_name like #{userName} and head_pic like #{headPic} ")
    int countByParam(@Param("userName")String userName,@Param("headPic")String headPic);

    @Select(value = "SELECT count(*) from t_user where user_name like #{userName} and head_pic like #{headPic} ")
    int countAll(@Param("userName")String userName,@Param("headPic")String headPic);

}
