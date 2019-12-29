package com.springboot.security.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author Miracle.wcg
 * @Date 2019/12/29 13:06
 */
public class SecurityTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
        System.out.println(encoder.matches("123456", encode));
    }
}
