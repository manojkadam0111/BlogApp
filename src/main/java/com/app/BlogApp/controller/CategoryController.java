package com.app.BlogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.BlogApp.paylods.ApiResponse;
import com.app.BlogApp.paylods.CategoryDto;
import com.app.BlogApp.paylods.UserDto;
import com.app.BlogApp.service.CategoryServiceI;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceI categoryServiceI;
	
	@PostMapping(value="/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto category = this.categoryServiceI.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/update/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer cId ){
		CategoryDto updateCategory = this.categoryServiceI.updateCategory(categoryDto, cId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value = "/deleteCategory/{cId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer cId) {
		this.categoryServiceI.deleteCategory(cId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted", true), HttpStatus.OK);
	}
	
	@GetMapping(value="/getById/{cId}")
	public ResponseEntity<CategoryDto> getUserById(@PathVariable Integer cId){
		return ResponseEntity.ok(this.categoryServiceI.getById(cId));
	}
	
	@GetMapping(value="/getAllCategory")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> list = this.categoryServiceI.getAllCategory();
		return new ResponseEntity<List<CategoryDto>>(list,HttpStatus.OK);
	}
}
