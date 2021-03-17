package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.DocumentsClassificationDao;
import com.zhishi.appfront.entity.dto.request.DocumentsClassificationRequestDto;
import com.zhishi.appfront.entity.vo.DocumentsClassificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DocumentsClassificationService {

    @Autowired
    private DocumentsClassificationDao documentsClassificationDao;

    public Integer addDocumentsClassification(DocumentsClassificationRequestDto documentsClassificationRequestDto) {
       return documentsClassificationDao.addDocumentsClassification(documentsClassificationRequestDto);
    }

    public List<DocumentsClassificationVo> selectDocumentsClassification() {
       return documentsClassificationDao.selectDocumentsClassification();
    }

    public void deleteDocumentsClassification(Integer id) {
        documentsClassificationDao.deleteDocumentsClassification(id);
    }

    public void updateDocumentsClassification(DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        documentsClassificationDao.updateDocumentsClassification(documentsClassificationRequestDto);
    }
}
