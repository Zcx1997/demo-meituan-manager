package com.pro.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFile {
    public String UploadFile(MultipartFile upload, String path) throws IOException {
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //如果这个文件夹不存在的话,就创建这个文件
            file.mkdirs();
        }
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        System.out.println(filename);

        System.out.println(filename);
        //完成文件上传
        upload.transferTo(new File(path, filename));
        String filePath = "upload/" + filename;
        return filePath;
    }


}
