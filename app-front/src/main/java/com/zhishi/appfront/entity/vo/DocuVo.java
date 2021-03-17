package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocuVo implements RowMapper<List<DocuVo>> {

    private Integer id;
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
    private Date date;
    private Integer state;
    private String scDate;
    private String zfDate;
    private Integer certificatesStatus;
    private Integer different;
    private Date ksDate;
    private BigDecimal syhkje;

    public BigDecimal getSyhkje() {
        return syhkje;
    }

    public void setSyhkje(BigDecimal syhkje) {
        this.syhkje = syhkje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getKsDate() {
        return ksDate;
    }

    public void setKsDate(Date ksDate) {
        this.ksDate = ksDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getScDate() {
        return scDate;
    }

    public void setScDate(String scDate) {
        this.scDate = scDate;
    }

    public String getZfDate() {
        return zfDate;
    }

    public void setZfDate(String zfDate) {
        this.zfDate = zfDate;
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

    @Override
    public List<DocuVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<DocuVo> docuVo = new ArrayList<>();
        do {
            DocuVo docu = new DocuVo();
            docu.setId(resultSet.getInt("id"));
            docu.setNum(resultSet.getString("num"));
            docu.setDcId(resultSet.getInt("dc_id"));
            docu.setBankId(resultSet.getInt("bank_id"));
            docu.setLoanAmount(resultSet.getBigDecimal("loan_amount"));
            docu.setDuration(resultSet.getInt("duration"));
            docu.setHouseStatus(resultSet.getInt("house_status"));
            docu.setAddress(resultSet.getString("address"));
            docu.setPropertyCertificate(resultSet.getString("property_certificate"));
            docu.setHouseCost(resultSet.getBigDecimal("house_cost"));
            docu.setArea(resultSet.getBigDecimal("area"));
            docu.setVillageId(resultSet.getInt("village_id"));
            docu.setBuilding(resultSet.getString("building"));
            docu.setUnit(resultSet.getString("unit"));
            docu.setHouse(resultSet.getString("house"));
            docu.setDate(resultSet.getDate("date"));
            docu.setState(resultSet.getInt("state"));
            docu.setScDate(resultSet.getString("sc_date"));
            docu.setZfDate(resultSet.getString("zf_date"));
            docu.setCertificatesStatus(resultSet.getInt("certificates_status"));
            docu.setDifferent(resultSet.getInt("different"));
            docu.setKsDate(resultSet.getDate("ks_date"));
            docu.setSyhkje(resultSet.getBigDecimal("syhkje"));
            docuVo.add(docu);
        } while (resultSet.next());
        return docuVo;
    }
}
