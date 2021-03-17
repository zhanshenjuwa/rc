package com.zhishi.appfront.controller;


import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.BankRequestDto;
import com.zhishi.appfront.entity.vo.BankVo;
import com.zhishi.appfront.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 银行
 */
@RestController
public class BankController {

    @Autowired
    private BankService bankService;


    @CrossOrigin
    @RequestMapping(value = "/addBank", method = RequestMethod.POST)
    public EquityResult addBank(@RequestBody BankRequestDto bankRequestDto) {
        return new EquityResult("操作成功", bankService.addBank(bankRequestDto), 0);
    }


    @CrossOrigin
    @RequestMapping(value = "/deleteBank", method = RequestMethod.POST)
    public EquityResult deleteBank(@RequestBody BankRequestDto bankRequestDto) {
        bankService.deleteBank(bankRequestDto.getId());
        return new EquityResult("操作成功", "", 0);
    }


    @CrossOrigin
    @RequestMapping(value = "/selectBank", method = RequestMethod.POST)
    public EquityResult selectBank(@RequestBody PageRequest pageRequest) {
        int plateInfoCount = bankService.selectBankCount();
        List<BankVo> result = bankService.selectBank(pageRequest);
        int totalPageNum = plateInfoCount % pageRequest.getPageSize() == 0 ? plateInfoCount / pageRequest.getPageSize() : plateInfoCount / pageRequest.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, false);
        }
        return new PageResponse("查看成功", result, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, totalPageNum - pageRequest.getPageNum() < 1 ? false : true);
    }


    @CrossOrigin
    @RequestMapping(value = "/updateBank", method = RequestMethod.POST)
    public EquityResult updateBank(@RequestBody BankRequestDto bankRequestDto) {
        bankService.updateBank(bankRequestDto);
        return new EquityResult("操作成功", "", 0);
    }
}
