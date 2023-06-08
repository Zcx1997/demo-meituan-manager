package com.pro.service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public interface FileService {
    public JSONObject fileUpload(MultipartFile file,String uploadFilePath);


}
