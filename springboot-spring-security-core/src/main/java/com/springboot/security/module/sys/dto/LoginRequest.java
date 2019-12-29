package com.springboot.security.module.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 17:05
 */
@Data
public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
