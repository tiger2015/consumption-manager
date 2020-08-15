package com.tiger.consumption.manager.dao;

import com.tiger.consumption.manager.model.ConsumptionRecord;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 17:03
 * @Description:
 * @Version: 1.0
 **/
@Mapper
@Repository
public interface ConsumptionRecordDao {

    Boolean insert(ConsumptionRecord consumptionRecord);

    List<ConsumptionRecord> selectAll();

    @Cacheable(cacheNames = "record", key = "'consumption:'+#id")
    ConsumptionRecord selectById(Long id);

    Boolean update(ConsumptionRecord consumptionRecord);

    Integer delete(Long... ids);

    List<ConsumptionRecord> selectByCondition(@Param("begin") Date begin, @Param("end") Date end, @Param(
            "consumptionType") ConsumptionType consumptionType, @Param("payType") PayType payType);
}
