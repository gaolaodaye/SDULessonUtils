package com.gaolaodaye.haijia.domain;

import java.util.Map;

public class User {

    private String userName;
    private String password;
    private Map<String, String> cookieMap;
    private String xxzh;
    private Map<String,String> mapOption;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public Map<String, String> getCookieMap() {
        return cookieMap;
    }

    public void setCookieMap(Map<String, String> cookieMap) {
        this.cookieMap = cookieMap;
    }

    public String getXxzh() {
        return xxzh;
    }

    public void setXxzh(String xxzh) {
        this.xxzh = xxzh;
    }

    public Map<String, String> getMapOption() {
        return mapOption;
    }

    public void setMapOption(Map<String, String> mapOption) {
        this.mapOption = mapOption;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", cookieMap=" + cookieMap +
                ", xxzh='" + xxzh + '\'' +
                ", mapOption=" + mapOption +
                '}';
    }
}
