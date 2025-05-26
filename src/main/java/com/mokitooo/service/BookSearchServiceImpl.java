package com.mokitooo.service;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {
    private final BookRepositoryImpl bookRepositoryImpl;

    @Override
    public List<Book> findByKeyword(String keyword) {
        return bookRepositoryImpl.findAll()
                .stream()
                .filter(b -> b.titleContains(keyword))
                .toList();
    }
}
