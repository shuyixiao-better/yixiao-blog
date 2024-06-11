package com.shuyixiao.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shuyixiao.dto.TokenResult;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName JwtUtils.java
 * author 舒一笑
 * version 1.0.0
 * Description JWT验证验证码
 * createTime 2024年06月11日 21:47:00
 */
public class JwtUtils {

    // 盐
    private static final String SIGN = "SHUyixiao!@#$$";

    private static final String JWT_KEY_SERVICE_IP= "serviceIP";

    // 乘客是1，司机是2
    private static final String JWT_KEY_IDENTITY = "identity";

    // token类型
    private static final String JWT_TOKEN_TYPE = "tokenType";

    private static final String JWT_TOKEN_TIME = "tokenTime";

    // 生成token
    public static String generatorToken(String serviceIP , String identity , String tokenType) {
        Map<String,String> map = new HashMap<>();
        map.put(JWT_KEY_SERVICE_IP,serviceIP);
        map.put(JWT_KEY_IDENTITY, identity);
        map.put(JWT_TOKEN_TYPE, tokenType);
        // 防止每次生成的token一样。
        map.put(JWT_TOKEN_TIME, Calendar.getInstance().getTime().toString());

        JWTCreator.Builder builder = JWT.create();
        // 整合map
        map.forEach(
                (k,v) -> {
                    builder.withClaim(k,v);
                }
        );
        // 整合过期时间
//        builder.withExpiresAt(date);

        // 生成 token
        String sign = builder.sign(Algorithm.HMAC256(SIGN));

        return sign;
    }


    // 解析token
    public static TokenResult parseToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        String serviceIP = verify.getClaim(JWT_KEY_SERVICE_IP).asString();
        String identity = verify.getClaim(JWT_KEY_IDENTITY).asString();

        TokenResult tokenResult = new TokenResult();
        tokenResult.setServiceIP(serviceIP);
        tokenResult.setIdentity(identity);
        return tokenResult;

    }

    /**
     * 校验token，主要判断token是否异常
     * @param token
     * @return
     */
    public static TokenResult checkToken(String token){
        TokenResult tokenResult = null;
        try {
            tokenResult = JwtUtils.parseToken(token);
        }catch (Exception e){

        }
        return tokenResult;
    }
}
