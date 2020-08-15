package com.tiger.consumption.manager.controller;

import com.tiger.consumption.manager.common.QueryConsumptionCondition;
import com.tiger.consumption.manager.common.ResponseMessage;
import com.tiger.consumption.manager.common.User;
import com.tiger.consumption.manager.dao.AccountDao;
import com.tiger.consumption.manager.dao.ConsumptionTypeDao;
import com.tiger.consumption.manager.dao.PayTypeDao;
import com.tiger.consumption.manager.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 17:51
 * @Description:
 * @Version: 1.0
 **/
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ConsumptionTypeDao consumptionTypeDao;
    @Autowired
    private PayTypeDao payTypeDao;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @ModelAttribute(value = "account") User user, Model model) {
        log.info("user:{}", user.getName());
        Account account = accountDao.findByName(user.getName());
        if (account == null) {
            model.addAttribute("msg", ResponseMessage.INVALID_ACCOUNT);
        } else if (!account.getPassword().equals(user.getPassword())) {
            model.addAttribute("msg", ResponseMessage.ERROR_PWD);
        } else {
            request.getSession().removeAttribute("queryCondition");
            request.getSession().setAttribute("account", user.getName());
            return "redirect:/listAll";
        }
        return "index";
    }

}
