package com.library.management.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.management.dao.AuthorDao;
import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Author;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao authordao;
	
	public ResponseEntity<ResponseStructure<Author>> saveAuthorData( Author author) {
        Author saved = authordao.saveAuthor(author);
        ResponseStructure<Author> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Author saved");
        structure.setData(saved);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

	public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthors() {
        List<Author> authors = authordao.getAllAuthor();
        ResponseStructure<List<Author>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Authors fetched successfully");
        structure.setData(authors);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
	

    public ResponseEntity<ResponseStructure<Author>> getAuthorById( int id) {
        Author author = authordao.getAuthorById(id);
        ResponseStructure<Author> structure = new ResponseStructure<>();

        if (author != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Author found");
            structure.setData(author);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Author not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
	
    public ResponseEntity<ResponseStructure<Author>> updateAuthor( Author author,  int id) {
        Author updatedAuthor = authordao.updateAuthor(author, id);
        ResponseStructure<Author> structure = new ResponseStructure<>();

        if (updatedAuthor != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Author updated successfully");
            structure.setData(updatedAuthor);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Author not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
	 public ResponseEntity<ResponseStructure<String>> deleteAuthor( int id) {
	        try {
	            authordao.deleteAuthor(id);
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.OK.value());
	            structure.setMessage("Author deleted successfully");
	            structure.setData("Deleted author with ID: " + id);
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } catch (Exception e) {
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	            structure.setMessage("Author not found");
	            structure.setData(null);
	            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	        }
	    }
}
