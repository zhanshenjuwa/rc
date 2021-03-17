package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.PermDao;
import com.zhishi.appfront.entity.vo.PermVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class PermService {

    @Autowired
    private PermDao permDao;


    public List<PermVo> getPerm() {
        return permDao.getPerm();
    }
}
