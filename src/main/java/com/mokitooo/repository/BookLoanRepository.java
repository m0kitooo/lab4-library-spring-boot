package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import com.mokitooo.model.loan.Loan;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface BookLoanRepository {
    Optional<Loan> findById(UUID id);
    Set<Loan> findAll();
    List<Consumer> findConsumersByBookId(UUID bookId);
    void save(Loan loan);
    void update(Loan loan);
}
