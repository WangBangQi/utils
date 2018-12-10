package com.zimo.utils.model;

public class UserInfo {
    private Integer userInfoId;
    private Integer userId;
    private String headPic;
    private String desc;

    public UserInfo(Integer userInfoId, Integer userId, String headPic, String desc) {
        this.userInfoId = userInfoId;
        this.userId = userId;
        this.headPic = headPic;
        this.desc = desc;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
