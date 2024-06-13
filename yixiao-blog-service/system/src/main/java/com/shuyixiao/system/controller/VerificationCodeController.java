package com.shuyixiao.system.controller;

import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.system.service.VerificationCodeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName VerificationCodeController.java
 * author 舒一笑
 * version 1.0.0
 * Description 验证码生成
 * createTime 2024年06月11日 21:17:00
 */
@RestController
@Slf4j
@RequestMapping("/shuyixiao/v1")
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;

    @GetMapping("/getVerificationCode")
    public ResponseResult getVerificationCode(HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String serviceIP = "127.0.0.1";
        String ipv4Loopback = "127.0.0.1";
        String ipv6Loopback = "0:0:0:0:0:0:0:1";
        if (remoteAddr.equals(ipv4Loopback) || remoteAddr.equals(ipv6Loopback)){
            return verificationCodeService.getVerificationCode(serviceIP);
        }
        return ResponseResult.fail("");
    }
}
