package com.app.BlogApp.paylods;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {

	private int categoryId;
	
	@NotBlank
	@Size(min=4,message = "Not Valid Tital !!!")
	private String categoryTital;
	
	@NotBlank
	@Size(min=10,message = "Discription minimum 10 Words")
	private String categoryDiscription;
}
