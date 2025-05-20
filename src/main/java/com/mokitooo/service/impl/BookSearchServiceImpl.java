package com.mokitooo.service.impl;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepository;
import com.mokitooo.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findByKeyword(String keyword) {
        return bookRepository.findAll()
                .stream()
                .filter(b -> b.titleContains(keyword))
                .toList();
    }
}
