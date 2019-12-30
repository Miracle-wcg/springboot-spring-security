package com.springboot.security.controller;

import com.springboot.security.common.response.ApiResponse;
import com.springboot.security.config.security.config.CurrentUser;
import com.springboot.security.config.security.util.JwtTokenUtil;
import com.springboot.security.module.sys.dto.LoginRequest;
import com.springboot.security.module.sys.entity.SysUser;
import com.springboot.security.module.sys.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    private SysUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ApiResponse login(@RequestBody @Validated LoginRequest request) {
        SysUser user = userService.getUserDetailByUsername(request.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("用户名未找到");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }

        if (user.getEnabled()) {
            throw new DisabledException("该账户被锁定，请联系管理员");
        }

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = JwtTokenUtil.generateAccessToken((UserDetails) authenticate.getPrincipal());
        return ApiResponse.ok(token);
    }

    @GetMapping("/user-info")
    public ApiResponse getCurrentUser(@CurrentUser CurrentUser currentUser) {
        return ApiResponse.ok(currentUser);
    }
}
