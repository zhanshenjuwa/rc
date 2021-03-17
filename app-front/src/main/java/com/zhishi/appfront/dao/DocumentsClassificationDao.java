package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.dto.request.DocumentsClassificationRequestDto;
import com.zhishi.appfront.entity.vo.DocumentsClassificationVo;
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
public class DocumentsClassificationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addDocumentsClassification(DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `documents_classification` (`name`, `sqb_num`, `ht_num`, `xy_num`) VALUES ( ?, ?, ?, ?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, documentsClassificationRequestDto.getName());
                ps.setObject(2, documentsClassificationRequestDto.getSqbNum());
                ps.setObject(3, documentsClassificationRequestDto.getHtNum());
                ps.setObject(4, documentsClassificationRequestDto.getXyNum());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public List<DocumentsClassificationVo> selectDocumentsClassification() {
        List<DocumentsClassificationVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM  documents_classification", new DocumentsClassificationVo());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void deleteDocumentsClassification(Integer id) {
        String sql = "delete from documents_classification where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateDocumentsClassification(DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        String sql = "UPDATE `documents_classification` SET `name`=?, `sqb_num`=?, `ht_num`=?, `xy_num`=?  WHERE id=?";
        jdbcTemplate.update(sql, documentsClassificationRequestDto.getName(), documentsClassificationRequestDto.getSqbNum(), documentsClassificationRequestDto.getHtNum(), documentsClassificationRequestDto.getXyNum(), documentsClassificationRequestDto.getId());
    }

    public List<Integer> getDocumentsClassification() {
        List<Integer> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList("select id from documents_classification", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public String getDocumentsClassificationNameById(Integer i) {
        try {
            String sql = "SELECT name from  `documents_classification` where id=?";
            return jdbcTemplate.queryForObject(sql, String.class, i);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
