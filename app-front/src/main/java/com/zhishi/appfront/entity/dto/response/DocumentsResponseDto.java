package com.zhishi.appfront.entity.dto.response;

import com.zhishi.appfront.entity.vo.BorrowVo;
import com.zhishi.appfront.entity.vo.DocumentsVo;
import com.zhishi.appfront.entity.vo.FileVo;
import com.zhishi.appfront.entity.vo.MortgageVo;

import java.util.List;

public class DocumentsResponseDto {
    private DocumentsVo documentsVo;
    private List<FileVo> fileVo;
    private List<MortgageVo> mortgageVo;
    private List<BorrowVo> borrowVo;

    public DocumentsVo getDocumentsVo() {
        return documentsVo;
    }

    public void setDocumentsVo(DocumentsVo documentsVo) {
        this.documentsVo = documentsVo;
    }

    public List<FileVo> getFileVo() {
        return fileVo;
    }

    public void setFileVo(List<FileVo> fileVo) {
        this.fileVo = fileVo;
    }

    public List<MortgageVo> getMortgageVo() {
        return mortgageVo;
    }

    public void setMortgageVo(List<MortgageVo> mortgageVo) {
        this.mortgageVo = mortgageVo;
    }

    public List<BorrowVo> getBorrowVo() {
        return borrowVo;
    }

    public void setBorrowVo(List<BorrowVo> borrowVo) {
        this.borrowVo = borrowVo;
    }
}
