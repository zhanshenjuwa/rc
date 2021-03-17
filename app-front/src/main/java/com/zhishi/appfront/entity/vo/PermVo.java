package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermVo implements RowMapper<List<PermVo>> {
    private Integer id;
    private String name;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public List<PermVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<PermVo> permVo = new ArrayList<>();
        do {
            PermVo perm = new PermVo();
            perm.setId(resultSet.getInt("id"));
            perm.setName(resultSet.getString("name"));
            perm.setType(resultSet.getString("type"));
            permVo.add(perm);
        } while (resultSet.next());
        return permVo;
    }
}
