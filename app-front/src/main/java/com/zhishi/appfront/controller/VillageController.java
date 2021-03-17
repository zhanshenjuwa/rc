package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.VillageRequestDto;
import com.zhishi.appfront.entity.vo.VillageVo;
import com.zhishi.appfront.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小区
 */
@RestController
public class VillageController {

    @Autowired
    private VillageService villageService;

    @CrossOrigin
    @RequestMapping(value = "/addVillage", method = RequestMethod.POST)
    public EquityResult addVillage(@RequestBody VillageRequestDto villageRequestDto) {
        return new EquityResult("操作成功", villageService.addVillage(villageRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteVillage", method = RequestMethod.POST)
    public EquityResult deleteVillage(@RequestBody VillageRequestDto villageRequestDto) {
        villageService.deleteVillage(villageRequestDto.getId());
        return new EquityResult("操作成功", "", 0);
    }


    @CrossOrigin
    @RequestMapping(value = "/updateVillage", method = RequestMethod.POST)
    public EquityResult updateVillage(@RequestBody VillageRequestDto villageRequestDto) {
        villageService.updateVillage(villageRequestDto);
        return new EquityResult("操作成功", "", 0);
    }


    @CrossOrigin
    @RequestMapping(value = "/selectVillage", method = RequestMethod.POST)
    public EquityResult selectVillage(@RequestBody PageRequest pageRequest) {
        int plateInfoCount = villageService.selectVillageCount();
        List<VillageVo> result = villageService.selectVillage(pageRequest);
        int totalPageNum = plateInfoCount % pageRequest.getPageSize() == 0 ? plateInfoCount / pageRequest.getPageSize() : plateInfoCount / pageRequest.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, false);
        }
        return new PageResponse("查看成功", result, 0, pageRequest.getPageNum(), pageRequest.getPageSize(), totalPageNum, totalPageNum - pageRequest.getPageNum() < 1 ? false : true);
    }
}
