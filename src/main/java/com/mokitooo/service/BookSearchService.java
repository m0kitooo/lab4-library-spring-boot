package com.mokitooo.service;

import com.mokitooo.model.book.Book;

import java.util.List;

public interface BookSearchService {
    List<Book> findByTitle(String title);
    List<Book> findByKeyword(String keyword);
}
