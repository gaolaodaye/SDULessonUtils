package com.gaolaodaye.haijia.dto;

public class XnsdDto {
    private String Xnsd;
    private String XnsdName;

    public String getXnsd() {
        return Xnsd;
    }

    public void setXnsd(String xnsd) {
        Xnsd = xnsd;
    }

    public String getXnsdName() {
        return XnsdName;
    }

    public void setXnsdName(String xnsdName) {
        XnsdName = xnsdName;
    }

    @Override
    public String toString() {
        return "XnsdDto{" +
                "Xnsd='" + Xnsd + '\'' +
                ", XnsdName='" + XnsdName + '\'' +
                '}';
    }
}
