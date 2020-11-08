package com.tiger.consumption.manager.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 18:39
 * @Description:
 * @Version: 1.0
 **/
public class LoginHandleInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginHandleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object account = request.getSession().getAttribute("account");
        if (account != null) {
            //log.info("user:{} has login", account);
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/");
        return false;
    }
}
