package com.app.BlogApp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BlogApp.exceptions.ResourceNotFoundException;
import com.app.BlogApp.models.Comment;
import com.app.BlogApp.models.Post;
import com.app.BlogApp.paylods.CommentDto;
import com.app.BlogApp.repository.CommentRepository;
import com.app.BlogApp.repository.PostRepository;
import com.app.BlogApp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepository.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		 Comment save = this.commentRepository.save(comment);
		return this.modelMapper.map(save, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepository.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment", "Comment Id" ,commentId));
		
		this.commentRepository.delete(comment);
	}

}