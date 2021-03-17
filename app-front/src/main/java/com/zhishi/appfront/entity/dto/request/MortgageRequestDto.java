package com.zhishi.appfront.entity.dto.request;

public class MortgageRequestDto {
    private Integer id;
    private Integer uId;
    private Integer dId;
    private String mortgageCode;
    private String mortgageName;
    private String mortgagePhone;
    private String mortgageSpouseCode;
    private String mortgageSpouseName;
    private String mortgageSpousePhone;
    private Integer married;
    private Integer act;
    private String actName;
    private String actCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getMortgageName() {
        return mortgageName;
    }

    public void setMortgageName(String mortgageName) {
        this.mortgageName = mortgageName;
    }

    public String getMortgagePhone() {
        return mortgagePhone;
    }

    public void setMortgagePhone(String mortgagePhone) {
        this.mortgagePhone = mortgagePhone;
    }

    public String getMortgageSpouseName() {
        return mortgageSpouseName;
    }

    public void setMortgageSpouseName(String mortgageSpouseName) {
        this.mortgageSpouseName = mortgageSpouseName;
    }

    public String getMortgageSpousePhone() {
        return mortgageSpousePhone;
    }

    public void setMortgageSpousePhone(String mortgageSpousePhone) {
        this.mortgageSpousePhone = mortgageSpousePhone;
    }

    public Integer getAct() {
        return act;
    }

    public void setAct(Integer act) {
        this.act = act;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActCode() {
        return actCode;
    }

    public void setActCode(String actCode) {
        this.actCode = actCode;
    }

    public Integer getMarried() {
        return married;
    }

    public void setMarried(Integer married) {
        this.married = married;
    }

    public String getMortgageCode() {
        return mortgageCode;
    }

    public void setMortgageCode(String mortgageCode) {
        this.mortgageCode = mortgageCode;
    }

    public String getMortgageSpouseCode() {
        return mortgageSpouseCode;
    }

    public void setMortgageSpouseCode(String mortgageSpouseCode) {
        this.mortgageSpouseCode = mortgageSpouseCode;
    }
}
