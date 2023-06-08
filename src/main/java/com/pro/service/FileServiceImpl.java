package com.pro.service;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.pro.util.DirUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.DecimalFormat;

@Service
@Slf4j
public class FileServiceImpl implements FileService {


    DirUtil check = new DirUtil();
    @Override
    public JSONObject fileUpload(MultipartFile file, String uploadFilePath) {
        JSONObject result = new JSONObject();
        if (file.isEmpty()){
            result.put("error","空文件");
            return result;
        }
        //文件大小
        /*long size = file.getSize();*/
        String[] arr = {"Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        float srcsize = Float.valueOf(file.getSize());
        int index = (int) (Math.floor(Math.log(srcsize) / Math.log(1024)));
        double longsize = srcsize / Math.pow(1024, index);
        longsize = Double.valueOf(new DecimalFormat("#.00").format(longsize));
        String size =  longsize + arr[index];

        //文件名
        String filename=file.getOriginalFilename();
       /* String realFilename = filename+new Date().getTime();*/
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String firstName = filename.substring(0,filename.lastIndexOf("."));
        String realFilename = firstName+suffixName;
        log.info("上传文件的名称为:{}，后缀为:{}",filename,suffixName);
        //进行后缀判断
        boolean flag = check.checkFormats(suffixName);
        if (!flag){
            result.put("error","文件格式出错");
            return result;
        }
        File fileTempObj = new File(uploadFilePath+"/"+realFilename);

        //检测目录是否存在
        if (!fileTempObj.getParentFile().exists()){
            fileTempObj.getParentFile().mkdirs();
        }

        //使用文件名称检测文件是否存在
        if (fileTempObj.exists()){
            result.put("error","文件已经存在");
            return result;
        }

        //写入文件
        try {
            FileUtil.writeBytes(file.getBytes(),fileTempObj);
        } catch (Exception e) {
            log.error("发送错误:{}",e);
            result.put("error",e.getMessage());
            return result;
        }

        return result;

    }





}
