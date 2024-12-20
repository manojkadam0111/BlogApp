package com.app.BlogApp.service;

import java.util.List;

import com.app.BlogApp.models.Post;
import com.app.BlogApp.paylods.PostResponse;
import com.app.BlogApp.paylods.PostDto;

public interface PostService {

	//Create Post
	PostDto createPost(PostDto postDto , Integer userId,Integer categoryId);
	
	//Update Post
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Get All Posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//Get Post by Id
	PostDto getPostById(Integer postId);
	
	
	//Get Posts By Category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//Get Posts By User
	List<PostDto> getPostByUser(Integer userId);
	
	//get Post Search
	List<PostDto> searchPost(String keyword);
}
