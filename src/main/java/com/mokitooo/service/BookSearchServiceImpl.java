package com.mokitooo.service;

import com.mokitooo.model.book.Book;
import com.mokitooo.repository.BookRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {
    private final BookRepositoryAsyncImpl bookRepositoryAsyncImpl;

    @Override
    public List<Book> findByKeyword(String keyword) {
        return bookRepositoryAsyncImpl.findAll()
                .stream()
                .filter(b -> b.titleContains(keyword))
                .toList();
    }
}
