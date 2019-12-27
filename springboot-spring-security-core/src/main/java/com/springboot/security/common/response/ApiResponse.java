package com.springboot.security.common.response;

import lombok.Data;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-26 10:43
 */
@Data
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

//    public ApiResponse
}
