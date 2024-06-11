package com.shuyixiao.system.service;

import com.shuyixiao.dto.ResponseResult;

/**
 * ClassName VerificationCodeService.java
 * author 舒一笑
 * version 1.0.0
 * Description 验证码生成
 * createTime 2024年06月11日 21:59:00
 */
public interface VerificationCodeService {

    ResponseResult getVerificationCode(String serviceIP);
}
