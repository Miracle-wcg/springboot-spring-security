package com.springboot.controller;

import com.springboot.security.module.sys.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 17:04
 */
@RestController
public class LoginController {
    @PostMapping("login")
    public void login(@RequestBody UserDTO userDTO) {

    }
}
