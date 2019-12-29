package com.springboot.security.config.security.handler;

import com.springboot.security.common.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 认证失败处理类
 * 在访问一个受保护的资源，用户没有通过登录认证
 */
@Slf4j
@Component
public class MyAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        StringBuffer msg = new StringBuffer("请求访问: ");
        msg.append(request.getRequestURI()).append(" 接口，因为认证失败，无法访问系统资源.");
        log.info(msg.toString());
        ResponseUtil.out(response, ResponseUtil.resultMap(401, "权限不足，无法访问该资源"));
    }
}
