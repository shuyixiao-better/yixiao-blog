package com.shuyixiao.system.service.impl;

import com.shuyixiao.constant.IdentityConstants;
import com.shuyixiao.constant.TokenConstants;
import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.responese.TokenResponse;
import com.shuyixiao.system.service.VerificationCodeService;
import com.shuyixiao.util.JwtUtils;
import com.shuyixiao.util.RedisPrefixUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName VerificationCodeServiceImpl.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月11日 22:00:00
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public ResponseResult getVerificationCode(String serviceIP) {
        // 生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(serviceIP, IdentityConstants.SERVICE_IDENTITY) ;
        // 根据key获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);
        System.out.println("redis中的value："+codeRedis);

        // 颁发令牌，不应该用魔法值，用常量
        String accessToken = JwtUtils.generatorToken(serviceIP, IdentityConstants.SERVICE_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generatorToken(serviceIP, IdentityConstants.SERVICE_IDENTITY ,TokenConstants.REFRESH_TOKEN_TYPE);

        // 将token存到redis当中
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(serviceIP , IdentityConstants.SERVICE_IDENTITY , TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey , accessToken , 30, TimeUnit.DAYS);

        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(serviceIP , IdentityConstants.SERVICE_IDENTITY , TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey , refreshToken , 31, TimeUnit.DAYS);

        // 响应
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);
        return ResponseResult.success(tokenResponse);
    }
}
