package com.zhishi.appfront.service;

import com.zhishi.appfront.common.InitMsg;
import com.zhishi.appfront.dao.FileDao;
import com.zhishi.appfront.dao.OperateDao;
import com.zhishi.appfront.entity.OperateEntity;
import com.zhishi.appfront.entity.dto.request.FileRequestDto;
import com.zhishi.appfront.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FileService {

    @Autowired
    private FileDao fileDao;

    @Autowired
    private OperateDao operateDao;

    public Integer addFile(FileRequestDto fileRequestDto) {
        Integer fId = fileDao.addFile(fileRequestDto);
        OperateEntity operateEntity = new OperateEntity();
        operateEntity.setuId(fileRequestDto.getuId());
        operateEntity.setdId(fileRequestDto.getdId());
        operateEntity.setDate(new Date());
        operateEntity.setType(ConstantUtil.XZFJ);
        operateEntity.setChange("添加文件：" + fileRequestDto.getName());
        operateDao.addOperate(operateEntity);
        return fId;
    }

    public void deleteFile(FileRequestDto fileRequestDto) {
        fileDao.deleteFile(fileRequestDto);
        ddFile(fileRequestDto.getId());
        if (fileRequestDto.getdId() == null) {
            OperateEntity operateEntity = new OperateEntity();
            operateEntity.setuId(fileRequestDto.getuId());
            operateEntity.setdId(fileRequestDto.getdId());
            operateEntity.setDate(new Date());
            operateEntity.setType(ConstantUtil.SCFJ);
            operateEntity.setChange("删除文件：" + fileRequestDto.getName());
            operateDao.addOperate(operateEntity);
        }
    }

    public void ddFile(Integer fId) {
        String url = fileDao.getUrl(fId);
        url = InitMsg.way + url.split("/")[2] + "/" + url.split("/")[3];
        File file = new File(url);
        file.delete();
    }


    public void deleteFileNew(FileRequestDto fileRequestDto) {
        String url = fileRequestDto.getUrl();
        url = InitMsg.way + url.split("/")[2] + "/" + url.split("/")[3];
        File file = new File(url);
        file.delete();
    }
}
