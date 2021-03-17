package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.vo.PermVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PermVo> getPerm() {
        String sql = "SELECT * from perm";
        return jdbcTemplate.queryForObject(sql, new PermVo());
    }
}
