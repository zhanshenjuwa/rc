package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileVo implements RowMapper<List<FileVo>> {
    private Integer id;
    private Integer dId;
    private String url;
    private String name;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public List<FileVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<FileVo> fileVo = new ArrayList<>();
        do {
            FileVo file = new FileVo();
            file.setId(resultSet.getInt("id"));
            file.setdId(resultSet.getInt("d_id"));
            file.setName(resultSet.getString("name"));
            file.setUrl(resultSet.getString("url"));
            file.setState(resultSet.getInt("state"));
            fileVo.add(file);
        } while (resultSet.next());
        return fileVo;
    }
}
