package com.gaolaodaye.haijia.exception;

public class UserException extends RuntimeException {
    public static final int USER_NOT_LOGIN = 10;

    public static final int DATA_EXCEPTION = 20;
    int code = 0;
    String msg;

    public UserException() {

    }

    public UserException(int code) {
        this.code = code;
        String msg;
        switch (code) {
            case USER_NOT_LOGIN:
                msg = "未登录";
                break;
            case DATA_EXCEPTION:
                msg = "数据异常";
            default:
                msg = "其他异常";
        }
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
