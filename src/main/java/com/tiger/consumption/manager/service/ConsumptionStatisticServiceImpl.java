package com.tiger.consumption.manager.service;

import com.tiger.consumption.manager.dao.ConsumptionStatisticDao;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.MonthConsumptionStatistic;
import com.tiger.consumption.manager.model.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/8/14 23:46
 * @Description:
 * @Version: 1.0
 **/
@Service
public class ConsumptionStatisticServiceImpl implements ConsumptionStatisticService {

    @Autowired
    private ConsumptionStatisticDao consumptionStatisticDao;

    @Override
    public List<ConsumptionStatistic> statisticConsumption(Date begin, Date end, ConsumptionType consumptionType,
                                                           PayType payType) {
        return consumptionStatisticDao.statisticConsumption(begin, end, consumptionType, payType);
    }

    @Override
    public List<MonthConsumptionStatistic> statisticConsumptionByMonth(int year, int month) {
        return consumptionStatisticDao.statisticConsumptionByMonth(year, month);
    }
}
