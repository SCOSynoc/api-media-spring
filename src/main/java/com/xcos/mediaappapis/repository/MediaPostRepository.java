package com.xcos.mediaappapis.repository;

import com.xcos.mediaappapis.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaPostRepository extends MongoRepository<Post,String> {

}
