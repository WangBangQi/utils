package com.zimo.utils.sql_provider;

import com.zimo.utils.model.UserInfo;


public class UserInfoSqlProvider {

    public String addUserInfo(UserInfo userInfo){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into user_info ( ");
        stringBuilder.append(" head_pic,desc,user_id ) values (");
        stringBuilder.append(" #{headPic},#{desc},#{userId})");
        return stringBuilder.toString();
    }
}
