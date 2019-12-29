package com.springboot.security.controller;

import com.springboot.security.common.response.ApiResponse;
import com.springboot.security.config.security.util.JwtTokenUtil;
import com.springboot.security.module.sys.dto.LoginRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 17:04
 */
@Api(tags = {"登录"})
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/loginpage")
    public ApiResponse login(@RequestBody @Validated LoginRequest request) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = JwtTokenUtil.generateAccessToken((UserDetails) authenticate.getPrincipal());
        return ApiResponse.ok(token);
    }
}
