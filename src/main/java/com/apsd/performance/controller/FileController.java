package com.apsd.performance.controller;

import com.apsd.performance.service.FileService;
import com.apsd.performance.vo.ResponseVo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author 大稽
 * @date2018/12/2013:00
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseVo uploadFiels(HttpServletRequest request, MultipartFile file) throws IOException {
        ResponseVo vo = new ResponseVo();
        String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
        System.out.println(filePath);
        File dir = new File(filePath);
        if(! dir.exists()) {
            dir.mkdir();
        }
        String key = file.getOriginalFilename();
        String path = filePath+key;
        File tempFile =  new File(path);
        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        String s = fileService.uploadFiel(tempFile,key);
        System.out.println(s);
        if(s!=null&&s!=""){
            vo.setCode(200);
            vo.setData(s);
        }
        return vo;
    }

    @PostMapping("/download")
    public void downloadFiel(HttpServletRequest request) throws IOException {

    }
}
