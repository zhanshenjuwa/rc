package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.entity.dto.request.MortgageRequestDto;
import com.zhishi.appfront.service.MortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 抵押人
 */
@RestController
public class MortgageController {

    @Autowired
    private MortgageService mortgageService;

    @CrossOrigin
    @RequestMapping(value = "/addMortgage", method = RequestMethod.POST)
    public EquityResult addMortgage(@RequestBody MortgageRequestDto mortgageRequestDto) {
        return new EquityResult("操作成功", mortgageService.addMortgage(mortgageRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteMortgage", method = RequestMethod.POST)
    public EquityResult deleteMortgage(@RequestBody MortgageRequestDto mortgageRequestDto) {
        mortgageService.deleteMortgage(mortgageRequestDto.getId(), mortgageRequestDto.getuId(), mortgageRequestDto.getdId());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateMortgage", method = RequestMethod.POST)
    public EquityResult updateMortgage(@RequestBody MortgageRequestDto mortgageRequestDto) {
        mortgageService.updateMortgage(mortgageRequestDto);
        return new EquityResult("操作成功", "", 0);
    }
}
