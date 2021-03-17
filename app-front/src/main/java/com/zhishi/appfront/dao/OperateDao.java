package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.OperateEntity;
import com.zhishi.appfront.entity.dto.request.OperateSelectRequestDto;
import com.zhishi.appfront.entity.vo.OperateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperateDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addOperate(OperateEntity operateEntity) {
        String sql = "INSERT INTO `operate` (`u_id`, `d_id`, `date`, `type`, `change`) VALUES (?, ?, ?, ?, ?)";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(operateEntity.getuId());
        params.add(operateEntity.getdId());
        params.add(operateEntity.getDate());
        params.add(operateEntity.getType());
        params.add(operateEntity.getChange());
        jdbcTemplate.update(sql, params.toArray());
    }

//    public List<OperateVo> selectOperate(Integer dId) {
//        List<OperateVo> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForObject("SELECT o.*,e.`name` u_name  FROM  operate o LEFT JOIN employee e on o.u_id=e.id  where o.d_id=?", new OperateVo(), dId);
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
//    }
//
//    public List<OperateVo> selectAllOperate() {
//        List<OperateVo> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForObject("SELECT o.*,e.`name` u_name  FROM  operate o LEFT JOIN employee e on o.u_id=e.id ", new OperateVo());
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
//    }

    public List<OperateVo> selectOperateByMsg(OperateSelectRequestDto operateSelectRequestDto) {
        List<OperateVo> list = new ArrayList();
        ArrayList<Object> params = new ArrayList<Object>();
        try {
            String sql = getSql(operateSelectRequestDto, params);
            if (operateSelectRequestDto.getPageNum() > 0) {
                sql += " limit " + (operateSelectRequestDto.getPageNum() - 1) * operateSelectRequestDto.getPageSize() + "," + operateSelectRequestDto.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new OperateVo(), params.toArray());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }


    public Integer selectOperateByMsgCount(OperateSelectRequestDto operateSelectRequestDto) {
        ArrayList<Object> params = new ArrayList<Object>();
        try {
            String sql = "select COUNT(*) from (" + getSql(operateSelectRequestDto, params) + ") t";
            return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public String getSql(OperateSelectRequestDto operateSelectRequestDto, ArrayList<Object> params) {
        String sql = "select o.*,d.num,e.name eName from operate o left join documents d on o.d_id=d.id left join employee e on o.u_id=e.id where 1=1 ";
        if (!StringUtils.isEmpty(operateSelectRequestDto.getNum())) {
            sql += " and d.num=? ";
            params.add(operateSelectRequestDto.getNum());
        }
        if (operateSelectRequestDto.geteId() != null) {
            sql += " and o.u_id=? ";
            params.add(operateSelectRequestDto.geteId());
        }
        if (operateSelectRequestDto.getType() != null) {
            sql += " and o.type=? ";
            params.add(operateSelectRequestDto.getType());
        }
        if (operateSelectRequestDto.getStart() != null) {
            sql += " and o.date>? ";
            params.add(operateSelectRequestDto.getStart());
        }
        if (operateSelectRequestDto.getEnd() != null) {
            sql += " and o.date<? ";
            params.add(operateSelectRequestDto.getEnd());
        }
        sql += " order by o.date desc ";
        return sql;
    }
}
