package com.blog.app.services;

import com.blog.app.dto.PostDto;
import com.blog.app.entities.Post;
import com.blog.app.paloads.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost( Integer postId);
    //get post
    PostResponse getAllPostList(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    //get single post;
    PostDto getPostById(Integer postId);
    //get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);
    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);
    //search
    List<PostDto> searchPosts(String keyword);
}
