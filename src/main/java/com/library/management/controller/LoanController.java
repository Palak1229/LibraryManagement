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
import com.library.management.entity.Loan;
import com.library.management.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanservice;
	
	@PostMapping("/save")
    public ResponseEntity<ResponseStructure<Loan>> saveLoanData(@RequestBody Loan loan) {
       return loanservice.saveLoanData(loan);
    }
    
    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<List<Loan>>> getAllLoans() {
    	return loanservice.getAllLoans();
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Loan>> getLoanById(@PathVariable int id) {
        return loanservice.getLoanById(id);
    }

   @PutMapping("/update/{id}")
   public ResponseEntity<ResponseStructure<Loan>> updateLoanEntity(@RequestBody Loan loan , @PathVariable int id){
	   return loanservice.updateLoan(loan, id);
   }
   
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteLoan(@PathVariable int id) {
       return loanservice.deleteLoan(id);
}
}
