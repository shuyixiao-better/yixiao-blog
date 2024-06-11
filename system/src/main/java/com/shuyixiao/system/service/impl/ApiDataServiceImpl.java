package com.shuyixiao.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.shuyixiao.system.common.ResponseResult;
import com.shuyixiao.system.service.ApiDataService;
import com.shuyixiao.system.utils.CustomHttpUtil;
import org.springframework.stereotype.Service;

/**
 * ClassName ApiDataServiceImpl.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月06日 23:55:00
 */
@Service
public class ApiDataServiceImpl implements ApiDataService {

    @Override
    public ResponseResult hot(String type) {
        String url = "https://www.coderutil.com/api/resou/v1/" + type;
        JSONObject jsonObject = CustomHttpUtil.sendCuApiHttpUrl(url);
        return ResponseResult.success(jsonObject);
    }
}
