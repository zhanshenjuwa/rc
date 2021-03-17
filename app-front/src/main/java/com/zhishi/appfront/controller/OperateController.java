package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.OperateSelectRequestDto;
import com.zhishi.appfront.entity.vo.OperateVo;
import com.zhishi.appfront.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作
 */
@RestController
public class OperateController {

    @Autowired
    private OperateService operateService;

//    @CrossOrigin
//    @RequestMapping(value = "/selectOperateByDid", method = RequestMethod.POST)
//    public EquityResult selectOperateByDid(@RequestBody OperateRequestDto operateRequestDto) {
//        return new EquityResult("操作成功", operateService.selectOperate(operateRequestDto), 0);
//    }
//
//    @CrossOrigin
//    @RequestMapping(value = "/selectAllOperate", method = RequestMethod.POST)
//    public EquityResult selectAllOperate() {
//        return new EquityResult("操作成功", operateService.selectAllOperate(), 0);
//    }


    @CrossOrigin
    @RequestMapping(value = "/selectOperate", method = RequestMethod.POST)
    public PageResponse selectOperate(@RequestBody OperateSelectRequestDto operateSelectRequestDto) {
        int plateInfoCount = operateService.selectOperateByMsgCount(operateSelectRequestDto);
        List<OperateVo> result = operateService.selectOperateByMsg(operateSelectRequestDto);
        int totalPageNum = plateInfoCount % operateSelectRequestDto.getPageSize() == 0 ? plateInfoCount / operateSelectRequestDto.getPageSize() : plateInfoCount / operateSelectRequestDto.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, operateSelectRequestDto.getPageNum(), operateSelectRequestDto.getPageSize(), totalPageNum, false);
        }
        return new PageResponse("查看成功", result, 0, operateSelectRequestDto.getPageNum(), operateSelectRequestDto.getPageSize(), totalPageNum, totalPageNum - operateSelectRequestDto.getPageNum() < 1 ? false : true);
    }
}
