package com.springboot.security.config.security.handler;

import com.springboot.security.common.response.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 用户退出系统成功后, 需要做的业务操作
 * 包括：清空redis中的Token，清空上下文&Session，记录退出日志等等
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //清空上下文
        SecurityContextHolder.clearContext();
        // 从session中移除
        httpServletRequest.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
        //记录退出日志
        System.out.println("退出登录成功！");
        ResponseUtil.out(httpServletResponse, ResponseUtil.resultMap(200, "退出系统成功"));
    }

}
