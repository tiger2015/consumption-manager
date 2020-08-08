package com.tiger.consumption.manager.model;

import java.io.Serializable;

/**
 * @Auther: Zeng Hu
 * @Date: 2020/7/29 21:25
 * @Description:
 * @Version: 1.0
 **/
public class PayType implements Serializable {
    private static final long serialVersionUID = -3656448240512170430L;

    private Integer id;
    private String name;
    private String description;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
