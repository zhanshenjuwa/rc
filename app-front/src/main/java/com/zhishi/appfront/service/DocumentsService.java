package com.zhishi.appfront.service;

import com.zhishi.appfront.dao.*;
import com.zhishi.appfront.entity.OperateEntity;
import com.zhishi.appfront.entity.dto.request.*;
import com.zhishi.appfront.entity.dto.response.DocumentsResponseDto;
import com.zhishi.appfront.entity.vo.*;
import com.zhishi.appfront.util.ConstantUtil;
import com.zhishi.appfront.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DocumentsService {
    @Autowired
    private DocumentsDao documentsDao;

    @Autowired
    private OperateDao operateDao;

    @Autowired
    private FileDao fileDao;

    @Autowired
    private MortgageDao mortgageDao;

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private FileService fileService;

    @Autowired
    private DocumentsService documentsService;

    public synchronized String addDocuments(DocumentsRequestDto documentsRequestDto) throws Exception {
        String flag;
        String num = "";
        if (StringUtils.isEmpty(documentsRequestDto.getNum())) {
            if (documentsRequestDto.getDcId() == 1) {
                num = "D";
            } else if (documentsRequestDto.getDcId() == 2) {
                num = "U";
            } else if (documentsRequestDto.getDcId() == 3) {
                num = "S";
            }
            String con = "";
            Calendar date = Calendar.getInstance();
            String year = String.valueOf(date.get(Calendar.YEAR)).substring(2, 4);
            String month = String.valueOf(date.get(Calendar.MONTH) + 1);
            if (Integer.valueOf(month) < 10) {
                month = "0" + month;
            }
            String code = documentsDao.getLastCode(num + year + month);
            if (StringUtils.isEmpty(code)) {
                documentsRequestDto.setNum(num + year + month + ConstantUtil.CSBH);
            } else {
                if (Integer.valueOf(code.substring(5, 8)) + 1 < 10) {
                    con = "00" + (Integer.valueOf(code.substring(5, 8)) + 1);
                } else if (Integer.valueOf(code.substring(5, 8)) + 1 >= 10 && Integer.valueOf(code.substring(5, 8)) + 1 < 100) {
                    con = "0" + (Integer.valueOf(code.substring(5, 8)) + 1);
                } else {
                    con = "" + (Integer.valueOf(code.substring(5, 8)) + 1);
                }
                documentsRequestDto.setNum(num + year + month + con);
            }
            flag = "1";
        } else {
            flag = "2";
        }
        Integer dId = documentsDao.addDocuments(documentsRequestDto);
        if ("2".equals(flag)) {
            getSyhkje(dId);
        }
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(documentsRequestDto.getuId());
        operateEntity.setdId(dId);
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XZDA);
        operateEntity.setChange("新增档案");
        operateDao.addOperate(operateEntity);
        List<BorrowRequestDto> borrowRequestDtos = documentsRequestDto.getBorrowRequestDto();
        for (BorrowRequestDto borrowRequestDto : borrowRequestDtos) {
            borrowRequestDto.setdId(dId);
            borrowDao.addBorrow(borrowRequestDto);
        }
        List<MortgageRequestDto> mortgageRequestDtos = documentsRequestDto.getMortgageRequestDto();
        for (MortgageRequestDto mortgageRequestDto : mortgageRequestDtos) {
            mortgageRequestDto.setdId(dId);
            mortgageDao.addMortgage(mortgageRequestDto);
        }
        return documentsRequestDto.getNum() + "," + dId;
    }

    public void zfhyDocuments(DocumentsRequestDto documentsRequestDto) {
        documentsDao.zfhyDocuments(documentsRequestDto.getId(), documentsRequestDto.getZfhy());
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(documentsRequestDto.getuId());
        operateEntity.setdId(documentsRequestDto.getId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.ZFHYDA);
        if (documentsRequestDto.getZfhy() == 1) {
            operateEntity.setChange("注销");
        } else {
            operateEntity.setChange("还原");
        }
        operateDao.addOperate(operateEntity);
    }

    public void updateDocuments(DocumentsUpdateRequestDto documentsUpdateRequestDto) {
        documentsDao.updateDocuments(documentsUpdateRequestDto.getDocumentsMsgRequestDto());
        getSyhkje(documentsUpdateRequestDto.getdId());
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(documentsUpdateRequestDto.getuId());
        operateEntity.setdId(documentsUpdateRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        operateEntity.setChange(documentsUpdateRequestDto.getChange());
        operateDao.addOperate(operateEntity);
    }

    public List<DocumentsResponseDto> selectDocuments(SelectDocumentsRequestDto selectDocumentsRequestDto) throws Exception {
//        List<Integer> listNum=documentsDao.selectIdByNum(selectDocumentsRequestDto.getNum());
//        List<Integer> listMortgage = mortgageDao.selectIdByName(selectDocumentsRequestDto.getMortgageName());
//        List<Integer> listBorrow = borrowDao.selectIdByNameOrCode(selectDocumentsRequestDto.getBorrowName(),selectDocumentsRequestDto.getBorrowCode());
        List<DocumentsResponseDto> documentsResponseDto = new ArrayList<>();
        List<DocumentsVo> documentsVo = documentsDao.selectDocuments(selectDocumentsRequestDto);
        for (DocumentsVo documents : documentsVo) {
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            int mon = DateUtil.getMonth(formatter.parse(documents.getDate()), new Date());
//            double syhkje = BigDecimal.valueOf(documents.getDuration() * 12 - mon).multiply(BigDecimal.valueOf(documents.getLoanAmount().floatValue())).divide(BigDecimal.valueOf(documents.getDuration() * 12), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
//            documents.setSyhkje(new BigDecimal(syhkje));
            DocumentsResponseDto documentsResponse = new DocumentsResponseDto();
            documentsResponse.setDocumentsVo(documents);
            List<FileVo> fileVo = fileDao.selectFileByDid(documents.getId());
            documentsResponse.setFileVo(fileVo);
            List<MortgageVo> mortgageVo = mortgageDao.selectMortgageByDid(documents.getId());
            documentsResponse.setMortgageVo(mortgageVo);
            List<BorrowVo> borrowVo = borrowDao.selectBorrowDaoByDid(documents.getId());
            documentsResponse.setBorrowVo(borrowVo);
            documentsResponseDto.add(documentsResponse);
        }
        return documentsResponseDto;
    }

    public void deleteDocuments(DocumentsDeleteRequestDto documentsDeleteRequestDto) {
//        OperateEntity operateEntity = new OperateEntity();
//        operateEntity.setuId(documentsDeleteRequestDto.getuId());
//        operateEntity.setDate(new Date());
//        operateEntity.setType(ConstantUtil.SCDA);
//        operateEntity.setChange("删除档案");
        String[] str = documentsDeleteRequestDto.getDeleteIds().split(",");
        for (int i = 0; i < str.length; i++) {
            Integer dId = Integer.valueOf(str[i]);
            List<Integer> ids = fileDao.getIdByDid(dId);
            for (Integer id : ids) {
                fileService.ddFile(id);
            }
            fileDao.deleteFileByDid(dId);
            borrowDao.deleteBorrowByDid(dId);
            mortgageDao.deleteMortgageByDid(dId);
            documentsDao.deleteDocuments(dId);
//          operateEntity.setdId(dId);
////        operateDao.addOperate(operateEntity);
            documentsDao.deleteOperate(dId);
        }
    }


    public Integer getDeleteDocuments() {
        return documentsDao.getDeleteDocuments();
    }

    public void deleteZxDocuments(DocumentsDeleteRequestDto documentsDeleteRequestDto) {
        List<Integer> ids = documentsDao.getDeleteDocumentsIds();
//        OperateEntity operateEntity = new OperateEntity();
//        operateEntity.setuId(documentsDeleteRequestDto.getuId());
//        operateEntity.setDate(new Date());
//        operateEntity.setType(ConstantUtil.SCDA);
//        operateEntity.setChange("删除档案");
        for (int i = 0; i < ids.size(); i++) {
            Integer dId = ids.get(i);
            List<Integer> idss = fileDao.getIdByDid(dId);
            for (Integer id : idss) {
                fileService.ddFile(id);
            }
            fileDao.deleteFileByDid(dId);
            borrowDao.deleteBorrowByDid(dId);
            mortgageDao.deleteMortgageByDid(dId);
            documentsDao.deleteDocuments(dId);
//          operateEntity.setdId(dId);
//          operateDao.addOperate(operateEntity);
            documentsDao.deleteOperate(dId);
        }
    }

    public void qTox(DocumentsRequestDto documentsRequestDto) {
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(documentsRequestDto.getuId());
        operateEntity.setdId(documentsRequestDto.getId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.QZX);
        operateEntity.setChange("期转现");
        operateDao.addOperate(operateEntity);
        documentsDao.qTox(documentsRequestDto.getId(), documentsRequestDto.getHouseStatus());
    }

    public Integer selectDocumentsCount(SelectDocumentsRequestDto selectDocumentsRequestDto) {
        return documentsDao.selectDocumentsCount(selectDocumentsRequestDto);
    }

    public void updateCertificatesStatus(Integer id, Integer certificatesStatus, Integer uId) {
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(uId);
        operateEntity.setdId(id);
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        String change = "房产证状态改为：";
        if (certificatesStatus == 1) {
            change += "在系统内";
        } else if (certificatesStatus == 2) {
            change += "预抵押";
        } else if (certificatesStatus == 3) {
            change += "内部调用";
        } else if (certificatesStatus == 4) {
            change += "房主取走";
        }
        operateEntity.setChange(change);
        operateDao.addOperate(operateEntity);
        documentsDao.updateCertificatesStatus(id, certificatesStatus);
    }

    public List<Integer> getDocmentsIds() {
        return documentsDao.getDocumentsIds();
    }

    public DocuVo getDocmentsById(Integer id) {
        return documentsDao.getDocmentsById(id);
    }

    public void updateDocumentsSyhkje(Integer id, BigDecimal monthCapital) {
        documentsDao.updateDocumentsSyhkje(id, monthCapital);
    }

    public void getSyhkje(Integer id) {
        DocuVo dVo = documentsService.getDocmentsById(id);
        BigDecimal invest = dVo.getLoanAmount(); // 本金
        int year = dVo.getDuration();//期限
        double yearRate;
        Date date;
        if (dVo.getDcId() == 3) {
            if (dVo.getDuration() / 12 <= 1) {
                yearRate = 0.0435;
            } else if (dVo.getDuration() / 12 > 1 && dVo.getDuration() / 12 < 5) {
                yearRate = 0.0475;
            } else {
                yearRate = 0.0490;
            }
            date = dVo.getDate();
        } else {
            if (dVo.getDuration() / 12 <= 5) {
                yearRate = 0.0275;
            } else {
                yearRate = 0.0325;
            }
            date = dVo.getKsDate();
        }
        double monthRate = yearRate / 12;
        int month = year;
        BigDecimal monthCapital;
        int count = DateUtil.differentMonths(new Date(), date);
        for (int i = 1; i <= count + 1; i++) {
            monthCapital = invest.multiply(new BigDecimal(monthRate * (Math.pow((1 + monthRate),
                    i - 1)))).divide(new BigDecimal(Math.pow(1 + monthRate, month) - 1), 2,
                    BigDecimal.ROUND_HALF_UP);
            documentsService.updateDocumentsSyhkje(id, documentsService.getDocmentsById(id).getSyhkje().subtract(monthCapital));
        }
    }

    public void updateDf(DfRequestDto dfRequestDto) {
        documentsDao.updateDf(dfRequestDto);
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(dfRequestDto.getuId());
        operateEntity.setdId(dfRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XGDA);
        if ("1".equals(dfRequestDto.getFlag())) {
            operateEntity.setChange("垫付金额：" + dfRequestDto.getJe() + "元");
        } else {
            operateEntity.setChange("取消垫付");
        }
        operateDao.addOperate(operateEntity);
    }

    public BigDecimal getDf(Integer dId) {
        return documentsDao.getDf(dId);
    }

    public int getNum(String num) {
        return documentsDao.getNum(num);
    }

    public void ssj() {
        List<Integer> list = documentsDao.getDocumentsIdss();
        for (Integer id : list) {
            getSyhkje(id);
        }
    }
}
