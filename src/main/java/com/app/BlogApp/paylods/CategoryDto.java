package com.app.BlogApp.paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	
	private String categoryTital;
	
	private String categoryDiscription;
}
