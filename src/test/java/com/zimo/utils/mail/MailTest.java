package com.zimo.utils.mail;

import javafx.scene.media.MediaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    //           http://help.163.com/09/1224/17/5RAJ4LMH00753VB8.html
//      出错误时的返回
    @Test
    public void sendText() throws Exception {
       Mail mail = Mail163.getInstance();
       mail.setTitle("我的主题是真的");
       String[] toMails = new String[]{"1597176979@qq.com","wbq@xiyoukeji.com","m13173638162@163.com"};
       String msg = "你的验证码是 JSKHG,或者你要的连接为 www.baidu.com";
       for (int i=0;i<100;i++) {
           new Thread(new Runnable() {
               @Override
               public void run() {
                   mail.sendText("m13173638162@163.com", msg);
                   mail.sendText("wbq@xiyoukeji.com", msg);
               }
           }).start();
           //加上延迟，不然会导致发送失败。频繁发送
           Thread.sleep(2*1000);

       }
//       mail.sendText(toMails,msg);
//       sendMany(mail,toMails,msg);
//       sendToOne(mail,toMails,msg);

    }

    private void  sendMany(Mail mail,String[] toMails,String msg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mail.sendText(toMails,msg+"many");
            }
        }).start();
    }
    private void sendToOne(Mail mail,String[] toMails,String msg){
        for (String to:toMails){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mail.sendText(to,msg);
                }
            }
            ).start();
        }
    }


}