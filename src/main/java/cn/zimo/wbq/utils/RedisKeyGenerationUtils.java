package cn.zimo.wbq.utils;

public class RedisKeyGenerationUtils {

    /**
     * 根据类名和ID生成唯一KEY
     * @param t 类名
     * @param id id
     * @return
     */
    public static String keyGenerationByClassAndId(Class t,Long id){
        return new StringBuilder().append(t.getName()).append(":").append(id).toString();
    }

    public static String keyGenerationByClassAndMethodAndUniqueParam(Class t,String methodName,String uniqueKey){
        return new StringBuilder().append(t.getName()).append(":").append(methodName)
                .append(":uniqueKey:").append(uniqueKey).toString();
    }



}
