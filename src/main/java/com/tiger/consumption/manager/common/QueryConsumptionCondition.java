package com.tiger.consumption.manager.common;

import com.tiger.consumption.manager.model.ConsumptionType;
import com.tiger.consumption.manager.model.PayType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/8/1 22:57
 * @Description:
 * @Version: 1.0
 **/
public class QueryConsumptionCondition implements Serializable {
    private static final long serialVersionUID = -6735741938611545234L;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;
    private ConsumptionType consumptionType;
    private PayType payType;
    private int page;
    public static final int MAX_PAGE = Integer.MAX_VALUE;

    public QueryConsumptionCondition() {
        consumptionType = new ConsumptionType();
        consumptionType.setId(-1);
        payType = new PayType();
        payType.setId(-1);
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MONTH, -1);
        begin = instance.getTime();
        end = new Date();
        page = MAX_PAGE;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public ConsumptionType getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(ConsumptionType consumptionType) {
        this.consumptionType = consumptionType;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
