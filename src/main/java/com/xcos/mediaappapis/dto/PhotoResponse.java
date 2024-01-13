package com.xcos.mediaappapis.dto;

public class PhotoResponse {

    String fileUrl;

    public PhotoResponse() {

    }


    public PhotoResponse(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
