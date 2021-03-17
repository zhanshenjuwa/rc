package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.MortgageDao;
import com.zhishi.appfront.dao.OperateDao;
import com.zhishi.appfront.entity.OperateEntity;
import com.zhishi.appfront.entity.dto.request.MortgageRequestDto;
import com.zhishi.appfront.entity.vo.MortgageVo;
import com.zhishi.appfront.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MortgageService {

    @Autowired
    private MortgageDao mortgageDao;

    @Autowired
    private OperateDao operateDao;

    public Integer addMortgage(MortgageRequestDto mortgageRequestDto) {
        //添加抵押人
        Integer id = mortgageDao.addMortgage(mortgageRequestDto);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(mortgageRequestDto.getuId());
        operateEntity.setdId(mortgageRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("新增抵押人：" + mortgageRequestDto.getMortgageName());
        operateDao.addOperate(operateEntity);
        return id;
    }

    public void deleteMortgage(Integer id, Integer uId, Integer dId) {
        //删除抵押人
        MortgageVo mortgage = mortgageDao.getMortgageById(id);
        mortgageDao.deleteMortgage(id);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(uId);
        operateEntity.setdId(dId);
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("删除抵押人：" + mortgage.getMortgageName());
        operateDao.addOperate(operateEntity);
    }

    public void updateMortgage(MortgageRequestDto mortgageRequestDto) {
        MortgageVo mortgage = mortgageDao.getMortgageById(mortgageRequestDto.getId());
        mortgageDao.updateMortgage(mortgageRequestDto);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(mortgageRequestDto.getuId());
        operateEntity.setdId(mortgageRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("修改抵押人：" + mortgageRequestDto.getMortgageName());
        operateDao.addOperate(operateEntity);
    }
}
