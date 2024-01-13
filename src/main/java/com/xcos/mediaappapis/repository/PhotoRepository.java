package com.xcos.mediaappapis.repository;

import com.xcos.mediaappapis.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}
