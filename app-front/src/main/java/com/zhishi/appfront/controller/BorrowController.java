package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.entity.dto.request.BorrowRequestDto;
import com.zhishi.appfront.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @CrossOrigin
    @RequestMapping(value = "/addBorrow", method = RequestMethod.POST)
    public EquityResult addBorrow(@RequestBody BorrowRequestDto borrowRequestDto) {
        return new EquityResult("操作成功", borrowService.addBorrow(borrowRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteBorrow", method = RequestMethod.POST)
    public EquityResult deleteBorrow(@RequestBody BorrowRequestDto borrowRequestDto) {
        borrowService.deleteBorrow(borrowRequestDto.getId(), borrowRequestDto.getuId(), borrowRequestDto.getdId());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateBorrow", method = RequestMethod.POST)
    public EquityResult updateMortgage(@RequestBody BorrowRequestDto borrowRequestDto) {
        borrowService.updateBorrow(borrowRequestDto);
        return new EquityResult("操作成功", "", 0);
    }
}
