package com.springboot.security.config.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 15:58
 */
@Component
@PropertySource("classpath:auth.properties")
@Data
public class AuthParameters {
    @Value("${jwt.token.secret}")
    private String jwtTokenSecret;
    @Value("${token.expired.ms}")
    private long tokenExpiredMs;
}
