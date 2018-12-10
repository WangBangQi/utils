package cn.zimo.wbq.Sms;


import cn.zimo.wbq.Sms.contains.SmsContains;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


public abstract class SmsBaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static final RestTemplate rest;
    private static final int readTimeout = 5000;
    private static final int connectionTimeout = 3000;
    /**
     * 计算验证码
     */
    private static final int codeLength;
    private static final int origin;
    private static final int bound;

    private static final Random _r = new Random();

    public SmsBaseService() {
        init();
    }

    static {
        codeLength = SmsContains.codeLength;
        origin = (int) Math.pow(10,codeLength-1);
        bound = (int) Math.pow(10,codeLength);
        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(readTimeout);
        httpRequestFactory.setConnectTimeout(connectionTimeout);
        rest = new RestTemplate(httpRequestFactory);

    }

    protected abstract String getName();
    protected abstract void  init();
    protected abstract SmsResult send(String phone);
    protected abstract SmsResult send(String phone,String content);

    /**
     * 获取验证码
     * @return
     */
    public int getRandom(){
        return _r.nextInt(bound - origin) + origin;
    }
}
