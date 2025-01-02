package com.library.management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Author;
import com.library.management.repository.AuthorRepo;

@Repository
public class AuthorDao {
	@Autowired
	private AuthorRepo authorRepo;
	
	public Author saveAuthor(Author author) {
		return authorRepo.save(author);
	}
	public List<Author> getAllAuthor(){
		return authorRepo.findAll();
	}
	
	public Author getAuthorById(int id) {
		Optional<Author> author=authorRepo.findById(id);
		if(author.isPresent()) {
			Author presentAuthor=author.get();
			return presentAuthor;
		}
		else {
			return null;
		}
		
	}
	
	public Author updateAuthor(Author author,int id) {
		Optional<Author>Author=authorRepo.findById(id);
		if(Author.isPresent()) {
			Author updatedAuthor=Author.get();
			updatedAuthor.setName(author.getName());
			authorRepo.save(updatedAuthor);
			return updatedAuthor;
		}
		else return null;
	}

	public void deleteAuthor(int id) {
		authorRepo.deleteById(id);
	}
}
