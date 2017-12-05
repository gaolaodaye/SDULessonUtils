package com.gaolaodaye.haijia.dto;

public class LessonDto {
    private String JLCBH;
    private String CNBH;
    private String YT;
    private String JLYXM;

    public String getJLCBH() {
        return JLCBH;
    }

    public void setJLCBH(String JLCBH) {
        this.JLCBH = JLCBH;
    }

    public String getCNBH() {
        return CNBH;
    }

    public void setCNBH(String CNBH) {
        this.CNBH = CNBH;
    }

    public String getYT() {
        return YT;
    }

    public void setYT(String YT) {
        this.YT = YT;
    }

    public String getJLYXM() {
        return JLYXM;
    }

    public void setJLYXM(String JLYXM) {
        this.JLYXM = JLYXM;
    }

    @Override
    public String toString() {
        return "LessonDto{" +
                "JLCBH='" + JLCBH + '\'' +
                ", CNBH='" + CNBH + '\'' +
                ", YT='" + YT + '\'' +
                ", JLYXM='" + JLYXM + '\'' +
                '}';
    }
}
