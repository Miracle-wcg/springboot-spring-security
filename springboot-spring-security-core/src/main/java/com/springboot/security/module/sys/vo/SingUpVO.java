package com.springboot.security.module.sys.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-26 10:40
 */
@Data
public class SingUpVO {
    @NotBlank
    @Size(min = 3, max = 15)
    private String username;
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
}
