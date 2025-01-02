package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.management.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer>{

}
