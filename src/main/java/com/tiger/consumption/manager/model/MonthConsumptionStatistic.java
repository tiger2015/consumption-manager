package com.tiger.consumption.manager.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 按照月分类统计
 *
 * @Auther: Zeng Hu
 * @Date: 2020/8/14 23:41
 * @Description:
 * @Version: 1.0
 **/
public class MonthConsumptionStatistic implements Serializable {
    private static final long serialVersionUID = 7762488642965234747L;

    private int month;

    private BigDecimal total;

    private ConsumptionType type;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ConsumptionType getType() {
        return type;
    }

    public void setType(ConsumptionType type) {
        this.type = type;
    }
}
