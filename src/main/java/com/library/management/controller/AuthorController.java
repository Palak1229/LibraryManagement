package com.library.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.library.management.entity.Author;
import com.library.management.repository.AuthorRepo;
import com.library.management.service.AuthorService;
//import com.springlearn.springboot.Student;

@RestController
@RequestMapping("/author")
public class AuthorController {


	    @Autowired
	    private AuthorService authorService;
	    
	    @PostMapping("/save")
	    public ResponseEntity<ResponseStructure<Author>> saveAuthorData(@RequestBody Author author) {
	       return authorService.saveAuthorData(author);
	    }
	    
	    @GetMapping("/fetch")
	    public ResponseEntity<ResponseStructure<List<Author>>> getAllAuthors() {
	    	return authorService.getAllAuthors();
	    }
	    

	    @GetMapping("/{id}")
	    public ResponseEntity<ResponseStructure<Author>> getAuthorById(@PathVariable int id) {
	        return authorService.getAuthorById(id);
	    }

	   @PutMapping("/update/{id}")
	   public ResponseEntity<ResponseStructure<Author>> updateAuthorEntity(@RequestBody Author author , @PathVariable int id){
		   return authorService.updateAuthor(author, id);
	   }
	   
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponseStructure<String>> deleteAuthor(@PathVariable int id) {
	       return authorService.deleteAuthor(id);
	}
}


