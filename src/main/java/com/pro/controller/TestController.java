package com.pro.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.pro.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("file")
@Slf4j
@CrossOrigin
public class TestController {
    @Value("${file.upload.dir}")
    private String uploadFilePath;


    @Autowired
    private FileService fileService;

    //  文件上传
    @PostMapping("/uploadFile")
    public JSONObject fileUpload(MultipartFile file) throws JsonEOFException {
        JSONObject result = fileService.fileUpload(file, uploadFilePath);
        return result;

    }

    @RequestMapping("/uploadHead")
    public void ReturnHead(MultipartFile upload) throws IOException {
        System.out.println("13512");

    }



}
