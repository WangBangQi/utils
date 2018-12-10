package cn.zimo.wbq.Sms.wy;

import cn.zimo.wbq.Sms.SmsBaseService;
import cn.zimo.wbq.Sms.SmsResult;
import cn.zimo.wbq.Sms.contains.SmsContains;
import cn.zimo.wbq.utils.UUIDUtil;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;

public class WySmsService extends SmsBaseService {

    //发送验证码的请求路径URL
    private String SERVER_URL;
    private String VERIFY_CODE_URL;
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private String APP_KEY;
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private String APP_SECRET;
    //随机数
    private String NONCE;
    //短信模板ID
    private String TEMPLATEID;
    //验证码长度，范围4～10，默认为4,这里不知道需不需要传递验证码给
    private String CODELEN;

    @Override
    protected String getName() {
        return "网易云信短信接口";
    }

    @Override
    protected void init() {
        SERVER_URL = SmsContains.WY_SERVER_URL;
        VERIFY_CODE_URL = SmsContains.WY_VERIFY_CODE_URL;
        APP_KEY = SmsContains.WY_APP_KEY;
        APP_SECRET = SmsContains.WY_APP_SECRET;
        TEMPLATEID = SmsContains.WY_TEMPLATE_ID;
        NONCE = UUIDUtil.getRandom(32);
        CODELEN = String.valueOf(SmsContains.codeLength);
    }

    @Override
    protected SmsResult send(String phone) {
        Long curTime = System.currentTimeMillis();
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET,NONCE,curTime.toString());
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        headers.add("AppKey", APP_KEY);
        headers.add("Nonce", NONCE);
        headers.add("CurTime", checkSum + "");
        headers.add("CheckSum", checkSum);

        params.add("mobile", phone);
        params.add("templateid", TEMPLATEID);
        String randomCode = getRandom()+"";
        params.add("authCode", randomCode);
//        params.add("codeLen",CODELEN);
        HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity<>(params,headers);
        WySMSResult res = null;
        try {
            res = rest.postForObject(SERVER_URL,requestEntity,WySMSResult.class);
        }catch (Throwable t){
            logger.error("{} 使用【{}】短信接口发送失败",phone,getName(),t);
        }
        SmsResult sms = new SmsResult();
        if (res==null){
            return sms;
        }
        sms.setMsg(res.getMsg());
        if (res.isSuccess()){
            sms.setSuccess(true);
            sms.setCode(randomCode);
            logger.info("{} 使用【{}】短信接口发送成功,验证码为{}",phone,getName(),randomCode);
        } else {
            logger.error("{} 使用【{}】短信接口发送失败",phone,getName(),res.getMsg());
        }
        return sms;
    }

    @Override
    protected SmsResult send(String phone, String content) {
        return null;
    }

    public static class WySMSResult implements Serializable{
        private static final long seraialVersionID = 1l;
        private static final int SUCCESS = 200;

        private int code;
        private String msg;
        private String obj;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getObj() {
            return obj;
        }

        public void setObj(String obj) {
            this.obj = obj;
        }
        public boolean isSuccess(){
            return SUCCESS == code;
        }
    }




}
