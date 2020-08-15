package com.tiger.consumption.manager.controller;

import com.tiger.consumption.manager.common.PageResult;
import com.tiger.consumption.manager.dao.ConsumptionTypeDao;
import com.tiger.consumption.manager.dao.PayTypeDao;
import com.tiger.consumption.manager.model.ConsumptionRecord;
import com.tiger.consumption.manager.common.QueryConsumptionCondition;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.service.ConsumptionRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 22:35
 * @Description:
 * @Version: 1.0
 **/
@Controller
public class ConsumptionRecordController {
    private static final Logger log = LoggerFactory.getLogger(ConsumptionRecordController.class);
    @Autowired
    private ConsumptionRecordService recordService;
    @Autowired
    private ConsumptionTypeDao consumptionTypeDao;
    @Autowired
    private PayTypeDao payTypeDao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, @ModelAttribute("record") ConsumptionRecord consumptionRecord,
                      Model model) {
        log.info("type:{}", consumptionRecord.getConsumptionType().getId());
        recordService.add(consumptionRecord);
        return listAll(request, new QueryConsumptionCondition(), model);
    }

    @RequestMapping(value = "/listAll", method = {RequestMethod.POST, RequestMethod.GET})
    public String listAll(HttpServletRequest request,
                          @ModelAttribute(name = "condition") QueryConsumptionCondition condition,
                          Model model) {
        log.info("list all");
        if (condition == null || condition.getPage() == QueryConsumptionCondition.MAX_PAGE) {
            log.info("condition null");
            condition = request.getSession().getAttribute("queryCondition") == null ?
                    new QueryConsumptionCondition() : (QueryConsumptionCondition) request.getSession().getAttribute(
                    "queryCondition");
            condition.setPage(1);
        }
        log.info("before page:{}", condition.getPage());
        PageResult<ConsumptionRecord> result = recordService.findAllByConditionAndPage(condition.getBegin(),
                condition.getEnd(), condition.getConsumptionType(), condition.getPayType(), condition.getPage());
        condition.setPage(result.getCurrent());
        log.info("after page:{}", condition.getPage());
        model.addAttribute("records", result);
        model.addAttribute("condition", condition);
        model.addAttribute("consumptionTypes", consumptionTypeDao.selectAll());
        model.addAttribute("payTypes", payTypeDao.selectAll());
        request.getSession().setAttribute("queryCondition", condition);
        return "listConsumption";
    }


    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String getConsumptionRecord(@ModelAttribute("id") Long id, @ModelAttribute("target") String target,
                                       Model model) {
        ConsumptionRecord consumptionRecord = recordService.findById(id);
        model.addAttribute("record", consumptionRecord);
        if (target.equals("updateConsumptionRecord")) { // 更新
            model.addAttribute("consumptionTypes", consumptionTypeDao.selectAll());
            model.addAttribute("payTypes", payTypeDao.selectAll());
        }
        return target;
    }


    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, @ModelAttribute("record") ConsumptionRecord record, Model model) {
        recordService.update(record);
        return listAll(request, null, model);
    }

    @RequestMapping(path = "/delete")
    public String delete(HttpServletRequest request, @ModelAttribute("id") Long[] ids, Model model) {
        log.info("delete:{}", Arrays.toString(ids));
        recordService.delete(ids);
        return listAll(request, null, model);
    }



}
