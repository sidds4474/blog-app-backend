package com.example.app.blog.controller;


import com.example.app.blog.payload.PostDto;
import com.example.app.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")

// http://localhost:8080/api/posts/ ??(Post apis)

public class PostController {

    // Post APIs

    private PostService postService;


    // dependency injection
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 1st Api
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }



}
