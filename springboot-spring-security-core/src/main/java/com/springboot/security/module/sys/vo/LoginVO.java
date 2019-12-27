package com.springboot.security.module.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-26 10:39
 */
@Data
public class LoginVO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
