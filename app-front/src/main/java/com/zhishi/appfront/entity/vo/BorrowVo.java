package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowVo implements RowMapper<List<BorrowVo>> {

    private Integer id;
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

    @Override
    public List<BorrowVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<BorrowVo> borrowVo = new ArrayList<>();
        do {
            BorrowVo borrow = new BorrowVo();
            borrow.setId(resultSet.getInt("id"));
            borrow.setdId(resultSet.getInt("d_id"));
            borrow.setBorrowCode(resultSet.getString("borrow_code"));
            borrow.setBorrowName(resultSet.getString("borrow_name"));
            borrow.setBorrowPhone(resultSet.getString("borrow_phone"));
            borrow.setBorrowSpouseCode(resultSet.getString("borrow_spouse_code"));
            borrow.setBorrowSpouseName(resultSet.getString("borrow_spouse_name"));
            borrow.setBorrowSpousePhone(resultSet.getString("borrow_spouse_phone"));
            borrow.setMarried(resultSet.getInt("married"));
            borrow.setAct(resultSet.getInt("act"));
            borrow.setActName(resultSet.getString("act_name"));
            borrow.setActCode(resultSet.getString("act_code"));
            borrowVo.add(borrow);
        } while (resultSet.next());
        return borrowVo;
    }
}
