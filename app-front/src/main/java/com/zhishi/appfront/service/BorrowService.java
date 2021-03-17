package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.BorrowDao;
import com.zhishi.appfront.dao.OperateDao;
import com.zhishi.appfront.entity.OperateEntity;
import com.zhishi.appfront.entity.dto.request.BorrowRequestDto;
import com.zhishi.appfront.entity.vo.BorrowVo;
import com.zhishi.appfront.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BorrowService {

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private OperateDao operateDao;


    public Integer addBorrow(BorrowRequestDto borrowRequestDto) {
        //添加借款人
        Integer id = borrowDao.addBorrow(borrowRequestDto);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(borrowRequestDto.getuId());
        operateEntity.setdId(borrowRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("新增借款人：" + borrowRequestDto.getBorrowName());
        operateDao.addOperate(operateEntity);
        return id;
    }

    public void deleteBorrow(Integer id, Integer uId, Integer dId) {
        //删除借款人
        BorrowVo borrow = borrowDao.getBorrowById(id);
        borrowDao.deleteBorrow(id);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(uId);
        operateEntity.setdId(dId);
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("删除借款人：" + borrow.getBorrowName());
        operateDao.addOperate(operateEntity);
    }

    public void updateBorrow(BorrowRequestDto borrowRequestDto) {
        //删除借款人
        BorrowVo borrow = borrowDao.getBorrowById(borrowRequestDto.getId());
        borrowDao.updateBorrow(borrowRequestDto);
        //操作记录
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(borrowRequestDto.getuId());
        operateEntity.setdId(borrowRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange("修改借款人：" + borrowRequestDto.getBorrowName());
        operateDao.addOperate(operateEntity);
    }
}
