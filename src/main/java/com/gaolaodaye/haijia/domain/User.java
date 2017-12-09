package com.gaolaodaye.haijia.domain;

import java.util.Map;

public class User {

    private String userName;
    private String password;
    private String cookie;
    private String xxzh;

    public User() {

    }

    public User(String userName, String password, String cookie) {
        this.userName = userName;
        this.password = password;
        this.cookie = cookie;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getXxzh() {
        return xxzh;
    }

    public void setXxzh(String xxzh) {
        this.xxzh = xxzh;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cookie='" + cookie + '\'' +
                ", xxzh='" + xxzh + '\'' +
                '}';
    }
}
