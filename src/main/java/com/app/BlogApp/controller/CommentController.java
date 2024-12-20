package com.app.BlogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.BlogApp.paylods.ApiResponse;
import com.app.BlogApp.paylods.CommentDto;
import com.app.BlogApp.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping(value="/postId/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,@PathVariable Integer postId){
		
		CommentDto commentDto = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(commentDto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer commentId) {
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment is deleted ..",true),HttpStatus.OK);
		
	}
}
