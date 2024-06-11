package com.shuyixiao.system.controller;

import com.shuyixiao.dto.ResponseResult;
import com.shuyixiao.system.service.ApiDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName ApiDataController.java
 * author 舒一笑
 * version 1.0.0
 * Description 调用三方API获取数据工具类
 * createTime 2024年06月06日 23:52:00
 */
@RestController
@RequestMapping("/shuyixiao/v1")
public class ApiDataController {

    @Autowired
    private ApiDataService apiDataService;

    @GetMapping("/hot")
    @Operation(
            summary = "获取各大平台热搜",
            description = "获取各大平台热搜",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "成功响应",
                            content = @Content(
                                    schema = @Schema(implementation = ResponseResult.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "请求错误",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class)
                            )
                    )
            }
    )
    public ResponseResult hot(String type){
        return apiDataService.hot(type);
    }



}
