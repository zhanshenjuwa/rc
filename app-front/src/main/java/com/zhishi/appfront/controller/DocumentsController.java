package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.PageResponse;
import com.zhishi.appfront.entity.dto.request.*;
import com.zhishi.appfront.entity.dto.response.DocumentsResponseDto;
import com.zhishi.appfront.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 档案
 */
@RestController
public class DocumentsController {

    @Autowired
    private DocumentsService documentsService;

    @CrossOrigin
    @RequestMapping(value = "/addDocuments", method = RequestMethod.POST)
    public EquityResult addDocuments(@RequestBody DocumentsRequestDto documentsRequestDto) throws Exception {
        if (!StringUtils.isEmpty(documentsRequestDto.getNum())) {
            int count = documentsService.getNum(documentsRequestDto.getNum());
            if (count > 0) {
                return new EquityResult("档案编号已存在", "", -1);
            }
        }
        return new EquityResult("操作成功", documentsService.addDocuments(documentsRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/zfhyDocuments", method = RequestMethod.POST)
    public EquityResult zfhyDocuments(@RequestBody DocumentsRequestDto documentsRequestDto) {
        if (documentsService.getDf(documentsRequestDto.getId()) != null) {
            return new EquityResult("垫付不能注销", "", 0);
        }
        documentsService.zfhyDocuments(documentsRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateDocuments", method = RequestMethod.POST)
    public EquityResult updateDocuments(@RequestBody DocumentsUpdateRequestDto documentsUpdateRequestDto) {
        documentsService.updateDocuments(documentsUpdateRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/selectDocuments", method = RequestMethod.POST)
    public EquityResult selectDocuments(@RequestBody SelectDocumentsRequestDto selectDocumentsRequestDto) throws Exception {
        int plateInfoCount = documentsService.selectDocumentsCount(selectDocumentsRequestDto);
        List<DocumentsResponseDto> result = documentsService.selectDocuments(selectDocumentsRequestDto);
        int totalPageNum = plateInfoCount % selectDocumentsRequestDto.getPageSize() == 0 ? plateInfoCount / selectDocumentsRequestDto.getPageSize() : plateInfoCount / selectDocumentsRequestDto.getPageSize() + 1;
        if (result.size() < 0) {
            return new PageResponse("暂无相关信息", null, 0, selectDocumentsRequestDto.getPageNum(), selectDocumentsRequestDto.getPageSize(), totalPageNum, false);
        }
        return new PageResponse(plateInfoCount + "", result, 0, selectDocumentsRequestDto.getPageNum(), selectDocumentsRequestDto.getPageSize(), totalPageNum, totalPageNum - selectDocumentsRequestDto.getPageNum() < 1 ? false : true);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteDocuments", method = RequestMethod.POST)
    public EquityResult deleteDocuments(@RequestBody DocumentsDeleteRequestDto documentsDeleteRequestDto) {
        if (documentsService.getDf(Integer.valueOf(documentsDeleteRequestDto.getDeleteIds().split(",")[0])) != null) {
            return new EquityResult("垫付不能删除", "", 0);
        }
        documentsService.deleteDocuments(documentsDeleteRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/getDeleteDocuments", method = RequestMethod.POST)
    public EquityResult getDeleteDocuments() {
        return new EquityResult("操作成功", documentsService.getDeleteDocuments(), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteZxDocuments", method = RequestMethod.POST)
    public EquityResult deleteZxDocuments(@RequestBody DocumentsDeleteRequestDto documentsDeleteRequestDto) {
        documentsService.deleteZxDocuments(documentsDeleteRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/qTox", method = RequestMethod.POST)
    public EquityResult qTox(@RequestBody DocumentsRequestDto documentsRequestDto) {
        documentsService.qTox(documentsRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateCertificatesStatus", method = RequestMethod.POST)
    public EquityResult updateCertificatesStatus(@RequestBody DocumentsRequestDto documentsRequestDto) {
        documentsService.updateCertificatesStatus(documentsRequestDto.getId(), documentsRequestDto.getCertificatesStatus(), documentsRequestDto.getuId());
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateDf", method = RequestMethod.POST)
    public EquityResult updateDf(@RequestBody DfRequestDto dfRequestDto) {
        documentsService.updateDf(dfRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/ssj", method = RequestMethod.POST)
    public EquityResult ssj() {
        documentsService.ssj();
        return new EquityResult("操作成功", "", 0);
    }


//    @CrossOrigin
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
//    public EquityResult test() {
//        DocuVo d=documentsService.getDocmentsById(12);
//        return new EquityResult("操作成功", "", 0);
//    }
}
