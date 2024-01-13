package com.xcos.mediaappapis.dto;

import java.net.URI;

public class PhotoUrl {

    URI fileUrl;

    public PhotoUrl() {
    }

    public PhotoUrl(URI fileUrl) {
        this.fileUrl = fileUrl;
    }

    public URI getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(URI fileUrl) {
        this.fileUrl = fileUrl;
    }
}
