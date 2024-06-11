package com.shuyixiao.system.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;

import java.util.HashMap;

/**
 * ClassName CustomHttpUtil.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月07日 00:11:00
 */
public class CustomHttpUtil {

    private final static String accessKey = "a4be3957fe8874e260b762174cba623f";

    private final static String secretKey = "c8402aef0e57b1a3f57da3ced130c77d";

    /**
     * 发送api接口请求
     * @param url 接口地址
     * @return
     */
    public static JSONObject sendCuApiHttpUrl(String url) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("access-key", accessKey);
        paramMap.put("secret-key", secretKey);
        String result= HttpUtil.get(url, paramMap);
        return JSONObject.parseObject(result);
    }
}
