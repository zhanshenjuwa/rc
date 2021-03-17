package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperateVo implements RowMapper<List<OperateVo>> {
    private Integer id;
    private Integer uId;
    private Integer dId;
    private String date;
    private Integer type;
    private String change;
    private String uName;
    private String num;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public List<OperateVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<OperateVo> operateVo = new ArrayList<>();
        do {
            OperateVo operate = new OperateVo();
            operate.setId(resultSet.getInt("id"));
            operate.setuId(resultSet.getInt("u_id"));
            operate.setdId(resultSet.getInt("d_id"));
            operate.setChange(resultSet.getString("change"));
            operate.setDate(resultSet.getString("date"));
            operate.setType(resultSet.getInt("type"));
            operate.setNum(resultSet.getString("num"));
            operate.setuName(resultSet.getString("eName"));
            operateVo.add(operate);
        } while (resultSet.next());
        return operateVo;
    }
}
