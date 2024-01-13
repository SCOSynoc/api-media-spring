package com.xcos.mediaappapis.model;


import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "media_photos")
public class Photo {

    // this photoId is the id which is associated with the content of an image for example if its user image
    // then you have to pass user id if this post image then you have to pass postId
    /*private String photoId;
    private Binary image;


    public Photo(String photoId, Binary image) {
        this.photoId = photoId;
        this.image = image;
    }

    public Photo() {

    }


    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }*/

    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;

    public Photo() {
    }

    public Photo(String filename, String fileType, String fileSize, byte[] file) {
        this.filename = filename;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
