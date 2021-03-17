package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginVo implements RowMapper<List<LoginVo>> {
    private Integer id;
    private String loginName;
    private String name;
    private String passwd;
    private Integer roleId;
    private String rName;
    private String perm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    @Override
    public List<LoginVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<LoginVo> loginVo = new ArrayList<>();
        do {
            LoginVo login = new LoginVo();
            login.setId(resultSet.getInt("id"));
            login.setLoginName(resultSet.getString("login_name"));
            login.setName(resultSet.getString("name"));
            login.setPasswd(resultSet.getString("passwd"));
            login.setRoleId(resultSet.getInt("role_id"));
            login.setrName(resultSet.getString("rname"));
            login.setPerm(resultSet.getString("perm"));
            loginVo.add(login);
        } while (resultSet.next());
        return loginVo;
    }
}
