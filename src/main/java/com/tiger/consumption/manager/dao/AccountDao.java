package com.tiger.consumption.manager.dao;

import com.tiger.consumption.manager.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 16:27
 * @Description:
 * @Version: 1.0
 **/
@Mapper
@Repository
public interface AccountDao {
    Account findByName(String name);
}
