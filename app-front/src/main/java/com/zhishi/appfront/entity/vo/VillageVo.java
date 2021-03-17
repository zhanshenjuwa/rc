package com.zhishi.appfront.entity.vo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VillageVo implements RowMapper<List<VillageVo>> {
    private Integer id;
    private String name;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public List<VillageVo> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<VillageVo> villageVo = new ArrayList<>();
        do {
            VillageVo village = new VillageVo();
            village.setId(resultSet.getInt("id"));
            village.setName(resultSet.getString("name"));
            village.setMemo(resultSet.getString("memo"));
            villageVo.add(village);
        } while (resultSet.next());
        return villageVo;
    }
}
