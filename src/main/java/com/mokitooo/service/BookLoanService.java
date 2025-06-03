package com.mokitooo.service;

import com.mokitooo.dto.CreateLoanDto;

import java.util.UUID;

public interface BookLoanService {
    void borrowBook(CreateLoanDto createLoanDto);
    void returnBook(UUID id);
    boolean areAllBooksReturned();
}
