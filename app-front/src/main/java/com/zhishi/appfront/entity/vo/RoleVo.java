package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleVo implements RowMapper<List<RoleVo>> {
    private Integer id;
    private String name;
    private String perm;

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

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    @Override
    public List<RoleVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<RoleVo> roleVo = new ArrayList<>();
        do {
            RoleVo role = new RoleVo();
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("name"));
            role.setPerm(resultSet.getString("perm"));
            roleVo.add(role);
        } while (resultSet.next());
        return roleVo;
    }
}
