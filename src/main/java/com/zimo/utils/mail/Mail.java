package com.zimo.utils.mail;

/**
 * @author 子墨
 * @version 1.0.0
 */
public interface Mail {
    /**
     * set title of mail
     * @param title 标题
     */
    void setTitle(String title);

    /**
     * send mail to one person
     * @param toMail 接受对象
     * @param msg 内容
     */
    void sendText(String toMail,String msg);

    /**
     * send mail to person who in array toMails
     * @param toMails 接受对象
     * @param msg 内容
     */
    void sendText(String[] toMails,String msg);
}
