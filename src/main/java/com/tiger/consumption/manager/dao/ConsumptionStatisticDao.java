package com.tiger.consumption.manager.dao;

import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.MonthConsumptionStatistic;
import com.tiger.consumption.manager.model.PayType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/31 20:11
 * @Description:
 * @Version: 1.0
 **/
@Repository
@Mapper
public interface ConsumptionStatisticDao {

    List<ConsumptionStatistic> statisticConsumption(@Param("begin") Date begin, @Param("end") Date end, @Param(
            "consumptionType") ConsumptionType consumptionType, @Param("payType") PayType payType);
    @Cacheable(cacheNames = {"monthConsumptionStatistic"}, key = "'statistic:'+#year+'-'+#month")
    List<MonthConsumptionStatistic> statisticConsumptionByMonth(@Param("year") int year, @Param("month") int month);

}
