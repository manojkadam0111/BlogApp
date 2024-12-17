package com.app.BlogApp.service;

import java.util.List;

import com.app.BlogApp.paylods.CategoryDto;

public interface CategoryServiceI {

	//create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categoryDto , Integer cId);
	
	//delete
	void deleteCategory(Integer cId);
	
	//get
	CategoryDto getById(Integer cId);
	
	//getAll
	public List<CategoryDto> getAllCategory();
}
