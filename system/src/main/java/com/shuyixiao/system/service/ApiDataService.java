package com.shuyixiao.system.service;

import com.shuyixiao.system.common.ResponseResult;

/**
 * ClassName ApiDataService.java
 * author 舒一笑
 * version 1.0.0
 * Description TODO
 * createTime 2024年06月06日 23:54:00
 */
public interface ApiDataService {

    /**
     * 获取各大平台的热搜
     * @param type 平台
     * @return
     */
    public ResponseResult hot(String type);

}
