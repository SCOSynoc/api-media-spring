package com.xcos.mediaappapis.service;


import com.xcos.mediaappapis.exception.CustomizeResponseExceptionHandler;
import com.xcos.mediaappapis.exception.UserNotFoundException;
import com.xcos.mediaappapis.model.Post;
import com.xcos.mediaappapis.model.User;
import com.xcos.mediaappapis.repository.MediaPostRepository;
import com.xcos.mediaappapis.repository.MyUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class PostsService {

    private MyUserRepository myUserRepository;

    private MediaPostRepository mediaPostRepository;

    public PostsService(MyUserRepository myUserRepository, MediaPostRepository mediaPostRepository) {
        this.myUserRepository = myUserRepository;
        this.mediaPostRepository = mediaPostRepository;
    }

    public void createPost(String id, Post post, BindingResult result){
        User user = myUserRepository.findById(id).orElse(null);
        if(result.hasErrors()) {
            throw new RuntimeException();
        }
        if(user == null) {
            throw new UserNotFoundException("User does not exist");
        }else{
            Post newPost = new Post();
            newPost.setId(post.getId());
            newPost.setDescription(post.getDescription());
            newPost.setUser(user);
            mediaPostRepository.save(newPost);
        }
    }

    public List<Post> getPostsList(String id) {
        User user = myUserRepository.findById(id).orElse(null);
        if(user == null) {
            throw new UserNotFoundException("User does not exist");
        }else{
           return mediaPostRepository.findAll();
        }
    }


    public void deletePost(String id, String postId){
        User user = myUserRepository.findById(id).orElse(null);
        if(user == null){
            throw new UserNotFoundException("User does not exists");
        }else{
            Post post = mediaPostRepository.findById(postId).orElse(null);
            assert post != null;
            if(post.getUser().getId().equals(user.getId())){
                mediaPostRepository.deleteById(postId);
            }
        }
    }
}
