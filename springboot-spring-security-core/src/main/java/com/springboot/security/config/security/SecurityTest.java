package com.springboot.security.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-25 15:58
 */
public class SecurityTest {
    public static void main(String[] args) {
      /*  UserDetails userDetails = User.withDefaultPasswordEncoder().username("aaa").password("12345").roles("user", "admin").build();
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.getPassword());
        System.out.println(111);

        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        UserDetails user1 = builder.username("aaa").password("123").roles("user").build();
        UserDetails user2 = builder.username("bbb").password("123").roles("user", "admin").build();
        System.out.println(111);*/

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encode = encoder.encode("myPassword");
        System.out.println(encode);

        Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
        String result = pbkdf2PasswordEncoder.encode("myPassword");
        System.out.println(result);

    }
}
