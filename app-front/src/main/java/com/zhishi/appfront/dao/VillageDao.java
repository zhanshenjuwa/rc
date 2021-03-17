package com.zhishi.appfront.dao;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.entity.dto.request.VillageRequestDto;
import com.zhishi.appfront.entity.vo.VillageVo;
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
public class VillageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addVillage(VillageRequestDto villageRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `village` (`name`, `memo`) VALUES (?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, villageRequestDto.getName());
                ps.setObject(2, villageRequestDto.getMemo());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteVillage(Integer id) {
        String sql = "delete from village where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateVillage(VillageRequestDto villageRequestDto) {
        String sql = "update village set `name`=?,memo=? where id=?";
        jdbcTemplate.update(sql, villageRequestDto.getName(), villageRequestDto.getMemo(), villageRequestDto.getId());
    }

    public List<VillageVo> selectVillage(PageRequest pageRequest) {
        List<VillageVo> list = new ArrayList();
        try {
            String sql = "SELECT *  FROM  village ";
            if (pageRequest.getPageNum() > 0) {
                sql += " limit " + (pageRequest.getPageNum() - 1) * pageRequest.getPageSize() + "," + pageRequest.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new VillageVo());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public Integer selectVillageCount() {
        String sql = "select COUNT(*) from village ";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
