package com.tiger.consumption.manager.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tiger.consumption.manager.common.PageResult;
import com.tiger.consumption.manager.dao.ConsumptionRecordDao;
import com.tiger.consumption.manager.model.ConsumptionRecord;
import com.tiger.consumption.manager.model.ConsumptionStatistic;
import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 17:23
 * @Description:
 * @Version: 1.0
 **/
@Service
public class ConsumptionRecordServiceImpl implements ConsumptionRecordService {

    @Autowired
    private ConsumptionRecordDao consumptionRecordDao;

    @Override
    public Boolean add(ConsumptionRecord consumptionRecord) {
        return consumptionRecordDao.insert(consumptionRecord);
    }

    @Override
    public PageResult<ConsumptionRecord> findAllByPage(int pageNumber) {
        Page<Object> page = PageHelper.startPage(pageNumber, PageResult.PAGE_SIZE);
        List<ConsumptionRecord> records = consumptionRecordDao.selectAll();
        PageResult<ConsumptionRecord> result = new PageResult<>();
        result.setResult(records);
        result.setTotal(page.getPages());
        result.setCurrent(page.getPageNum());
        result.setPageSize(page.getPageSize());
        return result;
    }

    @Override
    public ConsumptionRecord findById(Long id) {
        return consumptionRecordDao.selectById(id);
    }

    @Override
    public Boolean update(ConsumptionRecord consumptionRecord) {
        return consumptionRecordDao.update(consumptionRecord);
    }

    @Override
    public Integer delete(Long... ids) {
        return consumptionRecordDao.delete(ids);
    }

    @Override
    public PageResult<ConsumptionRecord> findAllByConditionAndPage(Date begin, Date end,
                                                                   ConsumptionType consumptionType, PayType payType,
                                                                   int pageNumber) {
        Page<Object> page = PageHelper.startPage(pageNumber, PageResult.PAGE_SIZE);
        List<ConsumptionRecord> records = consumptionRecordDao.selectByCondition(begin, end, consumptionType, payType);
        PageResult<ConsumptionRecord> result = new PageResult<>();
        result.setResult(records);
        result.setTotal(page.getPages());
        result.setCurrent(page.getPageNum());
        result.setPageSize(page.getPageSize());
        return result;
    }

}
