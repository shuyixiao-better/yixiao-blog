package com.shuyixiao.dto;

import com.shuyixiao.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName ResponseResult.java
 * author 舒一笑
 * version 1.0.0
 * Description 统一返回结果类
 * createTime 2024年06月07日 00:00:00
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 成功相应的方法
     * @return
     * @param <T>
     */
    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }

    /**
     * 成功响应的方法
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseResult success(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /**
     * 失败：统一的失败
     * @param data
     * @return
     * @param <T>
     */
    public static <T>  ResponseResult fail(T data){
        return new ResponseResult().setData(data);

    }

    /**
     * 失败：自定义 失败错误码提示信息
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * 失败 ： 自定义失败错误码 提示信息 具体错误
     * @param code
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(int code,String message,String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
