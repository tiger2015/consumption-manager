package com.tiger.consumption.manager.common;

import java.io.Serializable;

/**
 * 用户
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 18:14
 * @Description:
 * @Version: 1.0
 **/
public class User implements Serializable {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
