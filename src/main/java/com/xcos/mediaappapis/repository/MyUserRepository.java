package com.xcos.mediaappapis.repository;

import com.xcos.mediaappapis.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MyUserRepository extends MongoRepository<User, String> {

}
