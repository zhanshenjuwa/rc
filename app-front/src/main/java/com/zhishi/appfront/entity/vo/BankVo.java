package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankVo implements RowMapper<List<BankVo>> {

    private Integer id;
    private String name;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public List<BankVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<BankVo> bankVo = new ArrayList<>();
        do {
            BankVo bank = new BankVo();
            bank.setId(resultSet.getInt("id"));
            bank.setName(resultSet.getString("name"));
            bank.setMemo(resultSet.getString("memo"));
            bankVo.add(bank);
        } while (resultSet.next());
        return bankVo;
    }
}