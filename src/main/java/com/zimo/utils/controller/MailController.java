package com.zimo.utils.controller;

import com.zimo.utils.mail.Mail;
import com.zimo.utils.mail.Mail163;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MailController {

    Mail mail = Mail163.getInstance();

    /**
     * @author 作者
     * @param toMail
     * @param data  内容
     * @return
     */
    @RequestMapping(value = "/v1/mail/send",method = RequestMethod.POST)
    public Map sendMail(@RequestParam("toMail")String toMail,
                        @RequestParam("data")String data){
        mail.sendText(toMail,data);
        Map map = new HashMap();
        map.put("code",100);
        map.put("msg","success");
        return map;
    }
}
