package com.zhishi.appfront.service;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.dao.EmployeeDao;
import com.zhishi.appfront.entity.dto.request.EmployeeRequestDto;
import com.zhishi.appfront.entity.dto.request.PasswdRequestDto;
import com.zhishi.appfront.entity.vo.EmployeeVo;
import com.zhishi.appfront.entity.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Integer addEmployee(EmployeeRequestDto employeeRequestDto) {
        return employeeDao.addEmployee(employeeRequestDto);
    }

    public void deleteEmployee(Integer id) {
        employeeDao.deleteEmployee(id);
    }

    public void updateEmployee(EmployeeRequestDto employeeRequestDto) {
        employeeDao.updateEmployee(employeeRequestDto);
    }

    public LoginVo login(String loginName, String passwd) {
        List<LoginVo> list = employeeDao.login(loginName, passwd);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return new LoginVo();
        }
    }

    public List<EmployeeVo> selectEmployee(PageRequest pageRequest) {
        return employeeDao.selectEmployee(pageRequest);
    }

    public void resetPasswd(Integer id, String passwd) {
        employeeDao.resetPasswd(id,passwd);
    }

    public void updatePasswd(PasswdRequestDto passwdRequestDto) {
        employeeDao.resetPasswd(passwdRequestDto.getuId(),passwdRequestDto.getNewPass());
    }

    public String getPasswd(Integer uId) {
        return employeeDao.getPasswd(uId);
    }

    public Integer selectEmployeeCount() {
        return employeeDao.selectEmployeeCount();
    }

    public Integer selectEmployeeByLoginName(String loginName) {
        return employeeDao.selectEmployeeByLoginName(loginName);
    }

    public String getLoginName(Integer id) {
        return employeeDao.getLoginName(id);
    }

    public String getRolePerm(Integer id) {
        return employeeDao.getRolePerm(id);
    }
}
