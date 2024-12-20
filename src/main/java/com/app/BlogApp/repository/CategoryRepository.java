package com.app.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.BlogApp.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
