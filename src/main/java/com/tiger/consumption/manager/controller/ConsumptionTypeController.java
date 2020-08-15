package com.tiger.consumption.manager.controller;

import com.tiger.consumption.manager.common.QueryConsumptionCondition;
import com.tiger.consumption.manager.dao.ConsumptionTypeDao;
import com.tiger.consumption.manager.dao.PayTypeDao;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/28 22:28
 * @Description:
 * @Version: 1.0
 **/
@Controller
public class ConsumptionTypeController {

    @Autowired
    private ConsumptionTypeDao consumptionTypeDao;

    @Autowired
    private PayTypeDao payTypeDao;

    @RequestMapping("/listAllTypes")
    public String listAll(Model model, @ModelAttribute("target") String target){
        model.addAttribute("consumptionTypes", consumptionTypeDao.selectAll());
        model.addAttribute("payTypes", payTypeDao.selectAll());
        return target;
    }

}
