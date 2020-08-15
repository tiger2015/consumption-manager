package com.tiger.consumption.manager.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/8/2 15:22
 * @Description:
 * @Version: 1.0
 **/
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {

    private static final List<Integer> errorCodes = new ArrayList<>();

    static {
        errorCodes.add(400);
        errorCodes.add(403);
        errorCodes.add(404);
        errorCodes.add(408);
        errorCodes.add(500);
        errorCodes.add(501);
        errorCodes.add(502);
        errorCodes.add(503);
        errorCodes.add(504);
        errorCodes.add(509);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (errorCodes.contains(response.getStatus())) {
            response.sendRedirect("./common/error.html");
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
