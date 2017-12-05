package com.gaolaodaye.haijia.dto;

public class YyrqDto {
    private String Yyrq;
    private String DisplayWeek;
    private String DisplayYyrq;

    public String getYyrq() {
        return Yyrq;
    }

    public void setYyrq(String yyrq) {
        Yyrq = yyrq;
    }

    public String getDisplayWeek() {
        return DisplayWeek;
    }

    public void setDisplayWeek(String displayWeek) {
        DisplayWeek = displayWeek;
    }

    public String getDisplayYyrq() {
        return DisplayYyrq;
    }

    public void setDisplayYyrq(String displayYyrq) {
        DisplayYyrq = displayYyrq;
    }

    @Override
    public String toString() {
        return "YyrqDto{" +
                "Yyrq='" + Yyrq + '\'' +
                ", DisplayWeek='" + DisplayWeek + '\'' +
                ", DisplayYyrq='" + DisplayYyrq + '\'' +
                '}';
    }
}
