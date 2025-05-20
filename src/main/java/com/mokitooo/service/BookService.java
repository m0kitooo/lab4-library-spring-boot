package com.mokitooo.service;

import com.mokitooo.model.book.Book;
import com.mokitooo.model.loan.Loan;

import java.util.List;

public interface BookService {
    void registerBook(Book book);
    void deleteBook(Long bookId);
    void block(int bookId);
}
