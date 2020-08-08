package com.tiger.consumption.manager.dao;

import com.tiger.consumption.manager.model.PayType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/29 21:27
 * @Description:
 * @Version: 1.0
 **/
@Repository
@Mapper
public interface PayTypeDao {
    @Cacheable(cacheNames = "payTypes", key = "'payTypes'")
    List<PayType> selectAll();

}
