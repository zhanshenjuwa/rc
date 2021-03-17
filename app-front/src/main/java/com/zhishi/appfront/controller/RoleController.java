package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.RoleRequestDto;
import com.zhishi.appfront.entity.vo.RoleVo;
import com.zhishi.appfront.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @CrossOrigin
    @PostMapping("/selectRole")
    public EquityResult selectRole(@RequestBody PageRequest pageRequest) {
        int plateInfoCount = roleService.getRoleCount();
        List<RoleVo> result = roleService.getRole(pageRequest);
        int totalPageNum = plateInfoCount % pageRequest.getPageSize() == 0 ? plateInfoCount / pageRequest.getPageSize() : plateInfoCount / pageRequest.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, false);
        }
        return new PageResponse("查看成功", result, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, totalPageNum - pageRequest.getPageNum() < 1 ? false : true);
    }

    @CrossOrigin
    @PostMapping("/addRole")
    public EquityResult addRole(@RequestBody RoleRequestDto roleRequestDto) {
        return new EquityResult("查询成功", roleService.addRole(roleRequestDto), 0);
    }

    @CrossOrigin
    @PostMapping("/deleteRole")
    public EquityResult deleteRole(@RequestBody RoleRequestDto roleRequestDto) {
        roleService.deleteRole(roleRequestDto.getId());
        return new EquityResult("查询成功", "", 0);
    }

    @CrossOrigin
    @PostMapping("/updateRole")
    public EquityResult updateRole(@RequestBody RoleRequestDto roleRequestDto) {
        roleService.updateRole(roleRequestDto);
        return new EquityResult("查询成功", "", 0);
    }
}
