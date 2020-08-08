package com.tiger.consumption.manager.dao;

import com.tiger.consumption.manager.model.ConsumptionType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 16:52
 * @Description:
 * @Version: 1.0
 **/
@Mapper
@Repository
public interface ConsumptionTypeDao {
    @Cacheable(cacheNames = "consumptionTypes", key = "'consumptionTypes'")
    List<ConsumptionType> selectAll();
}
