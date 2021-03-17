package com.zhishi.appfront.service;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.dao.VillageDao;
import com.zhishi.appfront.entity.dto.request.VillageRequestDto;
import com.zhishi.appfront.entity.vo.VillageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class VillageService {
    @Autowired
    private VillageDao villageDao;

    public Integer addVillage(VillageRequestDto villageRequestDto) {
        return villageDao.addVillage(villageRequestDto);
    }

    public void deleteVillage(Integer id) {
        villageDao.deleteVillage(id);
    }

    public void updateVillage(VillageRequestDto villageRequestDto) {
        villageDao.updateVillage(villageRequestDto);
    }

    public List<VillageVo> selectVillage(PageRequest pageRequest) {
        return villageDao.selectVillage(pageRequest);
    }

    public Integer selectVillageCount() {
        return villageDao.selectVillageCount();
    }
}
