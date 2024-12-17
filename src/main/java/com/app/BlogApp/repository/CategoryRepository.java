package com.app.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.BlogApp.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
