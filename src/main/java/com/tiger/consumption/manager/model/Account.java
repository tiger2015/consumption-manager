package com.tiger.consumption.manager.model;

import java.io.Serializable;

/**
 * 账号
 * @Auther: Zeng Hu
 * @Date: 2020/7/26 15:33
 * @Description:
 * @Version: 1.0
 **/
public class Account implements Serializable {
    private static final long serialVersionUID = -8925961310025531771L;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
