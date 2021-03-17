package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeVo implements RowMapper<List<EmployeeVo>> {
    private Integer id;
    private String loginName;
    private String name;
    private Integer roleId;
    private String rName;

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

    @Override
    public List<EmployeeVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<EmployeeVo> employeeVo = new ArrayList<>();
        do {
            EmployeeVo employee = new EmployeeVo();
            employee.setId(resultSet.getInt("id"));
            employee.setLoginName(resultSet.getString("login_name"));
            employee.setName(resultSet.getString("name"));
            employee.setRoleId(resultSet.getInt("role_id"));
            employee.setrName(resultSet.getString("rname"));
            employeeVo.add(employee);
        } while (resultSet.next());
        return employeeVo;
    }
}
