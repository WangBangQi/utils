package com.zimo.utils.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * mail class of 163
 * @author 子墨
 * @version 1.0
 */
public class Mail163 implements Mail{

    private static Logger log = LoggerFactory.getLogger(Mail163.class);

    private static Mail163 instance = null;

    private Mail163() {
    }

    private final String FROM_MAIL_NAME = "m13173638162";
    private final String FROM_MAIL = "m13173638162@163.com"; //发送者的邮箱，mail address of sender
    private final String MAIL_PASSWORD = "haoliyou123123";   //发送者的邮箱密码 password of mail
    private final String MAIL_163_HOST = "smtp.163.com";     //邮件服务器host  mail server host
    private String MAIL_TITLE =  "Mail163 测试";       //标题 title of mail
    private Session session = Session.getDefaultInstance(get163MailProperties());

    @Override
    public void sendText(String toMail, String msg){
        try {
            Address[] mails = new Address[]{new InternetAddress(toMail)};
            MimeMessage message = create163MailMimeMessage(session,msg,mails);
            this.sendToMany(session,message);
            log.info("send mail success");
        }catch (MessagingException e){
            e.printStackTrace();
            log.error("发送邮件失败：",e);
        }
    }

    @Override
    public void sendText(String[] toMails, String msg) {
        try {
            Address[] mails = new Address[toMails.length];
            for (int i=0;i<toMails.length;i++) {
                mails[i] = new InternetAddress(toMails[i]);
            }
            MimeMessage message = create163MailMimeMessage(session,msg,mails);
            this.sendToMany(session,message);
            log.info("send many mail success");
        }catch (MessagingException e){
            e.printStackTrace();
            log.error("发送邮件失败：",e);
        }
    }

    @Override
    public void setTitle(String title){
        this.MAIL_TITLE = title;
    }

    public static Mail163 getInstance() {
        if (instance==null){
            synchronized (Mail163.class){
                if (instance==null)
                    instance =  new Mail163();
            }
        }
        return instance;
    }
    private Properties get163MailProperties(){
        //设置邮件服务器
        Properties properties = System.getProperties();
        properties.setProperty("mail.host", MAIL_163_HOST);
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        return properties;
    }

    /**
     * @param session mail session
     * @param text  news of mail
     * @param toMails array of mail
     * @return 返回MimeMessage 对象，对象实体
     * @throws MessagingException
     */
    private MimeMessage create163MailMimeMessage(Session session, String text,Address[] toMails)throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        //消息文本
//      message.setContent(msg,"text/plain");
        message.setText(text);
        //邮件主题
        message.setSubject(MAIL_TITLE);
        //发送人
        message.setFrom(new InternetAddress(FROM_MAIL));
        //收信人
        message.setRecipients(Message.RecipientType.TO,toMails);
        return message;
    }

    private void sendToMany(Session session,MimeMessage message)throws MessagingException{
        Transport ts = session.getTransport();
        ts.connect(MAIL_163_HOST,FROM_MAIL_NAME,MAIL_PASSWORD);
        ts.sendMessage(message,message.getAllRecipients());
        ts.close();
    }
}
