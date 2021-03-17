package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentsClassificationVo implements RowMapper<List<DocumentsClassificationVo>> {
    private Integer id;
    private String name;
    private Integer sqbNum;
    private Integer htNum;
    private Integer xyNum;

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

    public Integer getSqbNum() {
        return sqbNum;
    }

    public void setSqbNum(Integer sqbNum) {
        this.sqbNum = sqbNum;
    }

    public Integer getHtNum() {
        return htNum;
    }

    public void setHtNum(Integer htNum) {
        this.htNum = htNum;
    }

    public Integer getXyNum() {
        return xyNum;
    }

    public void setXyNum(Integer xyNum) {
        this.xyNum = xyNum;
    }

    @Override
    public List<DocumentsClassificationVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<DocumentsClassificationVo> documentsClassificationVo = new ArrayList<>();
            do {
            DocumentsClassificationVo documentsClassification = new DocumentsClassificationVo();
                documentsClassification.setId(resultSet.getInt("id"));
                documentsClassification.setName(resultSet.getString("name"));
                documentsClassification.setSqbNum(resultSet.getInt("sqb_num"));
                documentsClassification.setHtNum(resultSet.getInt("ht_num"));
                documentsClassification.setXyNum(resultSet.getInt("xy_num"));
                documentsClassificationVo.add(documentsClassification);
        } while (resultSet.next());
        return documentsClassificationVo;
    }
}
