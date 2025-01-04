package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Book;
import com.library.management.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookservice ; 
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Book>> saveBookData(@RequestBody Book book) {
    return bookservice.saveBookData(book);
	}
	@GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<List<Book>>>getAuthors() {
    	return bookservice.getAllBooks();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book>> getAuthorById(@PathVariable int id) {
        return bookservice.getBookById(id);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<ResponseStructure<List<Book>>> getAuthorByGenre(@PathVariable String genre) {
        return bookservice.getBookByGenre(genre);
    }
   @PutMapping("/update/{id}")
   public ResponseEntity<ResponseStructure<Book>> updateABookEntity(@RequestBody Book book, @PathVariable int id){
	   return bookservice.updateBook(book, id);
   }
   
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteAuthor(@PathVariable int id) {
       return bookservice.deleteBook(id);

    }
}

