package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.EmployeeRequestDto;
import com.zhishi.appfront.entity.dto.request.PasswdRequestDto;
import com.zhishi.appfront.entity.vo.EmployeeVo;
import com.zhishi.appfront.entity.vo.LoginVo;
import com.zhishi.appfront.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public EquityResult addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        int con = employeeService.selectEmployeeByLoginName(employeeRequestDto.getLoginName());
        if (con > 0) {
            return new EquityResult("用户已存在", "", -1);
        }
        return new EquityResult("操作成功", employeeService.addEmployee(employeeRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public EquityResult deleteEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.deleteEmployee(employeeRequestDto.getId());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public EquityResult updateEmployee(@RequestBody EmployeeRequestDto employeeRequestDto) {
        boolean flag = true;
        String perm = employeeService.getRolePerm(employeeRequestDto.getuId());
        if (employeeRequestDto.getId() != employeeRequestDto.getuId()) {
            String[] str = perm.split(",");
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("10")) {
                    flag = false;
                }
            }
            if (flag) {
                return new EquityResult("无权限修改", "", -1);
            }
        }
        String name = employeeService.getLoginName(employeeRequestDto.getId());
        if (!name.equals(employeeRequestDto.getLoginName())) {
            int con = employeeService.selectEmployeeByLoginName(employeeRequestDto.getLoginName());
            if (con > 0) {
                return new EquityResult("用户已存在", "", -1);
            }
        }
        employeeService.updateEmployee(employeeRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public EquityResult login(@RequestBody EmployeeRequestDto employeeRequestDto) {
        LoginVo loginVo = employeeService.login(employeeRequestDto.getLoginName(), employeeRequestDto.getPasswd());
        if (loginVo.getId() == null) {
            return new EquityResult("账号或密码错误", "", -1);
        }
        return new EquityResult("操作成功", loginVo, 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/selectEmployee", method = RequestMethod.POST)
    public EquityResult selectEmployee(@RequestBody PageRequest pageRequest) {
        int plateInfoCount = employeeService.selectEmployeeCount();
        List<EmployeeVo> result = employeeService.selectEmployee(pageRequest);
        int totalPageNum = plateInfoCount % pageRequest.getPageSize() == 0 ? plateInfoCount / pageRequest.getPageSize() : plateInfoCount / pageRequest.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, false);
        }
        return new PageResponse("查看成功", result, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, totalPageNum - pageRequest.getPageNum() < 1 ? false : true);
    }


    @CrossOrigin
    @RequestMapping(value = "/resetPasswd", method = RequestMethod.POST)
    public EquityResult resetPasswd(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.resetPasswd(employeeRequestDto.getId(), employeeRequestDto.getPasswd());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updatePasswd", method = RequestMethod.POST)
    public EquityResult updatePasswd(@RequestBody PasswdRequestDto passwdRequestDto) {
        String passwd = employeeService.getPasswd(passwdRequestDto.getuId());
        if (passwd.equals(passwdRequestDto.getOldPass())) {
            employeeService.updatePasswd(passwdRequestDto);
            return new EquityResult("操作成功", "", 0);
        } else {
            return new EquityResult("旧密码输入错误", "", -1);
        }
    }
}
