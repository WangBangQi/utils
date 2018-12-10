package com.zimo.utils.mail;

import java.util.Properties;

public class MailAli implements Mail {

    private static final String ALIDM_SMTP_HOST = "smtpdm.aliyun.com";
    private static final String ALIDM_SMTP_PORT = "25";//或"80"



    @Override
    public void setTitle(String title) {

    }

    @Override
    public void sendText(String toMail, String msg) {

    }

    @Override
    public void sendText(String[] toMails, String msg) {

    }


    private Properties getMailAliProperties(){
        // 配置发送邮件的环境属性
        //设置邮件服务器
        Properties props = System.getProperties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // props.put("mail.smtp.socketFactory.port", "465");
        // props.put("mail.smtp.port", "465");
        return props;
    }

}
