package com.shuyixiao.constant;

import lombok.Getter;

/**
 * ClassName CommonStatusEnum.java
 * author 舒一笑
 * version 1.0.0
 * Description 常用信息枚举
 * createTime 2024年06月11日 13:38:00
 */
public enum CommonStatusEnum {

    /**
     * Token类提示：1100-1199
     */
    TOKEN_ERROR(1199,"token错误"),

    /**
     * 成功
     */
    SUCCESS(1,"SUCCESS"),
    /**
     * 失败
     */

    FAIL(2,"FAIL"),

    ;
    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
