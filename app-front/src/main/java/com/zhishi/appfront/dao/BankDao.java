package com.zhishi.appfront.dao;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.entity.dto.request.BankRequestDto;
import com.zhishi.appfront.entity.vo.BankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class BankDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addBank(BankRequestDto bankRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `bank` (`name`,`memo`) VALUES (?,?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, bankRequestDto.getName());
                ps.setObject(2, bankRequestDto.getMemo());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteBank(Integer id) {
        String sql = "delete from bank where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<BankVo> selectBank(PageRequest pageRequest) {
        List<BankVo> list = new ArrayList();
        try {
            String sql = "SELECT * FROM bank ";
            if (pageRequest.getPageNum() > 0) {
                sql += " limit " + (pageRequest.getPageNum() - 1) * pageRequest.getPageSize() + "," + pageRequest.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new BankVo());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void updateBank(BankRequestDto bankRequestDto) {
        String sql = "update bank set name=?,memo=? where id=?";
        jdbcTemplate.update(sql, bankRequestDto.getName(), bankRequestDto.getMemo(), bankRequestDto.getId());
    }

    public Integer selectBankCount() {
        String sql = "select COUNT(*) from bank ";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
