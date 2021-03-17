package com.zhishi.appfront.entity.dto.request;

public class BorrowRequestDto {
    private Integer id;
    private Integer uId;
    private Integer dId;
    private String borrowCode;
    private String borrowName;
    private String borrowPhone;
    private String borrowSpouseCode;
    private String borrowSpouseName;
    private String borrowSpousePhone;
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

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getBorrowPhone() {
        return borrowPhone;
    }

    public void setBorrowPhone(String borrowPhone) {
        this.borrowPhone = borrowPhone;
    }

    public String getBorrowSpouseCode() {
        return borrowSpouseCode;
    }

    public void setBorrowSpouseCode(String borrowSpouseCode) {
        this.borrowSpouseCode = borrowSpouseCode;
    }

    public String getBorrowSpouseName() {
        return borrowSpouseName;
    }

    public void setBorrowSpouseName(String borrowSpouseName) {
        this.borrowSpouseName = borrowSpouseName;
    }

    public String getBorrowSpousePhone() {
        return borrowSpousePhone;
    }

    public void setBorrowSpousePhone(String borrowSpousePhone) {
        this.borrowSpousePhone = borrowSpousePhone;
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
}
