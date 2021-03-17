package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.dto.request.BorrowRequestDto;
import com.zhishi.appfront.entity.vo.BorrowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class BorrowDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addBorrow(BorrowRequestDto borrowRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `borrow` (`d_id`, `borrow_code`, `borrow_name`, `borrow_phone`, `borrow_spouse_code`, `borrow_spouse_name`, `borrow_spouse_phone`,`act`,`act_name`,`act_code`,`married`) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, borrowRequestDto.getdId());
                ps.setObject(2, borrowRequestDto.getBorrowCode());
                ps.setObject(3, borrowRequestDto.getBorrowName());
                ps.setObject(4, borrowRequestDto.getBorrowPhone());
                ps.setObject(5, borrowRequestDto.getBorrowSpouseCode());
                ps.setObject(6, borrowRequestDto.getBorrowSpouseName());
                ps.setObject(7, borrowRequestDto.getBorrowSpousePhone());
                ps.setObject(8, borrowRequestDto.getAct());
                ps.setObject(9, borrowRequestDto.getActName());
                ps.setObject(10, borrowRequestDto.getActCode());
                ps.setObject(11, borrowRequestDto.getMarried());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }


    public BorrowVo getBorrowById(Integer id) {
        List<BorrowVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM borrow where id=?", new BorrowVo(), id);
        } catch (EmptyResultDataAccessException e) {
            return list.get(0);
        }
        return list.get(0);
    }


    public void deleteBorrow(Integer id) {
        String sql = "delete from borrow where id=?";
        jdbcTemplate.update(sql, id);
    }

    public void deleteBorrowByDid(Integer dId) {
        String sql = "delete from borrow where d_id = ?";
        jdbcTemplate.update(sql, dId);
    }


//    public List<Integer> selectIdByName(String name) {
//        List<Integer> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForList("SELECT d_id FROM borrow WHERE name=? ", Integer.class, name);
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
//    }
//
//    public List<Integer> selectIdByCode(String code) {
//        List<Integer> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForList("SELECT d_id FROM borrow WHERE code=? ", Integer.class, code);
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
//    }
//
//    public List<Integer> selectIdByNameOrCode(String borrowName, String borrowCode) {
//        if (StringUtils.isEmpty(borrowName) && StringUtils.isEmpty(borrowCode)) {
//            return new ArrayList<>();
//        }
//        ArrayList<Object> arrayList = new ArrayList<>();
//        String sql = " SELECT d_id FROM borrow where 1=1 ";
//        if (!StringUtils.isEmpty(borrowName)) {
//            sql += " and borrowName=? ";
//            arrayList.add(borrowName);
//        }
//        if (!StringUtils.isEmpty(borrowCode)) {
//            sql += " and borrowCode=? ";
//            arrayList.add(borrowCode);
//        }
//        return jdbcTemplate.queryForList(sql, Integer.class, arrayList.toArray());
//    }


    public List<BorrowVo> selectBorrowDaoByDid(Integer dId) {
        List<BorrowVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM borrow WHERE d_id=? ", new BorrowVo(), dId);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void updateBorrow(BorrowRequestDto borrowRequestDto) {
        String sql = "UPDATE borrow SET  `borrow_code`=?, `borrow_name`=?, `borrow_phone`=?, `borrow_spouse_code`=?, `borrow_spouse_name`=?, `borrow_spouse_phone`=?, `married`=?, `act`=?, `act_name`=?, `act_code`=? WHERE `id`=?";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(borrowRequestDto.getBorrowCode());
        params.add(borrowRequestDto.getBorrowName());
        params.add(borrowRequestDto.getBorrowPhone());
        params.add(borrowRequestDto.getBorrowSpouseCode());
        params.add(borrowRequestDto.getBorrowSpouseName());
        params.add(borrowRequestDto.getBorrowSpousePhone());
        params.add(borrowRequestDto.getMarried());
        params.add(borrowRequestDto.getAct());
        params.add(borrowRequestDto.getActName());
        params.add(borrowRequestDto.getActCode());
        params.add(borrowRequestDto.getId());
        jdbcTemplate.update(sql, params.toArray());
    }
}
