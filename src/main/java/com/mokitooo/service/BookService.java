package com.mokitooo.service;

import com.mokitooo.dto.CreateBookDto;
import com.mokitooo.dto.BookDto;

import java.util.UUID;

public interface BookService {
    BookDto registerBook(CreateBookDto createBookDto);
    BookDto deleteBook(UUID id);
    void block(UUID id);
}
