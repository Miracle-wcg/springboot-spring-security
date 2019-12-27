package com.springboot.security.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Miracle.wcg
 * @Date 2019-12-26 00:29
 */
@Slf4j
@Component
public class JwtTokenProvider {
    private static final long EXPIRE_TIME = 2 * 60 * 60 * 1000;
    //    private static final long EXPIRE_TIME = 20 * 1000;
    private static final String SECRET = "springboot-spring-security+JWT";
    private static final String CLAIM_USERNAME = "username";

    /**
     * 生成 token, 5min后过期
     *
     * @param username 用户名
     * @return 加密的token
     */
    public String sign(String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    .withClaim(CLAIM_USERNAME, username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验 token 是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public boolean verify(String token) {
        try {
            String username = getUsername(token);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(CLAIM_USERNAME, username)
                    .build();
            verifier.verify(token);
            return true;
        } catch (SignatureVerificationException exception) {
            log.error("Signature is invalid");
            return false;
        } catch (TokenExpiredException exception) {
            log.error("Token has expired");
            return false;
        } catch (InvalidClaimException exception) {
            log.error("A claim contained a different value than the expected one");
            return false;
        } catch (AlgorithmMismatchException exception) {
            log.error("Algorithm stated in the token's header it's not equal to the one defined in definition");
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(CLAIM_USERNAME).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
