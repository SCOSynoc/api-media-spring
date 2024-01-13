package com.xcos.mediaappapis.controller;


import com.xcos.mediaappapis.model.Post;
import com.xcos.mediaappapis.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class PostsController {

    private PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping(value = "/media-api/users/{id}/posts")
    public void createPostForUser(@PathVariable String id, @Valid @RequestBody Post post, BindingResult result){
       postsService.createPost(id, post, result);
    }

    @GetMapping(value = "/media-api/users/{id}/posts")
    public List<Post> getPostsList(@PathVariable String id){
        return postsService.getPostsList(id);
    }

    @DeleteMapping(value = "/media-api/users/{id}/posts/{pid}")
    public void deletePost(@PathVariable String id, @PathVariable String pid){
        postsService.deletePost(id, pid);
    }



}
