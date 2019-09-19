package cn.zimo.wbq.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

/*
 * AES对称加密和解密
 */
public class SymmetricEncoderUtil {
	/*
	 * 加密 1.构造密钥生成器   2.根据ecnodeRules规则初始化密钥生成器   3.产生密钥   4.创建和初始化密码器    5.内容加密   6.返回字符串
	 */
	public static String AESEncode(String encodeRules, String content) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	        secureRandom.setSeed(encodeRules.getBytes());
	        keygen.init(128, secureRandom);
			//keygen.init(128, new SecureRandom(encodeRules.getBytes()));
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] byte_encode = content.getBytes("utf-8");
			byte[] byte_AES = cipher.doFinal(byte_encode);
			String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 解密 解密过程： 1.同加密1-4步   2.将加密后的字符串反纺成byte[]数组      3.将加密内容解密
	 */
	public static String AESDecode(String encodeRules, String content) {
		try {
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	        secureRandom.setSeed(encodeRules.getBytes());
	        keygen.init(128, secureRandom);
			//keygen.init(128, new SecureRandom(encodeRules.getBytes()));
			SecretKey original_key = keygen.generateKey();
			byte[] raw = original_key.getEncoded();
			SecretKey key = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, "utf-8");
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		SymmetricEncoderUtil se = new SymmetricEncoderUtil();
		Scanner scanner = new Scanner(System.in);
		/*
		 * 加密
		 */
		System.out.println("使用AES对称加密，请输入加密的规则");
		String encodeRules = scanner.next();
		System.out.println("请输入要加密的内容:");
		String content = scanner.next();
		long encodeTimeStart = System.currentTimeMillis();
		System.out.println("根据输入的规则" + encodeRules + "加密后的密文是:" + se.AESEncode(encodeRules, content));
		long encodeTimeEnd = System.currentTimeMillis();
		System.out.println(encodeTimeEnd - encodeTimeStart);
		/*
		 * 解密
		 */
		System.out.println("使用AES对称解密，请输入加密的规则：(须与加密相同)");
		encodeRules = scanner.next();
		System.out.println("请输入要解密的内容（密文）:");
		content = scanner.next();
		long decodeTimeStart = System.currentTimeMillis();
		System.out.println("根据输入的规则" + encodeRules + "解密后的明文是:" + se.AESDecode(encodeRules, content));
		long decodeTimeEnd = System.currentTimeMillis();
		System.out.println(decodeTimeEnd - decodeTimeStart);
	}
	
	public static String encode(String rule,String text) {
		return SymmetricEncoderUtil.AESEncode(rule, text);
	}
}