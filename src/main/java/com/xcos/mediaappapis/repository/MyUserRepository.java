package com.xcos.mediaappapis.repository;

import com.xcos.mediaappapis.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface MyUserRepository extends MongoRepository<User, String> {

    @Query("{name:'?0'}")
    User findItemByName(String name);



}
