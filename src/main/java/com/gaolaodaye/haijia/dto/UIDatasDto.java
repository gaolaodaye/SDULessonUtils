package com.gaolaodaye.haijia.dto;

public class UIDatasDto {

    private String Yyrq;
    private Integer YyrqXH;
    private String Xnsd;
    private String XnsdName;
    private String QsName;
    private String Qsid;
    private Integer SL;
    private Integer KS;
    private Boolean IsBpked;
    private Integer IsBpked_SK;
    private Boolean IsCreate;
    private String YyClInfo;

    public String getYyrq() {
        return Yyrq;
    }

    public void setYyrq(String yyrq) {
        Yyrq = yyrq;
    }

    public Integer getYyrqXH() {
        return YyrqXH;
    }

    public void setYyrqXH(Integer yyrqXH) {
        YyrqXH = yyrqXH;
    }

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

    public String getQsName() {
        return QsName;
    }

    public void setQsName(String qsName) {
        QsName = qsName;
    }

    public String getQsid() {
        return Qsid;
    }

    public void setQsid(String qsid) {
        Qsid = qsid;
    }

    public Integer getSL() {
        return SL;
    }

    public void setSL(Integer SL) {
        this.SL = SL;
    }

    public Integer getKS() {
        return KS;
    }

    public void setKS(Integer KS) {
        this.KS = KS;
    }

    public Boolean getBpked() {
        return IsBpked;
    }

    public void setBpked(Boolean bpked) {
        IsBpked = bpked;
    }

    public Integer getIsBpked_SK() {
        return IsBpked_SK;
    }

    public void setIsBpked_SK(Integer isBpked_SK) {
        IsBpked_SK = isBpked_SK;
    }

    public Boolean getCreate() {
        return IsCreate;
    }

    public void setCreate(Boolean create) {
        IsCreate = create;
    }

    public String getYyClInfo() {
        return YyClInfo;
    }

    public void setYyClInfo(String yyClInfo) {
        YyClInfo = yyClInfo;
    }

    @Override
    public String toString() {
        return "UIDatasDto{" +
                "Yyrq='" + Yyrq + '\'' +
                ", YyrqXH=" + YyrqXH +
                ", Xnsd='" + Xnsd + '\'' +
                ", XnsdName='" + XnsdName + '\'' +
                ", QsName='" + QsName + '\'' +
                ", Qsid='" + Qsid + '\'' +
                ", SL=" + SL +
                ", KS=" + KS +
                ", IsBpked=" + IsBpked +
                ", IsBpked_SK=" + IsBpked_SK +
                ", IsCreate=" + IsCreate +
                ", YyClInfo='" + YyClInfo + '\'' +
                '}';
    }
}
