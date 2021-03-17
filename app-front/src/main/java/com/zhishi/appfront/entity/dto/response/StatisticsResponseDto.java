package com.zhishi.appfront.entity.dto.response;

import java.math.BigDecimal;

public class StatisticsResponseDto {
    private Integer type;
    private Integer dbhs;
    private Integer zxhs;
    private BigDecimal dbje;
    private BigDecimal zxje;
    private Integer zxihs;
    private String dName;
    private BigDecimal dbzje;

    public BigDecimal getDbzje() {
        return dbzje;
    }

    public void setDbzje(BigDecimal dbzje) {
        this.dbzje = dbzje;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDbhs() {
        return dbhs;
    }

    public void setDbhs(Integer dbhs) {
        this.dbhs = dbhs;
    }

    public Integer getZxhs() {
        return zxhs;
    }

    public void setZxhs(Integer zxhs) {
        this.zxhs = zxhs;
    }

    public BigDecimal getDbje() {
        return dbje;
    }

    public void setDbje(BigDecimal dbje) {
        this.dbje = dbje;
    }

    public BigDecimal getZxje() {
        return zxje;
    }

    public void setZxje(BigDecimal zxje) {
        this.zxje = zxje;
    }

    public Integer getZxihs() {
        return zxihs;
    }

    public void setZxihs(Integer zxihs) {
        this.zxihs = zxihs;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
