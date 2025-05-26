package com.mokitooo.service;

import com.mokitooo.dto.DeleteBookDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.model.loan.Loan;

import java.util.List;
import java.util.UUID;

public interface BookService {
    void registerBook(Book book);
    DeleteBookDto deleteBook(UUID bookId);
    void block(UUID bookId);
}
