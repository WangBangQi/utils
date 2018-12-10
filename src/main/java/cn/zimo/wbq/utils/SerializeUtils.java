package cn.zimo.wbq.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtils {
	
	private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);
	
	/**
	 * 序列化
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static byte[] serialize(Object object) throws Exception {
		if(object == null) {
			return null;
		}
		
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
			logger.error("序列化失败:",e);
			throw e;
		} finally {
			if(oos != null) {
				oos.close();
			}
		}
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static Object unSerialize(byte[] bytes) throws Exception {
		if(bytes == null) {
			return null;
		}
		
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			logger.error("反序列化失败：",e);
			throw e;
		} finally {
			if(ois != null) {
				ois.close();
			}
		}
	}
	
	/**
	 * 将字符串做序列化，最后转成base64字符串
	 * @param o
	 * @return
	 * @throws Exception
	 */
    public static String writeObject(Object o) throws Exception {  
    	byte[] b = serialize(o);
    	if(b != null) {
            return new BASE64Encoder().encode(b);  
    	}else {
    		return null;
    	}
    }  
  
	/**
	 * 获取base64字符串的字节数组,然后反序列化为对象
	 * @param str
	 * @return
	 * @throws Exception
	 */
    public static Object readObject(String str) throws Exception{ 
    	if(str == null) {
    		return null;
    	}
    	
    	return unSerialize(new BASE64Decoder().decodeBuffer(str));
    }
    
}