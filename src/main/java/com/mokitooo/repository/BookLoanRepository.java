package com.mokitooo.repository;

import com.mokitooo.model.loan.Loan;

import java.util.Set;

public interface BookLoanRepository {
    Loan findById(Long id);
    Set<Loan> findAll();
    void save(Loan loan);
    void update(Loan loan);
}
