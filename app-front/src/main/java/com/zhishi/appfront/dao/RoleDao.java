package com.zhishi.appfront.dao;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.entity.dto.request.RoleRequestDto;
import com.zhishi.appfront.entity.vo.RoleVo;
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
public class RoleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RoleVo> getRole(PageRequest pageRequest) {
        List<RoleVo> list = new ArrayList();
        try {
            String sql = "SELECT * FROM role ";
            if (pageRequest.getPageNum() > 0) {
                sql += " limit " + (pageRequest.getPageNum() - 1) * pageRequest.getPageSize() + "," + pageRequest.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new RoleVo());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public Integer addRole(RoleRequestDto roleRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `role` (`name`, `perm`) VALUES (?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, roleRequestDto.getName());
                ps.setObject(2, roleRequestDto.getPerm());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteRole(Integer id) {
        String sql = "delete from `role` where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void updateRole(RoleRequestDto roleRequestDto) {
        String sql = "update `role` set `name`=?,`perm`=? where id=?";
        jdbcTemplate.update(sql, roleRequestDto.getName(), roleRequestDto.getPerm(), roleRequestDto.getId());
    }

    public Integer getRoleCount() {
        String sql = "select COUNT(*) from role ";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
