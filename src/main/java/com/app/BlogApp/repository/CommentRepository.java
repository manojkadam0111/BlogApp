package com.app.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.BlogApp.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
