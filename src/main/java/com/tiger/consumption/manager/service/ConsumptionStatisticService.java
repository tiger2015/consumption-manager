package com.tiger.consumption.manager.service;

import com.tiger.consumption.manager.model.*;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/8/14 23:45
 * @Description:
 * @Version: 1.0
 **/
public interface ConsumptionStatisticService {

    List<ConsumptionStatistic> statisticConsumption(Date begin, Date end, ConsumptionType consumptionType, PayType payType);

    List<MonthConsumptionStatistic> statisticConsumptionByMonth(int year, int month);

    List<YearMothConsumptionStatistic> statisticConsumptionByYear(int start, int end);

}
