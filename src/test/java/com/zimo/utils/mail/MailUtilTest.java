package com.zimo.utils.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailUtilTest {

    @Test
    public void send() throws Exception {
        MailUtil.send("wbq@xiyoukeji.com");
    }

}