package com.zhishi.appfront.dao;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.entity.dto.request.EmployeeRequestDto;
import com.zhishi.appfront.entity.vo.EmployeeVo;
import com.zhishi.appfront.entity.vo.LoginVo;
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
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addEmployee(EmployeeRequestDto employeeRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `employee` ( `login_name`, `name`, `passwd`, `role_id`) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, employeeRequestDto.getLoginName());
                ps.setObject(2, employeeRequestDto.getName());
                ps.setObject(3, employeeRequestDto.getPasswd());
                if (employeeRequestDto.getRoleId() != null) {
                    ps.setObject(4, employeeRequestDto.getRoleId());
                } else {
                    ps.setObject(4, 1);
                }
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteEmployee(Integer id) {
        String sql = "delete from employee where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateEmployee(EmployeeRequestDto employeeRequestDto) {
        String sql = "update employee set login_name=?,`name`=?,`role_id`=? where id=?";
        jdbcTemplate.update(sql, employeeRequestDto.getLoginName(), employeeRequestDto.getName(), employeeRequestDto.getRoleId(), employeeRequestDto.getId());
    }

    public List<LoginVo> login(String loginName, String passwd) {
        List<LoginVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT e.*,r.name rname,r.perm  FROM employee e  left join role r on e.role_id=r.id where e.login_name=? and e.passwd=?", new LoginVo(), loginName, passwd);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public List<EmployeeVo> selectEmployee(PageRequest pageRequest) {
        List<EmployeeVo> list = new ArrayList();
        try {
            String sql = "SELECT e.*,r.name rname  FROM employee e left join role r on e.role_id=r.id ";
            if (pageRequest.getPageNum() > 0) {
                sql += " limit " + (pageRequest.getPageNum() - 1) * pageRequest.getPageSize() + "," + pageRequest.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new EmployeeVo());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void resetPasswd(Integer id, String passwd) {
        String sql = "update employee set  passwd=? where id=?";
        jdbcTemplate.update(sql, passwd, id);
    }

    public String getPasswd(Integer uId) {
        try {
            String sql = "SELECT passwd from  `employee` where id=?";
            return jdbcTemplate.queryForObject(sql, String.class, uId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer selectEmployeeCount() {
        String sql = "select COUNT(*) from `employee` ";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Integer selectEmployeeByLoginName(String loginName) {
        String sql = "select COUNT(*) from `employee` where login_name=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, loginName);
    }

    public String getLoginName(Integer id) {
        String sql = "select login_name from `employee` where id=?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    public String getRolePerm(Integer id) {
        String sql = "SELECT perm FROM `role` r LEFT JOIN employee e on r.id=e.role_id where e.id=?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }
}
