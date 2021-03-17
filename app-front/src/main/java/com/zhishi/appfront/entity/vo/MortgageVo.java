package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MortgageVo implements RowMapper<List<MortgageVo>> {

    private Integer id;
    private Integer dId;
    private String mortgageName;
    private String mortgagePhone;
    private String mortgageCode;
    private String mortgageSpouseName;
    private String mortgageSpousePhone;
    private String mortgageSpouseCode;
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

    @Override
    public List<MortgageVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<MortgageVo> mortgageVo = new ArrayList<>();
        do {
            MortgageVo mortgage = new MortgageVo();
            mortgage.setId(resultSet.getInt("id"));
            mortgage.setdId(resultSet.getInt("d_id"));
            mortgage.setMortgageName(resultSet.getString("mortgage_name"));
            mortgage.setMortgagePhone(resultSet.getString("mortgage_phone"));
            mortgage.setMortgageSpouseName(resultSet.getString("mortgage_spouse_name"));
            mortgage.setMortgageSpousePhone(resultSet.getString("mortgage_spouse_phone"));
            mortgage.setMarried(resultSet.getInt("married"));
            mortgage.setAct(resultSet.getInt("act"));
            mortgage.setActName(resultSet.getString("act_name"));
            mortgage.setActCode(resultSet.getString("act_code"));
            mortgage.setMortgageCode(resultSet.getString("mortgage_code"));
            mortgage.setMortgageSpouseCode(resultSet.getString("mortgage_spouse_code"));
            mortgageVo.add(mortgage);
        } while (resultSet.next());
        return mortgageVo;
    }
}
