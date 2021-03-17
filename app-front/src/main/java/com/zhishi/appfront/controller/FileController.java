package com.zhishi.appfront.controller;

import com.zhishi.appfront.common.EquityResult;
import com.zhishi.appfront.common.InitMsg;
import com.zhishi.appfront.entity.dto.request.FileRequestDto;
import com.zhishi.appfront.service.FileService;
import com.zhishi.appfront.util.DateUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * 文件
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @CrossOrigin
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public synchronized String upload(MultipartFile file) throws Exception {
        String date = DateUtil.yyyyMMdd.format(new Date());
        String url = InitMsg.wayUrl + date;
        String path = InitMsg.way + date;
        // 获取上传的位置（存放图片的文件夹）,如果不存在，创建文件夹
        File fileParent = new File(path);
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        String[] hz = file.getOriginalFilename().split("\\.");
        String way = path + "/" + System.currentTimeMillis() + "." + hz[1];
        url += "/" + System.currentTimeMillis() + "." + hz[1];
        File newFile = new File(way);
        // 如果不存在，创建一个副本
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        // 将io上传到副本中
        file.transferTo(newFile);
        return url;
    }


    @CrossOrigin
    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public void download(@PathVariable String fileName, HttpServletResponse response) {
        try (
                InputStream inputStream = new FileInputStream(new File("d://StartTask.java"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            //指明为下载
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);   // 设置文件名
            //把输入流copy到输出流
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @CrossOrigin
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public EquityResult addFile(@RequestBody FileRequestDto fileRequestDto) throws Exception {
        return new EquityResult("操作成功", fileService.addFile(fileRequestDto), 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public EquityResult deleteFile(@RequestBody FileRequestDto fileRequestDto) throws Exception {
        fileService.deleteFile(fileRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteFileNew", method = RequestMethod.POST)
    public EquityResult deleteFileNew(@RequestBody FileRequestDto fileRequestDto) throws Exception {
        fileService.deleteFileNew(fileRequestDto);
        return new EquityResult("操作成功", "", 0);
    }

}
