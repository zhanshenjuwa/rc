package com.zhishi.appfront.dao;

import com.zhishi.appfront.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StatisticsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getDbhs(String start, String end, Integer dcId) {
        try {
            String sql = "select COUNT(*) from documents where `date`>? and `date`<? and dc_id=? and state=?";
            return jdbcTemplate.queryForObject(sql, Integer.class, start, end, dcId, ConstantUtil.ZTZC);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer getZxhs(String start, String end, Integer dcId) {
        try {
            String sql = "select COUNT(*) from operate o  left join documents d on o.d_id=d.id where o.`date`>? and o.`date`<? and o.`type`=? and d.dc_id=?";
            return jdbcTemplate.queryForObject(sql, Integer.class, start, end, ConstantUtil.QZX, dcId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer getZxihs(String start, String end, Integer dcId) {
        try {
            String sql = "select COUNT(*) from operate o  left join documents d on o.d_id=d.id  where o.`date`>? and o.`date`<? and o.`type`=? and d.dc_id=?";
            return jdbcTemplate.queryForObject(sql, Integer.class, start, end, ConstantUtil.ZFHYDA, dcId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public BigDecimal getDbje(String start, String end, Integer dcId) {
        try {
            String sql = "select sum(syhkje) from documents where `date`>? and `date`<? and dc_id=? and state=?";
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, start, end, dcId, ConstantUtil.ZTZC);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public BigDecimal getZxje(String start, String end, Integer dcId) {
        try {
            String sql = "select sum(loan_amount) from documents d right join operate o on d.id=o.d_id where o.date>? and o.date<? and o.`type`=? and d.dc_id=?";
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, start, end, ConstantUtil.QZX, dcId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public BigDecimal getDbzje(String start, String end, Integer dcId) {
        try {
            String sql = "select sum(loan_amount) from documents where `date`>? and `date`<? and dc_id=? and state=?";
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, start, end, dcId, ConstantUtil.ZTZC);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
