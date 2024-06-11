package com.shuyixiao.util;

/**
 * ClassName RedisPrefixUtils.java
 * author 舒一笑
 * version 1.0.0
 * Description 通用工具类
 * createTime 2024年06月11日 21:32:00
 */
public class RedisPrefixUtils {

    // 服务IP的前缀
    public static String verificationCodePrefix = "verification-code-";

    // token存储的前缀
    public static String tokenPrefix = "token-";

    /**
     * 根据服务IP，生成key
     * @param serviceIP
     * @param identity
     * @return
     */
    public static String generatorKeyByPhone(String serviceIP, String identity){
        return verificationCodePrefix + identity+ "-" + serviceIP;
    }

    /**
     * 根据服务IP，生成token
     * @param serviceIP
     * @param identity
     * @return
     */
    public static String generatorTokenKey(String serviceIP , String identity , String tokenType){
        return tokenPrefix + serviceIP + "-" + identity + "-" + tokenType;
    }
}
