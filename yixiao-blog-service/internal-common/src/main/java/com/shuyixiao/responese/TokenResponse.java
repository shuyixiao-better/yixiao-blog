package com.shuyixiao.responese;

import lombok.Data;

/**
 * ClassName TokenResponse.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月11日 21:57:00
 */
@Data
public class TokenResponse {

    private String accessToken;

    private String refreshToken;
}
