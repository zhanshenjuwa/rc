package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.dto.request.FileRequestDto;
import com.zhishi.appfront.entity.vo.FileVo;
import com.zhishi.appfront.util.ConstantUtil;
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
public class FileDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addFile(FileRequestDto fileRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `file` (`d_id`, `url`, `name`,`state`) VALUES ( ?, ?, ?,?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, fileRequestDto.getdId());
                ps.setObject(2, fileRequestDto.getUrl());
                ps.setObject(3, fileRequestDto.getName());
                ps.setObject(4, ConstantUtil.ZTXZ);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteFile(FileRequestDto fileRequestDto) {
        String sql = "update `file` set state=? where id=?";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(ConstantUtil.ZTSC);
        params.add(fileRequestDto.getId());
        jdbcTemplate.update(sql, params.toArray());
    }

    public List<FileVo> selectFileByDid(Integer id) {
        List<FileVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM file WHERE d_id=? AND state=?", new FileVo(), id, ConstantUtil.ZTXZ);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void deleteFileByDid(Integer id) {
        String sql = "delete from file where d_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public String getUrl(Integer fId) {
        try {
            String sql = "SELECT url from  `file` where id=?";
            return jdbcTemplate.queryForObject(sql, String.class, fId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Integer> getIdByDid(Integer dId) {
        try {
            String sql = "SELECT id from  `file` where d_id=?";
            return jdbcTemplate.queryForList(sql, Integer.class, dId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
