package com.app.BlogApp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.BlogApp.exceptions.ResourceNotFoundException;
import com.app.BlogApp.models.Category;
import com.app.BlogApp.models.User;
import com.app.BlogApp.paylods.CategoryDto;
import com.app.BlogApp.paylods.UserDto;
import com.app.BlogApp.repository.CategoryRepository;
import com.app.BlogApp.service.CategoryServiceI;

@Service
public class CategoryServiceImpl implements CategoryServiceI {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category map = this.modelMapper.map(categoryDto,Category.class);
		Category save = this.categoryRepository.save(map);
		return this.modelMapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer cId) {
		Category byId = this.categoryRepository.findById(cId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",cId));
		
		byId.setCategoryTital(categoryDto.getCategoryTital());
		byId.setCategoryDiscription(categoryDto.getCategoryDiscription());
		
		Category update = this.categoryRepository.save(byId);
		
		return this.modelMapper.map(update, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer cId) {
		Category orElseThrow = this.categoryRepository.findById(cId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",cId));
		this.categoryRepository.delete(orElseThrow);
	}

	@Override
	public CategoryDto getById(Integer cId) {
		Category getbyId = this.categoryRepository.findById(cId)
		.orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id",cId));
		return this.modelMapper.map(getbyId, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> list = this.categoryRepository.findAll();
		List<CategoryDto> userList = list.stream()
				.map(u-> this.modelMapper.map(u, CategoryDto.class))
				.collect(Collectors.toList());
		return userList;
	}

}
