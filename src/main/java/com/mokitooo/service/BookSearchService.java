package com.mokitooo.service;

import com.mokitooo.dto.BookDto;
import com.mokitooo.model.book.Book;

import java.util.List;

public interface BookSearchService {
    List<BookDto> findAll();
    List<Book> findByTitle(String title);
    List<Book> findByKeyword(String keyword);
}
