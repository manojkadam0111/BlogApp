package com.app.BlogApp.paylods;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.BlogApp.models.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private int postId;

	private String title;
	
	private String content;
	
    private String imageName;
	
	private Date addedDate;	
	
	private CategoryDto category;

	private UserDto user;
	
	private Set<Comment> comment= new HashSet<>();
}
