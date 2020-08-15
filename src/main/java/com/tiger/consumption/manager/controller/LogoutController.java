package com.tiger.consumption.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/8/13 21:19
 * @Description:
 * @Version: 1.0
 **/
@Controller
public class LogoutController {

    public static Logger log = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        log.info("{} logout", request.getSession().getAttribute("account"));
        request.getSession().removeAttribute("account");
        request.getSession().removeAttribute("queryCondition");
        return "index";
    }

}
