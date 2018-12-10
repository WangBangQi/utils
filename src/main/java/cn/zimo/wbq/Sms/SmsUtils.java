package cn.zimo.wbq.Sms;

import cn.zimo.wbq.Sms.contains.SmsEnum;
import cn.zimo.wbq.Sms.wy.WySmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SmsUtils {

    private static final Logger log = LoggerFactory.getLogger(SmsUtils.class);

    public static SmsResult send(String phone){
        SmsBaseService smsBaseService = getSmsService(SmsEnum.WY);
        return smsBaseService.send(phone);
    }

    private static SmsBaseService getSmsService(SmsEnum smsEnum){
        if (SmsEnum.WY.equals(smsEnum))
            return new WySmsService();
        return null;
    }

}
