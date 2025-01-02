package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
	
	
}
