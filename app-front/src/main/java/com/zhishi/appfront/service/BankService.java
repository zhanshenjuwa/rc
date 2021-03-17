package com.zhishi.appfront.service;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.dao.BankDao;
import com.zhishi.appfront.entity.dto.request.BankRequestDto;
import com.zhishi.appfront.entity.vo.BankVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BankService {

    @Autowired
    private BankDao bankDao;

    public Integer addBank(BankRequestDto bankRequestDto) {
        return bankDao.addBank(bankRequestDto);
    }

    public void deleteBank(Integer id) {
        bankDao.deleteBank(id);
    }

    public List<BankVo> selectBank(PageRequest pageRequest) {
        return bankDao.selectBank(pageRequest);
    }

    public void updateBank(BankRequestDto bankRequestDto) {
        bankDao.updateBank(bankRequestDto);
    }

    public Integer selectBankCount() {
        return bankDao.selectBankCount();
    }
}
