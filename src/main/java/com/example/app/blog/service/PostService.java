package com.example.app.blog.service;

import com.example.app.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
