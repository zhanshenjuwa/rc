package com.zhishi.appfront.service;

import com.zhishi.appfront.common.PageRequest;
import com.zhishi.appfront.dao.RoleDao;
import com.zhishi.appfront.entity.dto.request.RoleRequestDto;
import com.zhishi.appfront.entity.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public List<RoleVo> getRole(PageRequest pageRequest) {
        return roleDao.getRole(pageRequest);
    }

    public Integer addRole(RoleRequestDto roleRequestDto) {
        return roleDao.addRole(roleRequestDto);
    }

    public void deleteRole(Integer id) {
        roleDao.deleteRole(id);
    }

    public void updateRole(RoleRequestDto roleRequestDto) {
        roleDao.updateRole(roleRequestDto);
    }

    public Integer getRoleCount() {
        return roleDao.getRoleCount();
    }
}
