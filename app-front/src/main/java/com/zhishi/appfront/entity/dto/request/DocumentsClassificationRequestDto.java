package com.zhishi.appfront.entity.dto.request;

public class DocumentsClassificationRequestDto {
    private Integer id;
    private String name;
    private Integer sqbNum;
    private Integer htNum;
    private Integer xyNum;

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

    public Integer getSqbNum() {
        return sqbNum;
    }

    public void setSqbNum(Integer sqbNum) {
        this.sqbNum = sqbNum;
    }

    public Integer getHtNum() {
        return htNum;
    }

    public void setHtNum(Integer htNum) {
        this.htNum = htNum;
    }

    public Integer getXyNum() {
        return xyNum;
    }

    public void setXyNum(Integer xyNum) {
        this.xyNum = xyNum;
    }
}
