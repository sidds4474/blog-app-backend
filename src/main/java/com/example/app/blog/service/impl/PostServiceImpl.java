package com.example.app.blog.service.impl;

import com.example.app.blog.model.Post;
import com.example.app.blog.payload.PostDto;
import com.example.app.blog.repository.PostRepository;
import com.example.app.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;



    // constructor
    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    @Override
    public PostDto createPost(PostDto postDto) {

       // request(data)----> save database ---> response(data)


       //convert dto to entity

       Post post = new Post();
       post.setTitle(postDto.getTitle());
       post.setDescription(postDto.getDescription());
       post.setContent(postDto.getContent());


       Post newPost = postRepository.save(post);
       //return post (database--save -- post(title,description,content)

       //convert entity to dto
        PostDto postResponse = new PostDto();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setContent(newPost.getContent());


        return  postResponse;
    }
}













