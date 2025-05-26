package com.mokitooo.service;

import com.mokitooo.dto.BorrowBookDto;
import com.mokitooo.dto.ReturnBookDto;

public interface BookLoanService {
    void borrowBook(BorrowBookDto borrowBookDto);
    void returnBook(ReturnBookDto returnBookDto);
    boolean areAllBooksReturned();
}
