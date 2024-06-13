package com.shuyixiao.system.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.shuyixiao.constant.TokenConstants;
import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.dto.TokenResult;
import com.shuyixiao.util.JwtUtils;
import com.shuyixiao.util.RedisPrefixUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * ClassName JwtTokenInterceptor.java
 * author 舒一笑
 * version 1.0.0
 * Description Token正确性校验工具
 * createTime 2024年06月13日 19:40:00
 */
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean result = true;

        String resultString = "";

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            // 移除 "Bearer " 前缀并获取实际的 JWT
            token = token.substring("Bearer ".length());
        }

        // 解析token
        TokenResult tokenResult = JwtUtils.parseToken(token);

        if(null == token){
            result = false;
            resultString = "access token invalid";
        }else {
            // 拼接key
            String serviceIP = tokenResult.getServiceIP();
            String identity = tokenResult.getIdentity();

            String tokenKey = RedisPrefixUtils.generatorTokenKey(serviceIP,identity, TokenConstants.ACCESS_TOKEN_TYPE);

            // 从redis中获取token
            String tokenRedis = stringRedisTemplate.opsForValue().get(tokenKey);
            if ((StringUtils.isBlank(tokenRedis)) || !token.trim().equals(tokenRedis)){
                result = false;
                resultString = "access token invalid";
            }
        }

        if (!result){
            PrintWriter out = response.getWriter();
            out.println(JSONObject.from(ResponseResult.fail(resultString)).toString());
        }
        return result;
    }
}
