package com.library.management.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Loan;
import com.library.management.repository.LoanRepo;

@Repository
public class LoanDao {
	@Autowired
	private LoanRepo loanrepo;
	
	public Loan saveLoan(Loan loan) {
		return loanrepo.save(loan);
	}
	public List<Loan> getAllLoans(){
		return loanrepo.findAll();
	}
	
	public Loan getLoanById(int id) {
		Optional<Loan> loan=loanrepo.findById(id);
			if(loan.isPresent()) {
			Loan presentLoan=loan.get();
			return presentLoan;
		}
		else {
			return null;
		}	
	}
	
	public Loan updateLoan(Loan loan ,int id) {
		Optional<Loan>Loan=loanrepo.findById(id);
		if(Loan.isPresent()) {
			Loan updatedLoan=Loan.get();
			updatedLoan.setLoandate(loan.getLoandate());
			updatedLoan.setReturndate(loan.getReturndate());
			updatedLoan.setBook(loan.getBook());
			updatedLoan.setMember(loan.getMember());
			loanrepo.save(updatedLoan);
			return updatedLoan;
		}
		else return null;
	}

	public void deleteLoan(int id) {
		loanrepo.deleteById(id);
	}

}
