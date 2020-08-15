package com.tiger.consumption.manager.service;

import com.tiger.consumption.manager.common.PageResult;
import com.tiger.consumption.manager.model.ConsumptionRecord;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 17:22
 * @Description:
 * @Version: 1.0
 **/
public interface ConsumptionRecordService {

    Boolean add(ConsumptionRecord consumptionRecord);

    PageResult<ConsumptionRecord> findAllByPage(int pageNumber);

    ConsumptionRecord findById(Long id);

    Boolean update(ConsumptionRecord consumptionRecord);

    Integer delete(Long ...ids);

    PageResult<ConsumptionRecord> findAllByConditionAndPage(Date begin, Date end, ConsumptionType consumptionType, PayType payType, int pageNumber);
}
