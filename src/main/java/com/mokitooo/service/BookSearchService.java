package com.mokitooo.service;

import com.mokitooo.model.book.Book;

import java.util.List;

public interface BookSearchService {
    List<Book> findByKeyword(String keyword);
}
