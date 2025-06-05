package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import com.mokitooo.model.loan.BookLoan;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface BookLoanRepository {
    Optional<BookLoan> findById(UUID id);
    Set<BookLoan> findAll();
    List<Consumer> findConsumersByBookId(UUID bookId);
    void save(BookLoan bookLoan);
    void update(BookLoan bookLoan);
}
