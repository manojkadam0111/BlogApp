package com.app.BlogApp.service;

import com.app.BlogApp.paylods.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId);
}
