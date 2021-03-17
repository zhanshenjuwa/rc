package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.entity.dto.request.DocumentsClassificationRequestDto;
import com.zhishi.appfront.service.DocumentsClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 档案分类
 */
@RestController
public class DocumentsClassificationController {

    @Autowired
    private DocumentsClassificationService documentsClassificationService;

    @CrossOrigin
    @RequestMapping(value = "/addDocumentsClassification", method = RequestMethod.POST)
    public EquityResult addDocumentsClassification(@RequestBody DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        return new EquityResult("操作成功", documentsClassificationService.addDocumentsClassification(documentsClassificationRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/selectDocumentsClassification", method = RequestMethod.POST)
    public EquityResult selectDocumentsClassification() {
        return new EquityResult("操作成功", documentsClassificationService.selectDocumentsClassification(), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteDocumentsClassification", method = RequestMethod.POST)
    public EquityResult deleteDocumentsClassification(@RequestBody DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        documentsClassificationService.deleteDocumentsClassification(documentsClassificationRequestDto.getId());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateDocumentsClassification", method = RequestMethod.POST)
    public EquityResult updateDocumentsClassification(@RequestBody DocumentsClassificationRequestDto documentsClassificationRequestDto) {
        documentsClassificationService.updateDocumentsClassification(documentsClassificationRequestDto);
        return new EquityResult("操作成功", "", 0);
    }
}
