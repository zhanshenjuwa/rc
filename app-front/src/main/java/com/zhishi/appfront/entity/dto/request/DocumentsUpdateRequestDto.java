package com.zhishi.appfront.entity.dto.request;

public class DocumentsUpdateRequestDto {
    private Integer uId;
    private Integer dId;
    private DocumentsMsgRequestDto documentsMsgRequestDto;
    private String change;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public DocumentsMsgRequestDto getDocumentsMsgRequestDto() {
        return documentsMsgRequestDto;
    }

    public void setDocumentsMsgRequestDto(DocumentsMsgRequestDto documentsMsgRequestDto) {
        this.documentsMsgRequestDto = documentsMsgRequestDto;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
