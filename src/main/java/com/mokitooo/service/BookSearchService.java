package com.mokitooo.service;

import com.mokitooo.dto.BookDto;

import java.util.List;

public interface BookSearchService {
    List<BookDto> findAll();
    List<BookDto> findByTitle(String title);
    List<BookDto> findByKeyword(String keyword);
}
