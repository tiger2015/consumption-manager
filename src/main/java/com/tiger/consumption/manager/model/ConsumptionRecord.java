package com.tiger.consumption.manager.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 消费记录
 *
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 15:36
 * @Description:
 * @Version: 1.0
 **/
public class ConsumptionRecord implements Serializable {
    private static final long serialVersionUID = -8600952020569892571L;
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private ConsumptionType consumptionType;
    private BigDecimal amount;
    private String comment;
    private Date createTime;

    private PayType payType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
