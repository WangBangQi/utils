package com.zimo.utils.utils;

import cn.zimo.wbq.utils.SymmetricEncoderUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

	private static final String salt_prefix = "qwlpkaedsm";

	private static final String salt_suffix = "tmtjkytwq";
	
	private static final String token_salt_pre = "kenfsf";
	
	private static final String token_salt_suf = "wlmfs";

    /**
     * SHA256 签名算法
     */
    public static final String SHA256 = "SHA-256";

    /**
     * md5 签名算法
     */
    public static final String MD5 = "md5";
	/**
	 * SHA512 签名算法
	 */
    public static final String SHA512 = "SHA-512";

    /**
     * 生成签名 默认使用 md5
     *
     * @param value 要转换成签名的数据
     * @return 生成后的签名
     * @throws NoSuchAlgorithmException 无指定签名类型异常
     */
    public static String generateSign(String value) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        messageDigest.update(value.getBytes());
        return generate(messageDigest);
    }

    /**
     * 生成签名
     *
     * @param value 要转换成签名的数据
     * @param type  要转签名的类型
     * @return 生成后的签名
     * @throws NoSuchAlgorithmException 无指定签名类型异常
     */
    public static String generateSign(String value, String type) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(type);
        messageDigest.update(value.getBytes());
        return generate(messageDigest);
    }

    /**
     * 生成签名主要方法
     *
     * @param messageDigest 包含信息的信息摘要类
     * @return 生成后的签名
     */
    private static String generate(MessageDigest messageDigest){
        // 得到 byte 類型结果
        byte[] byteBuffer = messageDigest.digest();
        // 將 byte 轉換爲 string
        StringBuffer strHexString = getHexString(byteBuffer);
        // 返回結果
        return strHexString.toString();
    }

    public static String SHA512(final String strText) {
        // 返回值
        String strResult = null;
        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(SHA512);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();
                // 將 byte 轉換爲 string
                StringBuffer strHexString = getHexString(byteBuffer);
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    private static StringBuffer getHexString(byte byteBuffer[]){
        // 遍歷 byte buffer
        StringBuffer strHexString = new StringBuffer();
        for (byte aByteBuffer : byteBuffer) {
            String hex = Integer.toHexString(0xff & aByteBuffer);
            if (hex.length() == 1) {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        return strHexString;
    }


	/**生成加密密匙字符串
	 * @param rawSalt
	 * @return
	 */
	private static String generateEncodeKey(String rawSalt) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(salt_prefix).append(rawSalt).append(salt_suffix);
		String encodeKey = DigestUtils.md5Hex(buffer.toString());
		return encodeKey;
	}
	
	/**加密文本
	 * @param text 待加密文本
	 * @param rawSalt 生成密匙资源
	 * @return
	 */
	public static String encode(String text,String rawSalt) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(salt_prefix).append(rawSalt);
		String salt = DigestUtils.md5Hex(buffer.toString());
		buffer.delete(0, buffer.length());
		buffer.append(salt).append(text).append(salt_suffix);
		return DigestUtils.sha1Hex(buffer.toString());
	}
	
	/**使用AES加密文本
	 * @param text 待加密文本
	 * @param rawSalt 生成密匙资源
	 * @return
	 */
	public static String encodeForAES(String text,String rawSalt) {
		String key = generateEncodeKey(rawSalt);
		String encodeText = SymmetricEncoderUtil.AESEncode(key, text);
		return encodeText;
	}

	/**使用AES解密文本
	 * @param text  待解密文本
	 * @param rawSalt 生成密匙资源
	 * @return
	 */
	public static String decodeForAES(String text, String rawSalt) {
		String key = generateEncodeKey(rawSalt);
		String decodeText = SymmetricEncoderUtil.AESDecode(key, text);
		return decodeText;
	}
	
	/**获取登录token
	 * @param account
	 * @return
	 */
	public static String getLoginToken(String account) {
		StringBuffer buffer =  new StringBuffer();
		buffer.append(token_salt_pre).append(account).append(token_salt_suf).append(System.currentTimeMillis());
		String encode= DigestUtils.sha1Hex(buffer.toString());
		int length=encode.length();
		if(length>64) {
			return encode.substring(0, 63);
		}else {
			return encode;
		}
	}
}
