package com.tiger.consumption.manager.common;

/**
 * 响应信息
 * @Auther: Zeng Hu
 * @Date: 2020/7/25 21:41
 * @Description:
 * @Version: 1.0
 **/
public enum ResponseMessage {

    INVALID_ACCOUNT(1, "invalid account"),
    ERROR_PWD(1, "invalid password");
    public final int code;
    public final String msg;

    ResponseMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
