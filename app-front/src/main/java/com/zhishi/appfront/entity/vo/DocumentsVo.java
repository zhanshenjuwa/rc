package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentsVo implements RowMapper<List<DocumentsVo>> {
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
    private String date;
    private Integer state;
    private String scDate;
    private String zfDate;
    private Integer certificatesStatus;
    private Integer different;
    private String bankNum;
    private String dcName;
    private String baName;
    private String vName;
    private Date ksDate;
    private BigDecimal syhkje;
    private BigDecimal dfje;

    public BigDecimal getDfje() {
        return dfje;
    }

    public void setDfje(BigDecimal dfje) {
        this.dfje = dfje;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getBaName() {
        return baName;
    }

    public void setBaName(String baName) {
        this.baName = baName;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public BigDecimal getSyhkje() {
        return syhkje;
    }

    public void setSyhkje(BigDecimal syhkje) {
        this.syhkje = syhkje;
    }

    public Date getKsDate() {
        return ksDate;
    }

    public void setKsDate(Date ksDate) {
        this.ksDate = ksDate;
    }


    @Override
    public List<DocumentsVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<DocumentsVo> documentsVo = new ArrayList<>();
        do {
            DocumentsVo documents = new DocumentsVo();
            documents.setId(resultSet.getInt("id"));
            documents.setNum(resultSet.getString("num"));
            documents.setDcId(resultSet.getInt("dc_id"));
            documents.setBankId(resultSet.getInt("bank_id"));
            documents.setLoanAmount(resultSet.getBigDecimal("loan_amount"));
            documents.setDuration(resultSet.getInt("duration"));
            documents.setHouseStatus(resultSet.getInt("house_status"));
            documents.setAddress(resultSet.getString("address"));
            documents.setPropertyCertificate(resultSet.getString("property_certificate"));
            documents.setHouseCost(resultSet.getBigDecimal("house_cost"));
            documents.setArea(resultSet.getBigDecimal("area"));
            documents.setVillageId(resultSet.getInt("village_id"));
            documents.setBuilding(resultSet.getString("building"));
            documents.setUnit(resultSet.getString("unit"));
            documents.setHouse(resultSet.getString("house"));
            documents.setDate(resultSet.getString("date"));
            documents.setState(resultSet.getInt("state"));
            documents.setScDate(resultSet.getString("sc_date"));
            documents.setZfDate(resultSet.getString("zf_date"));
            documents.setCertificatesStatus(resultSet.getInt("certificates_status"));
            documents.setDifferent(resultSet.getInt("different"));
            documents.setBankNum(resultSet.getString("bank_num"));
            documents.setDcName(resultSet.getString("dc_name"));
            documents.setBaName(resultSet.getString("ba_name"));
            documents.setvName(resultSet.getString("v_name"));
            documents.setKsDate(resultSet.getDate("ks_date"));
            documents.setSyhkje(resultSet.getBigDecimal("syhkje"));
            documents.setDfje(resultSet.getBigDecimal("dfje"));
            documentsVo.add(documents);
        } while (resultSet.next());
        return documentsVo;
    }
}
