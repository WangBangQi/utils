package com.zimo.utils.model;

import java.util.Date;

/**
 * @author zi.mo
 * @description 用户登录表实体表
 * @createTime 2019/9/23,5:20 PM
 */
public class UserAuth {

    private Long id;

    private String account;

    private String password;

    private String loginInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    public static class LoginInfo {
        private String ip;
        private Date loginTime;
        private String result;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Date getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Date loginTime) {
            this.loginTime = loginTime;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
