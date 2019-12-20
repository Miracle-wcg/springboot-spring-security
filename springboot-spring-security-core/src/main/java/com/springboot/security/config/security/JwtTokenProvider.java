package com.springboot.security.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 16:02
 */
@Slf4j
@Component
public class JwtTokenProvider {
    @Autowired
    private AuthParameters authParameters;

    public String createToken(Authentication authentication) {
        String username = ((User) authentication.getPrincipal()).getUsername();
        Date expiredTime = new Date(System.currentTimeMillis() + authParameters.getTokenExpiredMs());
        String token = Jwts.builder().setSubject(username).setExpiration(expiredTime).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, authParameters.getJwtTokenSecret()).compact();
        return token;
    }

    public boolean verify(String token) {
        try {
            Jwts.parser().setSigningKey(authParameters.getJwtTokenSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error("verify failed: " + e.getMessage());
            return false;
        }
    }


}
