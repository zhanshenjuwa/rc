package com.zhishi.appfront.entity.dto.request;

import com.zhishi.appfront.common.PageRequest;

import java.util.Date;

public class OperateSelectRequestDto extends PageRequest {

    private String num;
    private Integer eId;
    private Integer type;
    private String start;
    private String end;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
