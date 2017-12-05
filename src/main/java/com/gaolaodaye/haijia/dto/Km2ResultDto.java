package com.gaolaodaye.haijia.dto;

import java.util.List;

public class Km2ResultDto {
    private List<XnsdDto> XnsdList;
    private List<YyrqDto>YyrqList;
    private List<UIDatasDto> UIDatas;
    private List<LessonDto> Result;
    private Integer Total;


    public List<XnsdDto> getXnsdList() {
        return XnsdList;
    }

    public void setXnsdList(List<XnsdDto> xnsdList) {
        XnsdList = xnsdList;
    }

    public List<YyrqDto> getYyrqList() {
        return YyrqList;
    }

    public void setYyrqList(List<YyrqDto> yyrqList) {
        YyrqList = yyrqList;
    }

    public List<UIDatasDto> getUIDatas() {
        return UIDatas;
    }

    public void setUIDatas(List<UIDatasDto> UIDatas) {
        this.UIDatas = UIDatas;
    }

    public List<LessonDto> getResult() {
        return Result;
    }

    public void setResult(List<LessonDto> result) {
        Result = result;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    @Override
    public String toString() {
        return "Km2ResultDto{" +
                "XnsdList=" + XnsdList +
                ", YyrqList=" + YyrqList +
                ", UIDatas=" + UIDatas +
                ", Result=" + Result +
                ", Total=" + Total +
                '}';
    }
}

