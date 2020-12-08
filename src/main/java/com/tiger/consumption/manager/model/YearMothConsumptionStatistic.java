package com.tiger.consumption.manager.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: ZengHu
 * @Date: 2020/12/7 20:41
 * @Description:
 * @Version: 1.0
 **/
public class YearMothConsumptionStatistic implements Serializable {
    private static final long serialVersionUID = -1356125260134764269L;
    private int year;
    private int month;
    private BigDecimal total;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

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
}
