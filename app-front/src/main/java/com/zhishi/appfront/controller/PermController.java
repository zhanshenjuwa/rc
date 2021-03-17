package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PermController {

    @Autowired
    private PermService permService;

    @CrossOrigin
    @RequestMapping(value = "/selectPerm", method = RequestMethod.POST)
    public EquityResult selectPerm() {
        return new EquityResult("查询成功", permService.getPerm(), 0);
    }
}
