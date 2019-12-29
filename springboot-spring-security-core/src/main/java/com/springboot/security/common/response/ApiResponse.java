package com.springboot.security.common.response;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-26 10:43
 */
@Data
public class ApiResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(Integer code) {
        this.code = code;
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }


    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiResponse ok() {
        return new ApiResponse(0);
    }

    public static ApiResponse ok(Object data) {
        return new ApiResponse(data);
    }

    public static ApiResponse fail(Integer code, String message) {
        return new ApiResponse(code, message);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(ApiResponse.ok()));
        System.out.println(JSON.toJSONString(ApiResponse.ok(123)));
        System.out.println(JSON.toJSONString(ApiResponse.fail(400, "Test fail response")));
    }
}
