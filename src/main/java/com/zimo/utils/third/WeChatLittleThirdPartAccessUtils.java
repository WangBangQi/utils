package com.zimo.utils.third;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zimo.utils.utils.RestApiUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

/**
 * 微信小程序登录
 */
public class WeChatLittleThirdPartAccessUtils {
    private static Logger log = LoggerFactory.getLogger(WeChatLittleThirdPartAccessUtils.class);
    private static final String APPID = "wxd7338db4092dfc6f";
    private static final String SECRET = "9221a4a72308a094b864310f5d6e5e53";

    public static ThirdPartEntity weChatGetAccessAndOpenIdByCode(String code, String encryptedData, String iv) {
        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=").append(APPID).append("&");
        url.append("secret=").append(SECRET).append("&");
        url.append("js_code=").append(code).append("&");
        url.append("grant_type=").append("authorization_code").append("&");
        String result = (String) RestApiUtil.getForObject(url.toString(), null, String.class);
        try {
            System.out.println(result.getBytes());
            result = new String(result.getBytes("ISO-8859-1"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String openId = jsonObject.getString("openid");
        String session_key = jsonObject.getString("session_key");
        String unionId = jsonObject.getString("unionid");

        String errcode = jsonObject.getString("errcode");
        String errmsg = jsonObject.getString("errmsg");
        System.out.println("openId:" + openId);
        System.out.println("session_key:" + session_key);
        System.out.println("errcode:" + errcode);
        System.out.println("errmsg:" + errmsg);
        System.out.println("unionId:" + unionId);

        JSONObject userInfo = getUserInfo(encryptedData,session_key,iv);
        String nickName = userInfo.getString("nickName");
        String gender = userInfo.getString("gender");
        String country = userInfo.getString("country");
        String province = userInfo.getString("province");
        String city = userInfo.getString("city");
        String avatarUrl = userInfo.getString("avatarUrl");
        String userInfoUnionId = userInfo.getString("unionId");
        System.out.println("nickName:" + nickName);
        System.out.println("sex:" + gender);
        System.out.println("country:" + country);
        System.out.println("province:" + province);
        System.out.println("city:" + city);
        System.out.println("headImgUrl:" + avatarUrl);
        System.out.println("unionid:"+userInfoUnionId);

        ThirdPartEntity thirdPartEntity = new ThirdPartEntity();
        thirdPartEntity.setNickName(nickName);
        thirdPartEntity.setHeadImgUrl(avatarUrl);
        thirdPartEntity.setCity(city);
        thirdPartEntity.setProvince(province);
        //以unionId作为唯一标识
        thirdPartEntity.setOpenId(openId);
        thirdPartEntity.setUnionId(userInfoUnionId);
        return thirdPartEntity;
    }
    /**
     * 解密用户敏感数据获取用户信息
     *
     * @param sessionKey    数据进行加密签名的密钥
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv            加密算法的初始向量
     * @return
     * @author zhy
     */
    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64Utils.decodeFromString(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64Utils.decodeFromString(sessionKey);
        // 偏移量
        byte[] ivByte = Base64Utils.decodeFromString(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            //BouncyCastle是一个开源的加解密解决方案，主页在http://www.bouncycastle.org/
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result);
            }
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidParameterSpecException e) {
            log.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            log.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            log.error(e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e) {
            log.error(e.getMessage(), e);
        } catch (NoSuchProviderException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    public static void main(String args[]){
        String code="";
        String data="";
        String iv="";
        weChatGetAccessAndOpenIdByCode(code,data,iv);
    }
}
