package com.tiger.consumption.manager.controller;

import com.tiger.consumption.manager.common.QueryConsumptionCondition;
import com.tiger.consumption.manager.dao.ConsumptionTypeDao;
import com.tiger.consumption.manager.dao.PayTypeDao;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.MonthConsumptionStatistic;
import com.tiger.consumption.manager.service.ConsumptionStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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
    private ConsumptionTypeDao consumptionTypeDao;
    @Autowired
    private PayTypeDao payTypeDao;
    @Autowired
    private ConsumptionStatisticService consumptionStatisticService;


    @RequestMapping("/showStatisticChart")
    public String showConsumptionStatistic() {
        return "showStatisticConsumptionChart";
    }

    @RequestMapping(path = "/statisticConsumption")
    public String statisticConsumption(HttpServletRequest request,
                                       @ModelAttribute("condition") QueryConsumptionCondition condition, Model model) {
        if (condition == null) {
            condition = new QueryConsumptionCondition();
        }
        // 分类统计
        List<ConsumptionStatistic> list = consumptionStatisticService.statisticConsumption(condition.getBegin(),
                condition.getEnd(), condition.getConsumptionType(), condition.getPayType());
        //总的结果
        ConsumptionStatistic total = new ConsumptionStatistic();
        total.setPayType(condition.getPayType());
        total.setConsumptionType(condition.getConsumptionType());
        total.setBegin(condition.getBegin());
        total.setEnd(condition.getEnd());
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < list.size(); i++) {
            sum = sum.add(list.get(i).getTotal());
        }
        total.setTotal(sum);
        log.info("total:{}", sum);
        model.addAttribute("consumptionTypes", consumptionTypeDao.selectAll());
        model.addAttribute("payTypes", payTypeDao.selectAll());
        model.addAttribute("condition", condition);
        model.addAttribute("statisticSum", total);
        model.addAttribute("statisticList", list);
        return "statisticConsumption";
    }


    @RequestMapping(path = "/monthConsumptionStatistic")
    @ResponseBody
    public Object monthConsumptionStatistic(@RequestParam("year") int year, @RequestParam("month") int month) {
        List<MonthConsumptionStatistic> monthConsumptionStatistics =
                consumptionStatisticService.statisticConsumptionByMonth(year, month);
        return monthConsumptionStatistics;
    }

    @RequestMapping(path = "/yearConsumptionStatistic")
    @ResponseBody
    public Object yearConsumptionStatistic(@RequestParam("start") int start, @RequestParam("end") int end){
        return  consumptionStatisticService.statisticConsumptionByYear(start, end);
    }

}
