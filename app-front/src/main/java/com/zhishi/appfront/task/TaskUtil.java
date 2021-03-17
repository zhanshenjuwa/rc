package com.zhishi.appfront.task;

import com.zhishi.appfront.entity.vo.DocuVo;
import com.zhishi.appfront.service.DocumentsService;
import com.zhishi.appfront.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TaskUtil {

    @Autowired
    private DocumentsService documentsService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void syhkje() {
        List<Integer> ids = new ArrayList<>();
        ids.add(22214);
        for (Integer id : ids) {
            DocuVo dVo = documentsService.getDocmentsById(id);
            if (dVo.getKsDate().getTime() <= new Date().getTime()) {
                BigDecimal invest = dVo.getLoanAmount(); // 本金
                int year = dVo.getDuration();//期限
                double yearRate;
                Date date;
                if (dVo.getDcId() == 3) {
                    if (dVo.getDuration() / 12 <= 1) {
                        yearRate = 0.0435;
                    } else if (dVo.getDuration() / 12 > 1 && dVo.getDuration() / 12 < 5) {
                        yearRate = 0.0475;
                    } else {
                        yearRate = 0.0490;
                    }
                    date = dVo.getDate();
                } else {
                    if (dVo.getDuration() / 12 <= 5) {
                        yearRate = 0.0275;
                    } else {
                        yearRate = 0.0325;
                    }
                    date = dVo.getKsDate();
                }
                double monthRate = yearRate / 12;
                int month = year;
                BigDecimal monthCapital;
                int i = DateUtil.differentMonths(new Date(), date);
                System.out.println(id);
                monthCapital = invest.multiply(new BigDecimal(monthRate * (Math.pow((1 + monthRate),
                        i - 1)))).divide(new BigDecimal(Math.pow(1 + monthRate, month) - 1), 2,
                        BigDecimal.ROUND_HALF_UP);
                documentsService.updateDocumentsSyhkje(id, dVo.getSyhkje().subtract(monthCapital));
            }
        }
    }
}


