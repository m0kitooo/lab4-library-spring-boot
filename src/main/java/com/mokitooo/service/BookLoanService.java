package com.mokitooo.service;

import com.mokitooo.dto.BorrowBookDto;
import com.mokitooo.model.loan.Loan;

import java.util.UUID;

public interface BookLoanService {
    void borrowBook(BorrowBookDto borrowBookDto);
    void returnBook(UUID loanId);
    boolean areAllBooksReturned(Loan loan);
}
