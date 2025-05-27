package com.mokitooo.controller;

import com.mokitooo.dto.BookDto;
import com.mokitooo.dto.CreateBookDto;
import com.mokitooo.service.BookSearchService;
import com.mokitooo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookSearchService bookSearchService;

    @GetMapping
    public List<BookDto> getBooks(@RequestParam(defaultValue = "") String title) {
        return bookSearchService.findByKeyword(title);
    }

    @PostMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody CreateBookDto createBookDto) {
        return new ResponseEntity<>(bookService.registerBook(createBookDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBook(@RequestBody String title) {
        if (bookService.deleteBook(title) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }
}
