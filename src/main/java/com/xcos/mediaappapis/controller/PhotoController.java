package com.xcos.mediaappapis.controller;

import com.xcos.mediaappapis.dto.PhotoResponse;
import com.xcos.mediaappapis.dto.PhotoUrl;
import com.xcos.mediaappapis.model.Photo;
import com.xcos.mediaappapis.service.PhotoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;

@RestController
public class PhotoController {

    private PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    /*@PostMapping(value = "/media-api/photo")
    @ResponseStatus(HttpStatus.CREATED)
    public String addPhotoToDB(@RequestParam("photoId") String photoId, @RequestParam("image") MultipartFile image) throws IOException {
        return photoService.addPhoto("657c5d9010a497336a38b5b4",MultipartFile.class.cast("image/jpeg"));
    }

    @GetMapping(value = "/media-api/photo")
    @ResponseStatus(HttpStatus.FOUND)
    public PhotoResponse getPhoto(@RequestParam("id")String associatedId) {
        return  photoService.getPhoto(associatedId);
    }*/

    @PostMapping("/media-api/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        HashMap<String,String> dataMap = new HashMap<>();
        dataMap.put("fileId",photoService.addPhoto(file));
        /*URI location = ServletUriComponentsBuilder.fromContextPath()
                .buildAndExpand(photoService.addPhoto(file))
                .toUri();
        dataMap.put("fileUrl", location.getPath());*/
        return new ResponseEntity<>(
                dataMap,HttpStatus.CREATED);
    }



    @GetMapping("/media-api/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        Photo loadFile = photoService.getPhotoGrid(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
                .body(new ByteArrayResource(loadFile.getFile()));
    }
}
