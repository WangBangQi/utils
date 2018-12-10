package com.zimo.utils.sql_provider;

import org.apache.ibatis.annotations.Param;

public class UserSqlProvider {
    String allColumns = "user_id,user_name,password,head_pic";
    String table  = "t_user";

    public String searchByName(@Param("userName") String userName){
        return "select * from t_user where user_name like #{userName}";
    }

    public String searchByNamePage(@Param("userName") String userName,
                                   @Param("start")Integer start,
                                   @Param("end")Integer end){
        return "select "+allColumns+" from " + table +" where user_name like #{userName} limit #{start},#{end}";
    }

    public String addUser(@Param("userName")String userName,@Param("password")String password,@Param("headPic")String headPic){
        return "insert into t_user (USER_NAME,PASSWORD,HEAD_PIC)values(#{userName},#{password},#{headPic})";
    }
}


