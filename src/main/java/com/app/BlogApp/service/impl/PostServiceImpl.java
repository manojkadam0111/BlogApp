package com.app.BlogApp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.BlogApp.exceptions.ResourceNotFoundException;
import com.app.BlogApp.models.Category;
import com.app.BlogApp.models.Post;
import com.app.BlogApp.models.User;
import com.app.BlogApp.paylods.PostDto;
import com.app.BlogApp.paylods.PostResponse;
import com.app.BlogApp.repository.CategoryRepository;
import com.app.BlogApp.repository.PostRepository;
import com.app.BlogApp.repository.UserRepository;
import com.app.BlogApp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "User Id" ,userId));
		
		Category category = this.categoryRepository.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category", "Category Id" , categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class); 
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepository.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepository.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepository.findById(postId)
		.orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		
		this.postRepository.delete(post);
		
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {
		
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?sort = Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
	
		Pageable p = PageRequest.of(pageNumber, pageSize,Sort.by(sortBy).descending());
		Page<Post> postPage = this.postRepository.findAll(p);
		List<Post> allPost = postPage.getContent();
		
		List<PostDto> list = allPost.stream()
		.map((post->this.modelMapper.map(post, PostDto.class)))
		.collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(list);
		postResponse.setPageNumber(postPage.getNumber());
		postResponse.setPageSize(postPage.getSize());
		postResponse.setTotalElement(postPage.getTotalElements());
		postResponse.setTotalPages(postPage.getTotalPages());
		postResponse.setLastPages(postPage.isLast());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepository.findById(postId)
		.orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category categorybyId = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",categoryId));
		
		List<Post> posts = this.postRepository.findByCategory(categorybyId);
		
		List<PostDto> allPosts = posts.stream()
		.map((post->this.modelMapper.map(post, PostDto.class)))
		.collect(Collectors.toList());
		return allPosts;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user=this.userRepository
				.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		List<Post> byUser = this.postRepository.findByUser(user);
		
		List<PostDto> list = byUser.stream()
		.map((post->this.modelMapper.map(post, PostDto.class)))
		.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> posts = this.postRepository.findByTitleContaining(keyword);
		List<PostDto> listOfPost = posts.stream()
		.map((post)->this.modelMapper.map(post, PostDto.class))
		.collect(Collectors.toList());
		
		return listOfPost;
	}



}
