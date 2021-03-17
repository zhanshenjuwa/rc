package com.zhishi.appfront.entity.dto.request;

import java.math.BigDecimal;
import java.util.List;

public class DocumentsRequestDto {
    //基本信息
    private String num;
    private Integer dcId;
    private Integer bankId;
    private BigDecimal loanAmount;
    private Integer duration;
    private Integer houseStatus;
    private String address;
    private String propertyCertificate;
    private BigDecimal houseCost;
    private BigDecimal area;
    private Integer villageId;
    private String building;
    private String unit;
    private String house;
    private String date;
    private Integer certificatesStatus;
    private Integer different;
    private String bankNum;
    private String ksDate;
    private BigDecimal syhkje;

    public BigDecimal getSyhkje() {
        return syhkje;
    }

    public void setSyhkje(BigDecimal syhkje) {
        this.syhkje = syhkje;
    }

    //借款人
    private List<BorrowRequestDto> borrowRequestDto;
    //抵押人
    private List<MortgageRequestDto> mortgageRequestDto;
    //其他
    private Integer uId;
    private Integer id;
    private Integer zfhy;  //1 作废  2  还原

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getDcId() {
        return dcId;
    }

    public void setDcId(Integer dcId) {
        this.dcId = dcId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Integer houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPropertyCertificate() {
        return propertyCertificate;
    }

    public void setPropertyCertificate(String propertyCertificate) {
        this.propertyCertificate = propertyCertificate;
    }

    public BigDecimal getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(BigDecimal houseCost) {
        this.houseCost = houseCost;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<BorrowRequestDto> getBorrowRequestDto() {
        return borrowRequestDto;
    }

    public void setBorrowRequestDto(List<BorrowRequestDto> borrowRequestDto) {
        this.borrowRequestDto = borrowRequestDto;
    }

    public List<MortgageRequestDto> getMortgageRequestDto() {
        return mortgageRequestDto;
    }

    public void setMortgageRequestDto(List<MortgageRequestDto> mortgageRequestDto) {
        this.mortgageRequestDto = mortgageRequestDto;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZfhy() {
        return zfhy;
    }

    public void setZfhy(Integer zfhy) {
        this.zfhy = zfhy;
    }

    public Integer getCertificatesStatus() {
        return certificatesStatus;
    }

    public void setCertificatesStatus(Integer certificatesStatus) {
        this.certificatesStatus = certificatesStatus;
    }

    public Integer getDifferent() {
        return different;
    }

    public void setDifferent(Integer different) {
        this.different = different;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getKsDate() {
        return ksDate;
    }

    public void setKsDate(String ksDate) {
        this.ksDate = ksDate;
    }
}
