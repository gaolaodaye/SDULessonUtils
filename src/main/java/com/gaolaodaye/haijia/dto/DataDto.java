package com.gaolaodaye.haijia.dto;

public class DataDto<T> {

    private Integer code;
    private Integer type;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataDto{" +
                "code=" + code +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
