package com.app.BlogApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Comment {

	@Id
	private int id;
	
	private String content;
	
	@ManyToOne
	private Post post;
	
}
