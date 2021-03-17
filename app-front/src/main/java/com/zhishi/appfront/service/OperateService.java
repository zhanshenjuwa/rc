package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.FileDao;
import com.zhishi.appfront.dao.OperateDao;
import com.zhishi.appfront.entity.dto.request.OperateRequestDto;
import com.zhishi.appfront.entity.dto.request.OperateSelectRequestDto;
import com.zhishi.appfront.entity.vo.OperateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OperateService {

    @Autowired
    private OperateDao operateDao;

//    public List<OperateVo> selectOperate(OperateRequestDto operateRequestDto) {
//       return operateDao.selectOperate(operateRequestDto.getdId());
//    }
//
//    public List<OperateVo> selectAllOperate() {
//        return operateDao.selectAllOperate();
//    }

    public List<OperateVo> selectOperateByMsg(OperateSelectRequestDto operateSelectRequestDto) {
        return operateDao.selectOperateByMsg(operateSelectRequestDto);
    }

    public Integer selectOperateByMsgCount(OperateSelectRequestDto operateSelectRequestDto) {
        return operateDao.selectOperateByMsgCount(operateSelectRequestDto);
    }
}
