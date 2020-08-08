package com.tiger.consumption.manager.model;

import java.io.Serializable;

/**
 * 消费类型
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 15:34
 * @Description:
 * @Version: 1.0
 **/

public class ConsumptionType implements Serializable {
    private static final long serialVersionUID = 1300769660678504791L;
    private Integer id;
    private String name;
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
