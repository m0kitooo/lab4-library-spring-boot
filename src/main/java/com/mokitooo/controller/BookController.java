package com.mokitooo.controller;

import com.mokitooo.dto.BookDto;
import com.mokitooo.service.BookSearchService;
import com.mokitooo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController("/books")
public class BookController {
    private final BookService bookService;
    private final BookSearchService bookSearchService;

    @GetMapping
    public List<BookDto> getBooks() {
        return bookSearchService.findAll();
    }
}
