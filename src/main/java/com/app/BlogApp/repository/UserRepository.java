package com.app.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.BlogApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
