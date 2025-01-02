package com.library.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Book;
import com.library.management.repository.BookRepo;

@Repository
public class BookDao {
 @Autowired
 private BookRepo bookrepo;
	public Book saveBook(Book book) {
		return bookrepo.save(book);
	}
	public List<Book> getAllbook(){
		return bookrepo.findAll();
	}
	
	public Book getBookById(int id) {
		Optional<Book> book=bookrepo.findById(id);
			if(book.isPresent()) {
			Book presentBook=book.get();
			return presentBook;
		}
		else {
			return null;
		}	
	}
	public List<Book> getBookByGenre(String genre) {
		
		List<Book> book=bookrepo.findBookByGenre(genre);
		if(book.size()!= 0) {
		return book;
	}
	else {
		return null;
	}	
	}
	
	public Book updateBook(Book book ,int id) {
		Optional<Book>Book=bookrepo.findById(id);
		if(Book.isPresent()) {
			Book updatedBook=Book.get();
			updatedBook.setGenre(book.getGenre());
			updatedBook.setAuthor(book.getAuthor());
			updatedBook.setTitle(book.getTitle());
			bookrepo.save(updatedBook);
			return updatedBook;
		}
		else return null;
	}

	public void deleteBook(int id) {
		bookrepo.deleteById(id);
	}
}
