package com.tiger.consumption.manager.controller;

import com.tiger.consumption.manager.common.QueryConsumptionCondition;
import com.tiger.consumption.manager.dao.ConsumptionStatisticDao;
import com.tiger.consumption.manager.dao.ConsumptionTypeDao;
import com.tiger.consumption.manager.dao.PayTypeDao;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/30 21:12
 * @Description:
 * @Version: 1.0
 **/
@Controller
public class ConsumptionStatisticController {
    private static final Logger log = LoggerFactory.getLogger(ConsumptionStatisticController.class);

    @Autowired
    private ConsumptionStatisticDao statisticDao;

    @Autowired
    private ConsumptionTypeDao consumptionTypeDao;

    @Autowired
    private PayTypeDao payTypeDao;

    @RequestMapping(path = "/statisticConsumption")
    public String statisticConsumption(HttpServletRequest request, @ModelAttribute("condition") QueryConsumptionCondition condition, Model model) {
        // 查询总计
        ConsumptionStatistic total = statisticDao.statisticTotalConsumption(condition.getBegin(),
                condition.getEnd(), condition.getConsumptionType(), condition.getPayType());
        // 分类统计
        List<ConsumptionStatistic> list = statisticDao.statisticConsumption(condition.getBegin(),
                condition.getEnd(), condition.getConsumptionType(), condition.getPayType());
        model.addAttribute("consumptionTypes", consumptionTypeDao.selectAll());
        model.addAttribute("payTypes", payTypeDao.selectAll());
        model.addAttribute("condition", condition);
        model.addAttribute("statisticSum", total);
        model.addAttribute("statisticList", list);
        return "statisticConsumption";
    }
}
