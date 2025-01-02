package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	List<Book> findBookByGenre(String genre);

}
