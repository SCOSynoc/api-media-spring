package com.xcos.mediaappapis.service;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xcos.mediaappapis.dto.PhotoResponse;
import com.xcos.mediaappapis.dto.PhotoUrl;
import com.xcos.mediaappapis.model.Photo;
import com.xcos.mediaappapis.repository.PhotoRepository;
import org.apache.commons.io.IOUtils;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;
import org.apache.commons.io.IOUtils;

@Service
public class PhotoService {

//    PhotoRepository photoRepository;

    private GridFsTemplate gridFsTemplate;

    private GridFsOperations gridFsOperations;


    public PhotoService(GridFsTemplate gridFsTemplate, GridFsOperations gridFsOperations) {
        this.gridFsTemplate = gridFsTemplate;
        this.gridFsOperations = gridFsOperations;
    }

    public String addPhoto(MultipartFile file) throws IOException {
        DBObject metadata = new BasicDBObject();
        metadata.put("fileSize", file.getSize());

       /* Photo photo = new Photo();
        photo.setPhotoId(id);
        photo.setImage( new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepository.insert(photo);
        return photo.getPhotoId();*/

         Object fileId = gridFsTemplate.store(
                file.getInputStream(),
                file.getOriginalFilename(),
                file.getContentType(),
                metadata);

         return fileId.toString();
    }

    public Photo getPhotoGrid(Object fileId)throws  IOException{
        try{

            GridFSFile gridFSFile = gridFsTemplate.findOne( new Query(Criteria.where("_id").is(fileId)) );
            Photo loadFile = new Photo();

            if (gridFSFile != null && gridFSFile.getMetadata() != null) {
                loadFile.setFilename( gridFSFile.getFilename() );

                loadFile.setFileType( gridFSFile.getMetadata().get("_contentType").toString() );

                loadFile.setFileSize( gridFSFile.getMetadata().get("fileSize").toString() );

                loadFile.setFile( IOUtils.toByteArray(gridFsOperations.getResource(gridFSFile).getInputStream()) );
            }

           /* URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(loadFile.getFile())
                    .toUri();

            PhotoUrl photoUrl = new PhotoUrl();
            photoUrl.setFileUrl(location);*/
            return loadFile;
        }catch (Exception e) {
            System.out.println("Here in catch of add photo its :: " + e);
            throw new IOException(e);
        }
    };








    public PhotoResponse getPhoto(String associatedId) {
        /*try {
            Photo photo = photoRepository.findById(associatedId).orElse(null);
            assert photo != null;
            String image =Base64.getEncoder().encodeToString(photo.getImage().getData());
            PhotoResponse res = new PhotoResponse();
            res.setFileUrl(image);
            return res;
        }catch (Exception e) {
            throw new NotFoundException(e.getMessage() + e.getCause());
        }*/

        PhotoResponse res = new PhotoResponse();
        return  res;

    }



}
