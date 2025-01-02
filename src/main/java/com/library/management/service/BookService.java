package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.management.dao.BookDao;
import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Author;
import com.library.management.entity.Book;
import com.library.management.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookDao bookdao;
	
	public ResponseEntity<ResponseStructure<Book>> saveBookData( Book book) {
        Book saved = bookdao.saveBook(book);
        ResponseStructure<Book> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Book saved");
        structure.setData(saved);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
        List<Book> books = bookdao.getAllbook();
        ResponseStructure<List<Book>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Books fetched successfully");
        structure.setData(books);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
	

    public ResponseEntity<ResponseStructure<Book>> getBookById( int id) {
        Book book = bookdao.getBookById(id);
        ResponseStructure<Book> structure = new ResponseStructure<>();

        if (book != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Book found");
            structure.setData(book);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Book not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
    public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre( String genre ){
		List<Book> book = bookdao.getBookByGenre(genre);
		
		if(book!=null) {
		ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(book);

		return new  ResponseEntity<ResponseStructure <List<Book>>> (structure, HttpStatus.OK);
		}
		else {
			ResponseStructure<List<Book>> structure = new ResponseStructure<List<Book>>();
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Failed");
			structure.setData(null);
			return new  ResponseEntity<ResponseStructure <List<Book>>> (structure, HttpStatus.NOT_FOUND);
		}
	}

	
    public ResponseEntity<ResponseStructure<Book>> updateBook( Book book,  int id) {
        Book updatedBook = bookdao.updateBook(book, id);
        ResponseStructure<Book> structure = new ResponseStructure<>();

        if (updatedBook != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Book updated successfully");
            structure.setData(updatedBook);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("book not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
	 public ResponseEntity<ResponseStructure<String>> deleteBook( int id) {
	        try {
	            bookdao.deleteBook(id);
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.OK.value());
	            structure.setMessage("Book deleted successfully");
	            structure.setData("Deleted book with ID: " + id);
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } catch (Exception e) {
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	            structure.setMessage("Book not found");
	            structure.setData(null);
	            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	        }
	    }
}

	

	