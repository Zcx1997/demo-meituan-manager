package com.pro.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//传入文件后缀选择
public class DirUtil {
    public boolean checkFormats(String fileFullName){
        List<String> supportFileFormats =new ArrayList<>(Arrays.asList("rar,zip,doc,docx,pdf,jpg".split(",")));
        String suffix = fileFullName.substring(fileFullName.lastIndexOf(".") + 1).toLowerCase();
        return supportFileFormats.stream().anyMatch(suffix::contains);
    }
}
