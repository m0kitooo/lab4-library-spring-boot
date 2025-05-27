package com.mokitooo.service;

import com.mokitooo.dto.BookDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(Book::toBookDto)
                .toList();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findAll()
                .stream()
                .filter(b -> b.matchesTitle(title))
                .toList();
    }

    @Override
    public List<BookDto> findByKeyword(String keyword) {
        return bookRepository.findAll()
                .stream()
                .filter(b -> b.titleContains(keyword))
                .map(Book::toBookDto)
                .toList();
    }
}
