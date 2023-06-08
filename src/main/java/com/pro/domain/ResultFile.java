package com.pro.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultFile {
    private int fileId;
    private String fileName;
    private String realFileName;
    private String fileSize;
    private String date;
    private String fileUser;
    private int eid;

    public ResultFile(int fileId, String fileName, String realFileName, String fileSize, String date, String fileUser, int eid) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.realFileName = realFileName;
        this.fileSize = fileSize;
        this.date = date;
        this.fileUser = fileUser;
        this.eid = eid;
    }
}
