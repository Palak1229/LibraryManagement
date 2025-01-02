package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.management.dao.LoanDao;
import com.library.management.dto.ResponseStructure;
import com.library.management.entity.Loan;

@Service
public class LoanService {
	@Autowired 
	private LoanDao loandao;
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoanData( Loan loan) {
        Loan saved = loandao.saveLoan(loan);
        ResponseStructure<Loan> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Loan saved");
        structure.setData(saved);

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

	public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoans() {
        List<Loan> loans = loandao.getAllLoans();
        ResponseStructure<List<Loan>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Loan fetched successfully");
        structure.setData(loans);

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
	

    public ResponseEntity<ResponseStructure<Loan>> getLoanById( int id) {
        Loan loan = loandao.getLoanById(id);
        ResponseStructure<Loan> structure = new ResponseStructure<>();

        if (loan != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Loan found");
            structure.setData(loan);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("Loan not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
	
    public ResponseEntity<ResponseStructure<Loan>> updateLoan( Loan book,  int id) {
        Loan updatedLoan = loandao.updateLoan(book, id);
        ResponseStructure<Loan> structure = new ResponseStructure<>();

        if (updatedLoan != null) {
            structure.setStatusCode(HttpStatus.OK.value());
            structure.setMessage("Loan updated successfully");
            structure.setData(updatedLoan);
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            structure.setMessage("loan not found");
            structure.setData(null);
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    
	 public ResponseEntity<ResponseStructure<String>> deleteLoan( int id) {
	        try {
	            loandao.deleteLoan(id);
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.OK.value());
	            structure.setMessage("Loan deleted successfully");
	            structure.setData("Deleted loan with ID: " + id);
	            return new ResponseEntity<>(structure, HttpStatus.OK);
	        } catch (Exception e) {
	            ResponseStructure<String> structure = new ResponseStructure<>();
	            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
	            structure.setMessage("Loan not found");
	            structure.setData(null);
	            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	        }
	    }


}
