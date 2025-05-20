package com.mokitooo.service;

import com.mokitooo.model.loan.Loan;

public interface BookLoanService {
    void borrowBook(Loan loan);
    void returnBook(long loanId);
    boolean areAllBooksReturned(Loan loan);
}
