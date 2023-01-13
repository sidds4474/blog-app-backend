package com.example.app.blog.service.impl;

import com.example.app.blog.model.Post;
import com.example.app.blog.payload.PostDto;
import com.example.app.blog.repository.PostRepository;
import com.example.app.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

       Post post = mapToEntity(postDto);



       Post newPost = postRepository.save(post);
       //return post (database--save -- post(title,description,content)

       //convert entity to dto

        PostDto postResponse = mapToDTO(newPost);

        return  postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {

        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

    }


    // convert  DTO to Entity
    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }


    // convert entity to DTO
    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }



}













