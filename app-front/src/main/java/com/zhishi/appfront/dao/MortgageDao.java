package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.dto.request.MortgageRequestDto;
import com.zhishi.appfront.entity.vo.MortgageVo;
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
public class MortgageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addMortgage(MortgageRequestDto mortgageRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `mortgage` ( `d_id`, `mortgage_name`, `mortgage_phone`, `mortgage_spouse_name`, `mortgage_spouse_phone`,`act`,`act_name`,`act_code`,`married`,`mortgage_code`,`mortgage_spouse_code`) VALUES ( ?, ?, ?, ?, ?,?,?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, mortgageRequestDto.getdId());
                ps.setObject(2, mortgageRequestDto.getMortgageName());
                ps.setObject(3, mortgageRequestDto.getMortgagePhone());
                ps.setObject(4, mortgageRequestDto.getMortgageSpouseName());
                ps.setObject(5, mortgageRequestDto.getMortgageSpousePhone());
                ps.setObject(6, mortgageRequestDto.getAct());
                ps.setObject(7, mortgageRequestDto.getActName());
                ps.setObject(8, mortgageRequestDto.getActCode());
                ps.setObject(9, mortgageRequestDto.getMarried());
                ps.setObject(10, mortgageRequestDto.getMortgageCode());
                ps.setObject(11, mortgageRequestDto.getMortgageSpouseCode());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void deleteMortgage(Integer id) {
        String sql = "delete from mortgage where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<MortgageVo> selectMortgageByDid(Integer dId) {
        List<MortgageVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM mortgage WHERE d_id=? ", new MortgageVo(), dId);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void deleteMortgageByDid(Integer dId) {
        String sql = "delete from mortgage where d_id = ?";
        jdbcTemplate.update(sql, dId);
    }

//    public List<Integer> selectIdByName(String name) {
//        if (StringUtils.isEmpty(name)) {
//            return new ArrayList<>();
//        }
//        List<Integer> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForList("SELECT d_id FROM mortgage WHERE name=? ", Integer.class, name);
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
//    }

    public MortgageVo getMortgageById(Integer id) {
        List<MortgageVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("SELECT *  FROM  mortgage where id=?", new MortgageVo(), id);
        } catch (EmptyResultDataAccessException e) {
            return list.get(0);
        }
        return list.get(0);
    }

    public void updateMortgage(MortgageRequestDto mortgageRequestDto) {
        String sql = "UPDATE mortgage SET  `mortgage_code`=?, `mortgage_name`=?, `mortgage_phone`=?, `mortgage_spouse_code`=?, `mortgage_spouse_name`=?, `mortgage_spouse_phone`=?, `married`=?, `act`=?, `act_name`=?, `act_code`=? WHERE `id`=?";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(mortgageRequestDto.getMortgageCode());
        params.add(mortgageRequestDto.getMortgageName());
        params.add(mortgageRequestDto.getMortgagePhone());
        params.add(mortgageRequestDto.getMortgageSpouseCode());
        params.add(mortgageRequestDto.getMortgageSpouseName());
        params.add(mortgageRequestDto.getMortgageSpousePhone());
        params.add(mortgageRequestDto.getMarried());
        params.add(mortgageRequestDto.getAct());
        params.add(mortgageRequestDto.getActName());
        params.add(mortgageRequestDto.getActCode());
        params.add(mortgageRequestDto.getId());
        jdbcTemplate.update(sql, params.toArray());
    }
}
