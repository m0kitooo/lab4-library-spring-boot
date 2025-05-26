package com.mokitooo.repository;

import com.mokitooo.model.loan.Loan;

import java.util.Set;
import java.util.UUID;

public interface BookLoanRepository {
    Loan findById(UUID id);
    Set<Loan> findAll();
    void save(Loan loan);
    void update(Loan loan);
}
