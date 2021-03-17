package com.zhishi.appfront.entity.dto.request;

public class DocumentsDeleteRequestDto {
    private Integer uId;
    private String deleteIds;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }
}
