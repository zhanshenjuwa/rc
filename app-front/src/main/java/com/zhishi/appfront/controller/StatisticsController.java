package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.entity.dto.request.StatisticsRequestDto;
import com.zhishi.appfront.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计
 */
@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @CrossOrigin
    @PostMapping("/selectStatistics")
    public EquityResult selectStatistics(@RequestBody StatisticsRequestDto statisticsRequestDto) {
        return new EquityResult("查询成功", statisticsService.selectStatistics(statisticsRequestDto), 0);
    }
}
