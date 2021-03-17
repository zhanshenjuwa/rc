package com.zhishi.appfront.dao;

import com.zhishi.appfront.entity.dto.request.DfRequestDto;
import com.zhishi.appfront.entity.dto.request.DocumentsMsgRequestDto;
import com.zhishi.appfront.entity.dto.request.DocumentsRequestDto;
import com.zhishi.appfront.entity.dto.request.SelectDocumentsRequestDto;
import com.zhishi.appfront.entity.vo.DocuVo;
import com.zhishi.appfront.entity.vo.DocumentsVo;
import com.zhishi.appfront.util.ConstantUtil;
import com.zhishi.appfront.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DocumentsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer addDocuments(DocumentsRequestDto documentsRequestDto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `documents` (`num`, `dc_id`, `bank_id`, `loan_amount`, `duration`, `house_status`, `address`, `property_certificate`, `house_cost`, `area`, `village_id`, `building`, `unit`, `house`, `date`,`state`,`certificates_status`,`different`,`bank_num`,`ks_date`,`syhkje`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?);";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, documentsRequestDto.getNum());
                ps.setObject(2, documentsRequestDto.getDcId());
                ps.setObject(3, documentsRequestDto.getBankId());
                ps.setObject(4, documentsRequestDto.getLoanAmount());
                ps.setObject(5, documentsRequestDto.getDuration());
                ps.setObject(6, documentsRequestDto.getHouseStatus());
                ps.setObject(7, documentsRequestDto.getAddress());
                ps.setObject(8, documentsRequestDto.getPropertyCertificate());
                ps.setObject(9, documentsRequestDto.getHouseCost());
                ps.setObject(10, documentsRequestDto.getArea());
                ps.setObject(11, documentsRequestDto.getVillageId());
                ps.setObject(12, documentsRequestDto.getBuilding());
                ps.setObject(13, documentsRequestDto.getUnit());
                ps.setObject(14, documentsRequestDto.getHouse());
                ps.setObject(15, documentsRequestDto.getDate());
                ps.setObject(16, ConstantUtil.ZTZC);
                ps.setObject(17, documentsRequestDto.getHouseStatus());
                ps.setObject(18, documentsRequestDto.getDifferent());
                ps.setObject(19, documentsRequestDto.getBankNum());
                ps.setObject(20, documentsRequestDto.getKsDate());
                ps.setObject(21, documentsRequestDto.getLoanAmount());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    public void zfhyDocuments(Integer id, Integer zfhy) {
        if (zfhy == 1) {
            String sql = "update documents set state=?,zf_date=?,sc_date=?  where id=?";
            jdbcTemplate.update(sql, ConstantUtil.ZTZF, new Date(), DateUtil.getNextYear(new Date(), ConstantUtil.SCYEAR), id);
        } else {
            String sql = "update documents set state=?,zf_date=null,sc_date=null  where id=?";
            jdbcTemplate.update(sql, ConstantUtil.ZTZC, id);
        }
    }

    public String getLastCode(String num) {
        try {
            String sql = " select num  from documents  where num like ?  ORDER BY id desc limit 1";
            return jdbcTemplate.queryForObject(sql, String.class, num + "%");
        } catch (EmptyResultDataAccessException e) {
            return "";
        }
    }

    public void updateDocuments(DocumentsMsgRequestDto documentsMsgRequestDto) {
        String sql = " UPDATE `documents` SET  `num`=?, `dc_id`=?, `bank_id`=?, `loan_amount`=?, `duration`=?, `address`=?, `property_certificate`=?, `house_cost`=?, `area`=?, `village_id`=?, `building`=?, `unit`=?, `house`=?,`certificates_status`=?,`different`=?,`bank_num`=?,`syhkje`=? WHERE `id`=?";
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(documentsMsgRequestDto.getNum());
        params.add(documentsMsgRequestDto.getDcId());
        params.add(documentsMsgRequestDto.getBankId());
        params.add(documentsMsgRequestDto.getLoanAmount());
        params.add(documentsMsgRequestDto.getDuration());
        params.add(documentsMsgRequestDto.getAddress());
        params.add(documentsMsgRequestDto.getPropertyCertificate());
        params.add(documentsMsgRequestDto.getHouseCost());
        params.add(documentsMsgRequestDto.getArea());
        params.add(documentsMsgRequestDto.getVillageId());
        params.add(documentsMsgRequestDto.getBuilding());
        params.add(documentsMsgRequestDto.getUnit());
        params.add(documentsMsgRequestDto.getHouse());
        params.add(documentsMsgRequestDto.getCertificatesStatus());
        params.add(documentsMsgRequestDto.getDifferent());
        params.add(documentsMsgRequestDto.getBankNum());
        params.add(documentsMsgRequestDto.getLoanAmount());
        params.add(documentsMsgRequestDto.getId());
        jdbcTemplate.update(sql, params.toArray());
    }

    public List<DocumentsVo> selectDocuments(SelectDocumentsRequestDto selectDocumentsRequestDto) {
//        ArrayList<Object> params = new ArrayList<Object>();
//        String sql = "";
//        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getMortgageName())) {
//            sql += " select d.* from documents d LEFT JOIN mortgage m  on d.id=m.d_id where d.state=? and m.mortgage_name=? ";
//            params.add(ConstantUtil.ZTZC);
//            params.add(selectDocumentsRequestDto.getMortgageName());
//            sql += " UNION ";
//        }
//        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getBorrowName()) || !StringUtils.isEmpty(selectDocumentsRequestDto.getBorrowCode())) {
//            sql += " select d.* from documents d LEFT JOIN borrow b on d.id=b.d_id where d.state=? ";
//            params.add(ConstantUtil.ZTZC);
//            if (!StringUtils.isEmpty(selectDocumentsRequestDto.getBorrowName())) {
//                sql += " and borrow_name=? ";
//                params.add(selectDocumentsRequestDto.getBorrowName());
//            }
//            if (!StringUtils.isEmpty(selectDocumentsRequestDto.getBorrowCode())) {
//                sql += " and borrow_code=? ";
//                params.add(selectDocumentsRequestDto.getBorrowCode());
//            }
//            sql += " UNION ";
//        }
//        sql += " select *  from documents where state=? ";
//        params.add(ConstantUtil.ZTZC);
//        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getNum())) {
//            sql += " and num=? ";
//            params.add(selectDocumentsRequestDto.getNum());
//        }
//        List<DocumentsVo> list = new ArrayList();
//        try {
//            list = jdbcTemplate.queryForObject(sql, new DocumentsVo(), params.toArray());
//        } catch (EmptyResultDataAccessException e) {
//            return list;
//        }
//        return list;
        ArrayList<Object> params = new ArrayList<Object>();
        List<DocumentsVo> list = new ArrayList();
        try {
            String sql = getSql(selectDocumentsRequestDto, params);
            if (selectDocumentsRequestDto.getPageNum() > 0) {
                sql += " limit " + (selectDocumentsRequestDto.getPageNum() - 1) * selectDocumentsRequestDto.getPageSize() + "," + selectDocumentsRequestDto.getPageSize();
            }
            list = jdbcTemplate.queryForObject(sql, new DocumentsVo(), params.toArray());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public Integer getDeleteDocuments() {
        try {
            String sql = "select COUNT(*) from documents where sc_date<?";
            return jdbcTemplate.queryForObject(sql, Integer.class, new Date());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void deleteDocuments(Integer id) {
        String sql = "delete from documents where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Integer> selectIdByNum(String num) {
        if (StringUtils.isEmpty(num)) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList("select id from documents where num=?", Integer.class, num);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public List<Integer> getDeleteDocumentsIds() {
        List<Integer> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList("select id from documents where sc_date<? ", Integer.class, new Date());
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void qTox(Integer id, Integer houseStatus) {
        String sql = "update documents set house_status=?,certificates_status=? where id=?";
        jdbcTemplate.update(sql, houseStatus, 5, id);
    }

    public Integer selectDocumentsCount(SelectDocumentsRequestDto selectDocumentsRequestDto) {
        ArrayList<Object> params = new ArrayList<Object>();
        try {
            String sql = "select count(*) from (" + getSql(selectDocumentsRequestDto, params) + ") t";
            return jdbcTemplate.queryForObject(sql, Integer.class, params.toArray());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public String getSql(SelectDocumentsRequestDto selectDocumentsRequestDto, ArrayList<Object> params) {
        String sql = "SELECT DISTINCT d.*,dc.`name` dc_name,ba.`name` ba_name,v.`name` v_name from documents d RIGHT JOIN borrow b on d.id=b.d_id RIGHT JOIN mortgage m on d.id=m.d_id left join documents_classification dc on d.dc_id=dc.id LEFT JOIN bank ba on d.bank_id=ba.id LEFT JOIN village v on d.village_id=v.id where 1=1 ";
        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getNum())) {
            sql += " and d.num=? ";
            params.add(selectDocumentsRequestDto.getNum());
        }
        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getBorrowName())) {
            sql += " and b.borrow_name like ? ";
            params.add("%" + selectDocumentsRequestDto.getBorrowName() + "%");
        }
        if (!StringUtils.isEmpty(selectDocumentsRequestDto.getMortgageName())) {
            sql += " and m.mortgage_name like ? ";
            params.add("%" + selectDocumentsRequestDto.getMortgageName() + "%");
        }
        if (selectDocumentsRequestDto.getDcId() != null) {
            sql += " and d.dc_id=? ";
            params.add(selectDocumentsRequestDto.getDcId());
        }
        if (selectDocumentsRequestDto.getHouseStatus() != null) {
            sql += " and d.house_status=? ";
            params.add(selectDocumentsRequestDto.getHouseStatus());
        }
        if (selectDocumentsRequestDto.getState() != null) {
            sql += " and d.state=? ";
            params.add(selectDocumentsRequestDto.getState());
        }
        if (selectDocumentsRequestDto.getBankId() != null) {
            sql += " and d.bank_id=? ";
            params.add(selectDocumentsRequestDto.getBankId());
        }
        if (selectDocumentsRequestDto.getVillageId() != null) {
            sql += " and d.village_id=? ";
            params.add(selectDocumentsRequestDto.getVillageId());
        }
        if (selectDocumentsRequestDto.getStartTime() != null) {
            sql += " and d.date>=? ";
            params.add(selectDocumentsRequestDto.getStartTime());
        }
        if (selectDocumentsRequestDto.getEndTime() != null) {
            sql += " and d.date<=? ";
            params.add(selectDocumentsRequestDto.getEndTime());
        }
        sql += " order by d.date desc ";
        return sql;
    }

    public void updateCertificatesStatus(Integer id, Integer certificatesStatus) {
        String sql = "update documents set certificates_status=? where id=?";
        jdbcTemplate.update(sql, certificatesStatus, id);
    }

    public void deleteOperate(Integer dId) {
        String sql = "delete from operate where d_id = ?";
        jdbcTemplate.update(sql, dId);
    }

    public List<Integer> getDocumentsIds() {
        List<Integer> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList("select id from documents where syhkje>0", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public List<Integer> getDocumentsIdss() {
        List<Integer> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList("select id from documents", Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return list;
        }
        return list;
    }

    public void updateDocumentsSyhkje(Integer id, BigDecimal syhkje) {
        String sql = "update documents set syhkje=? where id=?";
        jdbcTemplate.update(sql, syhkje, id);
    }

    public DocuVo getDocmentsById(Integer id) {
        List<DocuVo> list = new ArrayList();
        try {
            list = jdbcTemplate.queryForObject("select * from documents where id=?", new DocuVo(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return list.get(0);
    }

    public void updateDf(DfRequestDto dfRequestDto) {
        String sql = "update documents set dfje=? where id=?";
        if ("1".equals(dfRequestDto.getFlag())) {
            jdbcTemplate.update(sql, dfRequestDto.getJe(), dfRequestDto.getdId());
        } else {
            jdbcTemplate.update(sql, null, dfRequestDto.getdId());
        }
    }

    public BigDecimal getDf(Integer dId) {
        String sql = "select dfje from documents where id=?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, dId);
    }

    public int getNum(String num) {
        String sql = "select count(*) from documents where num=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, num);
    }
}
