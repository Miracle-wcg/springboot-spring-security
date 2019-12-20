package com.springboot.security.config.security;

import com.google.common.net.HttpHeaders;
import com.springboot.security.module.sys.service.SysUserService;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chengang.wu
 * @Date: 2019-12-20 16:23
 */
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthParameters authParameters;
    @Autowired
    private SysUserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if (StringUtils.isNotBlank(token) && jwtTokenProvider.verify(token)) {
            String username = getUsername(token);
            UserDetails userDetails = userService.getUserDetailsByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        } else {
            log.error("Token is not found");
        }
        super.doFilter(request, response, filterChain);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotBlank(token) && token.startsWith("Bearer")) {
            return token.replace("Bearer", "");

        }
        return null;
    }

    private String getUsername(String token) {
        return Jwts.parser().setSigningKey(authParameters.getJwtTokenSecret()).parseClaimsJws(token).getBody().getSubject();
    }

}
