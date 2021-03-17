package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.DocumentsClassificationDao;
import com.zhishi.appfront.dao.StatisticsDao;
import com.zhishi.appfront.entity.dto.request.StatisticsRequestDto;
import com.zhishi.appfront.entity.dto.response.StatisticsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class StatisticsService {

    @Autowired
    private StatisticsDao statisticsDao;

    @Autowired
    private DocumentsClassificationDao documentsClassificationDao;

    public List<StatisticsResponseDto> selectStatistics(StatisticsRequestDto statisticsRequestDto) {
        List<StatisticsResponseDto> l = new ArrayList<>();
        List<Integer> type = documentsClassificationDao.getDocumentsClassification();
        for (Integer i : type) {
            StatisticsResponseDto statisticsResponseDto = new StatisticsResponseDto();
            statisticsResponseDto.setType(i);
            statisticsResponseDto.setdName(documentsClassificationDao.getDocumentsClassificationNameById(i));
            Integer dbhs = statisticsDao.getDbhs(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            statisticsResponseDto.setDbhs(dbhs);
            BigDecimal dbje = statisticsDao.getDbje(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            if (dbje == null) {
                dbje = new BigDecimal(0);
            }
            statisticsResponseDto.setDbje(dbje);
            BigDecimal dbzje = statisticsDao.getDbzje(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            if (dbzje == null) {
                dbzje = new BigDecimal(0);
            }
            statisticsResponseDto.setDbzje(dbzje);
            Integer zxhs = statisticsDao.getZxhs(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            statisticsResponseDto.setZxhs(zxhs);
            BigDecimal zxje = statisticsDao.getZxje(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            if (zxje == null) {
                zxje = new BigDecimal(0);
            }
            statisticsResponseDto.setZxje(zxje);
            Integer zxihs = statisticsDao.getZxihs(statisticsRequestDto.getStart(), statisticsRequestDto.getEnd(), i);
            statisticsResponseDto.setZxihs(zxihs);
            l.add(statisticsResponseDto);
        }
        return l;
    }
}
